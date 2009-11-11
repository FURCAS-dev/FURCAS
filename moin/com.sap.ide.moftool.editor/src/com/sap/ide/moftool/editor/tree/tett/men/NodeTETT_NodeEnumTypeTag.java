
// TreeTreeEnumTypeTags

// NodeTETT_NodeEnumTypeTag1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tett.men;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tetc.men.NodeTETC_NodeEnumType;
import com.sap.ide.moftool.editor.tree.tett.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTETT_NodeEnumTypeTag extends TreeNodeRefObject<Tag> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTETT_NodeEnumTypeTag(Tag modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
		setParent(new NodeTETT_NodeEnumType((EnumerationType)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTETT_NodeEnumTypeTag(Object parent, Tag modelElement) {
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
