package com.tom.service;


import com.tom.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tom on 7-9-2015.
 */
public interface MovieService {
    List<Movie> findAll();
    Movie findById(UUID id);
    Movie save(Movie movie);
    void delete(Movie movie);
    Page<Movie> findAllByPage(Pageable pageable);
}
