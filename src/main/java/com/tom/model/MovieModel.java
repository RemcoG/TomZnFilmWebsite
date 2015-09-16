package com.tom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 9-9-2015.
 */
@Getter
@Setter
@NoArgsConstructor
public class MovieModel {
    private String title;
    private String imdbID;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private DateTime releaseDate;
    private String runtime;
    private String plot;
    private String language;
    private String poster;
    private BufferedImage img;
    private int metascore;
    private double imdbRating;
    private List<String> actors = new ArrayList<String>();
    private List<String> directors = new ArrayList<String>();
    private List<String> genres = new ArrayList<String>();

}
