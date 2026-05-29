package com.pluralsight;

import com.pluralsight.enums.Size;
// ABSTRACT class to force inheritance and ensure I can add all children to common list for check out
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
