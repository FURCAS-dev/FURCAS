
// TreeTreeEnumTypeTags

// NodeTETT_NodeEnumType1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tett.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tett.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTETT_NodeEnumType extends TreeNodeRefObject<EnumerationType> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTETT_NodeEnumType(EnumerationType modelElement) {
		super(modelElement, modelElement);

	}

	/**
	 * @modified
	 */
	public NodeTETT_NodeEnumType(Object parent, EnumerationType modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTETT_NodeEnumTypeTag> children = new ArrayList<NodeTETT_NodeEnumTypeTag>();

		EnumerationType structureType = getValue();
	
		for (ModelElement dobj : structureType.getContents()) {
			if (dobj instanceof Tag) {				
				NodeTETT_NodeEnumTypeTag ltn = new NodeTETT_NodeEnumTypeTag(this,
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
