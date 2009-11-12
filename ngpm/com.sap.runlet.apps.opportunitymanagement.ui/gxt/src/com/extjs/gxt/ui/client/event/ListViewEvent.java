/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.widget.ListView;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * ListView event type.
 */
public class ListViewEvent<M extends ModelData> extends BoxComponentEvent {

  private Element element;
  private int index = -1;
  private ListView<M> listView;
  private M model;

  public ListViewEvent(ListView<M> listView) {
    super(listView);
    this.listView = listView;
  }

  public ListViewEvent(ListView<M> listView, Event event) {
    super(listView, event);
    this.listView = listView;
    this.event = event;
  }

  /**
   * Returns the element.
   * 
   * @return the element
   */
  public Element getElement() {
    if (element == null) {
      element = listView.getElement(getIndex());
    }
    return element;
  }

  /**
   * Returns the index.
   * 
   * @return the index
   */
  public int getIndex() {
    if (index == -1) {
      if (event != null) {
        El el = getTarget(listView.getItemSelector(), 10);
        if (el != null) {
          index = listView.indexOf(el.dom);
        }
      }
    }
    return index;
  }

  /**
   * Returns the source list view.
   * 
   * @return the list view
   */
  public ListView<M> getListView() {
    return listView;
  }

  /**
   * Returns the model.
   * 
   * @return the model
   */
  public M getModel() {
    return model;
  }

  /**
   * Sets the element.
   * 
   * @param element the element
   */
  public void setElement(Element element) {
    this.element = element;
  }

  /**
   * Sets the index.
   * 
   * @param index the index
   */
  public void setIndex(int index) {
    this.index = index;
  }

  /**
   * Sets the source list view.
   * 
   * @param listView the source list view.
   */
  public void setListView(ListView<M> listView) {
    this.listView = listView;
  }

  /**
   * Sets the model.
   * 
   * @param model the model
   */
  public void setModel(M model) {
    this.model = model;
  }

}
