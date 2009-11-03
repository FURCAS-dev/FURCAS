package com.sap.tc.moin.repository.core.events.framework.simple;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * The <code>Notifier</code> encapsulates the knowledge how to notify the
 * listeners.
 * 
 * @author Martin Kolb
 */
public class PreEventNotifier extends NotifierSimple {

    public PreEventNotifier( ListenerHelper listenerHelper, EventListener listener, EventFilter filter ) {

        super( listenerHelper, listener, filter );
    }

    /**
     * notifies the encapsulated listener about the passed event
     * 
     * @param event the event that will be sent to the listener
     */
    @Override
    public void fireEvent( ChangeEvent event ) {

        boolean timedDelivery = ( JMX_ENABLED && _listenerHelper.getMonitoringLevel( ) > 3 );
        long t = 0;



        PreChangeListener listener = (PreChangeListener) _listener.get( );
        if ( listener != null ) {
            try {
                if ( timedDelivery ) {
                    t = System.nanoTime( );
                }
                listener.prepare( event );
                if ( timedDelivery ) {
                    _listenerHelper.timeConsumedByPrepare( listener, System.nanoTime( ) - t );
                }
            } catch ( VetoException e ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( e, MoinSeverity.DEBUG, "Listener vetoed event. " + event, null ); //$NON-NLS-1$
                }
                if ( JMX_ENABLED ) {
                    _listenerHelper.eventVetoed( listener, event, e );
                }
                // VetoExceptions are OK, so pass them on to the next
                // exception block
                throw e;
            } catch ( Exception e ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( e, MoinSeverity.ERROR, "Listener has thrown exception", null ); //$NON-NLS-1$
                }
                if ( JMX_ENABLED ) {
                    _listenerHelper.exceptionThrown( listener, e );
                }
            }
        }

    }

}