package com.sap.tc.moin.facility.filesystem;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import com.sap.tc.moin.facility.componentmodel.CMManager;
import com.sap.tc.moin.facility.filesystem.componentmodel.CMFSServices;
import com.sap.tc.moin.facility.filesystem.componentmodel.services.FsLifecycleServiceImpl;
import com.sap.tc.moin.facility.filesystem.componentmodel.services.FsPersistenceExtImpl;
import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.facility.primary.dataareamgmt.impl.AbstractDataAreaManagerImpl;
import com.sap.tc.moin.facility.primary.dataareamgmt.impl.SimpleDataAreaManagerImpl;
import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiQuery;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsFacilityForTest;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.facility.primary.metamodelmanager.IndexMetaModelPartitionManagerImpl;
import com.sap.tc.moin.facility.primary.metamodelmanager.IndexMofRomInjectionServiceImpl;
import com.sap.tc.moin.facility.primary.persistence.fs.FacilityEventNotifierImpl;
import com.sap.tc.moin.facility.primary.persistence.fs.ResourceManagementImpl;
import com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl.FsFactory;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexFsDumpedImpl;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.facility.primary.riservice.CheckedResourceIdentifierFactoryImpl;
import com.sap.tc.moin.facility.primary.riservice.DiResourceIdentifierFactoryImpl;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.jmx.Description;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;
import com.sap.tc.moin.repository.spi.facility.SpiExternalSaveLocking;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityLifecycle;
import com.sap.tc.moin.repository.spi.facility.SpiInternalDistributedDirtyLocking;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.spi.facility.SpiMQLQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsFacility;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsMetaModelManager;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiCustomContentSelectionManagement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.util.SpiDelegator;

public class FileSystemFacility implements Facility, SpiFsFacility, SpiFacilityLifecycle, IpiFsFacilityForTest {

    // trace setup
//    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY, FileSystemFacility.class );

    // facility components are kept in a list
    protected final List<IpiFacilityComponent> facilityComponents;

    // the Moin Core Proxy is provided to all Primary Facilities
    protected final SpiCore core;

    protected final SpiPartitionSerializationManager partitionSerializationManager;

    protected final SpiRuntimeContext runtimeContext;

    static {
        CMFSServices.init( );
    }

    private CMManager cmManager;

    private IndexMetaModelPartitionManagerImpl indexMetaModelPartitionManager;

    private IndexMofRomInjectionServiceImpl mofRomInjectionService;

    private FsLifecycleServiceImpl lifecycleService;

    protected FsPersistenceExtImpl fsPersistence;

    protected ResourceManagementImpl resourceManagement;

    private IndexImpl index;

    private CheckedResourceIdentifierFactoryImpl checkedResourceIdentifierFactory;

    private AbstractDataAreaManagerImpl dataAreaManager;

    private FacilityEventNotifierImpl facilityEventNotifier;

    protected IpiLogicalFsFactory fsFactoryDirectory;

    protected IpiLogicalFsFactory fsFactoryArchive;

    protected SpiExternalSaveLocking saveLocking;

    private DiResourceIdentifierFactoryImpl diResourceIdentifierFactory; // OK: is technically NWDI free [beside "DCs/" String in CRI]

    private ObjectName jmxObjectName = null;

    private String indexFile;

