package entities;

import enums.CurrencyType;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportEntity {
    private String reportPath;
    private List<ReportRecordEntity> reportRecords;

    public ReportEntity(CurrencyType currencyType) {
        switch (currencyType) {

            case USD -> {
                reportPath = "reports\\usd.csv";
            }
            case EUR -> {
                reportPath = "reports\\euro.csv";
            }
            case TRY -> {
                reportPath = "reports\\lira.csv";
            }
        }


        reportRecords = new ArrayList<>();
        File file = new File(reportPath);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                try {
                    String [] reportRecordEntityArgs = sc.nextLine().split(";");
                    reportRecords.add(new ReportRecordEntity(Integer.parseInt(reportRecordEntityArgs[0]),
                                                            LocalDate.parse(reportRecordEntityArgs[1]),
                                                            Double.parseDouble(reportRecordEntityArgs[2]),
                                                            reportRecordEntityArgs[3]));
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
