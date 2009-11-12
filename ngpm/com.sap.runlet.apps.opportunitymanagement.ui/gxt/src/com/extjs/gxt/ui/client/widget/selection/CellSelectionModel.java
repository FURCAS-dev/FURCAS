/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.selection;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;

/**
 * Defines the interface for containers which provide cell based selections.
 * 
 * @param <C> the container type
 * @param <T> the component type
 */
public interface CellSelectionModel<C extends Container<T>, T extends Component> {

  /**
   * Selects the cell.
   * 
   * @param row the row index
   * @param column the column index
   */
  public void select(int row, int column);

  /**
   * Deselects the cell.
   * 
   * @param row the row index
   * @param column the column index
   */
  public void deselect(int row, int column);

  /**
   * Returns true if the cell is selected.
   * 
   * @param row the row index
   * @param column the column index
   */
  public void isSelected(int row, int column);

}
