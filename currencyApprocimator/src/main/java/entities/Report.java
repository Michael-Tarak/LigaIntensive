package entities;

import enums.CurrencyType;
import services.ReportReaderService;
import utils.ReportDateConverter;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private final List<ReportRecord> reportRecords;
    private final String columnSplitter = ";";

    public Report(CurrencyType currencyType) {
        reportRecords = new ArrayList<>();

        List<String> reportData = new ReportReaderService(currencyType).getFileData();
        for (String reportDataLine : reportData) {
            try {
                String[] reportRecordEntityArgs = reportDataLine.split(columnSplitter);
                reportRecords.add(new ReportRecord(Integer.parseInt(reportRecordEntityArgs[0].replaceAll(" ", "")),
                        ReportDateConverter.convertFromCsvStyleToLocalDate(reportRecordEntityArgs[1]),
                        Double.parseDouble(reportRecordEntityArgs[2].replaceAll(",", ".")),
                        reportRecordEntityArgs[3]));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<ReportRecord> getReportRecords() {
        return reportRecords;
    }
}
