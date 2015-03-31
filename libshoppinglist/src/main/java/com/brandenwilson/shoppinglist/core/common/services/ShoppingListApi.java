package com.brandenwilson.shoppinglist.core.common.services;

import com.brandenwilson.shoppinglist.core.common.services.parameters.LoginApiParams;

public interface ShoppingListApi {

    public void login(LoginApiParams loginApiParams);

    public void getItems(GetItemsParams getItemsParams);
}
