package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ReportService {


    public static void displayMonthToDateReport(String filename) {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Month-to-Date Report (" + currentDate.getMonth() + " " + currentDate.getYear() + "):");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDate transactionDate = LocalDate.parse(parts[0], formatter);

                if (transactionDate.isAfter(firstDayOfMonth.minusDays(1)) && transactionDate.isBefore(lastDayOfMonth.plusDays(1))) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void displayPreviousMonthReport(String filename) {
            LocalDate currentDate = LocalDate.now();
            LocalDate firstDayOfPreviousMonth = currentDate.minusMonths(1).withDayOfMonth(1);
            LocalDate lastDayOfPreviousMonth = firstDayOfPreviousMonth.withDayOfMonth(firstDayOfPreviousMonth.lengthOfMonth());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            System.out.println("Previous Month's Report (" + firstDayOfPreviousMonth.getMonth() + " " + firstDayOfPreviousMonth.getYear() + "):");

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    LocalDate transactionDate = LocalDate.parse(parts[0], formatter);

                    if (transactionDate.isAfter(firstDayOfPreviousMonth.minusDays(1)) && transactionDate.isBefore(lastDayOfPreviousMonth.plusDays(1))) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

    public static void displayYearToDateReport(String filename) {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfYear = currentDate.withDayOfYear(1);
        LocalDate lastDayOfYear = currentDate.withDayOfYear(currentDate.lengthOfYear());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Year-to-Date Report (" + currentDate.getYear() + "):");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDate transactionDate = LocalDate.parse(parts[0], formatter);

                if (transactionDate.isAfter(firstDayOfYear.minusDays(1)) && transactionDate.isBefore(lastDayOfYear.plusDays(1))) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void displayPreviousYearReport(String filename) {
            LocalDate currentDate = LocalDate.now();
            LocalDate firstDayOfPreviousYear = currentDate.minusYears(1).withDayOfYear(1);
            LocalDate lastDayOfPreviousYear = firstDayOfPreviousYear.withDayOfYear(firstDayOfPreviousYear.lengthOfYear());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            System.out.println("Previous Year's Report (" + firstDayOfPreviousYear.getYear() + "):");

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    LocalDate transactionDate = LocalDate.parse(parts[0], formatter);

                    if (transactionDate.isAfter(firstDayOfPreviousYear.minusDays(1)) && transactionDate.isBefore(lastDayOfPreviousYear.plusDays(1))) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

    public static void customSearchVendor(String filename) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the vendor name: ");
            String vendorName = scanner.nextLine();

            boolean found = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    String vendor = parts[3].trim(); // Assuming vendor is at index 3 in the line
                    if (vendor.equalsIgnoreCase(vendorName)) {
                        System.out.println(line);
                        found = true;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file.");
            }

            if (!found) {
                System.out.println("No entries found for vendor: " + vendorName);
            }

        }

    public static void filterSearch(String filename) {
            Scanner scanner = new Scanner(System.in);

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
                amount = Double.parseDouble(amountStr);
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


