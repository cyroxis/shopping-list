package com.brandenwilson.shoppinglist.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import timber.log.Timber;

public class TestView extends LinearLayout{

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Timber.w(context.getClass().getSimpleName());
    }
}
