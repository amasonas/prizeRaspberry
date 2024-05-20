package com.movies.raspberry.service.impl;

import com.movies.raspberry.entity.ProducerWinner;
import com.movies.raspberry.factory.ProducerPrizeIntervalFactory;
import com.movies.raspberry.model.ProducerPrizeInterval;
import com.movies.raspberry.repository.ProducerWinnerRepository;
import com.movies.raspberry.service.ProducerWinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerWinnerServiceImpl implements ProducerWinnerService {
    @Autowired
    private ProducerWinnerRepository repository;

    @Autowired
    private ProducerPrizeIntervalFactory producerPrizeIntervalFactory;

    @Override
    public ProducerPrizeInterval getProducersPrizeIntervals() {
        List<ProducerWinner> maxInterval = repository.getProducersPrizeMaxIntervals();
        List<ProducerWinner> minInterval = repository.getProducersPrizeMinIntervals();


        return producerPrizeIntervalFactory.buildModel(maxInterval, minInterval);
    }
}
