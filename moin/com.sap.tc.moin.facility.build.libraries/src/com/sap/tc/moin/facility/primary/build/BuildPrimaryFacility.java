package com.sap.tc.moin.facility.primary.build;

import java.io.File;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.repository.PRI;

/**
 * This interface provides MOIN build primary facility specific functionality
 * needed by the MOIN buildplugin.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * </p>
 * @author d047015
 */
public interface BuildPrimaryFacility extends PrimaryFacility {

    /**
     * The method returns the {@link File} object which corresponds to the given
     * <code>PRI</code>. If the respective {@link File} object cannot be
     * retrieved <code>null</code> is returned.
     * 
     * @param pri The identifier of the partition, must not be <code>null</code>
     * @return The {@link File} corresponding to the given {@link PRI} or
     * <code>null</code> if the partition does not exist
     */
    File getFile( PRI pri );

    /**
     * Returns the last modification time for a given partition.
     * 
     * @param pri The partition for which the modification is requested.
     * @return The last modification time of the given partition or
     * <code>-1</code> if the partition does not exist
     */
    public long getModificationTime( PRI pri );
}
