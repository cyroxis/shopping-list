package com.brandenwilson.shoppinglist.core.modules.login;


public interface LoginView {

    void setEmail(String email);
    void dismiss();
    void enableLoginButton();
    void disableLoginButton();

    public interface InteractionHandler {
        void registerView(LoginView loginView);
        void setEmail(String email);
        void setPassword(String password);
        void onLoginClicked();
        void updateView();
    }
}
