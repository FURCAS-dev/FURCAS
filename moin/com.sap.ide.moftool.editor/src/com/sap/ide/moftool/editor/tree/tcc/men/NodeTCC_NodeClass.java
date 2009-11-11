// TreeTreeClassConstraints

// NodeTCC_NodeClass1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcc.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.tree.tcc.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCC_NodeClass extends TreeNodeRefObject<MofClass> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCC_NodeClass(MofClass modelElement) {
		super(modelElement, modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
	}

	/**
	 * @modified
	 */
	public NodeTCC_NodeClass(Object parent, MofClass modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCC_NodeConstraint> children = new ArrayList<NodeTCC_NodeConstraint>();

		MofClass mofClass = getValue();

		for (ModelElement modelElement : mofClass.getContents()) {
			if (modelElement instanceof Constraint) {
				NodeTCC_NodeConstraint node = new NodeTCC_NodeConstraint(this, (Constraint) modelElement);
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
