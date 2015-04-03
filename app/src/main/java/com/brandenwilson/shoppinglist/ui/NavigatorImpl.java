package com.brandenwilson.shoppinglist.ui;

import android.content.Context;

import com.brandenwilson.shoppinglist.core.modules.Navigator;
import com.brandenwilson.shoppinglist.ui.login.LoginActivity;

public class NavigatorImpl implements Navigator{

    protected final Context context;

    public NavigatorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void showLogin() {
        context.startActivity(LoginActivity.intent(context));
    }

    @Override
    public void showItems() {
        context.startActivity(MainActivity.intent(context));
    }
}
