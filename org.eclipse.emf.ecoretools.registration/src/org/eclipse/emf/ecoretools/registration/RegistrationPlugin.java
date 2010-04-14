/***********************************************************************
 * Copyright (c) 2007, 2008 INRIA and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    INRIA - initial API and implementation
 *
 * $Id: RegistrationPlugin.java,v 1.2 2008/04/28 15:47:42 jlescot Exp $
 **********************************************************************/
/* **********************************************************************
 * Copyright (c) 2007, 2008 INRIA and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.ecoretools.registration;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class RegistrationPlugin extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.emf.ecoretools.registration"; //$NON-NLS-1$

	// The shared instance
	private static RegistrationPlugin plugin;

	/**
	 * The constructor
	 */
	public RegistrationPlugin() {
		// Do nothing
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static RegistrationPlugin getDefault() {
		return plugin;
	}

}
