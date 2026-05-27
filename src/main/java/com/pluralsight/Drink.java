package com.pluralsight;


import java.math.BigDecimal;

public class Drink extends Item {
    private final DrinkFlavor flavor;

    public Drink(Size size, DrinkFlavor flavor) {
        super("Drink", size);
        this.flavor = flavor;
    }

    public DrinkFlavor getFlavor() {

        return this.flavor;
    }

    @Override
    public BigDecimal getPrice() {

        return flavor.getCategory().priceFor(getSize());
    }

    @Override
    public String getDescription() {

        return getSize().getSizeLabel() + " " + flavor.getCategory().getDisplayName() + " - " + flavor.getDisplayName();
    }
}
