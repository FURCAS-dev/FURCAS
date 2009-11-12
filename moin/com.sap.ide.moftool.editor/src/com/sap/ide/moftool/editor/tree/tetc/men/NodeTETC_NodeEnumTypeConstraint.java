
// TreeTreeEnumTypeConstraints

// NodeTETC_NodeEnumTypeConstraint1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tetc.men;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.tree.tetc.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTETC_NodeEnumTypeConstraint extends TreeNodeRefObject<Constraint> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTETC_NodeEnumTypeConstraint(Constraint modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
		setParent(new NodeTETC_NodeEnumType((EnumerationType)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTETC_NodeEnumTypeConstraint(Object parent, Constraint modelElement) {
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
