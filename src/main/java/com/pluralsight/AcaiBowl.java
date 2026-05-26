package com.pluralsight;

import java.math.BigDecimal;

public class AcaiBowl extends Item{


    protected AcaiBowl(String name, String sku, Size size) {
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
