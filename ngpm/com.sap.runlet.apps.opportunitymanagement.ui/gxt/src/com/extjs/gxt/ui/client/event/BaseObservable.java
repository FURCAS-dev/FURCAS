/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Default implementation of the <code>Observable</code> interface.
 * 
 * <pre>
 * Observable observable = new BaseObservable();
 * observable.addListener(Events.Select, new Listener&lt;BaseEvent&gt;() {
 *   public void handleEvent(BaseEvent be) {
 * 
 *   }
 * });
 * observable.fireEvent(Events.Select, new BaseEvent());
 * </pre>
 */
public class BaseObservable implements Observable {

  private boolean firesEvents = true;
  private Map<EventType, List<Listener<BaseEvent>>> listeners;
  private boolean activeEvent;

  /**
   * Adds a listener bound by the given event type.
   * 
   * @param eventType the eventType
   * @param listener the listener to be added
   */
  @SuppressWarnings("unchecked")
  public void addListener(EventType eventType, Listener<? extends BaseEvent> listener) {
    if (listener == null) return;
    if (listeners == null) {
      listeners = new HashMap<EventType, List<Listener<BaseEvent>>>();
    }
    List<Listener<BaseEvent>> list = listeners.get(eventType);
    if (list == null) {
      list = new ArrayList<Listener<BaseEvent>>();
      listeners.put(eventType, list);
    }

    if (!list.contains(listener)) {
      list.add((Listener) listener);
    }
  }

  @SuppressWarnings("unchecked")
  public List<Listener<? extends BaseEvent>> getListeners(EventType eventType) {
    if (listeners == null) {
      listeners = new HashMap<EventType, List<Listener<BaseEvent>>>();
    }
    List<Listener<BaseEvent>> list = listeners.get(eventType);
    if (list == null) {
      list = new ArrayList<Listener<BaseEvent>>();
      listeners.put(eventType, list);
    }
    return (List) list;
  }

  /**
   * Fires an event.
   * 
   * @param eventType the event type
   * @return <code>true</code> if any listeners cancel the event.
   */
  public boolean fireEvent(EventType eventType) {
    return fireEvent(eventType, new BaseEvent(this));
  }

  /**
   * Fires an event.
   * 
   * @param eventType eventType the event type
   * @param be the base event
   * @return <code>true</code> if any listeners cancel the event.
   */
  public boolean fireEvent(EventType eventType, BaseEvent be) {
    if (firesEvents && hasListeners(eventType) && listeners != null) {
      activeEvent = true;
      be.setType(eventType);

      List<Listener<BaseEvent>> list = listeners.get(eventType);
      if (list != null) {
        List<Listener<BaseEvent>> copy = new ArrayList<Listener<BaseEvent>>(list);
        for (Listener<BaseEvent> l : copy) {
          callListener(l, be);
        }
      }
      activeEvent = false;
      return !be.isCancelled();
    }
    return true;
  }

  /**
   * Returns true if events are being fired.
   * 
   * @return the fire event state
   */
  public boolean getFiresEvents() {
    return firesEvents;
  }

  /**
   * Returns true if there is an active event
   * 
   * @return the active event start
   */
  public boolean hasActiveEvent() {
    return activeEvent;
  }

  public boolean hasListeners() {
    return listeners != null && listeners.size() > 0;
  }

  public boolean hasListeners(EventType eventType) {
    if (listeners != null && listeners.containsKey(eventType)) {
      List<Listener<BaseEvent>> list = listeners.get(eventType);
      if (list.size() != 0) {
        return true;
      }

    }
    return false;
  }

  /**
   * Removes all listeners.
   */
  public void removeAllListeners() {
    if (listeners != null) {
      listeners.clear();
    }
  }

  /**
   * Removes a listener.
   * 
   * @param eventType the event type
   * @param listener the listener to be removed
   */
  public void removeListener(final EventType eventType, final Listener<? extends BaseEvent> listener) {
    if (listeners == null) {
      return;
    }
    List<Listener<BaseEvent>> list = listeners.get(eventType);
    if (list != null) {
      list.remove(listener);
      if (list.isEmpty()) {
        listeners.remove(eventType);
      }
    }
  }

  /**
   * Sets whether events should be fired (defaults to true).
   * 
   * @param firesEvents true to fire events, false to disable events
   */
  public void setFiresEvents(boolean firesEvents) {
    this.firesEvents = firesEvents;
  }

  protected void callListener(Listener<BaseEvent> listener, BaseEvent be) {
    listener.handleEvent(be);
  }
}
