package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaDescriptorFactory;
import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaManager;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiServiceException;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiCustomContentSelectionManagement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * @author d021091
 */
public abstract class DiServiceImpl implements IpiFacilityComponent, SpiLifecycleManagement, SpiCustomContentSelectionManagement {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, DiServiceImpl.class );

    protected static final Object[] N0_ARGS = null;

    protected IpiDataAreaManager _dataAreaManager;

    protected IpiDataAreaDescriptorFactory _dataAreaDescriptorFactory;

    protected ResourceIdentifierFactory _riFactory;

    protected DiContentSelectionRegistryImpl _customContentSelectionRegistry;

    protected SpiPartitionSerializationManager _customSerializationRegistry;

    /** ******************** Construction *********************************** */

    protected DiServiceImpl( ) {

    }

    public void bind( IpiDataAreaManager dataAreaManager ) {

        _dataAreaManager = dataAreaManager;
    }

    public void bind( ResourceIdentifierFactory riFactory ) {

        _riFactory = riFactory;
    }

    public void bind( SpiPartitionSerializationManager customParserSerializerRegistry ) {

        _customContentSelectionRegistry = new DiContentSelectionRegistryImpl( customParserSerializerRegistry );
        _customSerializationRegistry = customParserSerializerRegistry;
    }

    public void bind( IpiDataAreaDescriptorFactory dataAreaDescriptorFactory ) {

        _dataAreaDescriptorFactory = dataAreaDescriptorFactory;
    }

    public void initialize( ) {

        if ( _customContentSelectionRegistry == null ) {
            // Create a dummy-registry
            _customContentSelectionRegistry = new DiContentSelectionRegistryImpl( null );
        }
    }

    public void tearDown( ) {

    }

    public void finalizeStartup( ) {

    }

    /** ************* SpiCustomContentSelectionManagement ****************** */

    public CheckResult checkContentSelectionProperties( ) {

        return _customContentSelectionRegistry.checkContentSelectionProperties( );
    }

    /** ********************* IpiDiService ********************************* */

    /**
     * The methods checks if a reference from a model element in partition
     * <code>usingPri</code> to a model element in partition
     * <code>usedPri</code> is allowed according to the rules of the underlying
     * infrastructure, i.e. to the SAP component model. This means that it must
     * be basically possible to navigate from a model element in partition
     * <code>usingPri</code> to a model element in partition
     * <code>usedPri</code> and to properly instantiate the respective link in
     * MOIN core in any scenario (also in Build scenario where only PPs of used
     * DCs are synced).
     * <p>
     * Example:
     * <p>
     * In SAP component model this reference is allowed when:
     * <p>
     * - The two model elements are located in the same container (DC).
     * <p>
     * - The two model elements are located in different containers:
     * <code>usingPri</code> is located in source-DC and <code>usedPri</code> is
     * located in destination-DC.
     * <p>
     * -- Additionally there is at least one usage relation from source-DC to a
     * public part of destination-DC
     * <p>
     * -- and <code>usedPri</code> is contained in one of those referenced
     * public parts.
     * <p>
     * Remark:
     * <p>
     * The parameter <code>clientSpecOfUsingPri</code> determines which client
     * spec builds the context for the creation of the reference. This client
     * spec is used to determine the container usage relations.
     * <p>
     * The parameter <code>clientSpecOfUsedPri</code> is needed for the future
     * handling of cross-data-area-links (e.g. ESR use-case: absolute SC
     * references).
     * <p>
     * If we would use only the respective clientSpecId then in the JEE scenario
     * this could mean that we need a DB access to retrieve the respective
     * client spec. On the other side, the Core has already available the client
     * spec in the context of a session and the respective compoundClientSpec.
     */

    public boolean isLinkBackedByContainerUsage( PRI usingPri, PRI usedPri, SpiClientSpec clientSpecOfUsingPri, SpiClientSpec clientSpecOfUsedPri ) {

        // Precondition checks:
        checkParameter( "isLinkBackedByContainerUsage", usingPri ); //$NON-NLS-1$
        checkParameter( "isLinkBackedByContainerUsage", usedPri ); //$NON-NLS-1$
        checkParameter( "isLinkBackedByContainerUsage", clientSpecOfUsingPri ); //$NON-NLS-1$
        checkParameter( "isLinkBackedByContainerUsage", clientSpecOfUsedPri ); //$NON-NLS-1$

        // Determine the source container (source DC) and destination container (destination DC) for the container usage relation:
        CRI srcCri = usingPri.getCri( );
        CRI destCri = usedPri.getCri( );

        // (1) Links between model elements in the same DC are allowed:
        if ( srcCri.equals( destCri ) ) {
            return true; // link is allowed
        }

        // (2) Cross data area links: are not yet allowed
        // Remark:
        // This is the future use case of ESR concerning the absolute SC references. 
        // If such an absolute SC reference exists then a respective cross data area reference is allowed.
        // But it will be not allowed especially for links from a synced DevConfigImport to a local DevConfigImport.
        if ( !clientSpecOfUsedPri.equals( clientSpecOfUsingPri ) ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                Object[] args = { usingPri.getPartitionName( ), clientSpecOfUsingPri, usedPri.getPartitionName( ), clientSpecOfUsedPri };
                LOGGER.trace( MoinSeverity.INFO, "isLinkBackedByContainerUsage: is false because the partitions belong to different client specs: using Partition [name: {0}, client spec: {1}], used Partition [name: {2}, client spec: {3}].", args ); //$NON-NLS-1$
            }
            return false;
        }

        // (3) Links between model elements in different DCs are not allowed, when:

        // (3.1) there is no usage relation between the DCs
        //(in Detail: usage relation for build-time to public part purpose compilation)
        DiConfigurationImpl diConfiguration = getAndCheckDiConfiguration( clientSpecOfUsingPri );
        if ( diConfiguration == null ) {
            // DiConfiguration is no longer valid, e.g. because DevConfig-Import was removed in the meanwhile
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                Object[] args = { usingPri.getPartitionName( ), clientSpecOfUsingPri, usedPri.getPartitionName( ), clientSpecOfUsedPri };
                LOGGER.trace( MoinSeverity.INFO, "isLinkBackedByContainerUsage: is false because the DiConfiguration for the client spec of the using partition was not found: using Partition [name: {0}, client spec: {1}], used Partition [name: {2}, client spec: {3}].", args ); //$NON-NLS-1$
            }
            return false;
        }
        DiDevelopmentComponentImpl srcDc = getAndCheckDiMoinDcDefinition( diConfiguration, srcCri );
        DiDevelopmentComponentImpl destDc = getAndCheckDiMoinDcDefinition( diConfiguration, destCri );
        if ( srcDc == null || destDc == null ) {
            // DiDcDefinition is no longer valid, e.g. because DC was removed/deleted in the meanwhile
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                Object[] args = { usingPri.getPartitionName( ), clientSpecOfUsingPri, srcCri.getContainerName( ), usedPri.getPartitionName( ), clientSpecOfUsedPri, destCri.getContainerName( ) };
                LOGGER.trace( MoinSeverity.INFO,
                              ( ( srcDc == null ) ? "isLinkBackedByContainerUsage: is false because the development component of the using partition is not registered for MOIN: using Partition [name: {0}, client spec: {1}, dc: {2}], used Partition [name: {3}, client spec: {4}, dc: {5}]." //$NON-NLS-1$
                                                 : "isLinkBackedByContainerUsage: is false because the development component of the used partition is not registered for MOIN: using Partition [name: {0}, client spec: {1}, dc: {2}], used Partition [name: {3}, client spec: {4}, dc: {5}]." ), args ); //$NON-NLS-1$
            }
            return false;
        }
        ArrayList<DiPublicPartImpl> destPps = getReferencedPps( srcDc, destDc );
        if ( destPps == null ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                Object[] args = { usingPri.getPartitionName( ), clientSpecOfUsingPri, srcDc, usedPri.getPartitionName( ), clientSpecOfUsedPri, destDc };
                LOGGER.trace( MoinSeverity.INFO, "isLinkBackedByContainerUsage: is false because the development component of used partition does not have MOIN relevant public parts: using partition [name: {0}, client spec: {1}, dc: {2}], used partition [name: {3}, client spec: {4}, dc: {5}].", //$NON-NLS-1$
                              args );
            }
            return false;
        }

        // (3.2) the usedPri is not in one of the referenced public parts of the destination DC:
        for ( DiPublicPartImpl destPp : destPps ) {

            if ( destPp.containsPartition( usedPri ) ) {
                return true; // link is allowed
            }
        }

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            Object[] args = { usingPri.getPartitionName( ), clientSpecOfUsingPri, srcDc, usedPri.getPartitionName( ), clientSpecOfUsedPri, destDc };
            LOGGER.trace( MoinSeverity.INFO, "isLinkBackedByContainerUsage: is false because used partition is not in a public part: using partition [name: {0}, client spec: {1}, dc: {2}], used partition [name: {3}, client spec: {4}, dc: {5}].", args ); //$NON-NLS-1$
        }

        // (4) Special cases:

        // (4.1) Links between MM-DCs and non-MM-DCs: 
        // Those links are not reasonable, but we do not spent time to check this here, because:
        // MOF-editor already provides (or should provide) mechanisms to prevent those links:
        // - A link must be backed by an association in the respective meta model, this association has to be created in MOF-editor. 
        //   The MOF-editor provides only reasonable editing features and additionally can check for such associations.
        // - Cases:
        //   -- MM-DC --> not MM-DC: i.e. association from element in MOF meta model to element in user defined meta model
        //   -- Not MM-DC --> MM-DC: i.e. association from element in concrete meta model to element in MOF meta model
        // If we face use cases where a check is needed, then this can be easily performed:
        // Retrieve and compare the DcType of srcDc and destDc, they must be equal if one of them is the MM DcType.

        // (4.2) Links from versioned DCs to local-only DCs 
        // This should be allowed, the developer still could add the destination DC to version-control afterwards, if she misses this, then it is here fault ...

        return false;
    }

    /**
     * The underlying infrastructure defines usage relations between containers.
     * Those usage relations define which parts of which containers content are
     * visible for which other containers. The method returns those containers
     * for which their content is visible for the given container defined by
     * <code>cri</code>.
     * <p>
     * Remark:
     * <p>
     * The parameter <code>clientSpec</code> determines which client spec builds
     * the context for the creation of the reference. This client spec is used
     * to determine the container usage relations.
     */

    public Collection<CRI> getVisibleContainers( SpiClientSpec clientSpec, CRI cri ) {

        // Precondition checks:
        checkParameter( "getVisibleContainers", clientSpec ); //$NON-NLS-1$
        checkParameter( "getVisibleContainers", cri ); //$NON-NLS-1$

        DiConfigurationImpl diConfiguration = getAndCheckDiConfiguration( clientSpec );
        if ( diConfiguration == null ) {
            // DiConfiguration is no longer valid, e.g. because DevConfig-Import was removed in the meanwhile
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "getVisibleContainers: DiConfiguration not found for client spec {0}.", clientSpec.getClientId( ) ); //$NON-NLS-1$
            }
            return Collections.emptyList( );
        }
        DiDevelopmentComponentImpl dc = getAndCheckDiMoinDcDefinition( diConfiguration, cri );
        if ( dc == null ) {
            // DiDcDefinition is no longer valid, e.g. because DC was removed/deleted in the meanwhile
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "getVisibleContainers: DC definition {0} not found for client spec {1}.", cri.getContainerName( ), clientSpec.getClientId( ) ); //$NON-NLS-1$
            }
            return Collections.emptyList( );
        }
        return dc.getVisibleDcs( );
    }

    public Collection<PRI> getOuterPartitions( SpiClientSpec clientSpec, CRI cri, List<PartitionOperation> dirtyPartitions ) {

        // Precondition checks:
        checkParameter( "getOuterPartitions", clientSpec ); //$NON-NLS-1$
        checkParameter( "getOuterPartitions", cri ); //$NON-NLS-1$
        checkParameter( "getOuterPartitions", dirtyPartitions ); //$NON-NLS-1$

        DiConfigurationImpl diConfiguration = getAndCheckDiConfiguration( clientSpec );
        if ( diConfiguration == null ) {
            // DiConfiguration is no longer valid, e.g. because DevConfig-Import was removed in the meanwhile
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "getOuterPartitions: DiConfiguration not found for client spec {0}.", clientSpec.getClientId( ) ); //$NON-NLS-1$
            }
            return Collections.emptyList( );
        }
        DiDevelopmentComponentImpl dc = getAndCheckDiMoinDcDefinition( diConfiguration, cri );
        if ( dc == null ) {
            // DiDcDefinition is no longer valid, e.g. because DC was removed/deleted in the meanwhile
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "getOuterPartitions: DC definition {0} not found for client spec {1}.", cri.getContainerName( ), clientSpec.getClientId( ) ); //$NON-NLS-1$
            }
            return Collections.emptyList( );
        }
        return dc.getVisiblePartitions( this, dirtyPartitions );
    }

    public void ensureCreatingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionCreatingNotPossibleException {

        // Precondition checks:
        checkParameter( "ensureCreatingAllowed", pri ); //$NON-NLS-1$
        checkParameter( "ensureCreatingAllowed", clientSpec ); //$NON-NLS-1$

        // First implementation: preparation approach
        // Future implementation: implicit check-out-approach can be switched on by preferences in the environment (e.g. Eclipse preferences)
        // --> first step: check the preference settings to decide between preparation approach and implicit check-out-approach.

        // Preparation approach:
        // - Preprocessing:
        //   The partition cannot be prepared for creation. It can only be checked, if there would come up name-clashes ...
        // - MoinCore asks Facility ensureCreatingAllowed.
        // - Post-processing: 
        //   The partition (now available on local disc) is c-o-f-add. 
        //   In the special case 'partition was c-o-f-delete' the partition is reverted and c-o-f-edit.

        // Creating is not allowed when:
        // (1) The pri belongs to a data area which cannot be modified (e.g. meta model data area)
        if ( !isDataAreaModifiable( pri.getDataAreaDescriptor( ) ) ) {
            // DATA_AREA_IS_UNMODIFIABLE=Partition [name\: {0}, development component\: {1}] cannot be created\/edited\/deleted because it belongs to an unmodifiable data area [name\: {2}].
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ), pri.getDataAreaDescriptor( ).getDataAreaName( ) };
            PartitionCreatingNotPossibleException e = new PartitionCreatingNotPossibleException( DiServiceMessages.DATA_AREA_IS_UNMODIFIABLE, pri, args );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e, MoinSeverity.INFO );
            }
            throw e;
        }

        // (2) The pri belongs to a container (DC) which is not modifiable (e.g. because the DC is synced from active DTR-workspace)
        if ( !isContainerModifiable( pri.getCri( ), clientSpec ) ) {
            // DEVELOPMENT_COMPONENT_IS_UNMODIFIABLE=Partition [name\: {0}, development component\: {1}] cannot be created\/edited\/deleted because it belongs to an unmodifiable development component.
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ) };
            PartitionCreatingNotPossibleException e = new PartitionCreatingNotPossibleException( DiServiceMessages.DEVELOPMENT_COMPONENT_IS_UNMODIFIABLE, pri, args );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e, MoinSeverity.INFO );
            }
            throw e;
        }

        // (3) there is no serializer for the given parition        
        if ( !_customSerializationRegistry.isSerializerAvailable( pri ) ) {
            PartitionCreatingNotPossibleException e = new PartitionCreatingNotPossibleException( DiServiceMessages.PARTITION_NO_SERIALIZER, pri );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e, MoinSeverity.INFO );
            }
            throw e;
        }

        // (3) The partition already exists or cannot be created in persistence.
        // Remark: In case of inconsistencies (partition exists on local disc with same or different upper / lower case an exception is thrown
        try {
            checkPartitionIsCreatable( pri );
        } catch ( IpiDiServiceException e ) {
            throw new PartitionCreatingNotPossibleException( e, pri );
        }

        // (4) We do not check versioning aspects, because this would probably include Server-communication and therefore be too expensive
        // --> If we face problems with this handling, then we have to investigate a cheap way to retrieve the check-out-state of a resource

        return;
    }

    public void ensureEditingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionEditingNotPossibleException {

        internalEnsureEditingAllowed( pri, clientSpec, "ensureEditingAllowed" ); //$NON-NLS-1$
    }

    private void internalEnsureEditingAllowed( PRI pri, SpiClientSpec clientSpec, String method ) throws PartitionEditingNotPossibleException {

        // First implementation: preparation approach
        // Future implementation: implicit check-out-approach can be switched on by preferences in the environment (e.g. Eclipse preferences)
        // --> first step: check the preference settings to decide between preparation approach and implicit check-out-approach.

        // Preparation approach:
        // - Preprocessing:
        //   The partition is c-o-f-edit and made writable on local disc.
        // - MoinCore asks Facility ensureEditingAllowed.
        // - Post-processing: 
        //   No special versioning actions or actions on local disc. 

        // Precondition checks:
        checkParameter( "ensureEditingAllowed", pri ); //$NON-NLS-1$
        checkParameter( "ensureEditingAllowed", clientSpec ); //$NON-NLS-1$

        // Editing is not allowed when:        
        // (1) The partition belongs to a data area which cannot be modified (e.g. meta model data area)
        if ( !isDataAreaModifiable( pri.getDataAreaDescriptor( ) ) ) {
            // DATA_AREA_IS_UNMODIFIABLE=Partition [name\: {0}, development component\: {1}] cannot be created\/edited\/deleted because it belongs to an unmodifiable data area [name\: {2}].
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ), pri.getDataAreaDescriptor( ).getDataAreaName( ) };
            PartitionEditingNotPossibleException e = new PartitionEditingNotPossibleException( DiServiceMessages.DATA_AREA_IS_UNMODIFIABLE, pri, args );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e, MoinSeverity.INFO );
            }
            throw e;
        }

        // (2) The partition belongs to a container which is not modifiable (e.g. because it is synced from active DTR-workspace)
        if ( !isContainerModifiable( pri.getCri( ), clientSpec ) ) {
            // DEVELOPMENT_COMPONENT_IS_UNMODIFIABLE=Partition [name\: {0}, development component\: {1}] cannot be created\/edited\/deleted because it belongs to an unmodifiable development component.
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ) };
            PartitionEditingNotPossibleException e = new PartitionEditingNotPossibleException( DiServiceMessages.DEVELOPMENT_COMPONENT_IS_UNMODIFIABLE, pri, args );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e, MoinSeverity.INFO );
            }
            throw e;
        }

        // (3) The partition does not exist.
        if ( !doesPartitionExist( pri ) ) {
            // PARTITION_DOES_NOT_EXIST=Partition [name\: {0}, development component\: {1}] cannot be edited\/deleted because it does not exist.
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ) };
            PartitionEditingNotPossibleException e = new PartitionEditingNotPossibleException( DiServiceMessages.PARTITION_DOES_NOT_EXIST, pri, args );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e, MoinSeverity.INFO );
            }
            throw e;
        }

        // (4) We do not check versioning aspects, because this would probably include Server-communication and therefore be too expensive
        // --> If we face problems with this handling, then we have to investigate an cheap way to retrieve the check-out-state of a resource

        // (5a) Check if a serializer is available.        
        if ( !_customSerializationRegistry.isSerializerAvailable( pri ) ) {
            PartitionEditingNotPossibleException e = new PartitionEditingNotPossibleException( DiServiceMessages.PARTITION_NO_SERIALIZER, pri );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e, MoinSeverity.INFO );
            }
            throw e;
        }

        // (5) The identified partition is not writable on local disc.
        try {
            if ( isPartitionReadOnly( pri ) ) {
                // PARTITION_IS_READ_ONLY=Partition [name\: {0}, development component\: {1}] cannot be edited\/deleted because the partition file is read-only.
                Object[] args = { pri.getPartitionName( ), pri.getContainerName( ) };
                PartitionEditingNotPossibleException e = new PartitionEditingNotPossibleException( DiServiceMessages.PARTITION_IS_READ_ONLY, pri, args );
                if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                    LOGGER.trace( e, MoinSeverity.INFO );
                }
                throw e;
            }
        } catch ( Exception e ) {
            // ACCESS_TO_LOCAL_DISC_FAILED=Partition [name\: {0}, development component\: {1}] cannot be edited/deleted because the access to the partition file on local disc failed\: {2}.
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ), e.getMessage( ) };
            PartitionEditingNotPossibleException e1 = new PartitionEditingNotPossibleException( DiServiceMessages.ACCESS_TO_LOCAL_DISC_FAILED, pri, args );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e1, MoinSeverity.INFO );
            }
            throw e1;
        }
        return;
    }

    public void ensureDeletingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionDeletingNotPossibleException {

        // Precondition checks:
        checkParameter( "ensureDeletingAllowed", pri ); //$NON-NLS-1$
        checkParameter( "ensureDeletingAllowed", clientSpec ); //$NON-NLS-1$

        // First implementation: preparation approach
        // Future implementation: implicit check-out-approach can be switched on by preferences in the environment (e.g. Eclipse preferences)
        // --> first step: check the preference settings to decide between preparation approach and implicit check-out-approach.

        // Preparation approach:
        // - Preprocessing:
        //   The partition is exclusively-c-o-f-edit and made writable on local disc.
        // - MoinCore asks Facility ensureDeletingAllowed.
        // - Post-processing: 
        //   The partition is reverted and c-o-f-delete and removed from local disc. 

        // Deleting is not allowed when:
        // (1) The pri belongs to a data area which cannot be modified
        // (2) The pri belongs to a container which is not modifiable (e.g. because it is synced from active DTR-workspace)
        // (3) The identified partition does not exist. --> should we allow this as an no-op?
        // (4) We do not check versioning aspects, because this would probably include Server-communication and therefore be too expensive
        // --> If we face problems with this handling, then we have to investigate an cheap way to retrieve the check-out-state of a resource
        // (5) The identified partition is not writable on local disc.

        // --> Analogous conditions for the delete-operation and for the edit-operation:
        // (Remark: we do not check for explicit c-o-f-edit --> see remark concerning versioning aspects above)
        try {
            internalEnsureEditingAllowed( pri, clientSpec, "ensureDeletingAllowed" ); //$NON-NLS-1$
        } catch ( PartitionEditingNotPossibleException e ) {
            throw new PartitionDeletingNotPossibleException( e );
        }
    }

    public boolean isContainerModifiable( CRI cri, SpiClientSpec clientSpec ) {

        // Precondition checks:
        checkParameter( "isContainerModifiable", cri ); //$NON-NLS-1$
        checkParameter( "isContainerModifiable", clientSpec ); //$NON-NLS-1$

        if ( cri.isVolatileContainer( ) ) {
            return true;
        }

        DiConfigurationImpl diConfiguration = getAndCheckDiConfiguration( clientSpec );
        if ( diConfiguration == null ) {
            // DiConfiguration is no longer valid, e.g. because DevConfig-Import was removed in the meanwhile
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "isContainerModifiable: DiConfiguration not found for client spec {0}.", clientSpec.getClientId( ) ); //$NON-NLS-1$
            }
            return false;
        }
        DiDevelopmentComponentImpl dc = getAndCheckDiMoinDcDefinition( diConfiguration, cri );
        if ( dc == null ) {
            // DiDcDefinition is not / no longer valid, e.g. because DC was removed/deleted in the meanwhile
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "isContainerModifiable: DC definition {0} not found for client spec {1}.", cri.getContainerName( ), clientSpec.getClientId( ) ); //$NON-NLS-1$
            }
            return false;
        }
        if ( !dc.isModifiable( ) ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "isContainerModifiable: the development component [name: {0}, client spec: {1}] is unmodifiable.", cri.getContainerName( ), clientSpec.getClientId( ) ); //$NON-NLS-1$
            }
            return false;
        }
        return true;
    }

    /** ********************* API for sub classes ************************** */

    /**
     * The scenario-specific implementations have to take care for caching &
     * refreshing & retrieval of the DiConfigurations in a scenario-specific way
     * (e.g. cached transiently or on DB).
     * <p>
     * --> This also might involve that the DiConfiguration is no longer valid,
     * e.g. because the DevConfig-Import was removed in the meanwhile. In this
     * case the method has to return NULL.
     */
    protected abstract DiConfigurationImpl getAndCheckDiConfiguration( SpiClientSpec clientSpec );

    /**
     * The scenario-specific implementations have to take care for caching &
     * refreshing & retrieval of the DiDevelopmentComponents in a
     * scenario-specific way (e.g. cached transiently or on DB).
     * <p>
     * --> This also might involve that the DiDevelopmentComponents are no
     * longer valid, e.g. because the DevConfig-Import was removed or DC was
     * removed or deleted in the meanwhile. In this case the method has to
     * return NULL.
     */
    protected abstract DiDevelopmentComponentImpl getAndCheckDiMoinDcDefinition( DiConfigurationImpl diConfiguration, CRI cri );

    protected abstract Collection<DiDevelopmentComponentImpl> getAndCheckDiMoinDcDefinitions( DiConfigurationImpl diConfiguration );

    protected ArrayList<DiPublicPartImpl> getReferencedPps( DiDevelopmentComponentImpl srcDc, DiDevelopmentComponentImpl destDc ) {

        ArrayList<DiPublicPartImpl> ppsVisibleForSrcDc = srcDc.getReferencedPpsVisibleForCompilation( );
        Iterator<DiPublicPartImpl> iter = ppsVisibleForSrcDc.iterator( );
        while ( iter.hasNext( ) ) {
            DiPublicPartImpl pp = iter.next( );
            if ( !pp.getDevelopmentComponent( ).getModelContainerName( ).equals( destDc.getModelContainerName( ) ) ) {
                iter.remove( );
            }
        }
        ppsVisibleForSrcDc.trimToSize( );
        return ppsVisibleForSrcDc;
    }

    protected abstract Collection<PRI> getPersistedPartitions( CRI cri );

    /** ******************** Internals ************************************** */

    private boolean isDataAreaModifiable( DataAreaDescriptor dataAreaDescriptor ) {

        IpiDataArea dataArea = _dataAreaManager.getDataAreaByName( dataAreaDescriptor.getDataAreaName( ) );
        return dataArea.isModifiable( );
    }

    protected abstract void checkPartitionIsCreatable( PRI pri ) throws IpiDiServiceException;

    protected abstract boolean doesPartitionExist( PRI pri );

    protected abstract boolean isPartitionReadOnly( PRI pri );

    protected void checkParameter( String methodName, CRI cri ) {

        if ( cri == null ) {
            // Message: "Method "{0}"\: Argument with name "{1}" has an illegal value
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( methodName, "cri", "null" ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
    }

    protected void checkParameter( String methodName, PRI pri ) {

        if ( pri == null ) {
            // Message: "Method "{0}"\: Argument with name "{1}" has an illegal value
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( methodName, "pri", "null" ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
    }

    protected void checkParameter( String methodName, SpiClientSpec clientSpec ) {

        if ( clientSpec == null ) {
            // Message: "Method "{0}"\: Argument with name "{1}" has an illegal value
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( methodName, "clientSpec", "null" ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
    }

    protected void checkParameter( String methodName, List<PartitionOperation> dirtyPartitions ) {

        if ( dirtyPartitions == null ) {
            // Message: "Method "{0}"\: Argument with name "{1}" has an illegal value
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( methodName, "dirtyPartitions", "null" ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
    }
}
