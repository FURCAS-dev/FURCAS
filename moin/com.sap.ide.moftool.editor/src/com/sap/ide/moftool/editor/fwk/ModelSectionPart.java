package com.sap.ide.moftool.editor.fwk;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;

public abstract class ModelSectionPart extends SectionPart {

	protected ModelSectionPart(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm.getToolkit(), Section.TITLE_BAR
				| Section.EXPANDED | Section.TWISTIE);
		initialize(managedForm);
	}
	
	protected RefObject getRefObject(Object input) {
		RefObject refObject = null;
		if (input instanceof RefObject) {
			refObject = (RefObject) input;
		} else if (input instanceof ModelEditorInput) {
			refObject = (RefObject) ((ModelEditorInput) input).getRefObject();
		} else if (input instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) input;
			Object object = selection.getFirstElement();
			if (object instanceof ITreeNode) {
				ITreeNode<?> node = (ITreeNode<?>) object;
				object = node.getValue();
				if (object instanceof RefObject) {
					refObject = (RefObject) object;
				}
			}
		}
		return refObject;
	}

}
