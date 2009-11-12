package com.sap.ide.moftool.editor.gen.datatype.enumeration;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

import com.sap.ide.moftool.editor.gen.datatype.pages.DatatypeOverviewPage;

import com.sap.ide.moftool.editor.gen.datatype.enumeration.pages.EnumLabelsPage;

import com.sap.ide.moftool.editor.gen.datatype.pages.EnumTypeConstraintsPage;

import com.sap.ide.moftool.editor.gen.datatype.pages.EnumTypeTagsPage;

public class EnumEditor extends com.sap.ide.moftool.editor.fwk.AbstractDeferredInitializedEditor {

	@Override
	protected void addPagesDeferred() {
		try {

			createOverviewPage();

			createLabelsPage();

			createConstraintsPage();

			createTagsPage();

		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), Messages.EnumEditor_ErrorCreatingPage, null, e.getStatus());
			MOFToolEditorPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	private void createOverviewPage() throws PartInitException {
		DatatypeOverviewPage page = new DatatypeOverviewPage(this, Messages.EnumEditor_Overview);
		int index = addPage(page);
		setPageText(index, Messages.EnumEditor_Overview);
	}

	private void createLabelsPage() throws PartInitException {
		EnumLabelsPage page = new EnumLabelsPage(this, Messages.EnumEditor_Labels);
		int index = addPage(page);
		setPageText(index, Messages.EnumEditor_Labels);
	}

	private void createConstraintsPage() throws PartInitException {
		EnumTypeConstraintsPage page = new EnumTypeConstraintsPage(this, Messages.EnumEditor_Constraints);
		int index = addPage(page);
		setPageText(index, Messages.EnumEditor_Constraints);
	}

	private void createTagsPage() throws PartInitException {
		EnumTypeTagsPage page = new EnumTypeTagsPage(this, Messages.EnumEditor_Tags);
		int index = addPage(page);
		setPageText(index, Messages.EnumEditor_Tags);
	}

}
