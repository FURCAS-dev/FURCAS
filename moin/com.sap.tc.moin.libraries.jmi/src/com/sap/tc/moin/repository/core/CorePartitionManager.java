/*
 * Created on 24.08.2006
 */
package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.shared.util.Notifyee;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;

/**
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d044711
 */
public interface CorePartitionManager extends Notifyee {

    /**
     * Returns the workspace this manager is part of.
     * 
     * @return the workspace this manager is part of.
     * @see Workspace#getPartitionManager()
     */
    public Workspace getWorkspace( );

    /**
     * Returns a read-only live view of the partitions which are currently
     * loaded to the associated workspace.
     * 
     * @return a read-only live view of the partitions which are currently
     * loaded to the associated workspace.
     */
    public Collection<CoreModelPartition> getLoadedPartitionsLive( );

    public CoreModelPartition getPartition( CoreSession session, PRI pri, boolean loadMissing );

    public CoreModelPartition getPartitionConsideringDeleted( CoreSession session, PRI pri, boolean loadMissing );

    public void removePartition( PRI pri );

    public void addPartition( CoreConnection connection, CoreModelPartition partition );

    public CoreModelPartition getNullPartition( CoreConnection connection );

    public CoreModelPartition getOrCreateTransientPartition( String partitionName, CoreConnection connection );

    public CoreModelPartition getOrCreateTransientPartitionNonTransactional( String partitionName, CoreConnection connection );

    public Collection<CoreModelPartition> getTransientPartitions( CoreConnection connection );

    public Collection<CoreModelPartition> getAllTransientPartitions( );

    public CoreModelPartition getExtentPartition( );

    public boolean isLegalPartitionNameForTransientPartition( String partitionName );

    public void assertLegalPartitionNameForTransientPartition( String partitionName ) throws IllegalArgumentException;

    public boolean isPartitionLoaded( PRI modelPartition );

    public void destroy( );

    public void evictPartition( CoreModelPartition mp );

    public void evictPartitionForced( CoreModelPartition mp );

    public boolean canEvict( ModelPartition partition );

    public void evictPartitionsForced( List<PRI> pris );

    public void evictPartitions( List<PRI> pris );

    /**
     * Returns a non-live collection of the partitions which are loaded to the
     * associated {@link #getWorkspace() workspace}.
     * 
     * @return a non-live collection of the partitions which are loaded to the
     * associated {@link #getWorkspace() workspace}.
     */
    public Collection<? extends SpiModelPartition> getLoadedPartitions( );


    public void savePartitionsOfConnection( CoreConnection connection ) throws NullPartitionNotEmptyException, PartitionsNotSavedException;

    public void evictPartition( PRI pri );
}
