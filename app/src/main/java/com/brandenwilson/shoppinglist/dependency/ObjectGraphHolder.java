package com.brandenwilson.shoppinglist.dependency;

import android.support.annotation.NonNull;

import dagger.ObjectGraph;

public class ObjectGraphHolder {

    private static ObjectGraph objectGraph;
    private static ObjectGraphCreator objectGraphCreator;

    public interface ObjectGraphCreator {
        @NonNull
        public ObjectGraph create();
    }

    @NonNull
    public static ObjectGraph getObjectGraph() {
        if (objectGraph == null) {
            objectGraph = objectGraphCreator.create();
        }
        return objectGraph;
    }

    public static void setObjectGraphCreator(@NonNull ObjectGraphCreator creator) {
        objectGraphCreator = creator;
    }

    public static void inject(Object obj, Object... modules) {
        getObjectGraph().plus(modules).inject(obj);
    }
}
