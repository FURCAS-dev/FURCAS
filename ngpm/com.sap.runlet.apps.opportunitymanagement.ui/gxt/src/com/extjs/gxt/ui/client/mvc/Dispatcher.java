/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.MvcEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

/**
 * Dispatchers are responsible for dispatching application events to
 * controllers.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Dispatcher.BeforeDispatch</b> : MvcEvent(dispatcher, appEvent)<br>
 * <div>Fires before an event is dispatched. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>dispatcher : this</li>
 * <li>appEvent : the application event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Dispatcher.AfterDispatch</b> : MvcEvent(dispatcher, appEvent)<br>
 * <div>Fires after an event has been dispatched.</div>
 * <ul>
 * <li>dispatcher : this</li>
 * <li>appEvent : the application event</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 * 
 * @see DispatcherListener
 */
public class Dispatcher extends BaseObservable {

  /**
   * Fires before an event is dispatched.
   */
  public static final EventType BeforeDispatch = new EventType();

  /**
   * Fires after an event has been dispatched.
   */
  public static final EventType AfterDispatch = new EventType();

  private static Dispatcher instance = new Dispatcher();

  /**
   * Forwards an application event to the dispatcher.
   * 
   * @param event the application event
   */
  public static void forwardEvent(AppEvent event) {
    instance.dispatch(event);
  }

  /**
   * Creates and forwards an application event to the dispatcher.
   * 
   * @param eventType the application event type
   */
  public static void forwardEvent(EventType eventType) {
    instance.dispatch(eventType);
  }

  /**
   * Creates and forwards an application event to the dispatcher.
   * 
   * @param eventType the application event type
   * @param data the event data
   */
  public static void forwardEvent(EventType eventType, Object data) {
    instance.dispatch(new AppEvent(eventType, data));
  }

  /**
   * Creates and forwards an application event to the dispatcher.
   * 
   * @param eventType the application event type
   * @param data the event data
   * @param historyEvent true to mark event as a history event
   */
  public static void forwardEvent(EventType eventType, Object data, boolean historyEvent) {
    AppEvent ae = new AppEvent(eventType, data);
    ae.setHistoryEvent(historyEvent);
    instance.dispatch(ae);
  }

  /**
   * Returns the singleton instance.
   * 
   * @return the dispatcher
   */
  public static Dispatcher get() {
    return instance;
  }

  private Map<String, AppEvent> history;

  private List<Controller> controllers;

  private Dispatcher() {
    controllers = new ArrayList<Controller>();
    history = new FastMap<AppEvent>();
    History.addValueChangeHandler(new ValueChangeHandler<String>() {

      public void onValueChange(ValueChangeEvent<String> event) {
        String historyToken = event.getValue();
        if (history.containsKey(historyToken)) {
          dispatch(history.get(historyToken), false);
        }
        
      }
      
    });
  }

  /**
   * Adds a controller.
   * 
   * @param controller the controller to be added
   */
  public void addController(Controller controller) {
    if (!controllers.contains(controller)) {
      controllers.add(controller);
    }
  }

  /**
   * Adds a listener to receive dispatch events.
   * 
   * @param listener the listener to add
   */
  public void addDispatcherListener(DispatcherListener listener) {
    addListener(BeforeDispatch, listener);
    addListener(AfterDispatch, listener);
  }

  /**
   * The dispatcher will query its controllers and pass the application event to any
   * controllers that can handle the particular event type.
   * 
   * @param event the application event
   */
  public void dispatch(AppEvent event) {
    dispatch(event, event.isHistoryEvent());
  }

  /**
   * The dispatcher will query its controllers and pass the application event to
   * controllers that can handle the particular event type.
   * 
   * @param type the event type
   */
  public void dispatch(EventType type) {
    dispatch(new AppEvent(type));
  }

  /**
   * The dispatcher will query its controllers and pass the application event to
   * controllers that can handle the particular event type.
   * 
   * @param type the event type
   * @param data the app event data
   */
  public void dispatch(EventType type, Object data) {
    dispatch(new AppEvent(type, data));
  }

  /**
   * Returns all controllers.
   * 
   * @return the list of controllers
   */
  public List<Controller> getControllers() {
    return controllers;
  }

  /**
   * Returns the dispatcher's history cache.
   * 
   * @return the history
   */
  public Map<String, AppEvent> getHistory() {
    return history;
  }

  /**
   * Removes a controller.
   * 
   * @param controller the controller to be removed
   */
  public void removeController(Controller controller) {
    controllers.remove(controller);
  }

  /**
   * Removes a previously added listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeDispatcherListener(DispatcherListener listener) {
    removeListener(BeforeDispatch, listener);
    removeListener(AfterDispatch, listener);
  }

  private void dispatch(AppEvent event, boolean createhistory) {
    MvcEvent e = new MvcEvent(this, event);
    e.setAppEvent(event);
    if (fireEvent(BeforeDispatch, e)) {
      for (Controller controller : controllers) {
        if (controller.canHandle(event)) {
          if (!controller.initialized) {
            controller.initialized = true;
            controller.initialize();
          }
          controller.handleEvent(event);
        }
      }
      fireEvent(AfterDispatch, e);
    }
    if (createhistory && event.isHistoryEvent()) {
      String token = event.getToken();
      if (token == null) {
        token = "" + new Date().getTime();
      }
      history.put(token, event);
      History.newItem(token, false);
    }
  }

}
