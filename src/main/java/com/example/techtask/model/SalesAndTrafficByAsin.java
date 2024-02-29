package com.example.techtask.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SalesAndTrafficByAsin {

    private List<AsinData> salesAndTrafficByAsin;

    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class AsinData {
        private String parentAsin;
        private SalesByAsin salesByAsin;
        private TrafficByAsin trafficByAsin;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class SalesByAsin {
        private int unitsOrdered;
        private int unitsOrderedB2B;
        private ProductSales orderedProductSales;
        private ProductSales orderedProductSalesB2B;
        private int totalOrderItems;
        private int totalOrderItemsB2B;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class TrafficByAsin {

        private int browserSessions;
        private int browserSessionsB2B;
        private int mobileAppSessions;
        private int mobileAppSessionsB2B;
        private int sessions;
        private int sessionsB2B;
        private double browserSessionPercentage;
        private double browserSessionPercentageB2B;
        private double mobileAppSessionPercentage;
        private double mobileAppSessionPercentageB2B;
        private double sessionPercentage;
        private double sessionPercentageB2B;
        private int browserPageViews;
        private int browserPageViewsB2B;
        private int mobileAppPageViews;
        private int mobileAppPageViewsB2B;
        private int pageViews;
        private int pageViewsB2B;
        private double browserPageViewsPercentage;
        private double browserPageViewsPercentageB2B;
        private double mobileAppPageViewsPercentage;
        private double mobileAppPageViewsPercentageB2B;
        private double pageViewsPercentage;
        private double pageViewsPercentageB2B;
        private double buyBoxPercentage;
        private double buyBoxPercentageB2B;
        private double unitSessionPercentage;
        private double unitSessionPercentageB2B;
    }
}