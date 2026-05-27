package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AcaiBowl extends Item {

    private final List<Topping> toppings;
    private final BaseType base;
    private boolean hempBoost;

    private static final Map<Size, BigDecimal> HEMP_FEES = Map.of(
            Size.SMALL, new BigDecimal("1.00"),
            Size.MEDIUM, new BigDecimal("1.50"),
            Size.LARGE, new BigDecimal("2.00")
    );

    private static final Map<Size, BigDecimal> BASE_PRICES = Map.of(
            Size.SMALL, new BigDecimal("9.00"),
            Size.MEDIUM, new BigDecimal("10.00"),
            Size.LARGE, new BigDecimal("12.00")
    );

    public void setHempBoost(boolean hempBoost) {
        this.hempBoost = hempBoost;
    }

    public AcaiBowl(Size size, BaseType base) {
        super("Acai Bowl", size);
        this.base = base;
        this.toppings = new ArrayList<>();
        this.hempBoost = false;
    }


    public BaseType getBase() {
        return base;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);

    }


    @Override
    public BigDecimal getPrice() {
        BigDecimal total = BASE_PRICES.get(getSize());
        total = total.add(base.getAcaiBaseUpcharge());

        for (Topping topping : toppings) {
            total = total.add(topping.getPriceForSize(getSize()));
        }
        if (hempBoost) {
            total = total.add(HEMP_FEES.get(getSize()));
        }
        return total;
    }

    public boolean isHempBoost() {
        return hempBoost;
    }

    @Override
    public String getDescription() {
        StringBuilder aBowl = new StringBuilder();
        aBowl.append(getSize()).append(" ").append(getName()).append(" ").append("(").append(base.getAcaiBase()).append(")");
        for (Topping topping : toppings) {
            aBowl.append("\n + ").append(topping.getName());
        }

        if (hempBoost) {
            aBowl.append("\n + ").append("Hemp Seed Boost");
        }


        return aBowl.toString();
    }


}
