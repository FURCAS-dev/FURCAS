package com.sap.ide.moftool.editor.fwk;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

import com.sap.ide.moftool.editor.core.ocl.OclConstraintActivator;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.editor.ModelFormEditorPart;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;

public abstract class AbstractDeferredInitializedEditor extends
		ModelFormEditorPart {

	/**
	 * @modified
	 */
	private OclConstraintActivator mConstraintActivator = null;

	/**
	 * @modified
	 */
	@Override
	protected boolean useDeferredInitialization() {
		return true;
	}

	/**
	 * @modified
	 */
	@Override
	protected void initDeferred(IEditorSite site, IEditorInput input) {
		super.initDeferred(site, input);

		String partName = ""; //$NON-NLS-1$
		if (input != null) {
			RefBaseObject refBaseObject = ModelAdapterUI.getInstance()
					.getRefBaseObject(input);
			partName = MOFToolEditorPlugin.getDefault().getLabelProvider()
					.getText(refBaseObject);
		}
		setPartName(partName);

		// Register constraint activator as listener to constraint changes
		mConstraintActivator = new OclConstraintActivator(getModelEditor()
				.getConnection());
		EventFilter eventFilter = new ClassFilter(mConstraintActivator
				.getOclConstraintRefClass(), false);
		getModelEditor().getConnection().getEventRegistry().registerListener(
				mConstraintActivator, eventFilter);
	}

	/**
	 * @modified
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		// OCL activation
		mConstraintActivator.activate();

		// Finally do the standard saving
		super.doSave(monitor);
	}

}
