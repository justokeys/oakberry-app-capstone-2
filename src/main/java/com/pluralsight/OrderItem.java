package com.pluralsight;

import java.math.BigDecimal;

public interface OrderItem {

    BigDecimal getPrice();

    String getDescription();

    String name();
}
