package ui;

import com.pluralsight.Order;
import com.pluralsight.OrderItem;
import com.pluralsight.Size;

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
        Size chosenSize = null;
        while (chosenSize == null) {
            System.out.println(
                    """ 
                            == Select Size ==
                            1) Classic   (12 oz)
                            2) Works     (16 oz)
                            3) The Oak   (20 oz)
                            Please choose an option: \s""");

            int choice = thescanner.nextInt();
            thescanner.nextLine();

            switch (choice) {
                case 1:
                    chosenSize = Size.SMALL;
                    System.out.println("You Picked " + chosenSize.getDisplayName());
                    break;
                case 2:
                    chosenSize = Size.MEDIUM;
                    System.out.println("You Picked " + chosenSize.getDisplayName());

                    break;
                case 3:
                    chosenSize = Size.LARGE;
                    System.out.println("You Picked " + chosenSize.getDisplayName());

                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

        }
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
