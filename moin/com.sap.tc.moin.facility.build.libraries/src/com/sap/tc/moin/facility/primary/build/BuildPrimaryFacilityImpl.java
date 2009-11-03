package com.sap.tc.moin.facility.primary.build;

import java.io.File;
import java.util.Collection;

import com.sap.tc.moin.facility.primary.AbstractFsPrimaryFacility;
import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.facility.primary.dataareamgmt.impl.AbstractDataAreaManagerImpl;
import com.sap.tc.moin.facility.primary.dataareamgmt.impl.SimpleDataAreaManagerImpl;
import com.sap.tc.moin.facility.primary.diservice.build.impl.BuildDiServiceImpl;
import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaDescriptorFactory;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityEventNotifier;
import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.diservice.build.IpiBuildDiService;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.facility.primary.metamodelmanager.IndexMetaModelPartitionManagerImpl;
import com.sap.tc.moin.facility.primary.metamodelmanager.IndexMofRomInjectionServiceImpl;
import com.sap.tc.moin.facility.primary.persistence.fs.FacilityEventNotifierImpl;
import com.sap.tc.moin.facility.primary.persistence.fs.FsPersistenceImpl;
import com.sap.tc.moin.facility.primary.persistence.fs.ResourceManagementImpl;
import com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl.FsFactory;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.facility.primary.riservice.CheckedResourceIdentifierFactoryImpl;
import com.sap.tc.moin.facility.primary.riservice.DiResourceIdentifierFactoryImpl;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiExternalSaveLocking;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;
import com.sap.tc.moin.repository.spi.facility.SpiInternalDistributedDirtyLocking;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.spi.facility.SpiMQLQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsFacility;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsMetaModelManager;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiCustomContentSelectionManagement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

public class BuildPrimaryFacilityImpl extends AbstractFsPrimaryFacility implements SpiFsFacility, BuildPrimaryFacility {

    private IndexMetaModelPartitionManagerImpl indexMetaModelPartitionManager;

    private IndexMofRomInjectionServiceImpl mofRomInjectionService;

    private BuildDiServiceImpl buildDiService;

    private FsPersistenceImpl fsIndexPersistence;

    private ResourceManagementImpl resourceManagement;

    private IndexImpl index;

    private AbstractDataAreaManagerImpl dataAreaManager;

    private FacilityEventNotifierImpl facilityEventNotifier;

    private FsFactory fsFactory;

    private DiResourceIdentifierFactoryImpl diResourceIdentifierFactory;

    private CheckedResourceIdentifierFactoryImpl checkedResourceIdentifierFactory;

    public BuildPrimaryFacilityImpl( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext ) {

        super( core, serializationManager, runtimeContext );
        configureFacility( );
    }

    private void configureFacility( ) {

        // phase 1: construct sub-components
        ////////////////////////////////////

        this.fsFactory = new FsFactory( );
        this.facilityComponents.add( this.fsFactory );

        // Data Area Manager
        this.dataAreaManager = new SimpleDataAreaManagerImpl( );
        this.facilityComponents.add( this.dataAreaManager );

        // Di Service
        this.buildDiService = new BuildDiServiceImpl( );
        this.facilityComponents.add( this.buildDiService );

        this.diResourceIdentifierFactory = new DiResourceIdentifierFactoryImpl( this.core.getReferenceQueue( ) );
        this.facilityComponents.add( this.diResourceIdentifierFactory );

        this.checkedResourceIdentifierFactory = new CheckedResourceIdentifierFactoryImpl( );
        this.facilityComponents.add( this.checkedResourceIdentifierFactory );

        // Index without Dump
        this.index = new IndexImpl( this.getId( ), this.core.getMoinId( ), this.core.getReferenceQueue( ) );
        this.facilityComponents.add( this.index );

        // resource management
        this.resourceManagement = new ResourceManagementImpl( );
        this.facilityComponents.add( this.resourceManagement );

        // persistence
        this.fsIndexPersistence = new FsPersistenceImpl( this.core.getMoinId( ), this.core.getReferenceQueue( ) );
        this.facilityComponents.add( this.fsIndexPersistence );

        // facility event manager
        this.facilityEventNotifier = new FacilityEventNotifierImpl( );
        this.facilityComponents.add( this.facilityEventNotifier );

        // meta-model manager
        this.indexMetaModelPartitionManager = new IndexMetaModelPartitionManagerImpl( );
        this.facilityComponents.add( this.indexMetaModelPartitionManager );

        // mof rom injection service
        this.mofRomInjectionService = new IndexMofRomInjectionServiceImpl( );
        this.facilityComponents.add( this.mofRomInjectionService );

        // phase 2: bind sub-components
        ///////////////////////////////

        // Data Area Manager
        this.dataAreaManager.bind( this.core.getStageFactory( ) );
        this.dataAreaManager.bind( this.diResourceIdentifierFactory );
        this.dataAreaManager.bind( this );

        // Project Handler

        // Di Service
        this.buildDiService.bind( this.index );
        this.buildDiService.bind( this.resourceManagement );
        this.buildDiService.bind( this.dataAreaManager );
        this.buildDiService.bind( (ResourceIdentifierFactory) this.diResourceIdentifierFactory );
        this.buildDiService.bind( (IpiDataAreaDescriptorFactory) this.diResourceIdentifierFactory );
        this.buildDiService.bind( this.partitionSerializationManager );

        // Ri factory
        this.checkedResourceIdentifierFactory.bind( this.diResourceIdentifierFactory );
        this.checkedResourceIdentifierFactory.bind( this.resourceManagement );
        this.checkedResourceIdentifierFactory.bind( this.partitionSerializationManager );

        // Index
        this.index.bind( this.partitionSerializationManager );
        this.index.bind( this.core.getMetamodelService( ) );

        // Resource Management
        this.resourceManagement.bind( this.dataAreaManager );
        this.resourceManagement.bind( this.facilityEventNotifier );
        this.resourceManagement.bind( this.fsFactory, this.fsFactory );
        this.resourceManagement.bind( this.diResourceIdentifierFactory );
        this.resourceManagement.bind( this.index );
        this.resourceManagement.bind( this.partitionSerializationManager );

        // Persistence
        this.fsIndexPersistence.bind( (IpiFsResourceManagement) this.resourceManagement );
        this.fsIndexPersistence.bind( this.index );
        this.fsIndexPersistence.bind( this.indexMetaModelPartitionManager );
        this.fsIndexPersistence.bind( this.partitionSerializationManager );
        this.fsIndexPersistence.bind( this.diResourceIdentifierFactory );

        // MetaModel Partition Manager
        this.indexMetaModelPartitionManager.bind( this.index );
        this.indexMetaModelPartitionManager.bind( this.dataAreaManager );

        // MOFROM Injection Service
        this.mofRomInjectionService.bind( this.index );

        // Facility event notifier
        this.facilityEventNotifier.bind( this.core.getPartitionService( ) );
    }


