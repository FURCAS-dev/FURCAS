package com.sap.tc.moin.test.fw.ide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.junit.Assert;

import com.sap.ide.dii05.lib.api.commands.DiiCommandFactory;
import com.sap.ide.dii05.lib.api.modeledit.DiiConcurrentModelModificationException;
import com.sap.ide.dii05.lib.api.modeledit.DiiLibraryOperationCancelledException;
import com.sap.ide.dii05.lib.api.modeledit.DiiModelEditService;
import com.sap.ide.dii05.lib.api.modeledit.IMeAttribute;
import com.sap.ide.dii05.lib.api.modeledit.IMeCommonEntity;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcDependency;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcMetadataState;
import com.sap.ide.dii05.lib.api.modeledit.IMeEntity;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPart;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPartRef;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditFactory;
import com.sap.ide.dii05.lib.api.util.DiiLibraryException;
import com.sap.ide.dii05.lib.api.util.DiiModelService;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.lib.internal.commands.RefreshChildrenJob;
import com.sap.ide.dii05.lib.internal.commands.RefreshMetadataJdiJob;
import com.sap.ide.dii05.lib.internal.commands.devconf.CreateScJdiJob;
import com.sap.ide.dii05.lib.internal.commands.devconf.CreateScJdiJob.ScCreationInfo;
import com.sap.ide.dii05.model.api.IChildrenRefreshable;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.IDcMetadataState;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.IPublicPart;
import com.sap.ide.dii05.model.api.ISoftwareComponent;
import com.sap.ide.dii05.model.api.LocationState;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.model.api.RefreshState;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.ide.dii05.test.util.DiiUtil;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiPublicPartProvider;
import com.sap.tc.moin.friends.ide.IdePrimaryFacilityUtil;
import com.sap.tc.moin.friends.ide.factory.IdeUtilitiesFactory;
import com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelDcType;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;

@SuppressWarnings( "nls" )
public class DcModificationUtilImpl extends UtilImpl implements DcModificationUtil {

    /** ***************** Internals ***************************************** */

    private IdeRuntimeTestHelper _ideTestHelper;

    static final boolean NOT_LOCAL = false;

    static final Runnable NO_RUNNABLE = null;

    static final Connection NO_CONNECTION = null;

    static final boolean DONT_DELETE_PARTITIONS = false;

    static final boolean DELETE_PARTITIONS = true;

    static final boolean PERFORM_DC_BUILD = true;

    static final boolean DONT_PERFORM_DC_BUILD = false;

    // Component model:

    static final MoinDcOptions NO_DC_OPTIONS = null;

    static final boolean DONT_ADD_T0_SOURCE_CONTROL = false;

    static final boolean ADD_T0_SOURCE_CONTROL = true;

    static final String JAVA_DC_TYPE_NAME = "Java";

    static final String JAVA_DC_TYPE_VENDOR = IpiDiDcDefinitionProvider.MOIN_VENDOR;

    static final String DICTIONARY_DC_TYPE_NAME = "Dictionary";

    static final String DICTIONARY_DC_TYPE_VENDOR = IpiDiDcDefinitionProvider.MOIN_VENDOR;

    static final String MOIN_DUMMY_DC_TYPE_NAME = "com.sap.tc.moin.test.di.dctype.dummy.DummyTest";

    static final String MOIN_DUMMY_MOIN_DC_TYPE_NAME = "com.sap.tc.moin.test.di.dctype.MoinTest";

    static final String MOIN_DUMMY_DC_TYPE_VENDOR = "test.sap.com";

    private static final String DC_VENDOR_SAP = "sap.com";

    private static final String PP_NAME_FOR_MM_DC = "def";

    private static final String PP_NAME_FOR_MOIN_DCS_USED_BY_MM_BUILD_PLUGIN = "api";

    private static final String DC_NAME_FOR_MOIN_API_DC = "tc/moin/api";

    private static final String DC_NAME_FOR_MOIN_JMICORE_DC = "tc/moin/jmicore/api";

    static final String NO_DC_SUBTYPE = null;

    static final boolean IS_SOURCE_COMPARTMENT = true;

