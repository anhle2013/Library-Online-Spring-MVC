package com.cg.service.publisher;

import com.cg.model.Publisher;
import com.cg.model.dto.PublisherDTO;
import com.cg.repository.IPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherService implements IPublisherService{
    @Autowired
    private IPublisherRepository publisherRepository;

    @Override
    public Iterable<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<PublisherDTO> findAllDTO() {
        return publisherRepository.findAllDTO();
    }

    @Override
    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Iterable<Publisher> findAllByNameContainingIgnoreCase(String name) {
        return publisherRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Publisher> findAllByName(String name) {
        return publisherRepository.findAllByName(name);
    }

    @Override
    public Publisher getById(Long id) {
        return null;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

}
