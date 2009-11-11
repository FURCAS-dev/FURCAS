
// TreeTreeClassOperations

// NodeTCO_NodeOperation1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tco.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;

import com.sap.ide.moftool.editor.tree.tco.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeInOutParameters;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeInParameters;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeOutParameters;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeTags;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCO_NodeOperation extends TreeNodeRefObject<Operation> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCO_NodeOperation(Operation modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
		setParent(new NodeTCO_NodeClass((MofClass)modelElement.getContainer()));

	}

	/**
	 * @modified
	 */
	public NodeTCO_NodeOperation(Object parent, Operation modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		Operation modelElement = getValue();

		children.add(new NodeTCO_NodeInParameters(this, modelElement));

		children.add(new NodeTCO_NodeOutParameters(this, modelElement));

		children.add(new NodeTCO_NodeInOutParameters(this, modelElement));

		children.add(new NodeTCO_NodeTags(this, modelElement));

		return children.toArray();

	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return true;
	}
}
