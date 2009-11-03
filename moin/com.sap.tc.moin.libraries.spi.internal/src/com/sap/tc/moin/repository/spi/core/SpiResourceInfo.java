package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.PRI;

/**
 * Fully identifies a resource by the combination of the object's PRI and a
 * Stage.
 * <p>
 * This interface is<i>not</i> intended to be implemented by facility
 * providers.
 * 
 * @author d020383
 */
public interface SpiResourceInfo {

    /**
     * Returns the {@link PRI}.
     */
    PRI getPri( );

    /**
     * Returns the stage for the partition identified by {@link #getPri()}.
     * 
     * @return stage
     */
    SpiStage getStage( );

}
