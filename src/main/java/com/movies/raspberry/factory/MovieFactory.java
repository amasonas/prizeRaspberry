package com.movies.raspberry.factory;

import com.movies.raspberry.entity.Movie;
import com.movies.raspberry.model.MovieCSVModel;
import com.movies.raspberry.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieFactory {

    @Autowired
    private ProducerFactory producerModelFactory;
    @Autowired
    private StudioFactory studioModelFactory;

    public List<MovieModel> toListModel(List<MovieCSVModel> movieCSVModelList) {
        return movieCSVModelList.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public MovieModel toModel(MovieCSVModel csvModel) {

        return MovieModel.builder()
                .title(csvModel.getTitle())
                .year(csvModel.getYear())
                .studios(studioModelFactory.fromCsv(csvModel.getStudios()))
                .producers(producerModelFactory.fromCsv(csvModel.getProducers()))
                .winner(csvModel.getWinner().equalsIgnoreCase("yes"))
                .build();
    }

    public Movie fromModel(MovieModel model) {
        return Movie.builder()
                .id(model.getId())
                .title(model.getTitle())
                .producers(
                        model.getProducers().stream().map(producerModelFactory::fromModel).collect(Collectors.toList())
                )
                .studios(
                        model.getStudios().stream().map(studioModelFactory::fromModel).collect(Collectors.toList())
                )
                .year(model.getYear())
                .winner(model.getWinner())
                .build();
    }
}
