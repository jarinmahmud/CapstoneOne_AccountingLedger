package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportService {

//    public List<String> generateReport(String reportType, String... args) {
//        // Implement report generation logic based on reportType and args
//        return null;
//    }

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

    // Other methods for generating different types of reports
}

