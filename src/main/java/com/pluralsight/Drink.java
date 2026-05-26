package com.pluralsight;

import java.math.BigDecimal;

public class Drink extends Item {

    protected Drink(String name, Size size) {
        super(name, size);
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
