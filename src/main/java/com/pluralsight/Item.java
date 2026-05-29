package com.pluralsight;

public abstract class Item implements OrderItem {
    private final String name;

    private final Size size;

    protected Item(String name, Size size) {
        this.name = name;
        this.size = size;

    }

    public String getName() {
        return this.name;
    }


    public Size getSize() {
        return this.size;
    }
}
