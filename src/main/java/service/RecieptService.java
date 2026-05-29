package service;

import com.pluralsight.Order;
import com.pluralsight.OrderItem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class RecieptService {
    public static void saveReceipt(Order order) {

        try {
            BufferedWriter receiptWriter = getBufferedWriter(order);

            receiptWriter.close();

        } catch (Exception e) {
            System.out.println("Error Reading file");

        }

    }
    private static BufferedWriter getBufferedWriter(Order order) throws IOException {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String filename = "src/main/resources/receipts/" + order.getOrderTime().format(fmt) + ".txt";
        BufferedWriter receiptWriter = new BufferedWriter(new FileWriter(filename));


        StringBuilder receipt = new StringBuilder();
        receipt.append("=== OAKBERRY RECEIPT ===\n");
        receipt.append("Date: ").append(order.getOrderTime().format(fmt)).append("\n\n");

        for (OrderItem item : order.getItems()) {
            receipt.append(item.getDescription()).append("  $").append(item.getPrice()).append("\n");
        }

        receipt.append("\nTOTAL: $").append(order.getTotal()).append("\n");

        receiptWriter.write(receipt.toString());
        receiptWriter.newLine();
        System.out.println("Receipt saved" + filename);

        return receiptWriter;
    }

}


