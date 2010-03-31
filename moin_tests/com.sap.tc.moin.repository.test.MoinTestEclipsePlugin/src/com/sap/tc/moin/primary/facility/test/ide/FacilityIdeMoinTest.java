package com.sap.tc.moin.primary.facility.test.ide;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.After;
import org.junit.Before;

import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsFacilityForTest;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.facility.primary.ipi.ide.dii05.IpiIdeDiService;
import com.sap.tc.moin.facility.primary.persistence.fs.StorageArchiveImpl;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.facility.primary.test.FacilityTestCase;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.cdam.ide.internal.IdeFacilityDispatcherInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.spi.facility.ide.SpiIdeFacility;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.test.fw.TestMetaModels;

// todo: This is an exact copy of CoreMoinTest --> unify, so that this
// functionality is available at a location which is
// accessible from core as well as from facility in any scenario.
public class FacilityIdeMoinTest extends FacilityTestCase {

    protected static final boolean DONT_FORCED_REFRESH = false;

    protected final IProgressMonitor NO_PROGRESS_MONITOR = null;

    protected static final int MAX_WAITING_FOR_PARTITION_EVICTION_IN_CORE = 10000; // 10 sec

    protected static final int MAX_WAITING_FOR_DII05_UPDATE_OF_TRANSIENT_STATE = 10000; // 10 sec

    protected static final int MAX_WAITING_FOR_PERSISTENCE_EVENTS = 10000; // 10 sec

    protected static final int MAX_WAITING_FOR_INDEX_UPDATE = 10000; // 10 sec

    private Map<ClientSpec, Connection> _connectionMap = new HashMap<ClientSpec, Connection>( );