    static final boolean NO_SOURCE_COMPARTMENT = false;

    static final String NO_AP_TYPE = null; // Application Type ?

    static final String NO_URI = null;

    private static final int MAX_WAITING_FOR_DC_CREATION = 30000; // 30 sec

    /** ************************ Construction ******************************* */
    public DcModificationUtilImpl( IdeRuntimeTestHelper ideRuntimeTestHelper ) {

        _ideTestHelper = ideRuntimeTestHelper;
    }

    /** ************************ Creation of DCs and Projects *************** */

    public IProject getOrCreateLocalMoinDCProject( IComponentType dii05ComponentType, String dcVendor, String dcName, boolean doInitialize ) throws Exception {

        return getOrCreateMoinDcProject( _ideTestHelper.getDevConfUtil( ).getLocalConfiguration( ), NAME_OF_LOCAL_SC, VENDOR_OF_LOCAL_SC, dii05ComponentType, dcVendor, dcName, doInitialize );
    }

    public IProject getOrCreateMoinDcProject( IDevelopmentConfiguration devConfig, String scName, String scVendor, IComponentType dii05ComponentType, String dcVendor, String dcName, boolean doInitialize ) throws Exception {

        return getOrCreateMoinDcProject( devConfig, scName, scVendor, dii05ComponentType, dcVendor, dcName, IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER, doInitialize, IdeRuntimeTestHelper.DONT_CHECKIN );
    }

    public IProject getOrCreateMoinDcProject( IDevelopmentConfiguration devConfig, String scName, String scVendor, IComponentType dii05ComponentType, String dcVendor, String dcName, IChangelistProvider changelistProvider, boolean doInitialize, boolean doCheckIn ) throws Exception {

        try {
            // Create the DC and the respective project:
            ISoftwareComponent scForMyComponents = getSc( devConfig, scName, scVendor );
            boolean addToSourceControl = ( changelistProvider == null ) ? DONT_ADD_T0_SOURCE_CONTROL : ADD_T0_SOURCE_CONTROL;
            IDevelopmentComponent dc = createDc( scForMyComponents, dii05ComponentType, dcVendor, dcName, changelistProvider );
            IProject eclipseProject = getOrCreateProjectForExistingDc( dc );

            // For MM DCs: enable DC for DC build
            if ( MoinMetaModelDcType.getDcType( ).equals( dii05ComponentType ) ) {
                setMMDcPropertiesNeededForDcBuild( dc );
            }

            // Checkin changelist:
            if ( doCheckIn ) {
                String changelistId = changelistProvider.getChangelistId( eclipseProject );
                _ideTestHelper.getDiTrackUtil( ).checkInChangeList( devConfig, changelistProvider, changelistId );
            }

            // Initialize MOIN for the DevConfig of the created project and/or for the created project:
            if ( doInitialize ) {
                IdePrimaryFacility ideFacility = (IdePrimaryFacility) _ideTestHelper.getFacility( PrimaryFacility.FACILITY_ID );
                IdePrimaryFacilityUtil primaryFacilityUtil = IdeUtilitiesFactory.getFacilityUtil( );
                IdePrimaryFacilityUtil.ContainerInitializationState initState = primaryFacilityUtil.getContainerInitializationState( ideFacility, eclipseProject );
                if ( initState == IdePrimaryFacilityUtil.ContainerInitializationState.NOT_MOIN_RELEVANT ) {
                    throw new IllegalStateException( "Newly created MOIN DC project is not recognized as MOIN-relevant project." );
                } else if ( initState == IdePrimaryFacilityUtil.ContainerInitializationState.NOT_INITIALIZED ) {
                    primaryFacilityUtil.initializeClientSpec( ideFacility, eclipseProject );
                } else if ( initState == IdePrimaryFacilityUtil.ContainerInitializationState.CLIENT_SPEC_ONLY_INITIALIZED ) {
                    IdeCompoundDataAreaManager dispatcher = (IdeCompoundDataAreaManager) _ideTestHelper.getCoreMoin( ).getCompoundDataAreaManager( );
                    dispatcher.refreshFromFileSystem( eclipseProject, IdeRuntimeTestHelper.DONT_FORCED_REFRESH );
                }
            }
            return eclipseProject;

        } catch ( CoreException e ) {
            e.printStackTrace( );
            String message = "Could not create dc-project [" + _ideTestHelper.getFullDCName( dcVendor, dcName ) + "] in SC [" + scName + "] in DevConfig[" + devConfig.getName( ) + "]";
            throw new Exception( message, e );
        }
    }

