package com.movies.raspberry.service;

import com.movies.raspberry.model.MovieCSVModel;

import java.io.IOException;
import java.util.List;

public interface CsvLoadService {
    List<MovieCSVModel> readCsv() throws IOException;
}
