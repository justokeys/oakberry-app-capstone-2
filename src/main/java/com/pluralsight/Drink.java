package com.pluralsight;

import java.math.BigDecimal;

public class Drink extends Item {
    public Drink(String name, BigDecimal price, String sku) {
        super(name, price, sku);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String name() {
        return "";
    }
}
