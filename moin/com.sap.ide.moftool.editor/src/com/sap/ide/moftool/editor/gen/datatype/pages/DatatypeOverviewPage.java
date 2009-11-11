package com.sap.ide.moftool.editor.gen.datatype.pages;

import com.sap.ide.moftool.editor.fwk.TableLayoutedModelFormPage;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;

import org.eclipse.ui.forms.widgets.TableWrapData;

public class DatatypeOverviewPage extends TableLayoutedModelFormPage {

	private static final String ID = "datatype.pages.datatypeOverview"; //$NON-NLS-1$

	public DatatypeOverviewPage(FormEditor editor, String title) {
		super(editor, ID, title);
	}

	@Override
	protected void createFormContentInternal(Composite body, IManagedForm managedForm) {

		com.sap.ide.moftool.editor.gen.sections.DataTypesSection dataTypesSection = new com.sap.ide.moftool.editor.gen.sections.DataTypesSection(
				body, managedForm);
		dataTypesSection.getSection().setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		managedForm.addPart(dataTypesSection);
		dataTypesSection.setFormInput(getEditorInput());

	}

}
