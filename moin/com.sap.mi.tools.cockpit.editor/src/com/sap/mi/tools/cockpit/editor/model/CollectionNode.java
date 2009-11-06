package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * A node for representing collections in the Model Browser tree. The children of this node contain the contents of the collection.
 * 
 * @author d003456
 * 
 */
public class CollectionNode extends TreeNode<CollectionData> implements ITreeNodeLabelAware {

	/**
	 * Creates {@link CollectionNode}.
	 * 
	 * @param parentNode
	 * @param data
	 */
	public CollectionNode(ITreeNode<?> parentNode, CollectionData data) {

		super(parentNode, data);
		Assert.isNotNull(getParent());
		Assert.isNotNull(getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public final Object[] getChildren() {

		final ITreeNode<?>[] children = new ITreeNode[getValue().getCollection().size()];

		final List<Object> childValueList = new ArrayList<Object>(getValue().getCollection());

		for (int i = 0; i < children.length; i++) {
			final Object o = childValueList.get(i);
			if (o == null) {
				// dangling link is possible!
				children[i] = new LiteralNode(this, MOINBrowserLabelProvider.NULL_VALUE);

			}
			else if (o instanceof RefObject) {
				children[i] = new RefObjectNode(this, (RefObject) o);

			}
			else {
				children[i] = new LiteralNode(this, o.toString());
			}
		}
		return children;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return getChildren().length > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		return getValue().getName();
	}

}