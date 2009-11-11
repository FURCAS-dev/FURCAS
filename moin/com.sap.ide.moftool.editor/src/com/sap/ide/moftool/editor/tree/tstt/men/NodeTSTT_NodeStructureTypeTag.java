
// TreeTreeStructureTypeTags

// NodeTSTT_NodeStructureTypeTag1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tstt.men;

import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tstc.men.NodeTSTC_NodeStructureType;
import com.sap.ide.moftool.editor.tree.tstt.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTSTT_NodeStructureTypeTag extends TreeNodeRefObject<Tag> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTSTT_NodeStructureTypeTag(Tag modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object)
		setParent(new NodeTSTC_NodeStructureType((StructureType)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTSTT_NodeStructureTypeTag(Object parent, Tag modelElement) {
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
