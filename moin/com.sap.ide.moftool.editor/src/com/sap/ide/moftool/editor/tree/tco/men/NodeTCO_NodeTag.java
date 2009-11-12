
// TreeTreeClassOperations

// NodeTCO_NodeTag1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tco.men;

import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tco.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeTags;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCO_NodeTag extends TreeNodeRefObject<Tag> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCO_NodeTag(Tag modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object)		
		setParent(new NodeTCO_NodeTags((Operation)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTCO_NodeTag(Object parent, Tag modelElement) {
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
