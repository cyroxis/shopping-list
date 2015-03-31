package com.brandenwilson.shoppinglist;

import android.app.Application;
import android.support.annotation.NonNull;

import com.brandenwilson.shoppinglist.dependency.AppModule;
import com.brandenwilson.shoppinglist.dependency.ObjectGraphHolder;
import com.brandenwilson.shoppinglist.ui.login.LoginModule;

import dagger.ObjectGraph;
import timber.log.Timber;

public class ShoppingListApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        ObjectGraphHolder.setObjectGraphCreator(new ObjectGraphHolder.ObjectGraphCreator() {

            @NonNull
            @Override
            public ObjectGraph create() {
                return ObjectGraph.create(new AppModule());
            }
        });
    }
}
