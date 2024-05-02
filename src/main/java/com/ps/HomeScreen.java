package com.ps;

import java.util.Scanner;

public class HomeScreen {

    public static void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Home Screen:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("R) Reports");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "D":
                    FinancialService.addDeposit(); // add deposit
                    break;
                case "P":
                    FinancialService.addDebit(); // add debit
                    break;
                case "L":
                    LedgerScreen.display();
                    break;
                case "R":
                    ReportScreen.display();
                    break;
                case "X":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
