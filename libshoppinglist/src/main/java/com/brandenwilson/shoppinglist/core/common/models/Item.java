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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (checked != item.checked) return false;
        if (quantity != item.quantity) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (notes != null ? !notes.equals(item.notes) : item.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (checked ? 1 : 0);
        return result;
    }
}
