package com.pluralsight.sandwich;

public enum SandwichSize {
    FOUR(5.50), EIGHT(7.00), TWELVE(8.50);
    private final double price;

    public double getPrice() {
        return price;
    }

    SandwichSize(double price) {
        this.price = price;

    }
}
