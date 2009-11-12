/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.HtmlContainerEvent;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * A specialized container whose contents can be specified as an existing
 * element, an html fragment, or a remote url. When adding children a css
 * selector is used to identify the element the child will be inserted into.
 * 
 * <p />
 * Code snippet:
 * 
 * <pre>{@code
   HtmlContainer hc = new HtmlContainer(
     "<div class=text style='padding:5px'>"
     + "<h1>Heading1</h1>"
     + "<i>Some text</i></br>"
     + "<div class=b1></div>"
     + "<u>Final text</u></div>");
   hc.add(new Button("Test"), "div.b1");
   hc.setBorders(true);
   hc.setSize(200, 100);
   hc.setPosition(10, 10);
   RootPanel.get().add(hc);
 * }</pre>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>Container BeforeAdd</dd>
 * <dd>Container Add</dd>
 * <dd>Container BeforeRemove</dd>
 * <dd>Container Remove</dd>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
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
public class HtmlContainer extends Container<Component> {

  /**
   * The method used when requesting remote content (defaults to
   * RequestBuilder.GET). Only applies when specifying a {@link #setUrl(String)}
   * .
   */
  public Method httpMethod = RequestBuilder.GET;

  /**
   * True to defer remote requests until the component is rendered (defauls to
   * false).
   */
  public boolean deferDownload;

  /**
   * The request data to be used in remote calls (defaults to null).
   */
  public String requestData;
  private Element elem;
  private String html;
  private String tagName = "div";
  private String url;
  private RequestBuilder requestBuilder;
  private RequestCallback callback;

  /**
   * Creates a new container.
   */
  public HtmlContainer() {

  }

  /**
   * Creates a new container.
   * 
   * @param elem the component's element
   */
  public HtmlContainer(Element elem) {
    this.elem = elem;
    this.elem.getStyle().setProperty("display", "block");
  }

  /**
   * Creates a new container.
   * 
   * @param requestBuilder the request to be used when setting a url
   */
  public HtmlContainer(RequestBuilder requestBuilder) {
    this.requestBuilder = requestBuilder;
  }

  /**
   * Creates a container.
   * 
   * @param html the containers inner html
   */
  public HtmlContainer(String html) {
    this.html = html;
  }

  /**
   * Adds a component to this Container. Fires the <i>BeforeAdd</i> event before
   * adding, then fires the <i>Add</i> event after the component has been added.
   * 
   * @param widget the widget to add. If the widget is not a Component it will
   *          be wrapped in a WidgetComponent
   * @param selector the css selector (ie div.class) used to identify the components parent
   */
  public void add(Widget widget, String selector) {
    Component component = wrapWidget(widget);
    if (super.add(component)) {
      component.setData("selector", selector);
      if (rendered) {
        renderItem(component, selector);
      }
    }
  }

  /**
   * @return the tagName
   */
  public String getTagName() {
    return tagName;
  }

  /**
   * Sets the container's inner html.
   * 
   * @param html the html
   */
  public void setHtml(String html) {
    this.html = html;
    if (rendered) {
      el().removeChildren();
      getElement().setInnerHTML(html);
      renderAll();
    }
  }

  /**
   * The HTML tag name that will wrap the text (defaults to 'div'). For inline
   * behavior set the tag name to 'span'.
   * 
   * @param tagName the new tag name
   */
  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  /**
   * Retrieves and sets the container's content from the given url.
   * 
   * @param url the url
   */
  public void setUrl(String url) {
    this.url = url;
    if (!deferDownload) {
      requestData();
    }
  }

  protected void handleError(Request request, Throwable exception) {
    HtmlContainerEvent hce = new HtmlContainerEvent(this);
    hce.setException(exception);
    fireEvent(Loader.LoadException, hce);
  }

  protected void handleResponseReceived(Request request, Response response) {
    HtmlContainerEvent hce = new HtmlContainerEvent(this);
    hce.setResponse(response);
    hce.setHtml(response.getText());
    fireEvent(Loader.Load, hce);
    setHtml(hce.getHtml());
  }

  @Override
  protected void onRender(Element target, int index) {
    if (elem != null) {
      setElement(elem);
      renderAll();
    } else {
      setElement(DOM.createElement(tagName), target, index);
      if (html != null) {
        setHtml(html);
      } else if (url != null && deferDownload) {
        requestData();
      }
    }
  }

  protected void renderAll() {
    for (Component c : getItems()) {
      renderItem(c, (String) c.getData("selector"));
    }
  }

  protected void renderItem(Component item, String selector) {
    El elem = el().selectNode(selector);
    if (elem != null) {
      elem.removeChildren();
      if (!item.isRendered()) {
        item.render(elem.dom);
      } else {
        getElement().appendChild(item.getElement());
      }
      if (isAttached() && !item.isAttached()) {
        ComponentHelper.doAttach(item);
      }
    }
  }

  protected void requestData() {
    if (requestBuilder == null) {
      requestBuilder = new RequestBuilder(httpMethod, url);
    }
    if (callback == null) {
      callback = new RequestCallback() {
        public void onError(Request request, Throwable exception) {
          handleError(request, exception);
        }

        public void onResponseReceived(Request request, Response response) {
          handleResponseReceived(request, response);
        }
      };
    }
    try {
      requestBuilder.sendRequest(requestData, callback);
    } catch (Exception e) {

    }

  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new HtmlContainerEvent(this);
  }

  @Override
  @SuppressWarnings("unchecked")
  protected ContainerEvent createContainerEvent(Component item) {
    return new HtmlContainerEvent(this, item);
  }
}
