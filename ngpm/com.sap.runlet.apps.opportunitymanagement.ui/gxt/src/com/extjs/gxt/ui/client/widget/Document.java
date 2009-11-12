/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.core.XDOM;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * Wraps the document element and provides the ability to listen for document
 * events.
 */
public class Document extends Component {

  private static Document instance;

  private Document() {

  }

  @Override
  public void onBrowserEvent(Event event) {
    // do not unnessecarily create component events
    if (hasListeners()) {
      super.onBrowserEvent(event);
    }
  }

  /**
   * Returns the singleton instance.
   * 
   * @return the document
   */
  public static Document get() {
    if (instance == null) {
      instance = new Document();
      instance.setElement(XDOM.getDocument());
      instance.sinkEvents(Event.MOUSEEVENTS | Event.ONCLICK);
      DOM.setEventListener(instance.getElement(), instance);
    }
    return instance;
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(XDOM.getDocument());
    sinkEvents(Event.MOUSEEVENTS);
  }

}
