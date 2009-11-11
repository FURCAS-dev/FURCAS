package com.sap.ide.moftool.editor.gen.datatype.structuretype;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

import com.sap.ide.moftool.editor.gen.datatype.pages.DatatypeOverviewPage;

import com.sap.ide.moftool.editor.gen.datatype.structuretype.pages.StructureFieldPage;

import com.sap.ide.moftool.editor.gen.datatype.pages.StructureTypeConstraintsPage;

import com.sap.ide.moftool.editor.gen.datatype.pages.StructureTypeTagsPage;

public class StructureTypeEditor extends com.sap.ide.moftool.editor.fwk.AbstractDeferredInitializedEditor {

	@Override
	protected void addPagesDeferred() {
		try {

			createOverviewPage();

			createFieldsPage();

			createConstraintsPage();

			createTagsPage();

		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), Messages.StructureTypeEditor_ErrorCreatingPage, null, e
					.getStatus());
			MOFToolEditorPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	private void createOverviewPage() throws PartInitException {
		DatatypeOverviewPage page = new DatatypeOverviewPage(this, Messages.StructureTypeEditor_Overview);
		int index = addPage(page);
		setPageText(index, Messages.StructureTypeEditor_Overview);
	}

	private void createFieldsPage() throws PartInitException {
		StructureFieldPage page = new StructureFieldPage(this, Messages.StructureTypeEditor_Fields);
		int index = addPage(page);
		setPageText(index, Messages.StructureTypeEditor_Fields);
	}

	private void createConstraintsPage() throws PartInitException {
		StructureTypeConstraintsPage page = new StructureTypeConstraintsPage(this,
				Messages.StructureTypeEditor_Constraints);
		int index = addPage(page);
		setPageText(index, Messages.StructureTypeEditor_Constraints);
	}

	private void createTagsPage() throws PartInitException {
		StructureTypeTagsPage page = new StructureTypeTagsPage(this, Messages.StructureTypeEditor_Tags);
		int index = addPage(page);
		setPageText(index, Messages.StructureTypeEditor_Tags);
	}

}
