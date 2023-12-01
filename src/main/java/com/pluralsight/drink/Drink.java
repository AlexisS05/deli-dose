package com.pluralsight.drink;

import com.pluralsight.order.Order;
import com.pluralsight.order.OrderItem;
import com.pluralsight.utils.Utils;

import static com.pluralsight.utils.Utils.*;

public class Drink implements OrderItem {

    private final DrinkSize size;

    private final DrinkName name;

    public Drink(DrinkSize size, DrinkName name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public String getStringDetails() {
        return "DRINK: " + size + ", " + name.getName() + " ----------------------------------------- PRICE:" + String.format("($%.2f)", getPrice());
    }

    @Override
    public double getPrice() {
       return size.getPrice();
    }

    public static void chooseDrink(Order order){
        System.out.print(ANSI_PINK + """
                >>>>>>>> What size of the Drink would you prefer? <<<<<<<<""" + ANSI_RESET);
        int drinkSize = Utils.getIntInput(ANSI_PINK + """
                               
                                            -----------
                                            | 1) Small  |
                                            | 2) Medium |
                                            | 3) Large  |
                                            -----------
                                """ + ANSI_RESET, 0, 4);
        DrinkSize drinks = DrinkSize.values()[drinkSize - 1];
        System.out.print(ANSI_YELLOW + """
                >>>>>>>> What Beverage do you prefer? <<<<<<<<<""" + ANSI_RESET);
        int drinkName = Utils.getIntInput(ANSI_YELLOW + """
                
                                                ------
                                               |      |
                                            ---------------
                                            | 1) Coke       |
                                            | 2) Sprite     |
                                            | 3) Ginger ale |
                                            | 4) Water      |
                                            ---------------
                             """ + ANSI_RESET, 0, 5);
        DrinkName drinkChoice = DrinkName.values()[drinkName - 1];
        Drink drinkOrder = new Drink(drinks, drinkChoice);
        System.out.println(drinkOrder.getStringDetails());
        order.addItem(drinkOrder);

    }
}
