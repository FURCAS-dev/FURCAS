package com.sap.tc.moin.facility.primary.inconsistency;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.junit.Before;
import org.junit.Test;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.tc.moin.primary.facility.test.ide.FacilityIdeMoinTest;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.ConsistencyViolationRegistryWrapperImpl;
import com.sap.tc.moin.repository.core.consistency.impl.ConsistencyViolationRegistryImpl;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcases.case001.B1;


public class TestVisibilityRulesConsistency extends FacilityIdeMoinTest {

    private static final String TEST_CASE = "TestVisibilityRulesConsistency";

    private static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    // Convenience:
    final boolean NEW_INSTANCE = true;

    /**
     * Test-SetUp:Perform the standard set-up procedure
     * <p>
     * The packageExtend for models of the used meta model is retrieved.
     * </p>
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // Retrieve the packageExtend for the MetaModel (which later is needed to create the respective model elements)
        String modelContainerName = null;
        String[] qualifiedName = new String[] { TestMetaModels.SERVICE_INTERACTIONS };
        _packageExtendForServiceInteractionsModels = (ServiceInteractionsPackage) ( getMoinConnection( ).getPackage( modelContainerName, qualifiedName ) );
        if ( _packageExtendForServiceInteractionsModels == null ) {
            throw new RuntimeException( "PackageExtend for ServiceInteraction models could not be retrieved." );
        }

    }

    /**
     * The test creates forbidden link and checks if the explicit consistency
     * check detects the inconsistency.
     * 
     * @throws Exception
     */
    @Test
    public void TestVisibilityRulesOfCompModel( ) throws Exception {

        final String subTestCaseName = "visibilityConsistency";
        final String fullTestCaseName = getFullTestCaseName( TEST_CASE, subTestCaseName );

        boolean testSucceeded = false;

        // Test objects
        List testObjects = new ArrayList( );
        Connection connection = null;

        printTestBeginInfo( fullTestCaseName );

        try {
            TestClient myTestClient = MOIN_IDE_TEST_HELPER.getDefaultTestClient( NEW_INSTANCE );

            // First test situation: References to DCs which are all visible
            // =============================================================
            // In Detail:
            // - srcDc01 references destDc01
            // - where the destination DCs are MOIN-relevant and have a respective PP purpose compilation          

            printTestMethodInfo( "References to DCs which have 1 partition" );

            // - Preparation of test:
            // ----------------------
            // Create/Determine the needed test data: test project, test partitions in this project, …

            printTestPreparationInfo( );

            connection = getMoinConnection( );

            // Create srcDc01
            // -- Get or create the specific test-DC, including test-project in the given default local DevConfig
            String subTestCaseNameWithRestrictedLength = subTestCaseName.length( ) <= 29 ? subTestCaseName : subTestCaseName.substring( 0, 29 );
            String dcVendor = "test.sap.com";
            String dcName_01 = "moin/pf/" + subTestCaseNameWithRestrictedLength + "/srcModelCase001Dc01";
            String fullDcName_01 = dcVendor + "/" + dcName_01;
            IProject eclipseMMProject_01 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinMetaModelDCProject( dcVendor, dcName_01 );
            IDevelopmentComponent srcDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_01 );
            CRI srcDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_01 );

