package com.pluralsight.ui;

import com.pluralsight.chips.Chips;
import com.pluralsight.drink.Drink;
import com.pluralsight.order.Order;
import com.pluralsight.order.OrderFileManager;
import com.pluralsight.order.OrderItem;
import com.pluralsight.sandwich.BreadType;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.SandwichSize;
import com.pluralsight.toppings.Topping;
import com.pluralsight.utils.Utils;


import static com.pluralsight.utils.Utils.*;

public class UserInterface {

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
                    >>>>>> What would you like to Order? <<<<<<<<
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
        BreadType bread = Sandwich.getBreadChoice(); // Get bread choice
        SandwichSize size = Sandwich.getSandwichSize(); // Get sandwich size choice

        Sandwich sandwich = new Sandwich(bread, size);

        boolean continueChoosing = true;
        // Meats
        while (continueChoosing) {
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
                } else {
                    continueChoosing = false;
                    String extraChoice = Utils.getStringInput(ANSI_PINK + """
                            >>>>>>>> Would you like to Add Extra Meat? <<<<<<<<<
                                                   |Y/N|""" + ANSI_RESET);
                    if (extraChoice.equalsIgnoreCase("y")) {
                        Sandwich.addExtra(Topping.EXTRA_MEAT);
                    }
                }
            } else {
                continueChoosing = addMeatTopping(); // Only update continueChoosing if there's already at least one topping
            }
        }

        // Cheese
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
            String extraCheese = Utils.getStringInput(ANSI_RED + """
                    >>>>>>> Would you like to Add Extra Cheese? <<<<<<<<<
                                         |Y/N|""" + ANSI_RESET);
            if (extraCheese.equalsIgnoreCase("y")) {
                Sandwich.addExtra(Topping.EXTRA_CHEESE);
            }
        }

        // Topping
        boolean toppingChoose = true;
        while (toppingChoose) {
            String toppingsTest = Utils.getIntToppings(ANSI_CYAN + """
                    >>>>>>>> Would you like to Add Toppings? <<<<<<<<<<
                                            |Y/N|""" + ANSI_RESET);
            if (!toppingsTest.equalsIgnoreCase("y")) {
                toppingChoose = false;
            }
        }

        // Sauces
        boolean isSauceChoice = true;
        while (isSauceChoice) {
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
                isSauceChoice = false;
            }
        }
        //Sides
        int sideOptions = Utils.getIntInput(ANSI_GREEN + """
                >>>>>>>> I'm pretty sure you need some Sides with that, How about these, These are free: <<<<<<<<
                                                  ---------------------
                                                 | 28) au jus          |
                                                 | 29) Mashed potatoes |
                                                 | 30) Mac & Cheese    |
                                                 | 31) Garlic Bread    |
                                                  ---------------------""" + ANSI_RESET, 27, 32);
        Topping sideToppings = Topping.values()[sideOptions - 1];
        Sandwich.addSides(sideToppings);

        // Toasted
        String toastChoice = Utils.getStringInput(ANSI_CYAN + """
                >>>>>>> Would you like it Toasted? <<<<<<<<<<
                                  |Y/N|""" + ANSI_RESET);
        sandwich.setToasted(toastChoice.equalsIgnoreCase("y"));
        System.out.println(sandwich.getStringDetails());
        order.addItem(sandwich);
    }

    private void addDrink(Order order) {
        Drink.chooseDrink(order);
    }

    private void addChips(Order order) {
        Chips.chooseChip(order);
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
            System.out.printf("This is the total price: $%.2f%n", order.getPrice());
            String choice = Utils.getStringInput(ANSI_GREEN + """
                    >>>>>>> Would you like to Confirm Order? <<<<<<<<<
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

    private boolean addMeatTopping() {
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
            return true;
        } else {
            return false;
        }
    }
}
