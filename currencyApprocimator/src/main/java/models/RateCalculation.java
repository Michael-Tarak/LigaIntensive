package models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RateCalculation {
    LocalDate date;
    BigDecimal rate;
    public RateCalculation(LocalDate date, BigDecimal rate) {
        this.date = date;
        this.rate = new BigDecimal(rate.doubleValue());
    }

    public LocalDate getDate() {
        return this.date;
    }

    public  BigDecimal getRate () {
        return this.rate;
    }
}
