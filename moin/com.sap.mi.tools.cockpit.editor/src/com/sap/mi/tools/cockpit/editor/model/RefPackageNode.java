package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * @author d003456
 * 
 */
public class RefPackageNode extends TreeNode<RefPackage> implements ITreeNodeLabelAware{

	private final VIEWER_MODE mode;

	/**
	 * Creates {@link RefPackageNode}.
	 * 
	 * @param parent
	 * @param refPackage
	 */
	public RefPackageNode(ITreeNode<?> parent, RefPackage refPackage, VIEWER_MODE mode) {

		super(parent, refPackage);
		this.mode = mode;
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
	}

	/* (non-Javadoc)
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		final List<ITreeNode<?>> childList = new ArrayList<ITreeNode<?>>();

		final List<RefPackage> packages = getProjectNode().getPackageHierarchy().get(getValue());
		if (packages != null) {
			for (final RefPackage refPackage : packages) {
				childList.add(new RefPackageNode(this, refPackage, this.mode));
			}
		}

		final TreeMap<ModelElement, List<Partitionable>> partitionableProType = getProjectNode().getRefPackageToTypesToElements().get(
				this.getValue());

		if (partitionableProType != null) {
			for (final Map.Entry<ModelElement, List<Partitionable>> e : partitionableProType.entrySet()) {
				childList.add(new TypeNode(this, e.getKey(), this.mode));
			}
		}

		return childList.toArray(new Object[childList.size()]);

	}

	/* (non-Javadoc)
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return true;
	}

	/* (non-Javadoc)
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		return ((ModelElement) (getValue()).refMetaObject()).getName();
	}

	private ProjectRootNode getProjectNode() {

		ITreeNode<?> currParent = (ITreeNode<?>) getParent();

		while (!(currParent instanceof ProjectRootNode)) {
			currParent = (ITreeNode<?>) currParent.getParent();
		}
		return (ProjectRootNode) currParent;
	}
}
