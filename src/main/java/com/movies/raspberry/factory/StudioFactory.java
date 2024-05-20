package com.movies.raspberry.factory;

import com.movies.raspberry.entity.Studio;
import com.movies.raspberry.model.StudioModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudioFactory {

    public List<StudioModel> fromCsv(String rawStudios) {
        return Arrays.stream(rawStudios.split(","))
                .map(studio -> {
                    return StudioModel.builder().name(studio.toUpperCase().trim()).build();
                })
                .collect(Collectors.toList());
    }

    public Studio fromModel(StudioModel model) {
        return Studio.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
