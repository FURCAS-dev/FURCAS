package com.sap.tc.moin.facility.primary.persistence.fs;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityEventNotifier;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiPartitionService;
import com.sap.tc.moin.repository.spi.core.SpiStage;

public class FacilityEventNotifierImpl implements Runnable, IpiFacilityEventNotifier, IpiFacilityComponent {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_NOTIFICATION, FacilityEventNotifierImpl.class );

    private static final int ITEM_LIST_SIZE = 5;

    private SpiPartitionService corePartitionService;

    private boolean stopped = false;

    private boolean shutdown = false;

    private Thread notificationThread;

    private NotifItems objectRegistry;

    public FacilityEventNotifierImpl( ) {

        this.objectRegistry = new NotifItems( );
    }

    public void bind( SpiPartitionService corePartitionService ) {

        this.corePartitionService = corePartitionService;
    }

    /**
     */
    public void initialize( ) {

        this.start( );
    }

    public void finalizeStartup( ) {

    }

    public void tearDown( ) {

        this.stopNotificationThread( );
        this.notificationThread = null;
    }


    public void evictPartitions( Map<SpiStage, List<PRI>> partitionsToEvictPerStage ) throws IllegalArgumentException {

        NotifItem notifItem = new NotifItem( partitionsToEvictPerStage );
        this.register( notifItem );
    }


    /**
     * Internal handle keeping content to be used for core eviction.
     */
    protected static class NotifItems {

        private List<NotifItem> itemList = new ArrayList<NotifItem>( ITEM_LIST_SIZE );

        private static final long serialVersionUID = 1L;

        // content to be used for core eviction 

        /**
         * @return the itemList
         */
        protected List<NotifItem> getItemList( ) {

            return itemList;
        }

        /**
         * @param itemList the itemList to set
         */
        protected void setItemList( List<NotifItem> itemList ) {

            this.itemList = itemList;
        }
    }

    private static class NotifItem {

        // entity for core eviction
        private Map<SpiStage, List<PRI>> partitionsToEvictPerStage;

        public NotifItem( Map<SpiStage, List<PRI>> partitionsToEvictPerStage ) {

            super( );
            this.partitionsToEvictPerStage = partitionsToEvictPerStage;
        }

        /**
         * @return the partitionsToEvictPerStage
         */
        public Map<SpiStage, List<PRI>> getPartitionsToEvictPerStage( ) {

            return partitionsToEvictPerStage;
        }

    }


    private int getCollectionLatency( ) {

        // latency for collection of events
        return 0;
    }

    private int getNotificationLatency( ) {

        // latency
        return 0;
    }

    /**
     * Start a new daemon thread with this object's run method
     */
    private void start( ) {

        this.notificationThread = new Thread( this );
        this.notificationThread.setDaemon( true );
        this.notificationThread.setName( "com.sap.tc.moin.facility.primary.ide.events.LocalNotificationThread" ); //$NON-NLS-1$
        this.notificationThread.start( );
    }

    /**
     * Stop the thread that is related to this instance
     */
    private void stopNotificationThread( ) {

        int sleepTime = 50;
        int triesLeft = 6;
        this.stopped = true;
        this.notificationThread.interrupt( );
        while ( ( !this.shutdown ) && ( triesLeft > 0 ) ) {
            try {
                Thread.sleep( sleepTime );
            } catch ( InterruptedException e ) {
                // $JL-EXC$
            }

            triesLeft--;
        }
    }

    /**
     * After the notification latency interval, this thread repeatedly (every
     * notification heartbeat) works off the objects registered by any thread.
     * Each object that was registered more than notification minimum age ago is
     * handled: its updateDependingObjects method is called, and then the object
     * is removed from the registry.
     */
    public void run( ) {

        // Start with a little nap
        try {
            Thread.sleep( this.getNotificationLatency( ) ); // let the system come up
        } catch ( InterruptedException ex ) {
            // $JL-EXC$
        }

        while ( !stopped ) // do the same forever
        {
            int collectionLatency = this.getCollectionLatency( );

            // Have a little nap, collecting several events
            FacilityEventNotifierImpl.LOGGER.trace( MoinSeverity.INFO, "Notification thread pauses briefly ..." ); //$NON-NLS-1$
            try {
                Thread.sleep( collectionLatency );
            } catch ( InterruptedException ex ) {
                if ( stopped ) {
                    FacilityEventNotifierImpl.LOGGER.trace( MoinSeverity.INFO, "Notification thread is stopped." ); //$NON-NLS-1$
                    break;
                }
            }
            FacilityEventNotifierImpl.LOGGER.trace( MoinSeverity.INFO, "Notification thread awakes ..." ); //$NON-NLS-1$

            // Do it really
            try {
                this.updateAllCachedObjects( );
            } catch ( Throwable e ) {
                FacilityEventNotifierImpl.LOGGER.trace( MoinSeverity.ERROR, "Exception occured!", e ); //$NON-NLS-1$
            }

            // Stop the heart beat if the registry is empty
            synchronized ( this ) {
                if ( this.isEmpty( ) ) {
                    FacilityEventNotifierImpl.LOGGER.trace( MoinSeverity.INFO, "Notification thread waits for registrations ..." ); //$NON-NLS-1$
                    try {
                        wait( );
                    } catch ( InterruptedException e ) {
                        if ( stopped ) {
                            FacilityEventNotifierImpl.LOGGER.trace( MoinSeverity.INFO, "Notification thread is stopped." ); //$NON-NLS-1$
                            break;
                        }
                    }
                }
            }
        }

        shutdown = true;
    }

    private void updateAllCachedObjects( ) {

        // FIXME: remove this asap
        if ( Boolean.getBoolean( IpiPrimaryFacility.TEST_NOTIFICATION_AND_PARTITION_EVICTION_BY_MOIN_CORE ) ) {
            long currentTimeMillis = System.currentTimeMillis( );
            Date currentDate = new Date( currentTimeMillis );
            //$JL-SYS_OUT_ERR$ For testing only, having messages besides the test messages
            java.lang.System.out.println( "FacilityEventNotifier#updateAllCachedObjects: begin method, " + currentDate + "( " + currentTimeMillis + " )" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            java.lang.System.out.flush( );
        }

        // do update here
        // create a worklist of real objects that we can work on (outside this sync block) without threading problems
        List<NotifItem> list = null;
        synchronized ( objectRegistry ) {
            list = objectRegistry.getItemList( );
            int size = list.size( );
            if ( size > 0 ) {
                // list for notifications filled - provide empty list for further registration
                objectRegistry.setItemList( new ArrayList<NotifItem>( ITEM_LIST_SIZE ) );
            }
        }

        // process list
        if ( list.size( ) < 1 ) {
            // nothing to do
            return;
        }

        for ( Iterator<NotifItem> it = list.iterator( ); it.hasNext( ); ) {
            NotifItem item = it.next( );
            Map<SpiStage, List<PRI>> partitionsToEvictPerStage = item.getPartitionsToEvictPerStage( );
            try {
                if ( partitionsToEvictPerStage != null && LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    String message = String.format( "Trigger partition eviction in Core: \n%s", partitionsToEvictPerStage.toString( ) ); //$NON-NLS-1$
                    LOGGER.trace( MoinSeverity.DEBUG, message );
                }
                this.corePartitionService.evictPartitions( partitionsToEvictPerStage );
            } catch ( RuntimeException e ) {
                FacilityEventNotifierImpl.LOGGER.trace( e, MoinSeverity.ERROR, "Exception occured!" ); //$NON-NLS-1$
            }
        }

        // FIXME: remove this asap
        if ( Boolean.getBoolean( IpiPrimaryFacility.TEST_NOTIFICATION_AND_PARTITION_EVICTION_BY_MOIN_CORE ) ) {
            long currentTimeMillis = System.currentTimeMillis( );
            Date currentDate = new Date( currentTimeMillis );
            //$JL-SYS_OUT_ERR$ For testing only, having messages besides the test messages
            java.lang.System.out.println( "FacilityEventNotifier#updateAllCachedObjects: end method, " + currentDate + "( " + currentTimeMillis + " )" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            java.lang.System.out.flush( );
        }

    }

    /**
     * evaluate threadRegistry -> objectRegistry.size(); do it thread-safe!
     */
    private synchronized boolean isEmpty( ) {

        return this.objectRegistry.getItemList( ).isEmpty( );
    }

    /**
     * @param notifRegistry map of NotifKey to NotifItems
     */
    private void register( NotifItem notifItem ) {

        synchronized ( this.objectRegistry ) {
            objectRegistry.getItemList( ).add( notifItem );
        }

        // wake up the notification thread
        synchronized ( this ) {
            this.notify( );
        }
    }
}
