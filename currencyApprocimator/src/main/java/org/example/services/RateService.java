package org.example.services;

import org.example.entities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RateService {
    public static List<RateCalculationView> getCurrencyStatistic (CurrencyType currencyType, RatePeriod ratePeriod) {
        ReportEntity reportEntity = new ReportEntity(currencyType);
        switch (ratePeriod) {

            case WEEK -> {
                List<ReportRecordEntity> report = reportEntity.getReportRecords();
                report.sort(Comparator.comparing(ReportRecordEntity::getDate,Comparator.reverseOrder()));
                List<RateCalculationView> calculationViews = new ArrayList<>();
                for (int i = 0; i < 7; i++) {
                    List<ReportRecordEntity> analysisForDay = report.subList(i, 7 + i);


                    calculationViews.add(new RateCalculationView(report.get(0).getDate().plusDays(1),
                            calculateApprocimateRate(analysisForDay)));
                }
                return calculationViews;

            }
            case TOMORROW -> {
                List<ReportRecordEntity> report = reportEntity.getReportRecords();
                report.sort(Comparator.comparing(ReportRecordEntity::getDate,Comparator.reverseOrder()));
                List<ReportRecordEntity> analysisForDay = report.subList(0,7);
                List<RateCalculationView> calculationViews = new ArrayList<>();

                calculationViews.add(new RateCalculationView(report.get(0).getDate().plusDays(1),
                        calculateApprocimateRate(analysisForDay)));
                return calculationViews;

            }
            default -> throw new RuntimeException();
        }

    }

    static double calculateApprocimateRate(List<ReportRecordEntity> list) {
        double rateSum = 0;
        for (ReportRecordEntity record : list) {
            rateSum += record.getRate();
        }
        return rateSum / (double) list.size();
    }

}
