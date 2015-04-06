package com.brandenwilson.shoppinglist.ui.common;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ViewHolderAdapter<T,H> extends BaseAdapter {

    private final int layoutId;
    List<T> items = new ArrayList<>();

    protected ViewHolderAdapter(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    public void setItems(Collection<? extends T> collection) {
        items.clear();
        items.addAll(collection);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        H viewHolder = null;

        if (view == null) {
            view = createView(parent);
            viewHolder = createViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (H) view.getTag();
        }

        updateViewHolder(viewHolder, getItem(position), position);

        return view;
    }

    public abstract H createViewHolder(View view);

    public abstract void updateViewHolder(H h, T item, int position);

    private View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(layoutId, parent, false);
    }

}
