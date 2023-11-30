package com.pluralsight.chips;

import com.pluralsight.order.OrderItem;

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
        return  "CHIPS: " + name.getName() + " --------------------------------------------- PRICE: " + String.format("($%.2f)", getPrice()) + "\n";
    }
}
