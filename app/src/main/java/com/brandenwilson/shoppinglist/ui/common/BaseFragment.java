package com.brandenwilson.shoppinglist.ui.common;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onInjectDependencies(getBaseActivity().getActivityObjectGraph());
    }

    protected void onInjectDependencies(ObjectGraph objectGraph) {
        objectGraph.inject(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof BaseActivity))
            throw new IllegalArgumentException("Activity must extends " + BaseActivity.class.getSimpleName());
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

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

}
