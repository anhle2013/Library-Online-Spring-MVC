package com.cg.service.publisher;

import com.cg.model.Publisher;
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
    public Optional<Publisher> findById(Long id) {
        return Optional.empty();
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
