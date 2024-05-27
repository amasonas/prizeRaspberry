package com.movies.raspberry.repository;

import com.movies.raspberry.entity.ProducerWinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerWinnerRepository extends JpaRepository<ProducerWinner, Long> {
    @Query(value = "select * from( SELECT ROW_NUMBER() OVER ( ORDER BY \"interval\" ASC ) AS row_num, * FROM \"producer_winner\" where \"interval\" is not null order by \"interval\" ASC ) AS ranked_intervals where \"ROW_NUM\" = 1;", nativeQuery = true)
    List<ProducerWinner> getProducersPrizeMinIntervals();

    @Query(value = "select * from( SELECT ROW_NUMBER() OVER ( ORDER BY \"interval\" DESC ) AS row_num, * FROM \"producer_winner\" where \"interval\" is not null order by \"interval\" DESC ) AS ranked_intervals where \"ROW_NUM\" = 1;", nativeQuery = true)
    List<ProducerWinner> getProducersPrizeMaxIntervals();
}
