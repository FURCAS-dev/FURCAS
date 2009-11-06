package com.sap.mi.fwk.ui.internal.dnd;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler.TransferOperationEnum;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

public class DefaultTreeNodeTransfer implements ITreeNodeTransfer {

	private final IStructuredSelection sel;
	private TransferOperationEnum op;
	private RefBaseObject[] objs;
	private Connection con;

	public DefaultTreeNodeTransfer(IStructuredSelection sel, TransferOperationEnum op) {
		this.sel = sel;
		this.op = op;
	}

	public void setOperation(TransferOperationEnum newOp) {
		this.op = newOp;
	}

	public IStructuredSelection getSelection() {
		return sel;
	}

	public TransferOperationEnum getTransferOperartion() {
		return op;
	}

	public RefBaseObject[] getRefBaseObjects(Connection con) {
		// objects already resolved ?
		if (con.equals(this.con)) {
			return this.objs;
		}

		// not resolved (at least not for the given connection)
		this.con = con;
		Object[] objects = sel.toArray();
		RefBaseObject rbo = null;
		List<RefBaseObject> list = new ArrayList<RefBaseObject>();
		for (Object object : objects) {
			rbo = ModelAdapterUI.getInstance().getRefBaseObject(object);
			if (rbo != null) {
				list.add(ModelAdapter.getInstance().resolveInConnection(rbo, this.con));
			}
		}
		this.objs = list.toArray(new RefBaseObject[list.size()]);
		return this.objs;
	}

	public int hashCode() {
		return sel.hashCode();
	}

	/**
	 * Two {@link DefaultTreeNodeTransfer}s are considered equal if 
	 * 
	 * <pre>
	 * a) one == the other or
	 * b) the selections are equal
	 * </pre>
	 * 
	 * @return True if both are equal
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof DefaultTreeNodeTransfer)) {
			return false;
		}
		DefaultTreeNodeTransfer other = (DefaultTreeNodeTransfer) obj;
		if (sel.equals(other.sel)) {
			return true;
		}
		return false;
	}
}
