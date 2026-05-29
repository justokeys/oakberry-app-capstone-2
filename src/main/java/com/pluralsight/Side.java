package com.pluralsight;

import com.pluralsight.enums.SideType;
import com.pluralsight.enums.Size;

import java.math.BigDecimal;
// Side represents a flat-priced side item. Extends Item so it can be
// added to an Order alongside bowls and drinks.
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
