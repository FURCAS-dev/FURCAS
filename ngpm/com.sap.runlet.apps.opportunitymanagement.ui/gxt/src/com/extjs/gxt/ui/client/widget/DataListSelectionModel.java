/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.widget.selection.AbstractSelectionModel;

/**
 * A <code>AbstractSelectionModel</code> implementation for DataList.
 * 
 * @deprecated see {@link ListView}
 */
public class DataListSelectionModel extends AbstractSelectionModel<DataList, DataListItem> {

  private boolean selectOnCheck;

  public DataListSelectionModel(SelectionMode mode) {
    super(mode);
  }

  /**
   * Returns true if select on check is enabled.
   * 
   * @return the select on check state
   */
  public boolean isSelectOnCheck() {
    return selectOnCheck;
  }

  /**
   * Sets whether the item should be selected when the user clicks the check box
   * (defaults to false).
   * 
   * @param selectOnCheck true to select on check
   */
  public void setSelectOnCheck(boolean selectOnCheck) {
    this.selectOnCheck = selectOnCheck;
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void onMouseDown(ContainerEvent ce) {
    if (locked) return;
    if (!selectOnCheck) {
      DataListItem item = (DataListItem) ce.getItem();
      if (item != null) {
        if (container.isCheckable()) {
          El e = item.el().selectNode(".my-list-item-icon");
          if (e != null && ce.within(e.dom)) {
            return;
          }
        }
      }
    }
    super.onMouseDown(ce);
  }

}
