package com.brandenwilson.shoppinglist.ui.common;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;

public class FragmentContainer {

    private final FragmentManager fragmentManager;
    private final int layoutId;

    public FragmentContainer(FragmentManager fragmentManager,@IdRes int layoutId) {
        this.fragmentManager = fragmentManager;
        this.layoutId = layoutId;
    }

    public void addFragmentToBackStack(Fragment fragment) {
        addFragmentToBackStack(fragment, null);
    }

    public void addFragmentToBackStack(Fragment fragment, String tag) {
        replaceFragment(fragment, tag)
                .addToBackStack(null)
                .commit();
    }

    public void showFragment(Fragment fragment) {
        showFragment(fragment, null);
    }

    public void showFragment(Fragment fragment, String tag) {
        replaceFragment(fragment, tag)
                .commit();
    }

    private FragmentTransaction replaceFragment(Fragment fragment, String tag) {
        return fragmentManager
                .beginTransaction()
                .replace(layoutId, fragment, tag);
    }

    public boolean onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            return true;
        }

        return false;
    }
}
