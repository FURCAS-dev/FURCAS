
// TreeTreeClassDataTypes

// NodeTCDT_NodeClass1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcdt.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.tree.tcdt.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCDT_NodeClass extends TreeNodeRefObject<MofClass> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCDT_NodeClass(MofClass modelElement) {
		super(modelElement, modelElement);
	}

	/**
	 * @modified
	 */
	public NodeTCDT_NodeClass(Object parent, MofClass modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCDT_NodeDataType> children = new ArrayList<NodeTCDT_NodeDataType>();

		MofClass mofClass = getValue();
	
		for (ModelElement dobj : mofClass.getContents()) {
			if (dobj instanceof DataType) {				
				NodeTCDT_NodeDataType ltn = new NodeTCDT_NodeDataType(this,
						(DataType)dobj);
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
