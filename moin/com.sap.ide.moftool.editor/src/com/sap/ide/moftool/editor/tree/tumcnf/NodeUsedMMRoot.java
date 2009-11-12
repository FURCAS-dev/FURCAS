/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG-Version0.1)
 * (NodeClass_ROOTPROJECT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tumcnf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;

import com.sap.ide.moftool.editor.tree.tumcnf.men.NodeUsedMMDCs;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeDomainRoot;
import com.sap.tc.moin.repository.CRI;

/**
 * Navigator Root Node
 * 
 * @author SAP AG
 * @generated modified
 */
public class NodeUsedMMRoot extends TreeNodeDomainRoot implements IThisTreeNode {

	/**
	 * @generated
	 */
	public NodeUsedMMRoot(IProject value) {
		super(value, value);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeUsedMMDCs> children = new ArrayList<NodeUsedMMDCs>();

		CRI criContainer = ModelAdapter.getInstance().getContainer(getConnection());
		Collection<CRI> referencedContainers = getConnection().getSession().getReferencedContainers(criContainer);

		for (CRI cri : referencedContainers) {
			IProject project = ModelAdapter.getInstance().getProject(cri);
			if (project == null) { // closed DC; set project of root node for children
				project = getValue();
			}
			NodeUsedMMDCs node = new NodeUsedMMDCs(this, project, cri);
			children.add(node);
		}

		return children.toArray();

	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		// the assumption is that root nodes always have some children
		return true;
	}
}
