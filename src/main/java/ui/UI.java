package ui;

import com.pluralsight.*;

import java.util.List;
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
        BaseType chosenBase = null;
        while (chosenBase == null) {
            System.out.println("== Select Base ==");
            System.out.println(BaseType.STANDARD.getAcaiBase() + " " + "(+$" + BaseType.STANDARD.getAcaiBaseUpcharge() + ")");
            System.out.println(BaseType.GREEN_WELLNESS.getAcaiBase() + " " + "(+$" + BaseType.GREEN_WELLNESS.getAcaiBaseUpcharge() + ")");
            System.out.println(BaseType.IM8_MIXED_BERRY.getAcaiBase() + " " + "(+$" + BaseType.IM8_MIXED_BERRY.getAcaiBaseUpcharge() + ")");
            int choice = thescanner.nextInt();
            thescanner.nextLine();

            switch (choice) {
                case 1:
                    chosenBase = BaseType.STANDARD;
                    System.out.println("You Picked " + chosenBase.getAcaiBase());
                    break;
                case 2:
                    chosenBase = BaseType.GREEN_WELLNESS;
                    System.out.println("You Picked " + chosenBase.getAcaiBase());

                    break;
                case 3:
                    chosenBase = BaseType.IM8_MIXED_BERRY;
                    System.out.println("You Picked " + chosenBase.getAcaiBase());

                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
        AcaiBowl acaiBowl = new AcaiBowl(chosenSize, chosenBase);

        System.out.println(" Regular Toppings ");
        System.out.println("Type the number to add. Type 0 when done.");
        while (true) {
            // Display the numbered menu


            for (int i = 0; i < RegularTopping.MENU.size(); i++) {
                System.out.println((i + 1) + ")" + RegularTopping.MENU.get(i).getName());
            }
            System.out.println("0) Done");
            System.out.println("Choose: ");
            int choice = thescanner.nextInt();
            thescanner.nextLine();


            if (choice == 0)
                break;

            if (choice < 1 || choice > RegularTopping.MENU.size()) {
                System.out.println("Invalid Choice");
                continue;
            }
            RegularTopping toppingChoice = RegularTopping.MENU.get(choice - 1);
            acaiBowl.addTopping(toppingChoice);
            System.out.println("Added: " + toppingChoice.getName());


        }
        System.out.println(" Premium Toppings ");
        System.out.println("Type the number to add. Type 0 when done.");

        PremiumToppingMenu[] premiumToppings = PremiumToppingMenu.values();
        while (true) {
            for (int i = 0; i < premiumToppings.length; i++) {
                System.out.println((i + 1) + ")" + premiumToppings[i].getDisplayName() +
                        " (+$" + premiumToppings[i].getCategory().priceFor(chosenSize) + ")");
            }
            System.out.println("0) Done");
            System.out.println("Choose: ");
            int choice = thescanner.nextInt();
            thescanner.nextLine();

            if (choice == 0)
                break;

            if (choice < 1 || choice > premiumToppings.length) {
                System.out.println("Invalid Choice");
                continue;
            }
            PremiumTopping toppingChoice = premiumToppings[choice - 1].toTopping();
            acaiBowl.addTopping(toppingChoice);
            System.out.println("Add: " + toppingChoice.getName());


        }
        System.out.println("Add Hemp Seed Boost? (y/n): ");
        String hempChoice = thescanner.nextLine().trim().toLowerCase();
        if (hempChoice.equals("y")) {
            acaiBowl.setHempBoost(true);
            System.out.println("Hemp Boost Added!");
        }

        order.addItem(acaiBowl);


    }

    private void drinkMenu(Order order) {
        DrinkCategory choosenCategory = null;
        DrinkCategory[] categories = DrinkCategory.values();
        while (choosenCategory == null) {
            System.out.println("== Select a drink Type ==");
            for (int i = 0; i < categories.length; i++) {
                System.out.println((i + 1) + ")" + categories[i].getDisplayName());
            }
            System.out.println("0) Done");
            System.out.println("Choose: ");
            int choice = thescanner.nextInt();
            thescanner.nextLine();

            if (choice == 0)
                break;

            if (choice < 1 || choice > categories.length) {
                System.out.println("Invalid Choice");
                continue;
            }
            choosenCategory = categories[choice - 1];
        }
        if (choosenCategory == null) {
            System.out.println("Drink cancelled.");
            return;
        }

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
        List<DrinkFlavor> flavors = DrinkFlavor.flavorsFor(choosenCategory);

        DrinkFlavor chosenFlavor = null;
        while (chosenFlavor == null) {
            System.out.println("== Pick a " + choosenCategory.getDisplayName() + " ==");
            for (int i = 0; i < flavors.size(); i++) {
                System.out.println((i + 1) + ")" + flavors.get(i).getDisplayName());
            }
            System.out.println("0) Done");
            System.out.println("Choose: ");
            int choice = thescanner.nextInt();
            thescanner.nextLine();

            if (choice == 0)
                break;

            if (choice < 1 || choice > flavors.size()) {
                System.out.println("Invalid Choice");
                continue;
            }
            chosenFlavor = flavors.get(choice - 1);

        }
        if (chosenFlavor == null) {
            System.out.println("Drink cancelled.");
            return;
        }
        Drink drink = new Drink(chosenSize, chosenFlavor);
        order.addItem(drink);
        System.out.println("✓" + drink.getDescription() + " added! - $" + drink.getPrice());

    }

    private void addSide(Order order) {
        System.out.println("Add drink flow — coming soon");
    }

    private void displayCart(Order order) {
        if (order.isEmpty()) {
            System.out.println("Your cart is empty");
            return;

        }
        System.out.println("=== Your Order ===");
        for (OrderItem item : order.getItems()) {
            System.out.println(item.getDescription() + " -$" + item.getPrice());
        }
    }

    private void checkOut(Order order) {
        System.out.println("Checkout — coming soon");
    }


}
