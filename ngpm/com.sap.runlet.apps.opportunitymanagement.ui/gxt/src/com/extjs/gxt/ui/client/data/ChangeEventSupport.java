/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the <code>ChangeEventSource</code> interface.
 */
public class ChangeEventSupport implements ChangeEventSource {

  protected List<ChangeListener> listeners;
  protected boolean silent;

  public void addChangeListener(ChangeListener... listener) {
    if (listeners == null) {
      listeners = new ArrayList<ChangeListener>();
    }
    for (int i = 0; i < listener.length; i++) {
      listeners.add(listener[i]);
    }
  }

  public void notify(ChangeEvent event) {
    if (!silent && listeners != null) {
      for (ChangeListener listener : listeners) {
        listener.modelChanged(event);
      }
    }
  }

  public void removeChangeListener(ChangeListener... listener) {
    if (listeners != null) {
      for (int i = 0; i < listener.length; i++) {
        listeners.remove(listener[i]);
      }
    }
  }

  public void setSilent(boolean silent) {
    this.silent = silent;
  }

  public void removeChangeListeners() {
    listeners.clear();
  }

}
