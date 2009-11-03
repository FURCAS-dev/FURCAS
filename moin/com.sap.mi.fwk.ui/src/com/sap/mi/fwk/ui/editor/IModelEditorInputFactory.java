package com.sap.mi.fwk.ui.editor;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IFileEditorInput;

/**
 * Defines a {@link ModelEditorInput} factory for {@link RefBaseObject}s. An
 * instance of this class will be instantiated once per object class coming from
 * extension point <code>com.sap.mi.fwk.ui.modelObjectEditorAssociations</code>.
 * <p/>
 * Not intended to be implemented directly, subclass
 * {@link ModelObjectElementFactory} instead.
 * 
 * @author d024127
 * @author d031150
 */
public interface IModelEditorInputFactory extends IElementFactory {

	/**
	 * Creates a {@link ModelEditorInput} for the given input object.
	 * 
	 * @param inputObject
	 *            The object to create an input for
	 * @return the ModelEditorInput
	 */
	ModelEditorInput createEditorInput(RefBaseObject inputObject);

	/**
	 * Creates a {@link ModelEditorInput} for the given input. This is used when
	 * Eclipse tries to launch an editor with a foreign input, usally an
	 * {@link IFileEditorInput}. Implementors may here convert this input to a
	 * {@link ModelEditorInput}. <code>null</code> should be returned in case
	 * the input is not convertable.
	 * 
	 * @param otherInput
	 *            the input to convert
	 * @return the converted input or <code>null</code> to indicate that the
	 *         other input cannot be used
	 * 
	 * @see ModelEditorManager#convertEditorInput(IEditorInput, String)
	 */
	ModelEditorInput createEditorInput(IEditorInput otherInput);

}