            SpiClientSpec clientSpec = getClientSpec( eclipseMMProject_01 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = makePartitionName( "myCase001Partition1" );
            ModelPartition mmPartition_01 = createPartition( clientSpec, fullDcName_01, "moin/meta/" + partitionName_01 );
            PRI mmPri_01 = mmPartition_01.getPri( );

            connection.save( );

            // Create and 'fill' destDc01
            // -- Get or create the specific test-DC, including test-project in the given default local DevConfig
            String dcName_02 = "moin/pf/" + subTestCaseNameWithRestrictedLength + "/destModelCase001Dc01";
            String fullDcName_02 = dcVendor + "/" + dcName_02;
            IProject eclipseMMProject_02 = MOIN_IDE_TEST_HELPER.getOrCreateLocalMoinMetaModelDCProject( dcVendor, dcName_02 );
            IDevelopmentComponent destDc01 = DiiResourceService.getDevelopmentComponent( eclipseMMProject_02 );
            CRI destDc01Cri = getIdeFacilityDispatcher( ).getContainer( eclipseMMProject_02 );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_02 = makePartitionName( "myCase001Partition2" );
            ModelPartition mmPartition_02 = createPartition( clientSpec, fullDcName_02, "moin/meta/" + partitionName_02 );
            PRI mmPri_02 = mmPartition_02.getPri( );

            // Create the references between the DCs:
            ArrayList<IDevelopmentComponent> destDcs = new ArrayList<IDevelopmentComponent>( 3 );
            destDcs.add( destDc01 );
            MOIN_IDE_TEST_HELPER.getDcModificationUtil( ).addDcDependencies( srcDc01, destDcs, MOIN_IDE_TEST_HELPER.getDcModificationUtil( ).NAME_OF_PP_PURPOSE_COMPILATION_FOR_MM_DC );

            connection.save( );

            A1 a1 = this.createA1( connection );
            B1 b1 = this.createB1( connection );

            a1.getBs( ).add( b1 );

            mmPartition_01.assignElement( a1 );
            mmPartition_02.assignElement( b1 );

            connection.save( );

            MyConsistencyListener listener = new MyConsistencyListener( );

            connection.getConsistencyViolationListenerRegistry( ).addListener( listener );

            connection.getConsistencyViolationListenerRegistry( ).performDcDependencyCheck( mmPartition_01.getPri( ) );

            this.processNotificationQueue( connection );
            verifyAndLog( "Too many inconsistencies found.", listener.getViolations( ).isEmpty( ), true );

            // next test: violation of visibility      

            // remove dependencies            
            MOIN_IDE_TEST_HELPER.getDcModificationUtil( ).removePublicPartFromDc( destDc01, MOIN_IDE_TEST_HELPER.getDcModificationUtil( ).NAME_OF_PP_PURPOSE_COMPILATION_FOR_MODEL_DC );

            connection.getConsistencyViolationListenerRegistry( ).performDcDependencyCheck( mmPartition_01.getPri( ) );

            this.processNotificationQueue( connection );
            verifyAndLog( "Inconsistencies not found.", listener.getViolations( ).isEmpty( ), false );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        } finally {

            // Print test result
            if ( testSucceeded ) {
                printTestSucceededInfo( fullTestCaseName );
            } else {
                try {
                    // The test objects potentially have not yet been
                    // cleaned-up:
                    cleanUpTestObjects( testObjects, connection );
                } catch ( Exception e1 ) {
                    e1.printStackTrace( );
                }
                printTestFailedInfo( fullTestCaseName );
            }
        }


    }

    private B1 createB1( Connection conn ) {

        return conn.createElementInPartition( B1.class, null );
    }

    private A1 createA1( Connection conn ) {

        return conn.createElementInPartition( A1.class, null );
    }

    protected void processNotificationQueue( Connection conn ) {

        ConsistencyViolationRegistryImpl registry = (ConsistencyViolationRegistryImpl) ( (ConsistencyViolationRegistryWrapperImpl) conn.getConsistencyViolationListenerRegistry( ) ).unwrap( );
        registry.processNotificationQueue( );
    }

    class MyConsistencyListener implements ConsistencyListener {

        private final List<ConsistencyViolation> events = new ArrayList<ConsistencyViolation>( );

        private int numberOfNotifications = 0;

        public void onConsistencyViolation( ConsistencyViolation[] consistencyEvents, Connection connection ) {

            for ( ConsistencyViolation event : consistencyEvents ) {
                this.events.add( event );
            }
            this.numberOfNotifications++;
        }

        public void onConsistencyResolution( ConsistencyViolation[] consistencyEvents, Connection connection ) {

            for ( ConsistencyViolation event : consistencyEvents ) {
                this.events.remove( event );
            }
            this.numberOfNotifications++;
        }

        public List<ConsistencyViolation> getViolations( ) {

            return new ArrayList<ConsistencyViolation>( this.events );
        }

        public void reset( ) {

            this.events.clear( );
            this.numberOfNotifications = 0;
        }

        public List<ConsistencyViolation> getEvents( ) {

            return this.events;
        }

        public int getNumberOfNotifications( ) {

            return this.numberOfNotifications;
        }

    }
}
