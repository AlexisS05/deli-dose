package com.pluralsight.drink;

import com.pluralsight.order.OrderInterface;

public class Drink implements OrderInterface {

    private final DrinkSize size;

    private final DrinkName name;

    @Override
    public String toString() {
        return "Drink{" +
                "size=" + size +
                ", name=" + name +
                '}';
    }

    public Drink(DrinkSize size, DrinkName name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public String getStringDetails() {
        return "DRINK: " + size + ", " + name.getName();
    }
}
