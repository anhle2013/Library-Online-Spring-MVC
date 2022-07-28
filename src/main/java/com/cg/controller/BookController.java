package com.cg.controller;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.Genre;
import com.cg.model.Publisher;
import com.cg.model.dto.BookDTO;
import com.cg.service.author.IAuthorService;
import com.cg.service.book.IBookService;
import com.cg.service.genre.IGenreService;
import com.cg.service.publisher.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
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


    @GetMapping
    public ModelAndView showBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/list");
        List<BookDTO> bookDTOS = bookService.findAllBookDTO();
        modelAndView.addObject("bookDTOS", bookDTOS);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/create");
        Iterable<Author> authorList = authorService.findAll();
        Iterable<Genre> genreList = genreService.findAll();
        Iterable<Publisher> publisherList = publisherService.findAll();
        modelAndView.addObject("bookDTO", new BookDTO());
        modelAndView.addObject("authorList", authorList);
        modelAndView.addObject("genreList", genreList);
        modelAndView.addObject("publisherList", publisherList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showSelectPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/select");
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent())
            modelAndView.addObject("bookDTO", optionalBook.get().toBookDTO());
//        else
//            modelAndView.addObject()
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/edit");
        Optional<Book> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent()) {
            Iterable<Author> authorList = authorService.findAll();
            Iterable<Genre> genreList = genreService.findAll();
            Iterable<Publisher> publisherList = publisherService.findAll();
            modelAndView.addObject("bookDTO", new BookDTO());
            modelAndView.addObject("authorList", authorList);
            modelAndView.addObject("genreList", genreList);
            modelAndView.addObject("publisherList", publisherList);
            modelAndView.addObject("bookDTO", optionalBook.get().toBookDTO());
        }
        else
            modelAndView.addObject("bookDTO", new BookDTO());
        return modelAndView;
    }

//    @PostMapping("/create")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView doCreate(@ModelAttribute BookDTO bookDTO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/create");
        try {
            bookService.save(bookDTO.toBook());
            modelAndView.addObject("success", "Created New Book");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "Bad data");
        }
//
//        Iterable<Author> authorList = authorService.findAll();
//        Iterable<Genre> genreList = genreService.findAll();
//        Iterable<Publisher> publisherList = publisherService.findAll();
//
//        modelAndView.addObject("authorList", authorList);
//        modelAndView.addObject("genreList", genreList);
//        modelAndView.addObject("publisherList", publisherList);


        modelAndView.addObject("bookDTO", new BookDTO());
        modelAndView.addObject("authorList", null);
        modelAndView.addObject("genreList", null);
        modelAndView.addObject("publisherList", null);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView doUpdate(@PathVariable Long id, @ModelAttribute BookDTO bookDTO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/books/edit");
        try {
            bookDTO.setId(id);
            bookService.save(bookDTO.toBook());
            modelAndView.addObject("bookDTO", bookDTO);
            modelAndView.addObject("success", "Updated book successful");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "Bad data");
            modelAndView.addObject("bookDTO", new BookDTO());
        }
        return modelAndView;
    }
}
