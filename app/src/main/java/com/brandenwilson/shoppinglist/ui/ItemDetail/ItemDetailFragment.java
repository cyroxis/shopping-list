package com.brandenwilson.shoppinglist.ui.ItemDetail;

import android.os.Bundle;
import android.widget.TextView;

import com.brandenwilson.shoppinglist.R;
import com.brandenwilson.shoppinglist.core.common.models.Item;
import com.brandenwilson.shoppinglist.core.modules.itemdetail.ItemDetailView;
import com.brandenwilson.shoppinglist.ui.BaseFragment;

import javax.inject.Inject;

import butterknife.InjectView;
import dagger.ObjectGraph;

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
    protected void onInjectDependencies(ObjectGraph objectGraph) {
        super.onInjectDependencies(objectGraph.plus(new ItemDetailModule()));
    }
}
