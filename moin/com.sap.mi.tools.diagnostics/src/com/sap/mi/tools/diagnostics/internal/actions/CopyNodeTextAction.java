package com.sap.mi.tools.diagnostics.internal.actions;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

import com.sap.mi.tools.diagnostics.internal.model.PartitionNode;

/**
 * Copies the current node's text to the clipboard
 * 
 * @author d031150
 */
public class CopyNodeTextAction extends DiagnosticsViewerAction {
    
    CopyNodeTextAction(StructuredViewer viewer) {
    	super("Copy", viewer); //$NON-NLS-1$
        setId(ActionFactory.COPY.getId());
        setActionDefinitionId(IWorkbenchActionDefinitionIds.COPY);
    }
    
    public boolean isAvailable() {
    	IStructuredSelection selection = getStructuredSelection();
    	if (!(selection.getFirstElement() instanceof PartitionNode))
    		return false;
    	return true;
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
    	String text = ((ILabelProvider) mViewer.getLabelProvider()).getText(firstElement);
    	if (text != null && text.length() > 0) {
    		Clipboard clipboard = new Clipboard(mViewer.getControl().getDisplay());
    		try {
    			clipboard.setContents(
    					new Object[] { text }, 
    					new Transfer[] { TextTransfer.getInstance() });
    		}
    		finally {
    			clipboard.dispose();
    		}
    	}
    }
}
