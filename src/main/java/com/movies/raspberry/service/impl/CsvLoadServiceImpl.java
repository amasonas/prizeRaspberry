package com.movies.raspberry.service.impl;

import com.movies.raspberry.model.MovieCSVModel;
import com.movies.raspberry.service.CsvLoadService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class CsvLoadServiceImpl implements CsvLoadService {

    @Value("${data.load-csv}")
    private String csvPath;

    public List<MovieCSVModel> readCsv() throws IOException {
        try (Reader reader = new FileReader(csvPath)) {
            CsvToBean<MovieCSVModel> csvToBean = new CsvToBeanBuilder<MovieCSVModel>(reader)
                    .withType(MovieCSVModel.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        }
    }
}