    public IProject getOrCreateProjectForExistingDc( IDevelopmentComponent dc ) throws Exception {

        return getOrCreateProjectForExistingDc( dc, DONT_PERFORM_DC_BUILD );
    }


    public IProject getOrCreateProjectForExistingDc( IDevelopmentComponent dc, boolean build ) throws Exception {

        // Check precondition: valid dc object, contained in Dii05 transient component model
        if ( !dc.isContainedInComponentModel( ) ) {
            String message = "Could not create project for existing DC: " + _ideTestHelper.getFullDCName( dc.getVendor( ), dc.getName( ) );
            Assert.fail( message );
            throw new Exception( message );
        }

        IProject eclipseProject = DiiResourceService.getProject( dc );
        if ( eclipseProject != null ) {
            return eclipseProject;
        }

        // The project is created and the Dii05 transient component model is in sync afterwards.
        // The parameter 'build' controls whether the used DCs are synced and the DC is build (DC build, not incremental Eclipse build).
        Collection<IDevelopmentComponent> dcs = new ArrayList<IDevelopmentComponent>( );
        dcs.add( dc );
        IStatus status = DiiUtil.createProjectForDcs( dcs, build );
        if ( status.getSeverity( ) == IStatus.CANCEL || status.getSeverity( ) == IStatus.ERROR ) {
            String message = "Could not create project for existing DC: " + _ideTestHelper.getFullDCName( dc.getVendor( ), dc.getName( ) );
            throw new Exception( message );
        }

        eclipseProject = DiiResourceService.getProject( dc );
        return eclipseProject;
    }

    /** *********** DC modification ***************************************** */

    @SuppressWarnings( "unchecked" )
    public void addDcDependencies( IDevelopmentComponent srcDc, List<IDevelopmentComponent> destDcs, String ppName ) throws DiiLibraryException {

        // Get the editable dependencies of srcDc:
        IDcMetadataState metaDataOfsrcDc = srcDc.getLocalState( );
        IMeDcMetadataState editableMetaDataOfSrcDc = DiiModelEditService.getEditableState( metaDataOfsrcDc, IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );
        EList<IMeDcDependency> editableDependenciesOfSrcDc = editableMetaDataOfSrcDc.getDependencies( );

        for ( IDevelopmentComponent destDc : destDcs ) {
            // Add dependency: srcDc --> destDc
            IMeDcDependency dependency = ModelEditFactory.eINSTANCE.createIMeDcDependency( );
            IMePublicPartRef ppRef = ModelEditFactory.eINSTANCE.createIMePublicPartRef( );
            ppRef.setName( destDc.getName( ) );
            ppRef.setVendor( destDc.getVendor( ) );
            ppRef.setPpName( ppName );
            dependency.setDcOrPpRef( ppRef );
            dependency.setAtBuildTime( true );
            editableDependenciesOfSrcDc.add( dependency );
        }

        // Commit the changes 
        // --> changes are written into the transient component model of Dii05 and to local disc
        // --> changes MUST be visible immediately 
        DiiModelEditService.commitChangesAndRefresh( editableMetaDataOfSrcDc );
    }

    public void removePublicPartFromDc( IDevelopmentComponent dc, String ppName ) throws CoreException {

        IDcMetadataState dcMetaDataState = dc.getLocalState( );
        IPublicPart publicPart = DiiModelEditService.getPublicPart( dcMetaDataState, ppName );
        if ( publicPart != null ) {
//            DiiModelEditService.assureWritability( publicPart, NO_CHANGELIST_PROVIDER );
            DiiModelEditService.deletePublicPart( dcMetaDataState, ppName, IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );
        }
    }

