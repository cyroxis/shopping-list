package com.brandenwilson.shoppinglist.ui.common;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.brandenwilson.shoppinglist.R;
import com.brandenwilson.shoppinglist.ShoppingListApplication;
import com.brandenwilson.shoppinglist.dependency.ObjectGraphHolder;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

public abstract class BaseActivity extends ActionBarActivity {

    private ObjectGraphHolder objectGraphHolder;

    // Making this final because this is not the onCreate you want to override
    @Override
    public final void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createObjectGraph();
    }

    protected void onInjectDependencies(ObjectGraph objectGraph) {
        objectGraph.inject(this);
    }

    private void createObjectGraph() {
        objectGraphHolder = new ObjectGraphHolder(ObjectGraphHolder.from(getApplication()), getActivityModules().toArray());
    }

    protected List<? extends Object> getActivityModules() {
        return Collections.emptyList();
    }

    protected ShoppingListApplication getShoppingListApplication() {
        return (ShoppingListApplication) getApplication();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        objectGraphHolder.release();
    }

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
    }

    @Nullable
    @Override
    public ActionBar getActionBar() {
        throw new IllegalArgumentException("Use Support Action Bar");
    }

    protected void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public FragmentContainer getFragmentContainer() {
        return new FragmentContainer(getFragmentManager(), R.id.frame_main_content);
    }

    @Override
    public Object getSystemService(String name) {
        if (ObjectGraphHolder.isObjectGraphService(name)) {
            return objectGraphHolder;
        } else {
            return super.getSystemService(name);
        }
    }
}
