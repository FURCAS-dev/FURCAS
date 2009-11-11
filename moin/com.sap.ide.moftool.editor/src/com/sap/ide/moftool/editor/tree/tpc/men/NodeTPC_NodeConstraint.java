// TreeTreePackageConstraints

// NodeTPC_NodeConstraint1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpc.men;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.tree.tpc.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tpt.men.NodeTPT_NodePackage;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTPC_NodeConstraint extends TreeNodeRefObject<Constraint> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPC_NodeConstraint(Constraint modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		setParent(new NodeTPT_NodePackage((MofPackage) modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTPC_NodeConstraint(Object parent, Constraint modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {
		return ITreeNode.EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return false;
	}
}
