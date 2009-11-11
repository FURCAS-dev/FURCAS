/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.Map;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * A concrete <code>DataProxy</code> that retrieves data using a
 * <code>RequestBulder</code> instances.
 * 
 * <p />
 * When using a load config object that implements <code>LoadConfig</code> or
 * <code>ModelData</code>, all properties and property values will be sent as
 * request parameters in the load request.
 * 
 * @param <D> the data type being returned by the proxy
 * 
 * @see RequestBuilder
 * @see ScriptTagProxy
 */
public class HttpProxy<D> implements DataProxy<D> {

  protected RequestBuilder builder;
  protected String initUrl;

  /**
   * Creates a new HttpProxy.
   * 
   * @param builder the request builder
   */
  public HttpProxy(RequestBuilder builder) {
    this.builder = builder;
    this.initUrl = builder.getUrl();
  }

  public void load(final DataReader<D> reader, final Object loadConfig, final AsyncCallback<D> callback) {
    try {
      String data = null;
      if (builder.getHTTPMethod().equals("POST")) {
        data = generateUrl(loadConfig);
      } else {
        String url = initUrl;
        url = url + (url.indexOf("?") == -1 ? "?" : "&");
        String params = generateUrl(loadConfig);
        url += params;
        setUrl(builder, url);
      }

      builder.sendRequest(data, new RequestCallback() {
        public void onError(Request request, Throwable exception) {
          callback.onFailure(exception);
        }

        @SuppressWarnings("unchecked")
        public void onResponseReceived(Request request, Response response) {
          if (response.getStatusCode() != Response.SC_OK) {
            callback.onFailure(new RuntimeException("HttpProxy: Invalid status code "
                + response.getStatusCode()));
            return;
          }
          String text = response.getText();
          try {
            D data = null;
            if (reader != null) {
              data = reader.read(loadConfig, text);
            } else {
              data = (D) text;
            }
            callback.onSuccess(data);
          } catch (Exception e) {
            e.printStackTrace();
            callback.onFailure(e);
          }
        }
      });
    } catch (Exception e) {
      callback.onFailure(e);
    }
  }

  protected String generateUrl(Object loadConfig) {
    StringBuffer sb = new StringBuffer();
    if (loadConfig instanceof ModelData) {
      Map<String, Object> map = ((ModelData) loadConfig).getProperties();
      for (String key : map.keySet()) {
        sb.append("&" + key + "=" + map.get(key));
      }
    }
    if (sb.length() > 0) {
      return sb.substring(1, sb.length());
    }
    return sb.toString();
  }

  private native void setUrl(RequestBuilder rb, String url) /*-{
      rb.@com.google.gwt.http.client.RequestBuilder::url = url;
    }-*/;
}