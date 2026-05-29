package com.pluralsight.enums;

import java.math.BigDecimal;
import java.util.Map;
// Defines the available beverages and their fixed prices according to size.
public enum DrinkCategory {
    SMOOTHIE("Smoothie", Map.of(Size.SMALL, new BigDecimal("5.00"),
            Size.MEDIUM, new BigDecimal("6.50"),
            Size.LARGE, new BigDecimal("8.00"))),

    REFRESHER("Refresher", Map.of(Size.SMALL, new BigDecimal("4.00"),
            Size.MEDIUM, new BigDecimal("5.50"),
            Size.LARGE, new BigDecimal("6.60"))),

    BOTTLED_WATER("Waiakea Water", Map.of(Size.SMALL, new BigDecimal("2.50"),
            Size.LARGE, new BigDecimal("4.00"))),
    COFFEE("Coffee", Map.of(Size.SMALL, new BigDecimal("2.50"), Size.LARGE, new BigDecimal("5.50")));


    private final Map<Size, BigDecimal> prices;
    private final String displayName;

    DrinkCategory(String displayName, Map<Size, BigDecimal> prices) {
        this.prices = prices;
        this.displayName = displayName;

    }

    public String getDisplayName() {
        return displayName;
    }

    public BigDecimal priceFor(Size size) {
        return prices.get(size);
    }
}
