/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: OCLExamplePlugin.java,v 1.4 2007/06/06 18:56:55 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class OCLExamplePlugin extends AbstractUIPlugin {

	
	// The shared instance.
	private static OCLExamplePlugin plugin;

	/**
	 * The constructor.
	 */
	public OCLExamplePlugin() {
		super();
		plugin = this;
	}

	/**
	 * Obtains my plug-in ID.
	 * 
	 * @return my plug-in ID
	 */
	public static String getPluginId() {
		return getDefault().getBundle().getSymbolicName();
	}
	
	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static OCLExamplePlugin getDefault() {
		return plugin;
	}
}
