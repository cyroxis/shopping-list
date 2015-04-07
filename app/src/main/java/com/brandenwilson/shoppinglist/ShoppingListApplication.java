package com.brandenwilson.shoppinglist;

import android.app.Application;

import com.brandenwilson.shoppinglist.dependency.ApplicationModule;
import com.brandenwilson.shoppinglist.dependency.ObjectGraphHolder;

import timber.log.Timber;

public class ShoppingListApplication extends Application {

    ObjectGraphHolder objectGraphHolder;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraphHolder = new ObjectGraphHolder(new ApplicationModule());

        Timber.plant(new Timber.DebugTree());
    }

    @Override
    public Object getSystemService(String name) {
        if (ObjectGraphHolder.isObjectGraphService(name)) {
            return objectGraphHolder;
        } else {
            return super.getSystemService(name);
        }
    }
}
