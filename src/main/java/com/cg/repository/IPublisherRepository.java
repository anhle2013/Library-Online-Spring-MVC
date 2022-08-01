package com.cg.repository;

import com.cg.model.Book;
import com.cg.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface IPublisherRepository extends CrudRepository<Publisher, Long> {
    Iterable<Publisher> findAllByNameContainingIgnoreCase(String name);
}
