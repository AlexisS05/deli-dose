package com.pluralsight.order;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderInterface{
    private final List<OrderInterface> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderInterface item) {
        items.add(item);
    }

    public List<OrderInterface> getItems() {
        return items;
    }

    @Override
    public String getStringDetails() {
        return null;
    }
}
