package com.brandenwilson.shoppinglist.core.modules.items;

import com.brandenwilson.shoppinglist.core.common.models.Item;

public interface ItemsView {

    void showItems(ItemsViewModel itemsViewModel);

    public interface InteractionHandler {
        void registerView(ItemsView itemsView);
        void itemSelected(Item item);
        void updateView();
    }
}
