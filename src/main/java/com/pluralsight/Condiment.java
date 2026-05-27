package com.pluralsight;

import java.math.BigDecimal;

public class Condiment extends Topping{
    public Condiment( String name) {
        super(name);

    }

    @Override
    BigDecimal getPriceForSize(Size size) {
        return BigDecimal.ZERO;
    }
}
