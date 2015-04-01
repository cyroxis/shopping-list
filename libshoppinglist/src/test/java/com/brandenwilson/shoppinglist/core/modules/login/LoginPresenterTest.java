package com.brandenwilson.shoppinglist.core.modules.login;

import com.brandenwilson.shoppinglist.core.common.models.Credentials;
import com.brandenwilson.shoppinglist.core.common.models.TestUser;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class LoginPresenterTest {

    @Mock
    private LoginInteractor loginInteractor;

    @Mock LoginView loginView;

    private LoginPresenter loginPresenter;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginInteractor);
        loginPresenter.registerView(loginView);
    }

    @Test
    public void testSetUp() {
        verify(loginInteractor).setCallback(loginPresenter);
        verifyNoMoreInteractions(loginInteractor);
        verifyZeroInteractions(loginView);
    }

    @Test
    public void testSetEmailOnUpdate() {
        loginPresenter.updateView();
        verify(loginView).setEmail(anyString());
    }

    @Test
    public void testSetButtonStateOnUpdate() {
        loginPresenter.updateView();
        verify(loginView).disableLoginButton();
    }

    @Test
    public void testDisableButtonWithoutPassword() {
        loginPresenter.setEmail("test@test.com");
        loginPresenter.setPassword("");
        verify(loginView, atLeastOnce()).disableLoginButton();
        verify(loginView, never()).enableLoginButton();
    }


    @Test
    public void testDisableButtonWithoutEmail() {
        loginPresenter.setEmail("");
        loginPresenter.setPassword("password");
        verify(loginView, atLeastOnce()).disableLoginButton();
        verify(loginView, never()).enableLoginButton();
    }


    @Test
    public void testEnableButton() {
        loginPresenter.setEmail("test@test.com");
        loginPresenter.setPassword("password");
        verify(loginView).enableLoginButton();
    }

    @Test
    public void testLogin() {
        loginPresenter.setEmail("test@test.com");
        loginPresenter.setPassword("password");
        loginPresenter.onLoginClicked();
        verify(loginInteractor).login(eq(new Credentials("test@test.com", "password")));
    }

    @Test
    public void testLoginBlockedWithNoPassword() {
        loginPresenter.setEmail("test@test.com");
        loginPresenter.setPassword("");
        loginPresenter.onLoginClicked();
        verify(loginInteractor, never()).login(any(Credentials.class));
    }


    @Test
    public void testLoginBlockedWithNoEmail() {
        loginPresenter.setEmail("");
        loginPresenter.setPassword("password");
        loginPresenter.onLoginClicked();
        verify(loginInteractor, never()).login(any(Credentials.class));
    }

    @Test
    public void testUserLoggedIn() {
        loginPresenter.userLoggedIn(new TestUser());
        verify(loginView).dismiss();
    }



}
