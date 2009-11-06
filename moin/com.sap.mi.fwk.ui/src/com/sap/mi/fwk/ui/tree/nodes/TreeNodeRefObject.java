package com.sap.mi.fwk.ui.tree.nodes;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * This class is intended for tree node implementations that logically represent a model object of a specific type. They
 * can be adapted to type {@link RefObject} and {@link Connection}.
 * <p>
 * Example: Assume the following tree structure:<br>
 * 
 * <pre>
 * InterfacesTreeNode (structural node)         instanceof TreeNode&lt;IProject&gt;
 * NodeSimpleComponent                          instanceof TreeNodeRefObject&lt;SimpleComponent&gt; adapts to RefObject 'SimpleComponent'
 *   - NodeRequiredInterfaces (structural node) instanceof TreeNode&lt;SimpleComponent&gt;
 *     - NodeInterface                          instanceof TreeNodeRefObject&lt;SimpleInterface&gt;
 *   - NodeProvidedInterfaces (structural node) instanceof TreeNode&lt;SimpleComponent&gt;
 *     - NodeInterface                          instanceof TreeNodeRefObject&lt;SimpleInterface&gt;
 *   - NodeSimpleComponent                      instanceof TreeNodeRefObject&lt;SimpleComponent&gt; adapts to RefObject 'SimpleComponent'
 *    	- ... recursive
 * </pre>
 * 
 * </p>
 * Clients should always use <code>instanceof ITreeNodeRefObject</code> instead of using
 * <code>instanceof TreeNodeRefObject</code>directly.
 * 
 * @author d022960
 * 
 * @param <T>
 *            the java type of the value wrapped by this tree node
 */
public abstract class TreeNodeRefObject<T extends RefObject> extends TreeNode<T> implements ITreeNodeRefObject<T> {

	protected TreeNodeRefObject(final T modelElement) {
		super(modelElement);
	}

	protected TreeNodeRefObject(final Object parent, final T modelElement) {
		super(parent, modelElement);
	}

	/**
	 * Returns an object which is an instance of the given class or <code>null</code> if no such object can be found. <br>
	 * This class supports adaption to {@link Connection} and to {@link RefObject} - including super classes of
	 * <code>RefObject</code>. It also allows accessing the underlying value defined by &lt;T&gt;. Adaption requests
	 * that could not be handled by this class are delegated to {@link TreeNode}.
	 * 
	 */
	@Override
	public Object getAdapter(final Class adapter) {
		final T modelElement = getValue();
		if (adapter.isInstance(modelElement)) {
			return modelElement;
		}
		if (adapter.equals(RefObject.class)) {
			return modelElement;
		}
		if (adapter.equals(Connection.class)) {
			return getConnection();
		}
		

		return super.getAdapter(adapter);
	}

	protected final Connection getConnection() {
		return ((Partitionable) getValue()).get___Connection();
	}
}