    public SpiExternalSaveLocking getExternalSaveLocking( ) {

        return null;
    }

    public SpiInternalDistributedDirtyLocking getInternalDistributedDirtyLocking( DataArea dataArea ) {

        return null;
    }

    public SpiFsMetaModelManager getFsMetaModelManager( ) {

        return this.indexMetaModelPartitionManager;
    }

    public SpiMofRomInjectionService getMofRomInjectionService( ) {

        return this.mofRomInjectionService;
    }

    // Implementation of SPI interface.

    public SpiPersistence getModelPersistence( ) {

        return this.fsIndexPersistence;
    }

    public SpiCoreQueryService getCoreQueryService( ) {

        return this.index;
    }

    public SpiMQLQueryService getMQLQueryService( ) {

        return this.index;
    }

    public ResourceIdentifierFactory getRIFactory( ) {

        return this.checkedResourceIdentifierFactory;
    }

    public SpiLifecycleManagement getLifecycleManagement( ) {

        return this.buildDiService;
    }

    /*
     * Getters for internal components
     */

    // used by the XMLConverter
    public IpiBuildDiService getBuildDiService( ) {

        return this.buildDiService;
    }

    @Override
    public IpiFsResourceManagement getResourceManagement( ) {

        return this.resourceManagement;
    }

    public IpiFacilityEventNotifier getFacilityEventManager( ) {

        return this.facilityEventNotifier;
    }

    /*
     * Facade functions to satisfy API
     */

    public String getId( ) {

        return PrimaryFacility.FACILITY_ID;
    }

    public DataArea getMetamodelDataArea( ) {

        return this.dataAreaManager.getMetaModelDataArea( );
    }

    public SpiClientSpec getMetamodelClientSpec( ) throws SpiFacilityException {

        return ( (IpiDataArea) this.dataAreaManager.getMetaModelDataArea( ) ).getSingleClientSpec( );
    }

    public DataArea getTransientDataArea( ) {

        return this.dataAreaManager.getTransientDataArea( );
    }

    public ClientSpec getTransientClientSpec( ) throws SpiFacilityException {

        return ( (IpiDataArea) this.dataAreaManager.getTransientDataArea( ) ).getSingleClientSpec( );
    }

    public Collection<String> getDataAreaNames( ) {

        return this.dataAreaManager.getDataAreaNames( );
    }

    public DataArea getDataAreaByName( String name ) {

        // delegate to dataAreaManager
        return this.dataAreaManager.getDataAreaByName( name );
    }

    public File getFile( PRI pri ) {

        if ( pri != null ) {
            IpiStorage storage = this.resourceManagement.getStorageResponsibleForPRI( pri );
            if ( storage != null ) {
                IpiLogicalResource resourceHandle = storage.getPartitionResourceHandle( pri );
                if ( resourceHandle != null ) {
                    return resourceHandle.getUnderlyingResource( File.class );
                }
            }
        }
        return null;
    }

    public long getModificationTime( PRI pri ) {

        return this.index.getPartitionTimestamp( pri );
    }

    public SpiCustomContentSelectionManagement getCustomContentSelectionManagement( ) {

        return this.buildDiService;
    }

}
