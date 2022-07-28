package com.cg.repository;

import com.cg.model.Book;
import com.cg.model.dto.BookDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IBookRepository extends PagingAndSortingRepository<Book, Long> {

    @Query(value = "" +
            "SELECT new com.cg.model.dto.BookDTO (" +
                "b.id, " +
                "b.name, " +
                "b.author, " +
                "b.genre, " +
                "b.publisher, " +
                "b.quantity, " +
                "b.available, " +
                "b.active " +
                ") " +
            "FROM Book AS b " +
            "WHERE b.active = true"
    )
    List<BookDTO> findAllBookDTO();
}
