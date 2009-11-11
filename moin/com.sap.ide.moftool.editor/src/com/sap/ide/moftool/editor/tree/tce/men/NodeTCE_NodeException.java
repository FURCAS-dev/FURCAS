// TreeTreeClassExceptions

// NodeTCE_NodeException1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tce.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;

import com.sap.ide.moftool.editor.tree.tce.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tce.atn.NodeTCE_NodeParameters;
import com.sap.ide.moftool.editor.tree.tce.atn.NodeTCE_NodeTags;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCE_NodeException extends TreeNodeRefObject<MofException> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCE_NodeException(MofException modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		setParent(new NodeTCE_NodeClass((MofClass) modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTCE_NodeException(Object parent, MofException modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		MofException modelElement = getValue();

		children.add(new NodeTCE_NodeParameters(this, modelElement));

		children.add(new NodeTCE_NodeTags(this, modelElement));

		return children.toArray();

	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return true;
	}
}
