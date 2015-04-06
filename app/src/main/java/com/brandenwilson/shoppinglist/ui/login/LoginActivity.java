package com.brandenwilson.shoppinglist.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.brandenwilson.shoppinglist.R;
import com.brandenwilson.shoppinglist.core.modules.login.LoginView;
import com.brandenwilson.shoppinglist.dependency.ActivityModule;
import com.brandenwilson.shoppinglist.reactive.Subscriber;
import com.brandenwilson.shoppinglist.ui.common.BaseActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;
import rx.android.widget.OnTextChangeEvent;
import rx.android.widget.WidgetObservable;

public class LoginActivity extends BaseActivity implements LoginView {

    @InjectView(R.id.edit_text_email)
    EditText email;

    @InjectView(R.id.edit_text_password)
    EditText password;

    @InjectView(R.id.button_login)
    Button login;

    @Inject
    InteractionHandler interactionHandler;

    public static Intent intent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login);

        interactionHandler.registerView(this);
    }

    @Override
    protected List<? extends Object> getActivityModules() {
        return Arrays.asList(new ActivityModule(this), new LoginModule());
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();

        WidgetObservable.text(email).subscribe(new Subscriber<OnTextChangeEvent>() {
            @Override
            public void onNext(OnTextChangeEvent onTextChangeEvent) {
                String value = onTextChangeEvent.text().toString();
                interactionHandler.setEmail(value);
            }
        });

        WidgetObservable.text(password).subscribe(new Subscriber<OnTextChangeEvent>() {
            @Override
            public void onNext(OnTextChangeEvent onTextChangeEvent) {
                String value = onTextChangeEvent.text().toString();
                interactionHandler.setPassword(value);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        interactionHandler.updateView();
    }

    @Override
    public void setEmail(String email) {
        this.email.setText(email);
    }

    @Override
    public void dismiss() {
        finish();
    }

    @Override
    public void enableLoginButton() {
        login.setEnabled(true);
    }

    @Override
    public void disableLoginButton() {
        login.setEnabled(false);
    }

    @OnClick(R.id.button_login)
    void onLoginClicked() {
        interactionHandler.onLoginClicked();
    }
}
