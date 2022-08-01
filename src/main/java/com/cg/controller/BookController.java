package com.cg.controller;

import com.cg.model.*;
import com.cg.service.author.IAuthorService;
import com.cg.service.book.IBookService;
import com.cg.service.genre.IGenreService;
import com.cg.service.publisher.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("callCard")
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private IGenreService genreService;

    @Autowired
    private IPublisherService publisherService;


    @ModelAttribute("callCard")
    public CallCard setupCart() {
        return new CallCard();
    }
    
    private Iterable<Book> books = new ArrayList<>();
    private Iterable<Author> authors = new ArrayList<>();
    private Iterable<Genre> genres = new ArrayList<>();
    private Iterable<Publisher> publishers = new ArrayList<>();

    @GetMapping
    public ModelAndView showBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/list");
        books = bookService.findAllByActive(true);
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/create");
        authors = authorService.findAll();
        genres = genreService.findAll();
        publishers = publisherService.findAll();

        modelAndView.addObject("book", new Book());
        modelAndView.addObject("authors", authors);
        modelAndView.addObject("genres", genres);
        modelAndView.addObject("publishers", publishers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showSelectPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/select");
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent())
            modelAndView.addObject("book", optionalBook.get());
        else
            modelAndView.addObject("error", "Book Id NOT EXIST");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/edit");
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent()) {
            authors = authorService.findAll();
            genres = genreService.findAll();
            publishers = publisherService.findAll();
            modelAndView.addObject("book", optionalBook.get());
            modelAndView.addObject("authors", authors);
            modelAndView.addObject("genres", genres);
            modelAndView.addObject("publishers", publishers);
        }
        else
            modelAndView.addObject("error", "Book Id NOT EXIST");
        return modelAndView;
    }

    @GetMapping("/disable/{id}")
    public ModelAndView disableBook(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/select");
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent()) {
            boolean bookIsActive = optionalBook.get().isActive();
            if (bookIsActive) {
                optionalBook.get().setActive(false);
                bookService.save(optionalBook.get());
                modelAndView.addObject("book", optionalBook.get());
            } else
                modelAndView.addObject("error", "This Book already DISABLE now");
        } else
            modelAndView.addObject("error", "Book Id NOT EXIST");
        return modelAndView;
    }

    @GetMapping("/reActive/{id}")
    public ModelAndView reActiveBook(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/select");
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent()) {
            boolean bookIsActive = optionalBook.get().isActive();
            if (!bookIsActive) {
                optionalBook.get().setActive(true);
                bookService.save(optionalBook.get());
                modelAndView.addObject("book", optionalBook.get());
            } else
                modelAndView.addObject("error", "This Book already ACTIVE now");
        } else
            modelAndView.addObject("error", "Book Id NOT EXIST");
        return modelAndView;
    }

