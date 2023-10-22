
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
        String[] command = commandText.split("\\s+");
        CurrencyAnalyzerService cas = new CurrencyAnalyzerService();
        switch (command[0]) {
            case "rate": {
                cas.rateCurrency(command[1], command[2]);
            }
            default:
                System.out.println("Unknown command");
        }




    }
}
