package org.example.entities;

import java.time.LocalDate;

public class ReportRecordEntity {
    int nominal;
    LocalDate date;
    double rate;
    String currency;

    ReportRecordEntity (String[] line) {
        this.nominal = Integer.parseInt(line[0]);
        this.date = LocalDate.parse(line[1]);
        this.rate = Double.parseDouble(line[2]);
        this.currency = line [3];
    }

    public int getNominal() {
        return nominal;
    }

    public LocalDate getDate () {
        return date;
    }

    public double getRate() {
        return rate;
    }

    public String getCurrencyType() {
        return currency;
    }

}
