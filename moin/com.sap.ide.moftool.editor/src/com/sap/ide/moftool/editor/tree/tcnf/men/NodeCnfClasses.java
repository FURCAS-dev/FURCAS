// TreeMofTreeCNF

// NodeCnfClasses1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcnf.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.ide.moftool.editor.tree.tcnf.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeCnfClasses extends TreeNodeRefObject<MofClass> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeCnfClasses(MofClass modelElement) {
		super(modelElement);
		// initialize the parent for this node using the method
		// setParent(Object)
		Namespace container = modelElement.getContainer();
		if (container instanceof MofPackage) {
			setParent(new NodeCnfPackages((MofPackage) container));
		}
	}

	/**
	 * @modified
	 */
	public NodeCnfClasses(Object parent, MofClass modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeCnfDataTypes> children = new ArrayList<NodeCnfDataTypes>();

		MofClass mofClass = getValue();

		for (ModelElement dobj : mofClass.getContents()) {
			if (dobj instanceof DataType) {
				NodeCnfDataTypes ltn = new NodeCnfDataTypes(this, (DataType) dobj);
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
