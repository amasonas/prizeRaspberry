package com.movies.raspberry.service;

import com.movies.raspberry.entity.Movie;
import com.movies.raspberry.model.MovieModel;

import java.util.List;

public interface MovieService {

    Movie save(MovieModel model);

}
