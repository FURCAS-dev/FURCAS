package com.sap.mi.fwk.ui.tree.provider;

import org.eclipse.jface.viewers.ITreeContentProvider;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * A content provider that supports elements of type <code>ITreeNode</code>.
 * Methods {@link #getChildren(Object)} and {@link #hasChildren(Object)}
 * delegate to <code>ITreeNode</code> if such an instance is passed in.
 * 
 * @see TreeNode
 * @author d022960
 * 
 */
public abstract class TreeNodeContentProviderBase implements ITreeContentProvider {

	/**
	 * Delegates to {@link ITreeNode#hasChildren()} if the passed object is of
	 * type <code>ITreeNode</code>, otherwise this method returns
	 * <code>true</code> in order to ensure that the expansion icon is shown.
	 * <p>
	 * Clients may overwrite this method in case they are dealing with children
	 * that are not child aware.
	 * </p>
	 * 
	 * @param element
	 *            {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	public boolean hasChildren(final Object element) {
		if (element instanceof ITreeNode<?>) {
			return ((ITreeNode<?>) element).hasChildren();
		}
		return true;
	}

	/**
	 * Delegates to {@link ITreeNode#getChildren()} if the passed object is of
	 * type <code>ITreeNode</code>, otherwise this method returns an empty
	 * array.
	 * <p>
	 * Clients have to overwrite this method in order to provide the children
	 * for the root element.
	 * </p>
	 * 
	 * @param parentElement
	 *            {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof ITreeNode<?>) {
			return ((ITreeNode<?>) parentElement).getChildren();
		}
		return ITreeNode.EMPTY_ARRAY;
	}

	/**
	 * Delegates to {@link ITreeNode#getParent()} if the passed object is of
	 * type <code>ITreeNode</code>, otherwise returns null in order to indicate
	 * that this node is a root node and does not have a parent.
	 * 
	 * @see TreeNode#TreeNode(Object) for further details
	 * 
	 *      <p>
	 *      Clients may overwrite this method in order to compute the parent in
	 *      some other way.
	 *      </p>
	 * @param element
	 *            {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	public Object getParent(final Object element) {
		if (element instanceof ITreeNode<?>) {
			return ((ITreeNode<?>) element).getParent();
		}
		return null;
	}

	/**
	 * Delegates to {@link ITreeNode#getChildren()} iif such an instance is
	 * passed in. Otherwise returns an empty array.
	 * <p>
	 * Note: This method is not called by the Common Navigator framework.
	 * </p>
	 * 
	 * @param inputElement
	 *            {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	public Object[] getElements(final Object inputElement) {
		return getChildren(inputElement);
	}
}