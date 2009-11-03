package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiCustomContentSelectionManagement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * The SPI interface for the Facility.
 * <p>
 * Each facility has to provide the Core with certain services. This interface
 * defines which services have to be provided and which may be implemented
 * optionally.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 */
public interface SpiFacility extends Facility {

    /**
     * Returns the model persistence service of this facility.
     * <p>
     * The service provides means to load model and metamodel partitions as well
     * as to store model partitions.
     * <p>
     * The provision of the service is mandatory.
     * 
     * @return The {@link SpiPersistence} of this facility.
     */
    public SpiPersistence getModelPersistence( );

    /**
     * Returns the core query service of this facility.
     * <p>
     * The service provides access to a set of predefined queries needed by the
     * MOIN core.
     * <p>
     * The provision of the service is mandatory.
     * 
     * @return The {@link SpiCoreQueryService} of this facility.
     */
    public SpiCoreQueryService getCoreQueryService( );

    /**
     * Returns the facility query service of this facility.
     * 
     * @return The {@link SpiMQLQueryService} of this facility
     */
    public SpiMQLQueryService getMQLQueryService( );

    /**
     * Returns the distributed dirty locking service of this facility.
     * <p>
     * The service provides means for cross MOIN instance lock management. A
     * service provider can implement an environment dependent mechanism in
     * order to guarantee that a partition can only be dirty in one single MOIN
     * instance.
     * <p>
     * The provision of the service is optional.<br>
     * Service providers may decide not to provide such a service. In that case
     * this method returns <code>null</code>.<br>
     * Hence the
     * <code>com.sap.tc.moin.repository.core.PartitionLockManager</code> only
     * works with the build-in memory locking.
     * 
     * @param dataArea The DataArea on which the facility locking operates.
     * @return The {@link SpiInternalDistributedDirtyLocking} of this facility
     * or <code>null</code> if such a service is not provided.
     */
    public SpiInternalDistributedDirtyLocking getInternalDistributedDirtyLocking( DataArea dataArea );

    /**
     * Returns the external save locking service of this facility.
     * <p>
     * The service allows access to and integration of environment specific
     * locking mechanisms via a generally defined protocol.
     * <p>
     * The provision of the service is optional.<br>
     * Service providers may decide not to provide such a service. In that case
     * this method returns <code>null</code>.
     * 
     * @return The {@link SpiExternalSaveLocking} of this facility or
     * <code>null</code> if such a service is not provided.
     */
    public SpiExternalSaveLocking getExternalSaveLocking( );

    /**
     * Returns the MOF ROM Injection service for this facility
     * 
     * @return The {@link SpiMofRomInjectionService} of this facility.
     */
    public SpiMofRomInjectionService getMofRomInjectionService( );

    /**
     * Returns the lifecycle management service of this facility.
     * <p>
     * The service provides access to life cycle related functionality.
     * <p>
     * The provision of the service is mandatory.
     * 
     * @return The {@link SpiLifecycleManagement} of this facility.
     */
    public SpiLifecycleManagement getLifecycleManagement( );

    /**
     * Returns the metamodel data area of this facility, if it exists.
     * 
     * @return The metamodel {@link DataArea} of this facility or
     * <code>null</code> if does not exists.
     * @see #getMetamodelClientSpec()
     */
    public DataArea getMetamodelDataArea( );

    /**
     * Returns the client spec for the metamodel data area of this facility.
     * <p>
     * The client spec for the meta model data must always exist. It has the
     * role of a technical client used to access the meta models.
     * <p>
     * This method returns the same result as {@link #getMetamodelDataArea()}
     * <code>.getClientIds().get(0)</code>
     * 
     * @return The {@link ClientSpec} for the meta model data area of this
     * facility.
     * @see #getMetamodelDataArea()
     * @throws SpiFacilityException
     */
    public SpiClientSpec getMetamodelClientSpec( ) throws SpiFacilityException;

    /**
     * Returns the transient data area of this facility, if it exists.
     * 
     * @return The transient {@link DataArea} of this facility or
     * <code>null</code> if it does not exists.
     * @see #getTransientClientSpec()
     */
    public DataArea getTransientDataArea( );

    /**
     * Returns the client spec for the transient data area of this facility, if
     * it exists.
     * 
     * @return The {@link ClientSpec} for the transient data area of this
     * facility or <code>null</code> if it does not exists.
     * @see #getTransientDataArea()
     * @throws SpiFacilityException
     */
    public ClientSpec getTransientClientSpec( ) throws SpiFacilityException;

    /**
     * Returns the partition serialization manager of this facility.
     * <p>
     * The partition serialization manager is part of the runtime host. It is
     * responsible for parsing and serializing model partitions.
     * 
     * @return The partition serialization manager of this facility
     * @deprecated currently only used by various test cases but not by
     * productive code. To be replaced by a test helper method which directly
     * exposes the runtime host component
     */
    @Deprecated
    public SpiPartitionSerializationManager getPartitionSerializationManager( );

    /**
     * Returns the custom content selection manager of this facility.
     * <p>
     * The custom content selection management handles the registration of
     * additional criteria to identify model content (e. g. additional DC types
     * in case of the NWDI). The criteria can be deployed to MOIN via a MOIN
     * archive.
     * 
     * @return the custom content selection manager of this facility
     */
    public SpiCustomContentSelectionManagement getCustomContentSelectionManagement( );
}
