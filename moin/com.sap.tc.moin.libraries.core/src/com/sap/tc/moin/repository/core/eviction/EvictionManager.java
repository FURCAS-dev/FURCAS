package com.sap.tc.moin.repository.core.eviction;

/**
 * @author d029324
 */


public class EvictionManager {

    private boolean evictionRunning = false;

    // Start evection when the current memory alocation is 80% of avalable memory 
    private int threshold = 80;

    // The instance of the currently used eviction policy - use the same policy for all workspaces / partitions.
    private EvictionPolicy evictionPolicy = null;

    // The EvictionManager is a singleton.
    private static EvictionManager theInstance = null;

    public static EvictionManager getInstance( ) {

        if ( theInstance == null ) {
            theInstance = new EvictionManager( );
        }
        return theInstance;
    }

    private EvictionManager( ) {

        if ( this.evictionPolicy == null ) {
            // At the moment use 100 objects as limit;
            this.evictionPolicy = new SimpleLRUImpl( 100 );
            //this.evictionPolicy = new SimpleLRU_StatisticsImpl(100);
        }
    }


    /**
     * Puts the partition to the partition list as last used partition (list top)..
     * The MOIN calls this method before the partition is stored in workspace. 
     *
     * @param partition     The partition
     * @throws              NullPointerException if the partition is null
     */
    public void onPut( Object partition ) {

        if ( this.evictionPolicy != null ) {
            this.evictionPolicy.onPut( partition );
        }
    }


    /**
     * Puts the partition to the partition list as last used partition (list top)..
     * The MOIN calls this method before the MOIN client access the partition. 
     *
     * @param partition     The partition
     * @throws              NullPointerException if the partition is null
     */
    public void onAccess( Object partition ) {

        if ( this.evictionPolicy != null ) {
            this.evictionPolicy.onAccess( partition );
        }
    }


    /**
     * Removes the partition fron the partition list.
     * The MOIN calls this method after removing the partition from workspace.
     *
     * @param partition     The partition
     * @throws              NullPointerException if the partition is null
     */
    public void onRemove( Object partition ) {

        if ( this.evictionPolicy != null ) {
            this.evictionPolicy.onRemove( partition );
        }
    }


    /**
     * Recalculate the curent partition size.
     * 
     * @param partition the partition instance which should be recalculated.
     * @return the current partition size.
     */
    // public int recalculatePartitionSize (Object partition) {
    // if (this.evictionPolicy instanceof SimpleLRU_StatisticsImpl) {
    // return this.recalculatePartitionSize(partition);
    // } else {
    // return 0;
    // }
    // }
    /**
     * The method returns true if the currently used memory requeires the start of the eviction process.
     * Otherwise this method returns false.
     * 
     * @return <code>true</code> if the eviction process should be started.
     */
    public boolean doEviction( ) {

        if ( ( Runtime.getRuntime( ).freeMemory( ) / Runtime.getRuntime( ).totalMemory( ) * 100 ) >= this.threshold ) {
            return true;
        }
        return false;
    }


    /**
     * The method returns <code>true</code> if the eviction process is running. Otherwise the method returns <code>false</code>.
     * 
     * @return <code>true</code> if the eviction process is already running.
     */
    public boolean isEvectionRunning( ) {

        return this.evictionRunning;
    }


    /**
     * Obtain the currently used eviction policy. 
     * <p>
     * The eviction policy is an instance of the EvictionPolicy interface (see 
     * {@link com.sap.tc.moin.repository.core.impl.eviction.EvictionPolicy}).
     * 
     * @return instance of the current used eviction policy.
     */
    public EvictionPolicy getUsedEvictionPolicy( ) {

        return this.evictionPolicy;
    }

}
