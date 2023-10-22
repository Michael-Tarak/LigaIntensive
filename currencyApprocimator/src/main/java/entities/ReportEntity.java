package entities;

import enums.CurrencyType;
import services.ReportReaderService;
import utils.ReportDateConverter;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportEntity {
    private String reportPath;
    private List<ReportRecordEntity> reportRecords;

    public ReportEntity(CurrencyType currencyType) {
        reportRecords = new ArrayList<>();

        List<String> reportData = new ReportReaderService(currencyType).getFileData();
        String columnSplitter = ";";
        for (String reportDataLine : reportData) {
            try {
                String [] reportRecordEntityArgs = reportDataLine.split(columnSplitter);
                reportRecords.add(new ReportRecordEntity(Integer.parseInt(reportRecordEntityArgs[0]),
                        ReportDateConverter.ConvertFromCsvStyleToLocalDate(reportRecordEntityArgs[1]),
                        Double.parseDouble(reportRecordEntityArgs[2].replaceAll(",", ".")),
                        reportRecordEntityArgs[3]));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public List<ReportRecordEntity> getReportRecords() {
        return reportRecords;
    }
}
