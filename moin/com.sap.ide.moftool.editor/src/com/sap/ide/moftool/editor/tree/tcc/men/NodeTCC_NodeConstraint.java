// TreeTreeClassConstraints

// NodeTCC_NodeConstraint1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcc.men;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.tree.tcc.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCC_NodeConstraint extends TreeNodeRefObject<Constraint> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCC_NodeConstraint(Constraint modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		setParent(new NodeTCC_NodeClass((MofClass) modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTCC_NodeConstraint(Object parent, Constraint modelElement) {
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
