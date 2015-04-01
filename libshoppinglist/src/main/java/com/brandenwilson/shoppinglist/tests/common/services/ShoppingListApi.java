package com.brandenwilson.shoppinglist.tests.common.services;

import com.brandenwilson.shoppinglist.tests.common.services.parameters.LoginApiParams;

public interface ShoppingListApi {

    public void login(LoginApiParams loginApiParams);

    public void getItems(GetItemsParams getItemsParams);
}
