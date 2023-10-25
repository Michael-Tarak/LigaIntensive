package services;

import enums.CurrencyType;
import models.RateCalculation;
import views.RateCalculationView;
import enums.RatePeriod;

import java.util.ArrayList;
import java.util.List;

public class CurrencyAnalyzerService {
    List<RateCalculation> rateCalculations;

    public void predictFutureRateOfCurrency(String currencyType, String ratePeriod) {
        try {
            CurrencyType currencyForRating = CurrencyType.valueOf(currencyType.toUpperCase());
            RatePeriod currencyRatePeriod = RatePeriod.valueOf(ratePeriod.toUpperCase());

            switch (currencyRatePeriod) {
                case WEEK -> {
                    rateCalculations = new WeekRateService().getCurrencyStatistic(currencyForRating);

                }
                case TOMORROW -> {
                    rateCalculations = new TomorrowRateService().getCurrencyStatistic(currencyForRating);
                }
            }
            List <RateCalculationView> rateCalculationsViews = new ArrayList<>();
            for (RateCalculation rc : rateCalculations) {
                rateCalculationsViews.add(new RateCalculationView(rc.getDate(), rc.getRate().doubleValue()));
            }
            for (RateCalculationView rcv : rateCalculationsViews) {
                System.out.println(rcv.getRateCalculationLine());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
