package com.brandenwilson.shoppinglist.core.modules.login;

import com.brandenwilson.shoppinglist.core.common.models.Credentials;
import com.brandenwilson.shoppinglist.core.common.models.User;

import org.apache.commons.lang3.StringUtils;

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
    }

    @Override
    public void updateView() {
        loginView.setEmail(credentials.email);
        updateButtonState();
    }

    @Override
    public void setEmail(String email) {
        credentials = new Credentials(email, credentials.password);
        updateButtonState();
    }

    @Override
    public void setPassword(String password) {
        credentials = new Credentials(credentials.email, password);
        updateButtonState();
    }

    private void updateButtonState() {
        if (hasValidCredentials()) {
            loginView.enableLoginButton();
        } else {
            loginView.disableLoginButton();
        }
    }

    private boolean hasValidCredentials() {
        return !StringUtils.isEmpty(credentials.email) && !StringUtils.isEmpty(credentials.password);
    }

    @Override
    public void onLoginClicked() {
        if (hasValidCredentials()) {
            loginInteractor.login(credentials);
        }
    }
}