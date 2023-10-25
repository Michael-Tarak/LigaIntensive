package services;

import entities.ReportRecord;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class CalculateFutureCurrencyService {
    private final double DAYS_WEEK = 7;

    BigDecimal calculateAverageFromWeek (List<ReportRecord> weekReportRecords) {

        BigDecimal rateSum = new BigDecimal(0);
        for (ReportRecord record : weekReportRecords) {
            rateSum = rateSum.add(record.getRate());
        }
        return rateSum.divide(BigDecimal.valueOf(DAYS_WEEK), MathContext.DECIMAL32);
    }
}
