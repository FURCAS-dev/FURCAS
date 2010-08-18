/**
 * 
 */
package com.sap.ide.treeprovider.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import com.sap.ide.treeprovider.GenericRefObjectNode;


class DeleteElementAction extends Action {

    private ISelection mSelection = null;

    public DeleteElementAction() {
	super("Delete", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
	this.setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
		ISharedImages.IMG_TOOL_DELETE_DISABLED));
	this.setId(ActionFactory.DELETE.getId());
    }

    public final void setContext(ISelection sel) {
	mSelection = sel;
    }

    public void run() {
	ISelection lSelectedNodes = mSelection;
	final IStructuredSelection lStructuredSelection = (IStructuredSelection) lSelectedNodes;
	List<EObject> ldevobjs = toRefObjectList(lStructuredSelection);

	if (ldevobjs == null)
	    throw new IllegalStateException("Strange Input" + lSelectedNodes.toString());

	boolean lProceed = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getShell(),
		"Confirm deletion of development object", "Are you sure you want to delete selected object(s)?");

	ResourceSet connection = null;
	if (lProceed) {
	    for (EObject devobj : ldevobjs) {
		if (((EObject) devobj).is___Alive()) {
		    if (connection == null) {
			connection = devobj.get___Connection();
		    }
		    devobj.refDelete();
		}
	    }
	    try {
		if (connection != null) {
		    connection.save();
		}
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	}
    }

    @SuppressWarnings("unchecked")
    private List<EObject> toRefObjectList(IStructuredSelection selection) {
	List<EObject> result = new ArrayList<EObject>(selection.size());
	Iterator<Object> it = selection.iterator();
	while (it.hasNext()) {
	    Object o = it.next();
	    if (o instanceof GenericRefObjectNode) {
		result.add(((GenericRefObjectNode) o).getValue());
	    } else {
		return null;
	    }
	}
	return result;
    }

    public static IAction createActionForSelection(IStructuredSelection sel) {
	return createActionForSelection(sel, null);
    }

    @SuppressWarnings("unchecked")
    public static IAction createActionForSelection(IStructuredSelection sel, Class clazz) {
	if ((sel == null) || sel.isEmpty()) {
	    return null;
	}

	if ((clazz != null) && !clazz.isInstance(sel.getFirstElement())) {
	    return null;
	}
	DeleteElementAction lDeleteAction = new DeleteElementAction();
	lDeleteAction.setContext(sel);
	lDeleteAction.setEnabled(true);
	return lDeleteAction;
    }
}