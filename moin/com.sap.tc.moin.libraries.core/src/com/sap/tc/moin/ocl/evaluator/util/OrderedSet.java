package com.sap.tc.moin.ocl.evaluator.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;

/**
 * An <code>OrderedSet</code> is a {@link Set} that keeps track of the order 
 * that elements are added. Elements can be retrieved by 
 * {@link #get(int) index}, or {@link #iterator() iterated} over in the order
 * that they were added.
 */
public interface OrderedSet extends Set<OclAny> {

    /**
     * Add <code>element</code> to the end of this OrderedSet. If the element 
     * already exists, the OrderedSet does not change, and this method returns 
     * <code>false</code>.
     * 
     * @return <code>true</code> if the collection changes
     * @throws NullPointerException Thrown if <code>element</code> is 
     *         <code>null</code>.
     */
    public boolean add( OclAny o );

    /**
     * Add <code>element</code> to the <code>index</code> position in this
     * OrderedSet, and increment the position of all elements previously at or 
     * after this position. If the element already exists, the OrderedSet does 
     * not change, and this method returns <code>false</code>.
     * 
     * @param index the index
     * @param element the object to add
     * 
     * @return <code>true</code> if the collection changes. 
     * @throws IndexOutOfBoundsException Thrown if <code>index &lt; 0</code> or
     *         <code>index &gt; size()</code>.
     * @throws NullPointerException Thrown if <code>element</code> is 
     *         <code>null</code>.
     */
    public boolean add( int index, OclAny element );

    /**     
     * Add all of the elements from the supplied <code>collection</code> in the 
     * order that they are returned from the collection's iterator.
     * 
     * @param collection the collection to add
     * @return true if the set was changed as a result of the add operation
     * 
     * @throws NullPointerException Thrown if <code>collection</code> or any of
     *         its contained elements is <code>null</code>.
     */
    public boolean addAll( Collection<? extends OclAny> collection );

    /**
     * Returns the element at the position whose <code>index</code> is supplied.
     * 
     * @param index the index
     * @return the object at that index
     * 
     * @throws IndexOutOfBoundsException Thrown if <code>index &lt; 0</code> or
     *         <code>index &gt; size()</code>.
     */
    public OclAny get( int index );

    /**
     * Returns the position that the supplied <code>element</code> appears in 
     * this OrderedSet, or -1 if the element doesn't exist in the set.
     * 
     * @param element the object
     * @return the index
     */
    public int indexOf( Object element );

    /** 
     * Returns an iterator over this OrderedSet, which returns elements in the
     * order that they were added. 
     */
    public Iterator<OclAny> iterator( );

    /**
     * Returns a new OrderedSet containing the ordered set of elements between
     * the two supplied positions of this OrderedSet.
     * 
     * @param fromIndex The starting position to return the sub-OrderedSet from
     *        (inclusive)
     * @param toIndex The end position to return the sub-OrderedSet from
     *        (exclusive)
     * @return the subset
     * @throws IndexOutOfBoundsException Thrown if <code>fromIndex &lt; 0</code> 
     *         or <code>toIndex &gt; size()</code> or 
     *         <code>fromIndex &gt; toIndex</code>.
     */
    public OrderedSet subOrderedSet( int fromIndex, int toIndex );

    /**
     * This method has the same contract as {@link Set#equals(java.lang.Object)}
     * 
     * <b>NOTE:</b> This means that two sets with the same contents are still 
     * considered equal, even if they have a different order. This may not be
     * intuitive, however, it is consistent with sections 11.7.2 and 11.7.3 of 
     * the UML 2.0 OCL spec, which implies that the equals method for an 
     * OrderedSet is inherited from Set.
     */
    public boolean equals( Object o );
}
