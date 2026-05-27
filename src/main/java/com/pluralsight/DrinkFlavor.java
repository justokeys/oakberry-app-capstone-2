package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public enum DrinkFlavor {

    // Smoothie flavors
    MANGO_TANGO("Mango Tango", DrinkCategory.SMOOTHIE),
    MIXED_BERRY("Mixed Berry", DrinkCategory.SMOOTHIE),
    STRAWBERRY_COCONUT("Strawberry Coconut", DrinkCategory.SMOOTHIE),
    GREEN_MACHINE("Green Machine", DrinkCategory.SMOOTHIE),
    PINEAPPLE_CRUSH("Pineapple Crush", DrinkCategory.SMOOTHIE),
    PEANUT_BUTTER_POWER("Peanut Butter Power", DrinkCategory.SMOOTHIE),
    //Coffee flavors
    VANILLA_LATTE("Vanilla Latte", DrinkCategory.COFFEE),
    ICED_MOCHA("Iced Mocha", DrinkCategory.COFFEE),
    CARAMEL_MACCHIATO("Caramel Macchiato", DrinkCategory.COFFEE),
    COLD_BREW("Cold Brew", DrinkCategory.COFFEE),
    AMERICANO("Americano", DrinkCategory.COFFEE),
    FLAT_WHITE("Flat White", DrinkCategory.COFFEE),
    // Refresher flavors
    STRAWBERRY_REFRESHER("Strawberry", DrinkCategory.REFRESHER),
    LIME_REFRESHER("Lime", DrinkCategory.REFRESHER),
    MANGO_DRAGONFRUIT("Mango Dragonfruit", DrinkCategory.REFRESHER),
    PASSION_FRUIT_LEMONADE("Passion Fruit Lemonade", DrinkCategory.REFRESHER),
    WATERMELON_MINT("Watermelon Mint", DrinkCategory.REFRESHER),
    PEACH_GREEN_TEA("Peach Green Tea", DrinkCategory.REFRESHER),

    // Bottled water
    WAIAKEA_STILL("Still Water", DrinkCategory.BOTTLED_WATER),
    WAIAKEA_SPARKLING("Sparkling Water", DrinkCategory.BOTTLED_WATER);

    private final String displayName;
    private final DrinkCategory category;


    DrinkFlavor(String displayName, DrinkCategory drinkCategory) {
        this.displayName = displayName;
        this.category = drinkCategory;
    }

    public String getDisplayName() {
        return displayName;
    }

    public DrinkCategory getCategory() {
        return category;
    }

    public static List<DrinkFlavor> flavorsFor(DrinkCategory category) {
        List<DrinkFlavor> matches = new ArrayList<>();

        for (DrinkFlavor drink : DrinkFlavor.values()) {
            if (drink.getCategory() == category) {
                matches.add(drink);
            }
        }
        return matches;
    }


}
