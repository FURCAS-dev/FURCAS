package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;

/**
 * @author d003456
 * 
 */
public final class ModelPartitionSubPathNode extends TreeNode<ContainerFragment> implements ITreeNodeLabelAware {

	private final VIEWER_MODE mode;

	/**
	 * Creates {@link ModelPartitionSubPathNode}.
	 * 
	 * @param parent
	 * @param containerFragment
	 */
	public ModelPartitionSubPathNode(ITreeNode<?> parent, ContainerFragment containerFragment, VIEWER_MODE mode) {

		super(parent, containerFragment);
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
		Assert.isNotNull(mode);
		this.mode = mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		final List<ITreeNode<?>> childList = new ArrayList<ITreeNode<?>>();
		final ContainerFragment root = getValue();

		// calculate fragmented container paths
		final List<ContainerFragment> cf = root.getCompactedChildren();

		final ProjectRootNode prn = getProjectRootNode();

		for (final ContainerFragment containerFragment : cf) {
			if (containerFragment.isLeaf()) {
				childList.add(new ModelPartitionNode(this, prn.getModelPartitionByName(containerFragment.getKey()), this.mode));
			}
			else {
				childList.add(new ModelPartitionSubPathNode(this, containerFragment, this.mode));
			}
		}

		return childList.toArray(new Object[childList.size()]);

	}

	private ProjectRootNode getProjectRootNode() {

		ITreeNode<?> parent = (ITreeNode<?>) getParent();
		while (!(parent instanceof ProjectRootNode)) {
			parent = (ITreeNode<?>) parent.getParent();
		}
		return (ProjectRootNode) parent;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		final ContainerFragment root = getValue();

		String label = MOINBrowserLabelProvider.ERROR_LABEL;
		if (root != null && root.getName().length() > 0) {
			label = root.getName();
		}
		return label;

	}

	public boolean isContainer() {

		final boolean result = true;
		final ContainerFragment root = getValue();

		if (root != null) {
			final List<ContainerFragment> children = root.getCompactedChildren();
			for (final ContainerFragment containerFragment : children) {
				if (!containerFragment.isLeaf()) {
					return false;
				}
			}
		}

		return result;
	}

}
