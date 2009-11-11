package com.sap.ide.moftool.editor.gen.cls;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassOverviewPage;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassAttributesPage;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassReferencesPage;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassOperationsPage;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassExceptionsPage;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassConstraintsPage;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassConstantsPage;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassTagsPage;

import com.sap.ide.moftool.editor.gen.cls.pages.ClassInnerDataTypesPage;

public class ClassEditor extends com.sap.ide.moftool.editor.fwk.AbstractDeferredInitializedEditor {

	@Override
	protected void addPagesDeferred() {
		try {

			createOverviewPage();

			createAttributesPage();

			createReferencesPage();

			createOperationsPage();

			createExceptionsPage();

			createConstraintsPage();

			createConstantsPage();

			createTagsPage();

			createInnerDataTypesPage();

		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), Messages.ClassEditor_ErrorCreatingPage, null, e.getStatus());
			MOFToolEditorPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	private void createOverviewPage() throws PartInitException {
		ClassOverviewPage page = new ClassOverviewPage(this, Messages.ClassEditor_Overview);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_Overview);
	}

	private void createAttributesPage() throws PartInitException {
		ClassAttributesPage page = new ClassAttributesPage(this, Messages.ClassEditor_Attributes);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_Attributes);
	}

	private void createReferencesPage() throws PartInitException {
		ClassReferencesPage page = new ClassReferencesPage(this, Messages.ClassEditor_References);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_References);
	}

	private void createOperationsPage() throws PartInitException {
		ClassOperationsPage page = new ClassOperationsPage(this, Messages.ClassEditor_Operations);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_Operations);
	}

	private void createExceptionsPage() throws PartInitException {
		ClassExceptionsPage page = new ClassExceptionsPage(this, Messages.ClassEditor_Exceptions);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_Exceptions);
	}

	private void createConstraintsPage() throws PartInitException {
		ClassConstraintsPage page = new ClassConstraintsPage(this, Messages.ClassEditor_Constraints);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_Constraints);
	}

	private void createConstantsPage() throws PartInitException {
		ClassConstantsPage page = new ClassConstantsPage(this, Messages.ClassEditor_Constants);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_Constants);
	}

	private void createTagsPage() throws PartInitException {
		ClassTagsPage page = new ClassTagsPage(this, Messages.ClassEditor_Tags);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_Tags);
	}

	private void createInnerDataTypesPage() throws PartInitException {
		ClassInnerDataTypesPage page = new ClassInnerDataTypesPage(this, Messages.ClassEditor_InnerDataTypes);
		int index = addPage(page);
		setPageText(index, Messages.ClassEditor_InnerDataTypes);
	}

}
