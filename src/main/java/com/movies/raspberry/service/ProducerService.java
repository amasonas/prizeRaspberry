package com.movies.raspberry.service;

import com.movies.raspberry.entity.Producer;
import com.movies.raspberry.model.ProducerModel;

public interface ProducerService {
    Producer findByName(String name);

    Producer findOrCreateByName(String name);

    Producer save(ProducerModel producerModel);

    Producer findByid(long id);
}
