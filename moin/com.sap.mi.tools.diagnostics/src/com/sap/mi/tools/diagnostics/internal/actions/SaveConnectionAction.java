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
 * Saves a connection
 * 
 * @author d031150
 */
public class SaveConnectionAction extends DiagnosticsViewerAction {
    
	private static final Logger stracer = Logger.getLogger(MiLocations.MI_DIAGNOSTICS);
	
    private final Shell mShell;

    SaveConnectionAction(Shell shell, StructuredViewer viewer) {
        super("Save", viewer); //$NON-NLS-1$
        setId(ActionFactory.SAVE.getId());
        setActionDefinitionId(IWorkbenchActionDefinitionIds.SAVE);
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
					if (isDirty && connectionNode.getNumberOfElementsInNullPartition() == 0)
						return true;
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
                connectionNode.save();
            } 
            catch (IOException e) {
                ErrorDialog.openError(
                    mShell, 
                    "Error on Save",  //$NON-NLS-1$
                    e.getMessage(), 
                    null);
            }
        }
        
        mViewer.refresh();
    }

}
