package com.movies.raspberry.factory;

import com.movies.raspberry.entity.Producer;
import com.movies.raspberry.model.ProducerModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerFactory {
    public List<ProducerModel> fromCsv(String rawStudios) {
        return Arrays.stream(rawStudios.split(","))
                .map(studio -> {
                    return ProducerModel.builder().name(studio.toUpperCase().trim()).build();
                })
                .collect(Collectors.toList());
    }

    public Producer fromModel(ProducerModel model) {
        return Producer.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
