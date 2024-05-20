package com.movies.raspberry.service;

import com.movies.raspberry.entity.Studio;
import com.movies.raspberry.model.StudioModel;

public interface StudioService {

    Studio findByName(String name);

    Studio findOrCreateByName(String name);

    Studio save(StudioModel studioModel);
}
