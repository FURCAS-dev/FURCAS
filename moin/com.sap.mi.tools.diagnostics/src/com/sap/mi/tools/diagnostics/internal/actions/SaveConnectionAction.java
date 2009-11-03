package com.sap.mi.tools.diagnostics.internal.actions;

import java.io.IOException;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.diagnostics.internal.model.ConnectionNode;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Saves a connection
 * 
 * @author d031150
 */
public class SaveConnectionAction extends DiagnosticsViewerAction {
    
	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_DIAGNOSTICS);
	
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
					sTracer.error(e.getMessage(), e);
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
                ExtendedMessageDialog.showError(
                    mShell, 
                    "Error on Save",  //$NON-NLS-1$
                    e.getMessage(), 
                    null, 
                    new String[] {IDialogConstants.OK_LABEL}, 
                    e);
            }
        }
        
        mViewer.refresh();
    }

}
