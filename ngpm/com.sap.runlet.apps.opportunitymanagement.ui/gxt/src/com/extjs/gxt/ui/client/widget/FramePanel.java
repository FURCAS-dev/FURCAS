/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.Stack;

import com.extjs.gxt.ui.client.GXT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Displays an iframe under a element to stop IE bleed through and applet
 * related issues.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 */
public class FramePanel extends Component {

  private static Stack<FramePanel> frameStack = new Stack<FramePanel>();

  /**
   * Returns a frame panel from the stack.
   * 
   * @return the frame panel
   */
  public static FramePanel pop() {
    FramePanel panel = frameStack.size() > 0 ? frameStack.pop() : null;
    if (panel == null) {
      panel = new FramePanel();
    }
    return panel;
  }

  /**
   * Pushes a panel back onto the stack.
   * 
   * @param panel the panel
   */
  public static void push(FramePanel panel) {
    frameStack.push(panel);
  }

  /**
   * Creates a new frame panel.
   */
  private FramePanel() {

  }

  /**
   * Removes the panel.
   * 
   * @param element the parent element
   */
  public native void onHide(Element element) /*-{
     var frame = this.@com.google.gwt.user.client.ui.UIObject::element;
     frame.parentNode.removeChild(frame);
    }-*/;

  /**
   * Displays the panel behind the given element.
   * 
   * @param element the element
   */
  public void onShow(Element element) {
    if (GXT.isIE) {
      bindIE(element, getElement());
    } else {
      bindOther(element, getElement());
    }
  }

  /**
   * Displays the panel behind the given element.
   * 
   * @param element the element
   * @param zIndex the z index
   */
  public void onShow(Element element, int zIndex) {
    onShow(element);
    setZIndex(zIndex);
  }

  /**
   * Sets the z-index of the panel.
   * 
   * @param index the z index
   */
  public void setZIndex(int index) {
    index = Math.max(1, index);
    if (GXT.isIE) {
      setZIndexIE(index);
    } else {
      DOM.setIntStyleAttribute(getElement(), "zIndex", index);
    }
  }

  public void sync(Element element) {
    if (GXT.isIE) {
      syncIE(element, getElement());
    } else {
      syncOther(element, getElement());
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createIFrame(), target, index);
    if (GXT.isIE && GXT.isSecure) {
      getElement().setPropertyString("src", GXT.SSL_SECURE_URL);
    }
    el().insertInto(target, index);
  }

  private native void bindIE(Element parent, Element frame) /*-{
       frame.scrolling = 'no';
       frame.frameBorder = 0;
       frame.style.position = 'absolute';
       frame.className = 'my-frame-panel';
       parent.__frame = frame;
       frame.__parent = parent;
       frame.style.setExpression('left', parent.offsetLeft);
       frame.style.setExpression('top', parent.offsetTop);
       frame.style.setExpression('width', parent.offsetWidth);
       frame.style.setExpression('height', parent.offsetHeight);
       parent.parentElement.insertBefore(frame, parent);
     }-*/;

  private native void bindOther(Element parent, Element frame) /*-{
       frame.scrolling = 'no';
       frame.frameBorder = 0;
       frame.style.position = 'absolute';
       frame.className = 'my-frame-panel';
       parent.__frame = frame;
       frame.__parent = parent;
       frame.style.left = parent.offsetLeft + 'px';
       frame.style.top = parent.offsetTop + 'px';
       frame.style.width = parent.offsetWidth + 'px';
       frame.style.height = parent.offsetHeight + 'px'; 
       parent.parentNode.insertBefore(frame, parent);
     }-*/;

  private native void setZIndexIE(int index) /*-{
       var frame = this.@com.google.gwt.user.client.ui.UIObject::element;
       frame.style.setExpression('zIndex', index);
     }-*/;

  private native void syncIE(Element parent, Element frame) /*-{
       frame.style.setExpression('left', parent.offsetLeft);
       frame.style.setExpression('top', parent.offsetTop);
       frame.style.setExpression('width', parent.offsetWidth);
       frame.style.setExpression('height', parent.offsetHeight);
    }-*/;

  private native void syncOther(Element parent, Element frame) /*-{
       frame.style.left = parent.offsetLeft + 'px';
       frame.style.top = parent.offsetTop + 'px';
       frame.style.width = parent.offsetWidth + 'px';
       frame.style.height = parent.offsetHeight + 'px'; 
    }-*/;

}
