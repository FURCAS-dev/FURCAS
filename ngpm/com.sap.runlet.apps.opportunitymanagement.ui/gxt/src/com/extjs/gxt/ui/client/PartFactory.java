/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory implementation that can be used to create to object instances given a
 * string identifier. <code>PartProviders</code> can be registered with the
 * factory.
 */
public class PartFactory {
  private static List<PartProvider> providers = new ArrayList<PartProvider>();

  /**
   * Returns a new object instance.
   * 
   * @param <X> the new object type
   * @param partId the part id
   * @return the new instance
   */
  @SuppressWarnings("unchecked")
  public static <X> X createPart(String partId) {
    for (PartProvider p : providers) {
      Object part = p.createPart(partId);
      if (part != null) {
        return (X) part;
      }
    }
    throw new RuntimeException("part not found: " + partId);
  }

  /**
   * Registers a new part provider.
   * 
   * @param provider the provider
   */
  public static void registerProvider(PartProvider provider) {
    providers.add(provider);
  }

  /**
   * Unregisters the part provider.
   * 
   * @param provider the part provider
   */
  public static void unregisterProvider(PartProvider provider) {
    providers.remove(provider);
  }
}
