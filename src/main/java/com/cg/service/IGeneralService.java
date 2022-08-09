package com.cg.service;

import java.util.Optional;

public interface IGeneralService<T> {

    Iterable<T> findAll();

    Iterable<T> findAllByNameContainingIgnoreCase(String name);

    Iterable<T> findAllByName(String name);

    Optional<T> findById(Long id);

    T getById(Long id);

    T save(T t);

    void remove(Long id);

}
