package com.brandenwilson.shoppinglist.ui.items;

import com.brandenwilson.shoppinglist.core.common.services.ShoppingListApi;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsInteractor;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsNavigator;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsPresenter;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsView;
import com.brandenwilson.shoppinglist.dependency.ApplicationModule;
import com.brandenwilson.shoppinglist.ui.FragmentContainer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true,
        complete = false,
        addsTo = ApplicationModule.class,
        injects = { ItemsFragment.class }
)
public class ItemsModule {

    @Singleton
    @Provides
    public ItemsInteractor providesItemInteractor(ShoppingListApi shoppingListApi) {
        return new ItemsInteractor(shoppingListApi);
    }

    @Singleton
    @Provides
    public ItemsNavigator providesItemsNavigator(FragmentContainer fragmentContainer) {
            return new ItemsNavigatorImpl(fragmentContainer);
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