//    @GetMapping("/addToCard/{id}")
//    public ModelAndView addToCard(@PathVariable Long id, @ModelAttribute CallCard callCard) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/admin/books/list");
//        Optional<Book> optionalBook = bookService.findById(id);
//        if (!optionalBook.isPresent()) {
//            modelAndView.addObject("error", "Book Id NOT EXIST");
//            return modelAndView;
//        }
//        else  {
//            callCard.addBook(optionalBook.get());
//            modelAndView.addObject("success", "Added Book (ID = "+ id +") to Call Card");
//            return modelAndView;
//        }
//    }

    @PostMapping("/create")
    public ModelAndView doCreate(@ModelAttribute("book") @Validated Book book, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/create");
        authors = authorService.findAll();
        genres = genreService.findAll();
        publishers = publisherService.findAll();
        modelAndView.addObject("authors", authors);
        modelAndView.addObject("genres", genres);
        modelAndView.addObject("publishers", publishers);

        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }
        String newName = book.getName();
        Author newAuthor = book.getAuthor();
        Genre newGenre = book.getGenre();
        Publisher newPublisher = book.getPublisher();
        Optional<Book> optionalBook = bookService.findByNameAndAuthorAndGenreAndPublisher(newName, newAuthor, newGenre, newPublisher);
        if (optionalBook.isPresent())
            modelAndView.addObject("error", "This book already exist with id: " + optionalBook.get().getId());
        else {
            book.setActive(true);
            book.setAvailable(book.getQuantity());
            bookService.save(book);
            modelAndView.addObject("success", "Created New Book");
        }
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView doUpdate(@PathVariable Long id, @ModelAttribute @Validated Book book, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/edit");
        authors = authorService.findAll();
        genres = genreService.findAll();
        publishers = publisherService.findAll();
        modelAndView.addObject("authors", authors);
        modelAndView.addObject("genres", genres);
        modelAndView.addObject("publishers", publishers);

        Optional<Book> optionalCurrentBook = bookService.findById(id);
        Optional<Author> optionalNewAuthor = authorService.findById(book.getAuthor().getId());
        Optional<Genre> optionalNewGenre = genreService.findById(book.getGenre().getId());
        Optional<Publisher> optionalNewPublisher = publisherService.findById(book.getPublisher().getId());
        if (!optionalCurrentBook.isPresent())
            modelAndView.addObject("error", "Book Id NOT EXIST");
        else if (!optionalNewAuthor.isPresent())
            modelAndView.addObject("error", "Author Id NOT EXIST");
        else if (!optionalNewGenre.isPresent())
            modelAndView.addObject("error", "Genre Id NOT EXIST");
        else if (!optionalNewPublisher.isPresent())
            modelAndView.addObject("error", "Publisher Id NOT EXIST");
        else {
            if (bindingResult.hasFieldErrors()){
                modelAndView.addObject("book", optionalCurrentBook.get());
                return modelAndView;
            }
            Book currentBook = optionalCurrentBook.get();
            Author newAuthor = optionalNewAuthor.get();
            Genre newGenre = optionalNewGenre.get();
            Publisher newPublisher = optionalNewPublisher.get();
            String newName = book.getName();

            book.setAuthor(newAuthor);
            book.setGenre(newGenre);
            book.setPublisher(newPublisher);
            book.setActive(currentBook.isActive());
            book.setAvailable(currentBook.getAvailable());
            book.setQuantity(currentBook.getQuantity());
            book.setCreatedAt(currentBook.getCreatedAt());
            book.setCreatedBy(currentBook.getCreatedBy());

            Optional<Book> optionalCheckBook = bookService.findByNameAndAuthorAndGenreAndPublisher(newName, newAuthor, newGenre, newPublisher);
            if (optionalCheckBook.isPresent())
                modelAndView.addObject("error", "This book already exist with id: " + optionalCheckBook.get().getId());
            else {
                bookService.save(book);
                modelAndView.addObject("book", book);
                modelAndView.addObject("success", "Updated book successful");
            }
        }
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView doSearch(@RequestParam("field_name") String field_name, @RequestParam("q") Optional<String> q) {
        ModelAndView modelAndView = new ModelAndView("/admin/books/search");
        if (field_name.equals("disable")) {
            books = bookService.findAllByActive(false);
            modelAndView.addObject("books", books);
            modelAndView.addObject("success", "Search by Disable Book");
            return modelAndView;
        }

        List<Book> bookList = new ArrayList<>();
        String searchKey = "";
        if (q.isPresent())
            searchKey = q.get().trim().replaceAll("\\s+", " ");
        int firstIndex = searchKey.indexOf("'");
        int lastIndex = searchKey.lastIndexOf("'");
        switch (field_name) {
            case "b.name":
                books = bookService.findAllByNameContainingIgnoreCase(searchKey);
                modelAndView.addObject("success", "Search by Book Name like: '" + searchKey + "'");
                modelAndView.addObject("books", books);
                break;
            case "a.name":
                authors = authorService.findAllByNameContainingIgnoreCase(searchKey);
                for (Author author: authors) {
                    books = bookService.findByAuthor(author);
                    books.forEach(bookList::add);
                }
                modelAndView.addObject("books", bookList);
                modelAndView.addObject("success", "Search by Author Name like: '" + searchKey + "'");
                break;
            case "g.name":
                genres = genreService.findAllByNameContainingIgnoreCase(searchKey);
                for (Genre genre: genres) {
                    books = bookService.findByGenre(genre);
                    books.forEach(bookList::add);
                }
                modelAndView.addObject("books", bookList);
                modelAndView.addObject("success", "Search by Genre Name like: '" + searchKey + "'");
                break;
            case "p.name":
                publishers = publisherService.findAllByNameContainingIgnoreCase(searchKey);
                for (Publisher publisher : publishers) {
                    books = bookService.findByPublisher(publisher);
                    books.forEach(bookList::add);
                }
                modelAndView.addObject("books", bookList);
                modelAndView.addObject("success", "Search by Publisher Name like: '" + searchKey + "'");
                break;
            default:
                modelAndView.addObject("error", "Field search NOT available");
        }

        return modelAndView;
    }

//    @GetMapping("/search")
//    public ModelAndView showSearchPage(){
//        ModelAndView modelAndView = new ModelAndView("/admin/books/search");
//        return modelAndView;
//    }


}
