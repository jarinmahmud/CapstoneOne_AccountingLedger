package com.ps;

import java.util.Scanner;

public class ReportScreen {

    public static void display() {
        Scanner scanner = new Scanner(System.in); // scanner class to take input
        while (true) {
            // Report Screen Prompt
            System.out.println("Report Screen:");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Search by keyword ");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt(); // takes the option number as input
            scanner.nextLine(); // new line
            String path = "transaction.txt";

            switch (option) {
                case 1:
                    ReportGenerator.displayMonthToDateReport(path); // generates Month to Date report
                    break;
                case 2:
                    ReportGenerator.displayPreviousMonthReport(path); // generates Previous Month report
                    break;
                case 3:
                    ReportGenerator.displayYearToDateReport(path); // generates Year to Date report
                    break;
                case 4:
                    ReportGenerator.displayPreviousYearReport(path); // generates Previous Year report
                    break;
                case 5:
                    ReportGenerator.customSearchVendor(path); // Search by Vendor
                    break;
                case 6:
                    ReportGenerator.filterSearch(path); // challenge search
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

