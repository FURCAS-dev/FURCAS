/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - rework of LPG OCL Console for Xtext
 *
 * </copyright>
 *
 * $Id: XtextConsolePlugin.java,v 1.3 2011/03/31 16:53:48 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.console;

import org.eclipse.ocl.examples.xtext.essentialocl.ui.internal.EssentialOCLActivator;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLPlugin;

import com.google.inject.Module;

/**
 * The main plugin class to be used in the desktop.
 */
public class XtextConsolePlugin extends EssentialOCLActivator
{
	// The shared instance.
	private static XtextConsolePlugin plugin;

	/**
	 * Returns the shared instance.
	 */
	public static XtextConsolePlugin getInstance() {
		return plugin;
	}

	/**
	 * Obtains my plug-in ID.
	 * 
	 * @return my plug-in ID
	 */
	public static String getPluginId() {
		return getInstance().getBundle().getSymbolicName();
	}

	/**
	 * The constructor.
	 */
	public XtextConsolePlugin() {
		super();
		plugin = this;
	}
	
	protected Module getRuntimeModule(String grammar) {
		if (EssentialOCLPlugin.LANGUAGE_ID.equals(grammar)) {
		  return new XtextConsoleRuntimeModule();
		}
		
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getUiModule(String grammar) {
		if (EssentialOCLPlugin.LANGUAGE_ID.equals(grammar)) {
		  return new XtextConsoleUiModule(this);
		}
		
		throw new IllegalArgumentException(grammar);
	}
}
