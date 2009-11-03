package com.sap.mi.fwk.ui.editor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import com.sap.tc.moin.repository.Connection;

/**
 * Convenience page base class inheriting from {@link FormPage}.
 * 
 * @author d022960
 */
public abstract class ModelFormPage extends FormPage {

	private boolean partitionChanged;

	/**
	 * Constructor to be used, if within MultiPageEditorPart (if parent
	 * instanceof ModelMultiPageEditorPart connection is delegated to this one )
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 */
	public ModelFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		initialize(editor);
	}

	/**
	 * The constructor. The parent editor need to be passed in the
	 * <code>initialize</code> method if this constructor is used.
	 * 
	 * @param id
	 *            a unique page identifier
	 * @param title
	 *            a user-friendly page title
	 */
	public ModelFormPage(String id, String title) {
		super(id, title);
	}

	@Override
	public void initialize(FormEditor editor) {
		super.initialize(editor);
	}

	/**
	 * This method would typically be overwritten by your editor, you *must*
	 * call super.init()
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		// Call input and site setters not before here because they may be
		// overidden -
		// this code could already require a properly initialized connection.
		// The achieve this the code above must not call methods like
		// getInput().
		super.init(site, input);
	}

	@Override
	public boolean isDirty() {
		boolean isDirty = getModelEditor().isDirty();
		return isDirty;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		getModelEditor().doSave(monitor);
	}

	/**
	 * Model Editors commonly do not support isSaveAsAllowed. If your Editor
	 * supports this, override this method and override doSaveAs();
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void doSaveAs() {
		throw new UnsupportedOperationException("isSaveAllowed is false"); //$NON-NLS-1$
	}

	protected ModelEditor getModelEditor() {
		return ((ModelFormEditorPart) getEditor()).getModelEditor();
	}

	/**
	 * @return whether a default connection should be used by this editor. Such
	 *         a connection is not exclusively in the scope of this editor, but
	 *         may be used in other Moin clients as well. The default
	 *         implementation returns <code>false</code>.
	 */
	protected boolean useDefaultConnection() {
		return false;
	}

	/*
	 * This method is called from ModelFormEditorPart in case a
	 * PartitionChangeEvent is fired. <br> This implementation calls refresh on
	 * the <code>ManagedForm</code> owned by this pages in order to update every
	 * form that is stale. This method is package protected as clients will be
	 * informed via the registered form parts - @see {@link
	 * IManagedForm#addPart(org.eclipse.ui.forms.IFormPart)}
	 * 
	 * NOTE: In this version we do not use the stale and refresh handling - the
	 * relevant methods are either package protected or private, the listener in
	 * ModelEditor is deactivated - see ModelFormEditorPart for details.
	 */
	void refresh() {
		if (getManagedForm() != null) {
			getManagedForm().refresh();
		}
	}

	/**
	 * @return the connection that this editor may work with
	 */
	public Connection getWorkingConnection() {
		return getModelEditor().getWorkingConnection();
	}

	/**
	 * Returns
	 * 
	 * <pre>
	 * adapter
	 * {@link IModelEditor} : current ModelEditor
	 * {@link IPropertySheetPage} : newly created PropertySheetPage
	 * </pre>
	 * 
	 * @return the result object as specified
	 * @see IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (IModelEditor.class == adapter) {
			return getModelEditor();
		}

		return super.getAdapter(adapter);
	}

	@Override
	public void setFocus() {
		// if (partitionChanged) {
		// try {
		// // set new Input for nested editor pages
		// IManagedForm managedForm = getManagedForm();
		// if (managedForm != null) {
		// managedForm.setInput(getEditorInput());
		// }
		// }
		// finally {
		// partitionChanged = false;
		// }
		// }
		super.setFocus();
	}

	void setPartitionChanged(boolean changed) {
		partitionChanged = changed;
	}

	protected boolean isPartitionChanged() {
		return partitionChanged;
	}
}