/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.DataList;
import com.extjs.gxt.ui.client.widget.DataListItem;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.menu.Menu;

/**
 * DataList event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see DataList
 * 
 * @deprecated {@link ListView}
 */
public class DataListEvent extends ContainerEvent<DataList, DataListItem> {

  private Menu menu;

  public DataListEvent(DataList list) {
    super(list);
  }

  public DataListEvent(DataList list, DataListItem item) {
    super(list, item);
  }

  /**
   * Returns the menu.
   * 
   * @return the menu
   */
  public Menu getMenu() {
    return menu;
  }

  /**
   * Sets the menu.
   * 
   * @param menu the menu
   */
  public void setMenu(Menu menu) {
    this.menu = menu;
  }

}
