package com.pluralsight;
 // set the sizer and name of bowl and drink sizes
public enum Size {
    SMALl(12,"Classic"),
    MEDIUM(16,"Works"),
    LARGE(20,"The Oak");
// public so every class can see the variables
    public final int ounces;
    public final String displayName;

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
