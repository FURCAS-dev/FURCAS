/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.fx;

import com.extjs.gxt.ui.client.event.FxEvent;
import com.extjs.gxt.ui.client.event.Listener;

/**
 * Allows the configuration of an Fx instance using a single object.
 */
public class FxConfig {

  public static final FxConfig NONE = new FxConfig();

  private Listener<FxEvent> effectStartListener;
  private Listener<FxEvent> effectCompleteListener;
  private int duration;

  public FxConfig() {

  }

  public FxConfig(int duration) {
    this.setDuration(duration);
  }

  public FxConfig(Listener<FxEvent> callback) {
    this.effectCompleteListener = callback;
  }

  public FxConfig(int duration, Listener<FxEvent> callback) {
    this.setDuration(duration);
    this.effectCompleteListener = callback;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public int getDuration() {
    return duration;
  }

  public Listener<FxEvent> getEffectStartListener() {
    return effectStartListener;
  }

  public void setEffectStartListener(Listener<FxEvent> effectStartListener) {
    this.effectStartListener = effectStartListener;
  }

  public Listener<FxEvent> getEffectCompleteListener() {
    return effectCompleteListener;
  }

  public void setEffectCompleteListener(Listener<FxEvent> effectCompleteListener) {
    this.effectCompleteListener = effectCompleteListener;
  }

}
