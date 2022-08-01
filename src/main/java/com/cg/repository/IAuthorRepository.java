package com.cg.repository;

import com.cg.model.Author;
import com.cg.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> findAllByNameContainingIgnoreCase(String name);
}
