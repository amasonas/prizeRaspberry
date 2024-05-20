package com.movies.raspberry.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieModel {
    private Long id;
    private int year;
    private String title;
    private Boolean winner;
    private List<StudioModel> studios;
    private List<ProducerModel> producers;
}
