/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Zeligsoft - Bug 256040
 * 
 * $Id: OCLEcorePlugin.java,v 1.6 2010/04/08 06:27:21 ewillink Exp $
 * 
 *
 * </copyright>
 *
 * $Id: OCLEcorePlugin.java,v 1.6 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * The activator class controls the plug-in life cycle
 */
public class OCLEcorePlugin
		extends EMFPlugin {

	public static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private static final String PREFIX_THROWING = "THROWN "; //$NON-NLS-1$

	private static final String SEPARATOR_SPACE = " "; //$NON-NLS-1$

	private static final String PARENTHESIS_OPEN = "("; //$NON-NLS-1$

	private static final String PARENTHESIS_CLOSE = ")"; //$NON-NLS-1$

	private static final String SEPARATOR_METHOD = "#"; //$NON-NLS-1$

	private static final String PREFIX_CATCHING = "CAUGHT "; //$NON-NLS-1$

	//The shared instance.
	public static OCLEcorePlugin INSTANCE = new OCLEcorePlugin();

	//The shared Eclipse plug-in instance
	private static Implementation plugin;

	/**
	 * The constructor.
	 */
	public OCLEcorePlugin() {
		super(new ResourceLocator[0]);
	}

	public static String getPluginId() {
		return (getPlugin() != null)
			? getPlugin().getBundle().getSymbolicName()
			: "org.eclipse.ocl.ecore"; // last known bundle ID //$NON-NLS-1$
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
	public static OCLEcorePlugin getInstance() {
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
			OCLEcorePlugin.plugin = this;
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

		return Boolean.getBoolean("org.eclipse.ocl.ecore.debug"); //$NON-NLS-1$
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
			catching(OCLEcorePlugin.class, "log", iae);//$NON-NLS-1$
		}
	}

	/**
	 * Obtains the best available resource factory suitable for serializing
	 * Ecore models.
	 * 
	 * @return the best available Ecore resource factory
	 */
	public static Resource.Factory getEcoreResourceFactory() {
		//        Resource.Factory result;
		//        Object maybeFactory = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(
		//            "ecore"); //$NON-NLS-1$
		//        if (maybeFactory instanceof Resource.Factory.Descriptor) {
		//            result = ((Resource.Factory.Descriptor) maybeFactory).createFactory();
		//        } else if (maybeFactory instanceof Resource.Factory) {
		//            result = (Resource.Factory) maybeFactory;
		//        } else {
		//            maybeFactory = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(
		//                Resource.Factory.Registry.DEFAULT_EXTENSION);
		//            
		//            if (maybeFactory instanceof Resource.Factory.Descriptor) {
		//                result = ((Resource.Factory.Descriptor) maybeFactory).createFactory();
		//            } else if (maybeFactory instanceof Resource.Factory) {
		//                result = (Resource.Factory) maybeFactory;
		//            } else {
		//                result = new ResourceFactoryImpl();
		//            }
		//        }
		//        
		//        return result;
		// TODO: The EcoreResourceImpl should work!
		return new ResourceFactoryImpl() {

			@Override
			public Resource createResource(URI uri) {
				return new ResourceImpl(uri) {

					@Override
					public EObject getEObject(String uriFragment) {
						return super.getEObject(URI.decode(uriFragment));
					}
				};
			}
		};
	}
}
