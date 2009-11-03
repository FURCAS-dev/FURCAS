package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;

/**
 * An ElementChangeEvent indicates a change to the state of the affected
 * Element. The element was either created, deleted, or changed.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @see com.sap.tc.moin.repository.events.type.ModelChangeEvent
 * @see com.sap.tc.moin.repository.events.type.ElementCreateEvent
 * @see com.sap.tc.moin.repository.events.type.ElementDeleteEvent
 * @see com.sap.tc.moin.repository.events.type.AttributeValueEvent
 * @author Daniel Vocke (D044825)
 */

public interface ElementChangeEvent extends ModelChangeEvent {

    /**
     * If the type of the event is {@link ElementCreateEvent}or
     * {@link ElementDeleteEvent}, the {@link #getAffectedElementMri()} method
     * will return a reference to the added/removed element. If the event is of
     * type AttributeValueEvent, the method will return a reference to the
     * composite parent of the attribute. According to the MOF-specification,
     * classifier scoped attributes are contained in the corresponding class
     * proxy. This is the reason for the return type
     * {@link com.sap.tc.moin.repository.mmi.reflect.RefFeatured}. Note, that the reference is passed
     * as MRI which points to the affected element.
     * 
     * @return an MRI pointing to the affected Element
     */
    public MRI getAffectedElementMri( );

    /**
     * resolves the element that can be retrieved using the
     * {@link #getAffectedElementMri()}method.
     * 
     * @param resolvingConnection the connection used to resolve the LRI
     * @return the changed element or <code>null</code> if the LRI could not be
     * resolved
     */
    public RefObject getAffectedElement( Connection resolvingConnection );
}