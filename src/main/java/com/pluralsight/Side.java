package com.pluralsight;

import java.math.BigDecimal;

public class Side extends Item{


    protected Side(String name, Size size) {
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
