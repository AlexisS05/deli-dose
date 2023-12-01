package com.pluralsight.sandwich;

import com.pluralsight.order.OrderItem;
import com.pluralsight.toppings.Topping;
import com.pluralsight.utils.Utils;

import static com.pluralsight.utils.Utils.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderItem {
    private double price;
    private BreadType breadType;
    private SandwichSize size;
    private boolean isToasted;
    private static List<Topping> toppings;
    private static List<Topping> extras;
    private static List<Topping> sides;

    public Sandwich(BreadType breadType, SandwichSize size) {
        this.breadType = breadType;
        this.size = size;
        toppings = new ArrayList<>();
        extras = new ArrayList<>();
        sides = new ArrayList<>();
    }

    public Sandwich() {
    }

    public static void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public static void addExtra(Topping topping) {
        extras.add(topping);
    }

    public static void addSides(Topping topping){sides.add(topping);}

    public double getPrice(int a) {
        switch (size){
            case FOUR -> price = SandwichSize.FOUR.getPrice();
            case EIGHT -> price = SandwichSize.EIGHT.getPrice();
            case TWELVE -> price = SandwichSize.TWELVE.getPrice();
        }
        return price;
    }

    public static List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public double getPrice(){
        price = size.getPrice();
        for (Topping topping: toppings
        ) {
            if(size == SandwichSize.FOUR){
                price += topping.getPrice4Inch();
            } else if (size == SandwichSize.EIGHT){
                price += topping.getPrice8Inch();
            } else if (size == SandwichSize.TWELVE) {
                price += topping.getPrice12Inch();
            }
        }
        double extraPrice = getExtraPrice();
        return price + extraPrice;
    }

    private double getExtraPrice() {
        double extraPrice = 0;
        for(Topping extra : extras) {
            if (extras.contains(Topping.EXTRA_MEAT) || extras.contains(Topping.EXTRA_CHEESE)) {
                if (size == SandwichSize.FOUR) {
                    extraPrice += extra.getPrice4Inch();
                } else if (size == SandwichSize.EIGHT) {
                    extraPrice += extra.getPrice8Inch();
                } else if (size == SandwichSize.TWELVE) {
                    extraPrice += extra.getPrice12Inch();
                }
            }
        }
        return extraPrice;
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

    public static BreadType getBreadChoice(){
        BreadType bread = null;
        while (bread == null) {
            System.out.println("""
            >>>>>> Select your Bread Choice: <<<<<<<<<
                            ----------
                           | 1) WHITE |
                           | 2) WHEAT |
                           | 3) RYE   |
                           | 4) WRAP  |
                            ----------""");
            char breadChoice = Utils.getCharInput();
            switch (breadChoice) {
                case '1':
                    bread = BreadType.WHITE;
                    break;
                case '2':
                    bread = BreadType.WHEAT;
                    break;
                case '3':
                    bread = BreadType.RYE;
                    break;
                case '4':
                    bread = BreadType.WRAP;
                    break;
                default:
                    System.out.println("Please enter a valid bread choice (1, 2, 3, or 4): ");
            }
        }
        return bread;
    }

    public static SandwichSize getSandwichSize(){
        SandwichSize size = null;
        while (size == null) {
            System.out.println(ANSI_PINK + """
                    >>>>>>>> Select size of Sandwich: <<<<<<<<<<
                                  ------------------
                                 | 1) Four Inches   |
                                 | 2) Eight Inches  |
                                 | 3) Twelve Inches |
                                  ------------------""" + ANSI_RESET);
            char sizeChoice = Utils.getCharInput();
            switch (sizeChoice) {
                case '1':
                    size = SandwichSize.FOUR;
                    break;
                case '2':
                    size = SandwichSize.EIGHT;
                    break;
                case '3':
                    size = SandwichSize.TWELVE;
                    break;
                default:
                    System.out.println("Choose an appropriate sandwich size.");
            }
        }
        return size;
    }

    @Override
    public String getStringDetails() {
        StringBuilder receipt = new StringBuilder();

        receipt.append(String.format("%-22s %s\n", "SANDWICH:", "BREAD: " + getBreadType()));
        receipt.append(String.format("%-22s %s\n", "", "SIZE: " + getSize()));
        receipt.append(String.format("%-22s %s\n", "", "TOPPINGS: " + toppings));
        receipt.append(String.format("%-22s %s\n", "", "EXTRAS: " + extras));
        receipt.append(String.format("%-22s %s\n", "", "SIDES: " + sides));
        receipt.append(String.format("%-22s %s\n", "", "TOASTED: " + (isToasted ? "Yes" : "No")));

        receipt.append(String.format("%s PRICE:($%.2f)\n", "TOTAL: -----------------------------------------------------",getPrice()));

        return receipt.toString();
    }

    }

