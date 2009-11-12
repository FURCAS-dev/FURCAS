
// TreeTreeStructureTypeConstraints

// NodeTSTC_NodeStructureTypeConstraint1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tstc.men;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.tree.tstc.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTSTC_NodeStructureTypeConstraint extends TreeNodeRefObject<Constraint> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTSTC_NodeStructureTypeConstraint(Constraint modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
		setParent(new NodeTSTC_NodeStructureType((StructureType)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTSTC_NodeStructureTypeConstraint(Object parent, Constraint modelElement) {
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
