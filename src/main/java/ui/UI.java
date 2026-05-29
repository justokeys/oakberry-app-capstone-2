package ui;

import com.pluralsight.*;
import com.pluralsight.enums.*;
import com.pluralsight.Side;
import com.pluralsight.toppings.PremiumTopping;
import com.pluralsight.toppings.RegularTopping;
import service.PromptHelper;
import service.RecieptService;

import java.util.List;
import java.util.Scanner;

// All menu and user inputs performed in this class
public class UI {
    private final Scanner thescanner = new Scanner(System.in);
    private final Order currentOrder = new Order();
    // Initialize Prompt helper method for input validation -- pass in scanner
    private final PromptHelper prompts = new PromptHelper(thescanner);

    public void homeMenu(){
        // Opening menu
        boolean appRun = true;
        while (appRun) {
            System.out.println("""
                    ╭────────────────────────────────────────╮
                    │                                        │
                    │            O A K B E R R Y             │
                    │           Açaí Bowls & More            │
                    │                                        │
                    ╰────────────────────────────────────────╯
                    """);
            System.out.println("1 - Start new order");
            System.out.println("0 - Exit");

            int choice = prompts.readInt("Choose: ");
            switch (choice) {
                case 1:
                    start();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    appRun = false;
                    break;
            }
        }
    }

