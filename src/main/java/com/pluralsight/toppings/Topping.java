package com.pluralsight.toppings;

public enum Topping {
    // Meats
    STEAK(ToppingType.MEAT, 0.00, 1.00, 2.00, 3.00),
    HAM(ToppingType.MEAT, 0.00, 1.00, 2.00, 3.00),
    SALAMI(ToppingType.MEAT, 0.00, 1.00, 2.00, 3.00),
    ROAST_BEEF(ToppingType.MEAT, 0.00, 1.00, 2.00, 3.00),
    CHICKEN(ToppingType.MEAT, 0.00, 1.00, 2.00, 3.00),
    BACON(ToppingType.MEAT, 0.00, 1.00, 2.00, 3.00),


    // Cheese
    AMERICAN(ToppingType.CHEESE, 0.00, 0.75, 1.50, 2.25),
    PROVOLONE(ToppingType.CHEESE, 0.00, 0.75, 1.50, 2.25),
    CHEDDAR(ToppingType.CHEESE, 0.00, 0.75, 1.50, 2.25),
    SWISS(ToppingType.CHEESE, 0.00, 0.75, 1.50, 2.25),

    // Extra Cheese
    EXTRA_CHEESE(ToppingType.EXTRA, 0.00, 0.30, 0.60, 0.90),

    // Extra Meat
    EXTRA_MEAT(ToppingType.EXTRA, 0.00, 0.50, 1.00, 1.50),

    // Regular Toppings Free
    LETTUCE(ToppingType.REGULAR, 0.00),
    PEPPERS(ToppingType.REGULAR, 0.00),
    ONIONS(ToppingType.REGULAR, 0.00),
    TOMATOES(ToppingType.REGULAR, 0.00),
    JALAPENOS(ToppingType.REGULAR, 0.00),
    CUCUMBERS(ToppingType.REGULAR, 0.00),
    PICKLES(ToppingType.REGULAR, 0.00),
    GUACAMOLE(ToppingType.REGULAR, 0.00),
    MUSHROOMS(ToppingType.REGULAR, 0.00),

    // Sauces
    MAYO(ToppingType.SAUCE, 0.00),
    MUSTARD(ToppingType.SAUCE, 0.00),
    KETCHUP(ToppingType.SAUCE, 0.00),
    RANCH(ToppingType.SAUCE, 0.00),
    THOUSAND_ISLANDS(ToppingType.SAUCE, 0.00),
    VINAIGRETTE(ToppingType.SAUCE, 0.00),

    // Sides
    AU_JUS(ToppingType.SIDES, 0.00),
    MASHED_POTATOES(ToppingType.SIDES, 0.00),
    MAC_AND_CHEESE(ToppingType.SIDES, 0.00),
    GARLIC_BREAD(ToppingType.SIDES, 0.00);

    private final ToppingType category;
    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;
    private final double price;

    // Constructor for meats and cheeses
    Topping(ToppingType category, double price, double price4Inch, double price8Inch, double price12Inch) {
        this.price = price;
        this.category = category;
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
    }

    // Constructor for regular toppings and sauces
    Topping(ToppingType category, double price) {
        this(category, price, 0.0, 0.0, 0.0);
    }

    public ToppingType getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getPrice4Inch() {
        return price4Inch;
    }

    public double getPrice8Inch() {
        return price8Inch;
    }

    public double getPrice12Inch() {
        return price12Inch;
    }
}


