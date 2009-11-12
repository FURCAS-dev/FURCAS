package com.sap.ide.moftool.editor.gen.pkg.pages;

import com.sap.ide.moftool.editor.fwk.TableLayoutedModelFormPage;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;

import org.eclipse.ui.forms.widgets.TableWrapData;

public class PackageOverviewPage extends TableLayoutedModelFormPage {

	private static final String ID = "pkg.pages.packageOverview"; //$NON-NLS-1$

	public PackageOverviewPage(FormEditor editor, String title) {
		super(editor, ID, title);
	}

	@Override
	protected void createFormContentInternal(Composite body, IManagedForm managedForm) {

		com.sap.ide.moftool.editor.gen.sections.PackageSection packageSection = new com.sap.ide.moftool.editor.gen.sections.PackageSection(
				body, managedForm);
		packageSection.getSection().setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		managedForm.addPart(packageSection);
		packageSection.setFormInput(getEditorInput());

	}

}