    public void addMoinRelevantPublicPartToMmDc( IDevelopmentComponent dc, String ppName ) throws CoreException {

        // Create an entity for the PP:
        IMeEntity entity = MoinProject.createEntityForPath( MoinMetaModelDcType.META_MODEL_RESOURCE_FOLDER.getPath( ), IpiDiPublicPartProvider.META_MODEL_FOLDER_TREE_ENTITY_TYPE );
        ArrayList<IMeEntity> ppEntities = new ArrayList<IMeEntity>( );
        ppEntities.add( entity );

        // Get or create the PP and add the entity:
        addPublicPartToDc( dc, ppName, Purpose.COMPILATION_LITERAL, ppEntities );
    }

    @SuppressWarnings( "unchecked" )
    public void addPublicPartToDc( IDevelopmentComponent dc, String ppName, Purpose purpose, ArrayList<IMeEntity> ppEntities ) throws CoreException {

        // Create or get the PP:
        IDcMetadataState dcMetaDataState = dc.getLocalState( );
        IPublicPart publicPart = DiiModelEditService.getPublicPart( dcMetaDataState, ppName );
        if ( publicPart != null ) {
            DiiModelEditService.assureWritability( publicPart, IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );
            if ( publicPart.getPurpose( ) != purpose ) {
                // DiiModelEditService.newEditablePublicPart throws an exception if the purpose of the found pp doesn't match the given one. 
                // --> In this case we first delete this public part before creating it.
                DiiModelEditService.deletePublicPart( dcMetaDataState, ppName, IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );
            }
        }
        IMePublicPart editablePublicPart = DiiModelEditService.newEditablePublicPart( dcMetaDataState, ppName, purpose, IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER, NOT_LOCAL );

        // Add the entities to the PP:
        for ( IMeEntity entity : ppEntities ) {
            editablePublicPart.getEntities( ).add( entity );
        }
        IStatus result = DiiModelEditService.commitChangesAndRefresh( editablePublicPart );
        if ( !result.isOK( ) ) {
            throw new CoreException( result );
        }
    }

    public void removeMoinRelevantEntitiesFromPublicPartOfModelDc( IDevelopmentComponent dc ) throws CoreException {

        List<String> entityTypes = new ArrayList<String>( );
        entityTypes.add( IpiDiPublicPartProvider.MOIN_FOLDER_TREE_ENTITY_TYPE );

        removeEntitiesFromPublicPart( dc, NAME_OF_PP_PURPOSE_COMPILATION_FOR_MODEL_DC, entityTypes );
    }

    /**
     * Removes all entities with one of the given <code>entityTypes</code> from
     * the given public part <code>ppName</code> of the DC.
     */
    @SuppressWarnings( "unchecked" )
    public void removeEntitiesFromPublicPart( IDevelopmentComponent dc, String ppName, List<String> entityTypes ) throws CoreException {

        // Get the PP:
        IDcMetadataState dcMetaDataState = dc.getLocalState( );
        IPublicPart publicPart = DiiModelEditService.getPublicPart( dcMetaDataState, ppName );
        if ( publicPart == null ) {
            return;
        }
        // and make it editable:
        DiiModelEditService.assureWritability( publicPart, IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );
        IMePublicPart editablePublicPart = DiiModelEditService.getEditablePublicPart( publicPart, IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );
        // Get the editable public part entities:
        EList<IMeCommonEntity> editablePublicPartEntities = editablePublicPart.getEntities( );
        Iterator<IMeCommonEntity> entityIterator = editablePublicPartEntities.iterator( );
        // and remove the entities with one of the given entity types:
        while ( entityIterator.hasNext( ) ) {
            IMeCommonEntity entity = entityIterator.next( );
            if ( entityTypes.contains( entity.getEntityType( ) ) ) {
                entityIterator.remove( );
            }
        }
        // Commit the changes and refresh transient component model of Dii05:
        IStatus result = DiiModelEditService.commitChangesAndRefresh( editablePublicPart );
        if ( !result.isOK( ) ) {
            throw new CoreException( result );
        }
    }

