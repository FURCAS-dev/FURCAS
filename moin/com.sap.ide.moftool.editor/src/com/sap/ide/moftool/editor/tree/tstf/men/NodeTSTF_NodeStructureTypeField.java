
// TreeTreeStructureTypeFields

// NodeTSTF_NodeStructureTypeField1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tstf.men;

import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.tree.tstf.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTSTF_NodeStructureTypeField extends TreeNodeRefObject<StructureField> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTSTF_NodeStructureTypeField(StructureField modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
		setParent(new NodeTSTF_NodeStructureType((StructureType)modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTSTF_NodeStructureTypeField(Object parent, StructureField modelElement) {
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
