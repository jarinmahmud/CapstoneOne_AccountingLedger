package com.ps;

import java.util.Scanner;

public class ReportScreen {

    public static void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Report Screen:");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Search by keyword ");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    ReportService.displayMonthToDateReport("transaction.txt");
                    // Generate Month to Date report
                    break;
                case 2:
                    ReportService.displayPreviousMonthReport("transaction.txt");
                    // Generate Previous Month report
                    break;
                case 3:
                    ReportService.displayYearToDateReport("transaction.txt");
                    // Generate Year to Date report
                    break;
                case 4:
                    ReportService.displayPreviousYearReport("transaction.txt");
                    // Generate Previous Year report
                    break;
                case 5:
                    ReportService.customSearchVendor("transaction.txt");
                    // Search by Vendor
                    break;
                case 6:
                    ReportService.filterSearch("transaction.txt");
                    // challenge search
                    break;
                case 0:

                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
