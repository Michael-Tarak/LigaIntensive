package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ReportDateConverter {
    public static LocalDate convertFromCsvStyleToLocalDate(String date) {
        DateTimeFormatter fmt = new DateTimeFormatterBuilder().appendPattern("dd.MM.yyyy").toFormatter();
        return LocalDate.parse(date, fmt);
    }
}
