package com.cg.service.genre;

import com.cg.model.Genre;
import com.cg.model.dto.GenreDTO;
import com.cg.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService implements IGenreService{
    @Autowired
    private IGenreRepository genreRepository;

    @Override
    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<GenreDTO> findAllDTO() {
        return genreRepository.findAllDTO();
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public Iterable<Genre> findAllByNameContainingIgnoreCase(String name) {
        return genreRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Genre> findAllByName(String name) {
        return genreRepository.findAllByName(name);
    }

    @Override
    public Genre getById(Long id) {
        return null;
    }

    @Override
    public Genre save(Genre genre) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

}
