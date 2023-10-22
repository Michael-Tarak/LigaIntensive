
import services.CommandReaderService;
import services.CurrencyAnalyzerService;

import java.util.Scanner;

/**
 * Input "rate" command with arguments
 * Output currency statistic
 */
public class App 
{
    public static void main( String[] args ) {
        String commandText;
        Scanner sc = new Scanner(System.in);
        commandText = sc.nextLine();
        CommandReaderService crs = new CommandReaderService(commandText);

    }
}
