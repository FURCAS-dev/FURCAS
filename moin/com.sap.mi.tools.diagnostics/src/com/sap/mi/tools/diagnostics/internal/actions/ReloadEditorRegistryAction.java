package com.sap.mi.tools.diagnostics.internal.actions;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;

import com.sap.mi.tools.diagnostics.internal.DiagnosticsUpdater;
import com.sap.mi.tools.diagnostics.internal.model.EditorRegistryNode;

/**
 * Reloads the editor registry
 * 
 * @author d031150
 */
public class ReloadEditorRegistryAction extends DiagnosticsViewerAction {

	ReloadEditorRegistryAction(StructuredViewer viewer) {
		super("Reload", viewer); //$NON-NLS-1$
	}

	public boolean isAvailable() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.getFirstElement() instanceof EditorRegistryNode) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		if (!super.updateSelection(selection))
			return false;
		return isAvailable();
	}

	@Override
	public void run() {
		Object firstElement = getStructuredSelection().getFirstElement();
		if (firstElement instanceof EditorRegistryNode) {
			((EditorRegistryNode) firstElement).reload();
	        new DiagnosticsUpdater(mViewer).doUpdate();
		}
	}
}