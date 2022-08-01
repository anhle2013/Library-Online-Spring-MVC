package com.cg.service.callCardDetail;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CallCardDetail implements ICallCardDetail{
    @Override
    public Iterable<com.cg.model.CallCardDetail> findAll() {
        return null;
    }

    @Override
    public Iterable<com.cg.model.CallCardDetail> findAllByNameContainingIgnoreCase(String name) {
        return null;
    }

    @Override
    public Optional<com.cg.model.CallCardDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public com.cg.model.CallCardDetail getById(Long id) {
        return null;
    }

    @Override
    public com.cg.model.CallCardDetail save(com.cg.model.CallCardDetail callCardDetail) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
