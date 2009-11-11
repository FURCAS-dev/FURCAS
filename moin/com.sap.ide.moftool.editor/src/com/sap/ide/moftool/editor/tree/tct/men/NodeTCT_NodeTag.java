
// TreeTreeClassTags

// NodeTCT_NodeTag1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tct.men;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tca.men.NodeTCA_NodeClass;
import com.sap.ide.moftool.editor.tree.tct.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCT_NodeTag extends TreeNodeRefObject<Tag> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCT_NodeTag(Tag modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
		setParent(new NodeTCA_NodeClass((MofClass)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTCT_NodeTag(Object parent, Tag modelElement) {
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
