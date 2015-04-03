package com.brandenwilson.shoppinglist.ui.items;

import android.content.Context;

import com.brandenwilson.shoppinglist.core.common.services.ShoppingListApi;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsInteractor;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsNavigator;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsPresenter;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsView;
import com.brandenwilson.shoppinglist.dependency.AppModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true,
        addsTo = AppModule.class,
        injects = {ItemsFragment.class}
)
public class ItemsModule {

    private final Context context;

    public ItemsModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public ItemsInteractor providesItemInteractor(ShoppingListApi shoppingListApi) {
        return new ItemsInteractor(shoppingListApi);
    }

    @Singleton
    @Provides
    public ItemsNavigator providesItemsNavigator() {
        //TODO fix
        return new ItemsNavigatorImpl(context, null, 0);
    }

    @Singleton
    @Provides
    public ItemsPresenter providesItemsPresenter(ItemsInteractor itemsInteractor, ItemsNavigator itemsNavigator) {
        return new ItemsPresenter(itemsInteractor, itemsNavigator);
    }

    @Singleton
    @Provides
    public ItemsView.InteractionHandler providesInteractionHandler(ItemsPresenter itemsPresenter) {
        return itemsPresenter;
    }
}
