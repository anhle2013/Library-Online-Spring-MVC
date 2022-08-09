package com.cg.service.callCard;

import com.cg.model.CallCard;
import com.cg.model.User;
import com.cg.repository.ICallCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CallCardService implements ICallCardService{

    @Autowired
    private ICallCardRepository callCardRepository;

    @Override
    public Boolean existsByUserAndActiveIsTrue(User user) {
        return callCardRepository.existsByUserAndActiveIsTrue(user);
    }

    @Override
    public Iterable<CallCard> findAll() {
        return callCardRepository.findAll();
    }

    @Override
    public Optional<CallCard> findByUserAndActiveIsFalse(User user) {
        return callCardRepository.findByUserAndActiveIsFalse(user);
    }

    @Override
    public CallCard getByUserAndActiveIsFalse(Long userId) {
        return callCardRepository.getByUserAndActiveIsFalse(userId);
    }

    @Override
    public Iterable<CallCard> findAllByNameContainingIgnoreCase(String name) {
        return null;
    }

    @Override
    public Iterable<CallCard> findAllByName(String name) {
        return null;
    }

    @Override
    public Optional<CallCard> findById(Long id) {
        return callCardRepository.findById(id);
    }

    @Override
    public CallCard getById(Long id) {
        return null;
    }

    @Override
    public CallCard save(CallCard callCard) {
        return callCardRepository.save(callCard);
    }

    @Override
    public void remove(Long id) {

    }
}
