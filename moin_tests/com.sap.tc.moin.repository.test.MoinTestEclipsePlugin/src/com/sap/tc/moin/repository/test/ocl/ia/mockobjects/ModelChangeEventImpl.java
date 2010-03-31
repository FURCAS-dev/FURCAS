package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import java.util.Date;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.ListenerTypeEnum;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;

/**
 * The abstract super class for all the mock events
 * 
 * @author d022737
 */
public abstract class ModelChangeEventImpl implements ModelChangeEvent {

    public CoreConnection eventTriggerConnection;

    /**
     * Nothing special here
     */
    public ModelChangeEventImpl( CoreConnection connection ) {

        eventTriggerConnection = connection;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ModelChangeEvent#getEventTriggerConnection()
     */
    public Connection getEventTriggerConnection( ) {

        return eventTriggerConnection.getWrapper( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ChangeEvent#getTimestamp()
     */
    public Date getTimestamp( ) {

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ChangeEvent#isPostChangeEvent()
     */
    public boolean isPostChangeEvent( ) {

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.ChangeEvent#veto(java.lang.String)
     */
    public void veto( @SuppressWarnings( "unused" )
    String reason ) {

        // nothing
    }

    public ListenerTypeEnum getDedicatedListenerType( ) {

        return null;
    }

}
