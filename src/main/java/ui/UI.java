package ui;

import com.pluralsight.Order;
import com.pluralsight.OrderItem;

import java.util.Scanner;

public class UI {
    private final Scanner thescanner = new Scanner(System.in);
    private final Order currentOrder = new Order();
    private boolean AppRunning;

    public void start() {
        boolean appRunning = true;
        // Create the active cart for this session
        while (appRunning) {
            System.out.println(
                    """ 
                            == Welcome to Oakberry ==
                            1- Add a Bowl
                            2- Add a Drink
                            3- Add a side
                            4- View Current Order
                            5- Checkout
                            6- Exit
                            Please choose an option: \s""");

            int menuChoice = thescanner.nextInt();
            thescanner.nextLine();
            switch (menuChoice) {
                case 1:
                    acaiMenu(currentOrder);
                    break;
                case 2:
                    drinkMenu(currentOrder);
                    break;
                case 3:
                    addSide(currentOrder);
                    break;
                case 4:
                    displayCart(currentOrder);
                    break;
                case 5:
                    checkOut(currentOrder);
                    break;
                case 6:
                    System.out.println("Thank you !");
                    appRunning = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

        }
    }
    private void acaiMenu(Order order) {
        System.out.println("Add bowl flow — coming soon");
    }

    private void drinkMenu(Order order) {
        System.out.println("Add drink flow — coming soon");
    }
    private void  addSide(Order order) {
        System.out.println("Add drink flow — coming soon");
    }

    private void displayCart(Order order) {
        if(order.isEmpty()){
            System.out.println("Your cart is empty");

        }
        System.out.println("=== Your Order ===");
        for (OrderItem item : order.getItems()){
            order.getItems();
            System.out.println(item.getDescription() + " -$" + item.getPrice());
        }
    }

    private void checkOut(Order order) {
        System.out.println("Checkout — coming soon");
    }


}
