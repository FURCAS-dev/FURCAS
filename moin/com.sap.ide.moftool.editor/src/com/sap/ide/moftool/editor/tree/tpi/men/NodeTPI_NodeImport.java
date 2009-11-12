// TreeTreePackageImports

// NodeTPI_NodeImport1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpi.men;

import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.tree.tpi.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTPI_NodeImport extends TreeNodeRefObject<Import> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPI_NodeImport(Import modelElement) {
		super(modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
		setParent(new NodeTPI_NodePackage((MofPackage) modelElement.getContainer()));
	}

	/**
	 * @modified
	 */
	public NodeTPI_NodeImport(Object parent, Import modelElement) {
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
