/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.fx;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.core.El;

public class MultiEffect extends BaseEffect {

  protected List<Effect> effects;

  public MultiEffect(El el) {
    super(el);
    effects = new ArrayList<Effect>();
  }

  public void addEffects(List<Effect> effects) {
    for (Effect e : effects) {
      this.effects.add(e);
    }
  }

  public void addEffects(Effect... effects) {
    for (int i = 0; i < effects.length; i++) {
      this.effects.add(effects[i]);
    }
  }

  @Override
  public void onCancel() {
    for (Effect e : effects) {
      e.onCancel();
    }
  }

  @Override
  public void onComplete() {
    for (Effect e : effects) {
      e.onComplete();
    }
  }

  @Override
  public void onStart() {
    for (Effect e : effects) {
      e.onStart();
    }
  }

  @Override
  public void onUpdate(double progress) {
    for (Effect e : effects) {
      e.onUpdate(progress);
    }
  }

}
