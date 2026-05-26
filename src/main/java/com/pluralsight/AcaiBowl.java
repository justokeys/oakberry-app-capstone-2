package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class AcaiBowl extends Item{

    private final ArrayList<Topping> toppings;
    private final BaseType base;
    private final boolean  hempBoost;


    AcaiBowl(Size size, ArrayList<Topping> toppings, BaseType base) {
        super("Acai bowl", size);
        this.base = base;
        this.toppings = new ArrayList<>();
        this.hempBoost = false;
    }
    private static final Map<Size,BigDecimal> HEMP_FEES = Map.of(
            Size.SMALL, new BigDecimal("1.00"),
            Size.MEDIUM, new BigDecimal("1.50"),
            Size.LARGE, new BigDecimal("2.00")
    );

    private static final Map<Size, BigDecimal> BASE_PRICES = Map.of(
            Size.SMALL , new BigDecimal("9.00"),
            Size.MEDIUM, new BigDecimal("10.00"),
            Size.LARGE, new BigDecimal("12.00")
    );


    public BaseType getBase() {
        return base;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);

    }


    @Override
    public BigDecimal getPrice() {
        BigDecimal total = BASE_PRICES.get(getSize());
        total = total.add(base.getAcaiBaseUpcharge());

        for (Topping  topping: toppings){
            total = total.add(topping.getPriceForSize(getSize()));
        }
        if (hempBoost){
            total = total.add(HEMP_FEES.get(getSize()));
        }
        return total;
    }

    @Override
    public String getDescription() {
        return "";
    }

    public boolean getHempBoost() {
        return hempBoost;
    }



}
