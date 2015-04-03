package com.brandenwilson.shoppinglist.core.modules.items;

import com.brandenwilson.shoppinglist.core.common.models.Item;

import java.util.List;

public class ItemsPresenter implements ItemsView.InteractionHandler, ItemsInteractor.Callback {

    private final ItemsInteractor itemsInteractor;
    private final ItemsNavigator itemsNavigator;
    private ItemsView itemsView;

    public ItemsPresenter(ItemsInteractor itemsInteractor, ItemsNavigator itemsNavigator) {
        this.itemsInteractor = itemsInteractor;
        this.itemsNavigator = itemsNavigator;
        itemsInteractor.setCallback(this);
    }

    @Override
    public void itemsLoaded(List<Item> items) {
        itemsView.showItems(new ItemsViewModel(items));
    }

    @Override
    public void registerView(ItemsView itemsView) {
        this.itemsView = itemsView;
    }

    @Override
    public void itemSelected(Item item) {
        itemsNavigator.showItemDetail(item);
    }

    @Override
    public void updateView() {
        itemsInteractor.getItems();
    }
}
