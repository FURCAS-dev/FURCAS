
// TreeMofTreeCNF

// NodeCnfDataTypes1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcnf.men;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.ide.moftool.editor.tree.tcnf.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeCnfDataTypes extends TreeNodeRefObject<DataType> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeCnfDataTypes(DataType modelElement) {
		super(modelElement);
		//initialize the parent for this node using the method setParent(Object) 		
		Namespace container = modelElement.getContainer();
		if (container instanceof MofPackage) {
				setParent(new NodeCnfPackages((MofPackage)container));
		} else if (container instanceof MofClass) {
			setParent(new NodeCnfClasses((MofClass)container));
		}
	}

	/**
	 * @modified
	 */
	public NodeCnfDataTypes(Object parent, DataType modelElement) {
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
