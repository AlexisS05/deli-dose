package com.pluralsight.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<String> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}
