package com.pluralsight;

import java.math.BigDecimal;
import java.util.Map;
public enum PremiumCategory {
    NUT_BUTTER(Map.of(Size.SMALL, new BigDecimal("1.00"),
            Size.MEDIUM, new BigDecimal("1.50"),
            Size.LARGE, new BigDecimal("2.00"))),

    PROTEIN(Map.of(Size.SMALL, new BigDecimal("2.00"),
            Size.MEDIUM, new BigDecimal("2.50"),
            Size.LARGE, new BigDecimal("3.50"))),

    SUPERFOOD(Map.of(Size.SMALL, new BigDecimal("1.50"),
            Size.MEDIUM, new BigDecimal("2.00"),
            Size.LARGE, new BigDecimal("3.00")));


    private final Map<Size, BigDecimal> prices;

    PremiumCategory(Map<Size, BigDecimal> prices) {
        this.prices = prices;

    }


    public BigDecimal priceFor(Size size) {
        return prices.get(size);
    }
}
