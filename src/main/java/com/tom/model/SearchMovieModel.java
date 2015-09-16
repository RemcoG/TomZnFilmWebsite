package com.tom.model;

import com.tom.entity.EType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Tom on 9-9-2015.
 */
@Getter
@Setter
@NoArgsConstructor
public class SearchMovieModel {
    private String title;
    private String releasedYear;
    private EType type;
}
