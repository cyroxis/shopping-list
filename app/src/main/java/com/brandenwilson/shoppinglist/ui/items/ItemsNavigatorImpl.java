package com.brandenwilson.shoppinglist.ui.items;

import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsNavigator;
import com.brandenwilson.shoppinglist.ui.common.FragmentContainer;
import com.brandenwilson.shoppinglist.ui.itemdetail.ItemDetailFragment;

public class ItemsNavigatorImpl implements ItemsNavigator {
    private final FragmentContainer fragmentContainer;

    public ItemsNavigatorImpl(FragmentContainer fragmentContainer) {
        this.fragmentContainer = fragmentContainer;
    }

    @Override
    public void showItemDetail(Item item) {
        fragmentContainer.addFragmentToBackStack(new ItemDetailFragment());
    }
}
