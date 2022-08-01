package com.cg.service.callCard;

import com.cg.model.CallCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CallCardService implements ICallCardService{
    @Override
    public Iterable<CallCard> findAll() {
        return null;
    }

    @Override
    public Iterable<CallCard> findAllByNameContainingIgnoreCase(String name) {
        return null;
    }

    @Override
    public Optional<CallCard> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CallCard getById(Long id) {
        return null;
    }

    @Override
    public CallCard save(CallCard callCard) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
