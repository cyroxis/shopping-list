package com.brandenwilson.shoppinglist.tests.common.services.responses;

import com.brandenwilson.shoppinglist.tests.common.models.Item;

import java.util.List;

public class GetItemsResponse {
    public final List<Item> items;

    public GetItemsResponse(List<Item> items) {
        this.items = items;
    }
}
