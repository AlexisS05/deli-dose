package com.pluralsight.drink;

public enum DrinkName {
    COKE("Coke"),SPRITE("Sprite"),GINGERALE("Gingerale"),WATER("water");
    private final String name;
    DrinkName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }





    // Missing one more thing
}
