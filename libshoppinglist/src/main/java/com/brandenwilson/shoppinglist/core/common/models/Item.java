package com.brandenwilson.shoppinglist.core.common.models;

public class Item {

    public final String name;
    public final int quantity;
    public final String notes;
    public final boolean checked;

    public Item(String name) {
        this(name, 1, "", false);
    }

    public Item(String name, int quantity, String notes, boolean checked) {
        this.name = name;
        this.quantity = quantity;
        this.notes = notes;
        this.checked = checked;
    }
}
