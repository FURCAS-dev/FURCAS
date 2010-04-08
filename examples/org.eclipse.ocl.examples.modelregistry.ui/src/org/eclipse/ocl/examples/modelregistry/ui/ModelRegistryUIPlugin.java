/**
 * <copyright>
 *
 * Copyright (c) 2008,2010 E.D.Willink and others.
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
 * $Id: ModelRegistryUIPlugin.java,v 1.2 2010/04/08 06:26:04 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.ui;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ModelRegistryUIPlugin extends Plugin
{
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.modelregistry.ui";

	// The shared instance
	public static ModelRegistryUIPlugin INSTANCE;

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}

	public static Status createErrorStatus(String string, Throwable e) {
		return new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, string, e);
	}
	
	public static void logError(String string, Throwable e) {	// FIXME Exploit EclipseUIPLugin.log() 
		ILog log = INSTANCE.getLog();
		log.log(createErrorStatus(string, e));
	}

	public static void showError(final String string, final Exception e) {
//		logError(string, e);
		Display display = Display.getDefault();
		if (Thread.currentThread() != display.getThread()) {
			display.syncExec(new Runnable() {
				public void run() {
					showError(string, e);					
				}});
		}			
		else
			ErrorDialog.openError(null, "OCL Model Registry Editor Error", null, createErrorStatus(string, e)); 		
	}
}
