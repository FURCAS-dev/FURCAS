package com.sap.ide.moftool.editor.fwk;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

public abstract class ModelDetailsPageProvider implements IDetailsPageProvider {

	private final IManagedForm managedForm;

	public ModelDetailsPageProvider(IManagedForm managedForm) {
		this.managedForm = managedForm;
	}

	public Object getPageKey(Object object) {
		RefObject refObject = null;
		if (object instanceof ITreeNodeRefObject) {
			ITreeNode<?> node = (ITreeNode<?>) object;
			refObject = (RefObject) node.getValue();
		} else if (object instanceof RefObject) {
			refObject = (RefObject) object;

		} else if (object instanceof ModelEditorInput) {
			refObject = (RefObject) ((ModelEditorInput) object)
					.getRefObject();
		}
		
		return getPageKeyInternal(refObject);
	}

	protected abstract Object getPageKeyInternal(RefObject refObject);
	
	public IManagedForm getManagedForm() {
		return managedForm;
	}

}
