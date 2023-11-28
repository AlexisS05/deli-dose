package com.pluralsight.ui;

import com.pluralsight.chips.Chips;
import com.pluralsight.chips.ChipsName;
import com.pluralsight.drink.Drink;
import com.pluralsight.drink.DrinkName;
import com.pluralsight.drink.DrinkSize;
import com.pluralsight.order.Order;
import com.pluralsight.sandwich.BreadType;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.SandwichSize;
import com.pluralsight.toppings.Topping;
import com.pluralsight.utils.Utils;

import java.util.Scanner;

public class UserInterface {
    public void homeScreen() {
        System.out.println("Welcome to the Deli Dose the best sandwiches in the world!");

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
        SandwichSize size = null;
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
        System.out.println(bread);

        while (size == null){
            System.out.println("Select size of Sandwich: \n 1) Four \n 2) Eight \n 3) Twelve");
            char sizeChoice = Utils.getCharInput();
            switch (sizeChoice){
                case '1':
                    size = SandwichSize.FOUR;
                    break;
                case '2':
                    size = SandwichSize.EIGHT;
                    break;
                case '3':
                    size = SandwichSize.TWELVE;
                    break;
                default:
                    System.out.println("Choose an appropriate sandwich size.");
            }
        }
        Sandwich sandwich = new Sandwich(bread, size);
        System.out.println("Here are our meat toppings: \n 1) Steak \n 2) ham " +
                "\n 3) salami \n 4) roast beef \n 5) chicken \n 6) bacon");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        Topping topping = Topping.values()[option -1];
        System.out.println(topping);
        Sandwich.addTopping(topping);
        System.out.println("Would you like to add extra Meat? Y/N");
        String choose = scanner.next();
        if (choose.equalsIgnoreCase("y")){
            Sandwich.addExtra(topping);
        }
        System.out.println("Here are our cheese options: \n 7) American, \n 8) Provolone, \n 9) Cheddar, \n 10) Swiss");
        int cheeseOption = scanner.nextInt();
        Topping cheeseTopping = Topping.values()[cheeseOption -1];
        System.out.println(cheeseTopping);
        Sandwich.addTopping(cheeseTopping);
        System.out.println("Would you like to add extra cheese? Y/N");
        String extraCheese = scanner.next();
        if (extraCheese.equalsIgnoreCase("y")){
            Sandwich.addExtra(cheeseTopping);
        }
        System.out.println(sandwich.getStringDetails());

    }

    private void addDrink(Order order) {
        System.out.println("What size of the drink would you prefer?");
        System.out.println("Size options include: small, medium and large");
        Scanner scanner = new Scanner(System.in);
        String size = scanner.next().toUpperCase();
        System.out.println("What beverage do you prefer?");
        System.out.println("Options include: coke, sprite, ginger ale, water");
        String drinkName = scanner.next().toUpperCase();
        System.out.println(size);
        System.out.println(drinkName);
        DrinkName nameOfDrink = DrinkName.valueOf(drinkName);
        DrinkSize sizeOfDrink = DrinkSize.valueOf(size);
        Drink sizeAndName = new Drink(sizeOfDrink, nameOfDrink);
        System.out.println(sizeAndName);
    }

    private void addChips(Order order) {
        System.out.println("which chips you would like to select");
        System.out.println("Lays,Pringles,Doritos,Cheetos");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().toUpperCase().trim();
        System.out.println(userInput);
        ChipsName chipsName = ChipsName.valueOf(userInput);
        Chips chip = new Chips(chipsName);
    }
}
