package com.pluralsight;

import java.math.BigDecimal;

public class Snack extends Item{


    protected Snack(String name, String sku, Size size) {
        super(name, sku, size);
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
