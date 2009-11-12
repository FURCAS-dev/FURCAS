// TreeTreePackageTags

// NodeTPT_NodePackage1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpt.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tpt.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTPT_NodePackage extends TreeNodeRefObject<MofPackage> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPT_NodePackage(MofPackage modelElement) {
		super(modelElement, modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
	}

	/**
	 * @modified
	 */
	public NodeTPT_NodePackage(Object parent, MofPackage modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTPT_NodeTag> children = new ArrayList<NodeTPT_NodeTag>();

		MofPackage mofPackage = getValue();

		for (ModelElement modelElement : mofPackage.getContents()) {
			if (modelElement instanceof Tag) {
				NodeTPT_NodeTag node = new NodeTPT_NodeTag(this, (Tag) modelElement);
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
