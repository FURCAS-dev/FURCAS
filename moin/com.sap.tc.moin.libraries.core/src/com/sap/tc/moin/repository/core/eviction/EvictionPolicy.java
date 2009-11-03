package com.sap.tc.moin.repository.core.eviction;

/**
 * @author d029324
 *
 * The eviction policy definition which has to be implemented by each eviction policy 
 * implementation class. 
 */
public interface EvictionPolicy {

    /**
     * Puts the partition to the partition list as last used partition (list top)..
     * The MOIN calls this method before the partition is stored in workspace. 
     *
     * @param partition		The partition
     * @throws 				NullPointerException if the partition is null
     */
    public void onPut( Object partition );

    /**
     * Puts the partition to the partition list as last used partition (list top)..
     * The MOIN calls this method before the MOIN client access the partition. 
     *
     * @param partition 	The partition
     * @throws 				NullPointerException if the partition is null
     */
    public void onAccess( Object partition );

    /**
     * Removes the partition fron the partition list.
     * The MOIN calls this method after removing the partition from workspace.
     *
     * @param partition 	The partition
     * @throws 				NullPointerException if the partition is null
     */
    public void onRemove( Object partition );

    /**
     * Checks if the partition is known for the EvectionManager.
     *
     * @param partition 	The partition
     * @return 				True when the partition is alredy in the list
     * @throws 				NullPointerException if the partition is null
     */
    public boolean exists( Object partition );

    /**
     * Returns the partition which should be removed / evicted from MOIN.
     * 
     * @return 	The partition name which should be evicted
     */
    public Object chooseToEvict( );

    /**
     * Returns the current number of partitions which are known for EvictionManager. 
     * When the cache does not cotains any partitions the method returns -1.
     *
     * @return 	The number of objects
     */
    public int getCount( );

}
