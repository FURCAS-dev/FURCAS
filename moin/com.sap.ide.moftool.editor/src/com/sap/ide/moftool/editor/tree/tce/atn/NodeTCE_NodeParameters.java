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
import com.sap.tc.moin.repository.mmi.model.Parameter;

import com.sap.ide.moftool.editor.tree.tce.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tce.men.NodeTCE_NodeException;
import com.sap.ide.moftool.editor.tree.tce.men.NodeTCE_NodeParameter;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * @generated modified
 */
public class NodeTCE_NodeParameters extends TreeNode<MofException> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCE_NodeParameters(Object parent, MofException modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public NodeTCE_NodeParameters(MofException modelElement) {
		super(modelElement);
		// TODO set the parent for this node using the setParent(Object) method otherwise equals(Object) will fail
		// @see JavaDoc for details, e.g. setParent(new NodeLibrary(getValue());
		setParent(new NodeTCE_NodeException(modelElement));
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCE_NodeParameter> children = new ArrayList<NodeTCE_NodeParameter>();

		MofException mofException = getValue();

		for (ModelElement modelElement : mofException.getContents()) {
			if (modelElement instanceof Parameter) {
				NodeTCE_NodeParameter node = new NodeTCE_NodeParameter(this, (Parameter) modelElement);
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
