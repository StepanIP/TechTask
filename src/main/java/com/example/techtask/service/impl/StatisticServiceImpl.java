package com.example.techtask.service.impl;

import com.example.techtask.model.SalesAndTrafficByAsin;
import com.example.techtask.model.SalesAndTrafficByDate;
import com.example.techtask.model.Statistic;
import com.example.techtask.repository.StatisticRepository;
import com.example.techtask.service.StatisticService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    StatisticRepository statisticRepository;

    @Override
    public SalesAndTrafficByDate getStatisticsByDate(String date) {
        return statisticRepository.findByDate(date);
    }

    @Override
    public SalesAndTrafficByAsin getStatisticsByAsin(String asin) {
        return statisticRepository.findByAsin(asin);
    }

    @Override
    public SalesAndTrafficByDate getTotalStatisticsByDate() {
        return statisticRepository.getAllByDate();
    }

    @Override
    public SalesAndTrafficByAsin getTotalStatisticsByAsin() {
        return statisticRepository.getAllByAsin();
    }

    @Override
    @Cacheable(value = "updateStatisticsCache")
    public void updateStatisticsFromJsonFile() {
        try {
            String filePath = "src/main/resources/test_report.json";
            Path path = Paths.get(filePath);
            ObjectMapper objectMapper = new ObjectMapper();
            Statistic statistics = objectMapper.readValue(path.toFile(), Statistic.class);

            String existingId = "65df6f2e89976fc0db6665be";

            statistics.setId(existingId);

            statisticRepository.save(statistics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @CacheEvict(value = "updateStatisticsCache", allEntries = true)
    public void clearUpdateStatisticsCache() {
    }

}
