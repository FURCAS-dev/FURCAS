// TreeTreePackageImports

// NodeTPI_NodePackage1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tpi.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.tree.tpi.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTPI_NodePackage extends TreeNodeRefObject<MofPackage> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTPI_NodePackage(MofPackage modelElement) {
		super(modelElement, modelElement);
		// TODO initialize the parent for this node using the method setParent(Object)
		// @see JavaDoc for details, e.g. setParent(new NodeWriter(((Book)modelElement).getAuthor()));
	}

	/**
	 * @modified
	 */
	public NodeTPI_NodePackage(Object parent, MofPackage modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTPI_NodeImport> children = new ArrayList<NodeTPI_NodeImport>();

		MofPackage mofPackage = getValue();

		for (ModelElement modelElement : mofPackage.getContents()) {
			if (modelElement instanceof Import) {
				NodeTPI_NodeImport node = new NodeTPI_NodeImport(this, (Import) modelElement);
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