    public void start() {

        boolean appRunning = true;
        // Main menu
        while (appRunning) {
            System.out.println("""
                    ╭────────────────────────────────────────╮
                    │                                        │
                    │          == Welcome to Oakberry ==     │
                    │          1- Add a Bowl                 │
                    │          2- Add a Drink                │
                    │          3- Add a Side                 │
                    │          4- View Current Order         │
                    │          5- Checkout                   │
                    │          6- Exit                       │
                    │                                        │
                    ╰────────────────────────────────────────╯
                    """);

            int menuChoice = prompts.readInt("Choose: ");

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

    // Create A Acai bowl menu
    private void acaiMenu(Order order) {
        // prompt user to select a size
        Size chosenSize = null;
        while (chosenSize == null) {
            System.out.println("""
                    ╭────────────────────────────────────────╮
                    │             == Select Size ==          │
                    ├────────────────────────────────────────┤
                    │                                        │
                    │          1) Classic   (12 oz)          │
                    │          2) Works     (16 oz)          │
                    │          3) The Oak   (20 oz)          │
                    │                                        │
                    ╰────────────────────────────────────────╯
                    """);
            // Input goes to input validation so user inputs an integer
            int choice = prompts.readInt("Choose: ");


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
        // prompt a user to select base for bowl
        BaseType chosenBase = null;
        while (chosenBase == null) {
            System.out.println("""
                    ╭────────────────────────────────────────╮
                    │             == Select Base ==          │
                    ├────────────────────────────────────────┤
                    │                                        │
                    │     1) Acai (+$0)                      │
                    │     2) Acai + Green-Superfood (+$1.50) │
                    │     3) Acai + I*M*8 Berry     (+$1.50) │
                    │                                        │
                    ╰────────────────────────────────────────╯
                    """);
            int choice = prompts.readInt("Choose: ");


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
        // new bowl created withe selected base and size
        AcaiBowl acaiBowl = new AcaiBowl(chosenSize, chosenBase);

        System.out.println("""
                ╭────────────────────────────────────────╮
                │           == Regular Toppings ==       │
                ╰────────────────────────────────────────╯
                """);
        System.out.println("Type the number to add. Type 0 when done.");
        while (true) {
            // Display the numbered menu for regular toppings

            for (int i = 0; i < RegularTopping.MENU.size(); i++) {
                System.out.println((i + 1) + ")" + RegularTopping.MENU.get(i).getName());
            }
            System.out.println("0) Done");
            // Input validation checks if user inputs; integer , not String character or number to high or low
            int choice = prompts.readInt("Choose: ");


            if (choice == 0)
                break;

            if (choice < 1 || choice > RegularTopping.MENU.size()) {
                System.out.println("Invalid Choice");
                continue;
            }
            RegularTopping toppingChoice = RegularTopping.MENU.get(choice - 1);
            // add to bowl!
            acaiBowl.addTopping(toppingChoice);
            System.out.println("Added: " + toppingChoice.getName());


        }
        System.out.println("""
                ╭────────────────────────────────────────╮
                │           == Premium Toppings ==       │
                ╰────────────────────────────────────────╯
                """);
        System.out.println("Type the number to add. Type 0 when done.");
        // loops through enums to display ordered premium topping list
        PremiumToppingMenu[] premiumToppings = PremiumToppingMenu.values();
        while (true) {
            for (int i = 0; i < premiumToppings.length; i++) {
                System.out.println((i + 1) + ")" + premiumToppings[i].getDisplayName() +
                        " (+$" + premiumToppings[i].getCategory().priceFor(chosenSize) + ")");
            }
            System.out.println("0) Done");
            // Input validation checks if user inputs; integer , not String character or number to high or low
            int choice = prompts.readInt("Choose: ");


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

        // Prompt user for hemp boost add on
        if (prompts.inputYesNo("Add Hemp Seed Boost? (y/n): ")) {
            acaiBowl.setHempBoost(true);
            System.out.println("Hemp Boost Added!");
        }

        order.addItem(acaiBowl);

        System.out.println("Total: " + PromptHelper.money(order.getTotal()));


    }

    // display drink menu
    private void drinkMenu(Order order) {
        DrinkCategory choosenCategory = null;
        DrinkCategory[] categories = DrinkCategory.values();
        while (choosenCategory == null) {
            // loops through drink category enum to display ordered premium topping list
            System.out.println("""
                    ╭────────────────────────────────────────╮
                    │          == Select a Drink Type ==     │
                    ╰────────────────────────────────────────╯
                    """);
            for (int i = 0; i < categories.length; i++) {
                System.out.println((i + 1) + ")" + categories[i].getDisplayName());
            }
            System.out.println("0) Done");

            int choice = prompts.readInt("Choose: ");


            if (choice == 0)
                break;

            if (choice < 1 || choice > categories.length) {
                System.out.println("Invalid Choice");
                continue;
            }
            choosenCategory = categories[choice - 1];
        }
        // must choose a flavor
        if (choosenCategory == null) {
            System.out.println("Drink cancelled.");
            return;
        }

        Size chosenSize = null;
        while (chosenSize == null) {
            System.out.println("""
                    ╭────────────────────────────────────────╮
                    │             == Select Size ==          │
                    ├────────────────────────────────────────┤
                    │                                        │
                    │          1) Classic   (12 oz)          │
                    │          2) Works     (16 oz)          │
                    │          3) The Oak   (20 oz)          │
                    │                                        │
                    ╰────────────────────────────────────────╯
                    """);

            int choice = prompts.readInt("Choose: ");

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
        // Initialize List for flavors
        List<DrinkFlavor> flavors = DrinkFlavor.flavorsFor(choosenCategory);

        DrinkFlavor chosenFlavor = null;
        // loop through flavors
        while (chosenFlavor == null) {
            System.out.println("== Pick a " + choosenCategory.getDisplayName() + " ==");
            for (int i = 0; i < flavors.size(); i++) {
                System.out.println((i + 1) + ")" + flavors.get(i).getDisplayName());
            }
            System.out.println("0) Done");

            // prompt user for flavor choice

            int choice = prompts.readInt("Choose: ");

            if (choice == 0)
                break;

            if (choice < 1 || choice > flavors.size()) {
                System.out.println("Invalid Choice");
                continue;
            }
            chosenFlavor = flavors.get(choice - 1);

        }
        // must choose a size
        if (chosenFlavor == null) {
            System.out.println("Drink cancelled.");
            return;
        }
        Drink drink = new Drink(chosenSize, chosenFlavor);
        order.addItem(drink);
        System.out.println("✓" + drink.getDescription() + " added! - $" + drink.getPrice());
        System.out.println("Total: " + PromptHelper.money(order.getTotal()));


    }

    private void addSide(Order order) {
        SideType[] sides = SideType.values();
        System.out.println("""
                ╭────────────────────────────────────────╮
                │             == Add a Side ==           │
                ╰────────────────────────────────────────╯
                """);
        // creates side menu
        for (int i = 0; i < sides.length; i++) {
            System.out.println((i + 1) + ")" + sides[i].getDisplayName());
        }
        System.out.println("0) Done");

        // prompt user to choose side
        int choice = prompts.readInt("Choose: ");


        if (choice == 0)
            return;

        if (choice < 1 || choice > sides.length) {
            System.out.println("Invalid Choice");
            return;
        }
        Side chosenSide = new Side(sides[choice - 1]);

        order.addItem(chosenSide);
        System.out.println("✓" + chosenSide.getDescription() + " added! - $" + chosenSide.getPrice());
        System.out.println("Total: " + PromptHelper.money(order.getTotal()));
    }

    // display to the user what the  current orderlist is
    private void displayCart(Order order) {
        if (order.isEmpty()) {
            System.out.println("Your cart is empty");
            return;

        }
        System.out.println("""
                ╭────────────────────────────────────────╮
                │             === Your Order ===         │
                ╰────────────────────────────────────────╯
                """);
        for (OrderItem item : order.getItems()) {
            System.out.println(item.getDescription() + " -$" + item.getPrice());
        }
        System.out.println("Total: " + PromptHelper.money(order.getTotal()));
    }
    // allow user to confirm order and check out ( save receipt to file)
    private void checkOut(Order order) {
        if (order.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }

        System.out.println("""
            ╭────────────────────────────────────────╮
            │          Oakberry Order Summary        │
            ├────────────────────────────────────────┤""");

        for (OrderItem item : order.getItems()) {
            String details = item.getDescription().replace("\n", "\n   ");
            System.out.println(" • " + details + " (" + PromptHelper.money(item.getPrice()) + ")      ");
        }

        System.out.println(" ────────────────────────────────────────");
        System.out.println("  Total: " + PromptHelper.money(order.getTotal()) + "        ");
        System.out.println("""
            ╰────────────────────────────────────────╯
             1) Confirm Order
             2) Cancel
            """);

        int UserChoice = prompts.readInt("Choose: ");

        if (UserChoice == 1){
            RecieptService.saveReceipt(order);
            order.clear();
        }
        else {
            System.out.println("Order canceled");
            order.clear();
        }
    }


}
