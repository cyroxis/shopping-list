package com.brandenwilson.shoppinglist.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.brandenwilson.shoppinglist.R;
import com.brandenwilson.shoppinglist.dependency.ActivityModule;
import com.brandenwilson.shoppinglist.dependency.ObjectGraphHolder;
import com.brandenwilson.shoppinglist.ui.common.BaseActivity;
import com.brandenwilson.shoppinglist.ui.items.ItemsFragment;

import java.util.Arrays;
import java.util.List;

import timber.log.Timber;

public class ContentActivity extends BaseActivity {

    public static Intent intent(Context context) {
        return new Intent(context, ContentActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hello World");

        ObjectGraphHolder.inject(this);
        getFragmentContainer().showFragment(new ItemsFragment());
    }

    @Override
    protected List<? extends Object> getActivityModules() {
        return Arrays.asList(new ActivityModule(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Timber.w("Back Pressed");

        if(!getFragmentContainer().onBackPressed()) {
            super.onBackPressed();
        }
    }
}
