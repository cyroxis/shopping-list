package com.brandenwilson.shoppinglist.dependency;

import android.content.Context;
import android.support.annotation.NonNull;

import com.brandenwilson.shoppinglist.core.modules.MainNavigator;
import com.brandenwilson.shoppinglist.ui.ContentActivity;
import com.brandenwilson.shoppinglist.ui.MainNavigatorImpl;
import com.brandenwilson.shoppinglist.ui.common.BaseActivity;
import com.brandenwilson.shoppinglist.ui.common.FragmentContainer;

import dagger.Module;
import dagger.Provides;

@Module (
        library = true,
        addsTo = ApplicationModule.class,
        injects = { ContentActivity.class }
)
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    public Context providesContext() {
        return activity;
    }

    @Provides
    public MainNavigator providesContentNavigator() {
        return new MainNavigatorImpl(activity);
    }

    @Provides
    public FragmentContainer providesFragmentContainer() {
        return activity.getFragmentContainer();
    }
}
