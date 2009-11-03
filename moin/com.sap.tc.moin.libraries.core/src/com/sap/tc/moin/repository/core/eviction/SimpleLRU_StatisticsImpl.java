package com.sap.tc.moin.repository.core.eviction;

import java.util.LinkedList;
import java.util.Hashtable;

import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreModelPartition.CoreModelPartitionIdentity;
import com.sap.tc.moin.repository.core.impl.ModelPartitionImpl;


public class SimpleLRU_StatisticsImpl implements EvictionPolicy {

    // List of currently used partitions
    private LinkedList queue = null;

    // Already known partitions
    private Hashtable<Object, PartitionStatistics> partitions = new Hashtable<Object, PartitionStatistics>( );

    // the number of hard referenced objects    
    //private int hardReferenceLimit; 


    public SimpleLRU_StatisticsImpl( int hardReferenceLimit ) {

        this.queue = new LinkedList( );
    }

    /**
     * Puts the partition to the partition list as last used partition (list top)..
     * The MOIN calls this method before the partition is stored in workspace. 
     *
     * @param partition     The partition
     * @throws              NullPointerException if the partition is null
     */
    public synchronized void onPut( Object partition ) {

        if ( partition instanceof CoreModelPartition ) {
            PartitionStatistics ps = this.updateCoreModelPartitionStatistic( partition );
            ps.size = this.recalculateSize( partition );
        } else {
            PartitionStatistics ps = this.updatePartitionStatistic( partition );
            ps.size = this.recalculateSize( partition );
        }
    }


    /**
     * Puts the partition to the partition list as last used partition (list top)..
     * The MOIN calls this method before the MOIN client access the partition. 
     *
     * @param partition     The partition
     * @throws              NullPointerException if the partition is null
     */
    public synchronized void onAccess( Object partition ) {

        if ( partition instanceof CoreModelPartition ) {
            this.updateCoreModelPartitionStatistic( partition );
        } else {
            this.updatePartitionStatistic( partition );
        }
    }


    /**
     * Removes the partition fron the partition list.
     * The MOIN calls this method after removing the partition from workspace.
     *
     * @param partition     The partition
     * @throws              NullPointerException if the partition is null
     */
    public synchronized void onRemove( Object partition ) {

        if ( partition instanceof CoreModelPartition ) {
            CoreModelPartitionIdentity partitionIdetifier = ( (CoreModelPartition) partition ).getCoreModelPartitionIdentity( );
            PartitionStatistics ps = partitions.get( partitionIdetifier );
            if ( ps == null ) {
                ps = new PartitionStatistics( partitionIdetifier );
                partitions.put( partitionIdetifier, ps );
            }

            this.queue.remove( ps );
            ps.callNumber++;
        } else {
            String partitionName = partition.toString( );
            PartitionStatistics ps = partitions.get( partitionName );
            if ( ps == null ) {
                ps = new PartitionStatistics( partitionName );
                partitions.put( partitionName, ps );
            }

            this.queue.remove( ps );
            ps.callNumber++;
        }
    }


    /**
     * Checks if the partition is known for the EvectionManager.
     *
     * @param partition     The partition 
     * @return              True when the partition is alredy in the list
     * @throws              NullPointerException if the partition is null
     */
    public synchronized boolean exists( Object partition ) {

        if ( partition instanceof CoreModelPartition ) {
            CoreModelPartitionIdentity partitionIdetifier = ( (CoreModelPartition) partition ).getCoreModelPartitionIdentity( );
            PartitionStatistics ps = partitions.get( partitionIdetifier );
            if ( ps == null ) {
                ps = new PartitionStatistics( partitionIdetifier );
                partitions.put( partitionIdetifier, ps );
            }

            return this.queue.contains( ps );
        } else {
            String partitionName = partition.toString( );
            PartitionStatistics ps = partitions.get( partitionName );
            if ( ps == null ) {
                ps = new PartitionStatistics( partitionName );
                partitions.put( partitionName, ps );
            }

            return this.queue.contains( ps );
        }
    }


    /**
     * Returns the partition which should be removed / evicted from MOIN.
     * 
     * @return  The partition name which should be evicted
     */
    public synchronized Object chooseToEvict( ) {

        if ( !this.queue.isEmpty( ) ) {
            PartitionStatistics ps = (PartitionStatistics) this.queue.removeLast( );
            if ( ps.getPartitionIdentifier( ) instanceof CoreModelPartitionIdentity ) {
                return ( (CoreModelPartitionIdentity) ps.getPartitionIdentifier( ) ).getCoreModelPartition( );
            } else {
                return ps.getPartitionIdentifier( );
            }
        } else {
            return null;
        }
    }


    /**
     * Returns the current number of partitions which are known for EvictionManager. 
     * When the cache does not cotains any partitions the method returns -1.
     *
     * @return  The number of objects in the region
     */
    public synchronized int getCount( ) {

        if ( this.queue != null ) {
            return this.queue.size( );
        } else {
            return -1;
        }
    }


    /**
     * Recalculate the partition size.
     *
     * @param partition     The partition name
     * @throws              NullPointerException if the partition is null
     */
    protected synchronized void recalculatePartitionSize( Object partition ) {

        String partitionName = partition.toString( );
        PartitionStatistics ps = partitions.get( partitionName );

        if ( ps == null ) {
            ps = new PartitionStatistics( partitionName );
            partitions.put( partitionName, ps );
        }

        ps.size = this.recalculateSize( partition );
    }


    private int recalculateSize( Object partition ) {

        int size = 0;
        MemoryProfiler profiler = new MemoryProfiler( );

        if ( partition instanceof ModelPartitionImpl ) {
            try {
                size = profiler.sizeof( ( (ModelPartitionImpl) partition ).getElements( ) );
                size = size + profiler.sizeof( ( (ModelPartitionImpl) partition ).getLinks( ) );
            } catch ( Exception e ) {
                // $JL-EXC$ TODO trace?
            }
        } else {
            size = profiler.sizeof( partition );
        }
        return size;
    }


    private PartitionStatistics updateCoreModelPartitionStatistic( Object partition ) {

        CoreModelPartitionIdentity partitionIdetifier = ( (CoreModelPartition) partition ).getCoreModelPartitionIdentity( );
        PartitionStatistics ps = partitions.get( partitionIdetifier );
        if ( ps == null ) {
            ps = new PartitionStatistics( partitionIdetifier );
            partitions.put( partitionIdetifier, ps );
        }

        if ( this.queue.contains( ps ) ) {
            this.queue.remove( ps );
        }

        this.queue.addFirst( ps );
        ps.callNumber++;

        return ps;
    }

    private PartitionStatistics updatePartitionStatistic( Object partition ) {

        String partitionName = partition.toString( );
        PartitionStatistics ps = partitions.get( partitionName );
        if ( ps == null ) {
            ps = new PartitionStatistics( partitionName );
            partitions.put( partitionName, ps );
        }

        if ( this.queue.contains( ps ) ) {
            this.queue.remove( ps );
        }

        this.queue.addFirst( ps );
        ps.callNumber++;

        return ps;
    }
}
