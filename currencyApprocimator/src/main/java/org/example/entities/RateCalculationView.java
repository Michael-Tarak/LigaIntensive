package org.example.entities;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RateCalculationView {
    String dayOfWeek;
    LocalDate date;
    double rate;
    public RateCalculationView(LocalDate date, double rate) {
        this.date = date;
        this.rate = rate;
        switch (date.getDayOfWeek()) {

            case MONDAY -> {
                dayOfWeek = "Пн";
            }
            case TUESDAY -> {
                dayOfWeek = "Вт";
            }
            case WEDNESDAY -> {
                dayOfWeek = "Ср";
            }
            case THURSDAY -> {
                dayOfWeek = "Чт";
            }
            case FRIDAY -> {
                dayOfWeek = "Пт";
            }
            case SATURDAY -> {
                dayOfWeek = "Сб";
            }
            case SUNDAY -> {
                dayOfWeek = "Вс";
            }
        }
    }

    public String getRateCalculationLine() {
        return dayOfWeek + " " + date.toString() + " - " + rate;
    }

}
