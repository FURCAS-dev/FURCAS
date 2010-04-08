/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ModelRegistryPlugin.java,v 1.2 2010/04/08 06:23:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.eclipse;


import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ModelRegistryPlugin extends Plugin
{
	// The shared instance
	private static ModelRegistryPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ModelRegistryPlugin() {
		new EclipseModelRegistryEnvironment();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ModelRegistryPlugin getDefault() {
		return plugin;
	}


	public static void log(final IStatus status, boolean showErrorDialog) {
		if (showErrorDialog)
			/*getPlugin().*/showStatus(status);					
//		ILog log = Platform.getPlugin(PLUG_IN_ID).getLog();
		ILog log = getDefault().getLog();
		log.log(status);
	}


	public static void showStatus(final IStatus status) {
//		ErrorDialog.openError(null /*shell*/, "Model Registry Execution Error", null, status);
	}
}
