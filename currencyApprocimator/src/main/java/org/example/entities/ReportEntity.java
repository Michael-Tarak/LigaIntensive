package org.example.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportEntity {
    String reportPath;
    List<ReportRecordEntity> reportRecords;

    public ReportEntity(CurrencyType currencyType) {
        switch (currencyType) {

            case USD -> {
                reportPath = "src\\main\\java\\org\\example\\entities\\reports\\usd.csv";
            }
            case EUR -> {
                reportPath = "src\\main\\java\\org\\example\\entities\\reports\\euro.csv";
            }
            case TRY -> {
                reportPath = "src\\main\\java\\org\\example\\entities\\reports\\lira.csv";
            }
        }


        reportRecords = new ArrayList<>();
        File file = new File(reportPath);
        try (Scanner sc = new Scanner(file)) {
            //Сканер читает файл как пустой. Я не знаю, почему так
            while (sc.hasNextLine()) {
                try {
                    String line = sc.nextLine();
                    reportRecords.add(new ReportRecordEntity(line.split(";")));
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<ReportRecordEntity> getReportRecords() {
        return reportRecords;
    }
}
