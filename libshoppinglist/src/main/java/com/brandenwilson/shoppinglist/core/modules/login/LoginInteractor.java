package com.brandenwilson.shoppinglist.core.modules.login;

import com.brandenwilson.shoppinglist.core.common.models.Credentials;
import com.brandenwilson.shoppinglist.core.common.models.User;
import com.brandenwilson.shoppinglist.core.common.services.ShoppingListApi;
import com.brandenwilson.shoppinglist.core.common.services.parameters.LoginApiParams;

public class LoginInteractor implements LoginApiParams.Callback{

    public interface Callback {
        public void userLoggedIn(User user);
    }

    private final ShoppingListApi shoppingListApi;
    private Callback callback;

    public LoginInteractor(ShoppingListApi shoppingListApi) {
        this.shoppingListApi = shoppingListApi;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void login(Credentials credentials) {
        shoppingListApi.login(new LoginApiParams(credentials.email, credentials.password, this));
    }

    @Override
    public void loginSucceeded(User user) {
        if (callback != null) {
            callback.userLoggedIn(user);
        }
    }
}
