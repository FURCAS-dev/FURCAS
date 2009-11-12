/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.SplitBar;

/**
 * SplitBar event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see SplitBar
 */
public class SplitBarEvent extends ComponentEvent {

  /**
   * The drag event.
   */
  private DragEvent dragEvent;

  /**
   * The current size.
   */
  private int size;

  /**
   * The source split bar.
   */
  private SplitBar splitBar;

  public SplitBarEvent(SplitBar splitBar) {
    super(splitBar);
    this.splitBar = splitBar;
  }

  /**
   * Returns the drag event.
   * 
   * @return the drag event
   */
  public DragEvent getDragEvent() {
    return dragEvent;
  }

  /**
   * Returns the current size.
   * 
   * @return the current size
   */
  public int getSize() {
    return size;
  }

  /**
   * Returns the source split bar.
   * 
   * @return the source split bar
   */
  public SplitBar getSplitBar() {
    return splitBar;
  }

  /**
   * Sets the drag event.
   * 
   * @param dragEvent the drag event
   */
  public void setDragEvent(DragEvent dragEvent) {
    this.dragEvent = dragEvent;
  }

  /**
   * Sets the current size.
   * 
   * @param size the size
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Sets the source split bar.
   * 
   * @param splitBar the source split bar
   */
  public void setSplitBar(SplitBar splitBar) {
    this.splitBar = splitBar;
  }

}
