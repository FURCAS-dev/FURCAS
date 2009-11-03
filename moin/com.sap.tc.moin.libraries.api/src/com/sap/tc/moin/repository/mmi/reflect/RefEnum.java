package com.sap.tc.moin.repository.mmi.reflect;

import java.io.Serializable;
import java.util.List;

/**
 * The reflective interface for enumerations. It provides generic operations for
 * querying the enumeration.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RefEnum extends Serializable {

    /**
     * Returns the enumeration literal.
     * 
     * @return the enumeration literal.
     */
    public String toString( );

    /**
     * This operation returns the fully qualified name of the enumeration
     * object's metaobject.
     * <p>
     * The Collection returned from this operation has copy semantics. That is,
     * it does not reflect any changes to the source after the operation is
     * executed, and it cannot be used to update the source.
     * 
     * @return the fully qualified name of the enumeration object's metaobject.
     */
    public List<java.lang.String> refTypeName( );

    /**
     * Compares the enumeration object with another object. The comparison for
     * enumerations is based on literal value. If two enumerations are of the
     * same type and represent the same literal, then they are equal.
     * 
     * @param other the other enumeration
     * @return true if this object and <code>other</code> are of the same type
     * and represent the same literal.
     */
    public boolean equals( Object other );
}
