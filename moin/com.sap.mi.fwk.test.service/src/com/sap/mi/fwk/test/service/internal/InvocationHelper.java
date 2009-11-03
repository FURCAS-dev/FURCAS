package com.sap.mi.fwk.test.service.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.osgi.framework.Bundle;

import com.sap.tc.moin.repository.Connection;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

public class InvocationHelper {

	// TODO use constant: currently defined in MiLocations.MI_PROJECTS
	private static final TracerI sTracerProjects = TracingManager
			.getTracer("com.sap.moin.tooldevelopment.mie.projects"); //$NON-NLS-1$

	public static IStatus callModelManager_refreshFromFileSystem(IProject project, IProgressMonitor monitor) {
		Object instance = getModelManagerInstance();

		Object result = null;
		try {
			Method method = instance.getClass().getMethod(
					"refreshFromFileSystem", IProject.class, IProgressMonitor.class); //$NON-NLS-1$
			result = method.invoke(instance, project, monitor);
		} catch (NoSuchMethodException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		} catch (InvocationTargetException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			throw new RuntimeException(e.getTargetException());
		} catch (IllegalAccessException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		if (result instanceof IStatus) {
			return (IStatus) result;
		}
		return null;
	}

	public static IStatus callPartitionService_deletePartitions(IProject project, IProgressMonitor monitor) {
		Object instance = getPartitionServiceInstance();

		Object result = null;
		try {
			Method method = instance.getClass().getMethod("deletePartitions", IProject.class, IProgressMonitor.class); //$NON-NLS-1$
			result = method.invoke(instance, project, monitor);
		} catch (NoSuchMethodException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		} catch (InvocationTargetException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			throw new RuntimeException(e.getTargetException());
		} catch (IllegalAccessException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		if (result instanceof IStatus) {
			return (IStatus) result;
		}
		return null;
	}

	public static boolean callMetamodelManager_isMetamodelImported(String... metamodelContainerNames) {
		Object instance = getMetamodelManagerInstance();

		Object result = null;
		try {
			Method method = instance.getClass().getMethod("isMetamodelImported", String[].class); //$NON-NLS-1$
			result = method.invoke(instance, new Object[] { metamodelContainerNames });
		} catch (NoSuchMethodException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return false;
		} catch (InvocationTargetException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			throw new RuntimeException(e.getTargetException());
		} catch (IllegalAccessException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return false;
		}

		if (result instanceof Boolean) {
			return (Boolean) result;
		}
		return false;
	}

	public static Connection callConnectionManager_createConnection(IProject project) {
		Object instance = getConnectionManagerInstance();

		Object result = null;
		try {
			Method method = instance.getClass().getMethod("createConnection", IProject.class); //$NON-NLS-1$
			result = method.invoke(instance, project);
		} catch (NoSuchMethodException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		} catch (InvocationTargetException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			throw new RuntimeException(e.getTargetException());
		} catch (IllegalAccessException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		if (result instanceof Connection) {
			return (Connection) result;
		}
		return null;
	}

	public static IEditorPart callModelEditorManager_openEditor(RefBaseObject object, String editorId, Runnable followUp)
			throws PartInitException {
		Object instance = getModelEditorManagerInstance();

		Object result = null;
		try {
			Method method = instance.getClass().getMethod(
					"openEditor", RefBaseObject.class, String.class, Runnable.class); //$NON-NLS-1$
			result = method.invoke(instance, object, editorId, followUp);
		} catch (NoSuchMethodException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		} catch (InvocationTargetException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			throw new RuntimeException(e.getTargetException());
		} catch (IllegalAccessException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		if (result instanceof IEditorPart) {
			return (IEditorPart) result;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T callModelAdapter_adaptObject(Object object, Class<T> targetType) {
		Object instance = getModelAdapterInstance();

		Object result = null;
		try {
			Method method = instance.getClass().getMethod("adaptObject", Object.class, Class.class); //$NON-NLS-1$
			result = method.invoke(instance, object, targetType);
		} catch (NoSuchMethodException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		} catch (InvocationTargetException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			throw new RuntimeException(e.getTargetException());
		} catch (IllegalAccessException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		return (T) result;
	}

	public static Class<?> getIModelEditorClass() {
		Bundle bundle = getMiFwkUiBundle();
		Class<?> classObject = null;
		String className = "com.sap.mi.fwk.ui.editor.IModelEditor"; //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		return classObject;
	}

	private static Object getModelManagerInstance() {
		Bundle bundle = getMiFwkBundle();

		Class<?> classObject = null;
		String className = "com.sap.mi.fwk.ModelManager"; //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		return calGetInstance(classObject);
	}

	private static Object getPartitionServiceInstance() {
		Bundle bundle = getMiFwkBundle();

		Class<?> classObject = null;
		String className = "com.sap.mi.fwk.PartitionService"; //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		return calGetInstance(classObject);
	}

	private static Object getMetamodelManagerInstance() {
		Bundle bundle = getMiFwkBundle();

		Class<?> classObject = null;
		String className = "com.sap.mi.fwk.mm.MetamodelManager"; //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		return calGetInstance(classObject);
	}

	private static Object getConnectionManagerInstance() {
		Bundle bundle = getMiFwkBundle();

		Class<?> classObject = null;
		String className = "com.sap.mi.fwk.ConnectionManager"; //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		return calGetInstance(classObject);
	}

	private static Object getModelEditorManagerInstance() {
		Bundle bundle = getMiFwkUiBundle();

		Class<?> classObject = null;
		String className = "com.sap.mi.fwk.ui.editor.ModelEditorManager"; //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		return calGetInstance(classObject);
	}

	private static Object getModelAdapterInstance() {
		Bundle bundle = getMiFwkBundle();

		Class<?> classObject = null;
		String className = "com.sap.mi.fwk.ModelAdapter"; //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}

		return calGetInstance(classObject);
	}

	private static Object calGetInstance(Class<?> classObject) {
		Object result = null;
		try {
			Method method = classObject.getMethod("getInstance"); //$NON-NLS-1$
			result = method.invoke(null);
		} catch (NoSuchMethodException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		} catch (InvocationTargetException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			throw new RuntimeException(e.getTargetException());
		} catch (IllegalAccessException e) {
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}
		return result;
	}

	private static Bundle getMiFwkBundle() {
		String bundleName = "com.sap.mi.fwk"; //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			IllegalArgumentException e = new IllegalArgumentException("Bundle not found. Bundle name = " + //$NON-NLS-1$
					bundleName);
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}
		return bundle;
	}

	private static Bundle getMiFwkUiBundle() {
		String bundleName = "com.sap.mi.fwk.ui"; //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			IllegalArgumentException e = new IllegalArgumentException("Bundle not found. Bundle name = " + //$NON-NLS-1$
					bundleName);
			TestServicePlugin.logError(e, sTracerProjects);
			return null;
		}
		return bundle;
	}
}
