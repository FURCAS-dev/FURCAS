
// TreeTreeClassReferences

// NodeTCR_NodeClass1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcr.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.tree.tcr.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTCR_NodeClass extends TreeNodeRefObject<MofClass> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCR_NodeClass(MofClass modelElement) {
		super(modelElement, modelElement);
		//TODO initialize the parent for this node using the method setParent(Object) 
		//@see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
	}

	/**
	 * @modified
	 */
	public NodeTCR_NodeClass(Object parent, MofClass modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCR_NodeReference> children = new ArrayList<NodeTCR_NodeReference>();

		MofClass mofClass = getValue();
	
		for (ModelElement dobj : mofClass.getContents()) {
			if (dobj instanceof Reference) {				
				NodeTCR_NodeReference ltn = new NodeTCR_NodeReference(this,
						(Reference)dobj);
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
