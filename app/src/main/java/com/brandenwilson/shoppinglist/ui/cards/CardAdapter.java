package com.brandenwilson.shoppinglist.ui.cards;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brandenwilson.shoppinglist.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private LayoutInflater inflater;

    CardAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.card_item_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        bindViewHolder(viewHolder, i);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(i);
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.text_title)
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void bindData(int i) {
            title.setText("Title " + i);
        }
    }
}
