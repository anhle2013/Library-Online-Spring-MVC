package com.cg.repository;

import com.cg.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepository extends CrudRepository<Author, Long> {
}
