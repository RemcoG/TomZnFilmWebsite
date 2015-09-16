package com.tom.repository;

import com.tom.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Created by Tom on 8-9-2015.
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, UUID> {
}
