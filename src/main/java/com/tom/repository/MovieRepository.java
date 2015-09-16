package com.tom.repository;

import com.tom.entity.Genre;
import com.tom.entity.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tom on 7-9-2015.
 */
public interface MovieRepository extends PagingAndSortingRepository<Movie, UUID> {

    List<Movie> findByGenres(Genre genre);
}
