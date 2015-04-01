package com.brandenwilson.shoppinglist.ui.login;

import com.brandenwilson.shoppinglist.tests.common.services.ShoppingListApi;
import com.brandenwilson.shoppinglist.tests.modules.login.LoginInteractor;
import com.brandenwilson.shoppinglist.tests.modules.login.LoginPresenter;
import com.brandenwilson.shoppinglist.tests.modules.login.LoginView;
import com.brandenwilson.shoppinglist.dependency.AppModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true,
        injects = { LoginActivity.class },
        addsTo = AppModule.class
)
public class LoginModule {

    @Singleton
    @Provides
    public LoginInteractor providesLoginInteractor(ShoppingListApi shoppingListApi) {
        return new LoginInteractor(shoppingListApi);
    }

    @Singleton
    @Provides
    public LoginPresenter providesLoginPresent(LoginInteractor loginInteractor) {
        return new LoginPresenter(loginInteractor);
    }

    @Singleton
    @Provides
    public LoginView.InteractionHandler providesInteractionHandler(LoginPresenter loginPresenter) {
        return loginPresenter;
    }
}
