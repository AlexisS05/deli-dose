package com.pluralsight.drink;

public class Drink {

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

}
