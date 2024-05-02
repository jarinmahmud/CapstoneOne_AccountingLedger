package com.ps;

import java.io.FileWriter;
import java.io.IOException;

public class FinancialService {
    private static final String FILE_PATH = "transactions.txt";

    public void addTransaction(Transaction transaction) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            writer.append(String.format("%s|%s|%s|%s|%.2f\n",
                    transaction.getDate(), transaction.getTime(), transaction.getDescription(),
                    transaction.getVendor(), transaction.getAmount()));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Other methods for reading transactions, etc.
}
