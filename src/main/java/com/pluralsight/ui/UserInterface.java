package com.pluralsight.ui;

import com.pluralsight.chips.Chips;
import com.pluralsight.chips.ChipsName;
import com.pluralsight.drink.Drink;
import com.pluralsight.drink.DrinkName;
import com.pluralsight.drink.DrinkSize;
import com.pluralsight.order.Order;
import com.pluralsight.order.OrderFileManager;
import com.pluralsight.order.OrderItem;
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
            System.out.println("What would you like to do? \n 1) Make Order \n 0) Exit");
            char choice = Utils.getCharInput();
            switch (choice) {
                case '1':
                    makeOrder();
                    break;
                case '0':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
    }

    public void makeOrder() {
        // Instantiate new Order
        Order order = new Order();

        while (true) {
            System.out.println("What would you like to order? \n 1) Add Sandwich \n 2) Add Drink \n 3) Add Chips \n 4) Checkout \n 0) Return Home");
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
                case '4':
                    checkout(order);
                    break;
                case '0':
                    return;
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

        while (size == null) {
            System.out.println("Select size of Sandwich: \n 1) Four Inches \n 2) Eight Inches \n 3) Twelve Inches");
            char sizeChoice = Utils.getCharInput();
            switch (sizeChoice) {
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
        // Meat
        boolean continueChoosing = true;
        while (continueChoosing) {
            String meatChoice = Utils.getStringInput("Would you like to add Meat? Y/N");
            if (meatChoice.equalsIgnoreCase("y")) {
                int meatOption = Utils.getIntInput("Here are our meat toppings: \n 1) Steak \n 2) ham " +
                        "\n 3) salami \n 4) roast beef \n 5) chicken \n 6) bacon", 0, 7);
                Topping topping = Topping.values()[meatOption - 1];
                Sandwich.addTopping(topping);
            } else {
                continueChoosing = false;
            }
        }
        // Extra Meat
        String extraChoice = Utils.getStringInput("Would you like to add extra Meat? Y/N");
        if (extraChoice.equalsIgnoreCase("y")) {
            Sandwich.addExtra(Topping.EXTRA_MEAT);
        }
        // Cheese
        while (continueChoosing) {
            String cheeseChoice = Utils.getStringInput("Would you like to add Cheese? Y/N");
            if (cheeseChoice.equalsIgnoreCase("y")) {
                int cheeseOption = Utils.getIntInput("Here are our cheese options: \n 7) American \n 8) Provolone \n 9) Cheddar \n 10) Swiss", 6, 11);
                Topping cheeseTopping = Topping.values()[cheeseOption - 1];
                Sandwich.addTopping(cheeseTopping);
            }else {
                continueChoosing = false;
            }
        }
        // Extra Cheese
        String extraCheese = Utils.getStringInput("Would you like to add extra Cheese? Y/N");
        if (extraCheese.equalsIgnoreCase("y")) {
            Sandwich.addExtra(Topping.EXTRA_CHEESE);
        }
        // Topping
        String toppingChoice = Utils.getStringInput("Would you like to add Toppings? Y/N");
        if (toppingChoice.equalsIgnoreCase("y")) {
            int regularOptions = Utils.getIntInput("Here are some regular toppings: \n 13) Lettuce \n 14) Peppers \n 15) Onions " +
                    "\n 16) Tomatoes \n 17) Jalapenos \n 18) Cucumbers \n 19) Pickles \n 20) Guacamole \n 21) Mushrooms", 12, 22);
            Topping regularToppings = Topping.values()[regularOptions - 1];
            Sandwich.addTopping(regularToppings);
        }
        String toppingsTest = Utils.getIntToppings("Would you like to add more Toppings ? Y/N");
        System.out.println(toppingsTest);


        // Sauces

        while (continueChoosing) {
            String sauceChoice = Utils.getStringInput("Would you like to add any Sauce? Y/N");
            if (sauceChoice.equalsIgnoreCase("y")) {
                int sauceOptions = Utils.getIntInput("I know you don't want no dry sandwich, Here are some options: \n 22) Mayo \n 23) Mustard " +
                        "\n 24) Ketchup \n 25) Ranch \n 26) Thousand Islands \n 27) Vinaigrette", 21, 28);
                Topping sauceToppings = Topping.values()[sauceOptions - 1];
                Sandwich.addTopping(sauceToppings);
            } else {
                continueChoosing = false;
            }
        }

        // Toasted
        String toastChoice = Utils.getStringInput("Would you like it Toasted? Y/N");
        sandwich.setToasted(toastChoice.equalsIgnoreCase("y"));


        //Sides not completed yet
        //System.out.println("I'm pretty sure you need some sides with that, how about these: \n 28) au jus \n 29) sauce");
        //int sideOptions = scanner.nextInt();
        //Topping sideToppings = Topping.values()[sideOptions -1];
        //Sandwich.addTopping(sideToppings);
        System.out.println(sandwich.getStringDetails());
        order.addItem(sandwich);
    }

    private void addDrink(Order order) {
        System.out.println("What size of the drink would you prefer?");
        int drinkSize = Utils.getIntInput("Size options include: \n 1) Small \n 2) Medium \n 3) Large", 0, 4);
        DrinkSize drinks = DrinkSize.values()[drinkSize - 1];
        System.out.println("What beverage do you prefer?");
        int drinkName = Utils.getIntInput("Options include: \n 1) Coke \n 2) Sprite \n 3) Ginger ale \n 4) Water", 0, 5);
        DrinkName drinkChoice = DrinkName.values()[drinkName - 1];
        Drink drinkOrder = new Drink(drinks, drinkChoice);
        System.out.println(drinkOrder.getStringDetails());
        order.addItem(drinkOrder);
    }

    private void addChips(Order order) {
        System.out.println("which chips you would like to select");
        int userInput = Utils.getIntInput("\n 1) Lays \n 2) Pringles \n 3) Doritos \n 4) Cheetos", 0, 5);
        ChipsName chipsName = ChipsName.values()[userInput - 1];
        Chips chip = new Chips(chipsName);
        order.addItem(chip);
    }

    private void checkout(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("You have nothing in your cart");
        } else {
            System.out.println("Your Order: ");
            for (OrderItem item : order.getItems()
            ) {
                System.out.println(item.getStringDetails());
            }
            System.out.printf("This is the total price: $%.2f" + order.getPrice());
            String choice = Utils.getStringInput("Would you like to confirm order? Y/N ");
            if (choice.equalsIgnoreCase("y")) {
                OrderFileManager ofm = new OrderFileManager(order);
                ofm.saveToTXTFile();
                order.clear();
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("Order cancelled");
                order.clear();
            }
        }
    }
}
