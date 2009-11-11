/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.Map;

import com.extjs.gxt.ui.client.core.XDOM;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * A <code>DataProxy</code> that reads a data from a URL which may be in a
 * domain other than the originating domain of the running page.
 * 
 * <p />
 * Note that if you are retrieving data from a page that is in a domain that is
 * NOT the same as the originating domain of the running page, you must use this
 * class, rather than HttpProxy.
 * 
 * <p />
 * When using a load config object that implements <code>LoadConfig</code> or
 * <code>ModelData</code>, all properties and property values will be sent as
 * request parameters in the load request.
 * 
 * @param <D> the data type being returned by the proxy
 * 
 * @see HttpProxy
 */
public class ScriptTagProxy<D> implements DataProxy<D> {

  private static int ID = 0;
  private AsyncCallback<D> callback;
  private DataReader<D> reader;
  private Object config;
  private String url;
  private Element head = XDOM.getHead();

  public ScriptTagProxy(String url) {
    this.url = url;
  }

  public void load(DataReader<D> reader, Object loadConfig, AsyncCallback<D> callback) {
    this.callback = callback;
    this.reader = reader;
    this.config = loadConfig;

    String transId = "transId" + ID++;
    String prepend = url.indexOf("?") != -1 ? "&" : "?";
    String u = url + prepend + "callback=" + transId + generateUrl(loadConfig);

    createCallback(this, transId);

    Element script = DOM.createElement("script");
    script.setAttribute("src", u);
    script.setAttribute("id", transId);
    script.setAttribute("type", "text/javascript");
    script.setAttribute("language", "JavaScript");

    head.appendChild(script);
  }

  /**
   * Sets the proxies url.
   * 
   * @param url the url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  protected void destroyTrans(String id) {
    head.removeChild(DOM.getElementById(id));
  }

  protected String generateUrl(Object loadConfig) {
    StringBuffer sb = new StringBuffer();
    if (loadConfig instanceof ModelData) {
      Map<String, Object> map = ((ModelData) loadConfig).getProperties();
      for (String key : map.keySet()) {
        sb.append("&" + key + "=" + map.get(key));
      }
    }
    return sb.toString();
  }

  @SuppressWarnings("unchecked")
  protected void onReceivedData(String transId, JavaScriptObject jso) {
    try {
      D data = null;
      if (reader != null) {
        data = reader.read(config, jso);
      } else {
        data = (D) jso;
      }
      callback.onSuccess(data);
    } catch (Exception e) {
      callback.onFailure(e);
    }
    destroyTrans(transId);
  }

  private native void createCallback(ScriptTagProxy<D> proxy, String transId) /*-{
      cb = function( j ){
      proxy.@com.extjs.gxt.ui.client.data.ScriptTagProxy::onReceivedData(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(transId, j);
      };
      $wnd[transId]=cb;
      }-*/;

}
