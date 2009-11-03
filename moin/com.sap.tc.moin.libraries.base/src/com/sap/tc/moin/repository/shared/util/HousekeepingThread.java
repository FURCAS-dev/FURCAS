package com.sap.tc.moin.repository.shared.util;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

public class HousekeepingThread extends Thread {

    public interface ActionOnBeingGarbageCollectedProvider {

        public void actionOnBeingGarbageCollected( Reference referenceToObjectWhichHasBeenGarbageCollected );
    }

    /**
     * the queue which gets the garbage-collected keys from the registration map
     * not private to avoid accessor generation
     */
    private ReferenceQueue queue;

    private volatile boolean shutdownRequested = false;

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, HousekeepingThread.class );

    public HousekeepingThread( String moinId ) {

        queue = new ReferenceQueue<Object>( );
        this.setName( "HousekeepingThread-" + moinId ); //$NON-NLS-1$
        this.setDaemon( true );
        this.start( );
    }

    @Override
    public void run( ) {

        while ( !shutdownRequested ) {
            try {
                Reference reference = queue.remove( );
                synchronized ( this ) {
                    if ( this.shutdownRequested == true ) {
                        break;
                    }
                }
                if ( reference instanceof ActionOnBeingGarbageCollectedProvider ) {
                    ActionOnBeingGarbageCollectedProvider actionProvider = (ActionOnBeingGarbageCollectedProvider) reference;
                    actionProvider.actionOnBeingGarbageCollected( reference );
                }
            } catch ( InterruptedException e ) {
                // $JL-EXC$ fine
            } catch ( Throwable t ) {
                // $JL_EXC$ this thread must NOT die as it is essential for keeping the memory low
                logger.trace( t, MoinSeverity.ERROR, UtilitiesMessages.HOUSEKEEPINGTHREADEXCEPTION );

            }
        }
    }

    public <T> ReferenceQueue<T> getReferenceQueue( ) {

        return this.queue;
    }

    public synchronized void requestShutdown( ) {

        this.shutdownRequested = true;

        // wake up the thread (if necessary)
        new WeakReference<Object>( null, this.getReferenceQueue( ) ).enqueue( );
    }

}
