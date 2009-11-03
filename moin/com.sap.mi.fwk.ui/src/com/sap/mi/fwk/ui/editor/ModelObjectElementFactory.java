package com.sap.mi.fwk.ui.editor;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import com.sap.tc.moin.repository.MRI;

/**
 * An element factory used for creating {@link ModelEditorInput}s out of either
 * an Eclipse {@link IMemento}, {@link RefBaseObject} or {@link MRI} string.
 * 
 * @author d031150
 */
public class ModelObjectElementFactory implements IModelEditorInputFactory {

	/**
	 * The id of this factory. By default
	 * {@link ModelEditorInput#getFactoryId()} returns this id.
	 */
	public static final String FACTORY_ID = "com.sap.mi.fwk.ui.editor.ModelObjectElementFactory"; //$NON-NLS-1$
	/**
	 * The key for the stored {@link MRI} string
	 */
	public static final String KEY_MRI = "mri"; //$NON-NLS-1$
	/**
	 * The key for the stored project name
	 */
	public static final String KEY_PROJECTNAME = "projectName"; //$NON-NLS-1$

	/**
	 * The key for the stored object name
	 */
	public static final String KEY_OBJECT_NAME = "objectName"; //$NON-NLS-1$

	/**
	 * Creates a factory
	 */
	public ModelObjectElementFactory() {
	}

	/**
	 * The default implementation of
	 * {@link IElementFactory#createElement(IMemento)} calls
	 * {@link #createEditorInput(IMemento)}. Subclasses should override the
	 * latter method.
	 */
	public IAdaptable createElement(IMemento memento) {
		ModelEditorInput input = createEditorInput(memento);
		if (input != null) {
			// ensure the project name is set (sub class could have choosen a
			// different constructor)
			String projectName = getProjectName(memento);
			input.setProjectName(projectName);
			if (!input.hasName()) {
				input.setName(getObjectName(memento));
			}
		}
		return input;
	}

	/**
	 * Creates a {@link ModelEditorInput} using the given memento. Called when
	 * Eclipse tries to restore editors. The default implementation creates a
	 * {@link ModelEditorInput} configured with {@link #KEY_MRI} and
	 * {@link #KEY_PROJECTNAME}, which are mandatory. Subclasses should
	 * override this method instead of {@link #createElement(IMemento)} if they
	 * want to provide a specialized input.
	 * 
	 * @param memento
	 *            information to restore the editor from
	 * @return the input or <code>null</code> if it could not be created using
	 *         the memento.
	 * 
	 * @see #getMriString(IMemento)
	 * @see #getProjectName(IMemento)
	 */
	protected ModelEditorInput createEditorInput(IMemento memento) {
		String mri = getMriString(memento);
		String projectName = getProjectName(memento);
		// Eclipse may call us with an unknown memento, fail gracefully here.
		if (mri == null || projectName == null)
			return null;
		ModelEditorInput result = createEditorInput(mri, projectName);
		if (!result.hasName()) {
			result.setName(getObjectName(memento));
		}
		return result;
	}

	/**
	 * This default implementation creates an instance of
	 * {@link ModelEditorInput} with a {@link RefBaseObject}.
	 */
	public ModelEditorInput createEditorInput(RefBaseObject refObj) {
		return new ModelEditorInput(refObj);
	}

	/**
	 * This default implementation creates an instance of
	 * {@link ModelEditorInput} with a {@link MRI} string and an
	 * {@link IProject} name.
	 */
	public ModelEditorInput createEditorInput(String mriString, String projectName) {
		return new ModelEditorInput(mriString, projectName);
	}

	/**
	 * This default implementation simply returns the <code>otherInput</code>
	 * if this one already is a {@link ModelEditorInput}, otherwise
	 * <code>null</code>. Subclasses should override to define other
	 * strategies.
	 */
	public ModelEditorInput createEditorInput(IEditorInput otherInput) {
		if (otherInput instanceof ModelEditorInput)
			return (ModelEditorInput) otherInput;
		return null;
	}

	/**
	 * Returns the {@link MRI} string stored in the given memento using
	 * {@link #KEY_MRI} as key.
	 * 
	 * @param memento
	 *            the memento
	 * @return a {@link MRI} string
	 * 
	 * @see MRI#toString()
	 */
	protected String getMriString(IMemento memento) {
		String mri = memento.getString(KEY_MRI);
		return mri;
	}

	/**
	 * Returns the project name stored in the given memento using
	 * {@link #KEY_PROJECTNAME} as key.
	 * 
	 * @param memento
	 *            the memento
	 * @return the project name
	 * 
	 * @see IResource#getName()
	 */
	protected String getProjectName(IMemento memento) {
		String mri = memento.getString(KEY_PROJECTNAME);
		return mri;
	}

	/**
	 * Returns the object name from this memento
	 * 
	 * @param memento
	 *            the current memento
	 * @return the object's name or null
	 */
	protected String getObjectName(IMemento memento) {
		return memento.getString(KEY_OBJECT_NAME);
	}
}
