package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReportGenerator  {
    //common declaration of variable
    public static LocalDate currentDate = LocalDate.now(); // variable for current date
    public static LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1); // variable for first day of current month
    public static LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth()); // variable for first day of current month
    public static LocalDate firstDayOfPreviousMonth = currentDate.minusMonths(1).withDayOfMonth(1);
    public static LocalDate lastDayOfPreviousMonth = firstDayOfPreviousMonth.withDayOfMonth(firstDayOfPreviousMonth.lengthOfMonth());
    public static LocalDate firstDayOfYear = currentDate.withDayOfYear(1);
    public static LocalDate lastDayOfYear = currentDate.withDayOfYear(currentDate.lengthOfYear());
    public static LocalDate firstDayOfPreviousYear = currentDate.minusYears(1).withDayOfYear(1);
    public static LocalDate lastDayOfPreviousYear = firstDayOfPreviousYear.withDayOfYear(firstDayOfPreviousYear.lengthOfYear());
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // date pattern to format variable

    static Scanner scanner = new Scanner(System.in);

    public static void displayMonthToDateReport(String filename) {

        System.out.println("Month-to-Date Report (" + currentDate.getMonth() + " " + currentDate.getYear() + "):");

        //reading file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDate transactionDate = LocalDate.parse(parts[0], formatter);

                // condition for month to date
                if (transactionDate.isAfter(firstDayOfMonth.minusDays(1)) && transactionDate.isBefore(lastDayOfMonth.plusDays(1))) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file. ");
        }
    }

    public static void displayPreviousMonthReport(String filename) {

            System.out.println("Previous Month's Report (" + firstDayOfPreviousMonth.getMonth() + " " + firstDayOfPreviousMonth.getYear() + "):");

            //reading file
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    LocalDate transactionDate = LocalDate.parse(parts[0], formatter);

                    //condition for previous month
                    if (transactionDate.isAfter(firstDayOfPreviousMonth.minusDays(1)) && transactionDate.isBefore(lastDayOfPreviousMonth.plusDays(1))) {
                        System.out.println(line);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading file. ");
            }
        }

    public static void displayYearToDateReport(String filename) {

        System.out.println("Year-to-Date Report (" + currentDate.getYear() + "):");

        //reading file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDate transactionDate = LocalDate.parse(parts[0], formatter);

                // condition for year to date
                if (transactionDate.isAfter(firstDayOfYear.minusDays(1)) && transactionDate.isBefore(lastDayOfYear.plusDays(1))) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    public static void displayPreviousYearReport(String filename) {

            System.out.println("Previous Year's Report (" + firstDayOfPreviousYear.getYear() + "):");

            //reading file
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    LocalDate transactionDate = LocalDate.parse(parts[0], formatter);

                    //condition for previous year report display
                    if (transactionDate.isAfter(firstDayOfPreviousYear.minusDays(1)) && transactionDate.isBefore(lastDayOfPreviousYear.plusDays(1))) {
                        System.out.println(line);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading file: ");
            }
        }

    public static void customSearchVendor(String filename) {

            System.out.print("Enter the vendor name: ");
            String vendorName = scanner.nextLine();

            boolean found = false;

            //reading file
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    String vendor = parts[3].trim(); // vendor is at index 3 in the line
                    if (vendor.equalsIgnoreCase(vendorName)) {
                        System.out.println(line);
                        found = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }

            if (!found) {
                System.out.println("No entries found for vendor: " + vendorName);
            }

        }

    public static void filterSearch(String filename) {
            System.out.print("Enter start date (YYYY-MM-DD): ");
            String startDateStr = scanner.nextLine();
            LocalDate startDate = null;
            if (!startDateStr.isEmpty()) {
                startDate = LocalDate.parse(startDateStr);
            }

            System.out.print("Enter end date (YYYY-MM-DD): ");
            String endDateStr = scanner.nextLine();
            LocalDate endDate = null;
            if (!endDateStr.isEmpty()) {
                endDate = LocalDate.parse(endDateStr);
            }

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            System.out.print("Enter vendor: ");
            String vendor = scanner.nextLine();

            System.out.print("Enter amount: ");
            String amountStr = scanner.nextLine();
            Double amount = null;
            if (!amountStr.isEmpty()) {
                amount = Double.parseDouble(amountStr); // returns double from string
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    LocalDate transactionDate = LocalDate.parse(parts[0]);
                    String transactionDescription = parts[2].trim();
                    String transactionVendor = parts[3].trim();
                    double transactionAmount = Double.parseDouble(parts[4]);

                    if ((startDate == null || transactionDate.isAfter(startDate) || transactionDate.equals(startDate)) &&
                            (endDate == null || transactionDate.isBefore(endDate) || transactionDate.equals(endDate)) &&
                            (description.isEmpty() || transactionDescription.equalsIgnoreCase(description)) &&
                            (vendor.isEmpty() || transactionVendor.equalsIgnoreCase(vendor)) &&
                            (amount == null || transactionAmount == amount)) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Error parsing amount: " + e.getMessage());
            }

        }
    }









    // Other methods for generating different types of reports


