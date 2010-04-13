/**
 * <copyright> 
 *
 * Copyright (c) 2005-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ExporterPlugin.java,v 1.3 2006/12/28 06:50:54 marcelop Exp $
 */
package org.eclipse.emf.exporter;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.converter.ConverterPlugin;


/**
 * The <b>Plugin</b> for the model exporter.
 * @since 2.2.0
 */
public final class ExporterPlugin extends EMFPlugin
{
  /**
   * The singleton instance of the plugin.
   */
  public static final ExporterPlugin INSTANCE = new ExporterPlugin();

  /**
   * The one instance of this class.
   */
  private static Implementation plugin;
  
  public static final String ID = "org.eclipse.emf.exporter";

  /**
   * Creates the singleton instance.
   */
  private ExporterPlugin()
  {
    super
      (new ResourceLocator []
       {
         ConverterPlugin.INSTANCE
       });
  }

  /*
   * Javadoc copied from base class.
   */
  @Override
  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * @return the singleton instance.
   */
  public static Implementation getPlugin()
  {
    return plugin;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   */
  public static class Implementation extends EclipsePlugin
  {
    /**
     * Creates an instance.
     */
    public Implementation()
    {
      super();

      // Remember the static instance.
      //
      plugin = this;
    }
  }
}
