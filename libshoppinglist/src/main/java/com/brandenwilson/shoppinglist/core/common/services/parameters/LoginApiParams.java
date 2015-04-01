package com.brandenwilson.shoppinglist.core.common.services.parameters;

import com.brandenwilson.shoppinglist.core.common.models.User;

import org.apache.commons.lang3.StringUtils;

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LoginApiParams)) {
            return false;
        }

        LoginApiParams loginApiParams = (LoginApiParams) obj;
        return obj == this
                || callback == loginApiParams.callback
                && StringUtils.equals(email, loginApiParams.email)
                && StringUtils.equals(password, loginApiParams.password);

    }
}
