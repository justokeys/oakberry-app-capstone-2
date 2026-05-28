package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegularTopping extends Topping {
    public RegularTopping( String name) {
        super(name);
    }
    public static final List<RegularTopping> MENU = List.of(
            new RegularTopping("Strawberry"),
            new RegularTopping("Banana"),
            new RegularTopping("Blueberry"),
            new RegularTopping("Passion Fruit"),
            new RegularTopping("Cocoa Nibs"),
            new RegularTopping("Granola"),
            new RegularTopping("Chia Pudding"),
            new RegularTopping("Chia Seeds"),
            new RegularTopping("Coconut Flakes"),
            new RegularTopping("Peanut Butter"),
            new RegularTopping("Almond Flakes"),
            new RegularTopping("Honey"),
            new RegularTopping("Goji Berries"),
            new RegularTopping("Vegan Granola"),
            new RegularTopping("Milk Powder"),
            new RegularTopping("Peanut Butter")

    );


    @Override
    BigDecimal getPriceForSize(Size size) {
        return BigDecimal.ZERO;
    }
}
