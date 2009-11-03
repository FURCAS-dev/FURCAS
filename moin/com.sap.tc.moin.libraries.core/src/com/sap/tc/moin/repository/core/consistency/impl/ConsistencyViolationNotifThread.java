package com.sap.tc.moin.repository.core.consistency.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.ConsistencyThread;
import com.sap.tc.moin.repository.core.ConsistencyViolationEvent;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Notification thread for consistency violation events. This thread processes
 * the queue for consistency violation events. The queue contains events of type
 * {@link NewConsistencyViolationEvent} or
 * {@link ResolvedConsistencyViolationEvent}. The queue is filled by the MOIN
 * core.
 * 
 * @author d026715
 */
@SuppressWarnings( "nls" )
public final class ConsistencyViolationNotifThread extends Thread implements ConsistencyThread {

    private static final String THREAD_NAME = "ConsistencyViolationNotification"; //$NON-NLS-1$

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CONSISTENCY, ConsistencyViolationNotifThread.class );

    private final BlockingQueue<ConsistencyViolationEventImpl> violationsEventQueue = new LinkedBlockingQueue<ConsistencyViolationEventImpl>( );

    private volatile boolean processing = false;

    private volatile int elementCount = 0;

    private volatile boolean shutdownRequested = false;

    public ConsistencyViolationNotifThread( String moinId ) {

        this.setName( THREAD_NAME + "-" + moinId ); //$NON-NLS-1$
        this.setDaemon( true );
        this.start( );
    }


    @Override
    public void run( ) {

        logger.trace( MoinSeverity.INFO, "Start of inconsistency notification thread." );

        ConsistencyViolationEventImpl event;
        while ( !shutdownRequested ) {
            try {
                event = violationsEventQueue.take( );
            } catch ( InterruptedException ie ) {
                continue;
            }
            synchronized ( this ) {
                if ( shutdownRequested ) {
                    break;
                }
                processing = true;
                elementCount--;
                if ( elementCount < 0 ) {
                    logger.trace( MoinSeverity.ERROR, "Illegal state for inconsistency notification queue. Element counter < 0." );
                    throw new MoinIllegalStateException( CoreConsistencyMessages.ILLEGALSTATEFORINCONSISTENCYNOTIFICATIONQUEUE );
                }
            }
            try {
                try {
                    // wait for more events to be registered
                    Thread.sleep( 300 );
                } catch ( InterruptedException ex ) {
                    logger.trace( ex, MoinSeverity.WARNING, "Notification thread was interrupted while sleeping.", new Object[] {} );
                }

                Collection<ConsistencyViolationEventImpl> collectedEvents = null;
                if ( elementCount > 0 ) {
                    synchronized ( this ) {
                        if ( shutdownRequested ) {
                            break;
                        }

                        collectedEvents = new ArrayList<ConsistencyViolationEventImpl>( elementCount + 1 );
                        // add first event
                        collectedEvents.add( event );
                        // add the rest
                        this.violationsEventQueue.drainTo( collectedEvents );
                        this.elementCount = 0;
                    }
                    // sort events by session id
                    Collection<BulkConsistencyViolationEvent> bulkEvents = getBulkEvents( collectedEvents );
                    for ( BulkConsistencyViolationEvent bulkEvent : bulkEvents ) {
                        // bulk event can be empty
                        if ( !bulkEvent.isEmpty( ) ) {
                            this.consume( bulkEvent );
                        }
                    }
                } else {
                    this.consume( event );
                }
            } finally {
                processing = false;
                if ( elementCount == 0 ) {
                    synchronized ( this ) {
                        this.notify( );
                    }
                }
            }
        }

        logger.trace( MoinSeverity.INFO, "Shutdown of inconsistency notification thread." );

    }

    public synchronized void requestShutdown( ) {

        this.shutdownRequested = true;
        try {
            this.violationsEventQueue.clear( );
            this.elementCount = 0;
            this.violationsEventQueue.put( new ConsistencyViolationEventImpl( null ) {

                @Override
                public void notifyExternalListeners( ) {

                    throw new UnsupportedOperationException( );
                }

            } );
        } catch ( InterruptedException e ) {
            logger.trace( MoinSeverity.ERROR, "Unable to put stop event into violation event queue." );
        }
    }

    private static Collection<BulkConsistencyViolationEvent> getBulkEvents( Collection<ConsistencyViolationEventImpl> events ) {

        LinkedHashMap<Session, BulkConsistencyViolationEvent> sortedBySession = new LinkedHashMap<Session, BulkConsistencyViolationEvent>( );
        for ( ConsistencyViolationEventImpl singleEvent : events ) {
            Session session = singleEvent.getRegistry( ).getSession( );
            BulkConsistencyViolationEvent foundEvent = sortedBySession.get( session );
            if ( foundEvent == null ) {
                if ( singleEvent instanceof BulkConsistencyViolationEvent ) {
                    // if the first event for this session is a bulk event, use it
                    foundEvent = (BulkConsistencyViolationEvent) singleEvent;
                } else {
                    // create a new bulk event
                    foundEvent = new BulkConsistencyViolationEvent( singleEvent.getRegistry( ), new ConsistencyViolationBuffer( ) );
                    // add single event to bulk event
                    foundEvent.addViolationEvent( singleEvent );
                }
                // register it per session
                sortedBySession.put( session, foundEvent );
            } else {
                // add single event to bulk event
                foundEvent.addViolationEvent( singleEvent );
            }
        }
        return sortedBySession.values( );
    }

    /**
     * Does the external notification.<br>
     * Only the sessions where the consistency violation occurred is notified.
     * The violation event has got a reference to the
     * {@link ConsistencyViolationRegistryImpl} where it was raised. There is
     * only one {@link ConsistencyViolationRegistryImpl} per {@link Session}.
     * 
     * @param violationEvent
     */
    private void consume( ConsistencyViolationEventImpl violationEvent ) {

        try {
            this.waitForWriteLock( violationEvent.getSession( ) );
            violationEvent.notifyExternalListeners( );
        } catch ( Exception ex ) {
            logger.trace( ex, MoinSeverity.ERROR, "Exception when notifying inconsistency listeners.", new Object[] {} );
        }
    }

    public synchronized void addNewEvent( ConsistencyViolationEvent event ) {

        try {
            this.violationsEventQueue.put( (ConsistencyViolationEventImpl) event );
            this.elementCount++;
        } catch ( InterruptedException ex ) {
            logger.trace( ex, MoinSeverity.ERROR, "Thread was interrupted when waiting for inconsistency event queue to be processed.", new Object[] {} );
        }
    }

    private synchronized boolean isProcessing( ) {

        return ( elementCount > 0 ) || this.processing;
    }

    /**
     * Pragmatic approach: simply wait until everything is done.
     */
    public synchronized void waitForQueue( ) {

        // check if queue is empty: wait until all events are processed
        // check processing flag: wait until last event is processed - queue is empty then
        while ( isProcessing( ) ) {
            try {
                this.wait( );
            } catch ( InterruptedException ex ) {
                logger.trace( ex, MoinSeverity.ERROR, "Thread was interrupted when waiting for inconsistency event queue to be processed.", new Object[] {} );
            }
        }
    }

    /**
     * Waits for the MOIN core write lock to be released.
     * 
     * @param connection
     */
    private void waitForWriteLock( CoreSession session ) {

        if ( ( session != null ) && session.isAlive( ) ) {
            SynchronizationManager syncManager = session.getWorkspaceSet( ).getSynchronizationManager( );
            synchronized ( syncManager.getProhibitWriteSyncObject( ) ) {
                //just to make sure that all write operations are finished before starting the notification process
            }

        }
    }
}
