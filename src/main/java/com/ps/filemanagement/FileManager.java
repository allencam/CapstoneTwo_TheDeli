package com.ps.filemanagement;

import com.ps.structure.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    // SAVING ORDERS HANDLED HERE
    private static final String RECEIPT_FOLDER = "receipts/";

    public static void saveOrderReceipt(Order order) {

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = RECEIPT_FOLDER + dateTime + ".txt";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write(String.format("""
                ===============================
                    Order Total: $%.2f
                ===============================
                """, order.getTotal()));
            bufferedWriter.newLine();

            bufferedWriter.write("""
                    Sandwiches
                ------------------
                """);
            for (Product product : order.getProducts()) {
                if (product instanceof Sandwich) {
                    bufferedWriter.write(product.toString());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.newLine();

            bufferedWriter.write("""
                      Drinks
                ------------------
                """);
            for (Product product : order.getProducts()) {
                if (product instanceof Drink) {
                    bufferedWriter.write(product.toString());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.newLine();

            bufferedWriter.write("""
                      Chips
                ------------------
                """);
            for (Product product : order.getProducts()) {
                if (product instanceof Chips) {
                    bufferedWriter.write(product.toString());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            System.out.println("Order receipt saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
