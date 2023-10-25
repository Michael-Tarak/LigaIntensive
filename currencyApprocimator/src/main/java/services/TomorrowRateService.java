package services;

import entities.Report;
import entities.ReportRecord;
import enums.CurrencyType;
import models.RateCalculation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TomorrowRateService implements RateService {
    private final int DAYS_WEEK = 7;

    @Override
    public List<RateCalculation> getCurrencyStatistic(CurrencyType currencyType) {
        Report reportEntity = new Report(currencyType);
        List<ReportRecord> report = reportEntity.getReportRecords();
        report.sort(Comparator.comparing(ReportRecord::getDate, Comparator.reverseOrder()));
        List<ReportRecord> analysisForDay = report.subList(0, DAYS_WEEK);
        List<RateCalculation> rateCalculations = new ArrayList();

        rateCalculations.add(new RateCalculation(report.get(0).getDate().plusDays(1),
                new CalculateFutureCurrencyService().calculateAverageFromWeek(analysisForDay)));
        return rateCalculations;
    }
}
