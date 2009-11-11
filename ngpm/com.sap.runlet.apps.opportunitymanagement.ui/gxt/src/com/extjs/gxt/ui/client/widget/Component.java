/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HideMode;
import com.extjs.gxt.ui.client.aria.FocusFrame;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.Observable;
import com.extjs.gxt.ui.client.event.WidgetListener;
import com.extjs.gxt.ui.client.state.StateManager;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.util.SwallowEvent;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.tips.ToolTip;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base class for GXT components. All subclasses of Component can automatically
 * participate in the standard GXT component lifecycle of creation, attach and
 * detach. They also have automatic support for basic hide/show and
 * enable/disable behavior. Component allows any subclass to be lazy-rendered
 * into any GXT {@link Container}. Components added to a GWT {@link Panel} will
 * be rendered when inserted. All visual widgets that require rendering into a
 * layout should subclass Component (or {@link BoxComponent} if managed box
 * model handling is required).
 * 
 * <p />
 * The following 4 methods inherited from UIObject (setSize, setWidth,
 * setHeight, setPixelSize) have been overridden and do nothing. Any component
 * whose size can change should subclass {@link BoxComponent}.
 * 
 * <p />
 * All components are registered and unregistered with the @link
 * {@link ComponentManager} when the are attached and detached.
 * 
 * <dl>
 * <dt>Events:</dt>
 * 
 * <dd><b>Enable</b> : ComponentEvent(component)<br>
 * <div>Fires after the component is enabled.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Disable</b> : ComponentEvent(component)<br>
 * <div>Fires after the component is disabled.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeHide</b> : ComponentEvent(component)<br>
 * <div>Fires before the component is hidden. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeShow</b> : ComponentEvent(component)<br>
 * <div>Fires before the component is shown. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Hide</b> : ComponentEvent(component)<br>
 * <div>Fires after the component is hidden.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Show</b> : ComponentEvent(component)<br>
 * <div>Fires after the component is shown.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Attach</b> : ComponentEvent(component)<br>
 * <div>Fires after the component is attached.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Detach</b> : ComponentEvent(component) <br>
 * <div>Fires after the component is detached.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRender</b> : ComponentEvent(component)<br>
 * <div>Fires before the component is rendered. Listeners can cancel the action
 * by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Render</b> : ComponentEvent(component)<br>
 * <div>Fires after the component is rendered.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BrowserEvent</b> : ComponentEvent(component, event)<br>
 * <div>Fires on any browser event the component receives. Listeners will be
 * called prior to any event processing and before
 * {@link #onComponentEvent(ComponentEvent)} is called. Listeners can call
 * {@link BaseEvent#setCancelled(boolean)} to cancel the processing of the
 * event.</div>
 * <ul>
 * <li>component : this</li>
 * <li>event : event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeStateRestore</b> : ComponentEvent(component, state)<br>
 * <div>Fires before the state of the component is restored. Listeners can
 * cancel the action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>component : this</li>
 * <li>state : the state values
 * </ul>
 * </dd>
 * 
 * <dd><b>StateRestore</b> : ComponentEvent(component, state)<br>
 * <div>Fires after the state of the component is restored.</div>
 * <ul>
 * <li>component : this</li>
 * <li>state : map of state key / value pairs</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeStateSave</b> : ComponentEvent(component, state)<br>
 * <div>Fires before the state of the component is saved to the configured state
 * provider.</div>
 * <ul>
 * <li>component : this</li>
 * <li>state : map of state key / value pairs</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>StateSave</b> : ComponentEvent(component, state)<br>
 * <div>Fires after the state of the component is saved to the configured state
 * provider.</div>
 * <ul>
 * <li>component : this</li>
 * <li>state : map of state key / value pairs</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 * 
 * @see ComponentManager
 */
public abstract class Component extends Widget implements Observable {

  static {
    GXT.init();
  }

  /**
   * The base style is typically set as the component's style when rendered. All
   * child styles should be calculated based on the base style when the
   * component is rendered. This allows a component's style to be swapped by
   * simply modifying the base style (defaults to null).
   */
  protected String baseStyle;

  /**
   * True if the component is disabled. Read only.
   */
  protected boolean disabled;

  /**
   * The style used when a component is disabled (defaults to
   * 'x-item-disabled').
   */
  protected String disabledStyle = "x-item-disabled";

  protected Element dummy;

  /**
   * True if the component is can receive focus (defaults to false). A hidden
   * input field will be created created for Safari.
   */
  protected boolean focusable;

  /**
   * True if this component is hidden. Read only.
   */
  protected boolean hidden;

  protected boolean hideParent;

  /**
   * True if this component has been rendered. Read-only.
   */
  protected boolean rendered;
  /**
   * True to enable state (defaults to true).
   */
  protected boolean stateful = true;

  /**
   * The state id (defaults to null).
   */
  protected String stateId;
  protected List<SwallowEvent> swallowEvents;
  protected ToolTip toolTip;

  protected boolean mask;
  protected String maskMessage;
  protected String maskMessageStyleName;

  protected List<ComponentAttachable> attachables;

  private boolean afterRender;
  private int borders = Style.DEFAULT;
  private Menu contextMenu;
  private Map<String, Object> dataMap;
  private boolean disableBrowserEvents;
  private int disableContextMenu = Style.DEFAULT;
  private boolean disableEvents;
  private int disableTextSelection = Style.DEFAULT;
  private El el;
  private boolean enableState = true;
  private int events;
  private boolean focused;
  private El focusEl;
  private HideMode hideMode = HideMode.DISPLAY;
  private String id, itemId, cls, title;
  private LayoutData layoutData;
  private ModelData model;
  private Observable observable;
  private Map<String, String> overElements;
  private List<ComponentPlugin> plugins;
  private boolean setElementRender;
  private Map<String, Object> state;
  private String styles = "";
  private ToolTipConfig toolTipConfig;

  protected boolean monitorWindowResize;
  protected int windowResizeDelay = 100;
  protected DelayedTask windowResizeTask;
  protected HandlerRegistration resizeHandler;

  /**
   * Creates a new component..
   */
  public Component() {
    observable = createObservable();
  }

  /**
   * Specialized constructor for creating components from existing nodes. The
   * given element should be part of the dom and have a a parent element.
   * 
   * @param element the element
   * @param attach true to attach the component
   */
  protected Component(Element element, boolean attach) {
    this();
    setElement(element);
    render(DOM.getParent(element));
    if (attach) {
      onAttach();
    }
  }

  /**
   * Appends an event handler to this component.
   * 
   * @param eventType the eventType
   * @param listener the listener to be added
   */
  public void addListener(EventType eventType, Listener<? extends BaseEvent> listener) {
    observable.addListener(eventType, listener);
  }

  /**
   * Adds a component plugin.
   * 
   * @param plugin the component plugin
   */
  public void addPlugin(ComponentPlugin plugin) {
    assertPreRender();
    if (plugins == null) {
      plugins = new ArrayList<ComponentPlugin>();
    }
    plugins.add(plugin);
  }

  /**
   * Adds a CSS style name to the component's underlying element.
   * 
   * @param style the CSS style name to add
   */
  public void addStyleName(String style) {
    if (rendered) {
      fly(getStyleElement()).addStyleName(style);
    } else {
      cls = cls == null ? style : cls + " " + style;
    }
  }

  /**
   * Adds a listener to receive widget events.
   * 
   * @param listener the listener to be added
   */
  public void addWidgetListener(WidgetListener listener) {
    addListener(Events.Attach, listener);
    addListener(Events.Detach, listener);
    addListener(Events.Resize, listener);
  }

  /**
   * Clears the component's state.
   */
  public void clearState() {
    if (state != null) {
      state.clear();
      saveState();
    }
  }

  /**
   * Disable this component. Fires the <i>Disable</i> event.
   */
  public void disable() {
    if (rendered) {
      onDisable();
    }
    disabled = true;
    fireEvent(Events.Disable);
  }

  /**
   * True to disable event processing.
   * 
   * @param disable true to disable
   */
  public void disableEvents(boolean disable) {
    disableEvents = disable;
  }

  /**
   * Enables and disables text selection for the component.
   * 
   * @param disable <code>true</code> to disable text selection
   */
  public void disableTextSelection(boolean disable) {
    disableTextSelection = disable ? 1 : 0;
    if (isAttached()) {
      el.disableTextSelection(disable);
    }
  }

  /**
   * Returns the component's el instance.
   * 
   * @return the el instance
   */
  public El el() {
    assertAfterRender();
    return el;
  }

  /**
   * Enable this component. Fires the <i>Enable</i> event.
   */
  public void enable() {
    if (rendered) {
      onEnable();
    }
    disabled = false;
    fireEvent(Events.Enable);
  }

  /**
   * Enables or disables event processing.
   * 
   * @param enable the enable state
   */
  public void enableEvents(boolean enable) {
    disableEvents = !enable;
  }

  /**
   * Fires an event with the given event type.
   * 
   * @param type the event type
   * @return <code>false</code> if any listeners return <code>false</code>
   */
  public boolean fireEvent(EventType type) {
    if (disableEvents || !hasListeners(type)) return true;
    ComponentEvent be = createComponentEvent(null);
    be.setType(type);
    return fireEvent(type, be);
  }

  public boolean fireEvent(EventType eventType, BaseEvent be) {
    if (disableEvents || !hasListeners(eventType)) return true;
    return observable.fireEvent(eventType, be);
  }

  /**
   * Fires the specified event with the given event type.
   * 
   * @param type the event type
   * @param ce the base event
   * @return <code>false</code> if any listeners return <code>false</code>
   */
  public boolean fireEvent(EventType type, ComponentEvent ce) {
    if (disableEvents || !hasListeners(type)) return true;
    return observable.fireEvent(type, previewEvent(type, ce));
  }

  /**
   * Returns the global flyweight instance.
   * 
   * @param elem the new wrapped dom element
   * @return the global flyweight instance
   */
  public El fly(Element elem) {
    return El.fly(elem, "component");
  }

  /**
   * Try to focus this component. Fires the <i>Focus</i> event.
   */
  public void focus() {
    this.focused = true;
    if (rendered) {
      getFocusEl().focus();
    }
    fireEvent(Events.Focus);
  }

  /**
   * Returns the component's base style.
   * 
   * @return the base style
   */
  public String getBaseStyle() {
    return baseStyle;
  }

  /**
   * Returns the component's border state.
   * 
   * @return true if borders are visible
   */
  public boolean getBorders() {
    return borders > 0;
  }

  /**
   * Returns the application defined property for the given name, or
   * <code>null</code> if it has not been set.
   * 
   * @param key the name of the property
   * @return the value or <code>null</code> if it has not been set
   */
  @SuppressWarnings("unchecked")
  public <X> X getData(String key) {
    if (dataMap == null) return null;
    return (X) dataMap.get(key);
  }

  @Override
  public Element getElement() {
    // if getElement is called before a component is rendered then the caller is
    // a gwt panel. a proxy element is returned and the component will be
    // rendered when it is attached
    if (!rendered) {
      if (dummy == null) dummy = DOM.createDiv();
      return dummy;
    }
    return super.getElement();
  }

  /**
   * Returns the component's hide mode.
   * 
   * @return the hide mode
   */
  public HideMode getHideMode() {
    return hideMode;
  }

  /**
   * Returns the id of this component. A new id is generated if an id has not
   * been set.
   * 
   * @return the component's id
   */
  public String getId() {
    if (id == null) {
      id = XDOM.getUniqueId();
      setId(id);
      return id;
    }
    return id;
  }

  /**
   * Returns the item id of this component. Unlike the component's id, the item
   * id does not have to be unique.
   * 
   * @return the component's item id
   */
  public String getItemId() {
    return itemId != null ? itemId : getId();
  }

  public List<Listener<? extends BaseEvent>> getListeners(EventType eventType) {
    return observable.getListeners(eventType);
  }

  /**
   * Returns the component's model.
   * 
   * @return the model
   */
  @SuppressWarnings("unchecked")
  public <X> X getModel() {
    return (X) model;
  }

  /**
   * Returns the component's state.
   * 
   * @return the state
   */
  public Map<String, Object> getState() {
    if (!enableState || state == null) {
      state = new FastMap<Object>();
    }
    return state;
  }

  /**
   * Returns the component's tool tip.
   * 
   * @return the tool tip
   */
  public ToolTip getToolTip() {
    if (toolTip == null && toolTipConfig != null) {
      toolTip = new ToolTip(this, toolTipConfig);
    }
    return toolTip;
  }

  public boolean hasListeners() {
    return observable.hasListeners();
  }

  public boolean hasListeners(EventType eventType) {
    return observable.hasListeners(eventType);
  }

  /**
   * Hide this component. Fires the <i>BeforeHide</i> event before the component
   * is hidden, the fires the <i>Hide</i> event after the component is hidden.
   */
  public void hide() {
    if (fireEvent(Events.BeforeHide)) {
      hidden = true;
      if (rendered) {
        onHide();
      }
      fireEvent(Events.Hide);
    }
  }

  /**
   * Hides the component's tool tip (if one exists).
   */
  public void hideToolTip() {
    if (toolTip != null) {
      toolTip.hide();
    }
  }

  /**
   * Returns true if events are disabled.
   * 
   * @return true if events disabled
   */
  public boolean isDisabledEvents() {
    return disableEvents;
  }

  /**
   * Returns <code>true</code> if the component is enabled.
   * 
   * @return the enabled state
   */
  public boolean isEnabled() {
    return !disabled;
  }

  /**
   * Returns <code>true</code> if the component is rendered.
   * 
   * @return the rendered state
   */
  public boolean isRendered() {
    return rendered;
  }

  /**
   * Returns <code>true</code> if the component is visible.
   */
  public boolean isVisible() {
    return rendered && !hidden && el().isVisible(true);
  }

  /**
   * Puts a mask over this component to disable user interaction.
   * 
   * @return the mask element
   */
  public El mask() {
    return mask(null, null);
  }

  /**
   * Puts a mask over this component to disable user interaction.
   * 
   * @param message a message to display in the mask
   * @return the mask element
   */
  public El mask(String message) {
    return mask(message, null);
  }

  /**
   * Puts a mask over this component to disable user interaction.
   * 
   * @param message a message to display in the mask
   * @param messageStyleName a CSS style name to be applied to the message text
   * @return the mask element
   */
  public El mask(String message, String messageStyleName) {
    mask = true;
    maskMessage = message;
    maskMessageStyleName = messageStyleName;
    if (rendered) {
      return el().mask(message, messageStyleName);
    }
    return null;
  }

  /**
   * Components delegate event handling to
   * {@link #onComponentEvent(ComponentEvent)}. Subclasses should not override.
   * 
   * @param event the dom event
   */
  public void onBrowserEvent(Event event) {
    if (disabled || disableEvents || disableBrowserEvents) {
      return;
    }

    int type = DOM.eventGetType(event);

    Element eventTarget = (Element) event.getEventTarget().cast();
    if (swallowEvents != null) {
      for (SwallowEvent e : swallowEvents) {
        if (e.getEventType().getEventCode() == type
            && e.getElement().isOrHasChild(eventTarget)) {
          event.stopPropagation();
          if (e.isPreventDefault()) {
            event.preventDefault();
          }
        }
      }
    }

    // hack to receive keyboard events in safari
    if (GXT.isWebKit && type == Event.ONCLICK && focusable) {
      if (getElement().getTagName().equals("input")
          || eventTarget.getPropertyString("__eventBits") == null) {
        focus();
      }
    }

    EventType eventType = Events.lookupBrowserEvent(type);

    ComponentEvent ce = createComponentEvent(event);
    ce.setEvent(event);
    ce.setType(eventType);

    // browser event listeners can cancel event
    if (!fireEvent(Events.BrowserEvent, ce)) {
      return;
    }

    if (type == (GXT.isSafari && GXT.isMac ? Event.ONMOUSEDOWN : Event.ONMOUSEUP)
        && ce.isRightClick()) {
      onRightClick(ce);
    }

    // specialized support for mouse overs
    if (overElements != null && (type == Event.ONMOUSEOVER || type == Event.ONMOUSEOUT)) {
      El target = ce.getTargetEl();
      String style = overElements.get(target.getId());
      if (style != null) {
        target.setStyleName(style, type == Event.ONMOUSEOVER);
      }
    }

    onComponentEvent(ce);

    fireEvent(eventType, ce);
    DomEvent.fireNativeEvent(event, this, getElement());
  }

  /**
   * Any events a component receives will be forwarded to this method.
   * Subclasses should override as needed. The {@link #onBrowserEvent} method
   * should not be overridden or modified.
   * 
   * @param ce the base event
   */
  public void onComponentEvent(ComponentEvent ce) {
  }

  /**
   * Called when the component is in a LayoutContainer and the container's
   * layout executes. This method will not be called on container instances.
   * Default implementation does nothing.
   */
  public void recalculate() {

  }

  /**
   * Removes all listeners.
   */
  public void removeAllListeners() {
    observable.removeAllListeners();
  }

  @SuppressWarnings("unchecked")
  @Override
  public void removeFromParent() {
    if (getParent() instanceof Container) {
      ((Container) getParent()).remove(this);
      return;
    }
    super.removeFromParent();
  }

  /**
   * Removes a listener.
   * 
   * @param eventType the event type
   * @param listener the listener to be removed
   */
  public void removeListener(EventType eventType, Listener<? extends BaseEvent> listener) {
    observable.removeListener(eventType, listener);
  }

  /**
   * Removes a CSS style name from the component's underlying element.
   * 
   * @param style the CSS style name to remove
   */
  public void removeStyleName(String style) {
    if (rendered) {
      fly(getStyleElement()).removeStyleName(style);
    } else if (style != null && cls != null) {
      String[] s = cls.split(" ");
      cls = "";
      for (int i = 0; i < s.length; i++) {
        if (!s[i].equals(style)) {
          cls += " " + s[i];
        }
      }
    }
  }

  /**
   * Removes a swallow event.
   * 
   * @param e the swallow event to be removed
   */
  public void removeSwallow(SwallowEvent e) {
    swallowEvents.remove(e);
  }

  /**
   * Removes a listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeWidgetListener(WidgetListener listener) {
    if (observable.hasListeners()) {
      observable.removeListener(Events.Attach, listener);
      observable.removeListener(Events.Detach, listener);
      observable.removeListener(Events.Resize, listener);
    }
  }

  /**
   * Renders the element. Typically, this method does not need to be called
   * directly. A component will rendered by its parent if it is a container, or
   * rendered when attached if added to a gwt panel.
   * 
   * @param target the element this component should be rendered into
   */
  public void render(Element target) {
    render(target, -1);
  }

  /**
   * Renders the element. Typically, this method does not need to be called
   * directly. A component will rendered by its parent if it is a container, or
   * rendered when attached if added to a gwt panel.
   * 
   * @param target the element this component should be rendered into
   * @param index the index within the container <b>before</b> which this
   *          component will be inserted (defaults to appending to the end of
   *          the container if value is -1)
   */
  public void render(Element target, int index) {
    if (rendered || !fireEvent(Events.BeforeRender)) {
      return;
    }

    beforeRender();

    if (plugins != null) {
      for (ComponentPlugin plugin : plugins) {
        plugin.init(this);
      }
    }

    rendered = true;

    createStyles(baseStyle);

    if (!setElementRender) {
      if (index == -1) {
        index = DOM.getChildCount(target);
      }

      onRender(target, index);
    }

    if (el == null)
      throw new RuntimeException(getClass().getName()
          + " must call setElement in onRender");

    if (events != 0) {
      el().addEventsSunk(events);
    }

    if (id == null) {
      id = el.getId();
      if (id == null || id.equals("")) {
        id = XDOM.getUniqueId();
      }
    }
    getElement().setId(id);

    addStyleName(baseStyle);

    if (cls != null) {
      addStyleName(cls);
      cls = null;
    }

    if (title != null) {
      setTitle(title);
    }

    if (styles != null && !styles.equals("")) {
      el.applyStyles(styles);
      styles = null;
    }

    if (toolTipConfig != null) {
      setToolTip(toolTipConfig);
    }

    if (focused) {
      DeferredCommand.addCommand(new Command() {
        public void execute() {
          focus();
        }
      });
    }

    if (borders != Style.DEFAULT) {
      setBorders(borders == 1);
    }

    if (focusable && GXT.isWebKit) {
      focusEl = new El(createHiddenInput());
      getElement().appendChild(focusEl.dom);
    }

    afterRender = true;
    afterRender();

    if (hidden) {
      hide();
    }

    if (disabled) {
      disable();
    }

    initState();

    fireEvent(Events.Render);
  }

  /**
   * Repaints the component if rendered.
   */
  public void repaint() {
    if (rendered) {
      el().repaint();
    }
  }

  /**
   * Saves the component's current state.
   */
  public void saveState() {
    if (enableState && state != null) {
      ComponentEvent ce = createComponentEvent(null);
      ce.setState(state);
      if (fireEvent(Events.BeforeStateSave, ce)) {
        String sid = stateId != null ? stateId : getId();
        StateManager.get().set(sid, state);
        fireEvent(Events.StateSave, ce);
      }
    }
  }

  /**
   * Adds or removes a border. The style name 'x-border' is added to the widget
   * to display a border.
   * 
   * @param show <code>true</code> to display a border
   */
  public void setBorders(boolean show) {
    borders = show ? 1 : 0;
    if (rendered) {
      fly(getStyleElement()).setBorders(show);
    }
  }

  /**
   * Sets the application defined property with the given name.
   * 
   * @param key the name of the property
   * @param data the new value for the property
   */
  public void setData(String key, Object data) {
    if (dataMap == null) dataMap = new FastMap<Object>();
    dataMap.put(key, data);
  }

  // make public
  public void setElement(Element elem) {
    el = new El(elem);
    super.setElement(elem);
    if (!rendered) {
      setElementRender = true;
      render(null);
    }
  }

  /**
   * Convenience function for setting disabled/enabled by boolean.
   * 
   * @param enabled the enabled state
   */
  public void setEnabled(boolean enabled) {
    if (!enabled) {
      disable();
    } else {
      enable();
    }
  }

  /**
   * Sets whether the component's state is enabled (defaults to true).
   * 
   * @param enable true to enable
   */
  public void setEnableState(boolean enable) {
    this.enableState = enable;
  }

  /**
   * Overrides UIObject and does nothing.
   */
  public void setHeight(String height) {
  }

  /**
   * Sets the components hide mode (default to HideMode.DISPLAY).
   * 
   * @param hideMode the hide mode.
   */
  public void setHideMode(HideMode hideMode) {
    this.hideMode = hideMode;
  }

  /**
   * Sets the component's id.
   * 
   * @param id the new id
   */
  public void setId(String id) {
    this.id = id;
    if (el != null) {
      DOM.setElementProperty(getElement(), "id", id);
    }
  }

  /**
   * Sets a style attribute.
   * 
   * @param attr the attribute
   * @param value the attribute value
   */
  public void setIntStyleAttribute(String attr, int value) {
    setStyleAttribute(attr, "" + value);
  }

  /**
   * Sets the component's item id.
   * 
   * @param id the item id
   */
  public void setItemId(String id) {
    this.itemId = id;
  }

  /**
   * Overrides UIObject and does nothing.
   */
  public void setPixelSize(int width, int height) {
  }

  /**
   * Overrides UIObject and does nothing.
   */
  public void setSize(String width, String height) {
  }

  /**
   * Sets a style attribute.
   * 
   * @param attr the attribute
   * @param value the attribute value
   */
  public void setStyleAttribute(String attr, String value) {
    if (rendered) {
      el().setStyleAttribute(attr, value);
    } else {
      styles += attr + ":" + value + ";";
    }
  }

  @Override
  public void setStyleName(String style) {
    if (rendered) {
      super.setStyleName(style);
    } else {
      cls = style;
    }
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
    if (rendered) {
      super.setTitle(title);
    }
  }

  /**
   * Sets the component's tool tip.
   * 
   * @param text the text
   */
  public void setToolTip(String text) {
    if (toolTipConfig == null) {
      toolTipConfig = new ToolTipConfig();
    }
    toolTipConfig.setText(text);
    setToolTip(toolTipConfig);
  }

  /**
   * Sets the component's tool tip with the given config.
   * 
   * @param config the tool tip config
   */
  public void setToolTip(ToolTipConfig config) {
    this.toolTipConfig = config;
    if (rendered) {
      if (toolTip == null) {
        toolTip = new ToolTip(this, config);
      } else {
        toolTip.update(config);
      }
    }
  }

  /**
   * Convenience function to hide or show this component by boolean.
   * 
   * @param visible the visible state
   */
  public void setVisible(boolean visible) {
    if (visible) {
      show();
    } else {
      hide();
    }
  }

  /**
   * Overrides UIObject and does nothing.
   */
  public void setWidth(String width) {
  }

  public void setZIndex(int zIndex) {
    el().setZIndex(zIndex);
    FocusFrame.get().sync(this);
  }

  /**
   * Show this component. Fires the <i>BeforeShow</i> event before the component
   * is made visible, then fires the <i>Show</i> event after the component is
   * visible.
   */
  public void show() {
    if (fireEvent(Events.BeforeShow)) {
      hidden = false;
      if (rendered) {
        onShow();
      }
      fireEvent(Events.Show);
    }
  }

  @Override
  public void sinkEvents(int eventBitsToAdd) {
    if (!rendered) {
      this.events = this.events | eventBitsToAdd;
    } else {
      super.sinkEvents(eventBitsToAdd);
    }
  }

  /**
   * Adds a swallow event. When enabled, any events of the given type whose
   * target is or is a child of the given element are swallowed.
   * 
   * @param eventType the event type
   * @param element the target element
   * @param preventDefault true to prevent the default action
   * @return the swallow event config that can be used when removing a
   *         swallowing event
   */
  public SwallowEvent swallowEvent(EventType eventType, Element element,
      boolean preventDefault) {
    return swallowEvent(new SwallowEvent(eventType, element, preventDefault));
  }

  public SwallowEvent swallowEvent(SwallowEvent e) {
    assert e.getEventType().isBrowserEvent() : "only browserevents are supported here";
    if (swallowEvents == null) {
      swallowEvents = new ArrayList<SwallowEvent>();
    }
    swallowEvents.add(e);
    return e;
  }

  @Override
  public String toString() {
    return el != null ? el.toString() : super.toString();
  }

  /**
   * Unmasks the component.
   */
  public void unmask() {
    mask = false;
    maskMessage = null;
    maskMessageStyleName = null;
    if (rendered) {
      el().unmask();
    }
  }

  protected void addAttachable(ComponentAttachable a) {
    if (attachables == null) {
      attachables = new ArrayList<ComponentAttachable>();
    }
    attachables.add(a);
  }

  /**
   * Adds a style to the given element on mouseover. The component must be
   * sinking mouse events for the over style to function.
   * 
   * @param elem the over element
   * @param style the style to add
   */
  protected void addStyleOnOver(Element elem, String style) {
    if (overElements == null) {
      overElements = new FastMap<String>();
    }
    overElements.put(fly(elem).getId(), style);
  }

  /**
   * Called after the component has been rendered and is attached for the first
   * time. At this time, the component will be part of the DOM which is required
   * when retrieving location and offsets.
   */
  protected void afterRender() {
    if (mask) {
      mask(maskMessage, maskMessageStyleName);
    }
  }

  protected void applyState(Map<String, Object> state) {

  }

  protected void assertAfterRender() {
    assert rendered : "Method must be called after the component is rendered";
  }

  protected void assertPreRender() {
    assert !afterRender : "Method must be called before the component is rendered";
  }

  /**
   * Called before the component has been rendered.
   * 
   * <p/>
   * This method can be used to lazily alter this component pre-render
   */
  protected void beforeRender() {
  }

  /**
   * Tries to remove focus from the component. Fires the <i>Blur</i> event.
   */
  protected void blur() {
    if (rendered) {
      getFocusEl().blur();
    }
    fireEvent(Events.Blur);
  }

  protected ComponentEvent createComponentEvent(Event event) {
    return new ComponentEvent(this, event);
  }

  protected Observable createObservable() {
    return new BaseObservable();
  }

  protected void createStyles(String baseStyle) {

  }

  /**
   * Enables and disables the component's context menu.
   * 
   * @param disable <code>true</code> to disable the context menu
   */
  protected void disableContextMenu(boolean disable) {
    disableContextMenu = disable ? 1 : 0;
    if (isAttached()) {
      el.disableContextMenu(disable);
    }
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    if (attachables != null) {
      for (ComponentAttachable a : attachables) {
        a.doAttach();
      }
    }
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    if (attachables != null) {
      for (ComponentAttachable a : attachables) {
        a.doDetach();
      }
    }
  }

  protected void frame() {
    FocusFrame.get().frame(this);
  }

  /**
   * Returns the component's context menu. This method is marked protected,
   * subclasses can change access to public to expose the context menu.
   * 
   * @return the context menu
   */
  protected Menu getContextMenu() {
    return contextMenu;
  }

  protected El getFocusEl() {
    return focusEl == null ? el : focusEl;
  }

  protected LayoutData getLayoutData() {
    return layoutData;
  }

  protected Observable getObservable() {
    return observable;
  }

  /**
   * Returns the window resize delay.
   * 
   * @return the delay
   */
  protected int getWindowResizeDelay() {
    return windowResizeDelay;
  }

  protected void initState() {
    String sid = stateId != null ? stateId : getId();
    Map<String, Object> st = StateManager.get().getMap(sid);
    if (st != null) {
      state = st;
      ComponentEvent ce = createComponentEvent(null);
      ce.setState(state);
      if (fireEvent(Events.BeforeStateRestore, ce)) {
        applyState(state);
        fireEvent(Events.StateRestore, ce);
      }
    }
  }

  /**
   * Returns true if browser resizing is monitored
   * 
   * @return true if window resize monitoring is enabled
   */
  protected boolean isMonitorWindowResize() {
    return monitorWindowResize;
  }

  @Override
  protected void onAttach() {
    // added to a gwt panel, not rendered
    if (!rendered) {
      // render and swap the proxy element
      String widgetIndex = dummy.getPropertyString("__widgetID");
      Element parent = DOM.getParent(dummy);
      int index = DOM.getChildIndex(parent, dummy);
      parent.removeChild(dummy);
      render(parent, index);
      if (widgetIndex != null) {
        getElement().setPropertyInt("__widgetID", Integer.parseInt(widgetIndex));
      }
    }
    if (disableTextSelection > 0) {
      el.disableTextSelection(disableTextSelection == 1);
    }
    if (disableContextMenu > 0) {
      el.disableContextMenu(disableContextMenu == 1);
    }

    super.onAttach();

    if (monitorWindowResize) {
      if (windowResizeTask == null) {
        windowResizeTask = new DelayedTask(new Listener<BaseEvent>() {
          public void handleEvent(BaseEvent be) {
            onWindowResize(Window.getClientWidth(), Window.getClientHeight());
          }
        });
      }
      resizeHandler = Window.addResizeHandler(new ResizeHandler() {
        public void onResize(ResizeEvent event) {
          windowResizeTask.delay(windowResizeDelay);
        }
      });
    }

  }

  @Override
  protected void onDetach() {
    hideToolTip();

    FocusFrame.get().hide(this);

    if (disableTextSelection > 0) {
      el.disableTextSelection(false);
    }
    if (disableContextMenu > 0) {
      el.disableContextMenu(false);
    }

    if (resizeHandler != null) {
      resizeHandler.removeHandler();
      resizeHandler = null;
    }

    super.onDetach();

    fireEvent(Events.Detach);
    ComponentManager.get().unregister(this);
  }

  protected void onDisable() {
    addStyleName(disabledStyle);
  }

  protected void onEnable() {
    removeStyleName(disabledStyle);
  }

  @Override
  protected void onEnsureDebugId(String baseID) {
    setId(DEBUG_ID_PREFIX + baseID);
  }

  protected void onHide() {
    if (hideParent) {
      el().getParent().addStyleName("x-hide-" + hideMode.name().toLowerCase());
    } else {
      addStyleName("x-hide-" + hideMode.name().toLowerCase());
    }
    hideToolTip();
    FocusFrame.get().hide(this);
  }

  protected void onHideContextMenu() {

  }

  @Override
  protected void onLoad() {
    super.onLoad();
    fireEvent(Events.Attach);
    ComponentManager.get().register(this);
  }

  /**
   * Subclasses must override and ensure setElement is called for lazy rendered
   * components.
   * 
   * @param target the target element
   * @param index the insert location
   */
  protected void onRender(Element target, int index) {
  }

  protected void onRightClick(final ComponentEvent ce) {
    if (contextMenu != null) {
      ce.stopEvent();
      final int x = ce.getClientX();
      final int y = ce.getClientY();
      if (fireEvent(Events.ContextMenu, ce)) {
        DeferredCommand.addCommand(new Command() {
          public void execute() {
            onShowContextMenu(x, y);
          }
        });
      }
    }
  }

  protected void onShow() {
    if (hideParent) {
      el().getParent().removeStyleName("x-hide-" + hideMode.name().toLowerCase());
    } else {
      removeStyleName("x-hide-" + hideMode.name().toLowerCase());
    }

    FocusFrame.get().show(this);
  }

  protected void onShowContextMenu(int x, int y) {
    contextMenu.showAt(x, y);
    if (contextMenu.isVisible()) {
      contextMenu.addListener(Events.Hide, new Listener<ComponentEvent>() {
        public void handleEvent(ComponentEvent ce) {
          contextMenu.removeListener(Events.Hide, this);
          onHideContextMenu();
        }
      });
    }
  }

  protected void onWindowResize(int width, int height) {
  }

  protected ComponentEvent previewEvent(EventType type, ComponentEvent ce) {
    return ce;
  }

  protected void removeAttachagle(ComponentAttachable a) {
    if (attachables != null) {
      attachables.remove(a);
    }
  }

  protected void removeStyleOnOver(Element elem) {
    if (overElements != null) {
      overElements.remove(fly(elem).getId());
    }
  }

  /**
   * Sets the component's context menu.
   * 
   * @param menu the context menu
   */
  protected void setContextMenu(Menu menu) {
    contextMenu = menu;
    disableContextMenu(true);
    sinkEvents(GXT.isSafari && GXT.isMac ? Event.ONMOUSEDOWN : Event.ONMOUSEUP);
  }

  protected void setEl(El el) {
    this.el = el;
  }

  protected void setElement(Element elem, Element parent, int index) {
    setElement(elem);
    DOM.insertChild(parent, elem, index);
  }

  protected void setFiresEvents(boolean firesEvents) {
    if (observable instanceof BaseObservable) {
      ((BaseObservable) observable).setFiresEvents(firesEvents);
    }
  }

  protected void setLayoutData(LayoutData data) {
    this.layoutData = data;
  }

  protected void setModel(ModelData model) {
    this.model = model;
  }

  /**
   * True to have onWindowResize executed when the browser window is resized
   * (default to false).
   * 
   * You need to override onWindowResize to get your needed functionality
   * 
   * @param monitorWindowResize true to monitor window resizing
   */
  protected void setMonitorWindowResize(boolean monitorWindowResize) {
    this.monitorWindowResize = monitorWindowResize;
  }

  /**
   * Sets delay in milliseconds used to buffer window resizing (defaults to
   * 100).
   * 
   * @param delay the delay
   */
  protected void setWindowResizeDelay(int delay) {
    this.windowResizeDelay = delay;
  }

  protected void unframe() {
    FocusFrame.get().unframe(this);
  }

  private Element createHiddenInput() {
    Element input = DOM.createInputText();
    input.setClassName("_focus");
    com.google.gwt.dom.client.Style style = input.getStyle();
    style.setProperty("opacity", "0");
    style.setProperty("zIndex", "-1");
    style.setProperty("overflow", "hidden");
    style.setProperty("position", "absolute");
    style.setPropertyPx("height", 0);
    style.setProperty("borderWidth", "0");
    style.setPropertyPx("width", 0);
    return input;
  }
}
