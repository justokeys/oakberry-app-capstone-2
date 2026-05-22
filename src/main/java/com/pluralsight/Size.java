package com.pluralsight;

// set the size and name of bowl and drink sizes
public enum Size {
    SMALL(12, "Classic", "Small"),
    MEDIUM(16, "Works", "Medium"),
    LARGE(20, "The Oak", "Large");

    private final int ounces;
    private final String displayName;
    private final String sizeLabel;

    Size(int ounces, String displayName, String sizeLabel) {
        this.ounces = ounces;
        this.displayName = displayName;
        this.sizeLabel = sizeLabel;
    }


    // getter so they can be called global
    public int getOunces() {
        return this.ounces;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getSizeLabel() {
        return sizeLabel;
    }
}
