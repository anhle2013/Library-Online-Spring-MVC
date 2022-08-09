package com.cg.service.callCardDetail;

import com.cg.model.Book;
import com.cg.model.CallCard;

import com.cg.model.CallCardDetail;
import com.cg.repository.ICallCardDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CallCardDetailService implements ICallCardDetailService {

    @Autowired
    private ICallCardDetailRepository callCardDetailRepository;

    @Override
    public Optional<CallCardDetail> findByBookAndCallCard(Book book, CallCard callCard) {
        return callCardDetailRepository.findByBookAndCallCard(book, callCard);
    }

    @Override
    public Iterable<CallCardDetail> findAll() {
        return null;
    }

    @Override
    public Iterable<CallCardDetail> findAllByNameContainingIgnoreCase(String name) {
        return null;
    }

    @Override
    public Iterable<CallCardDetail> findAllByName(String name) {
        return null;
    }

    @Override
    public Optional<CallCardDetail> findById(Long id) {
        return callCardDetailRepository.findById(id);
    }

    @Override
    public Iterable<CallCardDetail> findByCallCard(CallCard callCard) {
        return callCardDetailRepository.findByCallCard(callCard);
    }

    @Override
    public CallCardDetail getById(Long id) {
        return null;
    }

    @Override
    public CallCardDetail save(CallCardDetail callCardDetail) {
        return callCardDetailRepository.save(callCardDetail);
    }

    @Override
    public void remove(Long id) {

    }
}
