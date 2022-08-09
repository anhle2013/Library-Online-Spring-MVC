package com.cg.repository;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.dto.AuthorDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAuthorRepository extends CrudRepository<Author, Long> {
    @Query("SELECT new com.cg.model.dto.AuthorDTO (" +
            "a.id, " +
            "a.name " +
            ") " +
            "FROM Author AS a"
    )
    List<AuthorDTO> findAllDTO();
    Iterable<Author> findAllByNameContainingIgnoreCase(String name);

    Iterable<Author> findAllByName(String name);
}
