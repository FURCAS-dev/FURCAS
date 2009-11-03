package com.sap.mi.tools.cockpit.editor.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeNavigatorContentProvider;
import com.sap.mi.tools.cockpit.editor.model.ProjectRootNode;
import com.sap.mi.tools.cockpit.editor.model.VIEWER_MODE;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;

/**
 * Content provider for the {@link MOINBrowserView}. Assumes elements are instances of {@link ITreeNode}.
 * 
 * @author d003456
 * 
 */
public final class MOINBrowserContentProvider extends TreeNodeNavigatorContentProvider {

	private final VIEWER_MODE mode;

	private List<ProjectRootNode> rootNodes;

	/**
	 * Creates {@link MOINBrowserContentProvider}.
	 * 
	 * @param mode
	 */
	public MOINBrowserContentProvider(VIEWER_MODE mode) {

		super();
		Assert.isNotNull(mode);
		this.mode = mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.provider.TreeNodeContentProviderBase#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof IProject[]) {
			final IProject[] projects = (IProject[]) parentElement;
			final List<ProjectRootNode> roots = new ArrayList<ProjectRootNode>();

			for (int i = 0; i < projects.length; i++) {
				final ProjectRootNode root = new ProjectRootNode(parentElement, projects[i], this.mode);
				roots.add(root);
			}
			this.rootNodes = roots;
			return roots.toArray();
		}

		if (parentElement instanceof ProjectRootNode) {
			if (!initializeConnectionDeferred((ProjectRootNode) parentElement)) {
				// initialization not finished (yet), so return place holder
				// once a connection is available the tree will be refreshed
				return new Object[] { ITreeNode.LOADING_DATA_NODE };
			}
		}

		return super.getChildren(parentElement);
	}

	/**
	 * @return the rootNodes
	 */
	public final List<ProjectRootNode> getRootNodes() {

		return this.rootNodes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.provider.TreeNodeNavigatorContentProvider#dispose()
	 */
	@Override
	public void dispose() {

		this.rootNodes.clear();
		this.rootNodes = null;
		super.dispose();
	}

}
