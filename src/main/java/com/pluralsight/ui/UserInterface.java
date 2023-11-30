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
    Sandwich sandwich = new Sandwich();


    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_PINK = "\u001B[38;5;206m";
    private static final String ANSI_PURPLE = "\u001B[38;5;165m";
    private static final String ANSI_ORANGE = "\u001B[38;5;208m";

    public void homeScreen() {
        System.out.print(ANSI_CYAN + """                        
                                     .---.
                                   //     \\
                                  || () () ||
                                   \\      //
                                     |||||
                ┌───────────────────────────────────────────┐
                │     Welcome To The Deli-Dose Store        |
                |           Order Best Sandwiches           │
                └───────────────────────────────────────────┘
                 """ + ANSI_RESET);

        while (true) {
            System.out.print(ANSI_YELLOW + """
            >>>>>>> Please Enter One Option: <<<<<<<<<
                             1) Make Order
                             0) Exit""" + ANSI_RESET);
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
            System.out.print(ANSI_RED + """
                    >>>>>> What would you like to order? <<<<<<<<
                                    -----------------
                                   | 1) Add Sandwich |
                                   | 2) Add Drink    |
                                   | 3) Add Chips    |
                                   | 4) Checkout     |
                                   | 0) Return Home  |
                                    -----------------""" + ANSI_RESET);
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
        BreadType bread = sandwich.getBreadChoice();
        SandwichSize size = null;
        while (bread == null) {
            System.out.println(ANSI_GREEN + """
                    >>>>>> Select your Bread Choice: <<<<<<<<<
                                    ----------
                                   | 1) WHITE |
                                   | 2) WHEAT |
                                   | 3) RYE   |
                                   | 4) WRAP  |
                                    ----------""" + ANSI_RESET);
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
            System.out.println(ANSI_PINK + """
                    >>>>>>>> Select size of Sandwich: <<<<<<<<<<
                                  ------------------
                                 | 1) Four Inches   |
                                 | 2) Eight Inches  |
                                 | 3) Twelve Inches |
                                  ------------------""" + ANSI_RESET);
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
        boolean cheeseContinue = true;

        while (continueChoosing) {
            String meatChoice = Utils.getStringInput(ANSI_CYAN + """
                    >>>>>>> Would you like to add Meat? <<<<<<<
                                        |Y/N|""" + ANSI_RESET);
            if (meatChoice.equalsIgnoreCase("y")) {
                int meatOption = Utils.getIntInput(ANSI_PURPLE + """ 
                        >>>>>>> Meat Toppings: <<<<<<<<
                                ---------------
                               | 1) Steak      |   
                               | 2) Ham        |
                               | 3) Salami     |  
                               | 4) Roast beef |   
                               | 5) Chicken    |  
                               | 6) Bacon      |
                                ---------------""" + ANSI_RESET, 0, 7);
                Topping topping = Topping.values()[meatOption - 1];
                Sandwich.addTopping(topping);
                if (!Sandwich.getToppings().isEmpty()) {
                    String meatChoice2 = Utils.getStringInput(ANSI_RED + """
                            >>>>>>> Would you like to add another Meat? <<<<<<<
                                                |Y/N|""" + ANSI_RESET);
                    if (meatChoice2.equalsIgnoreCase("y")) {
                        int meatOption2 = Utils.getIntInput(ANSI_GREEN + """ 
                                >>>>>>> Meat Toppings: <<<<<<<<
                                        ---------------
                                       | 1) Steak      |   
                                       | 2) Ham        |
                                       | 3) Salami     |  
                                       | 4) Roast beef |   
                                       | 5) Chicken    |  
                                       | 6) Bacon      |
                                        ---------------""" + ANSI_RESET, 0, 7);
                        Topping topping2 = Topping.values()[meatOption2 - 1];
                        Sandwich.addTopping(topping2);
                    }

                } else {
                    continueChoosing = false;
                }
            }
            // Extra Meat
            String extraChoice = Utils.getStringInput(ANSI_PINK + """
                    >>>>>>>> Would you like to Add Extra Meat? <<<<<<<<<
                                           |Y/N|""" + ANSI_RESET);
            if (extraChoice.equalsIgnoreCase("y")) {
                Sandwich.addExtra(Topping.EXTRA_MEAT);
            }
            // Cheese
            while (cheeseContinue) {
                String cheeseChoice = Utils.getStringInput(ANSI_CYAN + """
                        >>>>>>>> Would you like to Add Cheese? <<<<<<<<<
                                             |Y/N|""" + ANSI_RESET);
                if (cheeseChoice.equalsIgnoreCase("y")) {
                    int cheeseOption = Utils.getIntInput(ANSI_YELLOW + """
                            >>>>>>> Cheese Toppings: <<<<<<<<<<
                                       --------------
                                      | 7) American  |
                                      | 8) Provolone |
                                      | 9) Cheddar   |
                                      | 10) Swiss    |
                                       --------------""" + ANSI_RESET, 6, 11);
                    Topping cheeseTopping = Topping.values()[cheeseOption - 1];
                    Sandwich.addTopping(cheeseTopping);
                } else {
                    cheeseContinue = false;
                }
            }
            // Extra Cheese
            String extraCheese = Utils.getStringInput(ANSI_RED + """
                    >>>>>>> Would you like to add extra Cheese? <<<<<<<<<
                                         |Y/N|""" + ANSI_RESET);
            if (extraCheese.equalsIgnoreCase("y")) {
                Sandwich.addExtra(Topping.EXTRA_CHEESE);
            }
            // Topping
            String toppingChoice = Utils.getStringInput(ANSI_GREEN + """
                    >>>>>>>> Would you like to add Toppings? <<<<<<<<<<
                                           |Y/N|""" + ANSI_RESET);
            if (toppingChoice.equalsIgnoreCase("y")) {
                int regularOptions = Utils.getIntInput( ANSI_ORANGE + """
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
                                 ---------------""" + ANSI_RESET, 12, 22);
                Topping regularToppings = Topping.values()[regularOptions - 1];
                Sandwich.addTopping(regularToppings);
            }
            String toppingsTest = Utils.getIntToppings(ANSI_CYAN + """
                    >>>>>>>> Would you like to add more Toppings? <<<<<<<<<<
                                            |Y/N|""" + ANSI_RESET);
            System.out.println(toppingsTest);


            // Sauces

            while (continueChoosing) {
                String sauceChoice = Utils.getStringInput(ANSI_YELLOW + """
                        >>>>>>>> Would you like to Add any Sauce? <<<<<<<<
                                               |Y/N|""" + ANSI_RESET);
                if (sauceChoice.equalsIgnoreCase("y")) {
                    int sauceOptions = Utils.getIntInput(ANSI_PURPLE + """
                            >>>>>>> I know you don't want any Dry Sandwich, Here are some options: <<<<<<<<<
                                                      ----------------------
                                                     | 22) Mayo             |
                                                     | 23) Mustard          |
                                                     | 24) Ketchup          |
                                                     | 25) Ranch            |
                                                     | 26) Thousand Islands |
                                                     | 27) Vinaigrette      |
                                                      ----------------------""" + ANSI_RESET, 21, 28);

                    Topping sauceToppings = Topping.values()[sauceOptions - 1];
                    Sandwich.addTopping(sauceToppings);
                } else {
                    continueChoosing = false;
                }
            }

            //Sides
            int sideOptions = Utils.getIntInput(ANSI_GREEN + """
                    >>>>>>>> I'm pretty sure you need some Sides with that, How about these: <<<<<<<<
                                                      ---------------------
                                                     | 28) au jus          |
                                                     | 29) Mashed potatoes |
                                                     | 30) Mac & Cheese    |
                                                     | 31) Garlic Bread    |
                                                      ---------------------""" + ANSI_RESET, 27, 32);
            Topping sideToppings = Topping.values()[sideOptions - 1];
            Sandwich.addSides(sideToppings);
            System.out.println(sandwich.getStringDetails());


            // Toasted
            String toastChoice = Utils.getStringInput(ANSI_CYAN + """
                    >>>>>>> Would you like it Toasted? <<<<<<<<<<
                                      |Y/N|""" + ANSI_RESET);
            sandwich.setToasted(toastChoice.equalsIgnoreCase("y"));
        }
    }


    private void addDrink(Order order) {
        System.out.print(ANSI_CYAN + """
        >>>>>>>> What size of the Drink would you prefer? <<<<<<<<""" + ANSI_RESET);
        int drinkSize = Utils.getIntInput(ANSI_PINK + """
        >>>>>>>> Size options include: <<<<<<<<
                        -----------
                       | 1) Small  |
                       | 2) Medium |
                       | 3) Large  |
                        -----------""" + ANSI_RESET, 0, 4);
        DrinkSize drinks = DrinkSize.values()[drinkSize - 1];
        System.out.print(ANSI_YELLOW + """
               >>>>>>>> What Beverage do you prefer? <<<<<<<<<""" + ANSI_RESET);
        int drinkName = Utils.getIntInput(ANSI_YELLOW + """
                >>>>>>>> Options include: <<<<<<<<<
                                  ------
                                 |      |
                             ---------------
                            | 1) Coke       |
                            | 2) Sprite     |
                            | 3) Ginger ale |
                            | 4) Water      |
                             ---------------""" + ANSI_RESET, 0, 5);
        DrinkName drinkChoice = DrinkName.values()[drinkName - 1];
        Drink drinkOrder = new Drink(drinks, drinkChoice);
        System.out.println(drinkOrder.getStringDetails());
        order.addItem(drinkOrder);
    }

    private void addChips(Order order) {
        System.out.print(ANSI_RED + """
                >>>>>>>> Select One Chips: <<<<<<<< \n""" + ANSI_RESET);
        int userInput = Utils.getIntInput(ANSI_ORANGE + """ 
                          
                              ------------
                            | 1) Lays     |
                            | 2) Pringles |
                            | 3) Doritos  |
                            | 4) Cheetos  |
                             -------------""" + ANSI_RESET, 0, 5);
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
            String choice = Utils.getStringInput(ANSI_GREEN + """
            >>>>>>> Would you like to confirm order? <<<<<<<<<
                                |Y/N|""" + ANSI_RESET);
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
