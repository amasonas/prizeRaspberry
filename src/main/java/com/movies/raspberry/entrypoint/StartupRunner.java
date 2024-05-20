package com.movies.raspberry.entrypoint;

import com.movies.raspberry.entity.Producer;
import com.movies.raspberry.entity.Studio;
import com.movies.raspberry.factory.MovieFactory;
import com.movies.raspberry.model.MovieCSVModel;
import com.movies.raspberry.model.MovieModel;
import com.movies.raspberry.service.CsvLoadService;
import com.movies.raspberry.service.MovieService;
import com.movies.raspberry.service.ProducerService;
import com.movies.raspberry.service.StudioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class StartupRunner implements ApplicationRunner {

    @Autowired
    private CsvLoadService loadService;
    @Autowired
    private MovieFactory movieModelFactory;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ProducerService producerService;
    @Autowired
    private StudioService studioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            log.info("starting csvReader");
            List<MovieCSVModel> csvData = loadService.readCsv();
            log.info("Converting to Model");
            List<MovieModel> modelList = movieModelFactory.toListModel(csvData);
            log.info("Recording data");
            modelList.forEach(this::persistMovie);
            log.info("Data load finished");
        } catch (Exception e) {
            log.error("Error on load csv data");
        }
    }

    private void persistMovie(MovieModel model) {
        model.getStudios().forEach(studioModel -> {
            Studio studio = studioService.findOrCreateByName(studioModel.getName());
            studioModel.setId(studio.getId());
        });

        model.getProducers().forEach(producerModel -> {
            Producer producer = producerService.findOrCreateByName(producerModel.getName());
            producerModel.setId(producer.getId());
        });

        movieService.save(model);
    }


}
