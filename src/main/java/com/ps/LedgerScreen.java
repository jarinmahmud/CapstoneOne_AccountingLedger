package com.ps;

import java.util.Scanner;

public class LedgerScreen {

    public static void display() {
        Scanner scanner = new Scanner(System.in); // scanner class to take input
        while (true) {
            //Ledger Screen prompt
            System.out.println("Ledger Screen:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine().toUpperCase();
            String path = "transaction.txt";

            switch (option) {
                case "A":
                    TransactionGenerator.displayEntries(path); // displays all entries
                    break;
                case "D":
                    TransactionGenerator.displayDeposits(path); // displays all deposits
                    break;
                case "P":
                    TransactionGenerator.displayPayments(path); // displays all payments
                    break;
                case "R":
                    ReportScreen.display(); // display report screen prompt
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

