
// TreeTreeStructureTypeFields

// NodeTSTF_NodeStructureType1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tstf.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.tree.tstf.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTSTF_NodeStructureType extends TreeNodeRefObject<StructureType> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTSTF_NodeStructureType(StructureType modelElement) {
		super(modelElement, modelElement);

	}

	/**
	 * @modified
	 */
	public NodeTSTF_NodeStructureType(Object parent, StructureType modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTSTF_NodeStructureTypeField> children = new ArrayList<NodeTSTF_NodeStructureTypeField>();

		StructureType structureType = getValue();
	
		for (ModelElement dobj : structureType.getContents()) {
			if (dobj instanceof StructureField) {				
				NodeTSTF_NodeStructureTypeField ltn = new NodeTSTF_NodeStructureTypeField(this,
						(StructureField)dobj);
				children.add(ltn);
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
