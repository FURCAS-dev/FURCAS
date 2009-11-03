package com.sap.mi.fwk.ui.tree.dnd;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.internal.dnd.DNDHelper;
import com.sap.mi.fwk.ui.internal.dnd.DefaultTreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler.TransferOperationEnum;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;

/**
 * PROVISIONAL This API is subject to arbitrary change, including renaming or
 * removal.
 * <p>
 * 
 * @author d024127
 * 
 */
public class TreeNodeDropListener implements DropTargetListener {

	private int operation;

	public void dragOver(DropTargetEvent event) {
		Widget w = event.item;
		if (w != null && !w.isDisposed()) {
			Object target = event.item.getData();
			if (target instanceof ITreeNode<?>) {
				if (dragOver((ITreeNode<?>) target)) {
					event.detail = this.operation;
					return;
				}
			}
		}
		event.detail = DND.DROP_NONE;
	}

	private boolean dragOver(ITreeNode<?> target) {
		ITreeNodeTransferHandler handler = (ITreeNodeTransferHandler) target.getAdapter(ITreeNodeTransferHandler.class);
		if (handler != null) {
			ISelection sel = LocalSelectionTransfer.getTransfer().getSelection();
			if (sel instanceof IStructuredSelection) {
				Connection con = getConnection(target);
				if (con == null) {
					return false;
				}
				TransferOperationEnum op = DNDHelper.getOperation(this.operation);
				ITreeNodeTransfer tnt = new DefaultTreeNodeTransfer((IStructuredSelection) sel, op);
				return handler.isTransferAllowed(handler, tnt);
			}
		}
		return false;
	}

	public void drop(DropTargetEvent event) {
		Widget w = event.item;
		if (w != null && !w.isDisposed()) {
			Object target = event.item.getData();
			if (target instanceof ITreeNode<?>) {
				if (drop((ITreeNode<?>) target)) {
					event.detail = this.operation;
					return;
				}
			}
		}
		event.detail = DND.DROP_NONE;
	}

	private boolean drop(ITreeNode<?> target) {
		ITreeNodeTransferHandler handler = (ITreeNodeTransferHandler) target.getAdapter(ITreeNodeTransferHandler.class);
		if (handler != null) {
			ISelection sel = LocalSelectionTransfer.getTransfer().getSelection();
			if (sel instanceof IStructuredSelection) {
				Connection con = getConnection(target);
				if (con == null) {
					return false;
				}
				TransferOperationEnum op = DNDHelper.getOperation(this.operation);
				ITreeNodeTransfer tnt = new DefaultTreeNodeTransfer((IStructuredSelection) sel, op);
				return handler.handleTransfer(handler, tnt);
			}
		}
		return false;
	}

	private Connection getConnection(ITreeNode<?> treeNode) {
		Connection con = (Connection) treeNode.getAdapter(Connection.class);
		if (con == null) {
			IProject project = DNDHelper.getProject(treeNode);
			if (project == null) {
				return null;
			}

			IRunnableWithConnection runnable = new IRunnableWithConnection() {
				public void run(Connection connection, IProgressMonitor monitor) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
						}
					});
				}
			};
			con = ConnectionManagerUI.getInstance().getOrCreateDefaultConnectionAsync(project, runnable);
		}
		return con;
	}

	public void dragOperationChanged(DropTargetEvent event) {
		this.operation = event.operations;
	}

	public void dragEnter(DropTargetEvent event) {
	}

	public void dragLeave(DropTargetEvent event) {
	}

	public void dropAccept(DropTargetEvent event) {
	}
}