package com.tom.controller;

import com.tom.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Author: Tom
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    MovieService movieService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        logger.info("Index");
        return "index";
    }
}
