package service;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PromptHelper {
    public static String money(BigDecimal amount) {
        return "$" + amount.setScale(2, java.math.RoundingMode.HALF_UP);
    }

    private static Scanner thescanner = new Scanner(System.in);

    public int readInt(String prompt){
        System.out.print(prompt);
        while (true){

            try {
                int userChoice = thescanner.nextInt();
                thescanner.nextLine();
                return userChoice;
            } catch (InputMismatchException e) {
                thescanner.nextLine();
                System.out.println("Please enter a valid number.");
            }


        }
    }

}
