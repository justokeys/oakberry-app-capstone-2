package com.pluralsight;

import java.math.BigDecimal;

public class PremiumTopping extends Topping{
    private final PremiumCategory premiumCategory;

    public PremiumTopping( String name , PremiumCategory category ) {
        super(name);
        this.premiumCategory = category;
    }

    public PremiumCategory getPremiumCategory() {
        return premiumCategory;
    }

    @Override
    public boolean isPremium() {
        return super.isPremium();
    }

    @Override
    BigDecimal getPriceForSize(Size size) {
         return premiumCategory.priceFor(size);
    }
}
