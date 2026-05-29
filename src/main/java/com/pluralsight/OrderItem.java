package com.pluralsight;

import java.math.BigDecimal;
// Interface makes sure every item price and description methods
public interface OrderItem {

    BigDecimal getPrice();

    String getDescription();

}