    public void setDcLocale( IDevelopmentComponent dc, String dcLocale ) throws Exception {

        IMeDcMetadataState metadataState = DiiModelEditService.getEditableState( dc.getLocalState( ), IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );
        metadataState.setLocale( dcLocale );
        DiiModelEditService.commitChanges( metadataState );
    }

    @SuppressWarnings( "unchecked" )
    public void setDcAttribute( IDevelopmentComponent dc, String dcAttributeName, String dcVendor, String value ) throws Exception {

        // modify the DC ach (application component hierarchy), thanks to Dimitrij
        IMeDcMetadataState metadataState = DiiModelEditService.getEditableState( dc.getLocalState( ), IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );
        EList<IMeAttribute> attributes = metadataState.getAttributes( );
        boolean found = false;
        for ( IMeAttribute attribute : attributes ) {
            if ( dcAttributeName.equals( attribute.getName( ) ) && dcVendor.equals( attribute.getVendor( ) ) ) {
                attribute.setValue( value );
                found = true;
            }
        }
        if ( !found ) {
            IMeAttribute attr = ModelEditFactory.eINSTANCE.createIMeAttribute( );
            attr.setName( dcAttributeName );
            attr.setVendor( dcVendor );
            attr.setValue( value );
            attributes.add( attr );
        }
        // commit the DC changes
        DiiModelEditService.commitChanges( metadataState );
    }

    /** *********** Refresh after DC modifications ************************** */

    /**
     * The method scans the local disc for the DCs of the local SC which is
     * mentioned for user defined DCs. It refreshes the DCs of the SC, but does
     * not fully initialize the Dii05 DC-objects (
     * dc.getLocalState().getAttributes().size == 0) ), i.e. those DCs are not
     * recognized as MOIN-relevant (this effect is just needed in test case
     * TestRefreshClientSpec).
     */

    public void refreshDii05DcHandlingForNewOrDeletedDCs( ) throws Exception {

        // The MOIN tests work based on the local development configuration import
        // and create MOIN DCs in the local software component.
        IStatus status = null;
        try {
            IChildrenRefreshable localSoftwareComponent = getLocalSc( );
            Runnable postProcessingInUiThread = NO_RUNNABLE;
            RefreshChildrenJob refreshChildrenJob = new RefreshChildrenJob( localSoftwareComponent, postProcessingInUiThread, IdeRuntimeTestHelper.FORCED_REFRESH );
            status = JobUtil.syncExec( refreshChildrenJob, IdeRuntimeTestHelper.NO_PROGRESS_MONITOR );
        } catch ( Exception e ) {
            e.printStackTrace( );
            throw new Exception( e.getMessage( ), e );
        }
        if ( status == null || !status.isOK( ) ) {
            String message = "Could not refresh dc-projects in DII05: " + ( status == null ? "null-dii05-return-status" : status.getMessage( ) );
            throw new Exception( message );
        }
    }

    public void refreshDii05DcHandlingForChangedDc( String dcVendor, String dcName ) throws Exception {

        // The MOIN tests work based on the local development configuration import
        // and create MOIN DCs in the local software component.

        IProject project = getLocalMoinDCProject( dcVendor, dcName );
        IDevelopmentComponent dc = DiiModelService.getDcByNameAndVendor( _ideTestHelper.getDevConfUtil( ).getLocalConfiguration( ), dcName, dcVendor );
        ;
        IStatus status = null;
        try {
            Runnable postProcessingInUiThread = NO_RUNNABLE;
            LocationState displayState = LocationState.INACTIVE_LITERAL;
            RefreshMetadataJdiJob refreshMetadataJdiJob = new RefreshMetadataJdiJob( postProcessingInUiThread, dc, displayState, IdeRuntimeTestHelper.FORCED_REFRESH );
            status = JobUtil.syncExec( refreshMetadataJdiJob, IdeRuntimeTestHelper.NO_PROGRESS_MONITOR );
        } catch ( Exception e ) {
            e.printStackTrace( );
            throw new Exception( e.getMessage( ), e );
        }
        if ( status == null || !status.isOK( ) ) {
            String message = "Could not refresh dc-projects in DII05: " + ( status == null ? "null-dii05-return-status" : status.getMessage( ) );
            throw new Exception( message );
        }
    }

