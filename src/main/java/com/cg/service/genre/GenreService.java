package com.cg.service.genre;

import com.cg.model.Genre;
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
    public Optional<Genre> findById(Long id) {
        return Optional.empty();
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
