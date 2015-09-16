package com.tom.controller;

import com.tom.controller.rs.MovieControllerRs;
import com.tom.entity.EType;
import com.tom.model.MovieModel;
import com.tom.model.SearchMovieModel;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Tom on 9-9-2015.
 */
@Controller
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @RequestMapping(value = "/movie/add", method = RequestMethod.GET)
    public String addMovieForm(Model uiModel){
        logger.info("movie form get");
        uiModel.addAttribute("movieSearch", new SearchMovieModel());
        return "movie/addMovie";
    }

    @RequestMapping(value = "/movie/add", method = RequestMethod.POST)
    public String addMovie(@ModelAttribute SearchMovieModel movie, BindingResult bindingResult,
                           Model uiModel, RedirectAttributes redirectAttributes){
        logger.info("movie form post");
        try {
            movie.setType(EType.MOVIE);
            movie.setReleasedYear("");
            uiModel.addAttribute("movieSearch", movie);
            MovieModel movieModel = MovieControllerRs.getMovie(movie);
            uiModel.addAttribute("movie", movieModel);
        }catch(IOException ioException){
            ioException.printStackTrace();
        }catch(JSONException jsonException){
            jsonException.printStackTrace();
        }
        return "movie/addMovie";
    }

}
