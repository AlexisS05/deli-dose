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

    public void clear(){
        this.items.clear();
    }

    @Override
    public String getStringDetails() {
        StringBuilder receipt = new StringBuilder();
        for(OrderInterface item : items){
            receipt.append(item.getStringDetails()).append("\n");
        }
        return receipt.toString();
    }
}
