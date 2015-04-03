package com.brandenwilson.shoppinglist.ui;

import android.content.Context;

import com.brandenwilson.shoppinglist.core.modules.MainNavigator;
import com.brandenwilson.shoppinglist.ui.login.LoginActivity;

public class MainNavigatorImpl implements MainNavigator {

    protected final Context context;

    public MainNavigatorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void showLogin() {
        context.startActivity(LoginActivity.intent(context));
    }

    @Override
    public void showItems() {
        context.startActivity(ContentActivity.intent(context));
    }
}
