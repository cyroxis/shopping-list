package com.brandenwilson.shoppinglist.core.common.services;

import com.brandenwilson.shoppinglist.core.common.services.responses.GetItemsResponse;

public class GetItemsParams {
    public interface Callback {
        public void receivedItemsResponse(GetItemsResponse getItemsResponse);
    }

    public final String authToken;
    public final Callback callback;

    public GetItemsParams(String authToken, Callback callback) {
        this.authToken = authToken;
        this.callback = callback;
    }
}
