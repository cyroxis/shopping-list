package com.brandenwilson.shoppinglist.ui;

import android.app.ActionBar;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.brandenwilson.shoppinglist.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends ActionBarActivity {

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

    protected void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void onViewCreated() {
        ButterKnife.inject(this);
    }

    @Nullable
    @Override
    public ActionBar getActionBar() {
        throw new IllegalArgumentException("Use Support Action Bar");
    }

    protected void showFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_main_content, fragment)
                .commit();
    }
}
