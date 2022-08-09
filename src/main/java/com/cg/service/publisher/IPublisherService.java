package com.cg.service.publisher;

import com.cg.model.Publisher;
import com.cg.model.dto.AuthorDTO;
import com.cg.model.dto.PublisherDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IPublisherService extends IGeneralService<Publisher> {
    List<PublisherDTO> findAllDTO();
}
