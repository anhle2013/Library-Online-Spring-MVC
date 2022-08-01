package com.cg.service.book;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.Genre;
import com.cg.model.Publisher;
import com.cg.model.dto.BookDTO;
import com.cg.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IBookService extends IGeneralService<Book> {
//    List<BookDTO> findAllBookDTO();
    Iterable<Book> findAllByActive(boolean active);
    Iterable<Book> findByAuthor(Author author);

    Iterable<Book> findByGenre(Genre genre);
    Iterable<Book> findByPublisher(Publisher publisher);

    Optional<Book> findByNameAndAuthorAndGenreAndPublisher(String name, Author author, Genre genre, Publisher publisher);
}
