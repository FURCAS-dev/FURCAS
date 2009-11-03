package com.sap.tc.moin.repository.core.xmi.reader.parser;

import com.sap.tc.moin.repository.core.xmi.reader.InstanceInfo;

/**
 * Instances of this class represent a reference to a not yet completely read instance. It is linked to an owner which
 * must implement the {@link com.sap.tc.moin.repository.core.xmi.reader.parser.UnresolvedReferencesCounter} interface. It
 * can be registered in the {@link com.sap.tc.moin.repository.core.xmi.reader.parser.XmiContext}, see
 * {@link com.sap.tc.moin.repository.core.xmi.reader.parser.XmiContext#registerUnresolvedRef(String, UnresolvedReference)}.
 * As soon as the desired instance is complete and put into the context by calling
 * {@link com.sap.tc.moin.repository.core.xmi.reader.parser.XmiContext#instanceComplete(String, InstanceInfo)},
 * {@link #referenceResolved(Object)} is called, which decreases the owner's counter of unresolved references.
 */
public class UnresolvedReference {

    // when resolved, stores the resolved value
    private Object value = null;

    // owner of this unresolved reference
    private UnresolvedReferencesCounter owner;

    /**
     * Creates an UnresolvedReference with no owner. The owner can be set later by calling
     * {@link #setOwner(UnresolvedReferencesCounter)}.
     */
    public UnresolvedReference( ) {

    }

    public UnresolvedReference( UnresolvedReferencesCounter owningElement ) {

        setOwner( owningElement );
    }

    public void referenceResolved( Object value ) {

        this.value = value;
        if ( owner != null ) {
            owner.decreaseUnresolvedRefs( );
        }
    }

    public Object getValue( ) {

        return value;
    }

    public void setOwner( UnresolvedReferencesCounter owningElement ) {

        owner = owningElement;
        owner.increaseUnresolvedRefs( );
    }
}