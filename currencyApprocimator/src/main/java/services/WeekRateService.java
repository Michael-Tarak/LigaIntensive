package services;

import entities.Report;
import entities.ReportRecordEntity;
import enums.CurrencyType;
import models.RateCalculation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeekRateService implements RateService {
    private final int DAYS_WEEK = 7;
    public List<RateCalculation> getCurrencyStatistic(CurrencyType currencyType) {
        Report reportEntity = new Report(currencyType);
        List<ReportRecordEntity> report = reportEntity.getReportRecords();
        report.sort(Comparator.comparing(ReportRecordEntity::getDate, Comparator.reverseOrder()));
        List<RateCalculation> rateCalculations = new ArrayList<>();
        for (int i = 0; i < DAYS_WEEK; i++) {
            List<ReportRecordEntity> analysisForDay = report.subList(i, DAYS_WEEK + i);

            rateCalculations.add(new RateCalculation(report.get(i).getDate().plusDays(1),
                    new CalculateFutureCurrencyService().calculateAverageFromWeek(analysisForDay)));
        }
        return rateCalculations;
    }
}
