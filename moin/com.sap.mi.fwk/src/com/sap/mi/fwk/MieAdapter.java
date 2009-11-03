package com.sap.mi.fwk;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

/**
 * @deprecated use {@link ModelAdapter} and
 *             <code>com.sap.mi.fwk.ui.ModelAdapterUI</code>
 */
@Deprecated
public final class MieAdapter {

	/**
	 * @deprecated use the typed methods in {@link ModelAdapter}
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	public static <T> T adaptTo(Object object, Class<T> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Class must not be null"); //$NON-NLS-1$
		}

		if (object == null) {
			return null;
		}

		// instanceof
		if (clazz.isInstance(object)) {
			return (T) object;
		}

		// generic Eclipse adapter facilities
		Object adapter;
		if (object instanceof IAdaptable) {
			adapter = ((IAdaptable) object).getAdapter(clazz);
		} else {
			adapter = Platform.getAdapterManager().getAdapter(object, clazz);
		}
		if (adapter != null) {
			return adaptTo(adapter, clazz);
		}

		// custom conversions
		if (clazz.isAssignableFrom(Connection.class)) {
			if (object instanceof RefBaseObject) {
				return (T) getConnection((RefBaseObject) object);
			}
		} else if (clazz.isAssignableFrom(IProject.class)) {
			if (object instanceof IResource) {
				return (T) ((IResource) object).getProject();
			} else if (object instanceof RefBaseObject) {
				return (T) getProject((RefBaseObject) object);
			} else if (object instanceof Connection) {
				IProject project = getProjectOfConnection((Connection) object);
				return (T) project;
			} else {
				Connection connection = adaptTo(object, Connection.class);
				if (connection == null) {
					RefBaseObject refObject = adaptTo(object, RefBaseObject.class);
					if (refObject != null) {
						connection = adaptTo(refObject, Connection.class);
					}
				}
				if (connection != null) {
					IProject project = getProjectOfConnection(connection);
					return (T) project;
				}
			}
		} else if (clazz.isAssignableFrom(JmiHelper.class)) {
			if (object instanceof RefBaseObject) {
				return (T) getJmiHelper((RefBaseObject) object);
			}
		}

		return null;
	}

	/**
	 * @deprecated use {@link ModelAdapter#getProject(RefBaseObject)}
	 */
	@Deprecated
	public static IProject getProject(RefBaseObject object) {
		return ModelAdapter.getInstance().getProjectUsingConnection(object);
	}

	/**
	 * @deprecated use {@link ModelAdapter#getConnection(RefBaseObject)}
	 */
	@Deprecated
	public static Connection getConnection(RefBaseObject object) {
		return ModelAdapter.getInstance().getConnection(object);
	}

	/**
	 * @deprecated use {@link ModelAdapter#getMri(RefBaseObject)}
	 */
	@Deprecated
	public static MRI getMRI(RefBaseObject object) {
		return ModelAdapter.getInstance().getMri(object);
	}

	/**
	 * @deprecated use {@link ModelAdapter#getPri(RefBaseObject)}
	 */
	@Deprecated
	public static PRI getPRI(RefBaseObject object) {
		return ModelAdapter.getInstance().getPri(object);
	}

	/**
	 * @deprecated use {@link ModelAdapter#getJmiHelper(RefBaseObject)}
	 */
	@Deprecated
	public static JmiHelper getJmiHelper(RefBaseObject object) {
		return ModelAdapter.getInstance().getJmiHelper(object);
	}

	/**
	 * @deprecated use {@link ModelAdapter#getFile(RefBaseObject)}
	 */
	@Deprecated
	public static IFile getFile(RefBaseObject refObject) {
		IFile file = ModelAdapter.getInstance().getFile(refObject);
		return file;
	}

	/**
	 * @deprecated use {@link ModelAdapter#getProject(Connection)}
	 */
	@Deprecated
	public static IProject getProjectOfConnection(Connection co) {
		return ModelAdapter.getInstance().getProject(co);
	}

	/**
	 * @deprecated use
	 *             {@link ModelAdapter#getProjectUsingConnection(RefBaseObject)}
	 */
	@Deprecated
	public static IProject getProjectOfConnection(RefObject object) {
		return ModelAdapter.getInstance().getProjectUsingConnection(object);
	}

	/**
	 * @deprecated use
	 *             {@link ModelAdapter#resolveInConnection(RefBaseObject, Connection)}
	 */
	@Deprecated
	public static <T extends RefBaseObject> T getElementInConnection(T element, Connection newConnection) {
		return ModelAdapter.getInstance().resolveInConnection(element, newConnection);
	}

	/**
	 * @deprecated use {@link ModelAdapter#adaptObject(Object, Class)}
	 */
	@Deprecated
	public static <T> T adaptObject(Object object, Class<T> clazz) {
		return ModelAdapter.getInstance().adaptObject(object, clazz);
	}

}