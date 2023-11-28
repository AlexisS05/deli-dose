package com.pluralsight.toppings;

public enum Topping {
    // Meats
    STEAK(ToppingType.MEAT, 2.50, 1.00, 2.00, 3.00),
    HAM(ToppingType.MEAT, 1.80, 1.00, 2.00, 3.00),
    SALAMI(ToppingType.MEAT, 1.90, 1.00, 2.00, 3.00),
    ROAST_BEEF(ToppingType.MEAT, 2.20, 1.00, 2.00, 3.00),
    CHICKEN(ToppingType.MEAT, 2.00, 1.00, 2.00, 3.00),
    BACON(ToppingType.MEAT, 2.50, 1.00, 2.00, 3.00),

    // Extra Meat
    EXTRA_MEAT(ToppingType.EXTRA, 3.00, 0.50, 1.00, 1.50),

    // Cheese
    AMERICAN(ToppingType.CHEESE, 1.50, 0.75, 1.50, 2.25),
    PROVOLONE(ToppingType.CHEESE, 1.60, 0.75, 1.50, 2.25),
    CHEDDAR(ToppingType.CHEESE, 1.70, 0.75, 1.50, 2.25),
    SWISS(ToppingType.CHEESE, 1.80, 0.75, 1.50, 2.25),

    // Extra Cheese
    EXTRA_CHEESE(ToppingType.EXTRA, 2.00, 0.30, 0.60, 0.90),

    // Regular Toppings
    LETTUCE(ToppingType.REGULAR, 0.50),
    PEPPERS(ToppingType.REGULAR, 0.40),
    ONIONS(ToppingType.REGULAR, 0.30),
    TOMATOES(ToppingType.REGULAR, 0.60),
    JALAPENOS(ToppingType.REGULAR, 0.70),
    CUCUMBERS(ToppingType.REGULAR, 0.50),
    PICKLES(ToppingType.REGULAR, 0.40),
    GUACAMOLE(ToppingType.REGULAR, 1.20),
    MUSHROOMS(ToppingType.REGULAR, 0.80),

    // Sauces
    MAYO(ToppingType.SAUCE, 0.20),
    MUSTARD(ToppingType.SAUCE, 0.15),
    KETCHUP(ToppingType.SAUCE, 0.25),
    RANCH(ToppingType.SAUCE, 0.40),
    THOUSAND_ISLANDS(ToppingType.SAUCE, 0.35),
    VINAIGRETTE(ToppingType.SAUCE, 0.45);

    private final ToppingType category;
    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;

    // Constructor for meats and cheeses
    Topping(ToppingType category, double price, double price4Inch, double price8Inch, double price12Inch) {
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


