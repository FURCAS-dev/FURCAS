package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.spi.core.SpiEndAndMetaObject;

/**
 * This class represents a combined key which is immutable. These keys hold an
 * integer representing the end number (starting with 0 for the first end), and
 * a {@link MoinReference} to a meta object, such as an {@link Association} or
 * an {@link Attribute}.
 * <p>
 * Equality and hash code of this class are based on the values of the
 * {@link #getFromEnd()} and {@link #getMetaObject()} attributes. The
 * {@link #getToEnd()} is not contributing to the state of an instance of this
 * class, but is dynamically calculated.
 */
public interface EndAndMetaObject extends SpiEndAndMetaObject {

    /**
     * The metaObject as reference.
     * 
     * @return the metaObject as reference.
     */
    public MoinReference getMetaObject( CoreMoin moin );

    /**
     * Two EndAndMetaObjects are equal if {@link #getFromEnd() fromEnd} and
     * {@link #getMetaObject() metaObject} are equal.
     * 
     * @param o the reference object with which to compare.
     * @return <code>true</code> if this object's
     * {@link #getFromEnd() fromEnd} and {@link #getMetaObject() metaObject} are
     * equal, <code>false</code> otherwise.
     */
    public boolean equals( Object o );

    /**
     * The hash code has to take the {@link #getFromEnd() fromEnd} and
     * {@link #getMetaObject() metaObject} into account.
     * 
     * @return the hash code value for this object which takes into account the
     * {@link #getFromEnd() fromEnd} and {@link #getMetaObject() metaObject}.
     * @see #equals(Object)
     */
    public int hashCode( );

    String getMetaObjectMofId( );

    /**
     * Returns <code>true</code> if the multiplicity of the "fromEnd" has an
     * upper bound of 1.
     */
    public boolean isFromEndMultiplicityOne( CoreConnection connection );

    /**
     * Returns <code>true</code> if the multiplicity of the "toEnd" has an
     * upper bound of 1.
     */
    public boolean isToEndMultiplicityOne( CoreSession session, WorkspaceSet workspaceSet );
}