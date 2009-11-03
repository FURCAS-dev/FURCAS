/**
 * 
 */
package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.LRI;

/**
 * @author d024032
 *<p>
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface AttributeMultiValueEvent extends AttributeValueEvent {

    /**
     * If the attribute has an upper cardinality of 1 or if it is not ordered,
     * the position will always be -1;
     * 
     * @return the position of the value in the list of values
     */
    public int getPosition( );

    /**
     * The type of the value depends on the meta attribute. If the attribute is
     * primitive typed, a java wrapper (e.g. {@link java.lang.Integer}) will be
     * returned. If the attribute is object valued, the return value will be of
     * type {@link LRI}.
     * 
     * @return the removed value
     */

    public Object getValue( );
}
