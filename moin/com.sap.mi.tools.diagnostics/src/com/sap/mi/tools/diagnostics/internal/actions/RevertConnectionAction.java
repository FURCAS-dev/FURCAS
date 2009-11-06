package com.sap.mi.tools.diagnostics.internal.actions;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.diagnostics.internal.model.ConnectionNode;

/**
 * Reverts a connection
 * 
 * @author d031150
 */
public class RevertConnectionAction extends DiagnosticsViewerAction {
    
	private static final Logger stracer = Logger.getLogger(MiLocations.MI_DIAGNOSTICS);
	
    private final Shell mShell;

    RevertConnectionAction(Shell shell, StructuredViewer viewer) {
        super("Revert", viewer); //$NON-NLS-1$
        setId(ActionFactory.REVERT.getId());
        setActionDefinitionId(IWorkbenchActionDefinitionIds.REVERT);
        mShell = shell;
    }
    
    @Override
    protected boolean updateSelection(IStructuredSelection structuredSelection) {
        if (!structuredSelection.isEmpty()) {
            Object firstElement = structuredSelection.getFirstElement();
            if (firstElement instanceof ConnectionNode) {
            	ConnectionNode connectionNode = ((ConnectionNode) firstElement);
				try {
					if (!connectionNode.isAlive())
						return false;
					boolean isDirty = connectionNode.isDirty();
					return isDirty;
				} catch (IOException e) {
					stracer.log(Level.SEVERE, e.getMessage(), e);
					return false;
				}
            }
        }
        return false;
    }

    public boolean isAvailable() {
    	IStructuredSelection selection = getStructuredSelection();
        if (!selection.isEmpty()) {
            Object firstElement = selection.getFirstElement();
            if (firstElement instanceof ConnectionNode) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
    	IStructuredSelection selection = getStructuredSelection();
    	Object firstElement = selection.getFirstElement();
        if (firstElement instanceof ConnectionNode) {
            ConnectionNode connectionNode = (ConnectionNode) firstElement;
            try {
            	connectionNode.revert();
            } 
            catch (IOException e) {
                ErrorDialog.openError(
                    mShell, 
                    "Error on Revert",  //$NON-NLS-1$
                    e.getMessage(), 
                    null);
            }
        }
        
        mViewer.refresh();
    }

}
