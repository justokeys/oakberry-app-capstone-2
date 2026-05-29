package com.pluralsight;

import com.pluralsight.enums.Size;

import java.math.BigDecimal;
//Represents an abstract foundation for all food and beverage toppings
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
