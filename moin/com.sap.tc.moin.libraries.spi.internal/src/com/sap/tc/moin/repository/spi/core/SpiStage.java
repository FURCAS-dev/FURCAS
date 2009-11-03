package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;

/**
 * Differentiates versions of partitions.
 * <p>
 * The concept of stages was designed for and is effectively used only in the
 * server scenario, where MOIN wants to provide full client-isolation and at the
 * same time share as much data between clients as possible, in order to save
 * resources.
 * <p>
 * In order to achieve that, MOIN is able to differentiate multiple versions of
 * the same partition, and to assign these versions to different stages. It is
 * up to the facility implementation which and how many stages are used in a
 * certain data area, and how a specific client chooses the one version of a
 * partition that is visible to him.
 * <p>
 * In the contract between the Core and the Facility, a partition is fully
 * identified by the combination of a PRI and a Stage, which make up a
 * {@link SpiResourceInfo}. For client code, however, only the PRI is relevant.
 * The selection from the available stages that are supported by the data area
 * is done by the facility, e.g. according to a client-specific configuration.
 * During model navigation, e.g., the MOIN Core sometimes has to determine the
 * stage of a partition in the scope of a given client. This stage resolution is
 * done e.g. in {@link SpiClientSpec#getResourceInfo}.
 * <p>
 * <b>Sharing</b>
 * </p>
 * <p>
 * MOIN supports the use of shared stages for content that can be shared between
 * clients. Changes to partitions are not allowed for partitions in a shared
 * stage. When working with a standard versioning system, only one shared stage
 * is required to which typically the head revision of all partitions is mapped.
 * By default, a client sees all partitions in this stage.
 * </p>
 * <p>
 * In a full-featured NWDI-based server scenario, MOIN can utilize two shared
 * stages - INACTIVE and ACTIVE, corresponding to the two states that a file has
 * in DTR. Each client then has to select per Development Component whether it
 * wants to see the active or the inactive state of the partitions that belong
 * to the DC.
 * </p>
 * <p>
 * <b>Isolation</b>
 * </p>
 * <p>
 * When a client wants to change a partition, it needs a copy of this partition
 * in its own, client-specific, stage. This stage has precedence for this client
 * over all shared stages. A client thus sees the client-specific version of all
 * partitions for which a client-specific version for this client exists.
 * Client-specific partitions are not visible for other clients. MOIN thus
 * isolates uncommitted (not yet checked-in) changes done by a specific client
 * from all other clients of the same data area.
 * </p>
 * <p>
 * The client-specific stage can also be used to sync to a certain version of a
 * partition, e.g. to see previous versions or to decouple oneself from future
 * check-ins being done by others.
 * </p>
 * <p>
 * <b>Single-stage-scenarios</b>
 * </p>
 * <p>
 * In the IDE scenario as well as in the build scenario, the usage of shared
 * stages is not appropriate - the developer's PC (or the build machine) is
 * already set up thus that it is fully isolated against other clients, and two
 * different clients will never access the same MOIN at the same time.
 * Therefore, only one client is used (which even gets a default name), and only
 * one client-specific stage is used.
 * </p>
 * <p>
 * <b>Stages in Read-Only-DataAreas</b>
 * </p>
 * <p>
 * Read-only data areas expose data that cannot be changed by any client. A very
 * prominent example for this is the metamodel data area.
 * </p>
 * <p>
 * Such data areas will use a shared stage only and will not allow to create
 * client-specific stages. Further, using one single client for all purposes is
 * sufficient.
 * </p>
 * 
 * @author d020383
 */
public interface SpiStage {

    /**
     * The DataAreaDescriptor of the data area to which this Stage belongs.
     * 
     * @return
     */
    public DataAreaDescriptor getDataAreaDescriptor( );

    /**
     * A human readable name.
     */
    public String getName( );

    /**
     * Returns true if the Stage is client-specific. The returned value is the
     * same as !isShared();
     */
    public boolean isClientSpecific( );

    /**
     * Returns true if the Stage is shared. The returned value is the same as
     * !isClientSpecific();
     */
    public boolean isShared( );

    /**
     * For client-specific stages, the id of the client-spec is returned. For
     * shared stages, an UnsupportedOperationException is thrown.
     */
    public String getClientSpecId( );
}
