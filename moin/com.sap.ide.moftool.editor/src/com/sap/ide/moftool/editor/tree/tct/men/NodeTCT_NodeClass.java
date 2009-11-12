
// TreeTreeClassTags

// NodeTCT_NodeClass1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tct.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.tree.tct.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCT_NodeClass extends TreeNodeRefObject<MofClass> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCT_NodeClass(MofClass modelElement) {
		super(modelElement, modelElement);

	}

	/**
	 * @modified
	 */
	public NodeTCT_NodeClass(Object parent, MofClass modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCT_NodeTag> children = new ArrayList<NodeTCT_NodeTag>();

		MofClass mofClass = getValue();
	
		for (ModelElement dobj : mofClass.getContents()) {
			if (dobj instanceof Tag) {				
				NodeTCT_NodeTag ltn = new NodeTCT_NodeTag(this,
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
