package com.pluralsight;

import java.math.BigDecimal;

public class Snack extends Item{

    public Snack(String name, BigDecimal price, String sku) {
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
