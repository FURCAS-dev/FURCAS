// TreeUsedMetamodelsTreeCNF

// NodeUsedMMClasses1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tumcnf.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.tree.tumcnf.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeUsedMMClasses extends TreeNodeRefObject<MofClass> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeUsedMMClasses(MofClass mofClass) {
		super(mofClass);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		MofPackage mofPackage = (MofPackage) mofClass.getContainer();
		if (mofPackage.getContainer() instanceof MofPackage) {
			// the mofpackage is obviously not the RootPackage
			setParent(new NodeUsedMMPackages(mofPackage));
		} else {
			// must be the RootPackage
			setParent(new NodeUsedMMRootPackages(mofPackage));
		}
	}

	/**
	 * @generated
	 */
	public NodeUsedMMClasses(Object parent, MofClass modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeUsedMMDataTypes> children = new ArrayList<NodeUsedMMDataTypes>();

		MofClass mofClass = getValue();

		for (ModelElement modelElement : mofClass.getContents()) {
			if (modelElement instanceof DataType) {
				NodeUsedMMDataTypes node = new NodeUsedMMDataTypes(this, (DataType) modelElement);
				children.add(node);
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
