package com.sap.tc.moin.repository.core.events;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * All event implementations that are supported by MOIN inherit from
 * <code>ChangeEventImpl</code>.
 * 
 * @see com.sap.tc.moin.repository.events.type.ChangeEvent
 * @author Daniel Vocke (D044825)
 */

public abstract class ChangeEventImpl implements ChangeEvent {

    public CoreConnection eventTriggerConnection;

    /**
     * Constructor
     */
    protected ChangeEventImpl( CoreConnection triggeringConnection ) {

        eventTriggerConnection = triggeringConnection;
    }

    /**
     * This method returns the connection that caused this event. Receivers of
     * this event may choose to use this connection instead of their own
     * connection.
     * 
     * @return Returns the connection that caused this event
     */
    public Connection getEventTriggerConnection( ) {

        if ( eventTriggerConnection == null ) {
            return null;
        }
        return eventTriggerConnection.getWrapper( );
    }

    /**
     * retrieves the element's MRI. this is only a helper method
     */
    protected static MRI retrieveElementMri( RefBaseObject element ) {

        return ( (Partitionable) element ).get___Mri( );
    }

    /**
     * retrieves the element's LRI. This is only an internal helper method.
     */
    protected static LRI retrieveElementLri( RefBaseObject object ) {

        return ( (Partitionable) object ).get___Mri( ).getLri( );
    }

    /**
     * This method is used by the
     * {@link com.sap.tc.moin.repository.events.framework.PartitionFilterTable}
     * and the
     * {@link com.sap.tc.moin.repository.events.framework.PartitionMembershipFilterTable}
     * in order to determine the (Partition-)listeners for this event.
     * 
     * @return the partition(s) that might be touched by the actions that this
     * event indicates. The return type is either {@link MRI}if only one
     * partition is affected or {@link Set} if more than one partition is
     * affected. If no partition is affected, <code>null</code> will be
     * returned
     */
    public abstract Object getAffectedPartitionsPRIs( );

    /**
     * @see com.sap.tc.moin.repository.events.type.ChangeEvent#veto(java.lang.String)
     */
    public void veto( String reason ) {

        throw new VetoException( reason );
    }

    /**
     * Returns the String literal containing the type of the event (e.g.
     * "ElementDeleteEvent").
     */
    protected abstract String getTypeString( );

    /**
     * Returns a String of all relevant event parameters.
     */
    protected abstract String getParameterString( );

    @Override
    public String toString( ) {

        return getTypeString( ) + "(" + getParameterString( ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
    }
}
