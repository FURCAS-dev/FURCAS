package com.sap.mi.fwk.ui.tree.nodes;

import org.eclipse.core.runtime.IAdaptable;

import com.sap.mi.fwk.ui.internal.tree.HourglassTreeNode;

/**
 * A simple interface that is useful for implementing tree models. It holds a
 * reference to the logical parent and to the underlying value. It allows simple
 * delegation of methods from
 * {@link org.eclipse.jface.viewers.ITreeContentProvider} such as
 * {@link org.eclipse.jface.viewers.ITreeContentProvider#getChildren(Object)},
 * {@link org.eclipse.jface.viewers.ITreeContentProvider#getParent(Object)} and
 * {@link org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(Object)}
 * <p>
 * This interface is not intended to be implemented by clients. Clients have to
 * extend {@link TreeNode} instead.
 * </p>
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 *              Clients should instead subclass one of the classes that
 *              implement this interface. Note that direct implementers of this
 *              interface outside of the framework will be broken in future
 *              releases when methods are added to this interface.
 * 
 * @see TreeNode
 * 
 * @author d022960
 * 
 * @param <T>
 *            the java type of the value wrapped by this tree node
 */
public interface ITreeNode<T> extends IAdaptable {

	/**
	 * A tree node acting as a placeholder that is displayed until connection is
	 * available and tree can be refreshed.
	 */
	public static final ITreeNode LOADING_DATA_NODE = new HourglassTreeNode();

	/**
	 * Constant representing an empty object array.
	 */
	public static final ITreeNode[] EMPTY_ARRAY = new ITreeNode[0];

	/**
	 * Returns the parent of this node, or <code>null</code> indicating that
	 * either this node is a root node or that the parent can't be computed. In
	 * the latter case the tree-structured viewer can't expand a given node
	 * correctly if requested.
	 * 
	 * @return the parent element, or <code>null</code> if it has none or if
	 *         the parent cannot be computed
	 */
	Object getParent();

	/**
	 * Returns the value held by this node.
	 * 
	 * @return The value; may be anything.
	 */
	T getValue();

	/**
	 * Returns the child elements of this node. Implementations must not return
	 * <code>null</code>. Use {@link #EMPTY_ARRAY} instead.
	 * 
	 * @return an array of child elements
	 */
	Object[] getChildren();

	/**
	 * Distinguishes whether this node has children.
	 * <p>
	 * Intended as an optimization in case the viewer does not need the actual
	 * children. Clients may be able to implement this more efficiently than
	 * <code>getChildren</code>.
	 * </p>
	 * 
	 * @return <code>true</code> if this node has children, and
	 *         <code>false</code> if it has no children
	 */
	boolean hasChildren();

	/**
	 * Distinguishes whether this node knows, calculates and exposes its own
	 * children or not.
	 * 
	 * @return A value of <code>true</code> indicates that the node is capable
	 *         for calculating its children. <code>false</code> means that the
	 *         node is not able to compute its children. Calculation has to be
	 *         done in {@link ITreeContentProvider#getChildren(Object)} instead.
	 *         Clients have to check this flag in order to decide whether they
	 *         could delegate to {@link #hasChildren()}, {@link #getChildren()}
	 *         or {@link #getParent()}.
	 *
	 *@deprecated use {@link #hasChildren()} instead
	 */
//	boolean isChildAware();
}
