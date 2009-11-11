package com.sap.ide.moftool.editor.fwk;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.sap.mi.fwk.ui.editor.ModelFormPage;

public abstract class TableLayoutedModelFormPage extends ModelFormPage {
	
	public TableLayoutedModelFormPage(FormEditor editor, String id, String title ) {
		super(editor, id, title);
	}
	
	@Override
	public void createFormContent(IManagedForm managedForm) {
		Composite body = managedForm.getForm().getBody();
		TableWrapLayout tableWrapLayout = new TableWrapLayout();
		tableWrapLayout.leftMargin = 10;
		body.setLayout(tableWrapLayout);
		TableWrapData tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.colspan = 1;
		body.setLayoutData(tableWrapData);

		managedForm.getForm().setText(getTitle());

		createFormContentInternal(body, managedForm);
	}

	protected abstract void createFormContentInternal(Composite body, IManagedForm managedForm);


}
