package service;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
// helps class for input validation
public class PromptHelper {
    // use same scanner for ui and this class
    private final Scanner theScanner;

    public PromptHelper( Scanner theScanner) {
        this.theScanner = theScanner;

    }
    // fixes money output
    public static String money(BigDecimal amount) {
        return "$" + amount.setScale(2, java.math.RoundingMode.HALF_UP);
    }


 // makes sure input is not a string
    public  int readInt(String prompt){

        while (true){
            System.out.print(prompt);
            try {
                int userChoice = theScanner.nextInt();
                theScanner.nextLine();
                return userChoice;
            } catch (InputMismatchException e) {
                theScanner.nextLine();
                System.out.println("Please enter a valid number.");
            }


        }
    }
// makes sure user on inputs available options
    public boolean inputYesNo(String prompt){

        while (true){
            System.out.println(prompt);
            String input = theScanner.nextLine();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                return true;
            }
            if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
                return false;
            }
            System.out.println("Invalid input please enter ( y ) or ( n )");

        }

    }

}
