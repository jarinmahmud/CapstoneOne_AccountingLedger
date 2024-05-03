package com.ps;
import java.util.Scanner;
public class HomeScreen {
    public static void display() {
        Scanner scanner = new Scanner(System.in); //scanner class to take input
        while (true) {
            // Home Screen Prompt
            System.out.println("Home Screen:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().toUpperCase();// takes the option and converts it to uppercase

            switch (option) {
                case "D":
                    TransactionGenerator.addDeposit(); // implies add deposit method
                    break;
                case "P":
                    TransactionGenerator.addDebit(); // implies add debit method
                    break;
                case "L":
                    LedgerScreen.display(); // displays ledger screen
                    break;
                case "X":
                    System.out.println("Exiting Application.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