    private ClientSpec _testClientSpec1 = null;


    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        putClient1( );
    }

    private synchronized void putClient1( ) {

        _testClientSpec1 = _testClient1.getClientSpec( );
        Connection connection = _testClient1.getConnection( );
        connection.setLabel( new Date( System.currentTimeMillis( ) ).toString( ) );
        _connectionMap.put( _testClientSpec1, connection );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        // clean handling of Moin reset.
        super.afterTestMethod( );
    }

    /** **************** Retrieval of connections *************************** */
    /**
     * This implementation is not general, but it is related to the test clients
     * and internal maps. For general implementation see in a respective Utility
     * in the respective TestHelper.
     */
    public Connection getMoinConnection( ) {

        _testClient1.setAsCurrentClient( );
        return getMoinConnection( _testClientSpec1 );
    }

    public Connection getSecondMOINConnection( ) {

        _testClient2.setAsCurrentClient( );
        return _testClient2.getConnection( );
    }

    public synchronized Connection getMoinConnection( ClientSpec clientSpec ) {

        Connection connection = _connectionMap.get( clientSpec );
        if ( connection == null || !connection.isAlive( ) ) {

            connection = createConnection( clientSpec );
            connection.setLabel( new Date( System.currentTimeMillis( ) ).toString( ) );
            _connectionMap.put( clientSpec, connection );
        }
//        else {
//            // hot_todo: [21.08.2008, sj, mk, uh]
//            // This should be removed, because the attaching to thread is normally done automatically by the ConnectionWrapper.
//            // In cases where the CoreConnection is used to perform special calls, the test case which performs this special internal
//            // handling should take care by itself that the CoreConnection is attached to thread.
//            ( (ConnectionWrapper) connection ).unwrap( ).attachToThread( );
//        }
        return connection;
    }

    /**
     * The method creates and returns the connection to MOIN which allows to
     * access the data in the given project.
     */
    private Connection createConnection( ClientSpec clientSpec ) {

        return createSession( clientSpec ).createConnection( );
    }


    /**
     * The method creates and returns a session to MOIN which allows to access
     * the data.
     */
    private Session createSession( ClientSpec clientSpec ) {

        // (1) Check preconditions:
        if ( clientSpec == null ) {
            throw new IllegalArgumentException( "NULL clientSpec in method: createSession" );
        }

        // (2) Get the CompoundClientSpec covering the given clientSpec
        CompoundClientSpec compoundClientSpec = ( (IdeCompoundDataAreaManager) getTestHelper( ).getMoin( ).getCompoundDataAreaManager( ) ).getDefaultCompoundClientSpec( clientSpec );

        // (3) Create the session for the given clientSpec
        Session session = getTestHelper( ).getMoin( ).createSession( compoundClientSpec );

        return session;
    }


    /** ******************* Utility methods for handling of models ********* */

    protected ServiceInteractionsPackage _packageExtendForServiceInteractionsModels;

    /**
     * Create model of meta-model MOF and assign it to the given partition. The
     * caller is responsible for saving the partition.
     */
    protected List<MRI> fillPartitionWithMofModel( Connection connection, ModelPartition mmPartition ) throws Exception {

        return UtilityModelCreation.fillPartitionWithMofModel( connection, mmPartition );
    }

    /**
     * Creates a model of meta-model ServiceInteractions and assigns it to the
     * given partition. The caller is responsible for saving the partition.
     */
    protected List<MRI> fillPartitionWithServiceInteractionsModelElements( ModelPartition partition ) {

        return UtilityModelCreation.fillPartitionWithServiceInteractionsModelElements( _packageExtendForServiceInteractionsModels, partition );
    }

    protected List<MRI> fillPartitionWithServiceInteractionsModelElements( Connection connection, ModelPartition partition ) {

        // Fill the partition using the packageExtend
        return UtilityModelCreation.fillPartitionWithServiceInteractionsModelElements( getPackageExtendForServiceInteractionsModels( connection ), partition );
    }

    protected void fillPartitionsWithServiceInteractionsModelElements( Connection connection, ModelPartition partition_1, ModelPartition partition_2, List<MRI> partitionMris_1, List<MRI> partitionMris_2 ) {

        // Fill the partition using the packageExtend
        UtilityModelCreation.fillPartitionsWithServiceInteractionsModelElements( getPackageExtendForServiceInteractionsModels( connection ), partition_1, partition_2, partitionMris_1, partitionMris_2 );
    }

    protected ServiceInteractionsPackage getPackageExtendForServiceInteractionsModels( Connection connection ) {

        // Retrieve the packageExtend for the MetaModel (which later is needed to create the respective model elements)
        String modelContainerName = null;
        String[] qualifiedName = new String[] { TestMetaModels.SERVICE_INTERACTIONS };
        ServiceInteractionsPackage packageExtendForServiceInteractionsModels = (ServiceInteractionsPackage) ( connection.getPackage( modelContainerName, qualifiedName ) );
        if ( packageExtendForServiceInteractionsModels == null ) {
            throw new RuntimeException( "PackageExtend for ServiceInteraction models could not be retrieved." );
        }
        return packageExtendForServiceInteractionsModels;
    }

    /**
     * Get the MOF ID for one of the model element which is a message.
     */
    protected String getMofIdOfAnyMessageInServiceInteractionsModel( ModelPartition partition ) {

        Collection<Partitionable> modelElements = partition.getElements( );
        for ( Partitionable modelElement : modelElements ) {
            if ( modelElement instanceof Message ) {
                return modelElement.refMofId( );
            }
        }
        return null;
    }

    /**
     * Performs the changes which later are tested in method
     * isModelElementInPartitionWithServiceInterationsModelElementsCorrectlyChanged
     * 
     * @param connection MOIN connection
     * @param mrisInPartition
     * @param mofIdOfMessage
     * @param changedMessageTypeValue
     */
    protected void changeModelElementInPartitionWithServiceInteractionsModelElements( Connection connection, List<MRI> mrisInPartition, String mofIdOfMessage, String changedMessageTypeValue ) {

        for ( MRI mri : mrisInPartition ) {
            if ( mri.getMofId( ).equals( mofIdOfMessage ) ) {
                RefBaseObject modelElement = connection.getElement( mri );
                // We change the type attribute of the first message we find,
                // that should be enough 'changedContent' for
                // this test case (if not, then additional changes can be
                // performed ...)
                if ( modelElement instanceof Message ) {
                    Message message = (Message) modelElement;
                    message.setType( changedMessageTypeValue );
                    return;
                }
            }
        }

        // Given partition did not contain a message
        throw new IllegalStateException( "Internal test error: test tries to change partition with wrong content" );
    }

    protected void addModelElementInPartitionWithServiceInteractionsModelElements( Connection connection, ModelPartition partition ) {

        // - create new messages
        Message message1 = (Message) getPackageExtendForServiceInteractionsModels( connection ).getMessage( ).refCreateInstance( );
        partition.assignElement( (Partitionable) message1 );
    }

    /**
     * Tests if the concrete changes performed in method
     * changeModelElementInPartitionWithServiceInteractionsModelElements are
     * still there in the given model elements.
     * 
     * @param connection MOIN connection
     * @param mrisInPartition
     * @param mofIdOfChangedModelElement
     * @param messageTypeValueToBeChecked
     * @return
     */
    protected boolean isModelElementInPartitionWithServiceInterationsModelElementsCorrectlyChanged( Connection connection, List<MRI> mrisInPartition, String mofIdOfChangedModelElement, String messageTypeValueToBeChecked ) {

        for ( MRI mri : mrisInPartition ) {
            RefBaseObject modelElement = connection.getElement( mri );
            if ( mofIdOfChangedModelElement.equals( modelElement.refMofId( ) ) ) {
                if ( modelElement instanceof Message ) {
                    Message message = (Message) modelElement;
                    if ( messageTypeValueToBeChecked.equals( message.getType( ) ) ) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    protected List<MRI> getMrisInPartition( PRI pri, Connection connection ) {

        ModelPartition partition = connection.getPartition( pri );
        if ( partition == null ) {
            return null;
        }

        System.out.println( "PRI found by getMrisInPartition : " + pri.toString( ) );

        Collection<Partitionable> modelElements = partition.getElements( );
        List<MRI> mrisInPartition = new ArrayList<MRI>( modelElements.size( ) );
        for ( Partitionable modelElement : modelElements ) {
            mrisInPartition.add( modelElement.get___Mri( ) );
        }
        return mrisInPartition;
    }

    protected boolean doesContainEqualMris( List<MRI> mriList1, List<MRI> mriList2 ) {

        if ( mriList1 == null && mriList2 == null ) {
            return true;
        }

        if ( mriList1 == null || mriList2 == null ) {
            return false;
        }

        // test if size is equal
        if ( mriList1.size( ) == mriList2.size( ) ) {

            // test if both lists contain equal elements
            List<MRI> mriList2Copy = new ArrayList<MRI>( mriList2 ); // parameter
            // should
            // not be
            // changed
            mriList2Copy.removeAll( mriList1 );
            if ( mriList2Copy.size( ) == 0 ) {
                return true;
            }
        }

        return false;
    }

    protected boolean doesContainEqualPris( Collection<PRI> priList1, Collection<PRI> priList2 ) {

        if ( priList1 == null && priList2 == null ) {
            return true;
        }

        if ( priList1 == null || priList2 == null ) {
            return false;
        }

        // test if size is equal
        if ( priList1.size( ) == priList2.size( ) ) {

            // test if both lists contain equal elements
            List<PRI> priList2Copy = new ArrayList<PRI>( priList2 ); // parameter should not be changed
            priList2Copy.removeAll( priList1 );
            if ( priList2Copy.size( ) == 0 ) {
                return true;
            }
        }

        return false;
    }

    protected boolean doesContainEqualCris( Collection<CRI> criList1, Collection<CRI> criList2 ) {

        if ( criList1 == null && criList2 == null ) {
            return true;
        }

        if ( criList1 == null || criList2 == null ) {
            return false;
        }

        // test if size is equal
        if ( criList1.size( ) == criList2.size( ) ) {

            // test if both lists contain equal elements
            List<CRI> criList2Copy = new ArrayList<CRI>( criList2 ); // parameter should not be changed
            criList2Copy.removeAll( criList1 );
            if ( criList2Copy.size( ) == 0 ) {
                return true;
            }
        }

        return false;
    }

    protected PRI getAnyRelatedMetaModelPri( ModelPartition partition ) {

        // Get any model element from the partition:
        Collection<Partitionable> modelElements = partition.getElements( );
        Iterator modelElementsIter = modelElements.iterator( );
        Partitionable modelElement = (Partitionable) modelElementsIter.next( );

        // Get the related meta model object for this model element and its PRI:
        RefObject metaModelObject = ( (RefBaseObject) modelElement ).refMetaObject( );
        PRI metaModelObjectPri = ( (Partitionable) metaModelObject ).get___Mri( ).getPri( );

        return metaModelObjectPri;
    }

    /**
     * ************* Candidates for refactoring in test framework
     * *************************** *
     */

    static protected void printTestInfo( String message ) {

        java.lang.System.out.println( message );
        java.lang.System.out.flush( );
    }

    static protected void printTestPreparationInfo( ) {

        printTestInfo( "Creating test data" );
    }

    static protected void printPreconditionTestInfo( ) {

        printTestInfo( "Checking preconditions" );
    }

    static protected void printTestMethodInfo( String testedMethod ) {

        printTestInfo( "Executing tested method '" + testedMethod + "'" );
    }

    static protected void printPostconditionTestInfo( ) {

        printTestInfo( "Checking postconditions" );
    }

    static protected void printTestObjectCleanUpInfo( ) {

        printTestInfo( "Cleaning up test objects" );
    }

    static protected void printTestBeginInfo( String testCase ) {

        java.lang.System.out.println( "------ Begin of test case: " + testCase + "------" );
        java.lang.System.out.flush( );
    }

    static protected void printTestSucceededInfo( String testCase ) {

        java.lang.System.out.println( "------ Test case succeeded: " + testCase + "------" );
        java.lang.System.out.flush( );
    }

    static protected void printTestFailedInfo( String testCase ) {

        java.lang.System.out.println( "------ Test case failed: " + testCase + "------" );
        java.lang.System.out.flush( );
    }

    static protected void logExceptionMessage( final String testedMethod, Exception exception ) {

        String message = null;
        if ( exception != null ) {
            message = "[Exception orrured] Method '" + testedMethod + "' has thrown exception '" + exception.getClass( ).getCanonicalName( ) + "': " + exception.getMessage( );
            printTestInfo( message );
            exception.printStackTrace( System.out );
        }
    }

    static protected String getFullTestCaseName( String testCase, String subTestCase ) {

        return testCase + "[" + subTestCase + "]";
    }

    static protected String getPreconditionFailedMessage( String text, String affectedObjectName ) {

        return "[Precondition check failed] " + text + ": " + affectedObjectName;
    }

    static protected String getPreconditionFailedMessage( String text, PRI affectedPri ) {

        return getPreconditionFailedMessage( text, affectedPri.toString( ) );
    }

    static protected String getPreconditionFailedMessage( String text, IProject eclipseProject ) {

        return getPreconditionFailedMessage( text, eclipseProject.toString( ) );
    }

    static protected String getPreconditionFailedMessage( String text, CRI affectedContainer ) {

        return getPreconditionFailedMessage( text, affectedContainer.toString( ) );
    }

    static protected String getExceptionThrownAssertMessage( final String testedMethod, Exception exception ) {

        if ( exception != null ) {
            return "[Postcondition check failed] Method '" + testedMethod + "' has thrown exception '" + exception.getClass( ).getCanonicalName( ) + "': " + exception.getMessage( );
        }
        return "No exception";
    }

    static protected String getExceptionNotThrownAssertMessage( final String testedMethod ) {

        return "[Postcondition check failed] Method '" + testedMethod + "' has not thrown expected exception.";
    }

    static protected String getPostconditionFailedMessage( String text, Object affectedObject ) {

        return "[Postcondition check failed] " + text + ": " + ( affectedObject == null ? "null_object" : affectedObject.toString( ) );
    }

    static protected String getPostconditionFailedMessage( String text ) {

        return "[Postcondition check failed] " + text;
    }

    /**
     * **************************** Candidates for refactoring of TestClient and
     * TestHelper ******************
     */

    /**
     * analogous to IdeNwdiTestClientImpl#getOrCreatePartition(String testName,
     * boolean useCounter), but:
     * 
     * @param clientSpec
     * @param fullDcName concatenation of vendor and DCName, separated by "/"
     * @param partitionPath is the partition path including resource folder and
     * partition suffix
     * @return
     */
    protected ModelPartition createPartition( ClientSpec clientSpec, String fullDcName, String partitionPath ) {

        DataArea dataArea = clientSpec.getDataArea( );
        PRI pri = getResourceIdentifierFactory( ).createPri( dataArea.getName( ), fullDcName, partitionPath );
        try {
            ModelPartition modelPartition = getMoinConnection( clientSpec ).getPartition( pri );
            if ( modelPartition != null ) {
                modelPartition.delete( );
                getMoinConnection( clientSpec ).save( );
            }
            modelPartition = getMoinConnection( clientSpec ).createPartition( pri );
            return modelPartition;
        } catch ( Exception e ) {
            // don't deal with checked exceptions in test cases
            throw new IllegalStateException( "'createPartition' failed because an exception was thrown:" + pri, e );
        }
    }

    protected ModelPartition createPartition( Connection connection, PRI pri ) {

        try {
            ModelPartition modelPartition = connection.getPartition( pri );
            if ( modelPartition != null ) {
                modelPartition.delete( );
                connection.save( );
            }
            modelPartition = connection.createPartition( pri );
            return modelPartition;
        } catch ( Exception e ) {
            // don't deal with checked exceptions in test cases
            throw new IllegalStateException( "'createPartition' failed because an exception was thrown:" + pri, e );
        }
    }

    protected PRI getPri( ClientSpec clientSpec, String fullDcName, String partitionPath ) {

        DataArea dataArea = clientSpec.getDataArea( );
        PRI pri = getResourceIdentifierFactory( ).createPri( dataArea.getName( ), fullDcName, partitionPath );
        return pri;
    }

    protected void cleanUpTestObjects( List testObjects, Connection connection ) throws Exception {

        if ( connection == null ) {
            return; // The test has crashed before any objects could be created
        }

        //turn off switch concerning precondition checks for changes and turn it on again at the end of the test        
        printTestObjectCleanUpInfo( );
        Exception exception = null;
        SpiFacility facility = (SpiFacility) getFacility( );
        ArrayList<File> files = new ArrayList<File>( );
        ArrayList<PRI> partitionsAsModifiableSources = new ArrayList<PRI>( );
        ArrayList<PRI> partitionsAsNotModifiableSources = new ArrayList<PRI>( );
        ArrayList<PRI> partitionsInArchives = new ArrayList<PRI>( );
        SpiLifecycleManagement lifecycleManagement = facility.getLifecycleManagement( );
        IpiFsResourceManagement fsPersistence = getResourceManagement( );
        for ( Object testObject : testObjects ) {

            try {
                if ( testObject == null ) {
                    continue;
                }
                if ( testObject instanceof File ) {
                    files.add( (File) testObject );

                } else if ( connection != null && testObject instanceof PRI ) {
                    PRI pri = (PRI) testObject;
                    CRI cri = pri.getCri( );
                    SpiClientSpec clientSpec = getClientSpec( cri );
                    if ( lifecycleManagement.isContainerModifiable( cri, clientSpec ) ) {
                        partitionsAsModifiableSources.add( pri );
                    } else {
                        // else: collect cri's for containers with PP archives and collect cri's for containers visible as active source
                        IpiStorage storage = fsPersistence.getStorageResponsibleForPRI( pri );
                        if ( storage instanceof StorageArchiveImpl ) {
                            partitionsInArchives.add( pri );
                        } else {
                            partitionsAsNotModifiableSources.add( pri );
                        }
                    }
                }
            } catch ( Exception e ) {
                e.printStackTrace( );
                // if there are several exceptions then they should at least be visible in stack trace ..., 
                // only the last of those exceptions will be thrown (see below) ...
                // error tolerance: we continue so that other test objects can be cleaned up ...
                if ( exception == null ) {
                    exception = e;
                }
            }
        }
        // Clean up as many as possible test objects, caution: order of steps (files as last step!!!)
        try {
            cleanUpPartitionsAsModifiableSources( partitionsAsModifiableSources, connection );
        } catch ( Exception e ) {
            if ( exception == null ) {
                exception = e;
            }
        }
        try {
            cleanUpPartitionsAsNotModifiableSources( partitionsAsNotModifiableSources );
        } catch ( Exception e ) {
            if ( exception == null ) {
                exception = e;
            }
        }
        try {
            cleanUpPartitionsInArchives( partitionsInArchives );
        } catch ( Exception e ) {
            if ( exception == null ) {
                exception = e;
            }
        }
        try {
            cleanUpFiles( files );
        } catch ( Exception e ) {
            if ( exception == null ) {
                exception = e;
            }
        }
//        not needed, acutal test is already through
//        if ( exception != null ) {
//            throw exception; // we do not ignore the exceptions from clean-up ...
//        }
    }

    private void cleanUpPartitionsAsModifiableSources( ArrayList<PRI> partitionsAsModifiableSources, Connection connection ) throws PartitionsNotSavedException, Exception {

        Exception exception = null;
        for ( PRI pri : partitionsAsModifiableSources ) {
            try {
                cleanUpPartition( pri, connection );
            } catch ( Exception e ) {
                e.printStackTrace( );
                // if there are several exceptions then they should at least be visible in stack trace ..., 
                // only the last of those exceptions will be thrown (see below) ...
                // error tolerance: we continue so that other test objects can be cleaned up ...
                if ( exception == null ) {
                    exception = e;
                }
            }
        }
        if ( exception != null ) {
            throw exception; // we do not ignore the exceptions from clean-up
            // ...
        }
    }

    private void cleanUpPartitionsAsNotModifiableSources( ArrayList<PRI> partitionsAsNotModifiableSources ) throws Exception, CoreException {

        Exception exception = null;
        IdeCompoundDataAreaManager dispatcher = getIdeFacilityDispatcher( );
        for ( PRI pri : partitionsAsNotModifiableSources ) {
            try {
                IProject eclipseProject = dispatcher.getProject( pri.getCri( ) );
                if ( eclipseProject != null ) {
                    eclipseProject.close( NO_PROGRESS_MONITOR );
                    dispatcher.refreshFromFileSystem( eclipseProject, DONT_FORCED_REFRESH );
                }
            } catch ( Exception e ) {
                e.printStackTrace( );
                // if there are several exceptions then they should at least be visible in stack trace ..., 
                // only the last of those exceptions will be thrown (see below) ...
                // error tolerance: we continue so that other test objects can be cleaned up ...
                if ( exception == null ) {
                    exception = e;
                }
            }
        }
        if ( exception != null ) {
            throw exception; // we do not ignore the exceptions from clean-up
            // ...
        }
    }

    private void cleanUpPartitionsInArchives( ArrayList<PRI> partitionsInArchives ) throws Exception {

        Exception exception = null;
        IpiFsResourceManagement fsPersistence = getResourceManagement( );
        IpiIdeDiService ideDiService = getIdeDiService( );
        for ( PRI pri : partitionsInArchives ) {

            try {
                // The pri from same container can be located in different PP archives with different paths
                // --> all pri have to be handled
                IpiStorage storage = fsPersistence.getStorageResponsibleForPRI( pri );
                if ( storage == null ) {
                    continue; // already refreshed
                }

                String absolutePathOfArchivesFolder = storage.getSourcePath( );
                File archiveFile = new File( absolutePathOfArchivesFolder );
                if ( archiveFile.exists( ) ) {
                    archiveFile.delete( );
                    //ideDiService.refreshFromFileSystem( pri.getCri( ), DONT_FORCED_REFRESH );
                }
            } catch ( Exception e ) {
                e.printStackTrace( );
                // if there are several exceptions then they should at least be visible in stack trace ..., 
                // only the last of those exceptions will be thrown (see below) ...
                // error tolerance: we continue so that other test objects can be cleaned up ...
                if ( exception == null ) {
                    exception = e;
                }
            }
        }
        if ( exception != null ) {
            throw exception; // we do not ignore the exceptions from clean-up
            // ...
        }
    }

    private void cleanUpFiles( ArrayList<File> files ) {

        for ( File file : files ) {
            cleanUpFile( file );
        }
    }

    protected void cleanUpFile( File file ) {

        if ( file.exists( ) ) {
            file.delete( );
        }
    }

    protected void cleanUpPartition( PRI pri, Connection connection ) throws PartitionsNotSavedException {

        ModelPartition partition = connection.getPartition( pri );
        if ( partition != null ) {
            partition.delete( );
            connection.save( );
        }
    }

    /** *** Utility methods for Eclipse Integration and FileSystem Access *** */

    protected void refreshEclipseResourceTreeForProject( final IProject project ) {

        // Refresh in WorkspaceRunnable so that no Eclipse ResourceChangedEvents are fired in between
        IWorkspaceRunnable runnable = new IWorkspaceRunnable( ) {

            public void run( IProgressMonitor monitor ) throws CoreException {

                final IProgressMonitor NO_PROGRESS_MONITOR = null;
                // do not catch CoreException of refreshLocal here but catch it in outer method
                project.refreshLocal( IResource.DEPTH_INFINITE, NO_PROGRESS_MONITOR );
            }
        };

        try {
            ResourcesPlugin.getWorkspace( ).run( runnable, project, IWorkspace.AVOID_UPDATE, null );

        } catch ( CoreException e ) {
            throw new RuntimeException( "Refresh of EclipseResourceTree for project failed: " + project.getName( ), e );
        }
    }

    /** ****** Utility methods for Access of internal facility parts ******* */
    protected IdeCompoundDataAreaManager getIdeFacilityDispatcher( ) {

        return (IdeCompoundDataAreaManager) getTestHelper( ).getCoreMoin( ).getCompoundDataAreaManager( );
    }


    protected IdeFacilityDispatcherInternal getIdeFacilityDispatcherInternal( ) {

        return (IdeFacilityDispatcherInternal) getTestHelper( ).getCoreMoin( ).getCompoundDataAreaManager( );
    }

    protected IdePrimaryFacility getIdePrimaryFacility( ) {

        return ( (IdePrimaryFacility) getFacility( ) );
    }

    protected SpiClientSpec getClientSpec( IProject project ) {

        return (SpiClientSpec) getIdeFacilityDispatcher( ).getClientSpec( project );
    }

    protected SpiLifecycleManagement getLifecycleManagement( ) {

        return getSpiFacility( ).getLifecycleManagement( );
    }

    protected SpiFacility getSpiFacility( ) {

        return (SpiFacility) getFacility( );
    }

    protected IpiFsResourceManagement getResourceManagement( ) {

        return ( (IpiFsFacilityForTest) getFacility( ) ).getResourceManagement( );
    }

    protected IpiIdeDiService getIdeDiService( ) {

        return (IpiIdeDiService) getLifecycleManagement( );
    }

    protected IdeFacilityDispatcherInternal getInternalDispatcher( ) {

        return (IdeFacilityDispatcherInternal) getIdeFacilityDispatcher( );
    }

    protected SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        return getSpiFacility( ).getPartitionSerializationManager( );
    }

    protected SpiIdeFacility getSpiIdeFacility( ) {

        return (SpiIdeFacility) getFacility( );
    }

    protected IFile getFileHandle( PRI pri ) {

//        return getIdeDiService( ).getFileHandle(pri);
        IpiStorage storage = getResourceManagement( ).getStorageResponsibleForPRI( pri );
        if ( storage == null ) {
            return null;
        }
        IpiLogicalResource rh = storage.getPartitionResourceHandle( pri );
        return rh != null ? rh.getUnderlyingResource( IFile.class ) : null;
    }

    protected IFile getFile( PRI pri ) {

//      return getIdeDiService( ).getFile(pri);

        IFile file = getFileHandle( pri );
        return file != null && file.exists( ) ? file : null;
    }

    //
    // Please do not cast the result to IdeResourceIdentifierFactory !!!
    // This functionality has to be provided by the IdeFacilityDispatcher interface. 
    // 
    protected ResourceIdentifierFactory getResourceIdentifierFactory( ) {

        return getFacility( ).getRIFactory( );
    }

// protected NwdiPersistence getNwdiPersistence( ) {
//
// return (NwdiPersistence) ((SpiFacility) getIdePrimaryFacility(
// )).getModelPersistence( );
// }
// protected DbPersistence getDbPersistence() {
//
// return DbPersistenceImpl.getInstance(null);
// }
    /**
     * *********************** Utility methods for Access to DbIndex
     * *************************************
     */
    private boolean isNoDb( ) {

        // evaluate system flag
        boolean noDb = true; // was:
        // MoinSystemPropertyValues.COM_SAP_TC_MOIN_NODB;
        return noDb;
    }

    protected boolean isPartitionInIndex( PRI pri, String stage ) {

        if ( isNoDb( ) ) {
            // ask slim index
            IpiIndexManagement index;
            index = (IndexImpl) ( (SpiFacility) getFacility( ) ).getCoreQueryService( );

            if ( index != null ) {
                return index.isPartitionIndexed( pri );
            }
            return false;
        }
        return false;
    }

    protected long getTimestampFromIndex( PRI pri, String clientSpecificStageName ) {

        if ( isNoDb( ) ) {
            // ask slim index
            IpiIndexManagement index;
            index = (IndexImpl) ( (SpiFacility) getFacility( ) ).getCoreQueryService( );

            if ( index != null ) {
                return index.getPartitionTimestamp( pri );
            }
            return 0;
        }
        return 0;
    }



    /**
     * *** todo: Utility methods for facility internal logic --> refactor inside
     * facility *********************
     */

    protected String getClientSpecificStageName( ClientSpec clientSpec ) {

        // todo: refactor so that method
        // IdeDii05ServiceImpl#getClientSpecificStageName( NwdiClientSpec
        // clientSpec )
        // is available in super class of IdeDii05ServiceImpl and in the
        // respective Ipi
        // and use this method here.
        return clientSpec.getClientId( );
    }

    protected boolean doesBelongToClientSpec( PRI pri, ClientSpec clientSpec ) {

        // todo: refactor so that the method is available in the facility IPI in IDE scenario
        return pri.getDataAreaDescriptor( ).getDataAreaName( ).equals( clientSpec.getClientId( ) );
    }

    protected SpiClientSpec getClientSpec( CRI cri ) {

        // todo: refactor so that the method is available in the facility IPI in IDE scenario
        String dataAreaName = cri.getDataAreaDescriptor( ).getDataAreaName( );
        String clientSpecName = dataAreaName;
        DataArea dataArea = getFacility( ).getDataAreaByName( dataAreaName );
        return (SpiClientSpec) dataArea.getClientSpec( clientSpecName );
    }

    protected void threadSleep( long millis, String testedMethod ) {

        try {
            Thread.sleep( millis );
        } catch ( InterruptedException exception ) {
            logExceptionMessage( testedMethod, exception );
            try {
                Thread.sleep( millis );
            } catch ( InterruptedException ex ) {
                logExceptionMessage( testedMethod, ex );
            }
        }
    }

}
