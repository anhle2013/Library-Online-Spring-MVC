package com.cg.service.genre;

import com.cg.model.Genre;
import com.cg.model.dto.AuthorDTO;
import com.cg.model.dto.GenreDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IGenreService extends IGeneralService<Genre> {
    List<GenreDTO> findAllDTO();
}
