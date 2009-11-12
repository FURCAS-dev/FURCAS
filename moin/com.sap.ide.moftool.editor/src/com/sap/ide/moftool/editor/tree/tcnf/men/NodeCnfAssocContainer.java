package com.sap.ide.moftool.editor.tree.tcnf.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MoveAssocCmd;
import com.sap.ide.moftool.editor.tree.LocalizationMessages;
import com.sap.ide.moftool.editor.tree.tcnf.IThisTreeNode;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

public class NodeCnfAssocContainer extends TreeNode<MofPackage> implements ITreeNodeTransferHandler, IThisTreeNode {

	private final Connection con;

	protected NodeCnfAssocContainer(NodeCnfPackages container, Connection con) {
		super(container, container.getValue());
		this.con = con;
	}

	public Object[] getChildren() {
		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		MofPackage mofPackage = getValue();
		Connection connection = ModelAdapter.getInstance().getConnection(mofPackage);

		String assocQuery = "select assoc from \"sap.com/tc/moin/mof_1.4\"#Model::Association as assoc, \"" //$NON-NLS-1$
				+ ((Partitionable) mofPackage).get___Mri() + "\" as pack where assoc.container = pack"; //$NON-NLS-1$
		MQLProcessor mqlProcessor = connection.getMQLProcessor();
		MQLResultSet resultSet = mqlProcessor.execute(assocQuery);
		for (int i = 0; i < resultSet.getSize(); i++) {
			children.add(new NodeCnfAssoc(this, (Association) resultSet.getRefObject(i, "assoc"))); //$NON-NLS-1$
		}

		return children.toArray();
	}

	public boolean hasChildren() {
		return true;
	}

	public boolean handleTransfer(Object target, ITreeNodeTransfer transfer) {
		RefBaseObject[] refBaseObjects = transfer.getRefBaseObjects(con);
		Command cmd = null;
		//Check out all partitions of the project
		if (!CommandManager.getInstance().prepareExecution(con, null).isOK()) {
			return false;
		}
		con.getCommandStack().openGroup(LocalizationMessages.NodeCnfAssocContainer_0_XTND);
		try {
			for (RefBaseObject refBaseObject : refBaseObjects) {
				if (refBaseObject instanceof Association) {
					cmd = new MoveAssocCmd((Association) refBaseObject, getValue(), con);
				}
				cmd.execute();
			}
		} finally {
			con.getCommandStack().closeGroup();
			ConnectionManagerUI.getInstance().saveIfNecessary(con, null);
		}
		return true;
	}

	public boolean isTransferAllowed(Object target, ITreeNodeTransfer transfer) {
		RefBaseObject[] refBaseObjects = transfer.getRefBaseObjects(con);
		for (RefBaseObject refBaseObject : refBaseObjects) {
			if (!(refBaseObject instanceof Association)) {
				return false;
			}
		}
		return true;
	}
}
