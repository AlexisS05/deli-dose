package com.pluralsight.sandwich;

public enum SanwichSize {
    FOUR(5.50), EIGHT(7.00), TWELVE(8.50);
    private final double price;

    public double getPrice() {
        return price;
    }

    SanwichSize(double price) {
        this.price = price;

    }
}
