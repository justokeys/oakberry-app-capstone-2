package com.pluralsight.enums;

import java.math.BigDecimal;

// set the Base acai mix of  the bowls and there upcharge price
public enum BaseType {
    STANDARD(new BigDecimal("0"), "Acai"),
    // BigDecimal is more accurate and has better use case for currency for validation purposes
    GREEN_WELLNESS(new BigDecimal("1.50"), "Acai + Green-Superfood Blend"),
    IM8_MIXED_BERRY(new BigDecimal("1.50"), "Acai + I*M*8 Berry Blend");

    private final BigDecimal acaiBaseUpcharge;
    private final String acaiBase;

    BaseType(BigDecimal acaiBaseUpcharge, String acaiBase) {
        this.acaiBaseUpcharge = acaiBaseUpcharge;
        this.acaiBase = acaiBase;
    }

    // getter so they can be called global
    public BigDecimal getAcaiBaseUpcharge() {
        return this.acaiBaseUpcharge;
    }

    public String getAcaiBase() {
        return this.acaiBase;
    }
}
