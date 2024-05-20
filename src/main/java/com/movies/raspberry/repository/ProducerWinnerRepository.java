package com.movies.raspberry.repository;

import com.movies.raspberry.entity.ProducerWinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerWinnerRepository extends JpaRepository<ProducerWinner, Long> {
    @Query(value = "SELECT * FROM ( SELECT ROW_NUMBER() OVER (ORDER BY \"interval\") AS row_num, * FROM \"producer_winner\" where \"interval\" is not null) AS ranked_intervals WHERE row_num <= 2;", nativeQuery = true)
    List<ProducerWinner> getProducersPrizeMinIntervals();

    @Query(value = "SELECT * FROM ( SELECT ROW_NUMBER() OVER (ORDER BY \"interval\" ) AS row_num, * FROM \"producer_winner\" where \"interval\" is not null) AS ranked_intervals WHERE row_num <= 2  order by \"interval\" DESC;", nativeQuery = true)
    List<ProducerWinner> getProducersPrizeMaxIntervals();
}
