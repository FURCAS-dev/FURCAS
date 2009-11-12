/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.Event;

/**
 * Defines the GXT event types.
 */
public class Events {

  protected Events() {

  }

  /**
   * DOM ONBLUR event type.
   */
  public static final EventType OnBlur = new EventType(Event.ONBLUR);

  /**
   * DOM ONCHANGE event type.
   */
  public static final EventType OnChange = new EventType(Event.ONCHANGE);

  /**
   * DOM ONCLICK event type.
   */
  public static final EventType OnClick = new EventType(Event.ONCLICK);

  /**
   * DOM ONDBLCLICK event type.
   */
  public static final EventType OnDoubleClick = new EventType(Event.ONDBLCLICK);

  /**
   * DOM ONERROR event type.
   */
  public static final EventType OnError = new EventType(Event.ONERROR);

  /**
   * DOM ONFOCUS event type.
   */
  public static final EventType OnFocus = new EventType(Event.ONFOCUS);

  /**
   * DOM ONKEYDOWN event type.
   */
  public static final EventType OnKeyDown = new EventType(Event.ONKEYDOWN);

  /**
   * DOM ONKEYDOWN event type.
   */
  public static final EventType OnKeyPress = new EventType(Event.ONKEYPRESS);

  /**
   * DOM ONKEYUP event type.
   */
  public static final EventType OnKeyUp = new EventType(Event.ONKEYUP);

  /**
   * DOM ONLOAD event type.
   */
  public static final EventType OnLoad = new EventType(Event.ONLOAD);

  /**
   * DOM ONLOSECAPTURE event type.
   */
  public static final EventType OnLoseCapture = new EventType(Event.ONLOSECAPTURE);

  /**
   * DOM ONMOUSEDOWN event type.
   */
  public static final EventType OnMouseDown = new EventType(Event.ONMOUSEDOWN);

  /**
   * DOM ONMOUSEUP event type.
   */
  public static final EventType OnMouseUp = new EventType(Event.ONMOUSEUP);

  /**
   * DOM ONMOUSEWHEEL event type.
   */
  public static final EventType OnMouseWheel = new EventType(Event.ONMOUSEWHEEL);

  /**
   * DOM ONSCROLL event type.
   */
  public static final EventType OnScroll = new EventType(Event.ONSCROLL);

  /**
   * DOM ONCONTEXTMENU event type.
   */
  public static final EventType OnContextMenu = new EventType(Event.ONCONTEXTMENU);

  /**
   * DOM ONMOUSEOVER event type.
   */
  public static final EventType OnMouseOver = new EventType(Event.ONMOUSEOVER);

  /**
   * DOM ONMOUSEOUT event type.
   */
  public static final EventType OnMouseOut = new EventType(Event.ONMOUSEOUT);

  /**
   * DOM ONMOUSEMOVE event type.
   */
  public static final EventType OnMouseMove = new EventType(Event.ONMOUSEMOVE);

  private static Map<Integer, EventType> browserEvents = new HashMap<Integer, EventType>();

  static {
    browserEvents.put(Event.ONBLUR, OnBlur);
    browserEvents.put(Event.ONCHANGE, OnChange);
    browserEvents.put(Event.ONCLICK, OnClick);
    browserEvents.put(Event.ONCONTEXTMENU, OnContextMenu);
    browserEvents.put(Event.ONDBLCLICK, OnDoubleClick);
    browserEvents.put(Event.ONERROR, OnError);
    browserEvents.put(Event.ONFOCUS, OnFocus);
    browserEvents.put(Event.ONKEYDOWN, OnKeyDown);
    browserEvents.put(Event.ONKEYPRESS, OnKeyPress);
    browserEvents.put(Event.ONKEYUP, OnKeyUp);
    browserEvents.put(Event.ONLOAD, OnLoad);
    browserEvents.put(Event.ONLOSECAPTURE, OnLoseCapture);
    browserEvents.put(Event.ONMOUSEDOWN, OnMouseDown);
    browserEvents.put(Event.ONMOUSEUP, OnMouseUp);
    browserEvents.put(Event.ONMOUSEOVER, OnMouseOver);
    browserEvents.put(Event.ONMOUSEOUT, OnMouseOut);
    browserEvents.put(Event.ONMOUSEMOVE, OnMouseMove);
    browserEvents.put(Event.ONMOUSEWHEEL, OnMouseWheel);
    browserEvents.put(Event.ONSCROLL, OnScroll);

  }

