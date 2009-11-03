package com.sap.ide.cts.parser.incremental.util;

import java.util.List;

import com.sap.ide.cts.parser.incremental.util.TarjansLCA.Node;

/**
 * This interface is used to communicate with the Least Common Ancestor
 * algorithm of Tarjan {@link TarjansLCA}. Implement this to provide access to
 * the children of nodes within the tree that is going to be searched for the
 * least common ancestor.
 * 
 * @author C5106462
 * 
 * @param <T>
 *            The type of elements in the tree.
 */
public interface ITarjanTreeContentProvider<T> {
	
	/**
	 * Retrieve the child nodes of the given <code>node</code>.
	 * @param node
	 * @return all direct children of the node.
	 */
	public List<Node<T>> getChildren(Node<T> node);
}
