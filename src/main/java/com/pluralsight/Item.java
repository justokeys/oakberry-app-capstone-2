package com.pluralsight;

import java.math.BigDecimal;

public abstract class Item implements OrderItem {
    private final String name;
    private final String sku;

    private final Size size;

    protected Item(String name, String sku, Size size) {
        this.name = name;
        this.size = size;
        this.sku = sku;
    }

    public String getName() {
        return this.name;
    }

    public String getSku(){
        return this.sku;
    }

    public Size getSize(){
        return this.size;
    }
}
