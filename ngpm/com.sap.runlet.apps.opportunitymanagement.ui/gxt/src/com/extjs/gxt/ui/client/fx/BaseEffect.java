/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.fx;

import com.extjs.gxt.ui.client.Style.Direction;
import com.extjs.gxt.ui.client.Style.ScrollDir;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Timer;

/**
 * Base <code>Effect</code> implementation for elements.
 */
public class BaseEffect implements Effect {

  static class FadeIn extends SingleStyleEffect {

    public FadeIn(El el) {
      super(el, "opacity", 0, 1);
    }

    @Override
    public void increase(double value) {
      el.setStyleAttribute("opacity", value);
    }

    public void onComplete() {
      el.setStyleAttribute("filter", "");
    }

    public void onStart() {
      el.setStyleAttribute("opacity", 0);
      el.setVisible(true);
    }

  }

  static class Blink extends BaseEffect {

    private Timer t;
    private boolean visible;
    private int interval;

    public Blink(final El el, int interval) {
      super(el);
      this.interval = interval;
      t = new Timer() {
        @Override
        public void run() {
          el.setVisibility(visible);
          visible = !visible;
        }
      };
    }

    @Override
    public void onStart() {
      t.scheduleRepeating(interval);
    }

    @Override
    public void onUpdate(double progress) {

    }

    @Override
    public void onComplete() {
      t.cancel();
      // ensure timer is done executing
      DeferredCommand.addCommand(new Command() {
        public void execute() {
          el.setVisibility(true);
        }
      });
    }
  }

  static class Scroll extends SingleStyleEffect {

    protected ScrollDir dir;

    public Scroll(El el, ScrollDir dir, int value) {
      super(el);
      this.dir = dir;
      if (dir == ScrollDir.HORIZONTAL) {
        from = el.getScrollLeft();
        to = value;
      } else if (dir == ScrollDir.VERTICAL) {
        from = el.getScrollTop();
        to = value;
      }
    }

    @Override
    public void increase(double value) {
      if (dir == ScrollDir.HORIZONTAL) {
        el.setScrollLeft((int) value);
      } else if (dir == ScrollDir.VERTICAL) {
        el.setScrollTop((int) value);
      }

    }

  }

  static class FadeOut extends SingleStyleEffect {

    public FadeOut(El el) {
      super(el, "opacity", 1, 0);
    }

    @Override
    public void increase(double value) {
      el.setStyleAttribute("opacity", Math.max(value, 0));
    }

    public void onComplete() {
      el.setVisible(false);
      el.dom.getStyle().setProperty("opacity", "");
      el.dom.getStyle().setProperty("filter", "");
    }

  }

  static class Move extends BaseEffect {

    private int fromX, toX;
    private int fromY, toY;

    public Move(El el, int x, int y) {
      super(el);
      fromX = el.getX();
      fromY = el.getY();

      toX = x;
      toY = y;
    }

    @Override
    public void onUpdate(double progress) {
      int x = (int) getValue(fromX, toX, progress);
      int y = (int) getValue(fromY, toY, progress);

      el.setXY(x, y);
    }

  }

  static abstract class Slide extends BaseEffect {

    protected Direction dir;
    protected El wrapEl;
    protected Rectangle oBounds;
    protected String overflow;
    protected String style;
    protected double from, to;

    public Slide(El el, Direction dir) {
      super(el);
      this.dir = dir;
    }

    public void increase(int v) {
      if (style.equalsIgnoreCase("x")) {
        el.setX(v);
      } else if (style.equalsIgnoreCase("y")) {
        el.setY(v);
      } else {
        el.setStyleAttribute(style, "" + v);
      }

    }

    @Override
    public void onUpdate(double progress) {
      int v = (int) (from + ((to - from) * progress));
      increase(v);
    }

  }

  static class SlideIn extends Slide {

    public SlideIn(El el, Direction dir) {
      super(el, dir);
    }

    @Override
    public void increase(int now) {
      int v = (int) now;
      switch (dir) {
        case LEFT:
          wrapEl.setLeft(oBounds.width - v);
          wrapEl.setStyleAttribute(style, v);
          break;
        case UP:
          wrapEl.setTop((oBounds.height - v));
          wrapEl.setStyleAttribute(style, v);
          break;
        case DOWN:
          el.setStyleAttribute("marginTop", -(oBounds.height - v));
          wrapEl.setStyleAttribute(style, v);
          break;
        case RIGHT:
          el.setStyleAttribute("marginLeft", -(oBounds.width - v));
          wrapEl.setStyleAttribute(style, v);
          break;
      }
    }

