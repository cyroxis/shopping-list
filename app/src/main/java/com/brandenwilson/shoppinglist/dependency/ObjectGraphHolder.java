package com.brandenwilson.shoppinglist.dependency;

import android.app.Activity;
import android.content.Context;

import dagger.ObjectGraph;

@SuppressWarnings("ResourceType")
public class ObjectGraphHolder {

    public static final String OBJECT_GRAPH_SERVICE = "object_graph_service";

    private ObjectGraph objectGraph;

    public static boolean isObjectGraphService(String name) {
        return name.equals(OBJECT_GRAPH_SERVICE);
    }

    public static ObjectGraphHolder from(Context context) {
        return (ObjectGraphHolder) context.getSystemService(OBJECT_GRAPH_SERVICE);
    }

    public static void inject(Activity activity) {
        ObjectGraphHolder.from(activity).inject((Object) activity);
    }

    public static void inject(Context context, Object item) {
        ObjectGraphHolder.from(context).inject(item);
    }

    public static void inject(Context context, Object item, Object... modules) {
        ObjectGraphHolder.from(context).inject(item, modules);
    }

    public ObjectGraphHolder(ObjectGraphHolder objectGraphHolder, Object... modules) {
        objectGraph = objectGraphHolder.objectGraph.plus(modules);
    }

    public ObjectGraphHolder(Object... modules) {
        objectGraph = ObjectGraph.create(modules);
    }

    public void inject(Object item) {
        objectGraph.inject(item);
    }

    public void inject(Object item, Object... modules) {
        objectGraph.plus(modules).inject(item);
    }

    public void release() {
        objectGraph = null;
    }
}
