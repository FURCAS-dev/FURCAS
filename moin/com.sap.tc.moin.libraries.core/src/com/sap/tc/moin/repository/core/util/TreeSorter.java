package com.sap.tc.moin.repository.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.core.ParentRetriever;

/**
 * Given a set of nodes that each specify zero or more parents, computes a
 * sequence that contains all these nodes in such an order that parents precede
 * all of their children.
 * <p>
 * The nodes do not have to implement any specific interface. Instead,
 * resembling the design of the {@link java.util.Comparator}, an object can be
 * provided that knows how to retrieve the parents from the objects contained in
 * the collection that is to be sorted. This object has to implement the
 * {@link ParentRetriever} interface.
 * 
 * @author d043530
 */
public final class TreeSorter<T> {

    /**
     * Initializes a tree sorter with a composition traverser that defines how
     * to obtain the "parent" of an element in the set to be sorted as a tree in
     * "parent-before-child" ordering.
     * 
     * @param parentRetriever the strategy object that can obtain the parent for
     * the elements in the collection to sort, thereby implicitly constructing
     * the tree hierarchy over the collection
     */
    public TreeSorter( ParentRetriever<T> parentRetriever ) {

        this.parentRetriever = parentRetriever;
    }

    /**
     * Given a set of nodes that each specify zero or one parent, computes a
     * sequence that contains all these nodes in such an order that parents
     * precede all of their children.
     * <p>
     * The nodes do not have to implement any specific interface. Instead,
     * resembling the design of the {@link java.util.Comparator}, an object can
     * be provided to the constructor of this class that knows how to retrieve
     * the parents from the objects contained in the collection that is to be
     * sorted. This object has to implement the {@link ParentRetriever}
     * interface.
     * 
     * @param nodes the collection of nodes to be sorted
     * @return the sorted list of nodes from <tt>s</tt>
     */
    public synchronized List<T> sort( Collection<T> nodes ) {

        Set<T> visited = new HashSet<T>( );
        List<T> result = new ArrayList<T>( );
        for ( T node : nodes ) {
            sort( node, nodes, result, visited );
        }
        return result;
    }

    /**
     * The algorithm for sorting the tree nodes uses a depth-first-search along
     * the {@link ParentRetriever#getCompositionParent(Object)} relation. When a
     * node has already been visited, it is not visited again. Otherwise, the
     * node's subtree is recursively traversed. After that, the node is appended
     * to the end of the <tt>result</tt> list. This ensures that all parents
     * occur before their children.
     * <p>
     * The parent retriever (see {@link ParentRetriever}) stored in
     * {@link #parentRetriever} is used. The result contains parents before
     * their children.
     * 
     * @param node the node to append to <tt>result</tt> with all its parents
     * @param allNodes Only nodes contained in this collection will be added to
     * the result, no matter what parents are listed by the
     * {@link ParentRetriever}.
     * @param result Nodes will be appended to this list in sorted order
     * @param visited remembers the instances already visited to avoid endless
     * recursion
     */
    private synchronized void sort( T node, Collection<T> allNodes, List<T> result, Set<T> visited ) {

        if ( !visited.contains( node ) ) {
            visited.add( node );
            T parent = this.parentRetriever.getCompositionParent( node );
            if ( allNodes.contains( parent ) ) {
                sort( parent, allNodes, result, visited );
            }
            result.add( node );
        }
    }

    // ---------------------- attributes ---------------------
    /**
     * Defines the tree structure for the nodes to be sorted.
     */
    private ParentRetriever<T> parentRetriever;
}