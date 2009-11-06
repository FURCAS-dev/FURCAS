package com.sap.mi.tools.diagnostics.internal.actions;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.diagnostics.internal.model.MoinNode;
import com.sap.mi.tools.diagnostics.internal.model.PartitionableNode;

/**
 * Shows the properties view for various nodes
 * 
 * @author d031150
 */
class ShowPropertiesAction extends DiagnosticsViewerAction {

    private static final Logger stracer = Logger.getLogger(MiLocations.MI_DIAGNOSTICS);
    
    ShowPropertiesAction(StructuredViewer viewer) {
        super("&Properties", viewer); //$NON-NLS-1$
        setActionDefinitionId(IWorkbenchActionDefinitionIds.PROPERTIES);
    }
    
    public void run() {
        try {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(IPageLayout.ID_PROP_SHEET);
        } 
        catch (PartInitException e) {
            stracer.log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    @Override
    protected boolean updateSelection(IStructuredSelection selection) {
    	if (!super.updateSelection(selection))
    		return false;
    	Object firstElement = selection.getFirstElement();
		if (!(firstElement instanceof MoinNode)
				&& !(firstElement instanceof PartitionableNode))
    		return false;
    	return true;
    }

	public boolean isAvailable() {
    	boolean available = updateSelection(getStructuredSelection());
		return available;
	}
}
