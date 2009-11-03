package com.sap.mi.fwk.ui.tree.nodes;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.viewers.ITreeContentProvider;

import com.sap.mi.fwk.ui.internal.tree.TreeNodeMarkerSupport;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeContentProviderBase;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

/**
 * A simple data structure that is useful for implementing tree models. If and
 * only if <code>isChildAware()</code> returns <code>true</code>, the methods
 * {@link TreeNodeContentProviderBase#getChildren(Object)} and
 * {@link TreeNodeContentProviderBase#hasChildren(Object)} will delegate to
 * {@link ITreeNode#getChildren()} and {@link ITreeNode#hasChildren()}. <br>
 * The method {@link TreeNodeContentProviderBase#getParent(Object)} will always
 * delegate in case Object is of type <code>ITreeNode</code>.
 * <p>
 * Clients should always use <code>instanceof ITreeNode</code> instead of using
 * <code>instanceof TreeNode</code> directly.
 * </p>
 * 
 * @author d022960
 * @author d024127
 * 
 * @param <T>
 *            the java type of the value wrapped by this tree node
 */
public abstract class TreeNode<T> extends PlatformObject implements ITreeNode<T> {

	/**
	 * The parent of this node or null if it is a root node
	 */
	private Object parent = null;

	/**
	 * Utility class for marker support
	 */
	private TreeNodeMarkerSupport markerSupport = null;

	/**
	 * The value to store in this tree node instance
	 */
	private T value = null;

	/**
	 * Creates a new node without providing the parent. If the node logically
	 * has a parent it should be calculated internally and set using
	 * {@link #setParent()}. A node that does not have a parent is a root node
	 * of the corresponding tree.
	 * 
	 * @see {@link #setParent()} for further details
	 * 
	 * @param value
	 *            the value wrapped by this node, must not be null
	 * @exception IllegalArgumentException
	 *                if <code>value</code> is null
	 */
	protected TreeNode(final T value) {
		this(null, value);
	}

	/**
	 * Creates a new node
	 * 
	 * @param parent
	 *            the parent of this node, might be null
	 * @param value
	 *            the value wrapped by this node, must not be null
	 * @exception IllegalArgumentException
	 *                if <code>value</code> is null
	 */
	protected TreeNode(final Object parent, final T value) {
		Assert.isLegal(value != null, "The tree node value must not be null"); //$NON-NLS-1$
		this.value = value;
		this.parent = parent;
	}

	/**
	 * Returns this node's parent or null if this node has no parent.
	 * 
	 * @return this node's parent, or null if this node has no parent
	 * @see #setParent(Object)
	 */
	public final Object getParent() {
		return this.parent;
	}

	/**
	 * Sub classes may call this method in order to initialize the parent for
	 * this tree node after construction.<br>
	 * Typically tree nodes provide two constructors, first
	 * <code>MyNode(Object parent, T value)</code> and second
	 * <code>MyNode(T value)</code>. The second constructor has to calculate the
	 * logical parent node first and pass it to {@link #setParent(Object)}. <br>
	 * The second constructor might be used in the following scenarios:
	 * <p>
	 * 1. When linking an editor to a node in the explorer tree using the 'Link
	 * with Editor' feature of the Common Navigator Framework.
	 * 
	 * <pre>
	 * public IStructuredSelection findSelection(IEditorInput editorInput) {
	 *   if (editorInput instanceof ModelEditorInput) {
	 *     if (editorInput.exists()) {
	 *       ModelEditorInput modelEditorInput = (ModelEditorInput) editorInput;
	 *       RefBaseObject modelElement = (RefBaseObject) modelEditorInput.getRefObject();
	 *       if (modelElement instanceof SimpleInterface) {
	 *         &lt;b&gt;NodeInterface node = new NodeInterface((SimpleInterface) modelElement);&lt;/b&gt;
	 *         return new StructuredSelection(node);
	 *         ...
	 * </pre>
	 * 
	 * 2. Another frequent scenario is a content outline showing a tree which
	 * keeps track with the selection of the active editor.
	 * 
	 * <pre>
	 * public Object getParent(Object element) {
	 *   if (element instanceof SimpleInterface) {
	 *     &lt;b&gt;NodeInterface node = new NodeInterface((SimpleInterface) element);&lt;/b&gt;
	 *     return node;
	 *     ...
	 * </pre>
	 * 
	 * The following is valid for both scenarios: <br>
	 * In case the SWT Tree does not find a <code>TreeItem</code> that maps to
	 * the corresponding tree node (determined by calling
	 * {@link #equals(Object)}) - e.g. when trying to reveal the existing
	 * selection after the tree has been refreshed - the tree will call
	 * {@link ITreeContentProvider#getParent(Object)} in order to determine the
	 * reverse path - from the selected object to the root of the tree. If all
	 * tree nodes return the proper parent, the
	 * {@link ITreeContentProvider#getParent(Object)} implementation can simply
	 * delegate to {@link #getParent()}. This is the default implementation of
	 * {@link TreeNodeContentProviderBase#getParent(Object)}. The default
	 * implementation of {@link #equals(Object)} will return correct result,
	 * e.g. <code>false</code> if called for tree nodes with different
	 * hierarchies.
	 * 
	 * @param parent
	 *            the parent of this tree node.
	 */
	protected final void setParent(final Object parent) {
		this.parent = parent;
	}

	/**
	 * Returns the value wrapped by this tree node
	 */
	public final T getValue() {
		return value;
	}

	/**
	 * Returns an object which is an instance of the given class or
	 * <code>null</code> if no such object can be found. <br>
	 * This class supports adaptation to {@link Connection} in case the wrapped
	 * value is of type {@link Partitionable}.<br>
	 * 
	 * @param adapter
	 *            the class to adapt to
	 * @return the adapted object or <code>null</code>
	 * @see IAdaptable#getAdapter(Class)
	 * @see PlatformObject#getAdapter(Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(TreeNodeMarkerSupport.class)) {
			synchronized (this) {
				if (markerSupport == null) {
					markerSupport = new TreeNodeMarkerSupport();
				}
				return markerSupport;
			}
		}
		if (adapter.equals(Connection.class)) {
			if (value instanceof Partitionable) {
				return ((Partitionable) value).get___Connection();
			}
		}
		return super.getAdapter(adapter);
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * <p>
	 * 
	 * @return returns true if
	 * 
	 * 
	 *         this and obj are &lt;code&gt;==&lt;/code&gt;
	 * 
	 *         false if obj is not an instance of {@link ITreeNode}, the classes
	 *         of the two objects are different, or the values are different the
	 *         parents are different
	 */
	@Override
	public boolean equals(final Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof ITreeNode)) {
			return false;
		}

		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}

		TreeNode otherNode = (TreeNode) obj;
		Object parent = otherNode.getParent();

		// constructor ensures that mValue is not null
		if (!this.value.equals(otherNode.getValue())) {
			return false;
		}

		if (parent != null) {
			if (!parent.equals(getParent())) {
				return false;
			}
		} else {
			if (getParent() != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @see #equals(Object)
	 */
	@Override
	public int hashCode() {
		int h = this.getClass().hashCode();
		// value cannot be null due to assert in constructor
		h += 13 * 17 * value.hashCode();

		// using higher primes
		if (getParent() != null) {
			h += 101 * 191 * getParent().hashCode();
		}
		return 37 * h;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(512);
		builder.append("Tree node: "); //$NON-NLS-1$
		builder.append(super.toString());
		builder.append(", value: "); //$NON-NLS-1$
		builder.append(value.toString());
		return builder.toString();
	}
}