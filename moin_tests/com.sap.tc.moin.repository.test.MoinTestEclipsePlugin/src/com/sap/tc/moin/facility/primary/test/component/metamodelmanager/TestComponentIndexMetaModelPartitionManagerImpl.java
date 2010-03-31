package com.sap.tc.moin.facility.primary.test.component.metamodelmanager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaManager;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.IndexingAction;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncReport;
import com.sap.tc.moin.facility.primary.metamodelmanager.IndexMetaModelPartitionManagerImpl;
import com.sap.tc.moin.facility.primary.metamodelmanager.IndexMofRomInjectionServiceImpl;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsMetaModelManager.MetaModelPartitionDeploymentRecord;
import com.sap.tc.moin.test.testcase.MoinTestCase;


public class TestComponentIndexMetaModelPartitionManagerImpl extends MoinTestCase {

    /*
     * Private members
     */

    // component under test
    private IndexMetaModelPartitionManagerImpl indexMetaModelmPartitionManager = null;

    private IndexMofRomInjectionServiceImpl mofRomInjectionService;

    // collaborator mocks
    private IpiIndexManagement indexManagementMock = null;

    private IpiDataAreaManager dataAreaManagerMock = null;

    private DataArea metamodelDataArea = null;

    private DataAreaDescriptor metamodelDataAreaDescriptor = null;

    /*
     * JUnit life cycle
     */

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // create instance to test
        this.indexMetaModelmPartitionManager = new IndexMetaModelPartitionManagerImpl( );
        this.mofRomInjectionService = new IndexMofRomInjectionServiceImpl( );

        // create mocks for collaborators
        this.indexManagementMock = EasyMock.createStrictMock( IpiIndexManagement.class );
        this.dataAreaManagerMock = EasyMock.createStrictMock( IpiDataAreaManager.class );
        this.metamodelDataArea = EasyMock.createStrictMock( DataArea.class );
        this.metamodelDataAreaDescriptor = EasyMock.createStrictMock( DataAreaDescriptor.class );

        EasyMock.expect( this.dataAreaManagerMock.getMetaModelDataArea( ) ).andReturn( this.metamodelDataArea ).anyTimes( );
        EasyMock.expect( this.metamodelDataArea.getDescriptor( ) ).andReturn( this.metamodelDataAreaDescriptor ).anyTimes( );
        EasyMock.expect( this.metamodelDataAreaDescriptor.getDataAreaName( ) ).andReturn( IpiPrimaryFacility.META_MODEL_DATA_AREA_ID ).anyTimes( );

