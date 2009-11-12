/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DomEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.PreviewEvent;
import com.extjs.gxt.ui.client.util.BaseEventPreview;
import com.extjs.gxt.ui.client.util.Size;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * Provides a convenient wrapper for TextFields that adds a clickable trigger
 * button (looks like a combobox by default).
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>TriggerClick</b> : FieldEvent(field, event)<br>
 * <div>Fires after the trigger is clicked.</div>
 * <ul>
 * <li>field : this</li>
 * <li>event : event</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>Field Focus</dd>
 * <dd>Field Blur</dd>
 * <dd>Field Change</dd>
 * <dd>Field Invalid</dd>
 * <dd>Field Valid</dd>
 * <dd>Field KeyPress</dd>
 * <dd>Field SpecialKey</dd>
 * </dl>
 */
public class TriggerField<D> extends TextField<D> {

  protected BaseEventPreview focusEventPreview;
  protected El input;
  protected El trigger;
  protected String triggerStyle = "x-form-trigger-arrow";
  protected El wrap;

  protected boolean mimicing;

  private boolean editable = true;
  private boolean monitorTab = true;
  private boolean hideTrigger;

  public TriggerField() {
    super();
    setDeferHeight(true);
  }

  /**
   * Returns the trigger style.
   * 
   * @return the trigger style
   */
  public String getTriggerStyle() {
    return triggerStyle;
  }

  /**
   * Returns true if the combo is editable.
   * 
   * @return true if editable
   */
  public boolean isEditable() {
    return editable;
  }

  /**
   * Returns true if the trigger is hidden.
   * 
   * @return the hide trigger state
   */
  public boolean isHideTrigger() {
    return hideTrigger;
  }

  public boolean isMonitorTab() {
    return monitorTab;
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    int type = ce.getEventTypeInt();
    if (ce.getTarget() == trigger.dom && type == Event.ONCLICK) {
      onTriggerClick(ce);
    }
  }

  /**
   * Allow or prevent the user from directly editing the field text. If false is
   * passed, the user will only be able to select from the items defined in the
   * dropdown list.
   * 
   * @param value true to allow the user to directly edit the field text
   */
  public void setEditable(boolean value) {
    if (value == this.editable) {
      return;
    }
    this.editable = value;
    if (rendered) {
      El fromEl = getInputEl();
      if (!value) {
        fromEl.dom.setPropertyBoolean("readOnly", true);
        fromEl.addStyleName("x-triggerfield-noedit");
      } else {
        fromEl.dom.setPropertyBoolean("readOnly", false);
        fromEl.removeStyleName("x-triggerfield-noedit");
      }
    }
  }

  /**
   * True to hide the trigger (defaults to false, pre-render).
   * 
   * @param hideTrigger true to hide the trigger
   */
  public void setHideTrigger(boolean hideTrigger) {
    this.hideTrigger = hideTrigger;
  }

  public void setMonitorTab(boolean monitorTab) {
    this.monitorTab = monitorTab;
  }

  /**
   * Sets the trigger style name.
   * 
   * @param triggerStyle
   */
  public void setTriggerStyle(String triggerStyle) {
    this.triggerStyle = triggerStyle;
  }

  protected void onAttach() {
    super.onAttach();
    if (GXT.isIE && !hideTrigger) {
      int y;
      if ((y = input.getY()) != trigger.getY()) {
        trigger.setY(y);
      }
    }
  }

  @Override
  protected void afterRender() {
    super.afterRender();
    wrap.removeStyleName(fieldStyle);

  }

  @Override
  protected El getFocusEl() {
    return input;
  }

  @Override
  protected El getInputEl() {
    return input;
  }

  @Override
  protected El getStyleEl() {
    return input;
  }

  protected void onKeyDown(FieldEvent fe) {
    super.onKeyDown(fe);
    if (monitorTab && fe.getKeyCode() == KeyCodes.KEY_TAB) {
      triggerBlur(fe);
    }
  }

  @Override
  protected void onBlur(ComponentEvent ce) {
  }

  @Override
  protected void onClick(ComponentEvent ce) {
    if (!editable && ce.getTarget() == getInputEl().dom) {
      onTriggerClick(ce);
      return;
    }
    super.onClick(ce);
  }

  @Override
  protected void onDisable() {
    super.onDisable();
    wrap.addStyleName("x-item-disabled");
  }

  @Override
  protected void onEnable() {
    super.onEnable();
    wrap.removeStyleName("x-item-disabled");
  }

  @Override
  protected void onFocus(ComponentEvent ce) {
    super.onFocus(ce);
    if (!mimicing) {
      addStyleName("x-trigger-wrap-focus");
      mimicing = true;
      focusEventPreview.add();
    }
  }

  protected void mimicBlur(PreviewEvent e, Element target) {
    if (!el().dom.isOrHasChild(target) && validateBlur(e, target)) {
      triggerBlur(null);
    }
  }

  protected void triggerBlur(ComponentEvent ce) {
    mimicing = false;
    focusEventPreview.remove();
    beforeBlur();
    removeStyleName("x-trigger-wrap-focus");
    super.onBlur(ce);
  }

  protected void onTriggerClick(ComponentEvent ce) {
    fireEvent(Events.TriggerClick, ce);
  }

  protected boolean validateBlur(DomEvent ce, Element target) {
    return true;
  }

  protected void beforeBlur() {
  }

  @Override
  protected void onRender(Element target, int index) {
    if (el() != null) {
      super.onRender(target, index);
      return;
    }
    input = new El(DOM.createInputText());
    wrap = new El(DOM.createDiv());
    wrap.dom.setClassName("x-form-field-wrap");

    input.addStyleName(fieldStyle);

    trigger = new El(DOM.createImg());
    trigger.dom.setClassName("x-form-trigger " + triggerStyle);
    trigger.dom.setPropertyString("src", GXT.BLANK_IMAGE_URL);
    wrap.dom.appendChild(input.dom);
    wrap.dom.appendChild(trigger.dom);
    setElement(wrap.dom, target, index);

    if (hideTrigger) {
      trigger.setVisible(false);
    }

    addStyleOnOver(trigger.dom, "x-form-trigger-over");

    super.onRender(target, index);

    if (!editable) {
      editable = true;
      setEditable(false);
    }

    DOM.sinkEvents(wrap.dom, Event.FOCUSEVENTS);
    DOM.sinkEvents(trigger.dom, Event.ONCLICK | Event.MOUSEEVENTS);

    if (width == null) {
      setWidth(150);
    }

    focusEventPreview = new BaseEventPreview() {
      protected boolean onAutoHide(final PreviewEvent ce) {
        if (ce.getEventTypeInt() == Event.ONMOUSEDOWN) {
          final Element target = ce.getTarget();
          DeferredCommand.addCommand(new Command() {
            public void execute() {
              mimicBlur(ce, target);
            }
          });
        }
        return false;
      }
    };

  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    getInputEl().setWidth(adjustWidth("input", width - trigger.getWidth()), true);
    el().setWidth(getInputEl().getWidth() + trigger.getWidth(), true);
  }

  protected Size adjustSize(Size size) {
    return size;
  }

}
