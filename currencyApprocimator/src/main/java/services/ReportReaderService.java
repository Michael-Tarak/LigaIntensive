package services;

import enums.CurrencyType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportReaderService {
    private List<String> fileData;

    public ReportReaderService(CurrencyType currencyType) {
        String reportPath;
        switch (currencyType) {
            case USD -> {
                reportPath = "currencyApprocimator\\reports\\usd.csv";
            }
            case EUR -> {
                reportPath = "currencyApprocimator\\reports\\euro.csv";
            }
            case TRY -> {
                reportPath = "currencyApprocimator\\reports\\lira.csv";
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }

        fileData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(reportPath))) {
            String reportDataLine;
            while ((reportDataLine = br.readLine()) != null) {
                fileData.add(reportDataLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        File file = new File(reportPath);
//        fileData = new ArrayList<>();
//        try (Scanner sc = new Scanner(file)) {
//            while (sc.hasNextLine()) {
//                try {
//                    fileData.add(sc.nextLine());
//                } catch (RuntimeException e){
//                    System.out.println(e.getMessage());
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public List<String> getFileData() { return fileData; }
}
