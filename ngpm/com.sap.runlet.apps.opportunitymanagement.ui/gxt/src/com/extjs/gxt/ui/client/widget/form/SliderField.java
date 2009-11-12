/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SliderEvent;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.Slider;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Field which wraps a <code>Slider</code>.
 */
public class SliderField extends Field<Integer> {
  private Slider slider;
  protected El hidden;
  protected Listener<SliderEvent> listener;

  public SliderField(Slider slider) {
    super();
    setSlider(slider);
  }

  @Override
  public El getFocusEl() {
    return slider.getFocusEl();
  }

  @Override
  public El getInputEl() {
    return hidden;
  }

  public Slider getSlider() {
    return slider;
  }

  @Override
  public void setValue(Integer value) {
    slider.setValue(value);
    super.setValue(value);
  }

  public void setSlider(Slider slider) {
    assertPreRender();
    if (listener == null) {
      listener = new Listener<SliderEvent>() {
        public void handleEvent(SliderEvent be) {
          if (rendered) {
            updateHiddenField();
          }
        }
      };
    }
    this.slider = slider;
    slider.addListener(Events.Change, listener);
  }

  @Override
  protected void afterRender() {
    super.afterRender();
    updateHiddenField();
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    ComponentHelper.doAttach(slider);
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    ComponentHelper.doDetach(slider);
  }

  @Override
  protected void onRender(Element parent, int index) {
    setElement(DOM.createDiv(), parent, index);

    slider.render(getElement());
    hidden = new El((Element) Document.get().createHiddenInputElement().cast());;
    getElement().appendChild(hidden.dom);

    super.onRender(parent, index);

  }

  @Override
  protected void onResize(int width, int height) {
    if (rendered) {
      if (slider.isVertical()) {
        slider.setHeight(height);
      } else {
        slider.setWidth(width);
      }
    }
    super.onResize(width, height);
  }

  protected void updateHiddenField() {
    if (rendered) {
      hidden.setValue(slider.getValue() + "");
    }
  }

}
