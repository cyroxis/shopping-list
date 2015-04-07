package com.brandenwilson.shoppinglist.ui.common;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brandenwilson.shoppinglist.dependency.ObjectGraphHolder;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {


    protected List<? extends Object> getFragmentModules() {
        return Collections.emptyList();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ObjectGraphHolder.inject(getActivity(), this, getFragmentModules().toArray());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), container, false);

        ButterKnife.inject(this, view);
        return view;
    }

    @LayoutRes
    protected abstract int getLayoutID();
}
