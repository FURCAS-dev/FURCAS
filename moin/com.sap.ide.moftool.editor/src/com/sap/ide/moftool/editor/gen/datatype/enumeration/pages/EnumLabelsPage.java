package com.sap.ide.moftool.editor.gen.datatype.enumeration.pages;

import com.sap.ide.moftool.editor.fwk.TableLayoutedModelFormPage;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;

import org.eclipse.ui.forms.widgets.TableWrapData;

public class EnumLabelsPage extends TableLayoutedModelFormPage {

	private static final String ID = "datatype.enumeration.pages.enumLabels"; //$NON-NLS-1$

	public EnumLabelsPage(FormEditor editor, String title) {
		super(editor, ID, title);
	}

	@Override
	protected void createFormContentInternal(Composite body, IManagedForm managedForm) {

		com.sap.ide.moftool.editor.gen.sections.EnumLabelSection enumLabelSection = new com.sap.ide.moftool.editor.gen.sections.EnumLabelSection(
				body, managedForm);
		enumLabelSection.getSection().setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		managedForm.addPart(enumLabelSection);
		enumLabelSection.setFormInput(getEditorInput());

	}

}
