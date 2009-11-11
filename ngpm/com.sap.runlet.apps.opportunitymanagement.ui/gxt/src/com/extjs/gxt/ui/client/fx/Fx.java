/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.fx;

import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.EffectListener;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FxEvent;
import com.google.gwt.animation.client.Animation;

/**
 * Runs an effect and fires events. The run multiple effects see
 * {@link MultiEffect}.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>EffectStart</b> : FxEvent(fx, effect)<br>
 * <div>Fires after an effect is started.</div>
 * <ul>
 * <li>fx : this</li>
 * <li>effect : the effct</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>EffecCancel</b> : FxEvent(fx, effect)<br>
 * <div>Fires after an effect has been cancelled.</div>
 * <ul>
 * <li>fx : this</li>
 * <li>efffect : the effect</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>EffecComplete</b> : FxEvent(fx,effect)<br>
 * <div>Fires after an effect has been completed</div>
 * <ul>
 * <li>fx : this</li>
 * <li>effect : the effect</li>
 * </ul>
 * </dd>
 * </dl>
 */
public class Fx extends BaseObservable {

  private boolean isRunning;

  protected Effect effect;
  protected Animation animation;
  protected int duration = 0;

  public Fx() {
    animation = new Animation() {

      @Override
      public void onCancel() {
        Fx.this.onCancel();
        isRunning = false;
      }

      @Override
      public void onComplete() {
        Fx.this.onComplete();
        isRunning = false;
      }

      @Override
      public void onStart() {
        isRunning = true;
        Fx.this.onStart();
      }

      @Override
      public void onUpdate(double progress) {
        Fx.this.onUpdate(progress);
      }

    };
  }

  public Fx(FxConfig config) {
    this();
    duration = config.getDuration();
    addListener(Events.EffectStart, config.getEffectStartListener());
    addListener(Events.EffectComplete, config.getEffectCompleteListener());
  }

  /**
   * Adds a listener to be notified of effect events.
   * 
   * @param listener the listener to be added
   */
  public void addEffectListener(EffectListener listener) {
    addListener(Events.EffectStart, listener);
    addListener(Events.EffectCancel, listener);
    addListener(Events.EffectComplete, listener);
  }

  /**
   * Returns the effect.
   * 
   * @return the effect
   */
  public Effect getEffect() {
    return effect;
  }

  /**
   * Cancels the effect.
   */
  public void cancel() {
    animation.cancel();
  }

  /**
   * Removes a previously added effect listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeEffectListener(EffectListener listener) {
    removeListener(Events.EffectStart, listener);
    removeListener(Events.EffectCancel, listener);
    removeListener(Events.EffectComplete, listener);
  }

  /**
   * Runs the effect for the given duration.
   * 
   * @param effect the effect run
   * @return true if the effect is run
   */
  public boolean run(Effect effect) {
    return run(duration > 0 ? duration : 500, effect);
  }

  /**
   * Runs the effect for the given duration.
   * 
   * @param duration the effect duration in milliseconds
   * @param effect the effect run
   * @return true if the effect is run
   */
  public boolean run(int duration, Effect effect) {
    if (isRunning) return false;
    this.effect = effect;
    animation.run(duration);
    return true;
  }

  protected void onCancel() {
    effect.onCancel();
    fireEvent(Events.EffectCancel, new FxEvent(this, effect));
  }

  protected void onComplete() {
    effect.onComplete();
    fireEvent(Events.EffectComplete, new FxEvent(this, effect));
  }

  protected void onStart() {
    effect.onStart();
    fireEvent(Events.EffectStart, new FxEvent(this, effect));
  }

  protected void onUpdate(double progress) {
    effect.onUpdate(progress);
  }
}
