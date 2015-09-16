package com.tom.service;

import com.tom.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tom on 8-9-2015.
 */
public interface PersonService {
    List<Person> findAll();
    Person findById(UUID id);
    Person save(Person person);
    void delete(Person person);
    Page<Person> findAllByPage(Pageable pageable);
}
