package com.cg.service.author;

import com.cg.model.Author;
import com.cg.model.dto.AuthorDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IAuthorService extends IGeneralService<Author> {
    List<AuthorDTO> findAllDTO();
}