    /** ***************** Deletion of DCs and projects ********************** */

    /**
     * Deletes the given Dc Project, including the dc-definition and files, but
     * does not delete the respective partitions in MOIN index.
     */
    public void deleteLocalMoinDCProject( String dcVendor, String dcName ) throws Exception {

        deleteLocalMoinDCProject( dcVendor, dcName, NO_CONNECTION, DONT_DELETE_PARTITIONS );
    }

    /**
     * Deletes the given Dc project, including the dc-definition and files and
     * the respective partitions in MOIN index.
     */
    public void deleteLocalMoinDCProjectAndPartitions( String dcVendor, String dcName, Connection connection ) throws Exception {

        deleteLocalMoinDCProject( dcVendor, dcName, NO_CONNECTION, DELETE_PARTITIONS );
    }

    // Scenario 2:
    // DCs currently can only be deleted in Scenario 2, because Dii05 and Nwdi do not yet support a 'test deletion' in the current track ...
    // Remark: Scenario 3: only remove DC is possible (delete DC is not supported)
    public boolean deleteDcs( IDevelopmentComponent[] developmentComponents ) throws Exception {

        JdiJob deleteJob = DiiCommandFactory.forDevelopmentComponent( ).create_DeleteDcsJob( developmentComponents );
        IStatus status = JobUtil.syncExec( deleteJob, null );

        boolean isOk = status.isOK( );
        if ( !isOk && status.getException( ) != null ) {
            throw new Exception( status.getException( ) );
        }
        return isOk;
    }

    /** ***************** Retrieval of SCs ********************************** */

    /**
     * Returns first found editable Software Component (this realized the same
     * way in MIE Dc-Framework).
     */
    public ISoftwareComponent getLocalSc( ) throws CoreException {

        return getSc( _ideTestHelper.getDevConfUtil( ).getLocalConfiguration( ), NAME_OF_LOCAL_SC, VENDOR_OF_LOCAL_SC );
    }

    public ISoftwareComponent getOrCreateSc( IDevelopmentConfiguration devConfig, String scName, String scVendor ) throws Exception {

        // Caution: scName MUST be in upper case !!!
        ISoftwareComponent sc = getSc( devConfig, scName, scVendor );
        if ( sc != null ) {
            return sc;
        }
        return createSc( devConfig, scName, scVendor );
    }

    /** ***************** Internals ***************************************** */

    @SuppressWarnings( "unchecked" )
    private ISoftwareComponent getSc( IDevelopmentConfiguration devConfig, String scName, String scVendor ) throws CoreException {

        List scList = devConfig.getSoftwareComponents( );
        ISoftwareComponent[] scs;
        if ( scList.isEmpty( ) ) {
            scs = DiiModelService.getSoftwareComponents( devConfig, DiiModelService.FORCED_REFRESH );
        } else {
            scs = (ISoftwareComponent[]) scList.toArray( new ISoftwareComponent[scList.size( )] );
        }
        for ( ISoftwareComponent component : scs ) {
            if ( scName.equals( component.getName( ) ) && scVendor.equals( component.getVendor( ) ) ) {
                return component;
            }
        }
        return null;
    }

    private ISoftwareComponent createSc( IDevelopmentConfiguration devConfig, String scName, String scVendor ) throws Exception {

        String scCaption = scName;
        String scDescription = scName;

        String relativeDcRoot = scName;
        String storeUri = NO_URI;

        ScCreationInfo scCreationInfo = new CreateScJdiJob.ScCreationInfo( scName, scCaption, scDescription, scVendor, relativeDcRoot, IS_SOURCE_COMPARTMENT, NO_AP_TYPE, storeUri );

        ISoftwareComponent[] optionalDependencies = DiiModelService.getSoftwareComponents( devConfig );
        CreateScJdiJob createScJob = new CreateScJdiJob( devConfig, scCreationInfo, optionalDependencies );
        createScJob.setCreateSynchronously( true );

        IStatus status = JobUtil.syncExec( createScJob, new NullProgressMonitor( ) );

        if ( !status.isOK( ) ) {
            if ( status.getException( ) != null ) {
                throw new Exception( status.getException( ) );
            }
            throw new Exception( "ScCreation failed with status: " + status.getMessage( ) );
        }
        ISoftwareComponent newSc = createScJob.getNewSc( );
        return newSc;
    }

