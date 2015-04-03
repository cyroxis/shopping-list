package com.brandenwilson.shoppinglist.core.modules.items;

import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.core.common.services.GetItemsParams;
import com.brandenwilson.shoppinglist.core.common.services.ShoppingListApi;
import com.brandenwilson.shoppinglist.core.common.services.responses.GetItemsResponse;

import java.util.List;

public class ItemsInteractor implements GetItemsParams.Callback{

    public interface Callback {
        public void itemsLoaded(List<Item> items);
    }

    private final ShoppingListApi shoppingListApi;
    private Callback callback;

    public ItemsInteractor(ShoppingListApi shoppingListApi) {
        this.shoppingListApi = shoppingListApi;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void getItems() {
        //TODO get saved auth token
        shoppingListApi.getItems(new GetItemsParams("::some token::", this));
    }

    @Override
    public void receivedItemsResponse(GetItemsResponse getItemsResponse) {
        if (callback != null) {
            callback.itemsLoaded(getItemsResponse.items);
        }
    }
}