  /**
   * Finds the GXT EventType based on GWT int event type.
   * 
   * @param browserEventType the GWT event type
   * @return the GXT event type
   */
  public static EventType lookupBrowserEvent(int browserEventType) {
    EventType type = browserEvents.get(browserEventType);
    assert type != null;
    return type;
  }

  /**
   * Activate event type.
   */
  public static final EventType Activate = new EventType();

  /**
   * AfterEdit event type.
   */
  public static final EventType AfterEdit = new EventType();

  /**
   * AfterLayout event type.
   */
  public static final EventType AfterLayout = new EventType();

  /**
   * Add event type.
   */
  public static final EventType Add = new EventType();

  /**
   * ArrowClick event type.
   */
  public static final EventType ArrowClick = new EventType();

  /**
   * Attach event type.
   */
  public static final EventType Attach = new EventType();

  /**
   * BeforeAdd event type.
   */
  public static final EventType BeforeAdd = new EventType();
  
  /**
   * Bind event type.
   */
  public static final EventType BeforeBind = new EventType();
  
  /**
   * BeforeCancelEdit event type.
   */
  public static final EventType BeforeCancelEdit = new EventType();
  
  /**
   * BeforeChange event type.
   */
  public static final EventType BeforeChange = new EventType();

  /**
   * BeforeCheckChange event type.
   */
  public static final EventType BeforeCheckChange = new EventType();

  /**
   * Close event type.
   */
  public static final EventType BeforeClose = new EventType();

  /**
   * BeforeCollapse event type.
   */
  public static final EventType BeforeCollapse = new EventType();

  /**
   * BeforeComplete event type.
   */
  public static final EventType BeforeComplete = new EventType();

  /**
   * BeforeEdit event type.
   */
  public static final EventType BeforeEdit = new EventType();

  /**
   * BeforeExpand event type.
   */
  public static final EventType BeforeExpand = new EventType();

  /**
   * BeforeHide event type.
   */
  public static final EventType BeforeHide = new EventType();

  /**
   * BeforeOpen event type.
   */
  public static final EventType BeforeOpen = new EventType();

  /**
   * BeforeRemove event type.
   */
  public static final EventType BeforeRemove = new EventType();

  /**
   * Render event type.
   */
  public static final EventType BeforeRender = new EventType();

  /**
   * BeforeStateRestore event type.
   */
  public static final EventType BeforeStateRestore = new EventType();

  /**
   * BeforeSelect event type.
   */
  public static final EventType BeforeSelect = new EventType();

  /**
   * BeforeStateSave event type.
   */
  public static final EventType BeforeStateSave = new EventType();

  /**
   * BeforeSubmit event type.
   */
  public static final EventType BeforeSubmit = new EventType();

  /**
   * BeforeShow event type.
   */
  public static final EventType BeforeShow = new EventType();

  /**
   * BeforeStartEdit event type.
   */
  public static final EventType BeforeStartEdit = new EventType();

  /**
   * Bind event type.
   */
  public static final EventType Bind = new EventType();
  
  /**
   * Blur event type.
   */
  public static final EventType Blur = new EventType();

  /**
   * Blur event type.
   */
  public static final EventType BodyScroll = new EventType();

  /**
   * BrowserEvent event type.
   */
  public static final EventType BrowserEvent = new EventType();

  /**
   * CancelEdit event type.
   */
  public static final EventType CancelEdit = new EventType();
  
  /**
   * CellClick event type.
   */
  public static final EventType CellClick = new EventType();

