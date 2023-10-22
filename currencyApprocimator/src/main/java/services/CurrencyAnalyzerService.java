package services;

import enums.CurrencyType;
import models.RateCalculation;
import views.RateCalculationView;
import enums.RatePeriod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrencyAnalyzerService {
    List<RateCalculation> rateCalculations;
    public void findFutureRateOfCurrency(String currencyType, String ratePeriod) {
        try {
            String [] currencyTypes = Arrays.toString(CurrencyType.values()).replaceAll("^.|.$", "").
                    replaceAll(" ", "").split(",");
            boolean isValidCurrencyType = false;
            for (String ct : currencyTypes) {
                if (ct.equals(currencyType.toUpperCase())) {
                    isValidCurrencyType = true;
                    break;
                }
            }
            if (!isValidCurrencyType) {
                throw new IllegalArgumentException("Invalid currency type!");
            }
            String [] ratePeriods = Arrays.toString(RatePeriod.values()).replaceAll("^.|.$", "").
                    replaceAll(" ", "").split(",");
            boolean isValidRatePeriod = false;
            for (String rp : ratePeriods) {
                if (rp.equals(ratePeriod.toUpperCase())) {
                    isValidRatePeriod = true;
                    break;
                }
            }
            if (!isValidRatePeriod) {
                throw new IllegalArgumentException("Invalid rate period!");
            }

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
