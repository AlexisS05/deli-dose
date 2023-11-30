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
        System.out.print("""                        
                                     .---.
                                   //     \\
                                  || () () ||
                                   \\      //
                                     |||||
                ┌───────────────────────────────────────────┐
                │     Welcome To The Deli-Dose Store        |
                |           Order Best Sandwiches           │
                └───────────────────────────────────────────┘
                 """);

        while (true) {
            System.out.print("""
            >>>>>>> Please Enter One Option: <<<<<<<<<
                             1) Make Order
                             0) Exit""");
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
            System.out.print("""
                    >>>>>> What would you like to order? <<<<<<<<
                                    -----------------
                                   | 1) Add Sandwich |
                                   | 2) Add Drink    |
                                   | 3) Add Chips    |
                                   | 4) Checkout     |
                                   | 0) Return Home  |
                                    -----------------""");
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
            System.out.println("""
            >>>>>> Select your Bread Choice: <<<<<<<<<
                            ----------
                           | 1) WHITE |
                           | 2) WHEAT |
                           | 3) RYE   |
                           | 4) WRAP  |
                            ----------""");
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

        while (size == null) {
            System.out.println("""
            >>>>>>>> Select size of Sandwich: <<<<<<<<<<
                          ------------------
                         | 1) Four Inches   |
                         | 2) Eight Inches  |
                         | 3) Twelve Inches |
                          ------------------""");
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
            String meatChoice = Utils.getStringInput("""
                    >>>>>>> Would you like to add Meat? <<<<<<<
                                        |Y/N|""");
            if (meatChoice.equalsIgnoreCase("y")) {
                int meatOption = Utils.getIntInput(""" 
                         >>>>>>> Meat Toppings: <<<<<<<<
                                 ---------------
                                | 1) Steak      |   
                                | 2) Ham        |
                                | 3) Salami     |  
                                | 4) Roast beef |   
                                | 5) Chicken    |  
                                | 6) Bacon      |
                                 ---------------""", 0, 7);
                Topping topping = Topping.values()[meatOption - 1];
                Sandwich.addTopping(topping);
                while (continueChoosing) {
                    String extraChoice = Utils.getStringInput("""
                    >>>>>> Would you like to Add Extra Meat? <<<<<
                                          |Y/N|""");
                    if (extraChoice.equalsIgnoreCase("y")) {
                        Sandwich.addExtra(Topping.EXTRA_MEAT);
                    }else{
                        continueChoosing = false;
                    }
                }
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
            String cheeseChoice = Utils.getStringInput("""
                    >>>>>>>> Would you like to Add Cheese? <<<<<<<<<
                                         |Y/N|""");
            if (cheeseChoice.equalsIgnoreCase("y")) {
                int cheeseOption = Utils.getIntInput("""
                        >>>>>>> Cheese Toppings: <<<<<<<<<<
                                   --------------
                                  | 7) American  |
                                  | 8) Provolone |
                                  | 9) Cheddar   |
                                  | 10) Swiss    |
                                   --------------""", 6, 11);
                Topping cheeseTopping = Topping.values()[cheeseOption - 1];
                Sandwich.addTopping(cheeseTopping);
                String extraCheese = Utils.getStringInput("""
                >>>>>>>> Would you like to Add Extra Cheese? <<<<<<<<<<
                                        |Y/N|""");
                if (extraCheese.equalsIgnoreCase("y")) {
                    Sandwich.addExtra(Topping.EXTRA_CHEESE);
                }else {
                    continueChoosing = false;
                }
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
        String toppingChoice = Utils.getStringInput("""
        >>>>>>>> Would you like to add Toppings? <<<<<<<<<<
                               |Y/N|""");
        if (toppingChoice.equalsIgnoreCase("y")) {
            int regularOptions = Utils.getIntInput("""
                    >>>>>>> Regular Toppings: <<<<<<<
                             ---------------
                            | 13) Lettuce   |
                            | 14) Peppers   |
                            | 15) Onions    |
                            | 16) Tomatoes  |
                            | 17) Jalapenos |
                            | 18) Cucumbers |
                            | 19) Pickles   |
                            | 20) Guacamole |
                            | 21) Mushrooms |
                             ---------------""", 12, 22);
            Topping regularToppings = Topping.values()[regularOptions - 1];
            Sandwich.addTopping(regularToppings);
        }
        String toppingsTest = Utils.getIntToppings("""
        >>>>>>>> Would you like to add more Toppings? <<<<<<<<<<
                                |Y/N|""");
        System.out.println(toppingsTest);


        // Sauces

        while (continueChoosing) {
            String sauceChoice = Utils.getStringInput("""
            >>>>>>>> Would you like to Add any Sauce? <<<<<<<<
                                   |Y/N|""");
            if (sauceChoice.equalsIgnoreCase("y")) {
                int sauceOptions = Utils.getIntInput("""
                        >>>>>>> I know you don't want any Dry Sandwich, Here are some options: <<<<<<<<<
                                                  ----------------------
                                                 | 22) Mayo             |
                                                 | 23) Mustard          |
                                                 | 24) Ketchup          |
                                                 | 25) Ranch            |
                                                 | 26) Thousand Islands |
                                                 | 27) Vinaigrette      |
                                                  ----------------------""", 21, 28);

                Topping sauceToppings = Topping.values()[sauceOptions - 1];
                Sandwich.addTopping(sauceToppings);
            } else {
                continueChoosing = false;
            }
        }

        // Toasted
        String toastChoice = Utils.getStringInput("""
                >>>>>>> Would you like it Toasted? <<<<<<<<<<
                                  |Y/N|""");
        sandwich.setToasted(toastChoice.equalsIgnoreCase("y"));


        //Sides not completed yet
        int sideOptions = Utils.getIntInput("I'm pretty sure you need some sides with that, how about these: \n 29) au jus \n 230) sauce" +
                "", 28, 30);
        Topping sideToppings = Topping.values()[sideOptions -1];
        Sandwich.addTopping(sideToppings);
        System.out.println(sandwich.getStringDetails());
        order.addItem(sandwich);
    }

    private void addDrink(Order order) {
        System.out.print("""
        >>>>>>>> What size of the Drink would you prefer? <<<<<<<<""");
        int drinkSize = Utils.getIntInput("""
        >>>>>>>> Size options include: <<<<<<<<
                        -----------
                       | 1) Small  |
                       | 2) Medium |
                       | 3) Large  |
                        -----------""", 0, 4);
        DrinkSize drinks = DrinkSize.values()[drinkSize - 1];
        System.out.print("""
               >>>>>>>> What Beverage do you prefer? <<<<<<<<<""");
        int drinkName = Utils.getIntInput("""
                >>>>>>>> Options include: <<<<<<<<<
                                  ------
                                 |      |
                             ---------------
                            | 1) Coke       |
                            | 2) Sprite     |
                            | 3) Ginger ale |
                            | 4) Water      |
                             ---------------""", 0, 5);
        DrinkName drinkChoice = DrinkName.values()[drinkName - 1];
        Drink drinkOrder = new Drink(drinks, drinkChoice);
        System.out.println(drinkOrder.getStringDetails());
        order.addItem(drinkOrder);
    }

    private void addChips(Order order) {
        System.out.print("""
                >>>>>>>> Select One Chips: <<<<<<<<""");
        int userInput = Utils.getIntInput(""" 
                         \\ ------------/
                         |1) Lays     |
                         |2) Pringles |
                         |3) Doritos  |
                         |4) Cheetos  |
                         /-------------\\""", 0, 5);
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
            String choice = Utils.getStringInput("""
            >>>>>>> Would you like to confirm order? <<<<<<<<<
                                |Y/N|""");
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
