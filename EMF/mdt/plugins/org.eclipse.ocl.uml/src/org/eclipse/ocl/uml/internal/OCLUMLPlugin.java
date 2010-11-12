/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: OCLUMLPlugin.java,v 1.5 2008/10/12 01:12:33 cdamus Exp $
 */
package org.eclipse.ocl.uml.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * The activator class controls the plug-in life cycle
 */
public class OCLUMLPlugin
		extends EMFPlugin {

	public static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private static final String PREFIX_THROWING = "THROWN "; //$NON-NLS-1$

	private static final String SEPARATOR_SPACE = " "; //$NON-NLS-1$

	private static final String PARENTHESIS_OPEN = "("; //$NON-NLS-1$

	private static final String PARENTHESIS_CLOSE = ")"; //$NON-NLS-1$

	private static final String SEPARATOR_METHOD = "#"; //$NON-NLS-1$

	private static final String PREFIX_CATCHING = "CAUGHT "; //$NON-NLS-1$

	//The shared instance.
	public static OCLUMLPlugin INSTANCE = new OCLUMLPlugin();

	//The shared Eclipse plug-in instance
	private static Implementation plugin;

	/**
	 * The constructor.
	 */
	public OCLUMLPlugin() {
		super(new ResourceLocator[0]);
	}

	public static String getPluginId() {
		return (getPlugin() != null)
			? getPlugin().getBundle().getSymbolicName()
			: "org.eclipse.ocl.uml"; // last known bundle ID //$NON-NLS-1$
	}

	// implements the inherited method
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Obtains the Eclipse plug-in that I implement.
	 * 
	 * @return my Eclipse plug-in self
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * Returns the shared instance.
	 */
	public static OCLUMLPlugin getInstance() {
		return INSTANCE;
	}

	/**
	 * The definition of the Eclipse plug-in flavour of this EMF plug-in.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	public static class Implementation
			extends EMFPlugin.EclipsePlugin {

		/**
		 * Initializes me with my Eclipse plug-in descriptor.
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			OCLUMLPlugin.plugin = this;
		}
	}

	/**
	 * Traces the catching of the specified throwable in the specified method of
	 * the specified class.
	 * 
	 * @param clazz
	 *            The class in which the throwable is being caught.
	 * @param methodName
	 *            The name of the method in which the throwable is being caught.
	 * @param throwable
	 *            The throwable that is being caught.
	 *  
	 */
	public static void catching(Class<?> clazz, String methodName,
			Throwable throwable) {
		if (shouldTrace(OCLDebugOptions.EXCEPTIONS_CATCHING)) {
			System.out.println(PREFIX_CATCHING + throwable.getMessage()
				+ SEPARATOR_SPACE + PARENTHESIS_OPEN + clazz.getName()
				+ SEPARATOR_METHOD + methodName + PARENTHESIS_CLOSE);
			throwable.printStackTrace(System.err);
		}
	}

	public static void throwing(Class<?> clazz, String methodName,
			Throwable throwable) {
		if (shouldTrace(OCLDebugOptions.EXCEPTIONS_THROWING)) {
			System.out.println(PREFIX_THROWING + throwable.getMessage()
				+ SEPARATOR_SPACE + PARENTHESIS_OPEN + clazz.getName()
				+ SEPARATOR_METHOD + methodName + PARENTHESIS_CLOSE);
			throwable.printStackTrace(System.err);
		}
	}

	public static boolean shouldTrace(String option) {
		if (getPlugin() != null) {
			if (getPlugin().isDebugging()) {
				return Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(option));
			}

			return false;
		}

		return Boolean.getBoolean("org.eclipse.ocl.uml.debug"); //$NON-NLS-1$
	}

	/**
	 * Generates an error log for the specified plug-in, with the specified
	 * status code, message.
	 * 
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 *  
	 */
	public static void error(int code, String message) {
		error(code, message, null);
	}

	/**
	 * Generates an error log for the specified plug-in, with the specified
	 * status code, message, and throwable.
	 * 
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *  
	 */
	public static void error(int code, String message, Throwable throwable) {
		log(IStatus.ERROR, code, message, throwable);
	}

	/**
	 * Generates an information log for the specified plug-in, with the
	 * specified message. Uses OK as status code.
	 * 
	 * @param message
	 *            The message for the log.
	 *  
	 */
	public static void info(String message) {
		info(OCLStatusCodes.OK, message);
	}

	/**
	 * Generates an information log for the specified plug-in, with the
	 * specified status code, message.
	 * 
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 *  
	 */
	public static void info(int code, String message) {
		info(code, message, null);
	}

	/**
	 * Generates an information log for the specified plug-in, with the
	 * specified status code, message, and throwable.
	 * 
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *  
	 */
	public static void info(int code, String message, Throwable throwable) {
		log(IStatus.INFO, code, message, throwable);
	}

	/**
	 * Generates a warning log for the specified plug-in, with the specified
	 * status code, message.
	 * 
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 *  
	 */
	public static void warning(int code, String message) {
		warning(code, message, null);
	}

	/**
	 * Generates a warning log for the specified plug-in, with the specified
	 * status code, message, and throwable.
	 * 
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *  
	 */
	public static void warning(int code, String message, Throwable throwable) {
		log(IStatus.WARNING, code, message, throwable);
	}

	public static void log(int severity, int code, String message,
			Throwable throwable) {
		//
		// Status ctor requires a non-null message
		String msg = message == null
			? "" //$NON-NLS-1$
			: message;

		try {
			if (getPlugin() != null) {
				// Eclipse environment
				getPlugin().log(
					new Status(severity, getPluginId(), code, msg, throwable));
			} else {
				// not in the Eclipse environment
				if (shouldTrace(OCLDebugOptions.DEBUG)) {
					switch (code) {
						case IStatus.WARNING :
							System.err.print("WARNING "); //$NON-NLS-1$
							break;
						case IStatus.ERROR :
						case IStatus.CANCEL :
							System.err.print("ERROR "); //$NON-NLS-1$
							break;
						default :
							// don't output INFO or OK messages
							return;
					}

					System.err.print(code);
					System.err.print(": "); //$NON-NLS-1$
					System.err.println(message);

					if (throwable != null) {
						throwable.printStackTrace(System.err);
					}
				}
			}
		} catch (IllegalArgumentException iae) {
			catching(OCLUMLPlugin.class, "log", iae);//$NON-NLS-1$
		}
	}

}
