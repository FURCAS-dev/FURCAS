
// TreeTreeClassOperations

// NodeTCO_NodeClass1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tco.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;

import com.sap.ide.moftool.editor.tree.tco.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCO_NodeClass extends TreeNodeRefObject<MofClass> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCO_NodeClass(MofClass modelElement) {
		super(modelElement, modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
	}

	/**
	 * @generated
	 */
	public NodeTCO_NodeClass(Object parent, MofClass modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCO_NodeOperation> children = new ArrayList<NodeTCO_NodeOperation>();

		MofClass mofClass = getValue();	
		
		for (ModelElement dobj : mofClass.getContents()) {
			if (dobj instanceof Operation) {				
				NodeTCO_NodeOperation ltn = new NodeTCO_NodeOperation(this,
						(Operation)dobj);
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
