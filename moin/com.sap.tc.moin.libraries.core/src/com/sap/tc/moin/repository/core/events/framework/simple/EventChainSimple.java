package com.sap.tc.moin.repository.core.events.framework.simple;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * Implementation of the {@link com.sap.tc.moin.repository.events.EventChain
 * EventChain} interface
 * 
 * @see com.sap.tc.moin.repository.events.EventChain
 * @author Daniel Vocke (d044825)
 */
public class EventChainSimple implements EventChain {

    public EventChainSimple( DeferringNotifierSimple notifier ) {

        this.notifier = notifier;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.events.EventChain#getEvents()
     */
    public List<ChangeEvent> getEvents( ) {

        return events;
    }


    /*
     * (non-Javadoc) this method is "package-protected" by intention
     */
    void addEvent( ChangeEvent event ) {

        if ( events == null ) {
            events = new ArrayList<ChangeEvent>( );
        }
        events.add( event );
    }

    /*
     * (non-Javadoc) this method is "package-protected" by intention
     */
    void deliverEvents( ) {

        notifier.deliverDeferredEventsFor( this );
        notifier = null;
    }

    private static final long serialVersionUID = 1L;

    private DeferringNotifierSimple notifier;

    private ArrayList<ChangeEvent> events;

    @Override
    public String toString( ) {

        return "Event chain: events = " + events + ", notifier = " + notifier; //$NON-NLS-1$ //$NON-NLS-2$
    }

}