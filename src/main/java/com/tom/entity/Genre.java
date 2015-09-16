package com.tom.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Tom on 4-9-2015.
 */
@Entity
@Getter
@Setter
@Table(name = "GENRES")
public class Genre extends DomainObject{

    private String genre;

    @ManyToMany(mappedBy = "genres")
    private Collection<Movie> movies = new ArrayList<Movie>();

}
