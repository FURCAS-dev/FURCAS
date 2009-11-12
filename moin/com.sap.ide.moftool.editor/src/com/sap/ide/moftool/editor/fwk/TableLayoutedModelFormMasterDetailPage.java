package com.sap.ide.moftool.editor.fwk;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;

public abstract class TableLayoutedModelFormMasterDetailPage extends TableLayoutedModelFormPage {

	private ModelMasterDetailBlock part;

	public TableLayoutedModelFormMasterDetailPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}
	
	@Override
	protected final void createFormContentInternal(Composite body, IManagedForm managedForm) {
		part = createMasterBlockInternal(body, managedForm);
	}
	
	protected abstract ModelMasterDetailBlock createMasterBlockInternal(Composite body, IManagedForm managedForm);

	public TreeViewer test___getTreeViewer(){
		if (part.test___getMasterPart() instanceof TreeSection) {
			TreeSection ts = (TreeSection) part.test___getMasterPart();
			return ts.test___getTreeViewer();
		}
		return null;
	}

	
	
}
