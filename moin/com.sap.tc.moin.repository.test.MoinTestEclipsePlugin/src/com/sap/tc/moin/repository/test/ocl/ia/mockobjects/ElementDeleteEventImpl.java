package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;

/**
 * Mock Element Delete Event
 */
public class ElementDeleteEventImpl extends ElementChangeEventImpl implements ElementDeleteEvent {

    private MRI metaObjectMri;

    /**
     * @param affectedElement
     */
    public ElementDeleteEventImpl( CoreConnection connection, RefObject affectedElement ) {

        super( connection, affectedElement );
        this.metaObjectMri = new MRIImpl( affectedElement.refMetaObject( ) );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ElementDeleteEvent#getMetaObjectMRI()
     */
    public MRI getMetaObjectMri( ) {

        return this.metaObjectMri;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ElementDeleteEvent#getMetaObject(com.sap.tc.moin.repository.core.Connection)
     */
    public RefObject getMetaObject( @SuppressWarnings( "unused" )
    Connection resolvingConnection ) {

        return this.affectedElement.refMetaObject( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ElementDeleteEvent#getXmiRepresentation()
     */
    public String getXmiRepresentation( ) {

        return "";
    }

}
