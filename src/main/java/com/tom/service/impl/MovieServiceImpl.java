package com.tom.service.impl;

import com.google.common.collect.Lists;
import com.tom.entity.Movie;
import com.tom.repository.MovieRepository;
import com.tom.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tom on 7-9-2015.
 */
@Service("movieService")
@Repository
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return Lists.newArrayList(movieRepository.findAll(sort));
    }

    @Override
    public Movie findById(UUID id) {
        return movieRepository.findOne(id);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    public Page<Movie> findAllByPage(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
}
