package services;

public class CommandReaderService {
    private final int ARGUMENTS_FOR_RATE_COMMAND = 3;

    public CommandReaderService (String commandLine) {
        String [] command = commandLine.split("\\s+");
        switch (command[0]) {
            case "rate" -> {
                try {
                    if (command.length > ARGUMENTS_FOR_RATE_COMMAND) {
                        throw new IllegalArgumentException("Extra arguments for \"rate\" command");
                    }

                    new CurrencyAnalyzerService().findFutureRateOfCurrency(command[1], command[2]);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }
            default -> System.out.println("Unknown command");
        }
    }
}
