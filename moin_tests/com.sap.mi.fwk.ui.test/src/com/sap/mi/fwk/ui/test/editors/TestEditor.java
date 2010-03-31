package com.sap.mi.fwk.ui.test.editors;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.editor.IDecoratingModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorPart;

/**
 * A rudimentary editor for testing purposes
 * 
 * @author d031150
 */
public final class TestEditor extends ModelEditorPart implements IDecoratingModelEditor {

	public static final String ID = "com.sap.mi.fwk.ui.test.TestEditor"; //$NON-NLS-1$

	public static TestEditor open(View view) throws PartInitException {
		TestEditor editor = (TestEditor) TestUtil.openModelEditor(view, ID);
		return editor;
	}

	private volatile boolean decoState;
	private FormToolkit formToolkit;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorPart#useDeferredInitialization()
	 */
	@Override
	protected boolean useDeferredInitialization() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorPart#initDeferred(org.eclipse.ui.IEditorSite,
	 *      org.eclipse.ui.IEditorInput)
	 */
	@Override
	protected void initDeferred(IEditorSite site, IEditorInput input) {
		super.initDeferred(site, input);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorPart#createPartControlDeferred(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createPartControlDeferred(Composite parent) {
		formToolkit = new FormToolkit(parent.getDisplay());
		formToolkit.adapt(parent);
		formToolkit.createLabel(parent, "To be used for test purposes only");
	}

	@Override
	public void dispose() {
		if (formToolkit != null) {
			formToolkit.dispose();
		}
		super.dispose();
	}

	@Override
	public void setFocus() {
	}

	@Override
	public ModelEditor getModelEditor() {
		return super.getModelEditor();
	}

	public void decoratorStateChanged(boolean newState) {
		decoState = newState;
	}

	public boolean getDecoState() {
		return decoState;
	}
}
