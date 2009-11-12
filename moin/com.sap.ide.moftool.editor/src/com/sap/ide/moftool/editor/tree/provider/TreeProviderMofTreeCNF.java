
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import org.eclipse.core.resources.IProject;

import com.sap.ide.moftool.editor.tree.tcnf.NodeMofRoot;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeNavigatorContentProvider;

/**
 * @author SAP AG
 * @generated
 */

public class TreeProviderMofTreeCNF extends TreeNodeNavigatorContentProvider {

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof IProject) {
			IProject project = (IProject) parentElement;
			NodeMofRoot root = new NodeMofRoot(project);

			return new Object[] { root };

		}
		if (parentElement instanceof NodeMofRoot) {
			if (!initializeConnectionDeferred((NodeMofRoot) parentElement)) {
				// initialization not finished (yet), so return place holder
				// once a connection is available the tree will be refreshed
				return new Object[] { ITreeNode.LOADING_DATA_NODE };
			}
		}

		return super.getChildren(parentElement);
	}

	/**
	 * Given the input, return the top level entities; 
	 * This is generated from the  <Root> contents
	 * It can be used to use one and the same tree with different input to display subtrees
	 * Root entries are directly returned, 
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {

		return getChildren(inputElement);

	}

}
