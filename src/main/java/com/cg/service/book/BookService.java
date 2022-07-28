package com.cg.service.book;

import com.cg.model.Book;
import com.cg.model.dto.BookDTO;
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
        return null;
    }

    @Override
    public List<BookDTO> findAllBookDTO() {
        return bookRepository.findAllBookDTO();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
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
