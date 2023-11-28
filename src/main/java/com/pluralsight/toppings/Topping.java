package com.pluralsight.toppings;

public enum Topping {
    // Meats
    STEAK("Meat", 2.50, 1.00, 2.00, 3.00),
    HAM("Meat", 1.80, 1.00, 2.00, 3.00),
    SALAMI("Meat", 1.90, 1.00, 2.00, 3.00),
    ROAST_BEEF("Meat", 2.20, 1.00, 2.00, 3.00),
    CHICKEN("Meat", 2.00, 1.00, 2.00, 3.00),
    BACON("Meat", 2.50, 1.00, 2.00, 3.00),

    // Extra Meat
    EXTRA_MEAT("Meat", 3.00, 0.50, 1.00, 1.50),

    // Cheese
    AMERICAN("Cheese", 1.50, 0.75, 1.50, 2.25),
    PROVOLONE("Cheese", 1.60, 0.75, 1.50, 2.25),
    CHEDDAR("Cheese", 1.70, 0.75, 1.50, 2.25),
    SWISS("Cheese", 1.80, 0.75, 1.50, 2.25),

    // Extra Cheese
    EXTRA_CHEESE("Cheese", 2.00, 0.30, 0.60, 0.90),

    // Regular Toppings
    LETTUCE("Regular Topping", 0.50),
    PEPPERS("Regular Topping", 0.40),
    ONIONS("Regular Topping", 0.30),
    TOMATOES("Regular Topping", 0.60),
    JALAPENOS("Regular Topping", 0.70),
    CUCUMBERS("Regular Topping", 0.50),
    PICKLES("Regular Topping", 0.40),
    GUACAMOLE("Regular Topping", 1.20),
    MUSHROOMS("Regular Topping", 0.80),

    // Sauces
    MAYO("Sauce", 0.20),
    MUSTARD("Sauce", 0.15),
    KETCHUP("Sauce", 0.25),
    RANCH("Sauce", 0.40),
    THOUSAND_ISLANDS("Sauce", 0.35),
    VINAIGRETTE("Sauce", 0.45);

    private final String category;
    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;

    // Constructor for meats and cheeses
    Topping(String category, double price, double price4Inch, double price8Inch, double price12Inch) {
        this.category = category;
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
    }

    // Constructor for regular toppings and sauces
    Topping(String category, double price) {
        this(category, price, 0.0, 0.0, 0.0);
    }

    public String getCategory() {
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


