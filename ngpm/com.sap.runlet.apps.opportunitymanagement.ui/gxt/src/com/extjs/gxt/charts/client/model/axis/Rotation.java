/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.axis;

/**
 * Rotation enumeration.
 */
public enum Rotation {

  VERTICAL("vertical"), DIAGONAL("diagonal"), HORIZONTAL("horizontal");

  private final String text;

  Rotation(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}