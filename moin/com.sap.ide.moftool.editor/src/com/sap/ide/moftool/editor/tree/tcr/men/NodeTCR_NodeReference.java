
// TreeTreeClassReferences

// NodeTCR_NodeReference1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcr.men;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.tree.tca.men.NodeTCA_NodeClass;
import com.sap.ide.moftool.editor.tree.tcr.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCR_NodeReference extends TreeNodeRefObject<Reference> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCR_NodeReference(Reference modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object)		
		setParent(new NodeTCA_NodeClass((MofClass)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTCR_NodeReference(Object parent, Reference modelElement) {
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