  /**
   * CellDoubleClick event type.
   */
  public static final EventType CellDoubleClick = new EventType();

  /**
   * CellMouseDown event type.
   */
  public static final EventType CellMouseDown = new EventType();

  /**
   * Change event type.
   */
  public static final EventType Change = new EventType();

  /**
   * CheckChange event type.
   */
  public static final EventType CheckChange = new EventType();
  
  /**
   * CheckChange event type.
   */
  public static final EventType CheckChanged = new EventType();

  /**
   * Clear event type.
   */
  public static final EventType Clear = new EventType();

  /**
   * Close event type.
   */
  public static final EventType Close = new EventType();

  /**
   * Collapse event type.
   */
  public static final EventType Collapse = new EventType();

  /**
   * ColumnClick event type.
   */
  public static final EventType ColumnClick = new EventType();

  /**
   * ColumnResize event type.
   */
  public static final EventType ColumnResize = new EventType();

  /**
   * Complete event type.
   */
  public static final EventType Complete = new EventType();

  /**
   * ContextMenu event type.
   */
  public static final EventType ContextMenu = new EventType();

  /**
   * Deactivate event type.
   */
  public static final EventType Deactivate = new EventType();

  /**
   * Detach event type.
   */
  public static final EventType Detach = new EventType();
  
  /**
   * DoubleClick event type.
   */
  public static final EventType DoubleClick = new EventType();

  /**
   * Disable event type.
   */
  public static final EventType Disable = new EventType();

  /**
   * DragCancel event type.
   */
  public static final EventType DragCancel = new EventType();

  /**
   * DragEnd event type.
   */
  public static final EventType DragEnd = new EventType();

  /**
   * DragEnter event type.
   */
  public static final EventType DragEnter = new EventType();

  /**
   * DragLeave event type.
   */
  public static final EventType DragLeave = new EventType();

  /**
   * DragMove event type.
   */
  public static final EventType DragMove = new EventType();

  /**
   * DragStart event type.
   */
  public static final EventType DragStart = new EventType();

  /**
   * Drop event type.
   */
  public static final EventType Drop = new EventType();

  /**
   * EffectCancel event type.
   */
  public static final EventType EffectCancel = new EventType();

  /**
   * EffectComplete event type.
   */
  public static final EventType EffectComplete = new EventType();

  /**
   * EffectStart event type.
   */
  public static final EventType EffectStart = new EventType();

  /**
   * Enable event type.
   */
  public static final EventType Enable = new EventType();

  /**
   * Expand event type.
   */
  public static final EventType Expand = new EventType();

  /**
   * Focus event type.
   */
  public static final EventType Focus = new EventType();

  /**
   * HeaderChange event type.
   */
  public static final EventType HeaderChange = new EventType();

  /**
   * HeaderClick event type.
   */
  public static final EventType HeaderClick = new EventType();

  /**
   * HeaderContextMenu event type.
   */
  public static final EventType HeaderContextMenu = new EventType();

  /**
   * HeaderDoubleClick event type.
   */
  public static final EventType HeaderDoubleClick = new EventType();

  /**
   * HeaderMouseDown event type.
   */
  public static final EventType HeaderMouseDown = new EventType();

  /**
   * HiddenChange event type.
   */
  public static final EventType HiddenChange = new EventType();

  /**
   * Hide event type.
   */
  public static final EventType Hide = new EventType();

  /**
   * Invalid event type.
   */
  public static final EventType Invalid = new EventType();

  /**
   * KeyPress event type.
   */
  public static final EventType KeyPress = new EventType();

  /**
   * KeyUp event type.
   */
  public static final EventType KeyUp = new EventType();

  /**
   * KeyDown event type.
   */
  public static final EventType KeyDown = new EventType();

  /**
   * Minimize event type.
   */
  public static final EventType Maximize = new EventType();

  /**
   * MenuHide event type.
   */
  public static final EventType MenuHide = new EventType();

  /**
   * MenuShow event type.
   */
  public static final EventType MenuShow = new EventType();

