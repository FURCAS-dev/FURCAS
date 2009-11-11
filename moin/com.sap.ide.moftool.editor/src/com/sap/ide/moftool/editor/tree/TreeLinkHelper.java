package com.sap.ide.moftool.editor.tree;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfClasses;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;

public class TreeLinkHelper implements ILinkHelper {

	public void activateEditor(IWorkbenchPage page, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	public IStructuredSelection findSelection(IEditorInput editorInput) {		
		if (editorInput instanceof ModelEditorInput) {
			if (editorInput.exists()) {
				ModelEditorInput modelEditorInput = (ModelEditorInput) editorInput;
				RefBaseObject modelElement = (RefBaseObject) modelEditorInput.getRefObject();
				if (modelElement instanceof MofClass) {
					NodeCnfClasses node = new NodeCnfClasses((MofClass) modelElement);
					return new StructuredSelection(node);
//				} else if (modelElement instanceof SimpleComponent) {
//					NodeComponent node = new NodeComponent((SimpleComponent) modelElement);
//					return new StructuredSelection(node);
				}
			}
		}		
		return null;
	}

}
