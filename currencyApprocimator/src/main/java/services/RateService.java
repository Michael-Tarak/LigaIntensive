package services;

import enums.CurrencyType;
import models.RateCalculation;

import java.util.List;

interface RateService {
    public  List<RateCalculation> getCurrencyStatistic (CurrencyType currencyType);

}

