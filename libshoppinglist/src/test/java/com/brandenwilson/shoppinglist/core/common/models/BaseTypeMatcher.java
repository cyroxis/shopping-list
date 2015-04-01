package com.brandenwilson.shoppinglist.core.common.models;

import org.hamcrest.BaseMatcher;

public abstract class BaseTypeMatcher<T> extends BaseMatcher<T>{

    @Override
    public final boolean matches(Object item) {
        try {
            return matchesItem((T) item);
        } catch (ClassCastException e) {
            return false;
        }
    }

    public abstract boolean matchesItem(T t);
}