  /**
   * Minimize event type.
   */
  public static final EventType Minimize = new EventType();

  /**
   * Resize event type.
   */
  public static final EventType Move = new EventType();

  /**
   * Open event type.
   */
  public static final EventType Open = new EventType();
  
  /**
   * Ready event type.
   */
  public static final EventType Ready = new EventType();

  /**
   * Refresh event type.
   */
  public static final EventType Refresh = new EventType();

  /**
   * Register event type.
   */
  public static final EventType Register = new EventType();

  /**
   * Remove event type.
   */
  public static final EventType Remove = new EventType();

  /**
   * Render event type.
   */
  public static final EventType Render = new EventType();

  /**
   * Resize event type.
   */
  public static final EventType Resize = new EventType();

  /**
   * ResizeEnd event type.
   */
  public static final EventType ResizeEnd = new EventType();

  /**
   * ResizeStart event type.
   */
  public static final EventType ResizeStart = new EventType();

  /**
   * Minimize event type.
   */
  public static final EventType Restore = new EventType();

  /**
   * RowClick event type.
   */
  public static final EventType RowClick = new EventType();

  /**
   * RowDoubleClick event type.
   */
  public static final EventType RowDoubleClick = new EventType();

  /**
   * RowMouseDown event type.
   */
  public static final EventType RowMouseDown = new EventType();

  /**
   * RowUpdated event type.
   */
  public static final EventType RowUpdated = new EventType();

  /**
   * Scroll event type.
   */
  public static final EventType Scroll = new EventType();

  /**
   * Select event type.
   */
  public static final EventType Select = new EventType();

  /**
   * SelectionChange event type.
   */
  public static final EventType SelectionChange = new EventType();

  /**
   * Show event type.
   */
  public static final EventType Show = new EventType();

  /**
   * SortChange event type.
   */
  public static final EventType SortChange = new EventType();

  /**
   * SpecialKey event type.
   */
  public static final EventType SpecialKey = new EventType();

  /**
   * StartEdit event type.
   */
  public static final EventType StartEdit = new EventType();

  /**
   * StateChange event type.
   */
  public static final EventType StateChange = new EventType();

  /**
   * StateSave event type.
   */
  public static final EventType StateSave = new EventType();

  /**
   * StateRestore event type.
   */
  public static final EventType StateRestore = new EventType();

  /**
   * Submit event type.
   */
  public static final EventType Submit = new EventType();

  /**
   * Toggle event type.
   */
  public static final EventType Toggle = new EventType();

  /**
   * TriggerClick event type;
   */
  public static final EventType TriggerClick = new EventType();

  /**
   * TwinTriggerClick event type;
   */
  public static final EventType TwinTriggerClick = new EventType();

  /**
   * Change event type.
   */
  public static final EventType Update = new EventType();

  /**
   * UnBind event type.
   */
  public static final EventType UnBind = new EventType();
  
  /**
   * Unregister event type.
   */
  public static final EventType Unregister = new EventType();

  /**
   * Valid event type.
   */
  public static final EventType Valid = new EventType();

  /**
   * Validate drop event type.
   */
  public static final EventType ValidateDrop = new EventType();

  /**
   * ValidateEdit event type.
   */
  public static final EventType ValidateEdit = new EventType();

  /**
   * WidthChange event type.
   */
  public static final EventType WidthChange = new EventType();

  /**
   * BeforeAdopt event type.
   */
  public static final EventType BeforeAdopt = new EventType();

  /**
   * Adopt event type.
   */
  public static final EventType Adopt = new EventType();
  
  /**
   * AutoHide event type.
   */
  public static final EventType AutoHide = new EventType();

  /**
   * BeforeOrphan event type.
   */
  public static final EventType BeforeOrphan = new EventType();

  /**
   * BeforeQuery event type.
   */
  public static final EventType BeforeQuery = new EventType();

  /**
   * Orphan event type.
   */
  public static final EventType Orphan = new EventType();

}
