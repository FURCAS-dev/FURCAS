/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.google.gwt.http.client.Response;

/**
 * Html Container event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see HtmlContainer
 */
public class HtmlContainerEvent extends ContainerEvent<HtmlContainer, Component> {

  /**
   * The exception for remote requests.
   */
  private Throwable exception;

  /**
   * The remote html.
   */
  private String html;

  /**
   * The remote response.
   */
  private Response response;

  /**
   * Creates a new event.
   * 
   * @param container the source container
   */
  public HtmlContainerEvent(HtmlContainer container) {
    super(container);
  }

  /**
   * Creates a new event.
   * 
   * @param container the source container
   * @param component the component
   */
  public HtmlContainerEvent(HtmlContainer container, Component component) {
    super(container, component);
  }

  /**
   * Returns the exception.
   * 
   * @return the exception
   */
  public Throwable getException() {
    return exception;
  }

  /**
   * Returns the html.
   * 
   * @return the html
   */
  public String getHtml() {
    return html;
  }

  /**
   * Returns the response.
   * 
   * @return the response
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets the exception.
   * 
   * @param exception the exception
   */
  public void setException(Throwable exception) {
    this.exception = exception;
  }

  /**
   * Sets the html.
   * 
   * @param html the html
   */
  public void setHtml(String html) {
    this.html = html;
  }

  /**
   * Sets the response.
   * 
   * @param response the response
   */
  public void setResponse(Response response) {
    this.response = response;
  }

}
