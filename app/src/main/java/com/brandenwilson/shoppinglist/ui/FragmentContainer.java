package com.brandenwilson.shoppinglist.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.IdRes;

public class FragmentContainer {

    private final FragmentManager fragmentManager;
    private final int layoutId;

    public FragmentContainer(FragmentManager fragmentManager,@IdRes int layoutId) {
        this.fragmentManager = fragmentManager;
        this.layoutId = layoutId;
    }

    public void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .replace(layoutId, fragment)
                .commit();
    }
}
