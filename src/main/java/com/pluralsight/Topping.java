package com.pluralsight;

import java.math.BigDecimal;

public abstract class Topping {
    private boolean isPremium;
    private final String name;

    public Topping( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    abstract BigDecimal getPriceForSize(Size size);
}
