package com.cg.service.author;

import com.cg.model.Author;
import com.cg.model.dto.AuthorDTO;
import com.cg.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<AuthorDTO> findAllDTO() {
        return authorRepository.findAllDTO();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Iterable<Author> findAllByNameContainingIgnoreCase(String name) {
        return authorRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Author> findAllByName(String name) {
        return authorRepository.findAllByName(name);
    }

    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

}
