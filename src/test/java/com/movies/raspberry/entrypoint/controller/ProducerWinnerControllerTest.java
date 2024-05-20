package com.movies.raspberry.entrypoint.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ProducerWinnerControllerTest {

    @Autowired
    private ProducerWinnerController controller;

    @Test
    public void should_returnProducersPrizeIntervals() {

        var result = controller.getProducersPrizeIntervals();
        var body = result.getBody();

        assertEquals(result.getStatusCode(), HttpStatus.OK);

        assertEquals(6, body.getMin().get(0).getInterval());
        assertEquals(13, body.getMax().get(0).getInterval());

    }
}