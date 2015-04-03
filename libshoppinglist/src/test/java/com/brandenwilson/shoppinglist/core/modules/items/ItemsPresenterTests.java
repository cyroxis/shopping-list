package com.brandenwilson.shoppinglist.core.modules.items;

import com.brandenwilson.shoppinglist.core.common.models.Item;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class ItemsPresenterTests {

    @Mock
    private ItemsInteractor itemsInteractor;

    @Mock
    private ItemsView itemsView;

    @Mock
    private ItemsNavigator itemsNavigator;

    private ItemsPresenter itemsPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        itemsPresenter = new ItemsPresenter(itemsInteractor, itemsNavigator);
        itemsPresenter.registerView(itemsView);
    }

    @Test
    public void testSetUp() {
        verify(itemsInteractor).setCallback(itemsPresenter);
        verifyNoMoreInteractions(itemsInteractor);
        verifyZeroInteractions(itemsView);
    }

    @Test
    public void testUpdateView() {
        itemsPresenter.updateView();
        verify(itemsInteractor).getItems();
    }

    @Test
    public void testItemsLoaded() {
        List<Item> items = Arrays.asList(new Item("Item1"), new Item("Item2"));
        itemsPresenter.itemsLoaded(items);
        verify(itemsView).showItems(new ItemsViewModel(items));
    }

    @Test
    public void testItemSelected() {
        itemsPresenter.itemSelected(new Item("TestItem"));
        verify(itemsNavigator).showItemDetail(new Item("TestItem"));
    }
}
