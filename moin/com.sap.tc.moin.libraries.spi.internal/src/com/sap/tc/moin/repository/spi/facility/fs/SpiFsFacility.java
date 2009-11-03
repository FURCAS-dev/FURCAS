package com.sap.tc.moin.repository.spi.facility.fs;

import com.sap.tc.moin.repository.spi.facility.SpiFacility;


/**
 * The file system specific SPI interface extension for the Facility.
 * <p>
 * Each facility has to provide the Core with certain services. This interface
 * defines which services have to be provided and which may be implemented
 * optionally.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 */
public interface SpiFsFacility extends SpiFacility {

    /**
     * Returns the meta model partition manager service of this IDE facility.
     * <p>
     * The service provides means to deploy metamodel partitions as well as to
     * inject MofRom partitions.
     * <p>
     * The provision of the service is mandatory.
     * 
     * @return The {@link SpiFsMetaModelManager} of this facility.
     */
    public SpiFsMetaModelManager getFsMetaModelManager( );

}
