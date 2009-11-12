
// TreeTreeStructureTypeTags

// NodeTSTT_NodeStructureType1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tstt.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tstt.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTSTT_NodeStructureType extends TreeNodeRefObject<StructureType> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTSTT_NodeStructureType(StructureType modelElement) {
		super(modelElement, modelElement);

	}

	/**
	 * @modified
	 */
	public NodeTSTT_NodeStructureType(Object parent, StructureType modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTSTT_NodeStructureTypeTag> children = new ArrayList<NodeTSTT_NodeStructureTypeTag>();

		StructureType structureType = getValue();
	
		for (ModelElement dobj : structureType.getContents()) {
			if (dobj instanceof Tag) {				
				NodeTSTT_NodeStructureTypeTag ltn = new NodeTSTT_NodeStructureTypeTag(this,
						(Tag)dobj);
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
