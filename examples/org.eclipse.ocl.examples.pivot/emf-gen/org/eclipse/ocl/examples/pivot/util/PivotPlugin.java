/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotPlugin.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.util;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.examples.pivot.OCLDebugOptions;
import org.eclipse.ocl.examples.pivot.OCLStatusCodes;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryRegistryReader;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Pivot model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class PivotPlugin
		extends EMFPlugin {

	public static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private static final String PREFIX_THROWING = "THROWN "; //$NON-NLS-1$

	private static final String SEPARATOR_SPACE = " "; //$NON-NLS-1$

	private static final String PARENTHESIS_OPEN = "("; //$NON-NLS-1$

	private static final String PARENTHESIS_CLOSE = ")"; //$NON-NLS-1$

	private static final String SEPARATOR_METHOD = "#"; //$NON-NLS-1$

	private static final String PREFIX_CATCHING = "CAUGHT "; //$NON-NLS-1$

	public static final String STANDARD_LIBRARY_PPID = "standard_library";

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PivotPlugin INSTANCE = new PivotPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * In stand-alone use, whether all tracing is turned on.
	 * This is compatible with the usage of 1.2 and earlier.
	 * @since 1.3
	 */
	private static boolean traceAll = Boolean
		.getBoolean("org.eclipse.ocl.debug"); //$NON-NLS-1$;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PivotPlugin() {
		super(new ResourceLocator [] {});
	}

	public static String getPluginId() {
		return (getPlugin() != null)
			? getPlugin().getBundle().getSymbolicName()
			: "org.eclipse.ocl.examples.pivot"; // last known bundle ID //$NON-NLS-1$
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * Obtains the best available resource factory suitable for serializing
	 * Ecore models.
	 * 
	 * @return the best available Ecore resource factory
	 */
	public static Resource.Factory getPivotResourceFactory() {
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

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation
			extends EclipsePlugin {

		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}

		@Override
		public void start(BundleContext context)
				throws Exception {
			super.start(context);

			//			EnvironmentRegistryImpl envreg = ((EnvironmentRegistryImpl) Environment.Registry.INSTANCE);
			//			envreg.new RegistryReader(getInstance()).readRegistry();
			new StandardLibraryRegistryReader().readRegistry();
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
			trace(PREFIX_CATCHING + throwable.getMessage() + SEPARATOR_SPACE
				+ PARENTHESIS_OPEN + clazz.getName() + SEPARATOR_METHOD
				+ methodName + PARENTHESIS_CLOSE);
			throwable.printStackTrace(System.err);
		}
	}

	public static void throwing(Class<?> clazz, String methodName,
			Throwable throwable) {
		if (shouldTrace(OCLDebugOptions.EXCEPTIONS_THROWING)) {
			trace(PREFIX_THROWING + throwable.getMessage() + SEPARATOR_SPACE
				+ PARENTHESIS_OPEN + clazz.getName() + SEPARATOR_METHOD
				+ methodName + PARENTHESIS_CLOSE);
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

		return traceAll || Boolean.getBoolean(option);
	}

	/**
	 * Emits the specified message to the trace log.  It is the caller's
	 * responsibility to ensure that the appropriate tracing option
	 * is enabled.
	 * 
	 * @param message a message
	 * 
	 * @see #shouldTrace(String)
	 */
	public static void trace(String message) {
		System.out.println("[OCL] " + message); //$NON-NLS-1$
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
		log(Diagnostic.ERROR, code, message, throwable);
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
		log(Diagnostic.INFO, code, message, throwable);
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
		log(Diagnostic.WARNING, code, message, throwable);
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
						case Diagnostic.WARNING :
							System.err.print("WARNING "); //$NON-NLS-1$
							break;
						case Diagnostic.ERROR :
						case Diagnostic.CANCEL :
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
			catching(PivotPlugin.class, "log", iae);//$NON-NLS-1$
		}
	}

}