    @Override
    public void onComplete() {
      wrapEl.unwrap(el.dom, oBounds);
      el.setStyleAttribute("marginTop", 0);
      el.setStyleAttribute("overflow", overflow);
      super.onComplete();
    }

    @Override
    public void onStart() {
      overflow = el.getStyleAttribute("overflow");
      wrapEl = new El(DOM.createDiv());
      oBounds = el.wrap(wrapEl.dom);

      int h = oBounds.height;
      int w = oBounds.width;

      wrapEl.setSize(w, h);

      el.setVisible(true);
      wrapEl.setVisible(true);

      switch (dir) {
        case DOWN:
          wrapEl.setHeight(1);
          style = "height";
          from = 1;
          to = oBounds.height;
          break;
        case RIGHT:
          style = "width";
          from = 1;
          to = oBounds.width;
          break;
        case LEFT:
          wrapEl.setWidth(1);
          style = "width";
          from = 1;
          to = oBounds.width;
          break;
        case UP:
          wrapEl.setHeight(1);
          style = "height";
          from = 1;
          to = oBounds.height;
      }
    }
  }

  static class SlideOut extends Slide {

    public SlideOut(El el, Direction dir) {
      super(el, dir);
    }

    @Override
    public void increase(int v) {
      switch (dir) {
        case LEFT:
          el.setStyleAttribute("marginLeft", -(oBounds.width - v));
          wrapEl.setStyleAttribute(style, v);
          break;
        case UP:
          el.setStyleAttribute("marginTop", -(oBounds.height - v));
          wrapEl.setStyleAttribute(style, v);
          break;
        case DOWN:
          el.setY(v);
          break;
        case RIGHT:
          el.setX(v);
          break;
      }
    }

    @Override
    public void onComplete() {
      el.setVisible(false);
      wrapEl.unwrap(el.dom, oBounds);
      el.setStyleAttribute("overflow", overflow);
      super.onComplete();
    }

    @Override
    public void onStart() {
      super.onStart();
      overflow = el.getStyleAttribute("overflow");
      wrapEl = new El(DOM.createDiv());
      oBounds = el.wrap(wrapEl.dom);

      int h = oBounds.height;
      int w = oBounds.width;

      wrapEl.setSize(w, h);
      wrapEl.setVisible(true);
      el.setVisible(true);

      switch (dir) {
        case UP:
          style = "height";
          from = oBounds.height;
          to = 1;
          break;
        case LEFT:
          style = "width";
          from = oBounds.width;
          to = 0;
          break;
        case RIGHT:
          style = "left";
          from = wrapEl.getX();
          to = from + wrapEl.getWidth();
          break;

        case DOWN:
          style = "top";
          from = wrapEl.getY();
          to = from + wrapEl.getHeight();
          break;
      }
    }

  }

  public static void blink(El el, FxConfig config, int interval) {
    Fx fx = new Fx(config);
    fx.run(new Blink(el, interval));
  }

  public static void fadeIn(El el, FxConfig config) {
    Fx fx = new Fx(config);
    fx.run(new FadeIn(el));
  }

  public static void fadeOut(El el, FxConfig config) {
    Fx fx = new Fx(config);
    fx.run(new FadeOut(el));
  }

  public static void slideIn(El el, FxConfig config, Direction direction) {
    Fx fx = new Fx(config);
    fx.run(new SlideIn(el, direction));
  }

  public static void scroll(El el, FxConfig config, ScrollDir direction, int value) {
    Fx fx = new Fx(config);
    fx.run(new Scroll(el, direction, value));
  }

  public static void slideOut(El el, FxConfig config, Direction direction) {
    Fx fx = new Fx(config);
    fx.run(new SlideOut(el, direction));
  }

  protected El el;

  protected BaseEffect(El el) {
    this.el = el;
  }

  public void onCancel() {

  }

  public void onComplete() {

  }

  public void onStart() {

  }

  public void onUpdate(double progress) {

  }

  protected double getValue(double from, double to, double progress) {
    return (from + ((to - from) * progress));
  }

}
