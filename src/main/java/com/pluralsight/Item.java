package com.pluralsight;

import java.math.BigDecimal;

public abstract class Item implements OrderItem {
    private final String name;

    private final String sku;

    protected Item(String name, String sku) {
        this.name = name;
        this.sku = sku;
    }

    abstract String getName();


    abstract String getSize() ;




}