        // bind collaborator mocks to the component under test
        this.indexMetaModelmPartitionManager.bind( this.indexManagementMock );
        this.indexMetaModelmPartitionManager.bind( this.dataAreaManagerMock );
        this.mofRomInjectionService.bind( this.indexManagementMock );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );

        // nullify component under test
        this.indexMetaModelmPartitionManager = null;

        // nullify collaborator mocks
        this.indexManagementMock = null;
    }

    /*
     * Mock helper methods
     */

    private void setMemberMocksToReplayMode( ) {

        // set to replay mode
        EasyMock.replay( this.indexManagementMock );
        EasyMock.replay( this.dataAreaManagerMock );
        EasyMock.replay( this.metamodelDataArea );
        EasyMock.replay( this.metamodelDataAreaDescriptor );
    }

    /*
     * The actual test methods
     */

    /**
     * Tests if the getter {@link #testGetPartitionStream()} reacts properly on
     * illegal arguments.
     */
    @Test
    public void testGetPartitionStreamIllegalArgument( ) {

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );


        /////////////////////////////////////
        // perform test

        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( null );
            fail( "Passing null should lead to a NullPointerException" );
        } catch ( NullPointerException npe ) {
            // expected exception
        }
    }

    /**
     * Tests if the getter {@link #testGetPartitionStream()} works correctly.
     */
    @Test
    public void testGetPartitionStream( ) {

        /////////////////////////////////////
        // create parameter mocks

        PRI deployedPri = EasyMock.createMock( PRI.class );
        PRI undeployedPri = EasyMock.createMock( PRI.class );

        // stream related mocks (EasyMock is unable to handle InputStream cause it is an abstract class)
        SpiPartitionStreamProvider spiPartitionStreamProviderMock = EasyMock.createMock( SpiPartitionStreamProvider.class );
        MyMockInputStream deployedPriInputStream = new MyMockInputStream( );

        /////////////////////////////////////
        // create regular parameters

        MetaModelPartitionDeploymentRecord records[] = this.createDeploymentRecordArray( new PRI[] { deployedPri }, new long[] { -1 }, spiPartitionStreamProviderMock );

        /////////////////////////////////////
        // define expectations

        // expect call: Index update based on passed pri lists => return proper syncReport
        SyncReport returnIndexUpdateSyncReport = new SyncReport( null, null, null, null, null, null, null );
        EasyMock.expect( this.indexManagementMock.synchronize( EasyMock.aryEq( new PRI[] { deployedPri } ), EasyMock.aryEq( new long[] { -1 } ), (SpiPartitionStreamProvider) EasyMock.anyObject( ), EasyMock.eq( false ), EasyMock.eq( this.metamodelDataAreaDescriptor ) ) )
            .andReturn( returnIndexUpdateSyncReport ).once( );

        // expected calls: get partition streams for deployed metamodel partition
        EasyMock.expect( spiPartitionStreamProviderMock.getPartitionStream( deployedPri ) ).andReturn( deployedPriInputStream ).once( );

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );
        EasyMock.replay( deployedPri, undeployedPri );
        EasyMock.replay( spiPartitionStreamProviderMock );

        /////////////////////////////////////
        // perform test

        // assert: input stream for not yet deployed metamodel partition is not available
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

        // deploy
        this.indexMetaModelmPartitionManager.setDeployedMetamodelPartitions( Arrays.asList( records ) );

        // assert: input stream for deployed metamodel partition is available
        assertSame( "Unexpected input stream returned for deployed metamodel partition.", deployedPriInputStream, this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri ) );

        // assert: input stream for not deployed partition is not available
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( undeployedPri );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

    }

    /**
     * Tests if the deployment of meta models reacts properly on illegal
     * arguments.
     */
    @Test
    public void testSetDeployedMetamodelPartitionsIllegalArgument( ) {

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );

        /////////////////////////////////////
        // perform test

        try {
            this.indexMetaModelmPartitionManager.setDeployedMetamodelPartitions( null );
            fail( "Passing null should lead to NullPointerException" );
        } catch ( NullPointerException npe ) {
            // expected exception
        }

    }

    /**
     * Tests if the deployment of meta models works properly.
     */
    @Test
    public void testSetDeployedMetamodelPartitionsEmptyArgument( ) {

        /////////////////////////////////////
        // create parameter mocks

        // not deployed by runtime host / was in index dump
        PRI priMockDelete = EasyMock.createMock( PRI.class );

        /////////////////////////////////////
        // define expectations

        // expect call: Index update based on passed pri lists => return proper syncReport
        SyncReport returnIndexUpdateSyncReport = new SyncReport( null, null, null, null, null, Arrays.asList( priMockDelete ), null );
        EasyMock.expect( this.indexManagementMock.synchronize( EasyMock.aryEq( new PRI[0] ), EasyMock.aryEq( new long[0] ), (SpiPartitionStreamProvider) EasyMock.anyObject( ), EasyMock.eq( false ), EasyMock.eq( this.metamodelDataAreaDescriptor ) ) ).andReturn( returnIndexUpdateSyncReport ).once( );

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );

        /////////////////////////////////////
        // perform test

        List<PRI> returnedDefectivePartitions = this.indexMetaModelmPartitionManager.setDeployedMetamodelPartitions( (List<MetaModelPartitionDeploymentRecord>) Collections.EMPTY_LIST );

        // assert: defective partition was returned correctly
        assertEquals( "Unexpected return value: should be an empty list.", Collections.emptyList( ), returnedDefectivePartitions );

    }

    /**
     * Tests if the deployment of meta models works properly.
     */
    @Test
    public void testSetDeployedMetamodelPartitions( ) {

        /////////////////////////////////////
        // create parameter mocks

        // deployed by runtime host / not in index dump
        PRI priMockAdd = EasyMock.createMock( PRI.class );

        // deployed by runtime host / was in index dump        
        PRI priMockUpdate = EasyMock.createMock( PRI.class );
        PRI priMockNop = EasyMock.createMock( PRI.class );

        // not deployed by runtime host / was in index dump
        PRI priMockDelete = EasyMock.createMock( PRI.class );

        // deployed by runtime host / indexing error
        PRI priMockErr = EasyMock.createMock( PRI.class );

        // stream related mocks (EasyMock is unable to handle InputStream cause it is an abstract class)
        SpiPartitionStreamProvider spiPartitionStreamProviderMock = EasyMock.createMock( SpiPartitionStreamProvider.class );
        MyMockInputStream isMockAdd = new MyMockInputStream( );
        MyMockInputStream isMockUpdate = new MyMockInputStream( );
        MyMockInputStream isMockNop = new MyMockInputStream( );

        /////////////////////////////////////
        // create regular parameters

        PRI pris[] = new PRI[] { priMockAdd, priMockUpdate, priMockNop, priMockErr };
        long timestamps[] = new long[] { -1, -1, -1, -1 };
        MetaModelPartitionDeploymentRecord records[] = this.createDeploymentRecordArray( pris, timestamps, spiPartitionStreamProviderMock );

        /////////////////////////////////////
        // define expectations

        // expect call: Index update based on passed pri lists => return proper syncReport
        SyncReport returnIndexUpdateSyncReport = new SyncReport( Arrays.asList( priMockAdd ), null, Arrays.asList( priMockUpdate ), null, //
                                                                 Arrays.asList( priMockNop ), Arrays.asList( priMockDelete ), //
                                                                 Arrays.asList( priMockErr ) );
        EasyMock.expect( this.indexManagementMock.synchronize( EasyMock.aryEq( pris ), EasyMock.aryEq( timestamps ), (SpiPartitionStreamProvider) EasyMock.anyObject( ), EasyMock.eq( false ), EasyMock.eq( this.metamodelDataAreaDescriptor ) ) ).andReturn( returnIndexUpdateSyncReport ).once( );

        // expected calls: get partition streams for deployed metamodel partitions
        EasyMock.expect( spiPartitionStreamProviderMock.getPartitionStream( priMockAdd ) ).andReturn( isMockAdd ).once( );
        EasyMock.expect( spiPartitionStreamProviderMock.getPartitionStream( priMockUpdate ) ).andReturn( isMockUpdate ).once( );
        EasyMock.expect( spiPartitionStreamProviderMock.getPartitionStream( priMockNop ) ).andReturn( isMockNop ).once( );

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );
        EasyMock.replay( spiPartitionStreamProviderMock );
        EasyMock.replay( priMockAdd, priMockUpdate, priMockNop, priMockDelete, priMockErr );

        /////////////////////////////////////
        // perform test

        // deploy
        List<PRI> returnedDefectivePartitions = this.indexMetaModelmPartitionManager.setDeployedMetamodelPartitions( Arrays.asList( records ) );

        // assert: defective partition was returned correctly
        assertEquals( "Defective partitions were not correctly returned to the caller.", Arrays.asList( priMockErr ), returnedDefectivePartitions );

        // assert: stream provider of defective partition is not available
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( priMockErr );
            fail( "Expected exception was not thrown: Stream provider of defective partition must not be available after deployment." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

        // assert: stream provider of deleted partition (dump leftover) is not available
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( priMockDelete );
            fail( "Expected exception was not thrown: Stream provider of deleted partition (dump leftover) must not be available after deployment." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

        // assert: stream providers of all other partitions are available
        assertSame( "Unexpected or no stream provider returned.", isMockAdd, this.indexMetaModelmPartitionManager.getPartitionStream( priMockAdd ) );
        assertSame( "Unexpected or no stream provider returned.", isMockNop, this.indexMetaModelmPartitionManager.getPartitionStream( priMockNop ) );
        assertSame( "Unexpected or no stream provider returned.", isMockUpdate, this.indexMetaModelmPartitionManager.getPartitionStream( priMockUpdate ) );
    }

//    /**
//     * Tests if the deployment of meta models works properly when its called
//     * recurrently.<br>
//     * UNDER CONSTRUCTION
//     */
//    @Test
//    @Ignore
//    public void testSetDeployedMetamodelPartitionsRecurrently( ) {
//
//        /////////////////////////////////////
//        // create parameter mocks
//
//        // not deployed by runtime host / was in index dump
//        PRI priMockAddDelete = EasyMock.createMock( PRI.class );
//
//        /////////////////////////////////////
//        // define expectations
//
//        // expect call: Index update based on passed pri lists => return proper syncReport
//        SyncReport returnIndexUpdateSyncReport = new SyncReport( null, null, null, null, null );
//        EasyMock.expect( this.indexManagementMock.synchronize( EasyMock.eq( SyncKind.METAMODEL_CONTENT ), EasyMock.aryEq( new PRI[0] ), EasyMock.aryEq( new long[0] ), (SpiPartitionStreamProvider) null, EasyMock.eq( false ) ) ).andReturn( returnIndexUpdateSyncReport ).once( );
//
//        /////////////////////////////////////
//        // set mocks to replay mode
//
//        this.setMemberMocksToReplayMode( );
//
//        /////////////////////////////////////
//        // perform test
//
//        this.indexMetaModelmPartitionManager.setDeployedMetamodelPartitions( Arrays.asList( new MetaModelPartitionDeploymentRecord[0] ) );
//    }

    @Test
    public void testRemoveDeployedMetamodelPartitions( ) {

        /////////////////////////////////////
        // create parameter mocks

        PRI deployedPriContainer1 = EasyMock.createStrictMock( PRI.class );
        PRI deployedPriContainer2 = EasyMock.createStrictMock( PRI.class );
        PRI undeployedPri = EasyMock.createStrictMock( PRI.class );

        CRI container1 = EasyMock.createStrictMock( CRI.class );
        CRI container2 = EasyMock.createStrictMock( CRI.class );

        // stream related mocks (EasyMock is unable to handle InputStream cause it is an abstract class)
        SpiPartitionStreamProvider spiPartitionStreamProviderMock = EasyMock.createStrictMock( SpiPartitionStreamProvider.class );
        MyMockInputStream deployedPriContainer1InputStream = new MyMockInputStream( );
        MyMockInputStream deployedPriContainer2InputStream = new MyMockInputStream( );

        /////////////////////////////////////
        // create regular parameters

        PRI deployedPris[] = new PRI[] { deployedPriContainer1, deployedPriContainer2 };
        long timestamps[] = new long[] { -1, -1 };

        MetaModelPartitionDeploymentRecord records[] = this.createDeploymentRecordArray( deployedPris, timestamps, spiPartitionStreamProviderMock );

        /////////////////////////////////////
        // define expectations

        // expect call: Index update based on passed pri lists => return proper syncReport
        SyncReport returnIndexUpdateSyncReport = new SyncReport( null, null, null, null, null, null, null );
        EasyMock.expect( this.indexManagementMock.synchronize( EasyMock.aryEq( deployedPris ), EasyMock.aryEq( timestamps ), (SpiPartitionStreamProvider) EasyMock.anyObject( ), EasyMock.eq( false ), EasyMock.eq( this.metamodelDataAreaDescriptor ) ) ).andReturn( returnIndexUpdateSyncReport ).once( );

        // expected calls: get partition streams for deployed metamodel partition
        EasyMock.expect( spiPartitionStreamProviderMock.getPartitionStream( deployedPriContainer1 ) ).andReturn( deployedPriContainer1InputStream ).once( );
        EasyMock.expect( spiPartitionStreamProviderMock.getPartitionStream( deployedPriContainer2 ) ).andReturn( deployedPriContainer2InputStream ).once( );

        // expect calls: getCri on deployed cris
        EasyMock.expect( deployedPriContainer1.getCri( ) ).andReturn( container1 ).once( );
        EasyMock.expect( deployedPriContainer2.getCri( ) ).andReturn( container2 ).once( );

        // expected call: update index on removal of container1
        EasyMock.expect( this.indexManagementMock.synchronize( EasyMock.aryEq( new PRI[0] ), EasyMock.aryEq( new long[0] ), (SpiPartitionStreamProvider) EasyMock.anyObject( ), EasyMock.eq( true ), EasyMock.eq( container1 ) ) ).andReturn( returnIndexUpdateSyncReport ).once( );

        // expected calls: get partition streams for deployed metamodel partition
        EasyMock.expect( spiPartitionStreamProviderMock.getPartitionStream( deployedPriContainer2 ) ).andReturn( deployedPriContainer2InputStream ).once( );

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );
        EasyMock.replay( deployedPriContainer1, deployedPriContainer2, undeployedPri );
        EasyMock.replay( spiPartitionStreamProviderMock );

        /////////////////////////////////////
        // perform test

        // deploy container1 and container2
        this.indexMetaModelmPartitionManager.setDeployedMetamodelPartitions( Arrays.asList( records ) );

        // assert: input stream for now deployed metamodel partitions is available
        assertSame( "Unexpected input stream returned for deployed metamodel partition.", deployedPriContainer1InputStream, this.indexMetaModelmPartitionManager.getPartitionStream( deployedPriContainer1 ) );
        assertSame( "Unexpected input stream returned for deployed metamodel partition.", deployedPriContainer2InputStream, this.indexMetaModelmPartitionManager.getPartitionStream( deployedPriContainer2 ) );

        // assert: input stream for not deployed partition is not available
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( undeployedPri );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

        // undeploy container 2
        this.indexMetaModelmPartitionManager.removeDeployedMetamodelPartitions( container1 );

        // assert: input stream for still deployed metamodel partition is available
        assertSame( "Unexpected input stream returned for deployed metamodel partition.", deployedPriContainer2InputStream, this.indexMetaModelmPartitionManager.getPartitionStream( deployedPriContainer2 ) );

        // assert: input stream for removed deployed partitions is not available
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPriContainer1 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

        // assert: input stream for not deployed partition is not available
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( undeployedPri );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

    }

    /**
     * Test for MofRom injection.<br>
     * The correctness of the created partition deltas is not checked in this
     * test.
     */
    @Test
    @Ignore
    public void testInjectMofRomPartitions( ) {

        /////////////////////////////////////
        // create parameter mocks

        SpiModelPartition deployedPartition1Phase1 = EasyMock.createNiceMock( SpiModelPartition.class );
        SpiModelPartition deployedPartition2Phase1 = EasyMock.createNiceMock( SpiModelPartition.class );
        SpiModelPartition deployedPartition3Phase2 = EasyMock.createNiceMock( SpiModelPartition.class );
        SpiModelPartition deployedPartition4Phase2 = EasyMock.createNiceMock( SpiModelPartition.class );

        PRI undeployedPri = EasyMock.createStrictMock( PRI.class );
        PRI deployedPri1Phase1 = EasyMock.createStrictMock( PRI.class );
        PRI deployedPri2Phase1 = EasyMock.createStrictMock( PRI.class );
        PRI deployedPri3Phase2 = EasyMock.createStrictMock( PRI.class );
        PRI deployedPri4Phase2 = EasyMock.createStrictMock( PRI.class );

        List<SpiModelPartition> mofRomPartitionsPhase1 = Arrays.asList( new SpiModelPartition[] { deployedPartition1Phase1, deployedPartition2Phase1 } );
        List<SpiModelPartition> mofRomPartitionsPhase2 = Arrays.asList( new SpiModelPartition[] { deployedPartition3Phase2, deployedPartition4Phase2 } );
        List<PRI> mofRomPrisPhase2 = Arrays.asList( new PRI[] { deployedPri3Phase2, deployedPri4Phase2 } );

        /////////////////////////////////////
        // define expectations

        // expect call: for each partition
        // 1) get pri
        // 2) remove partition from index (must not be in index at this moment: paranoia check in MMPManager)
        // 3) index partition via delta operation (WE DO NOT CHECK CORRECTNESS OF THE DELTAS HERE)
        EasyMock.expect( deployedPartition1Phase1.getPri( ) ).andReturn( deployedPri1Phase1 ).anyTimes( );
        EasyMock.expect( this.indexManagementMock.removePartition( EasyMock.same( deployedPri1Phase1 ) ) ).andReturn( IndexingAction.NOP ).once( );
        EasyMock.expect( this.indexManagementMock.indexPartition( EasyMock.same( deployedPri1Phase1 ), EasyMock.isA( SpiPartitionDelta.class ), EasyMock.anyLong( ) ) ).andReturn( IndexingAction.ADDED ).once( );
        EasyMock.expect( deployedPartition2Phase1.getPri( ) ).andReturn( deployedPri2Phase1 ).anyTimes( );
        EasyMock.expect( this.indexManagementMock.removePartition( EasyMock.same( deployedPri2Phase1 ) ) ).andReturn( IndexingAction.DELETED ).once( );
        EasyMock.expect( this.indexManagementMock.indexPartition( EasyMock.same( deployedPri2Phase1 ), EasyMock.isA( SpiPartitionDelta.class ), EasyMock.anyLong( ) ) ).andReturn( IndexingAction.ADDED ).once( );
        EasyMock.expect( deployedPartition3Phase2.getPri( ) ).andReturn( deployedPri3Phase2 ).anyTimes( );
        EasyMock.expect( this.indexManagementMock.removePartition( EasyMock.same( deployedPri3Phase2 ) ) ).andReturn( IndexingAction.NOP ).once( );
        EasyMock.expect( this.indexManagementMock.indexPartition( EasyMock.same( deployedPri3Phase2 ), EasyMock.isA( SpiPartitionDelta.class ), EasyMock.anyLong( ) ) ).andReturn( IndexingAction.NOP ).once( );
        EasyMock.expect( deployedPartition4Phase2.getPri( ) ).andReturn( deployedPri4Phase2 ).anyTimes( );
        EasyMock.expect( this.indexManagementMock.removePartition( EasyMock.same( deployedPri4Phase2 ) ) ).andReturn( IndexingAction.DELETED ).once( );
        EasyMock.expect( this.indexManagementMock.indexPartition( EasyMock.same( deployedPri4Phase2 ), EasyMock.isA( SpiPartitionDelta.class ), EasyMock.anyLong( ) ) ).andReturn( IndexingAction.EXCEPTION ).once( );

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );
        EasyMock.replay( deployedPartition1Phase1, deployedPartition2Phase1, deployedPartition3Phase2, deployedPartition4Phase2 );
        EasyMock.replay( undeployedPri, deployedPri1Phase1, deployedPri2Phase1, deployedPri3Phase2, deployedPri4Phase2 );

        /////////////////////////////////////
        // perform test

