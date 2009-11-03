package com.sap.mi.fwk.dcfwk.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Used for calling methods of plugin "com.sap.mi.fwk" without having static
 * dependency.<br>
 * Note: This is just a temporary solution - we have to restructure this in order to
 * get rid of dynamic invocation stuff.
 * 
 * @author d022960
 * 
 */
public class InvocationHelper {

	private static final TracerI sTracerProjects = TracingManager.getTracer("com.sap.mi.fwk.dcfwk.internal.InvocationHelper"); //$NON-NLS-1$

	public static IStatus callModelManager_refreshFromFileSystem(IProject project) {
		Object modelManager = getModelManagerInstance();
		try {
			Method method = modelManager.getClass().getMethod("refreshFromFileSystem", IProject.class, IProgressMonitor.class); //$NON-NLS-1$
			return (IStatus) method.invoke(modelManager, project, null);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e.getTargetException());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Object getModelManagerInstance() {
		Bundle bundle = getMiFwkBundle();

		Class<?> classObject = null;
		String className = "com.sap.mi.fwk.ModelManager"; //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return calGetInstance(classObject);
	}

	private static Object calGetInstance(Class<?> classObject) {
		Object result = null;
		try {
			Method method = classObject.getMethod("getInstance"); //$NON-NLS-1$
			result = method.invoke(null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	private static Bundle getMiFwkBundle() {
		String bundleName = "com.sap.mi.fwk"; //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			IllegalArgumentException e = new IllegalArgumentException("Bundle not found. Bundle name = " + //$NON-NLS-1$
					bundleName);
			DcFwkPlugin.logError(e, sTracerProjects);
			return null;
		}
		return bundle;
	}
}
