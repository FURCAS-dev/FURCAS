package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;

/**
 * Mock Element Create Event
 */
public class ElementCreateEventImpl extends ElementChangeEventImpl implements ElementCreateEvent {

    /**
     * @param affectedElement
     */
    public ElementCreateEventImpl( CoreConnection connection, RefObject affectedElement ) {

        super( connection, affectedElement );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.repository.events.type.ElementCreateEvent#getMetaObjectMri()
     */
    public MRI getMetaObjectMri( ) {

        return affMetaMRI;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.repository.events.type.ElementLifeCycleEvent#getMetaObject(com.sap.tc.moin.repository.Connection)
     */
    public RefObject getMetaObject( Connection resolvingConnection ) {

        return (RefObject) resolvingConnection.getElement( affMetaMRI );
    }

}
