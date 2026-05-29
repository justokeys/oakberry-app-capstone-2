package com.pluralsight;

import com.pluralsight.enums.PremiumCategory;
import com.pluralsight.enums.Size;

import java.math.BigDecimal;

public class PremiumTopping extends Topping {
    private final PremiumCategory premiumCategory;

    public PremiumTopping(String name, PremiumCategory category) {
        super(name);
        this.premiumCategory = category;
    }

    public PremiumCategory getPremiumCategory() {
        return premiumCategory;
    }


    @Override
    BigDecimal getPriceForSize(Size size) {
        return premiumCategory.priceFor(size);
    }
}