//        List<PRI> returnedDefectivePartitions = this.mofRomInjectionService.injectMofRomPartitions( mofRomPartitionsPhase1 );
//
//        // assert: defective partition was returned correctly
//        assertEquals( "Defective partitions were not correctly returned to the caller.", Collections.emptyList( ), returnedDefectivePartitions );


        // assert: input stream for not deployed and undeployed partitions is not available
        // -> mofRom partitions are always loaded and not loadable here
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( undeployedPri );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri1Phase1 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri2Phase1 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri3Phase2 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri4Phase2 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

//        List<PRI> returnedDefectivePartitions2 = this.mofRomInjectionService.injectMofRomPartitions( mofRomPartitionsPhase2 );
//
//        // assert: defective partition was returned correctly
//        assertEquals( "Defective partitions were not correctly returned to the caller.", mofRomPrisPhase2, returnedDefectivePartitions2 );

        // assert: input stream for not deployed and undeployed partitions is not available
        // -> mofRom partitions are always loaded and not loadable here
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( undeployedPri );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri1Phase1 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri2Phase1 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri3Phase2 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }
        try {
            this.indexMetaModelmPartitionManager.getPartitionStream( deployedPri4Phase2 );
            fail( "Expected exception was not thrown: Stream provider of not deployed partition must not be available." );
        } catch ( RuntimeException e ) {
            // expected exception
        }

    }

    @Test
    @Ignore
    public void testInjectMofRomPartitionsEmptyArgument( ) {

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );

        /////////////////////////////////////
        // perform test

