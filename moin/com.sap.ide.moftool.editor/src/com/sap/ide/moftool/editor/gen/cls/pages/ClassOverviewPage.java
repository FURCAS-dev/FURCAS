package com.sap.ide.moftool.editor.gen.cls.pages;

import com.sap.ide.moftool.editor.fwk.TableLayoutedModelFormPage;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;

import org.eclipse.ui.forms.widgets.TableWrapData;

public class ClassOverviewPage extends TableLayoutedModelFormPage {

	private static final String ID = "cls.pages.classOverview"; //$NON-NLS-1$

	public ClassOverviewPage(FormEditor editor, String title) {
		super(editor, ID, title);
	}

	@Override
	protected void createFormContentInternal(Composite body, IManagedForm managedForm) {

		com.sap.ide.moftool.editor.gen.sections.ClassSection classSection = new com.sap.ide.moftool.editor.gen.sections.ClassSection(
				body, managedForm);
		classSection.getSection().setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		managedForm.addPart(classSection);
		classSection.setFormInput(getEditorInput());

		com.sap.ide.moftool.editor.gen.sections.ClassSupertypesSection classSupertypesSection = new com.sap.ide.moftool.editor.gen.sections.ClassSupertypesSection(
				body, managedForm);
		classSupertypesSection.getSection().setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		managedForm.addPart(classSupertypesSection);
		classSupertypesSection.setFormInput(getEditorInput());

	}

}
