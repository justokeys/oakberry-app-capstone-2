package com.pluralsight.enums;

import com.pluralsight.PremiumTopping;
// Defines the available premium toppings and their fixed category
public enum PremiumToppingMenu {
    ALMOND_BUTTER("Almond Butter", PremiumCategory.NUT_BUTTER),
    WHEY_PROTEIN("Whey Protein", PremiumCategory.PROTEIN),
    VEGAN_PROTEIN("Vegan Protein", PremiumCategory.PROTEIN),
    PISTACHIO_DRIZZLE("Pistachio Drizzle", PremiumCategory.NUT_BUTTER),
    HAZELNUT_DRIZZLE("Hazelnut Drizzle", PremiumCategory.NUT_BUTTER),
    IM8_ULTIMATE("I*M*8", PremiumCategory.SUPERFOOD);


    private final String displayName;
    private final PremiumCategory category;


    PremiumToppingMenu(String displayName, PremiumCategory category) {
        this.displayName = displayName;
        this.category = category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public PremiumCategory getCategory() {
        return category;
    }

    public PremiumTopping toTopping() {
        return new PremiumTopping(displayName, category);
    }
}
