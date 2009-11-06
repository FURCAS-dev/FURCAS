package com.sap.mi.fwk.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.views.properties.IPropertySource;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * UI counterpart of {@link ModelAdapter} implementing several policies to
 * convert model entities of one type to another. <p/> In addition to
 * {@link ModelAdapter} adapts to UI types like {@link IStructuredSelection}.
 * Some of the services are intentionally Object-typed to address Object-based
 * Eclipse protocols like {@link ILabelProvider} or {@link IPropertySource}.
 * However, the typed methods in {@link ModelAdapter} should be preferred if
 * possible.
 * 
 * @author d031150
 */
public final class ModelAdapterUI extends ModelAdapter {

	private static final ModelAdapterUI sInstance = new ModelAdapterUI();

	/**
	 * @return the adapter instance
	 */
	public static ModelAdapterUI getInstance() {
		return sInstance;
	}

	/**
	 * Tries to convert the given object to a {@link RefBaseObject}
	 * <ul>
	 * <li>using {@link #adaptObject(Object, Class)},</li>
	 * <li>unwrapping an {@link IStructuredSelection}.</li>
	 * </ul>
	 * 
	 * @param object
	 *            the object to convert
	 * @return the target object or <code>null</code>
	 * 
	 * @see #getRefObject(Object)
	 */
	public RefBaseObject getRefBaseObject(Object object) {
		// if object directly adapts to target type, take this
		RefBaseObject refBaseObject = adaptObject(object, RefBaseObject.class);
		if (refBaseObject != null)
			return refBaseObject;
		// unwrap a structured selection
		if (object instanceof IStructuredSelection) {
			if (((IStructuredSelection) object).isEmpty())
				return null;
			Object element = ((IStructuredSelection) object).getFirstElement();
			return getRefBaseObject(element);
		}
		return null;
	}

	/**
	 * Tries to convert the given object to a {@link RefObject}
	 * <ul>
	 * <li>using {@link #adaptObject(Object, Class)},</li>
	 * <li>unwrapping an {@link IStructuredSelection}.</li>
	 * </ul>
	 * 
	 * @param object
	 *            the object to convert
	 * @return the target object or <code>null</code>
	 * 
	 * @see #getRefBaseObject(Object)
	 */
	public RefObject getRefObject(Object object) {
		// if object directly adapts to target type, take this
		RefObject refObject = adaptObject(object, RefObject.class);
		if (refObject != null)
			return refObject;
		// unwrap a structured selection
		if (object instanceof IStructuredSelection) {
			if (((IStructuredSelection) object).isEmpty())
				return null;
			Object element = ((IStructuredSelection) object).getFirstElement();
			return getRefObject(element);
		}
		return null;
	}

	/**
	 * Tries to convert the given object to an {@link IProject}
	 * <ul>
	 * <li>using {@link #adaptObject(Object, Class)},</li>
	 * <li>unwrapping an {@link IStructuredSelection},</li>
	 * <li>dispatching to the typed <code>getProject()</code> methods if the
	 * object is an instance of the respective input types.</li>
	 * </ul>
	 * 
	 * @param object
	 *            the object to convert
	 * @return the target object or <code>null</code>
	 * 
	 * @see #getProjectUsingConnection(Object)
	 */
	public IProject getProject(Object object) {
		// dispatch to all typed methods
		IProject project = dispatchGetProject(object);
		if (project != null)
			return project;

		// unwrap a structured selection
		if (object instanceof IStructuredSelection) {
			if (((IStructuredSelection) object).isEmpty())
				return null;
			Object element = ((IStructuredSelection) object).getFirstElement();
			return getProject(element);
		}
		return null;
	}

	/**
	 * Tries to convert the given object to an {@link IProject}
	 * <ul>
	 * <li>using {@link #adaptObject(Object, Class)},</li>
	 * <li>unwrapping an {@link IStructuredSelection},</li>
	 * <li>dispatching to the typed <code>getProjectUsingConnectio()</code>
	 * methods if the object is an instance of the respective input types.</li>
	 * </ul>
	 * 
	 * @param object
	 *            the object to convert
	 * @return the target object or <code>null</code>
	 * 
	 * @see #getProject(RefBaseObject)
	 */
	public IProject getProjectUsingConnection(Object object) {
		// dispatch to all typed methods
		IProject project = dispatchGetProjectUsingConnection(object);
		if (project != null)
			return project;

		// unwrap a structured selection
		if (object instanceof IStructuredSelection) {
			if (((IStructuredSelection) object).isEmpty())
				return null;
			Object element = ((IStructuredSelection) object).getFirstElement();
			return getProjectUsingConnection(element);
		}
		return null;
	}

	private ModelAdapterUI() {
	}

}
