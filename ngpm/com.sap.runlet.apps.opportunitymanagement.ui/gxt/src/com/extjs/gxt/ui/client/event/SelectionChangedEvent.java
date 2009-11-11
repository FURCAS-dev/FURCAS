/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.util.Util;

/**
 * <code>BaseEvent</code> used to signal a <code>SelectionProviders</code>
 * selection has changed.
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
public class SelectionChangedEvent<M extends ModelData> extends BaseEvent {

  private SelectionProvider<M> provider;
  private List<M> selection;

  /**
   * Creates a new selection event.
   * 
   * @param provider the selection provider
   * @param selection the selection
   */
  public SelectionChangedEvent(SelectionProvider<M> provider, List<M> selection) {
    super(provider);
    this.provider = provider;
    this.selection = selection;
  }

  /**
   * Creates a new selection event.
   * 
   * @param provider the selection provider
   * @param selection the selection
   */
  @SuppressWarnings("unchecked")
  public SelectionChangedEvent(SelectionProvider<M> provider, M selection) {
    super(provider);
    this.provider = provider;
    this.selection = Util.createList(selection);
  }

  /**
   * Returns the first selected item.
   * 
   * @return the selected item
   */
  public M getSelectedItem() {
    if (selection.size() > 0) {
      return selection.get(0);
    }
    return null;
  }

  /**
   * Returns the selection.
   * 
   * @return the selection
   */
  public List<M> getSelection() {
    return selection;
  }

  /**
   * Returns the selection provider.
   * 
   * @return the provider
   */
  public SelectionProvider<M> getSelectionProvider() {
    return provider;
  }
}
