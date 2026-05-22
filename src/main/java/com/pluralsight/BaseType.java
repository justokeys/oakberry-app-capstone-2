package com.pluralsight;

public enum BaseType {
    STANDARD(0,"Acai"),
    GREENWELLNESS(1.50,"Acai + Green-Superfood Blend"),
    IM8MIXEDBERRY(1.50,"Acai + I*M*8 Berry Blend");

    public final double acaiBaseUpcharge;
    public final String acaiBase;

    BaseType(double acaiBaseUpcharge, String acaiBase) {
        this.acaiBaseUpcharge = acaiBaseUpcharge;
        this.acaiBase = acaiBase;
    }

    public double getAcaiBaseUpcharge() {
        return acaiBaseUpcharge;
    }

    public String getAcaiBase() {
        return acaiBase;
    }
}
