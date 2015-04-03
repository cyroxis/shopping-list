package com.brandenwilson.shoppinglist;

import android.app.Application;

import com.brandenwilson.shoppinglist.dependency.ApplicationModule;

import dagger.ObjectGraph;
import timber.log.Timber;

public class ShoppingListApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new ApplicationModule());

        Timber.plant(new Timber.DebugTree());
    }

    public ObjectGraph getApplicationObjectGraph() {
        return objectGraph;
    };
}
