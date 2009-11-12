/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.DataView;
import com.extjs.gxt.ui.client.widget.DataViewItem;
import com.extjs.gxt.ui.client.widget.ListView;

/**
 * DataView event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see DataView
 * 
 * @deprecated see {@link ListView}
 */
public class DataViewEvent extends ContainerEvent<DataView, DataViewItem> {

  /**
   * The source data view instance.
   */
  private DataView view;

  public DataViewEvent(DataView view) {
    super(view);
    this.view = view;
  }

  public DataViewEvent(DataView view, DataViewItem item) {
    super(view, item);
    this.view = view;
  }

  /**
   * Returns the source data view.
   * 
   * @return the data view
   */
  public DataView getView() {
    return view;
  }

  /**
   * Sets the source data view.
   * 
   * @param view the data view
   */
  public void setView(DataView view) {
    this.view = view;
  }

}
