package com.pluralsight;

public enum Size {
    SMALl(12,"Classic"),
    MEDIUM(16,"Works"),
    LARGE(20,"The Oak");

    public final int ounces;
    public final String displayName;

    Size(int ounces, String displayName) {
        this.ounces = ounces;
        this.displayName = displayName;
    }

    public int getOunces() {
        return ounces;
    }

    public String getDisplayName(){
        return this.displayName;
    }
}