    public FileSystemFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext, String indexFile ) {

        this.facilityComponents = new ArrayList<IpiFacilityComponent>( 20 );
        this.core = core;
        this.partitionSerializationManager = serializationManager;
        this.runtimeContext = runtimeContext;
        this.indexFile = indexFile;

        configureFacility( );
    }

    protected final <T> T push( T o ) {

        if ( o instanceof IpiFacilityComponent ) {
            if ( this.facilityComponents.indexOf( o ) == -1 ) {
                this.facilityComponents.add( (IpiFacilityComponent) o );
            }
        }
        return o;
    }

    protected void configureFacility( ) {

        // phase 1: construct sub-components
        ///////////////////////////////

        this.cmManager = push( new CMManager( ) );

        // File system factory
        if ( this.fsFactoryDirectory == null || this.fsFactoryArchive == null ) {
            FsFactory fsfct = new FsFactory( );
            if ( this.fsFactoryDirectory == null ) {
                this.fsFactoryDirectory = fsfct;
            }
            if ( this.fsFactoryArchive == null ) {
                this.fsFactoryArchive = fsfct;
            }
        }
        push( this.fsFactoryDirectory );
        push( this.fsFactoryArchive );

        // Data Area Manager
        this.dataAreaManager = push( new SimpleDataAreaManagerImpl( ) );

        // Di Service
        this.lifecycleService = push( new FsLifecycleServiceImpl( ) );
        this.diResourceIdentifierFactory = push( new DiResourceIdentifierFactoryImpl( this.core.getReferenceQueue( ) ) );
        this.checkedResourceIdentifierFactory = push( new CheckedResourceIdentifierFactoryImpl( ) );

        final String name = this.core.getMoinId( ) + "-" + getId( ); //$NON-NLS-1$
        // Index with or without dump capabilities
        if ( indexFile == null || indexFile.length( ) == 0 ) {
            this.index = new IndexImpl( this.getId( ), name, this.core.getReferenceQueue( ) );
        } else {
            this.index = new IndexFsDumpedImpl( this.getId( ), name, this.core.getReferenceQueue( ), indexFile );
        }
        push( this.index );

        // resource management
        this.resourceManagement = push( new ResourceManagementImpl( ) );

        // persistence
        if ( this.fsPersistence == null ) {
            this.fsPersistence = new FsPersistenceExtImpl( name, this.core.getReferenceQueue( ) );
        }
        push( this.fsPersistence );

        // facility event manager
        this.facilityEventNotifier = push( new FacilityEventNotifierImpl( ) );

        // meta-model manager
        this.indexMetaModelPartitionManager = push( new IndexMetaModelPartitionManagerImpl( ) );

        // mof rom injection service
        this.mofRomInjectionService = push( new IndexMofRomInjectionServiceImpl( ) );

        // phase 2: bind sub-components
        ///////////////////////////////

        // Data Area Manager
        this.dataAreaManager.bind( this.core.getStageFactory( ) );
        this.dataAreaManager.bind( this.diResourceIdentifierFactory );
        this.dataAreaManager.bind( this );

        // Project Handler

        // Di Service
        this.lifecycleService.bind( this.resourceManagement );
        this.lifecycleService.bind( this.cmManager );
        this.lifecycleService.bind( this.partitionSerializationManager );

        // Ri factory
        this.checkedResourceIdentifierFactory.bind( this.diResourceIdentifierFactory );
        this.checkedResourceIdentifierFactory.bind( this.resourceManagement );
        this.checkedResourceIdentifierFactory.bind( this.partitionSerializationManager );

        // Index
        this.index.bind( this.partitionSerializationManager );
        this.index.bind( this.core.getMetamodelService( ) );

        if ( index instanceof IndexFsDumpedImpl ) {
            ( (IndexFsDumpedImpl) this.index ).bind( this.diResourceIdentifierFactory );
        }

        // Resource Management
        this.resourceManagement.bind( this.dataAreaManager );
        this.resourceManagement.bind( this.facilityEventNotifier );
        this.resourceManagement.bind( this.fsFactoryDirectory, this.fsFactoryArchive );
        this.resourceManagement.bind( this.diResourceIdentifierFactory );
        this.resourceManagement.bind( this.index );
        this.resourceManagement.bind( this.partitionSerializationManager );

        // Persistence
        this.fsPersistence.bind( (IpiFsResourceManagement) this.resourceManagement );
        this.fsPersistence.bind( this.index );
        this.fsPersistence.bind( this.indexMetaModelPartitionManager );
        this.fsPersistence.bind( this.partitionSerializationManager );
        this.fsPersistence.bind( this.diResourceIdentifierFactory );
        this.fsPersistence.bind( this.cmManager );

//        this.versioningService.bind( this.indexDumped );

        // MetaModel Partition Manager
        this.indexMetaModelPartitionManager.bind( this.index );
        this.indexMetaModelPartitionManager.bind( this.dataAreaManager );

        // MOFROM Injection Service
        this.mofRomInjectionService.bind( this.index );

        // Facility event notifier
        this.facilityEventNotifier.bind( this.core.getPartitionService( ) );
    }

    public SpiExternalSaveLocking getExternalSaveLocking( ) {

        return saveLocking;
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

        return this.fsPersistence;
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

        return this.lifecycleService;
    }

    /*
     * Getters for internal components
     */
    public IpiFsResourceManagement getResourceManagement( ) {

        return this.resourceManagement;
    }

//    public IpiFacilityEventNotifier getFacilityEventManager( ) {
//
//        return this.facilityEventNotifier;
//    }

    /*
     * Facade functions to satisfy API
     */

    public String getId( ) {

        return System.getProperty( getClass( ).getName( ) + ".Id", PrimaryFacility.FACILITY_ID ); //$NON-NLS-1$
    }

    private boolean isPrimaryFacility( ) {

        return PrimaryFacility.FACILITY_ID.equals( getId( ) );
    }

    public DataArea getMetamodelDataArea( ) {

        if ( isPrimaryFacility( ) ) {
            return this.dataAreaManager.getMetaModelDataArea( );
        } else {
            return null;
        }
    }

    public SpiClientSpec getMetamodelClientSpec( ) throws SpiFacilityException {

        if ( isPrimaryFacility( ) ) {
            return ( (SpiDataArea) this.dataAreaManager.getMetaModelDataArea( ) ).getSingleClientSpec( );
        } else {
            return null;
        }
    }

    public DataArea getTransientDataArea( ) {

        if ( isPrimaryFacility( ) ) {
            return this.dataAreaManager.getTransientDataArea( );
        } else {
            return null;
        }
    }

    public ClientSpec getTransientClientSpec( ) throws SpiFacilityException {

        if ( isPrimaryFacility( ) ) {
            return ( (SpiDataArea) this.dataAreaManager.getTransientDataArea( ) ).getSingleClientSpec( );
        } else {
            return null;
        }
    }

    public Collection<String> getDataAreaNames( ) {

        return this.dataAreaManager.getDataAreaNames( );
    }

    public DataArea getDataAreaByName( String name ) {

        return this.dataAreaManager.getDataAreaByName( name );
    }


    // JD's extension

    public void dumpIndex( ) {

        if ( index instanceof IndexFsDumpedImpl ) {
            ( (IndexFsDumpedImpl) this.index ).dumpIndex( );
        }
    }

    public IpiQuery getQuery( ) {

        return index;
    }

    public CMManager getCMManager( ) {

        return this.cmManager;
    }

    public SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        return partitionSerializationManager;
    }

