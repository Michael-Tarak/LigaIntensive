package services;

import entities.ReportRecordEntity;

import java.math.BigDecimal;
import java.util.List;

public class CalculateFutureCurrencyService {
    private final double DAYS_WEEK = 7;
    BigDecimal calculateAverageFromWeek (List<ReportRecordEntity> list) {

        BigDecimal rateSum = new BigDecimal(0);
        for (ReportRecordEntity record : list) {
            rateSum.add(record.getRate());
        }
        return rateSum.divide(BigDecimal.valueOf(DAYS_WEEK));
    }
}
