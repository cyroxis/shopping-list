package com.brandenwilson.shoppinglist.ui.cards;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.brandenwilson.shoppinglist.R;
import com.brandenwilson.shoppinglist.ui.BaseFragment;

import butterknife.InjectView;

public class CardsFragment extends BaseFragment {

    @InjectView(R.id.recycler_cards)
    RecyclerView cardsView;

    public static CardsFragment getInstance() {
        return new CardsFragment();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_cards;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardAdapter cardAdapter = new CardAdapter(getActivity());
        cardsView.setAdapter(cardAdapter);
    }
}
