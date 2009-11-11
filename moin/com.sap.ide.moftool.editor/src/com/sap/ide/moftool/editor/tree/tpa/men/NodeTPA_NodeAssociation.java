// TreeTreePackageAssociations

// NodeTPA_NodeAssociation1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpa.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.tree.tpa.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeAssociationEnds;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeConstraints;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeTags;
import com.sap.ide.moftool.editor.tree.tpt.men.NodeTPT_NodePackage;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTPA_NodeAssociation extends TreeNodeRefObject<Association> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPA_NodeAssociation(Association modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		setParent(new NodeTPT_NodePackage((MofPackage) modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTPA_NodeAssociation(Object parent, Association modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		Association modelElement = getValue();

		children.add(new NodeTPA_NodeAssociationEnds(this, modelElement));

		children.add(new NodeTPA_NodeConstraints(this, modelElement));

		children.add(new NodeTPA_NodeTags(this, modelElement));

		return children.toArray();

	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return true;
	}
}
