package com.brandenwilson.shoppinglist.core.modules.itemdetail;

import com.brandenwilson.shoppinglist.core.common.models.Item;

public class ItemDetailPresenter implements ItemDetailView.InteractionHandler, ItemDetailInteractor.Callback{

    private final ItemDetailInteractor itemDetailInteractor;
    private ItemDetailView itemDetailView;

    public ItemDetailPresenter(ItemDetailInteractor itemDetailInteractor) {
        this.itemDetailInteractor = itemDetailInteractor;
        itemDetailInteractor.setCallback(this);
    }

    @Override
    public void registerView(ItemDetailView itemDetailView) {
        this.itemDetailView = itemDetailView;
    }

    @Override
    public void updateView() {
        itemDetailInteractor.loadItemDetail();
    }

    @Override
    public void itemDetailLoaded(Item item) {
        itemDetailView.showItem(item);
    }
}
