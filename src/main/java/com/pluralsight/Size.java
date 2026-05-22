package com.pluralsight;
 // set the size and name of bowl and drink sizes
public enum Size {
    SMALL(12,"Classic"),
    MEDIUM(16,"Works"),
    LARGE(20,"The Oak");

    private final int ounces;
    private final String displayName;

    Size(int ounces, String displayName) {
        this.ounces = ounces;
        this.displayName = displayName;
    }
// getter so they can be called global
    public int getOunces() {
        return ounces;
    }

    public String getDisplayName(){
        return this.displayName;
    }
}
