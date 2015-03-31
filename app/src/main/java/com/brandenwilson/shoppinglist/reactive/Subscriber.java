package com.brandenwilson.shoppinglist.reactive;

import timber.log.Timber;

public abstract class Subscriber<T> extends rx.Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Timber.tag(getClass().getSimpleName());
        Timber.e(e, e.getMessage());
    }
}
