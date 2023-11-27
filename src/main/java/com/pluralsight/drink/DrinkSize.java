package com.pluralsight.drink;

public enum DrinkSize {
    SMALL(2.00), MEDIUM(2.50), LARGE(3.00);
    private final double price;

    public double getPrice() {
        return price;
    }

    DrinkSize(double price) {
        this.price = price;
    }
}
