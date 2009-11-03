package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.LRI;

/**
 * AttributeValueChangeEvents indicate changes to MOF attributes. This event is
 * not fired when "derived" Attributes change their value. Derived attributes
 * typically depend on other attribute values. In these cases events are fired
 * when the non-derived attributes change.
 * <p>
 * This interface is not intended to be implemented by clients.
 * 
 * @author Daniel Vocke (D044825)
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface AttributeValueChangeEvent extends AttributeValueEvent {

    /**
     * The type of the returned value depends on the meta attribute. If the
     * attribute is primitive typed, a java wrapper (e.g.
     * {@link java.lang.Integer}) will be returned. If the attribute is object
     * valued, the return value will be of type {@link LRI}. Clients must be
     * aware of null values if the meta element has a cardinality of 0..1!
     * 
     * @return the value of the attribute before it was/will be changed
     */

    public Object getOldValue( );

    /**
     * The type of the returned value depends on the meta attribute. If the
     * attribute is primitive typed, a java wrapper (e.g.
     * {@link java.lang.Integer}) will be returned. If the attribute is object
     * valued, the return value will be of type {@link LRI}. Clients must be
     * aware of null values if the meta element has a cardinality of 0..1!
     * 
     * @return the value of the attribute after it was/will be changed
     */
    public Object getNewValue( );
}