package com.ps;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TransactionGenerator {
    private static final String path = "transaction.txt";

    public static void addDeposit() {
        Scanner scanner = new Scanner(System.in);

        // Prompt for deposit information
        System.out.println("Enter deposit details:");
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Time (HH:MM): ");
        String time = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        // deposit information to text file
        //writing the information on file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount + "\n");
            System.out.println("Deposit added successfully.");
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void addDebit() {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for debit information
        System.out.println("Enter debit details:");
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Time (HH:MM): ");
        String time = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        // Writing debit information to text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(date + "|" + time + "|" + description + "|" + vendor + "|-" + amount + "\n");
            System.out.println("Debit added successfully.");
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void displayEntries(String filename) {
        List<String> entries = new ArrayList<>(); // creating arraylist to store entry list

        // Read entries from file
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

        // Sorting entries by newest first
        Collections.reverse(entries);

        // Display sorted entries
        System.out.println("Displaying entries (newest first):");
        for (String entry : entries) {
            System.out.println(entry);
        }
    }

    public static void displayDeposits(String filename) {
        List<String> deposits = new ArrayList<>(); // arraylist for storing deposit information

        //reading file
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                double amount = Double.parseDouble(parts[4]);

                if (amount > 0) { // Only considering positive values as deposits
                    deposits.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file. ");
        }

        // Sort deposits by newest first
        Collections.reverse(deposits);

        // Display sorted deposits
        System.out.println("Displaying deposits (newest first):");
        for (String deposit : deposits) {
            System.out.println(deposit);
        }
    }

    public static void displayPayments(String filename) {
        List<String> payments = new ArrayList<>(); // arraylist for sorting payments

        //reading file
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                double amount = Double.parseDouble(parts[4]);

                if (amount < 0) { // Only consider negative values as payments
                    payments.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Sort payments by newest first
        Collections.reverse(payments);

        // Display sorted payments
        System.out.println("Displaying payments (newest first):");
        for (String payment : payments) {
            System.out.println(payment);
        }
    }


    }



