package com.cg.service.book;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.Genre;
import com.cg.model.Publisher;
import com.cg.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

//    @Override
//    public List<BookDTO> findAllBookDTO() {
////        return null;
//        return bookRepository.findAllBookDTO();
//    }

    @Override
    public Iterable<Book> findAllByActive(boolean active) {
        return bookRepository.findAllByActive(active);
    }

    @Override
    public Iterable<Book> findAllByNameContainingIgnoreCase(String name) {
        return bookRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Book> findAllByName(String name) {
        return bookRepository.findAllByName(name);
    }

    @Override
    public Iterable<Book> findByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public Iterable<Book> findByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public Iterable<Book> findByPublisher(Publisher publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByNameAndAuthorAndGenreAndPublisher(String name, Author author, Genre genre, Publisher publisher) {
        return bookRepository.findByNameAndAuthorAndGenreAndPublisher(name, author, genre, publisher);
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {

    }


}
