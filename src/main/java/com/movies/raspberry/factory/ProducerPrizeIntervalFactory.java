package com.movies.raspberry.factory;

import com.movies.raspberry.entity.Producer;
import com.movies.raspberry.entity.ProducerWinner;
import com.movies.raspberry.model.ProducerPrizeInterval;
import com.movies.raspberry.model.ProducerWinnerModel;
import com.movies.raspberry.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerPrizeIntervalFactory {

    @Autowired
    private ProducerService producerService;

    public ProducerPrizeInterval buildModel(List<ProducerWinner> maxInterval, List<ProducerWinner> minInterval) {
        return ProducerPrizeInterval.builder()
                .max(maxInterval
                        .stream()
                        .map(this::build)
                        .collect(Collectors.toList()))
                .min(minInterval
                        .stream()
                        .map(this::build)
                        .collect(Collectors.toList()))
                .build();
    }

    public ProducerWinnerModel build(ProducerWinner winner) {
        Producer producer = producerService.findByid(winner.getProducerId());

        return ProducerWinnerModel.builder()
                .producer(producer.getName())
                .interval(winner.getInterval())
                .previousWin(winner.getPreviousWin())
                .followingWin(winner.getFollowingWin())
                .build();
    }
}
