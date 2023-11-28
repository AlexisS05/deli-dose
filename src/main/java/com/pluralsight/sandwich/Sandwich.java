package com.pluralsight.sandwich;

import com.pluralsight.order.OrderInterface;
import com.pluralsight.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderInterface {
    private double price;
    private BreadType breadType;
    private SanwichSize size;
    private boolean isToasted;
    private static List<Topping> toppings;
    private static List<Topping> extras;

    public Sandwich(BreadType breadType, SanwichSize size) {
        this.breadType = breadType;
        this.size = size;
        toppings = new ArrayList<>();
        extras = new ArrayList<>();
    }

    public static void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public static void addExtra(Topping topping) {
        extras.add(topping);
    }

    public double getPrice() {
        switch (size){
            case FOUR -> price = SanwichSize.FOUR.getPrice();
            case EIGHT -> price = SanwichSize.EIGHT.getPrice();
            case TWELVE -> price = SanwichSize.TWELVE.getPrice();
        }
        return price;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public SanwichSize getSize() {
        return size;
    }

    public boolean isToasted() {
        return isToasted;
    }


    @Override
    public String getStringDetails() {
        return  "BREAD: " + getBreadType() + "\n" +
                "SIZE: " + getSize() + "\n" +
                "PRICE: " + getPrice() + "\n" +
                "TOPPINGS: " + toppings + "\n" +
                "EXTRAS: " + extras + "\n";
    }
}
