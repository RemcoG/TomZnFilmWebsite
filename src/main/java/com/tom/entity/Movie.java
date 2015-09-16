package com.tom.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.imageio.ImageIO;
import javax.persistence.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Tom on 4-9-2015.
 */
@Entity
@Table(name = "MOVIES")
@Setter
@Getter
@NoArgsConstructor
public class Movie extends DomainObject {
    private static final long serialVersionUID = 1L;

    private String title;
    private String imdbID;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd MM yyyy")
    private DateTime releaseDate;
    private String runtime;

    private String plot;
    private String language;
    private String poster;

    private byte[] img = new byte[2048];

    private int metascore;

    private double imdbRating;

    @ManyToMany
    private Collection<Genre> genres = new ArrayList<Genre>();

    @ManyToMany
    private Collection<Person> directors = new ArrayList<Person>();
    @ManyToMany
    private Collection<Person> actors = new ArrayList<Person>();

    @Transient
    public BufferedImage getImage(){
        return null;
    }

    @Transient
    public void setImage(BufferedImage image){
        WritableRaster bImage = image.getRaster();
        DataBufferByte data   = (DataBufferByte) bImage.getDataBuffer();
        this.img = data.getData();
    }

    @Transient
    public int getYear(){
        return releaseDate.getYear();
    }
}
