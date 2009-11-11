package com.sap.ide.moftool.editor.tree.tcnf.men;

import com.sap.tc.moin.repository.mmi.model.Association;

import com.sap.ide.moftool.editor.tree.tcnf.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

public class NodeCnfAssoc extends TreeNodeRefObject<Association> implements IThisTreeNode{

	protected NodeCnfAssoc(Object parent, Association value) {
		super(parent, value);
	}

	public Object[] getChildren() {
		return null;
	}

	public boolean hasChildren() {
		return false;
	}

}
