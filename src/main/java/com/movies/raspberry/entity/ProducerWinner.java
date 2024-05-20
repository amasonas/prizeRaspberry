package com.movies.raspberry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "producer_winner")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProducerWinner {
    @Id
    private Long id;
    private Long movieId;
    private Long producerId;
    private Integer previousWin;
    private Integer followingWin;
    private Integer interval;
}
