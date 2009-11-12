/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1) 
 * (NodeClass_ARTIFICIAL.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpa.atn;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tpa.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tpa.men.NodeTPA_NodeAssociation;
import com.sap.ide.moftool.editor.tree.tpa.men.NodeTPA_NodeTag;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * @generated modified
 */
public class NodeTPA_NodeTags extends TreeNode<Association> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPA_NodeTags(Object parent, Association modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public NodeTPA_NodeTags(Association modelElement) {
		super(modelElement);
		// TODO set the parent for this node using the setParent(Object) method otherwise equals(Object) will fail
		// @see JavaDoc for details, e.g. setParent(new NodeLibrary(getValue());
		setParent(new NodeTPA_NodeAssociation(modelElement));
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {

		List<NodeTPA_NodeTag> children = new ArrayList<NodeTPA_NodeTag>();

		Association association = getValue();

		for (ModelElement modelElement : association.getContents()) {
			if (modelElement instanceof Tag) {
				NodeTPA_NodeTag node = new NodeTPA_NodeTag(this, (Tag) modelElement);
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
