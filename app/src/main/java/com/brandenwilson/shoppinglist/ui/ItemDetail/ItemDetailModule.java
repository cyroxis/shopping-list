package com.brandenwilson.shoppinglist.ui.itemdetail;

import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.core.modules.itemdetail.ItemDetailInteractor;
import com.brandenwilson.shoppinglist.core.modules.itemdetail.ItemDetailPresenter;
import com.brandenwilson.shoppinglist.core.modules.itemdetail.ItemDetailView;
import com.brandenwilson.shoppinglist.dependency.ActivityModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true,
        complete = false,
        addsTo = ActivityModule.class,
        injects = { ItemDetailFragment.class }
)
public class ItemDetailModule {

    @Singleton
    @Provides
    public ItemDetailInteractor providesItemDetailInteractor() {
        return new ItemDetailInteractor(new Item("Hello World"));
    }

    @Singleton
    @Provides
    public ItemDetailPresenter providesItemDetailPresenter(ItemDetailInteractor itemDetailInteractor) {
        return new ItemDetailPresenter(itemDetailInteractor);
    }

    @Singleton
    @Provides
    public ItemDetailView.InteractionHandler providesInteractionHandler(ItemDetailPresenter itemDetailPresenter) {
        return itemDetailPresenter;
    }
}