    /**
     * Returns the project for the given DC name
     * 
     * @param dcName the name of the DC. Note that this differs from the
     * corresponding project name.
     * @return the Eclipse project or <code>null</code>
     */
    private IProject getLocalMoinDCProject( String dcVendor, String dcName ) {

        IDevelopmentComponent dc;
        try {
            dc = MoinProject.getLocalDC( dcName, dcVendor );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
        if ( dc != null ) {
            IProject project = DiiResourceService.getProject( dc );
            return project;
        }
        return null;
    }

    @SuppressWarnings( "unchecked" )
    private IDevelopmentComponent getDC( ISoftwareComponent sc, String dcName, String vendor ) {

        IDevelopmentComponent[] dcs;
        if ( !RefreshState.REFRESHED_LITERAL.equals( sc.getRefreshState( ) ) ) {
            dcs = DiiModelService.getDevelopmentComponents( sc, DiiModelService.FORCED_REFRESH );
        } else {
            dcs = (IDevelopmentComponent[]) sc.getDevelopmentComponents( ).toArray( new IDevelopmentComponent[0] );
        }
        for ( IDevelopmentComponent dc : dcs ) {
            if ( dcName.equals( dc.getName( ) ) && vendor.equals( dc.getVendor( ) ) ) {
                return dc;
            }
        }
        return null;
    }

    private IDevelopmentComponent createDc( ISoftwareComponent scForMyComponents, IComponentType dii05ComponentType, String dcVendor, String dcName, IChangelistProvider changelistProvider ) throws Exception {

        // Use Case: 
        // The creation of a DC requires the instantly creation of the respective DC folder hierarchy (without a specific activity-check-in).
        // --> This has the quality of an activity-check-in, therefore the same rules are applied as for activity-check-in (see DiTrackUtilImpl#checkInChangelist):
        // The DC creation requires an exclusive lock on DTR server (shared workspace-lock)
        // We wait max MAX_WAITING_FOR_DC_CREATION sec for an successful check-in. The check-in can fail e.g. in case of parallel check-in by other client or in case of parallel integrate of an activity or propagation list.

        // Create the DC:
        boolean addToSourceControl = ( changelistProvider == null ) ? DONT_ADD_T0_SOURCE_CONTROL : ADD_T0_SOURCE_CONTROL;

        int max_counter = MAX_WAITING_FOR_DC_CREATION / 100;
        int counter = max_counter;
        IDevelopmentComponent dc = null;
        Exception exception = null;

        try {
            dc = MoinProject.createDc( dcName, dcVendor, dii05ComponentType, scForMyComponents, NO_DC_OPTIONS, addToSourceControl, changelistProvider, IdeRuntimeTestHelper.NO_PROGRESS_MONITOR );
        } catch ( Exception e ) {
            logExceptionMessage( "createDc", e );
        }
        while ( counter > 0 && dc == null ) {
            threadSleep( 100, "createDc" ); //$NON-NLS-1$
            counter--;
            try {
                dc = MoinProject.createDc( dcName, dcVendor, dii05ComponentType, scForMyComponents, NO_DC_OPTIONS, addToSourceControl, changelistProvider, IdeRuntimeTestHelper.NO_PROGRESS_MONITOR );
            } catch ( Exception e ) {
                logExceptionMessage( "createDc", e );
                exception = e;
            }
        }
        String message = "Waited " + ( ( max_counter - counter ) * 100 ) + " millis for DC creation (exlusive lock on DTR)"; //$NON-NLS-1$ //$NON-NLS-2$
        java.lang.System.out.println( message );
        java.lang.System.out.flush( );

        if ( dc == null ) {
            throw exception;
        }
        return dc;
    }

    private void deleteLocalMoinDCProject( String dcVendor, String dcName, Connection connection, boolean deletePartitions ) throws Exception {

        IProject project = getLocalMoinDCProject( dcVendor, dcName );
        if ( project == null ) {
            return;
        }
        Exception ex = null;
        if ( deletePartitions && connection != null ) {
            if ( project != null && project.isAccessible( ) ) {
                try {
                    // prior to deletion, remove all partitions to align DB
                    deletePartitions( project, connection );
                } catch ( Exception e ) {
                    String message = "Could not delete partitions in dc-project: " + project.getName( );
                    Assert.fail( message );
                    ex = e;
                }
            }
        }

        // continue with deletion even if partition deletion failed
        try {
            MoinProject.deleteLocalDc( project, IdeRuntimeTestHelper.NO_PROGRESS_MONITOR );
        } catch ( CoreException e ) {
            String message = "Could not delete dc project: " + project.getName( );
            Assert.fail( message );
            ex = e;
        }
        if ( ex != null ) {
            throw ex;
        }
    }

    private void deletePartitions( IProject project, Connection connection ) throws PartitionsNotSavedException {

        CRI cri = ( (IdeCompoundDataAreaManager) _ideTestHelper.getMoin( ).getCompoundDataAreaManager( ) ).getContainer( project );
        Collection<PRI> pris = connection.getSession( ).getInnerPartitions( cri );
        for ( PRI pri : pris ) {
            cleanUpPartition( pri, connection );
        }
    }

    private void cleanUpPartition( PRI pri, Connection connection ) throws PartitionsNotSavedException {

        ModelPartition partition = connection.getPartition( pri );
        if ( partition != null ) {
            partition.delete( );
            connection.save( );
        }
    }

    private void setMMDcPropertiesNeededForDcBuild( IDevelopmentComponent developmentComponent ) throws DiiLibraryException, DiiLibraryOperationCancelledException, DiiConcurrentModelModificationException {

        // Get the editable state of the DC and adapt it so that the entries needed for MM-build are set:
        IMeDcMetadataState state = DiiModelEditService.getEditableState( developmentComponent.getLocalState( ), IdeRuntimeTestHelper.NO_CHANGELIST_PROVIDER );

        // We assume that the build plugin is already set in dcdef, especially: we do'nt want to have a dependency to the hard-coded build-plugin-name, because it might change ...
//        // Set the build plug-in
//        private static final String MM_BUILD_PLUGIN_NAME = "tc/moin/bi/bp/mmbuildplugin_720"; 
//        IMeBuildPlugin buildPlugin = state.getBuildPlugin( );
//        buildPlugin.setName( MM_BUILD_PLUGIN_NAME );
//        buildPlugin.setVendor( DC_VENDOR_SAP );
//        buildPlugin.setPpName( PP_NAME_FOR_MM_DC );

        // Add dependency to the DC which exposes the MOIN-API:
        IMeDcDependency dependency = ModelEditFactory.eINSTANCE.createIMeDcDependency( );
        IMePublicPartRef ppRef = ModelEditFactory.eINSTANCE.createIMePublicPartRef( );
        ppRef.setName( DC_NAME_FOR_MOIN_API_DC );
        ppRef.setVendor( DC_VENDOR_SAP );
        ppRef.setPpName( PP_NAME_FOR_MOIN_DCS_USED_BY_MM_BUILD_PLUGIN );
        dependency.setDcOrPpRef( ppRef );
        dependency.setAtBuildTime( true );
        state.getDependencies( ).add( dependency );

        // Add dependency to the DC which exposes the MOIN JMI-CORE-functionality:
        dependency = ModelEditFactory.eINSTANCE.createIMeDcDependency( );
        ppRef = ModelEditFactory.eINSTANCE.createIMePublicPartRef( );
        ppRef.setName( DC_NAME_FOR_MOIN_JMICORE_DC );
        ppRef.setVendor( DC_VENDOR_SAP );
        ppRef.setPpName( PP_NAME_FOR_MOIN_DCS_USED_BY_MM_BUILD_PLUGIN );
        dependency.setDcOrPpRef( ppRef );
        dependency.setAtBuildTime( true );
        state.getDependencies( ).add( dependency );

        // Commit the changes to local disc and into the transient component model of Dii05:
        DiiModelEditService.commitChangesAndRefresh( state );
    }

}
