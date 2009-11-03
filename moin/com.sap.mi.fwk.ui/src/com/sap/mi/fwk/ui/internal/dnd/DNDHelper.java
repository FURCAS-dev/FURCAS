package com.sap.mi.fwk.ui.internal.dnd;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.dnd.DND;

import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler.TransferOperationEnum;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;

public final class DNDHelper {

	public static final TransferOperationEnum getOperation(int swtOp) {

		switch (swtOp) {
		case DND.DROP_COPY:
			return TransferOperationEnum.OPERATION_DRAGDROP_COPY;
		case DND.DROP_MOVE:
			return TransferOperationEnum.OPERATION_DRAGDROP_MOVE;
		default:
			return TransferOperationEnum.OPERATION_UNKNOWN;
		}
	}

	public static final IProject getProject(ITreeNode<?> node) {
		Object value = node.getValue();
		if (value instanceof IProject) {
			return (IProject) value;
		}

		value = node.getAdapter(IProject.class);
		if (value != null) {
			return (IProject) value;
		}

		value = node.getParent();
		if (value instanceof IProject) {
			return (IProject) value;
		}
		if (node.equals(value)) {
			// parent == this -> recursion
			return null;
		}
		if (value instanceof ITreeNode<?>) {
			return getProject((ITreeNode<?>) value);
		} else {
			return null;
		}
	}
}
