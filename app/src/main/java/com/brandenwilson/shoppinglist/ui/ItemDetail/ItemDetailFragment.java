package com.brandenwilson.shoppinglist.ui.itemdetail;

import android.os.Bundle;
import android.widget.TextView;

import com.brandenwilson.shoppinglist.R;
import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.core.modules.itemdetail.ItemDetailView;
import com.brandenwilson.shoppinglist.ui.common.BaseFragment;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

public class ItemDetailFragment extends BaseFragment implements ItemDetailView {

    @InjectView(R.id.text_name)
    TextView name;

    @InjectView(R.id.text_notes)
    TextView notes;

    @Inject
    InteractionHandler interactionHandler;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_item_detail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        interactionHandler.registerView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        interactionHandler.updateView();
    }

    @Override
    public void showItem(Item item) {
        name.setText(item.name);
        notes.setText(item.notes);
    }

    @Override
    protected List<? extends Object> getFragmentModules() {
        return Arrays.asList(new ItemDetailModule());
    }
}