//    public SpiRuntimeContext getRuntimeContext( ) {
//
//        return runtimeContext;
//    }

    public void initialize( ) {

        for ( IpiFacilityComponent facilityComponent : facilityComponents ) {
            facilityComponent.initialize( );
        }

        addJMX( );
        cmManager.addJMX( core.getMoinId( ), getId( ), core.getReferenceQueue( ) );
    }

    /**
     * finalize startup delegates to sub-components. Is invoked after meta-model
     * deployment
     */
    public void finalizeStartup( ) {

        for ( IpiFacilityComponent facilityComponent : facilityComponents ) {
            facilityComponent.finalizeStartup( );
        }
    }

    /**
     * Shutdown delegates to sub-components
     */
    public void tearDown( ) {

        for ( IpiFacilityComponent facilityComponent : facilityComponents ) {
            facilityComponent.tearDown( );
        }

        if ( JMX_ENABLED ) {
            SpiJmxHelper.unregisterMBean( this.jmxObjectName );
        }
        cmManager.removeJMX( );
    }

    @SuppressWarnings( "unchecked" )
    private void addJMX( ) {

        if ( JMX_ENABLED ) {
            try {
                this.jmxObjectName = new ObjectName( MOIN_DOMAIN + "type=Facility,moin=" + this.core.getMoinId( ) + ",id=" + this.getId( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            } catch ( MalformedObjectNameException e ) {
                throw new RuntimeException( e );
            } catch ( NullPointerException e ) {
                throw new RuntimeException( e );
            }
            new JmxAdapter( this, jmxObjectName, this.core.getReferenceQueue( ) );
        }
    }

    public static interface FileSystemFacilityMBean {

        @Description( "The data areas of this facility." )
        public String[] getDataAreas( );

        @Description( "The id of this facility." )
        public String getId( );
    }

    private static final class JmxAdapter implements FileSystemFacilityMBean {

        private final WeakReferenceWithObjectName<FileSystemFacility> facilityRef;

        private JmxAdapter( FileSystemFacility facility, ObjectName jmxObjectName, ReferenceQueue<FileSystemFacility> refQueue ) {

            this.facilityRef = new WeakReferenceWithObjectName<FileSystemFacility>( facility, jmxObjectName, refQueue );
            SpiJmxHelper.registerStandardMBean( this, FileSystemFacilityMBean.class, jmxObjectName );
        }

        public String[] getDataAreas( ) {

            return this.facilityRef.get( ).getDataAreaNames( ).toArray( new String[this.facilityRef.get( ).getDataAreaNames( ).size( )] );
        }

        public String getId( ) {

            return this.facilityRef.get( ).getId( );
        }
    }

    @Override
    public boolean equals( Object obj ) {

        return super.equals( SpiDelegator.dismantle( obj ) );
    }

    @Override
    public int hashCode( ) {

        return super.hashCode( );
    }

    public DataArea grantDataArea( String name ) {

        DataArea dataArea = dataAreaManager.getDataAreaByName( name );
        if ( dataArea == null ) {
            dataArea = dataAreaManager.createRegularDataArea( name );
        }
        return dataArea;
    }

    public void removeDataAreaByName( String name ) {

        IpiDataArea dataArea = this.dataAreaManager.getDataAreaByName( name );
        if ( dataArea != null ) {
            getResourceManagement( ).removeDataArea( dataArea.getDescriptor( ) );
            this.dataAreaManager.deleteDataArea( name );
        }
    }

	public SpiCustomContentSelectionManagement getCustomContentSelectionManagement( ) {

        return new SpiCustomContentSelectionManagement( ) {

            public CheckResult checkContentSelectionProperties( ) {

                return new CheckResult( ) {

                    public Collection<MoinIllegalArgumentException> getWarnings( ) {

                        return Collections.emptySet( );
                    }

                    public int getSeverity( ) {

                        return MoinSeverity.INFO.severity( );
                    }

                    public Collection<MoinIllegalArgumentException> getErrors( ) {

                        return Collections.emptySet( );
                    }
                };
            }
        };
    }

}
