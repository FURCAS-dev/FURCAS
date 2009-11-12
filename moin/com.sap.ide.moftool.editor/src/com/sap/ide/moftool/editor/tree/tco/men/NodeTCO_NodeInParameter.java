
// TreeTreeClassOperations

// NodeTCO_NodeInParameter1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tco.men;

import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;

import com.sap.ide.moftool.editor.tree.tco.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeInParameters;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCO_NodeInParameter extends TreeNodeRefObject<Parameter> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCO_NodeInParameter(Parameter modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
		setParent(new NodeTCO_NodeInParameters((Operation)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTCO_NodeInParameter(Object parent, Parameter modelElement) {
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
