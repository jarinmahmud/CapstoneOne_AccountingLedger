package com.ps;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Create a static variable to store transactions: hint- ArrayList<Transaction>
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Welcome to the Home Screen:");
                System.out.println("1. Add Deposit");
                System.out.println("2. Make Payment");
                System.out.println("3. Display Ledger");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You chose: Add Deposit");

                        double amount;
                        do { // Prompt user for deposit information
                            System.out.println("Enter deposit information:");
                            System.out.print("Account Number: ");
                            String accountNumber = scanner.nextLine();
                            System.out.print("Amount: ");
                            amount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline character

                            // Save deposit information to CSV file
                            try {
                                FileWriter writer = new FileWriter("deposits.csv", true); // append mode
                                writer.append(accountNumber + "," + amount + "\n");
                                writer.close();
                                System.out.println("Deposit information saved to deposits.csv");
                            } catch (IOException e) {
                                System.err.println("Error writing to file: " + e.getMessage());
                            }
                        } while (amount >= 0);
                    {
                        System.out.println("Enter positive amount.");
                    }
                    break;
                    case 2:
                        System.out.println("You chose: Make Payment");
                        // Make Payment logic here
                        break;
                    case 3:
                        System.out.println("You chose: Display Ledger");
                        // Display Ledger logic here
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            } while (choice != 4);

            scanner.close();


            }
        }


// Create class for storing transactions
// Fields include date, time, description, vendor and amount
// *Note
// if amount is positive then the amount is a deposit
// if amount is negative then the amount is a payment

// Load records of transactions to the static variable for transactions
// * hint-Load transactions before the menu loop

// Create CLI menu items
// *hint
// first do-while: Home menu
// second do-while: Ledger menu
// third do-while: Reports menu

// Perform deposit and payment transactions while recording the transactions to the file

// Reports

// Menu Outline
// **Home Menu**
// D) Add Deposit
// P) Make Payment(Debit)
// L) Ledger
// **Ledger Menu**
// A) All
// D) Deposit
// P) Payments
// R) Reports
// R) **Reports Menu**
// 1) Month To Date
// 2) Previous Month
// 3) Year To Date
// 4) Previous Year
// 5) Search by Vendor
// 0) Back
// H) Home
// X) Exit


// ** Report Demo **
//  date, time, description, vendor and amount
//        Transaction transaction1 = new Transaction(
//                LocalDate.of(2024, 3, 14),
//                LocalTime.of(14, 43, 05, 0),
//                "Monstera Plant",
//                "Amazon",
//                39.99f
//        );

//        Transaction transaction2 = new Transaction(
//                LocalDate.of(2024, 4, 29),
//                LocalTime.of(8, 05, 25, 0),
//                "HeartLeaf Plant",
//                "Amazon",
//                19.99f
//        );

//        ArrayList<Transaction> transactions = new ArrayList<>();
//        transactions.add(transaction1);
//        transactions.add(transaction2);

// Generate a report- Month to Date

//        for(Transaction transaction : transactions){
//            LocalDate transactionDate = transaction.getDate();
//            LocalDate nowDate = LocalDate.now();
//            if(transactionDate.getMonthValue() == nowDate.getMonthValue()){
//                System.out.println("             Month To Date Report          ");
//                System.out.println("              -- Transactions --           ");
//                System.out.println("Date - Time - Description - Vendor - Amount");
//                System.out.printf("%s - %s - %s - %s - $%.2f",
//                        transaction.getDate(),
//                        transaction.getTime(),
//                        transaction.getDescription(),
//                        transaction.getVendor(),
//                        transaction.getAmount()
//                );

//            Month To Date Report
//            -- Transactions --
// Date - Time - Description - Vendor - Amount
// 4-29-24 - 8:05 - HeartLeaf Plant - Amazon - $19.99

