package com.pluralsight;

import java.math.BigDecimal;

public enum SideType {
    OAK_BAR("OakBar", new BigDecimal("3.50")),
    GRANOLA("Organic Granola", new BigDecimal("3.00")),
    PEANUT_BUTTER_BITES("Organic Peanut Bites", new BigDecimal("8.95"));

    private final String displayName;
    private final BigDecimal price;


    SideType(String displayName, BigDecimal price) {
        this.price = price;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
