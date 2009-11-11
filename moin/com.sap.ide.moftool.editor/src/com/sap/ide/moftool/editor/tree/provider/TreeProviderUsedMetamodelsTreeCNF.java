/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import org.eclipse.core.resources.IProject;

import com.sap.ide.moftool.editor.tree.tumcnf.NodeUsedMMRoot;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeNavigatorContentProvider;

/**
 * @author SAP AG
 * @generated
 */

public class TreeProviderUsedMetamodelsTreeCNF extends TreeNodeNavigatorContentProvider {

	/**
	 * @generated
	 */
	@Override
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof IProject) {
			IProject project = (IProject) parentElement;
			NodeUsedMMRoot root = new NodeUsedMMRoot(project);

			return new Object[] { root };

		}
		if (parentElement instanceof NodeUsedMMRoot) {
			if (!initializeConnectionDeferred((NodeUsedMMRoot) parentElement)) {
				// initialization not finished (yet), so return place holder
				// once a connection is available the tree will be refreshed
				return new Object[] { ITreeNode.LOADING_DATA_NODE };
			}
		}

		return super.getChildren(parentElement);
	}

}
