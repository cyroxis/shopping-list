package com.brandenwilson.shoppinglist.core.modules.itemdetail;

import com.brandenwilson.shoppinglist.core.common.models.Item;

public class ItemDetailInteractor {

    private final Item item;
    private Callback callback;

    public ItemDetailInteractor(Item item) {
        this.item = item;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void loadItemDetail() {
        callback.itemDetailLoaded(item);
    }

    public interface Callback {
        void itemDetailLoaded(Item item);
    }
}
