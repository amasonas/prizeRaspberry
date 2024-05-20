package com.movies.raspberry.service.impl;

import com.movies.raspberry.entity.Studio;
import com.movies.raspberry.factory.StudioFactory;
import com.movies.raspberry.model.StudioModel;
import com.movies.raspberry.repository.StudioRepository;
import com.movies.raspberry.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    private StudioRepository repository;
    @Autowired
    private StudioFactory factory;

    @Override
    public Studio findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public Studio findOrCreateByName(String name) {
        Studio studio = findByName(name);

        if (Objects.isNull(studio)) {
            studio = save(StudioModel.builder().name(name).build());
        }

        return studio;
    }

    @Override
    public Studio save(StudioModel studioModel) {
        return repository.save(factory.fromModel(studioModel));
    }
}
