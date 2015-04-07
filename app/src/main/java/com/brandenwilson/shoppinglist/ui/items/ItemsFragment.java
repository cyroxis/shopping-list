package com.brandenwilson.shoppinglist.ui.items;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.brandenwilson.shoppinglist.R;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsView;
import com.brandenwilson.shoppinglist.core.modules.items.ItemsViewModel;
import com.brandenwilson.shoppinglist.ui.common.BaseFragment;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import timber.log.Timber;

public class ItemsFragment extends BaseFragment implements ItemsView {

    @InjectView(R.id.list_view_items)
    ListView items;

    @Inject
    InteractionHandler interactionHandler;

    ItemsAdapter itemsAdapter = new ItemsAdapter();

    @Override
    protected List<? extends Object> getFragmentModules() {
        return Arrays.asList(new ItemsModule());
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_items;
    }

    @Override
    public void onStart() {
        super.onStart();
        Timber.w("Hi there");
        interactionHandler.updateView();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items.setAdapter(itemsAdapter);
        items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                interactionHandler.itemSelected(itemsAdapter.getItem(position));
            }
        });

        interactionHandler.registerView(this);
    }

    @Override
    public void showItems(ItemsViewModel itemsViewModel) {
        Timber.w("Hi there!!");
        itemsAdapter.setItems(itemsViewModel.items);
    }
}
