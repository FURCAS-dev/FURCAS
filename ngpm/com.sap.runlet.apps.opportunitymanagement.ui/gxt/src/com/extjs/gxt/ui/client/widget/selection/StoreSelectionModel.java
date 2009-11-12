/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.selection;

import java.util.List;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.Store;

public interface StoreSelectionModel<M extends ModelData> {

  /**
   * Binds the store to the selection model.
   * 
   * @param store the bound store
   */
  @SuppressWarnings("unchecked")
  public void bind(Store store);

  /**
   * Deselects the item at the given index.
   * 
   * @param index the index of the item to be deselected
   */
  public void deselect(int index);

  /**
   * Deselects the range.
   * 
   * @param start the start index
   * @param end the end index
   */
  public void deselect(int start, int end);

  /**
   * Deselects the items.
   * 
   * @param items the item
   */
  public void deselect(List<M> items);

  /**
   * Deselects the items.
   * 
   * @param items the items to deselect
   */
  public void deselect(M... items);

  /**
   * Deselects the item.
   * 
   * @param item the item to be deselected
   */
  public void deselect(M item);

  /**
   * Deselects all selections.
   */
  public void deselectAll();

  /**
   * Returns the selected item.
   */
  public M getSelectedItem();

  /**
   * Returns the selected items.
   */
  public List<M> getSelectedItems();

  /**
   * Returns the selection mode.
   * 
   * @return the selection mode
   */
  public SelectionMode getSelectionMode();

  /**
   * Returns true if the item is selected.
   * 
   * @param item the item
   * @return true if selected
   */
  public boolean isSelected(M item);

  /**
   * Refreshes the current selections.
   */
  public void refresh();

  /**
   * Selects the item at the given index.
   * 
   * @param index the index of the item to be selected
   * @param keepExisting true to keep existing selected
   */
  public void select(int index, boolean keepExisting);

  /**
   * Selects the range.
   * 
   * @param start the start index
   * @param end the end index
   * @param keepExisting true to keep existing selected
   */
  public void select(int start, int end, boolean keepExisting);

  /**
   * Selects the items. Selects the first item for single-select.
   * 
   * @param items the items to select
   * @param keepExisting true to keep existing selected
   */
  public void select(List<M> items, boolean keepExisting);

  /**
   * Selects the items. Selects the first item for single-select.
   * 
   * @param keepExisting true to keep existing selected
   * @param items the items
   */
  public void select(boolean keepExisting, M... items);

  /**
   * Selects the item.
   * 
   * @param item the item
   * @param keepExisting true to keep existing selected
   */
  public void select(M item, boolean keepExisting);

  /**
   * Selects all items.
   */
  public void selectAll();

  /**
   * Sets the selection mode.
   * 
   * @param selectionMode the selection mode
   */
  public void setSelectionMode(SelectionMode selectionMode);
}
