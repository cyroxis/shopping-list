package com.brandenwilson.shoppinglist.core.common.services.parameters;

import com.brandenwilson.shoppinglist.core.common.models.User;

public class LoginApiParams {

    public interface Callback {
        public void loginSucceeded(User user);
    }

    public final String email;
    public final String password;
    public final Callback callback;

    public LoginApiParams(String email, String password, Callback callback) {
        this.email = email;
        this.password = password;
        this.callback = callback;
    }
}
