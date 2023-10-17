package org.example;

import org.example.entities.CurrencyType;
import org.example.entities.RateCalculationView;
import org.example.entities.RatePeriod;
import org.example.entities.ReportRecordEntity;
import org.example.services.RateService;

import java.util.List;

public class CurrencyAnalyzer {
    public static void rateCurrency (String currencyType, String ratePeriod) {
        try {
            CurrencyType currencyForRating = CurrencyType.valueOf(currencyType.toUpperCase());
            RatePeriod currencyRatePeriod = RatePeriod.valueOf(ratePeriod.toUpperCase());

            List<RateCalculationView> rateCalculations = RateService.getCurrencyStatistic(currencyForRating,currencyRatePeriod);
            for (RateCalculationView rcv : rateCalculations) {
                System.out.println(rcv.getRateCalculationLine());
            }


        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
