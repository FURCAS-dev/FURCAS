package com.sap.tc.moin.repository.spi.facility.fs;

import java.util.List;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;

/**
 * This SPI interface provides means to deploy metamodels into the facility from
 * an IDE or build (FS) runtime host (at metamodel deployment phase).
 * <p>
 * The set of metamodels initally provided by the runtime host is expected to be
 * stable.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @see SpiFacility
 * @author d047015
 */
public interface SpiFsMetaModelManager {

    /**
     * Data structure holding deployment relevant information of one meta model
     * partition.
     */
    public static final class MetaModelPartitionDeploymentRecord {

        /** PRI of the meta model partition to deploy. */
        public PRI pri;

        /** Stream provider for the meta model partition to deploy. */
        public SpiPartitionStreamProvider streamProvider;

        /** Timestamp of the meta model partition to deploy. */
        public long timestamp;
    }

    /**
     * Destructively deploys a set of given metamodels into the facility
     * (previously deployed metamodels will be undeployed first).
     * <p>
     * Returns a list of defective partitions (if such partitions exist) which
     * could not be deployed.
     * <p>
     * The caller of this method has to handle these faults and will probably
     * decide to undeploy all not defective partitions in the same metamodel
     * container to ensure consistency.
     * 
     * @param metamodelPartitions The metamodel partitions to deploy.
     * @return A list of defective partitions that could not be deployed into
     * the facility.
     * @see SpiFsMetaModelManager#removeDeployedMetamodelPartitions(CRI)
     */
    public List<PRI> setDeployedMetamodelPartitions( List<MetaModelPartitionDeploymentRecord> metamodelPartitions );

    /**
     * Undeploys the metamodel partitions in the given container from the
     * facility.
     * <p>
     * This method must only be called in the metamodel deployment phase by the
     * runtime host. It is meant to remove specific metamodel partitions after
     * an faulty deployment step in method
     * {@link #setDeployedMetamodelPartitions(List)}.
     * 
     * @param metamodelContainer The metamodel container to undeploy.
     * @see SpiFsMetaModelManager#setDeployedMetamodelPartitions(List)
     */
    public void removeDeployedMetamodelPartitions( CRI metamodelContainer );

}
