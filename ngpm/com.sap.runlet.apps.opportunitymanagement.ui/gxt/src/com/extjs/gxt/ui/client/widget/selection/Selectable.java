/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.selection;

import java.util.List;

import com.extjs.gxt.ui.client.widget.Component;

/**
 * Interface for containers whos children can be selected.
 * 
 * @param <T> the child component type
 */
public interface Selectable<T extends Component> {

  /**
   * Returns the selected item.
   * 
   * @return the selected item
   */
  public T getSelectedItem();

  /**
   * Returns the selected items. For single-select, the last selected item is
   * returned.
   * 
   * @return the selected items
   */
  public List<T> getSelectedItems();

  /**
   * Called when the visual state of a item is changed.
   * 
   * @param item the item
   * @param select the select state
   */
  public void onSelectChange(T item, boolean select);

  /**
   * Selects the item. Any existing selections are cleared.
   * 
   * @param item the item to select
   */
  public void setSelectedItem(T item);

  /**
   * Selects the items. Only the first item is selected for single-select. Any
   * existing selections are cleared.
   * 
   * @param items the items to select
   */
  public void setSelectedItems(List<T> items);

}
