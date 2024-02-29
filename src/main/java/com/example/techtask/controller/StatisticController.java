package com.example.techtask.controller;

import com.example.techtask.model.SalesAndTrafficByAsin;
import com.example.techtask.model.SalesAndTrafficByDate;
import com.example.techtask.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/statistics")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/by-date")
    public ResponseEntity<SalesAndTrafficByDate> getStatisticsByDate(
            @RequestParam(name = "date") String date) {
        SalesAndTrafficByDate result = statisticService.getStatisticsByDate(date);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/by-asin")
    public ResponseEntity<SalesAndTrafficByAsin> getStatisticsByAsin(
            @RequestParam(name = "asin") String asin) {
        SalesAndTrafficByAsin result = statisticService.getStatisticsByAsin(asin);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/total-by-date")
    public ResponseEntity<SalesAndTrafficByDate> getTotalStatisticsByDate() {
        SalesAndTrafficByDate result = statisticService.getTotalStatisticsByDate();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/total-by-asin")
    public ResponseEntity<SalesAndTrafficByAsin> getTotalStatisticsByAsin() {
        SalesAndTrafficByAsin result = statisticService.getTotalStatisticsByAsin();
        return ResponseEntity.ok(result);
    }
}
