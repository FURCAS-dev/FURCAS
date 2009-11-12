/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.widget.impl.PngImageImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;

/**
 * Image widget that overcomes PNG browser incompatabilities.
 * 
 * <p>
 * Implementation adapted from GWT Widget Library
 * (http://gwt-widget.sourceforge.net/).
 * </p>
 */
public class PngImage extends Image {

  private PngImageImpl impl;

  /**
   * Creates a new image instance.
   * 
   * @param url the url of the image
   */
  public PngImage(String url) {
    this(url, 1, 1);
  }

  /**
   * Creates a new image instance.
   * 
   * @param url the url of the image
   * @param width the width
   * @param height the height
   */
  public PngImage(String url, int width, int height) {
    impl = (PngImageImpl) GWT.create(PngImageImpl.class);

    setElement(impl.createElement(url, width, height));
  }

  /**
   * Should not be used. Throws a RuntimeException.
   */
  public void setUrl(String url) {
    throw new RuntimeException("Not allowed to set url for a PNG image");
  }
}
