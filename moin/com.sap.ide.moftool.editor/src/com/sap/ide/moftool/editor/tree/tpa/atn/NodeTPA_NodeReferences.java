/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1) 
 * (NodeClass_ARTIFICIAL.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpa.atn;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.core.service.ReferenceService;
import com.sap.ide.moftool.editor.tree.tpa.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tpa.men.NodeTPA_NodeAssociationEnd;
import com.sap.ide.moftool.editor.tree.tpa.men.NodeTPA_NodeReference;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * @generated modified
 */
public class NodeTPA_NodeReferences extends TreeNode<AssociationEnd> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPA_NodeReferences(Object parent, AssociationEnd modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public NodeTPA_NodeReferences(AssociationEnd modelElement) {
		super(modelElement);
		// TODO set the parent for this node using the setParent(Object) method otherwise equals(Object) will fail
		// @see JavaDoc for details, e.g. setParent(new NodeLibrary(getValue());
		setParent(new NodeTPA_NodeAssociationEnd((AssociationEnd) modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTPA_NodeReference> children = new ArrayList<NodeTPA_NodeReference>();

		AssociationEnd associationEnd = getValue();

		if (associationEnd != null) {
			MofClass mofClass = (MofClass) associationEnd.otherEnd().getType();
			List<Reference> references = ReferenceService.findReferenceInMofClass(associationEnd, mofClass, true);

			for (Reference reference : references) {

				NodeTPA_NodeReference node = new NodeTPA_NodeReference(this, reference);
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
