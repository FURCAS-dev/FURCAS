package com.sap.mi.fwk.ui.tree.dnd;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.dnd.DefaultModelTransferTarget;
import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.mi.fwk.ui.internal.dnd.DNDHelper;
import com.sap.mi.fwk.ui.internal.dnd.DefaultTreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler.TransferOperationEnum;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * PROVISIONAL This API is subject to arbitrary change, including renaming or
 * removal.
 * <p>
 * This class offers basic support for drag/drop scenarios. It has to registered
 * as DropAssistant in the common navigator extension point.
 * 
 * <pre>
 * 	&lt;dropAssistant class=&quot;com.sap.mi.fwk.ui.tree.dnd.TreeNodeNavigatorDropAssistant&quot;
 * 	id=&quot;com.sap.demo.sample.components.TreeNodeDropAssistant&quot;&gt;
 * 	&lt;possibleDropTargets&gt;
 * </pre>
 * 
 * When active drop operations are delegated to {@link ITreeNodeTransferHandler}
 * objects or handled by the {@link ModelClipboard}
 * 
 * @author d024127
 * @see ModelClipboard
 * 
 */
public class TreeNodeNavigatorDropAssistant extends CommonDropAdapterAssistant {

	// cache object
	private transient DefaultTreeNodeTransfer transfer;

	public IStatus handleDrop(CommonDropAdapter dropAdapter, DropTargetEvent dropTargetEvent, Object target) {
		if (dropTargetEvent.widget == null || dropTargetEvent.widget.isDisposed()) {
			return Status.CANCEL_STATUS;
		}

		int currentOperation = dropAdapter.getCurrentOperation();
		IStructuredSelection strSel = ModelAdapter.getInstance().adaptObject(dropTargetEvent.data, IStructuredSelection.class);
		return handleDrop(strSel, currentOperation, target);
	}

	private IStatus handleDrop(IStructuredSelection strSel, int currentOperation, Object target) {
		if (strSel != null) {
			Object[] objects = strSel.toArray();
			ITreeNodeTransferHandler dtn = ModelAdapter.getInstance().adaptObject(target, ITreeNodeTransferHandler.class);
			if (dtn != null) {
				TransferOperationEnum operation = DNDHelper.getOperation(currentOperation);
				DefaultTreeNodeTransfer tnt = new DefaultTreeNodeTransfer(strSel, operation);
				if (!(tnt.equals(this.transfer))) {
					this.transfer = tnt;
				} else {
					// objects are the same but op might have changed
					this.transfer.setOperation(operation);
				}
				return (dtn.handleTransfer(dtn, this.transfer) ? Status.OK_STATUS : Status.CANCEL_STATUS);
			}

			RefBaseObject targetRefObj = ModelAdapterUI.getInstance().getRefBaseObject(target);
			if (targetRefObj != null) {
				Set<RefBaseObject> refObjs = new HashSet<RefBaseObject>();
				for (Object obj : objects) {
					RefBaseObject rbo = ModelAdapterUI.getInstance().getRefBaseObject(obj);
					if (rbo != null) {
						refObjs.add(rbo);
					}
				}
				DefaultModelTransferTarget dmth = new DefaultModelTransferTarget();
				try {
					dmth.handleTransfer(target, refObjs.toArray(new RefBaseObject[refObjs.size()]), null);
				} catch (OperationCanceledException e) {
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
		}
		return Status.CANCEL_STATUS;
	}

	private IStatus validateDrop(IStructuredSelection strSel, int operation, Object target) {
		if (strSel != null) {
			if (target instanceof ITreeNode<?>) {
				ITreeNode<?> treeNode = (ITreeNode<?>) target;
				ITreeNodeTransferHandler dtn = ModelAdapter.getInstance().adaptObject(target, ITreeNodeTransferHandler.class);
				if (dtn != null) {
					// ensure target connection exists
					Connection con = getConnection(treeNode);
					if (con == null) {
						return Status.CANCEL_STATUS;
					}
					TransferOperationEnum op = DNDHelper.getOperation(operation);
					DefaultTreeNodeTransfer tnt = new DefaultTreeNodeTransfer(strSel, op);
					if (!(tnt.equals(this.transfer))) {
						this.transfer = tnt;
					} else {
						this.transfer.setOperation(op);
					}
					boolean result = dtn.isTransferAllowed(dtn, this.transfer);
					return (result ? Status.OK_STATUS : Status.CANCEL_STATUS);
				}
			}

			RefBaseObject refObj = ModelAdapterUI.getInstance().getRefBaseObject(target);
			if (refObj != null) {
				Set<RefBaseObject> refObjs = new HashSet<RefBaseObject>();
				Object[] objects = strSel.toArray();
				for (Object obj : objects) {
					RefBaseObject rbo = ModelAdapterUI.getInstance().getRefBaseObject(obj);
					if (rbo != null) {
						refObjs.add(rbo);
					}
				}
				DefaultModelTransferTarget dmth = new DefaultModelTransferTarget();
				boolean result = dmth.isTransferAllowed(target, refObjs.toArray(new RefBaseObject[refObjs.size()]));
				return (result ? Status.OK_STATUS : Status.CANCEL_STATUS);
			}
		}
		return Status.CANCEL_STATUS;
	}

	public IStatus validateDrop(Object target, int operation, TransferData transferType) {
		IStructuredSelection strSel = ModelAdapter.getInstance().adaptObject(LocalSelectionTransfer.getInstance().getSelection(),
				IStructuredSelection.class);
		return validateDrop(strSel, operation, target);
	}

	private Connection getConnection(ITreeNode<?> treeNode) {
		Connection con = (Connection) treeNode.getAdapter(Connection.class);
		if (con == null) {
			IProject project = DNDHelper.getProject(treeNode);
			if (project == null) {
				return null;
			}
			// get connection, but do nothing if it's not there
			con = ConnectionManagerUI.getInstance().getOrCreateDefaultConnectionAsync(project, null);
		}
		return con;
	}
}