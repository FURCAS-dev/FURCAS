// TreeUsedMetamodelsTreeCNF

// NodeUsedMMPackages1
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
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated
 */
public class NodeUsedMMPackages extends TreeNodeRefObject<MofPackage> implements IThisTreeNode {

	/**
	 * @generated
	 */
	public NodeUsedMMPackages(MofPackage mofPackage) {
		super(mofPackage);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		if (mofPackage.getContainer() instanceof MofPackage) {
			setParent(new NodeUsedMMRootPackages((MofPackage) mofPackage.getContainer()));
		}
	}

	/**
	 * @generated
	 */
	public NodeUsedMMPackages(Object parent, MofPackage modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		MofPackage mofPackage = getValue();

		for (ModelElement modelElement : mofPackage.getContents()) {
			if (modelElement instanceof MofClass) {
				NodeUsedMMClasses node = new NodeUsedMMClasses(this, (MofClass) modelElement);
				children.add(node);
			} else if (modelElement instanceof DataType) {
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
