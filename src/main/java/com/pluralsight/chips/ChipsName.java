package com.pluralsight.chips;

public enum ChipsName {
    CHEETOS("Cheetos"),DORITOS("Doritos"),LAYS("Lays"),PRINGLES("Pringles");

    private final String name;
    ChipsName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
