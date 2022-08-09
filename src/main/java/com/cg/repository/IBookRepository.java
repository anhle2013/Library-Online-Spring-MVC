package com.cg.repository;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.Genre;
import com.cg.model.Publisher;
import com.cg.model.dto.BookDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends PagingAndSortingRepository<Book, Long> {
//
//    @Query(value = "" +
//            "SELECT new com.cg.model.dto.BookDTO (" +
//                "b.id, " +
//                "b.name, " +
//                "b.author, " +
//                "b.genre, " +
//                "b.publisher, " +
//                "b.quantity, " +
//                "b.available, " +
//                "b.active " +
//                ") " +
//            "FROM Book AS b " +
//            "WHERE b.active = true"
//    )
//    List<BookDTO> findAllBookDTO();
    Iterable<Book> findAllByActive(boolean active);

    Iterable<Book> findAllByNameContainingIgnoreCase(String name);

    Iterable<Book> findAllByName(String name);

    Iterable<Book> findByAuthor(Author author);

    Iterable<Book> findByGenre(Genre genre);

    Iterable<Book> findByPublisher(Publisher publisher);

    Optional<Book> findByNameAndAuthorAndGenreAndPublisher(String name, Author author, Genre genre, Publisher publisher);
}
