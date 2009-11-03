package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.tc.moin.repository.Partitionable;

/**
 * @author d003456
 * 
 */
public class TypeNode extends TreeNode<ModelElement> {

	private final VIEWER_MODE mode;

	/**
	 * In partition view mode only root model elements (aka top level elements) are shown.
	 */
	private final List<Partitionable> childrenAsRootEelements;

	/**
	 * Creates {@link TypeNode} showing model elements in {@link VIEWER_MODE#MODEL_BASED}.
	 * 
	 * @param parentNode
	 * @param element
	 * @param mode
	 */
	public TypeNode(ITreeNode<?> parentNode, ModelElement element, VIEWER_MODE mode) {

		super(parentNode, element);
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
		Assert.isNotNull(mode);
		this.mode = mode;
		this.childrenAsRootEelements = null;
	}

	/**
	 * Creates {@link TypeNode} showing root model elements in {@link VIEWER_MODE#PARTITION_BASED}.
	 * 
	 * @param parentNode
	 * @param element
	 * @param children
	 * @param mode
	 */
	public TypeNode(ITreeNode<?> parentNode, ModelElement element, List<Partitionable> children, VIEWER_MODE mode) {

		super(parentNode, element);
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
		Assert.isNotNull(mode);
		Assert.isLegal(children != null && !children.isEmpty());
		this.mode = mode;
		this.childrenAsRootEelements = children;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		if (this.mode == VIEWER_MODE.PARTITION_BASED) {
			return getChildrenForPartition();
		} else {
			return getChildrenForMetaModel();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return true;
	}

	private Object[] getChildrenForPartition() {

		final ITreeNode<?>[] children = new ITreeNode<?>[this.childrenAsRootEelements.size()];

		for (int i = 0; i < children.length; i++) {
			if ((this.childrenAsRootEelements.get(i)).is___Alive()) {
				children[i] = new RefObjectNode(this, (RefObject) this.childrenAsRootEelements.get(i));
			}
		}
		return children;
	}

	private Object[] getChildrenForMetaModel() {

		final List<RefObjectNode> childList = new ArrayList<RefObjectNode>();
		final List<Partitionable> partitionables = getProjectNode().getRefPackageToTypesToElements().get(
				((RefPackageNode) getParent()).getValue()).get(getValue());
		if (partitionables != null) {
			for (final Partitionable partitionable : partitionables) {
				if (partitionable instanceof RefObject && partitionable.is___Alive()) {
					childList.add(new RefObjectNode(this, (RefObject) partitionable));
				}
			}
		}

		return childList.toArray(new Object[childList.size()]);
	}

	private ProjectRootNode getProjectNode() {

		ITreeNode<?> currParent = (ITreeNode<?>) getParent();

		while (!(currParent instanceof ProjectRootNode)) {
			currParent = (ITreeNode<?>) currParent.getParent();
		}
		return (ProjectRootNode) currParent;
	}
}
