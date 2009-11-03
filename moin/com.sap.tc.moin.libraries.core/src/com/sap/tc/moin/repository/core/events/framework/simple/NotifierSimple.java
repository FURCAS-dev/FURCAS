package com.sap.tc.moin.repository.core.events.framework.simple;

import java.lang.ref.WeakReference;

import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;

/**
 * The <code>Notifier</code> encapsulates the knowledge how to notify the
 * listeners.
 * 
 * @author Martin Kolb
 */
public abstract class NotifierSimple {

    protected static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_EVENTS, NotifierSimple.class );

    /**
     * the listener that will be notified when an event is fired.
     */
    protected WeakReference<? extends EventListener> _listener = null;

    /**
     * the event filter that is used for notification
     */
    public EventFilter _filter = null;

    /**
     * The helper recording information about exceptions, vetoes and listener
     * runtimes. Note that this field is 'null' if JMX is not enabled.
     */
    protected final ListenerHelper _listenerHelper;

    public NotifierSimple( ListenerHelper listenerHelper, EventListener listener, EventFilter filter ) {

        if ( listener == null ) {
            throw new MoinIllegalNullArgumentException( "EventListener" ); //$NON-NLS-1$
        }
        _listenerHelper = listenerHelper;
        _listener = new WeakReference<EventListener>( listener );
        _filter = filter;
    }

    /**
     * @return the listener associated to this notifier
     */
    public EventListener getListener( ) {

        return _listener.get( );
    }

    /**
     * @return the filter
     */
    public EventFilter getFilter( ) {

        return _filter;
    }

    /**
     * notifies the encapsulated listener about the passed event
     * 
     * @param event the event that will be sent to the listener
     */
    abstract public void fireEvent( ChangeEvent event );

    /**
     * @return "Notifier for Pre_Commit_Tx Listener " for example
     */
    @Override
    public String toString( ) {

        return getClass( ).getName( );
    }

}