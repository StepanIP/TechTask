package com.example.techtask.service;


import com.example.techtask.model.SalesAndTrafficByAsin;
import com.example.techtask.model.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

public interface StatisticService {
    SalesAndTrafficByDate getStatisticsByDate(String date);

    SalesAndTrafficByAsin getStatisticsByAsin(String asin);

    SalesAndTrafficByDate getTotalStatisticsByDate();

    SalesAndTrafficByAsin getTotalStatisticsByAsin();

    void updateStatisticsFromJsonFile();

    void clearUpdateStatisticsCache();
}
