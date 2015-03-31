package com.brandenwilson.shoppinglist.core.modules.login;

import com.brandenwilson.shoppinglist.core.common.models.Credentials;
import com.brandenwilson.shoppinglist.core.common.models.User;

public class LoginPresenter implements LoginView.InteractionHandler, LoginInteractor.Callback{

    private final LoginInteractor loginInteractor;
    private Credentials credentials = new Credentials("", "");
    private LoginView loginView;

    public LoginPresenter(LoginInteractor loginInteractor) {
        this.loginInteractor = loginInteractor;
        loginInteractor.setCallback(this);
    }

    @Override
    public void userLoggedIn(User user) {
        loginView.dismiss();
    }

    @Override
    public void registerView(LoginView loginView) {
        this.loginView = loginView;
        loginView.setEmail("test@test.com");
    }

    @Override
    public void setEmail(String email) {
        credentials = new Credentials(email, credentials.password);
    }

    @Override
    public void setPassword(String password) {
        credentials = new Credentials(credentials.email, credentials.password);
    }

    @Override
    public void onLoginClicked() {
        loginInteractor.login(credentials);
    }
}