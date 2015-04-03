package com.brandenwilson.shoppinglist.core.modules.items;

import com.brandenwilson.shoppinglist.core.common.models.Item;

import java.util.Collections;
import java.util.List;

public class ItemsViewModel {

    public final List<Item> items;

    public ItemsViewModel(List<Item> items) {
        this.items = Collections.unmodifiableList(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsViewModel that = (ItemsViewModel) o;

        if (items != null ? !items.equals(that.items) : that.items != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return items != null ? items.hashCode() : 0;
    }
}
