package com.example.techtask.service.impl;

import com.example.techtask.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Autowired
    private StatisticService statisticService;

    @Scheduled(initialDelay = 6000, fixedRate = 6000)
    public void updateStatistics() {
        statisticService.updateStatisticsFromJsonFile();
        System.out.println("updated");
    }

    @Scheduled(initialDelay = 1800000, fixedRate = 1800000)
    public void clearStatistics() {
        statisticService.clearUpdateStatisticsCache();
    }
}
