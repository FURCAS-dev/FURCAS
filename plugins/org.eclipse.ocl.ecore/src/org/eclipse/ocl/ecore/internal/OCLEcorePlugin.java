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

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.ecore.EvaluationVisitorImpl;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.delegate.OCLValidationDelegate;
import org.eclipse.ocl.ecore.impl.NullLiteralExpImpl;

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
	
	private WeakHashMap<EOperation, OCLExpression> operationBodyCache =
		new WeakHashMap<EOperation, OCLExpression>();

	private WeakHashMap<EStructuralFeature, OCLExpression> propertyBodyCache =
		new WeakHashMap<EStructuralFeature, OCLExpression>();

	private WeakHashMap<EClassifier, Map<String, OCLExpression>> invariantBodyCache =
		new WeakHashMap<EClassifier, Map<String, OCLExpression>>();

	/**
	 * An "identifying" class that helps distinguish between the case where an operation or property
	 * isn't found in the expression cache and hasn't been looked up elsewhere yet from the case where
	 * we looked around for a definition but couldn't find one 
	 */
	private static class NullExpression extends NullLiteralExpImpl {}
	
	private NullExpression theNullExpression = new NullExpression();

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

	/**
	 * Looks for a cached OCL body for <code>operation</code>.
	 * 
	 * @return <code>null</code> in case nothing is currently known by the cache
	 *         about <code>operation</code>. If
	 *         {@link #featureHasNonOCLDefinition(OCLExpression)} returns
	 *         <code>true</code> for the result then this means that an attempt
	 *         was made before to locate an OCL body for <code>operation</code>,
	 *         but none was found.
	 */
	public OCLExpression getCachedOperationBody(EOperation operation) {
		return operationBodyCache.get(operation);
	}
	
	/**
	 * Caches the <code>body</code> expression for use in the
	 * {@link EvaluationVisitorImpl} during evaluating {@link OperationCallExp}
	 * expressions calling <code>operation</code>. The cache only weakly
	 * references <code>operation</code> so that when it otherwise becomes
	 * eligible for garbage collection it may get implicitly removed from the
	 * cache.
	 */
	public void cacheOperationBody(EOperation operation, OCLExpression body) {
		operationBodyCache.put(operation, body);
	}

	/**
	 * Records in the cache otherwise operated by
	 * {@link #getCachedOperationBody(EOperation)} and
	 * {@link #cacheOperationBody(EOperation, OCLExpression)} that for
	 * <code>operation</code> there was no OCL body found. Afterwards, responses
	 * from {@link #getCachedOperationBody(EOperation)} will return a special
	 * {@link OCLExpression} that, when tested with
	 * {@link #featureHasNonOCLDefinition(OCLExpression)}, returns
	 * <code>true</code>
	 */
	public void cacheOperationHasNoOCLBody(EOperation operation) {
		cacheOperationBody(operation, theNullExpression);
	}

	/**
	 * Looks for a cached OCL body for <code>property</code>.
	 * 
	 * @return <code>null</code> in case nothing is currently known by the cache
	 *         about <code>property</code>. If
	 *         {@link #featureHasNonOCLDefinition(OCLExpression)} returns
	 *         <code>true</code> for the result then this means that an attempt
	 *         was made before to locate an OCL body for <code>property</code>,
	 *         but none was found.
	 */
	public OCLExpression getCachedPropertyBody(EStructuralFeature property) {
		return propertyBodyCache.get(property);
	}
	
	/**
	 * Caches the <code>body</code> expression for use in the
	 * {@link EvaluationVisitorImpl} during evaluating {@link OperationCallExp}
	 * expressions calling <code>operation</code>. The cache only weakly
	 * references <code>operation</code> so that when it otherwise becomes
	 * eligible for garbage collection it may get implicitly removed from the
	 * cache.
	 */
	public void cachePropertyBody(EStructuralFeature property, OCLExpression body) {
		propertyBodyCache.put(property, body);
	}
	
	/**
	 * Records in the cache otherwise operated by
	 * {@link #getCachedPropertyBody(EStructuralFeature)} and
	 * {@link #cachePropertyBody(EStructuralFeature, OCLExpression)} that for
	 * <code>property</code> there was no OCL body found. Afterwards, responses
	 * from {@link #getCachedPropertyBody(EStructuralFeature)} will return a
	 * special {@link OCLExpression} that, when tested with
	 * {@link #featureHasNonOCLDefinition(OCLExpression)}, returns
	 * <code>true</code>
	 */
	public void cachePropertyHasNoOCLBody(EStructuralFeature property) {
		cachePropertyBody(property, theNullExpression);
	}

	/**
	 * Looks for a cached OCL body for the constraint named
	 * <code>constraintName</code> on type <code>classifier</code>.
	 * 
	 * @return <code>null</code> in case nothing is currently known by the cache
	 *         about the constraint named <code>constraintName</code> on type
	 *         <code>classifier</code>. If
	 *         {@link #featureHasNonOCLDefinition(OCLExpression)} returns
	 *         <code>true</code> for the result then this means that an attempt
	 *         was made before to locate the respective OCL body, but none was
	 *         found.
	 */
	public OCLExpression getCachedInvariantBody(EClassifier classifier, String constraintName) {
		Map<String, OCLExpression> constraints = invariantBodyCache.get(classifier);
		OCLExpression result = null;
		if (constraints != null) {
			result = constraints.get(constraintName);
		}
		return result;
	}
	
	/**
	 * Caches the <code>body</code> expression for use in the
	 * {@link OCLValidationDelegate} during validation. The cache only weakly
	 * references <code>classifier</code> so that when it otherwise becomes
	 * eligible for garbage collection it may get implicitly removed from the
	 * cache.
	 */
	public void cacheInvariantBody(EClassifier classifier, String constraintName, OCLExpression body) {
		Map<String, OCLExpression> constraints = invariantBodyCache.get(classifier);
		if (constraints == null) {
			constraints = new HashMap<String, OCLExpression>();
			invariantBodyCache.put(classifier, constraints);
		}
		constraints.put(constraintName, body);
	}

	/**
	 * Records in the cache otherwise operated by
	 * {@link #getCachedInvariantBody(EClassifier, String)} and
	 * {@link #cacheInvariantBody(EClassifier, String, OCLExpression)} that for
	 * <code>classifier</code> for the constraint named <code>constraintName</code>
	 * there was no OCL body found. Afterwards, responses from
	 * {@link #getCachedInvariantBody(EClassifier, constraintName)} will return a
	 * special {@link OCLExpression} that, when tested with
	 * {@link #featureHasNonOCLDefinition(OCLExpression)}, returns
	 * <code>true</code>
	 */
	public void cacheInvariantHasNoOCLBody(EClassifier classifier, String constraintName) {
		cacheInvariantBody(classifier, constraintName, theNullExpression);
	}
	
	/**
	 * Checks if the response from {@link #getCachedOperationBody(EOperation)}
	 * or {@link #getCachedPropertyBody(EStructuralFeature)} indicates that
	 * there is no OCL-defined body for the respective feature.
	 */
	public boolean featureHasNonOCLDefinition(OCLExpression cacheResponse) {
		return cacheResponse == theNullExpression;
	}
}
