package com.ps;

import java.util.Scanner;

public class LedgerScreen {

    public static void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ledger Screen:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    FinancialService.displayEntries("transaction.txt");
                    // Display all entries
                    break;
                case "D":
                    FinancialService.displayDeposits("transaction.txt");
                    // Display deposits
                    break;
                case "P":
                    FinancialService.displayPayments("transaction.txt");
                    // Display payments
                    break;
                case "R":
                    ReportScreen.display();
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
