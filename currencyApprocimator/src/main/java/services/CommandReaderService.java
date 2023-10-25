package services;

import enums.CurrencyType;
import enums.RatePeriod;

public class CommandReaderService {
    private final int ARGUMENTS_FOR_RATE_COMMAND_COUNT = 3;

    public CommandReaderService () {

    }

    public void readCommandFromConsole(String commandLine) {
        String [] command = commandLine.split("\\s+");
        switch (command[0]) {
            case "rate" -> {
                try {
                    if (command.length != ARGUMENTS_FOR_RATE_COMMAND_COUNT) {
                        throw new IllegalArgumentException("Extra arguments for \"rate\" command");
                    }

                    if (isValidRateArguments(command[1], command[2])) {
                        new CurrencyAnalyzerService().predictFutureRateOfCurrency(command[1], command[2]);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }
            default -> System.out.println("Unknown command");
        }
    }

    private boolean isValidRateArguments(String currency, String period) {

        try {
            CurrencyType.valueOf(currency.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid currency type!");
            return false;
        }

        try {
            RatePeriod.valueOf(period.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid rate period!");
            return false;
        }
        return true;
    }
}
