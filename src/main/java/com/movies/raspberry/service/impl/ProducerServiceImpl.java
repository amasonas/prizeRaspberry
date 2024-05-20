package com.movies.raspberry.service.impl;

import com.movies.raspberry.entity.Producer;
import com.movies.raspberry.factory.ProducerFactory;
import com.movies.raspberry.model.ProducerModel;
import com.movies.raspberry.repository.ProducerRepository;
import com.movies.raspberry.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository repository;
    @Autowired
    private ProducerFactory factory;

    @Override
    public Producer findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public Producer findOrCreateByName(String name) {
        Producer producer = findByName(name);
        if (isNull(producer)) {
            producer = save(ProducerModel.builder().name(name).build());
        }

        return producer;
    }

    @Override
    public Producer save(ProducerModel producerModel) {
        return repository.save(factory.fromModel(producerModel));
    }

    @Override
    public Producer findByid(long id) {
        return repository.findById(id).orElse(null);
    }
}
