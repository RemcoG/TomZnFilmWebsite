package com.tom.entity;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Tom on 4-9-2015.
 */
@Entity
@Getter
@Setter
public class Person extends DomainObject {

    private String name;
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    // needed to allow changing a date in the GUI
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private DateTime born;

    @ManyToMany(mappedBy = "directors")
    private Collection<Movie> moviesDirected = new ArrayList<Movie>();

    @ManyToMany(mappedBy = "actors")
    private Collection<Movie> moviesActedIn = new ArrayList<Movie>();
}
