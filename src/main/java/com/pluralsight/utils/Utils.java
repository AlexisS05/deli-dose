package com.pluralsight.utils;

import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.toppings.Topping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PINK = "\u001B[38;5;206m";
    public static final String ANSI_PURPLE = "\u001B[38;5;165m";
    public static final String ANSI_ORANGE = "\u001B[38;5;208m";
    static Scanner scanner = new Scanner(System.in);
    public static char getCharInput() {
        String userInput = scanner.nextLine().toUpperCase().trim();
        if (!userInput.isEmpty()) {
            return userInput.charAt(0);
        } else {
            return getCharInput();
        }
    }

    public static String getStringInput(String prompt) {
        String input;

        System.out.println(prompt);
        input = scanner.next().trim();

        while (input.isEmpty()) {
            System.out.println("Invalid input. Please enter a non-empty input: ");
            input = scanner.nextLine().trim();
        }

        return input;
    }

    public static int getIntInput(String prompt, int min, int max){
        int input = 0; // Initialize input variable outside the loop
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(prompt);
                input = scanner.nextInt();

                if (input <= min || input >= max) {
                    System.out.println("This is an invalid choice. Try again");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }
        return input;
    }

//    public static int getIntInput(String prompt, int min, int max){
//        int input;
//        System.out.println(prompt);
//        input = scanner.nextInt();
//
//        while (input <= min || input >= max){
//            System.out.println("This is an invalid choice. Try again");
//            input = scanner.nextInt();
//        }
//
//        return input;
//    }

    public static String getIntToppings(String prompt){
        String input;
        System.out.println(prompt);
        input = scanner.next();


        if(input.equalsIgnoreCase("y")){
                int regularOptions = Utils.getIntInput(ANSI_GREEN + """
                        >>>>>>> Here are some regular toppings: <<<<<<<
                                        _______________
                                       | 13) Lettuce   |
                                       | 14) Peppers   |
                                       | 15) Onions    |
                                       | 16) Tomatoes  |
                                       | 17) Jalapenos |
                                       | 18) Cucumbers |
                                       | 19) Pickles   |
                                       | 20) Guacamole |
                                       | 21) Mushrooms |
                                        ---------------""" + ANSI_RESET, 12, 22);
                Topping regularToppings = Topping.values()[regularOptions - 1];
                Sandwich.addTopping(regularToppings);
        }
        return input;
    }

}
