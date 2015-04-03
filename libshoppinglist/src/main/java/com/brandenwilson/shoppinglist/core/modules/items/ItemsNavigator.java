package com.brandenwilson.shoppinglist.core.modules.items;

import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.core.modules.Navigator;

public interface ItemsNavigator extends Navigator {

    public void showItemDetail(Item item);
}
