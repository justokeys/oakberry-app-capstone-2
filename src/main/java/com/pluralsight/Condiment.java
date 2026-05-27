package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;

public class Condiment extends Topping{
    public Condiment( String name) {
        super("Drizzle");

    }
    private static final List<Condiment> MENU = List.of(
            new Condiment("Honey"),
            new Condiment("Peanut butter")
    );

    @Override
    BigDecimal getPriceForSize(Size size) {
        return BigDecimal.ZERO;
    }
}
