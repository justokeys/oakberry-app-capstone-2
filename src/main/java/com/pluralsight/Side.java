package com.pluralsight;

import java.math.BigDecimal;

public class Side extends Item {
    private final SideType type;


    public Side(SideType type) {
        super("Side", Size.NONE);
        this.type = type;
    }

    @Override
    public BigDecimal getPrice() {
        return type.getPrice();
    }

    @Override
    public String getDescription() {
        return type.getDisplayName();
    }
}
