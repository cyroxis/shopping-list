package com.brandenwilson.shoppinglist.ui.items;

import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.LayoutRes;

import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsNavigator;
import com.brandenwilson.shoppinglist.ui.NavigatorImpl;

public class ItemsNavigatorImpl extends NavigatorImpl implements ItemsNavigator {

    private final FragmentManager fragmentManager;
    private final int layoutId;

    public ItemsNavigatorImpl(Context context, FragmentManager fragmentManager, @LayoutRes int layoutId) {
        super(context);
        this.fragmentManager = fragmentManager;
        this.layoutId = layoutId;
    }

    @Override
    public void showItemDetail(Item item) {
        //TODO
    }
}
