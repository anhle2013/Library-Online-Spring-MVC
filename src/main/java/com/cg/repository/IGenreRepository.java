package com.cg.repository;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.Genre;
import com.cg.model.dto.AuthorDTO;
import com.cg.model.dto.GenreDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGenreRepository extends CrudRepository<Genre, Long> {
    @Query("SELECT new com.cg.model.dto.GenreDTO (" +
            "g.id, " +
            "g.name " +
            ") " +
            "FROM Genre AS g"
    )
    List<GenreDTO> findAllDTO();
    Iterable<Genre> findAllByNameContainingIgnoreCase(String name);

    Iterable<Genre> findAllByName(String name);
}
