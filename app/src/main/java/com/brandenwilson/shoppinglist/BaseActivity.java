package com.brandenwilson.shoppinglist;

import android.app.ActionBar;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

public class BaseActivity extends ActionBarActivity {

    @Optional
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewCreated();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewCreated();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        onViewCreated();
    }


    protected void onViewCreated() {
        ButterKnife.inject(this);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Nullable
    @Override
    public ActionBar getActionBar() {
        throw new IllegalArgumentException("Use Support Action Bar");
    }
}
