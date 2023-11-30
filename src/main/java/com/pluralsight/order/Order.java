package com.pluralsight.order;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderItem {
    private final List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void clear(){
        this.items.clear();
    }

    @Override
    public String getStringDetails() {
        StringBuilder receipt = new StringBuilder();
        for(OrderItem item : items){
            receipt.append(item.getStringDetails()).append("\n");
        }
        return receipt.toString();
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
