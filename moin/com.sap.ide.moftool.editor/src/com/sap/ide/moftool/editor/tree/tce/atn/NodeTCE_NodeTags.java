/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1) 
 * (NodeClass_ARTIFICIAL.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tce.atn;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tce.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tce.men.NodeTCE_NodeException;
import com.sap.ide.moftool.editor.tree.tce.men.NodeTCE_NodeTag;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * @generated modified
 */
public class NodeTCE_NodeTags extends TreeNode<MofException> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCE_NodeTags(Object parent, MofException modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public NodeTCE_NodeTags(MofException modelElement) {
		super(modelElement);
		// TODO set the parent for this node using the setParent(Object) method otherwise equals(Object) will fail
		// @see JavaDoc for details, e.g. setParent(new NodeLibrary(getValue());
		setParent(new NodeTCE_NodeException(modelElement));
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCE_NodeTag> children = new ArrayList<NodeTCE_NodeTag>();

		MofException mofException = getValue();

		for (ModelElement modelElement : mofException.getContents()) {
			if (modelElement instanceof Tag) {
				NodeTCE_NodeTag node = new NodeTCE_NodeTag(this, (Tag) modelElement);
				children.add(node);
			}
		}

		return children.toArray();

	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return getChildren().length != 0;
	}
}
