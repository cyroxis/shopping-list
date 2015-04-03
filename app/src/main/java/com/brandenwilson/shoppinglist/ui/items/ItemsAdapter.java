package com.brandenwilson.shoppinglist.ui.items;

import android.view.View;
import android.widget.TextView;

import com.brandenwilson.shoppinglist.R;
import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.ui.ViewHolderAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ItemsAdapter extends ViewHolderAdapter<Item, ItemsAdapter.ViewHolder> {

    protected ItemsAdapter() {
        super(R.layout.row_item);
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void updateViewHolder(ViewHolder viewHolder, Item item, int position) {
        viewHolder.setItem(item);
    }

    static class ViewHolder {

        @InjectView(R.id.text_name)
        TextView name;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }

        public void setItem(Item item) {
            name.setText(item.name);
        }
    }
}
