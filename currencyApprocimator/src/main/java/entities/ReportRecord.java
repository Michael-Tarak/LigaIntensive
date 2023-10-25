package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReportRecord {
    private final int nominal;
    private final LocalDate date;
    private final BigDecimal rate;
    private final String currency;

    ReportRecord (int nominal, LocalDate date, double rate, String currency) {
        this.nominal = nominal;
        this.date = date;
        this.rate = BigDecimal.valueOf(rate);
        this.currency = currency;
    }

    public int getNominal () {
        return nominal;
    }

    public LocalDate getDate () {
        return date;
    }

    public BigDecimal getRate () {
        return rate;
    }

    public String getCurrencyType () {
        return currency;
    }

}
