package com.tom.service.impl;

import com.google.common.collect.Lists;
import com.tom.entity.Person;
import com.tom.repository.PersonRepository;
import com.tom.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tom on 8-9-2015.
 */
@Service("personService")
@Repository
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return Lists.newArrayList(personRepository.findAll(sort));
    }

    @Override
    public Person findById(UUID id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public Page<Person> findAllByPage(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
