package com.brandenwilson.shoppinglist.core.modules.login;

import com.brandenwilson.shoppinglist.core.common.models.Credentials;
import com.brandenwilson.shoppinglist.core.common.models.TestUser;
import com.brandenwilson.shoppinglist.core.common.models.User;
import com.brandenwilson.shoppinglist.core.common.services.ShoppingListApi;
import com.brandenwilson.shoppinglist.core.common.services.parameters.LoginApiParams;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class LoginInteractorTests {

    @Mock
    ShoppingListApi shoppingListApi;

    @Mock
    LoginInteractor.Callback callback;

    LoginInteractor loginInteractor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        loginInteractor = new LoginInteractor(shoppingListApi);
        loginInteractor.setCallback(callback);
    }

    @Test
    public void testSetUp() {
        verifyZeroInteractions(shoppingListApi);
        verifyZeroInteractions(callback);
    }

    @Test
    public void testLogin() {
        loginInteractor.login(new Credentials("test@test.com", "password"));
        verify(shoppingListApi).login(eq(new LoginApiParams("test@test.com", "password", loginInteractor)));
    }

    @Test
    public void testLoginSucceeded() {
        User user = new TestUser();
        loginInteractor.loginSucceeded(user);
        verify(callback).userLoggedIn(user);
    }
}

