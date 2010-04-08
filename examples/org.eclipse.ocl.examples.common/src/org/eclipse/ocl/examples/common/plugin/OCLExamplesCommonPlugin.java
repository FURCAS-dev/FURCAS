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
 * $Id: OCLExamplesCommonPlugin.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.plugin;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osgi.framework.BundleContext;

public final class OCLExamplesCommonPlugin extends EMFPlugin
{
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.common";
	public static final OCLExamplesCommonPlugin INSTANCE = new OCLExamplesCommonPlugin();
	public static final String LABEL_GENERATOR_PPID = "label_generator";
	private static Implementation plugin;

	public OCLExamplesCommonPlugin() {
		super
		  (new ResourceLocator [] {
		     EcorePlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * @return the singleton instance.
	 */
	@Override public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}
	
	public static void logError(String string, Throwable e) {
		if (plugin != null)
			plugin.logError(string, e);
		else
			System.err.println(string);
	}		

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
		
		public void logError(String string, Throwable e) {
			logException(newError(string, e));
		}		

		public void logException(Throwable e) {
			if (e instanceof InvocationTargetException) {
				e = ((InvocationTargetException) e).getTargetException();
			}
			IStatus status = null;
			if (e instanceof CoreException) {
				status = ((CoreException) e).getStatus();
			} else {
				String message = e.getMessage();
				if (message == null)
					message = e.toString();
				status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, message, e);
			}
			log(status);
		}
		
	    /**
	     * Return a CoreException with Error severity containing a text description and optionally
	     * wrapping a further exception.
	     * @param text description of exception
	     * @param exception optional wrapped exception
	     */
	    public CoreException newError(String text, Throwable exception) {
	        return new CoreException(new Status(IStatus.ERROR,
					PLUGIN_ID, IStatus.ERROR, "ERROR -- " + text, exception));
	    }

		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
		    new LabelGeneratorRegistryReader().readRegistry();
		}  
	}
}
