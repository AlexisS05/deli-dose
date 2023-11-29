package com.pluralsight.chips;

import com.pluralsight.order.OrderInterface;

public class Chips implements OrderInterface {
    private final ChipsName name;


    public Chips(ChipsName name) {
        this.name = name;
    }

    public double getPrice() {
        return 1.50;
    }

    public ChipsName getName() {
        return name;
    }

    @Override
    public String getStringDetails() {
        return  "CHIPS: " + name.getName() + "\n" +
                "CHIPS PRICE: " + getPrice();
    }
}
