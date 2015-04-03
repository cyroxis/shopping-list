package com.brandenwilson.shoppinglist.ui.login;

import com.brandenwilson.shoppinglist.core.common.services.ShoppingListApi;
import com.brandenwilson.shoppinglist.core.modules.login.LoginInteractor;
import com.brandenwilson.shoppinglist.core.modules.login.LoginPresenter;
import com.brandenwilson.shoppinglist.core.modules.login.LoginView;
import com.brandenwilson.shoppinglist.dependency.ApplicationModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true,
        addsTo = ApplicationModule.class,
        injects = { LoginActivity.class }
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
