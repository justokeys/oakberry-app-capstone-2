package com.pluralsight;

import java.math.BigDecimal;

public abstract class Topping {
    private final String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    abstract BigDecimal getPriceForSize(Size size);
}
