package com.pluralsight;

import java.math.BigDecimal;
// set the Base acai mix of  the bowls and there upcharge price
public enum BaseType {
    STANDARD(BigDecimal.valueOf(0) ,"Acai"),
    // BigDecimal is more accurate and has better use case for currency for validation purposes
    GREEN_WELLNESS(BigDecimal.valueOf(1.50) ,"Acai + Green-Superfood Blend"),
    IM8_MIXED_BERRY(BigDecimal.valueOf(1.50) ,"Acai + I*M*8 Berry Blend");

    private final BigDecimal acaiBaseUpcharge;
    private final String acaiBase;

    BaseType(BigDecimal acaiBaseUpcharge, String acaiBase) {
        this.acaiBaseUpcharge = acaiBaseUpcharge;
        this.acaiBase = acaiBase;
    }

    public BigDecimal getAcaiBaseUpcharge() {
        return acaiBaseUpcharge;
    }

    public String getAcaiBase() {
        return acaiBase;
    }
}
