/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.state;

import java.util.Date;

import com.google.gwt.user.client.Cookies;

/**
 * The default <code>Provider</code> implementation which saves state via
 * cookies.
 */
public class CookieProvider extends Provider {

  private Date expires;
  private String path, domain;
  private boolean secure;

  /**
   * Creates a new cookie provider
   * 
   * @param path The path for which the cookie is active (defaults to root '/'
   *          which makes it active for all pages in the site)
   * @param expires the cookie expiration date (defaults to 7 days from now)
   * @param domain The domain to save the cookie for. Note that you cannot
   *          specify a different domain than your page is on, but you can
   *          specify a sub-domain.
   * @param secure <code>true</code> if the site is using SSL
   */
  public CookieProvider(String path, Date expires, String domain, boolean secure) {
    this.path = path == null ? "/" : path;
    this.secure = secure;
    this.domain = domain;
    if (expires == null) {
      expires = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 7)); //7-
                                                                            // days
    }
    this.expires = expires;
  }

  protected void clearKey(String name) {
    Cookies.removeCookie(name);
  }

  protected String getValue(String name) {
    return Cookies.getCookie(name);
  }

  protected void setValue(String name, String value) {
    Cookies.setCookie(name, value, expires, domain, path, secure);
  }

  public void clear(String name) {
    Cookies.removeCookie(name);
  }

  public void set(String name, String value, Date expires) {
    Cookies.setCookie(name, value, expires, domain, path, secure);
  }

}
