package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;



public abstract class AbstractMoveAction<T extends RefObject> implements IObjectActionDelegate {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_MOFTOOLSET);

	private ISelection selection;
	private IWorkbenchPart targetPart;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	@SuppressWarnings("unchecked")
	public void run(IAction action) {
		try {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection sel = (IStructuredSelection) selection;
				if (sel.getFirstElement() instanceof ITreeNode) {
					ITreeNode<T> tn = (ITreeNode<T>) sel.getFirstElement();

					Connection con = (Connection) tn.getAdapter(Connection.class);

					FilteredItemsSelectionDialog spd = getSelectionDialog(targetPart.getSite().getShell(), tn
							.getValue(), con);
					if (spd.open() == Dialog.OK) {
						Object firstResult = spd.getFirstResult();
						MofPackage target = (MofPackage) firstResult;
						if (target != null) {
							Command mcc = createCommand(tn.getValue(), target, con);
							mcc.execute();
							con.save();
						}
					}
				}
			}
		} catch (Exception e) {
			sTracer.log(Level.SEVERE, e.getMessage(), e);
		}

	}
	


	protected abstract FilteredItemsSelectionDialog getSelectionDialog(Shell shell, T value, Connection con);

	protected abstract Command createCommand(T value, MofPackage target, Connection con);

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;		
		// <pg101208> disable move action for foreign (readonly) objects
		boolean foreign = false;
		if (this.selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			Object object = treeSelection.getFirstElement();
			if (object instanceof TreeNode) {
				TreeNode<?> treeNode = (TreeNode<?>) object;
				Object value = treeNode.getValue();
				if (value instanceof RefBaseObject) {
					RefBaseObject refBaseObject = (RefBaseObject) value;
					if (ModelElementService.isForeignObject(refBaseObject)) {
						foreign = true;
					}
				}
			}
		}
		action.setEnabled(targetPart != null && !foreign);
	}

}
