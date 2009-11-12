// TreeTreeClassExceptions

// NodeTCE_NodeParameter1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tce.men;

import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Parameter;

import com.sap.ide.moftool.editor.tree.tce.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tce.atn.NodeTCE_NodeParameters;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCE_NodeParameter extends TreeNodeRefObject<Parameter> implements IThisTreeNode {

	/**
	 * @generated modified
	 */
	public NodeTCE_NodeParameter(Parameter modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		setParent(new NodeTCE_NodeParameters((MofException) modelElement.getContainer()));
	}

	/**
	 * @generated modified
	 */
	public NodeTCE_NodeParameter(Object parent, Parameter modelElement) {
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
