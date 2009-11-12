// TreeTreeClassConstants

// NodeTCN_NodeClass1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcn.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.tree.tcn.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tpa.men.NodeTPA_NodePackage;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCN_NodeClass extends TreeNodeRefObject<MofClass> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCN_NodeClass(MofClass modelElement) {
		super(modelElement);
		setParent(new NodeTPA_NodePackage((MofPackage) modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTCN_NodeClass(Object parent, MofClass modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCN_NodeConstant> children = new ArrayList<NodeTCN_NodeConstant>();

		MofClass mofClass = getValue();

		for (ModelElement dobj : mofClass.getContents()) {
			if (dobj instanceof Constant) {
				NodeTCN_NodeConstant ltn = new NodeTCN_NodeConstant(this, (Constant) dobj);
				children.add(ltn);
			}
		}

		return children.toArray();
	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return getChildren().length != 0;
	}
}
