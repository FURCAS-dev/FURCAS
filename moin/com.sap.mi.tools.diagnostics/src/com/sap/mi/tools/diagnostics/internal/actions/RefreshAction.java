package com.sap.mi.tools.diagnostics.internal.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.actions.ActionFactory;

import com.sap.mi.tools.diagnostics.internal.DiagnosticsPlugin;
import com.sap.mi.tools.diagnostics.internal.DiagnosticsUpdater;

/**
 * Refreshes the tree
 * 
 * @author d031150
 */
public class RefreshAction extends DiagnosticsViewerAction {
    
    RefreshAction(StructuredViewer viewer) {
    	super(null, viewer);
        setId(ActionFactory.REFRESH.getId());
        setActionDefinitionId("org.eclipse.ui.file.refresh"); //$NON-NLS-1$
        ImageDescriptor imgDesc = DiagnosticsPlugin.getImageDescriptorFromPlugin(DiagnosticsPlugin.IMAGE_NAME_REFRESH);
        setImageDescriptor(imgDesc);
    }
    
    @Override
    public void run() {
        new DiagnosticsUpdater(mViewer).doUpdate();
    }

	@Override
	public boolean isAvailable() {
		return true;
	}
}
