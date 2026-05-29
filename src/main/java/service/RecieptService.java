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
        receipt.append("╭────────────────────────────────────────╮\n");
        receipt.append("│           === OAKBERRY RECEIPT ===     │\n");
        receipt.append("├────────────────────────────────────────┤\n");
        receipt.append("  Date: ").append(order.getOrderTime().format(fmt)).append("\n\n");

        for (OrderItem item : order.getItems()) {
            String details = item.getDescription().replace("\n", "\n   ");
            receipt.append("  • ").append(details).append(" (").append(PromptHelper.money(item.getPrice())).append(")\n");
        }

        receipt.append("\n  TOTAL: ").append(PromptHelper.money(order.getTotal())).append("\n");
        receipt.append("╰────────────────────────────────────────╯\n");

        receiptWriter.write(receipt.toString());
        receiptWriter.newLine();
        System.out.println("Receipt saved: " + filename);

        return receiptWriter;
    }

}


