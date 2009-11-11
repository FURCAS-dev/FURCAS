// TreeTreePackageAssociations

// NodeTPA_NodeReference1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpa.men;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.tree.tpa.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeReferences;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTPA_NodeReference extends TreeNodeRefObject<Reference> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPA_NodeReference(Reference modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		setParent(new NodeTPA_NodeReferences((AssociationEnd) modelElement.getContainer()));

	}

	/**
	 * @modified
	 */
	public NodeTPA_NodeReference(Object parent, Reference modelElement) {
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
