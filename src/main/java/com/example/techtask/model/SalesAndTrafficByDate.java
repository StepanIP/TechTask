package com.example.techtask.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SalesAndTrafficByDate {

    private List<DateData> salesAndTrafficByDate;

    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class DateData {
        private String date;
        private SalesByDate salesByDate;
        private TrafficByDate trafficByDate;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class SalesByDate {
        private ProductSales orderedProductSales;
        private ProductSales orderedProductSalesB2B;
        private int unitsOrdered;
        private int unitsOrderedB2B;
        private int totalOrderItems;
        private int totalOrderItemsB2B;
        private AverageSales averageSalesPerOrderItem;
        private AverageSales averageSalesPerOrderItemB2B;
        private double averageUnitsPerOrderItem;
        private double averageUnitsPerOrderItemB2B;
        private AverageSales averageSellingPrice;
        private AverageSales averageSellingPriceB2B;
        private int unitsRefunded;
        private double refundRate;
        private int claimsGranted;
        private ProductSales claimsAmount;
        private ProductSales shippedProductSales;
        private int unitsShipped;
        private int ordersShipped;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class TrafficByDate {
        private int browserPageViews;
        private int browserPageViewsB2B;
        private int mobileAppPageViews;
        private int mobileAppPageViewsB2B;
        private int pageViews;
        private int pageViewsB2B;
        private int browserSessions;
        private int browserSessionsB2B;
        private int mobileAppSessions;
        private int mobileAppSessionsB2B;
        private int sessions;
        private int sessionsB2B;
        private double buyBoxPercentage;
        private double buyBoxPercentageB2B;
        private double orderItemSessionPercentage;
        private double orderItemSessionPercentageB2B;
        private double unitSessionPercentage;
        private double unitSessionPercentageB2B;
        private int averageOfferCount;
        private int averageParentItems;
        private int feedbackReceived;
        private int negativeFeedbackReceived;
        private double receivedNegativeFeedbackRate;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class AverageSales {
        private double amount;
        private String currencyCode;
    }
}
