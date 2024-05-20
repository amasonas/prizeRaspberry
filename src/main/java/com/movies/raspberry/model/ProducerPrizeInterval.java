package com.movies.raspberry.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProducerPrizeInterval {
    private List<ProducerWinnerModel> min;
    private List<ProducerWinnerModel> max;
}
