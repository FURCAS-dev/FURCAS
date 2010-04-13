/**
 * <copyright> 
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
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
 * $Id: JavaImporterPlugin.java,v 1.5 2006/12/18 21:32:13 marcelop Exp $
 */
package org.eclipse.emf.importer.java;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.importer.ImporterPlugin;


/**
 * The <b>Plugin</b> for the EMF.CodeGen.Ecore.Rose library.
 * @since 2.1.0
 */
public final class JavaImporterPlugin extends EMFPlugin
{
  /**
   * The singleton instance of the plugin.
   */
  public static final JavaImporterPlugin INSTANCE = new JavaImporterPlugin();

  /**
   * The one instance of this class.
   */
  private static Implementation plugin;

  /**
   * Creates the singleton instance.
   */
  private JavaImporterPlugin()
  {
    super(new ResourceLocator [] { ImporterPlugin.INSTANCE });
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
