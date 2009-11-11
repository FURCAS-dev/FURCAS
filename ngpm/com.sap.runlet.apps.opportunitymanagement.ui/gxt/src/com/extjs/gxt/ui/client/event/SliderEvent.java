/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.Slider;
import com.google.gwt.user.client.Event;

/**
 * Slider event type.
 * 
 * @see Slider
 */
public class SliderEvent extends BoxComponentEvent {

  private int newValue = -1;
  private int oldValue = -1;
  private Slider slider;

  public SliderEvent(Slider slider) {
    super(slider);
    this.slider = slider;
  }
  
  public SliderEvent(Slider slider, Event event) {
    super(slider, event);
    this.slider = slider;
  }

  /**
   * Returns the new value.
   * 
   * @return the new value
   */
  public int getNewValue() {
    return newValue;
  }

  /**
   * Returns the old value.
   * 
   * @return the old value
   */
  public int getOldValue() {
    return oldValue;
  }

  /**
   * Returns the source slider.
   * 
   * @return the slider
   */
  public Slider getSlider() {
    return slider;
  }

  /**
   * Sets the new value.
   * 
   * @param newValue the new value
   */
  public void setNewValue(int newValue) {
    this.newValue = newValue;
  }

  /**
   * Sets the old value.
   * 
   * @param oldValue the old value
   */
  public void setOldValue(int oldValue) {
    this.oldValue = oldValue;
  }

  /**
   * Sets the source slider.
   * 
   * @param slider the slider
   */
  public void setSlider(Slider slider) {
    this.slider = slider;
  }

}
