package com.movies.raspberry.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProducerWinnerModel {
    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;
}
