// TreeTreePackageAssociations

// NodeTPA_NodeAssociationEnd1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpa.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;

import com.sap.ide.moftool.editor.tree.tpa.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeAssociationEnds;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeReferences;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTPA_NodeAssociationEnd extends TreeNodeRefObject<AssociationEnd> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPA_NodeAssociationEnd(AssociationEnd modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		setParent(new NodeTPA_NodeAssociationEnds((Association) modelElement.getContainer()));
	}

	/**
	 * @generated
	 */
	public NodeTPA_NodeAssociationEnd(Object parent, AssociationEnd modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		AssociationEnd modelElement = getValue();

		children.add(new NodeTPA_NodeReferences(this, modelElement));

		return children.toArray();

	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return true;
	}
}
