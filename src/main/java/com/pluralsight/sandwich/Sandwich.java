package com.pluralsight.sandwich;

import com.pluralsight.order.OrderInterface;
import com.pluralsight.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderInterface {
    private double price;
    private BreadType breadType;
    private SandwichSize size;
    private boolean isToasted;
    private static List<Topping> toppings;
    private static List<Topping> extras;

    public Sandwich(BreadType breadType, SandwichSize size) {
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
            case FOUR -> price = SandwichSize.FOUR.getPrice();
            case EIGHT -> price = SandwichSize.EIGHT.getPrice();
            case TWELVE -> price = SandwichSize.TWELVE.getPrice();
        }
        return price;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public SandwichSize getSize() {
        return size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    @Override
    public String getStringDetails() {
        return  "BREAD: " + getBreadType() + "\n" +
                "SIZE: " + getSize() + "\n" +
                "PRICE: " + getPrice() + "\n" +
                "TOPPINGS: " + toppings + "\n" +
                "EXTRAS: " + extras + "\n" +
                "TOASTED: " + (isToasted ? "Yes" : "No") + "\n";
    }
}
