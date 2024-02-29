package com.example.techtask.repository;

import com.example.techtask.model.SalesAndTrafficByAsin;
import com.example.techtask.model.SalesAndTrafficByDate;
import com.example.techtask.model.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface StatisticRepository extends MongoRepository<Statistic, String> {

    @Query(value = "{ 'salesAndTrafficByDate.date': { $eq: ?0 } }", fields = "{ 'salesAndTrafficByDate.$': 1, '_id': 0 }")
    SalesAndTrafficByDate findByDate(String date);

    @Query(value = "{ 'salesAndTrafficByAsin.parentAsin': ?0 }", fields = "{ 'salesAndTrafficByAsin.$': 1, '_id': 0 }")
    SalesAndTrafficByAsin findByAsin(String parentAsin);

    @Query("[{ $unwind: '$salesAndTrafficByDate' }, { $replaceRoot: { newRoot: '$salesAndTrafficByDate' } }]")
    SalesAndTrafficByDate getAllByDate();

    @Query("[{ $unwind: '$salesAndTrafficByAsin' }, { $replaceRoot: { newRoot: '$salesAndTrafficByAsin' } }]")
    SalesAndTrafficByAsin getAllByAsin();
}
