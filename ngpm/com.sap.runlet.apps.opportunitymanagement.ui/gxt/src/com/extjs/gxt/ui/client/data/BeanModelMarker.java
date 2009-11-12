/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker interface that identifies bean model classes indirectly without having
 * to modify the bean. As an alternative, the bean may implement the
 * {@link BeanModelTag} interface.
 */
public interface BeanModelMarker {

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.CLASS)
  public @interface BEAN {
    Class<?> value();
  }
}
