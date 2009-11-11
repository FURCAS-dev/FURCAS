package com.sap.ide.moftool.editor.gen.pkg;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

import com.sap.ide.moftool.editor.gen.pkg.pages.PackageOverviewPage;

import com.sap.ide.moftool.editor.gen.pkg.pages.PackageAssociationsPage;

import com.sap.ide.moftool.editor.gen.pkg.pages.PackageConstraintsPage;

import com.sap.ide.moftool.editor.gen.pkg.pages.PackageImportsPage;

import com.sap.ide.moftool.editor.gen.pkg.pages.PackageTagsPage;

import com.sap.ide.moftool.editor.gen.pkg.pages.PackageConstantsPage;

public class PackageEditor extends com.sap.ide.moftool.editor.fwk.AbstractDeferredInitializedEditor {

	@Override
	protected void addPagesDeferred() {
		try {

			createOverviewPage();

			createAssociationsPage();

			createConstraintsPage();

			createImportsPage();

			createTagsPage();

			createConstantsPage();

		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), Messages.PackageEditor_ErrorCreatingPage, null, e.getStatus());
			MOFToolEditorPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	private void createOverviewPage() throws PartInitException {
		PackageOverviewPage page = new PackageOverviewPage(this, Messages.PackageEditor_Overview);
		int index = addPage(page);
		setPageText(index, Messages.PackageEditor_Overview);
	}

	private void createAssociationsPage() throws PartInitException {
		PackageAssociationsPage page = new PackageAssociationsPage(this, Messages.PackageEditor_Associations);
		int index = addPage(page);
		setPageText(index, Messages.PackageEditor_Associations);
	}

	private void createConstraintsPage() throws PartInitException {
		PackageConstraintsPage page = new PackageConstraintsPage(this, Messages.PackageEditor_Constraints);
		int index = addPage(page);
		setPageText(index, Messages.PackageEditor_Constraints);
	}

	private void createImportsPage() throws PartInitException {
		PackageImportsPage page = new PackageImportsPage(this, Messages.PackageEditor_Imports);
		int index = addPage(page);
		setPageText(index, Messages.PackageEditor_Imports);
	}

	private void createTagsPage() throws PartInitException {
		PackageTagsPage page = new PackageTagsPage(this, Messages.PackageEditor_Tags);
		int index = addPage(page);
		setPageText(index, Messages.PackageEditor_Tags);
	}

	private void createConstantsPage() throws PartInitException {
		PackageConstantsPage page = new PackageConstantsPage(this, Messages.PackageEditor_Constants);
		int index = addPage(page);
		setPageText(index, Messages.PackageEditor_Constants);
	}

}
