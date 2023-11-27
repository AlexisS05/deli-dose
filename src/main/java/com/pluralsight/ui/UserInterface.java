package com.pluralsight.ui;

import com.pluralsight.order.Order;
import com.pluralsight.sandwich.BreadType;
import com.pluralsight.utils.Utils;

public class UserInterface {
    public void homeScreen() {
        System.out.println("Welcome to the Deli Sandwiches");

        while (true) {
            System.out.println("Would you like to do? \n 1) Make Order \n X) Exit");
            char choice = Utils.getCharInput();
            switch (choice) {
                case '1':
                    makeOrder();
                    break;
                case '0':
                    System.exit(0);
            }
        }
    }

    public void makeOrder() {
        // Instantiate new Order
        Order order = new Order();

        while (true) {
            System.out.println("What would you like to order? \n 1) Add Sandwich \n 2) Add Drink \n 3) Add Chips");
            char option = Utils.getCharInput();
            switch (option) {
                case '1':
                    addSandwich(order);
                    break;
                case '2':
                    addDrink(order);
                    break;
                case '3':
                    addChips(order);
                    break;
                default:
                    System.out.println("Please try again! ");
            }
        }
    }



    private void addSandwich(Order order) {
        BreadType bread = null;
        while (bread == null) {
            System.out.println("Select your bread choice: \n 1) WHITE \n 2) WHEAT \n 3) RYE \n 4) WRAP");
            char breadChoice = Utils.getCharInput();
            switch (breadChoice) {
                case '1':
                    bread = BreadType.WHITE;
                    break;
                case '2':
                    bread = BreadType.WHEAT;
                    break;
                case '3':
                    bread = BreadType.RYE;
                    break;
                case '4':
                    bread = BreadType.WRAP;
                    break;
                default:
                    System.out.println("Please enter a valid bread choice (1, 2, 3, or 4): ");
            }
        }
    }

    private void addDrink(Order order) {
    }

    private void addChips(Order order) {
    }
}
