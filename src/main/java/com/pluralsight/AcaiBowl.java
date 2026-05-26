package com.pluralsight;

import java.math.BigDecimal;

public class AcaiBowl extends Item{

    public AcaiBowl(String name, BigDecimal price, String sku) {
        super(name, price, sku);
    }

    @Override
    BigDecimal getPrice() {
        return null;
    }

    @Override
    String getSize() {
        return "";
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
