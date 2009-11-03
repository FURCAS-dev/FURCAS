package com.sap.tc.moin.repository.spi.core;

import java.lang.ref.ReferenceQueue;

import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;


/**
 * Provides important core functionality to other layers. Other layers that are
 * used by the MOIN core might need some of the MOIN core functionality, such as
 * partition reading/writing or instantiation of JMI instances.
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d026715
 */
public interface SpiCore {

    /**
     * Returns the id of the running MOIN instance.
     * 
     * @return The id of the running MOIN instance.
     */
    public String getMoinId( );

    /**
     * Returns the reference queue for garbage collection of weak references
     */
    public ReferenceQueue getReferenceQueue( );

    /**
     * Returns the JMI helper which provides functionality which is not directly
     * offered by single JMI calls.
     * 
     * @return The JMI helper.
     */
    public SpiJmiHelper getJmiHelper( );

    /**
     * Returns the partition service provided by the MOIN Core.
     * 
     * @return The partition service provided by the MOIN Core.
     */
    public SpiPartitionService getPartitionService( );

    /**
     * Returns the metamodel service provided by the MOIN Core.
     * 
     * @return The metamodel service provided by the MOIN Core.
     */
    public SpiMetamodelService getMetamodelService( );

    /**
     * Returns the operation service provided by the MOIN Core.
     * 
     * @return The operation service provided by the MOIN Core.
     */
    public SpiOperationService getOperationService( );

    /**
     * Returns the stage factory provided by the MOIN Core.
     * 
     * @return The stage factory provided by the MOIN Core.
     */
    public SpiStageService getStageFactory( );

}
