package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;

/**
 * Abstract mock event
 */
public abstract class ElementChangeEventImpl extends ModelChangeEventImpl implements ElementChangeEvent {

    protected RefObject affectedElement;

    protected MRI affElemMRI;

    protected MRI affMetaMRI;

    /**
     * @param affectedElement
     */
    public ElementChangeEventImpl( CoreConnection connection, RefObject affectedElement ) {

        super( connection );
        this.affectedElement = affectedElement;
        this.affElemMRI = new MRIImpl( affectedElement );
        this.affMetaMRI = new MRIImpl( affectedElement.refMetaObject( ) );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ElementChangeEvent#getAffectedElementMri()
     */
    public MRI getAffectedElementMri( ) {

        return this.affElemMRI;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ElementChangeEvent#getAffectedElement(com.sap.tc.moin.repository.core.Connection)
     */
    public RefObject getAffectedElement( @SuppressWarnings( "unused" )
    Connection resolvingConnection ) {

        return this.affectedElement;
    }

}
