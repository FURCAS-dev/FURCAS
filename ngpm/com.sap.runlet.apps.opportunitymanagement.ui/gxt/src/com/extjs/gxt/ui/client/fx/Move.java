/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.fx;

import com.extjs.gxt.ui.client.core.El;

public class Move extends BaseEffect {

  private int fromX, toX;
  private int fromY, toY;

  public Move(El el, int x, int y) {
    super(el);
    el.makePositionable();
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
