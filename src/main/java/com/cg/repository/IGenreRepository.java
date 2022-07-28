package com.cg.repository;

import com.cg.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface IGenreRepository extends CrudRepository<Genre, Long> {
}
