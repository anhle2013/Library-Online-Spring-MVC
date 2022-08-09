package com.cg.repository;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.Publisher;
import com.cg.model.dto.AuthorDTO;
import com.cg.model.dto.PublisherDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPublisherRepository extends CrudRepository<Publisher, Long> {
    @Query("SELECT new com.cg.model.dto.PublisherDTO (" +
            "p.id, " +
            "p.name " +
            ") " +
            "FROM Publisher AS p"
    )
    List<PublisherDTO> findAllDTO();
    Iterable<Publisher> findAllByNameContainingIgnoreCase(String name);

    Iterable<Publisher> findAllByName(String name);
}
