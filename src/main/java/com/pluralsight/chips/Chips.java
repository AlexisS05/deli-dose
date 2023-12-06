package com.pluralsight.chips;

import com.pluralsight.order.Order;
import com.pluralsight.order.OrderItem;
import com.pluralsight.utils.Utils;

import static com.pluralsight.utils.Utils.*;
import static com.pluralsight.utils.Utils.ANSI_RESET;

public class Chips implements OrderItem {
    private final ChipsName name;


    public Chips(ChipsName name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    public ChipsName getName() {
        return name;
    }

    @Override
    public String getStringDetails() {
        return  "CHIPS: " + name.getName() + " --------------------------------------------- PRICE:" + String.format("($%.2f)", getPrice()) + "\n";
    }

    public static void chooseChip(Order order){
        System.out.print(ANSI_RED + """
                >>>>>>>> Select One Chips: <<<<<<<< \n""" + ANSI_RESET);
        int userInput = Utils.getIntInput(ANSI_ORANGE + """ 
                                          
                                 -------------
                                 Each ($1.50)
                                | 1) Cheetos  |
                                | 2) Doritos  |
                                | 3) Lays     |
                                | 4) Pringles |
                                 -------------
                 """ + ANSI_RESET, 0, 5);
        ChipsName chipsName = ChipsName.values()[userInput - 1];
        Chips chip = new Chips(chipsName);
        order.addItem(chip);
    }
}
