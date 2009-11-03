package com.sap.mi.tools.diagnostics.internal;

import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.mi.tools.diagnostics.internal.model.ConnectionNode;

/**
 * Link helper for diagnostic view
 * 
 * @author d031150
 */
public class DiagnosticsLinkHelper implements ILinkHelper {

    /**
     * @see org.eclipse.ui.navigator.ILinkHelper#activateEditor(IWorkbenchPage, IStructuredSelection)
     */
    public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
        Object element = aSelection.getFirstElement();
        if (element instanceof ConnectionNode) {
        	ConnectionNode connectionNode = ((ConnectionNode) element);
            Set<IModelEditor> editors = ModelManagerUI.getEditorManager().getAllActiveModelEditors();
            for (IModelEditor editor : editors) {
				if (connectionNode.getId().equals(editor.getConnection().getId())) {
                    IEditorPart part = ModelManagerUI.getEditorManager().findEditorPart(editor);
                    if (part != null)
                        aPage.bringToTop(part);
                    break;
                }
            }
        }
    }

    /**
     * @see org.eclipse.ui.navigator.ILinkHelper#findSelection(IEditorInput)
     */
    public IStructuredSelection findSelection(IEditorInput anInput) {
//        if (anInput instanceof ModelEditorInput) {
//            ModelEditorInput input = (ModelEditorInput) anInput;
//            Connection connection = (Connection) input.getAdapter(Connection.class);
//            if (connection != null) {
//                ConnectionNode node = new ConnectionNode(connection);
//                return new StructuredSelection(node);
//            }
//        }
        return StructuredSelection.EMPTY;
    }

}