//        List<PRI> returnedDefectivePartitions = this.mofRomInjectionService.injectMofRomPartitions( (List<SpiModelPartition>) Collections.EMPTY_LIST );
//
//        // assert: check returned list
//        assertEquals( "Unexpected return value: should be an empty list.", Collections.emptyList( ), returnedDefectivePartitions );
    }

    @Test
    public void testInjectMofRomPartitionsIllegalArgument( ) {

        /////////////////////////////////////
        // set mocks to replay mode

        this.setMemberMocksToReplayMode( );

        /////////////////////////////////////
        // perform test

        try {
            this.mofRomInjectionService.injectMofRomPartitions( null );
            fail( "Passing null should lead to NullPointerException" );
        } catch ( NullPointerException npe ) {
            // expected exception
        }

    }

    /*
     * Some helpers
     */

    private MetaModelPartitionDeploymentRecord[] createDeploymentRecordArray( PRI pris[], long timestamps[], SpiPartitionStreamProvider streamProvider ) {

        SpiPartitionStreamProvider streamProviders[] = new SpiPartitionStreamProvider[pris.length];
        Arrays.fill( streamProviders, streamProvider );

        return this.createDeploymentRecordArray( pris, timestamps, streamProviders );
    }

    private MetaModelPartitionDeploymentRecord[] createDeploymentRecordArray( PRI pris[], long timestamps[], SpiPartitionStreamProvider streamProviders[] ) {

        MetaModelPartitionDeploymentRecord records[] = new MetaModelPartitionDeploymentRecord[pris.length];

        for ( int i = 0; i < pris.length; i++ ) {
            records[i] = new MetaModelPartitionDeploymentRecord( );
            records[i].pri = pris[i];
            records[i].timestamp = timestamps[i];
            records[i].streamProvider = streamProviders[i];
        }

        return records;
    }

    /**
     * Mock input stream. <br>
     * Needed because {@link java.io.InputStream} is an abstract class and not
     * an interface.
     */
    private class MyMockInputStream extends InputStream {

        @Override
        public int read( ) throws IOException {

            return 0;
        }
    }

}
