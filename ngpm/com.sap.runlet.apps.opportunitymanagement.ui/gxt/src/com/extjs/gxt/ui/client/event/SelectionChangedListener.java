/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.data.ModelData;

/**
 * Listener for selection changes.
 * 
 * <pre>
    TableBinder<Stock> binder = new TableBinder&lt;Stock>(tbl, store);
    binder.addSelectionChangedListener(new SelectionChangedListener&lt;Stock>() {
      public void selectionChanged(SelectionChangedEvent&lt;Stock> se) {
        List&lt;Stock> sel = se.getSelection();
      }
    });
 * </pre>
 *
 * @param <M> the model type being selected
 */
public abstract class SelectionChangedListener<M extends ModelData> implements
    Listener<SelectionChangedEvent<M>> {

  public void handleEvent(SelectionChangedEvent<M> se) {
    selectionChanged(se);
  }

  /**
   * Fires when the selection has changed.
   * 
   * @param se the selection event
   */
  public abstract void selectionChanged(SelectionChangedEvent<M> se);

}
