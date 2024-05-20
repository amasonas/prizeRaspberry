package com.movies.raspberry.service.impl;

import com.movies.raspberry.entity.Movie;
import com.movies.raspberry.factory.MovieFactory;
import com.movies.raspberry.model.MovieModel;
import com.movies.raspberry.repository.MovieRepository;
import com.movies.raspberry.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository repository;
    @Autowired
    private MovieFactory factory;

    @Override
    public Movie save(MovieModel model) {
        return repository.save(factory.fromModel(model));
    }

}
