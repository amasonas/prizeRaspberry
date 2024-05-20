package com.movies.raspberry.entrypoint.controller;

import com.movies.raspberry.entity.ProducerWinner;
import com.movies.raspberry.model.ProducerPrizeInterval;
import com.movies.raspberry.service.ProducerWinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
public class ProducerWinnerController {

    @Autowired
    private ProducerWinnerService service;

    @GetMapping("prize-intervals")
    public ResponseEntity<ProducerPrizeInterval> getProducersPrizeIntervals() {
        return ResponseEntity.ok(service.getProducersPrizeIntervals());
    }

}
