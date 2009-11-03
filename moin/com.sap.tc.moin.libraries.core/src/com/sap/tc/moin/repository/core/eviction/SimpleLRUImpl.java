package com.sap.tc.moin.repository.core.eviction;

import java.util.LinkedList;

import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreModelPartition.CoreModelPartitionIdentity;

/**
 * This solution uses the linked list (java.util.LinkedList) which provides the list of used pertitions.
 */
public class SimpleLRUImpl implements EvictionPolicy {

    private LinkedList queue = null;

    // private int size;

    // the number of hard referenced objects	
    // private int hardReferenceLimit; 


    public SimpleLRUImpl( int hardReferenceLimit ) {

        this.queue = new LinkedList( );
    }

    /**
     * Puts the partition to the partition list as last used partition (list top)..
     * The MOIN calls this method before the partition is stored in workspace. 
     *
     * @param partition		The partition name
     * @throws 				NullPointerException if the partition is null
     */
    public synchronized void onPut( Object partition ) {

        if ( partition instanceof CoreModelPartition ) {
            CoreModelPartitionIdentity partitionIdetifier = ( (CoreModelPartition) partition ).getCoreModelPartitionIdentity( );
            if ( this.queue.contains( partitionIdetifier ) ) {
                this.queue.remove( partitionIdetifier );
            }
            this.queue.addFirst( partitionIdetifier );
        } else {
            if ( this.queue.contains( partition ) ) {
                this.queue.remove( partition );
            }
            this.queue.addFirst( partition );
        }
    }


    /**
     * Puts the partition to the partition list as last used partition (list top)..
     * The MOIN calls this method before the MOIN client access the partition. 
     *
     * @param partition     The partition name
     * @throws              NullPointerException if the partition is null
     */
    public synchronized void onAccess( Object partition ) {

        if ( partition instanceof CoreModelPartition ) {
            CoreModelPartitionIdentity partitionIdetifier = ( (CoreModelPartition) partition ).getCoreModelPartitionIdentity( );
            if ( this.queue.contains( partitionIdetifier ) ) {
                this.queue.remove( partitionIdetifier );
            }
            this.queue.addFirst( partitionIdetifier );
        } else {
            if ( this.queue.contains( partition ) ) {
                this.queue.remove( partition );
            }
            this.queue.addFirst( partition );
        }
    }


    /**
     * Removes the partition fron the partition list.
     * The MOIN calls this method after removing the partition from workspace.
     *
     * @param partition     The partition name
     * @throws              NullPointerException if the partition is null
     */
    public synchronized void onRemove( Object partition ) {

        if ( partition instanceof CoreModelPartition ) {
            CoreModelPartitionIdentity partitionIdetifier = ( (CoreModelPartition) partition ).getCoreModelPartitionIdentity( );

            this.queue.remove( partitionIdetifier );
        } else {
            this.queue.remove( partition );
        }
    }


    /**
     * Checks if the partition is known for the EvectionManager.
     *
     * @param partition 	The partition name
     * @return 				True when the partition is alredy in the list
     * @throws 				NullPointerException if the partition is null
     */
    public synchronized boolean exists( Object partition ) {

        if ( partition instanceof CoreModelPartition ) {
            CoreModelPartitionIdentity partitionIdetifier = ( (CoreModelPartition) partition ).getCoreModelPartitionIdentity( );

            return this.queue.contains( partitionIdetifier );
        } else {
            return this.queue.contains( partition );
        }
    }


    /**
     * Returns the partition which should be removed / evicted from MOIN.
     * 
     * @return 	The partition name which should be evicted
     */
    public synchronized Object chooseToEvict( ) {

        if ( !this.queue.isEmpty( ) ) {
            Object objToRemove = this.queue.removeLast( );
            if ( objToRemove instanceof CoreModelPartitionIdentity ) {
                return ( (CoreModelPartitionIdentity) objToRemove ).getCoreModelPartition( );
            } else {
                return objToRemove;
            }
        } else {
            return null;
        }
    }


    /**
     * Returns the current number of partitions which are known for EvictionManager. 
     * When the cache does not cotains any partitions the method returns -1.
     *
     * @return 	The number of objects in the region
     */
    public synchronized int getCount( ) {

        if ( this.queue != null ) {
            return this.queue.size( );
        } else {
            return -1;
        }
    }
}
