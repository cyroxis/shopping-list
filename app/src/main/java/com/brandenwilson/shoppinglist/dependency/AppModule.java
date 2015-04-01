package com.brandenwilson.shoppinglist.dependency;

import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.core.common.models.User;
import com.brandenwilson.shoppinglist.core.common.models.UserProfileInformation;
import com.brandenwilson.shoppinglist.core.common.services.GetItemsParams;
import com.brandenwilson.shoppinglist.core.common.services.ShoppingListApi;
import com.brandenwilson.shoppinglist.core.common.services.parameters.LoginApiParams;
import com.brandenwilson.shoppinglist.core.common.services.responses.GetItemsResponse;
import com.brandenwilson.shoppinglist.ui.MainActivity;

import java.util.Collections;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true,
        complete = false,
        injects = { MainActivity.class }
)
public class AppModule {

    @Singleton
    @Provides
    public ShoppingListApi providesShoppingListApi() {
        return new ShoppingListApi() {
            @Override
            public void login(LoginApiParams loginApiParams) {
                loginApiParams.callback.loginSucceeded(new User(":token:", new UserProfileInformation("Bob test", "test@test.com")));
            }

            @Override
            public void getItems(GetItemsParams getItemsParams) {
                getItemsParams.callback.receivedItemsResponse(new GetItemsResponse(Collections.<Item>emptyList()));
            }
        };
    }

}
