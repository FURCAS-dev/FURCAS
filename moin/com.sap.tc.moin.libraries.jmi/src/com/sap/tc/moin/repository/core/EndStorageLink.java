package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.spi.core.SpiLink;

public interface EndStorageLink extends SpiLink {

    public MoinReference getEnd( int endNumber );

    public MriReference getStorageEnd( );

    public MoinReference getOtherEnd( );

    /**
     * Tells if this link tolerates another link in the same link set that is
     * equal to this link. This fact is determined based on the uniqueness as
     * requested by the {@link #getMetaObject meta object} of this link. For
     * links for associations, this operation should always return
     * <tt>false</tt> due to MOF 1.4 constraint C-40. For attributes,
     * uniqueness can be <tt>false</tt>, meaning that this operation may
     * return <tt>true</tt> because for those attributes it is permissible to
     * have two links that are "instance of" the same attribute and have equal
     * ends.
     */
    public boolean canHaveDuplicates( );

    /**
     * Retrieves the object from the metamodel that holds metadata about this
     * link. The type of the metaobject depends on the concrete subclass (e.g.,
     * an attribute or an association). This information can, e.g., be used to
     * group links for the same metaobject.
     */
    public RefObject getMetaObject( );

    /**
     * Obtains the upper bound of the multiplicity of end <tt>end</tt>
     * 
     * @return the upper bound of the multiplicity of end <tt>end</tt>.
     * <tt>-1</tt> means unbounded.
     */
    public int getUpperBound( CoreSession session, int end );

    /**
     * Checks if the upper multiplicity of the <tt>end</tt> is <tt>1</tt>.
     */
    public boolean isUpperMultiplicityOne( CoreSession session, int end );

    /**
     * Determines which end of this link represents a composite, owning the
     * element(s) at the other end(s). This is particularly important in order
     * to find out if adding / removing this link may have an impact on
     * partitioning and delete propagation.
     * 
     * @return <tt>-1</tt>, if none of the ends is composite; otherwise the
     * index of the end (can be used as index into the result of calling
     * {@link #getEnds()}) that is the composite owner of the other end(s).
     */
    public int getCompositeEnd( );

    /**
     * Determines which end of this link represents a composed end, being owned
     * by other end. This is particularly important in order to find out if
     * adding / removing this link may have an impact on partitioning and delete
     * propagation.
     * 
     * @return <tt>-1</tt>, if none of the ends is composite; otherwise the
     * index of the end (can be used as index into the result of calling
     * {@link #getEnds()}) that is the composed end.
     */
    public int getComponentEnd( );

    public boolean isStorageEnd( int endNumber );

    public boolean isOtherEnd( int endNumber );

    /**
     * Tells which of the ends of the link is ordered. This is determined by the
     * link's {@link #getMetaObject()}. If none of the ends is ordered,
     * <tt>-1</tt> is returned.
     * 
     * @return the index of the end that is ordered, starting with <tt>0</tt>,
     * or <tt>-1</tt> if none of the ends is ordered.
     */
    public int getOrderedEnd( );

    /**
     * Returns the responsible memory link manager for this link. Responsible
     * means the link manager of the workspace the
     * {@link #getStorageEnd() storage end} belongs to.
     * <p>
     * Attention: if the {@link #getStorageEnd() storage end} is not resolved,
     * it will be by this call!
     * 
     * @return the responsible memory link manager for this link.
     */
    public MemoryLinkManager getMemoryLinkManager( CoreConnection connection );

    /**
     * Compares two links but does not consider Java identity if duplicates are
     * allowed. The regular {@link #equals(Object)} considers Java identity in
     * case duplicates are allowed. This operation is currently used for
     * maintaining the composite parent information of an element where repeated
     * addition of the same element must not result in mulitple entries with the
     * same parent.
     * 
     * @param o
     * @return
     */
    public boolean logicalEquals( Object o );

    /**
     * Returns the element at the specified end and informs the inconsistency
     * registry if the element cannot be resolved.
     * 
     * @param session
     * @param endNumber number of the end to be returned
     * @return the element at the specified end number
     */
    public CorePartitionable getElementAtEnd( CoreSession session, int endNumber );
}
