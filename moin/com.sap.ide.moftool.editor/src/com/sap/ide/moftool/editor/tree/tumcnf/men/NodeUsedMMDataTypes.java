// TreeUsedMetamodelsTreeCNF

// NodeUsedMMDataTypes1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tumcnf.men;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.tree.tumcnf.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeUsedMMDataTypes extends TreeNodeRefObject<RefObject> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeUsedMMDataTypes(DataType modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		Namespace namespace = modelElement.getContainer();
		if (namespace instanceof MofPackage) {
			if (((MofPackage) namespace).getContainer() instanceof MofPackage) {
				// this is obviously not the RootPackage
				setParent(new NodeUsedMMPackages((MofPackage) namespace));
			} else {
				// must be the RootPackage
				setParent(new NodeUsedMMRootPackages((MofPackage) namespace.getContainer()));
			}
		} else if (namespace instanceof MofClass) {
			setParent(new NodeUsedMMClasses((MofClass) namespace));
		}
	}

	/**
	 * @modified
	 */
	public NodeUsedMMDataTypes(Object parent, DataType modelElement) {
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
