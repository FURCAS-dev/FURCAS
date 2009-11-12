// TreeUsedMetamodelsTreeCNF

// NodeUsedMMDCs1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tumcnf.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.ide.moftool.editor.tree.tumcnf.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tumcnf.NodeUsedMMRoot;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeDomainRoot;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;

/**
 * @generated modified
 */
public class NodeUsedMMDCs extends TreeNodeDomainRoot implements IThisTreeNode {

	/**
	 * @modified
	 */
	private CRI mContainer = null;

	/**
	 * @modified
	 */
	private IProject mProjectToNavigateTo = null;

	/**
	 * @modified
	 * 
	 * @exception IllegalArgumentException
	 *                if <code>cri</code> is null
	 */
	public NodeUsedMMDCs(IProject project, CRI cri) {
		super(new NodeUsedMMRoot(project), project);
		Assert.isLegal(cri != null, "The cri must not be null");  //$NON-NLS-1$
		this.mContainer = cri;
		// if project in workspace, offer navigation via context menu
		this.mProjectToNavigateTo = project;
	}

	/**
	 * @modified
	 * 
	 * @exception IllegalArgumentException
	 *                if <code>cri</code> is null
	 */
	public NodeUsedMMDCs(Object parent, IProject project, CRI cri) {
		super(parent, project);
		Assert.isLegal(cri != null, "The cri must not be null");  //$NON-NLS-1$
		this.mContainer = cri;
		// if project in workspace, offer navigation via context menu
		this.mProjectToNavigateTo = project;
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		IRunnableWithConnection runnable = new IRunnableWithConnection() {
			public void run(Connection connection, IProgressMonitor monitor) {
			}
		};

		if (ConnectionManagerUI.getInstance().getOrCreateDefaultConnectionAsync(getValue(), runnable) == null) {
			return new Object[] { ITreeNode.LOADING_DATA_NODE };
		}

		// Get all foreign objects (from all referenced containers)
		// <sw 310708>
		IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(getConnection(),
				PartitionScope.VISIBLE);
		List<MofPackage> mMofPackages = QueryService.getInstance().queryInstances(getConnection(), partitionScopeProvider,
				MOFToolEditorPlugin.CONTAINERNAME_Model, new String[] { "Model", "Package" });  //$NON-NLS-1$ //$NON-NLS-2$
		// </sw 310708>

		for (MofPackage mofPackage : mMofPackages) {
			CRI container = ModelAdapter.getInstance().getContainer(mofPackage);
			if (mContainer.equals(container)) {
				// Check availability in Eclipse workspace
				if ((mofPackage.getContainer() instanceof MofPackage) || mofPackage.getName().startsWith("OclGenerated_")) { //$NON-NLS-1$
					continue;
				}
				if (!ModelElementService.isAvailableInWorkspace(mofPackage)) {
					// MOF Package doesn't belong to a project in workspace
					NodeUsedMMRootPackages node = new NodeUsedMMRootPackages(this, mofPackage);
					children.add(node);

					// project is not in workspace -> remove navigation link
					mProjectToNavigateTo = null;

				} else {
					return new ArrayList<MofPackage>(0).toArray();
				}
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

	/**
	 * @modified
	 */
	public CRI getNodeContainer() {
		return mContainer;
	}

	/**
	 * @modified
	 */
	public IProject getProjectToNavigateTo() {
		return mProjectToNavigateTo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mContainer == null) ? 0 : mContainer.hashCode());
		result = prime * result + ((mProjectToNavigateTo == null) ? 0 : mProjectToNavigateTo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof NodeUsedMMDCs)) {
			return false;
		}

		NodeUsedMMDCs other = (NodeUsedMMDCs) obj;
		if (mContainer == null) {
			if (other.mContainer != null) {
				return false;
			}
		} else if (!mContainer.equals(other.mContainer)) {
			return false;
		}
		if (mProjectToNavigateTo == null) {
			if (other.mProjectToNavigateTo != null) {
				return false;
			}
		} else if (!mProjectToNavigateTo.equals(other.mProjectToNavigateTo)) {
			return false;
		}
		return true;
	}

}
