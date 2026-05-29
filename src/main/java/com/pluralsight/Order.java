package com.pluralsight;
// Order is the customer's shopping cart for ONE transaction.


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<OrderItem> items;
    private final LocalDateTime orderTime;

    public Order() {
        this.items = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }


    public LocalDateTime getOrderTime() {


        return this.orderTime;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : items) {
            total = total.add(item.getPrice());
        }
        return total;
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public void clear() {
        items.clear();
    }
}
