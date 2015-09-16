package com.tom.entity;

import lombok.Getter;

/**
 * Created by Tom on 9-9-2015.
 */
@Getter
public enum EType {
    MOVIE("movie"),
    SERIES("series"),
    EPISODE("episode");

    private String desc;

    private EType(String desc){
        this.desc = desc;
    }
}
