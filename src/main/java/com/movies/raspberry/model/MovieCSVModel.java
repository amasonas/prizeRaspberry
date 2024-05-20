package com.movies.raspberry.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieCSVModel {
    @CsvBindByName()
    private int year;
    @CsvBindByName
    private String title;
    @CsvBindByName
    private String Studios;
    @CsvBindByName
    private String producers;
    @CsvBindByName(required = false)
    private String winner;

}
