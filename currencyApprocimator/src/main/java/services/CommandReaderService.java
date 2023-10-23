package services;

import enums.CurrencyType;
import enums.RatePeriod;

import java.util.Arrays;

public class CommandReaderService {
    private final int ARGUMENTS_FOR_RATE_COMMAND_COUNT = 3;

    public CommandReaderService () {

    }

    public void readCommandFromConsole(String commandLine) {
        String [] command = commandLine.split("\\s+");
        switch (command[0]) {
            case "rate" -> {
                try {
                    if (command.length > ARGUMENTS_FOR_RATE_COMMAND_COUNT) {
                        throw new IllegalArgumentException("Extra arguments for \"rate\" command");
                    }

                    validateRateArguments(command[1], command[2]);

                    new CurrencyAnalyzerService().predictFutureRateOfCurrency(command[1], command[2]);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }
            default -> System.out.println("Unknown command");
        }
    }

    private void validateRateArguments(String currency, String period) {
        String [] currencyTypes = Arrays.toString(CurrencyType.values()).replaceAll("^.|.$", "").
                replaceAll(" ", "").split(",");
        boolean isValidCurrencyType = false;
        for (String ct : currencyTypes) {
            if (ct.equals(currency.toUpperCase())) {
                isValidCurrencyType = true;
                break;
            }
        }
        if (!isValidCurrencyType) {
            throw new IllegalArgumentException("Invalid currency type!");
        }
        String [] ratePeriods = Arrays.toString(RatePeriod.values()).replaceAll("^.|.$", "").
                replaceAll(" ", "").split(",");
        boolean isValidRatePeriod = false;
        for (String rp : ratePeriods) {
            if (rp.equals(period.toUpperCase())) {
                isValidRatePeriod = true;
                break;
            }
        }
        if (!isValidRatePeriod) {
            throw new IllegalArgumentException("Invalid rate period!");
        }
    };
}
