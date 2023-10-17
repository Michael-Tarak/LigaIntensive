package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        String commandText;
        Scanner sc = new Scanner(System.in);
        commandText = sc.nextLine();
        String[] command = commandText.split("\\s+");
        if (command[0].equals("rate")) {
            CurrencyAnalyzer.rateCurrency(command[1], command[2]);
        }
        System.out.println("Unknown command");

    }
}
