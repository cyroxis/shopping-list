package com.brandenwilson.shoppinglist.core.modules.itemdetail;

import com.brandenwilson.shoppinglist.core.common.models.Item;

public interface ItemDetailView {
    void showItem(Item item);

    public interface InteractionHandler {
        void registerView(ItemDetailView itemDetailView);
        void updateView();
    }
}
