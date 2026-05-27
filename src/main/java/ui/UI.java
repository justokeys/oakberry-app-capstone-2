package ui;

import java.util.Scanner;

public class UI {
    private final Scanner thescanner = new Scanner(System.in);
    boolean appRunning = true;
    // Create the active cart for this session
    while(appRunning){
        System.out.println(
                """ 
                == Welcome to Oakberry ==
                1- Add a Bowl
                2- Add a Drink
                3- View Current Order
                4- Checkout
                5- Exit
                Please choose an option: \s""" );

        int menuChoice = thescanner.nextInt();
        thescanner.nextLine();
        switch (menuChoice) {
            case 1:
                acaiMenu();
                break;
            case 2:
                drinkMenu();
                break;
            case 3:
                displayCart();
                break;
            case 4:
                checkOut();
                break;
            case 5:
                System.out.println("Thank you !");
                appRunning = false;
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
        }

    }





}
