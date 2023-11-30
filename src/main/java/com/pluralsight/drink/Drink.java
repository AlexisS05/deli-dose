package com.pluralsight.drink;

import com.pluralsight.order.OrderItem;

public class Drink implements OrderItem {

    private final DrinkSize size;

    private final DrinkName name;

    public Drink(DrinkSize size, DrinkName name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public String getStringDetails() {
        return "DRINK: " + size + ", " + name.getName() + " ------------------- PRICE" + String.format("($%.2f)", getPrice());
    }

    @Override
    public double getPrice() {
       return size.getPrice();
    }
}
