package com.sap.tc.moin.repository.test.performance;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc0x1;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.GeneratedmetamodelPackage;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass0;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass1;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestConfigurationImpl;
import com.sap.tc.moin.test.testcase.MoinTestCase;


public class TestPerfMoinExtensions extends TestPerfBase {

    private GeneratedmetamodelPackage gmp;

    public TestPerfMoinExtensions( ) {

        super( );
    }

    @BeforeClass
    public static void beforePerformanceTest( ) throws Exception {

        // creates the model data based on the synthetic metamodel
        setUp( );
    }

    @AfterClass
    public static void afterPerformanceTest( ) throws Exception {

        tearDown( );
    }

    @Test
    @Ignore
    public void testMOIN( ) {

        String id = MOIN_TEST_ID_PREFIX + "_testMOIN";
        String summary = "TestMOIN";
        String comment = "The average performance over basic MOIN instantiation";

        PerformanceMeter testPerfMeter = createPerformanceMeter( id, summary, false, comment );

        /** ************** MOIN start *********************** */
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINInstance( );
            testPerfMeter.stop( );
        }

        /** ************** MOIN With Reset *********************** */
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINInstanceWithReset( );
            testPerfMeter.stop( );
        }

        endPerformanceMeasurement( testPerfMeter, true );
        testPerfMeter.dispose( );
    }

    private void testMOINInstance( ) {

        for ( int i = 0; i < 10; i++ ) {
            Moin moin = getNewMoin( );
        }

    }

    private void testMOINInstanceWithReset( ) {

        for ( int i = 0; i < 10; i++ ) {
            Moin moin = getNewMoin( );
            getTestHelper( ).reset( );
        }
    }

    @Test
    @Ignore
    public void testMOINSession( ) {

        int elementCount = 10;
        String descriptiveId = "SessionCreation";
        String comment = "Creation of " + elementCount + " sessions";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Moin moin = MoinTestCase.getTestHelper( ).getMoin( );
        SpiCompoundDataAreaManager cdam = (SpiCompoundDataAreaManager) moin.getCompoundDataAreaManager( );
        CompoundClientSpec compoundClientSpec = cdam.getDefaultCompoundClientSpec( getTestHelper( ).getDefaultTestClient( false ).getClientSpec( ) );

        // Warmup
        moin.createSession( compoundClientSpec );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < elementCount; j++ ) {
                    moin.createSession( compoundClientSpec );
                }
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    @Ignore
    public void testMOINConnection( ) throws Exception {


        /** ********** Connection Creation ********** */
        int elementCount = 10;
        String descriptiveId = "ConnectionCreation";
        String comment = "Creation of " + elementCount + " connections";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Moin moin = MoinTestCase.getTestHelper( ).getMoin( );
        SpiCompoundDataAreaManager cdam = (SpiCompoundDataAreaManager) moin.getCompoundDataAreaManager( );
        CompoundClientSpec compoundClientSpec = cdam.getDefaultCompoundClientSpec( getTestHelper( ).getDefaultTestClient( false ).getClientSpec( ) );
        Session session = moin.createSession( compoundClientSpec );

        // Warmup
        Connection connection = session.createConnection( );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < elementCount; j++ ) {
                    session.createConnection( );
                }
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }


        /** ********** Connection Creation and Close ********** */
        elementCount = 10;
        descriptiveId = "ConnectionCreationAndClose";
        comment = "Creation and Close of " + elementCount + " connections";
        testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        session = moin.createSession( compoundClientSpec );

        // Warmup
        connection = session.createConnection( );
        connection.close( );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < elementCount; j++ ) {
                    connection = session.createConnection( );
                    connection.close( );
                }
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }


        /** ********** Connection Save /wo Dirty Partitions ********** */
        elementCount = 10;
        descriptiveId = "ConnectionSave /wo Dirty Partitions";
        comment = "Saving " + elementCount + " connections without dirty partitions";
        testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        session = moin.createSession( compoundClientSpec );

        // Warmup
        connection = session.createConnection( );
        connection.save( );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < elementCount; j++ ) {
                    connection = session.createConnection( );
                    connection.save( );
                }
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }


        /** ************** Connection Save2 *********************** */
        gmp = (GeneratedmetamodelPackage) ( (RefPackage) getTestHelper( ).getDefaultTestClient( false ).getConnection( ).getPackage( null, new String[] { "generatedmetamodel" } ) );
        if ( gmp == null ) {
            throw new RuntimeException( "GeneratedMetamodel package is null" );
        }

        Connection connection2 = getTestHelper( ).getDefaultTestClient( false ).getConnection( );
        RefClass testClass0Proxy = gmp.getTestClass0( );

        for ( int i = 0; i < 100; i++ ) {
            ModelPartition partition = getTestHelper( ).getDefaultTestClient( false ).getOrCreatePartition( "partition_" + i );
        }

        for ( int i = 0; i < 10; i++ ) {
            for ( int j = 0; j < 10; j++ ) {
                ModelPartition partition = getTestHelper( ).getDefaultTestClient( false ).getOrCreatePartition( "partition_" + j );
                for ( int k = 0; k < 100; k++ ) {
                    TestClass0 testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
                    partition.assignElement( testClass0 );
                }
            }
        }

        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINConnectionSave2( connection2 );
            testPerfMeter.stop( );
        }

        /** ************** Connection Save3 *********************** */
        Connection connection3 = getTestHelper( ).getDefaultTestClient( false ).getConnection( );
        for ( int i = 0; i < 10; i++ ) {
            for ( int j = 0; j < 100; j++ ) {
                ModelPartition partition = getTestHelper( ).getDefaultTestClient( false ).getOrCreatePartition( "partition_" + j );
                for ( int k = 0; k < 100; k++ ) {
                    TestClass0 testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
                    partition.assignElement( testClass0 );
                }
            }
        }
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINConnectionSave3( connection3 );
            testPerfMeter.stop( );
        }

        endPerformanceMeasurement( testPerfMeter, true );
        testPerfMeter.dispose( );

    }



    private void testMOINConnectionSave2( Connection connection ) {

        try {
            connection.save( );
        } catch ( NullPartitionNotEmptyException e ) {
            e.printStackTrace( );
        } catch ( ReferencedTransientElementsException e ) {
            e.printStackTrace( );
        } catch ( PartitionsNotSavedException e ) {
            e.printStackTrace( );
        }
    }

    private void testMOINConnectionSave3( Connection connection ) {

        try {
            connection.save( );
        } catch ( NullPartitionNotEmptyException e ) {
            e.printStackTrace( );
        } catch ( ReferencedTransientElementsException e ) {
            e.printStackTrace( );
        } catch ( PartitionsNotSavedException e ) {
            e.printStackTrace( );
        }
    }



    @Test
    @Ignore
    public void testMOINPartitions( ) {

        String id = MOIN_TEST_ID_PREFIX + "_testMOINPartitions";
        String summary = "TestMOINPartitions";
        String comment = "The average performance over basic MOIN partition handling";
        PerformanceMeter testPerfMeter = createPerformanceMeter( id, summary, false, comment );

        /** ************** Partitions Create*********************** */
        TestClient testClient = getTestHelper( ).getDefaultTestClient( false );
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionsCreate( testClient );
            testPerfMeter.stop( );
        }

        /** ************** Partitions Delete1 *********************** */
        ModelPartition partition = testClient.getOrCreatePartition( "partition" );
        partition.deleteElements( );
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionsDelete1( partition );
            testPerfMeter.stop( );
        }

        /** ************** Partitions Delete2 *********************** */
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionsDelete2( partition );
            testPerfMeter.stop( );
        }

        /** ************** Partitions Delete3 *********************** */
        gmp = (GeneratedmetamodelPackage) ( (RefPackage) getTestHelper( ).getDefaultTestClient( false ).getConnection( ).getPackage( null, new String[] { "generatedmetamodel" } ) );
        if ( gmp == null ) {
            throw new RuntimeException( "GeneratedMetamodel package is null" );
        }
        RefClass testClass0Proxy = gmp.getTestClass0( );
        for ( int i = 0; i < 100; i++ ) {
            partition.deleteElements( );
            for ( int j = 0; j < 100; j++ ) {
                TestClass0 testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
                partition.assignElement( testClass0 );
            }
        }
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionsDelete3( partition );
            testPerfMeter.stop( );
        }

        /** ************** Partitions Load *********************** */
        Collection pris = new Vector( );
        Connection connection4 = getTestHelper( ).getDefaultTestClient( false ).getConnection( );
        for ( int i = 0; i < 10; i++ ) {
            partition = getTestHelper( ).getDefaultTestClient( false ).getOrCreatePartition( "partition_" + i );
            pris.add( partition.getPri( ) );
            partition.deleteElements( );
            for ( int j = 0; j < 100; j++ ) {
                TestClass0 testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
                partition.assignElement( testClass0 );
            }
        }
        try {
            connection4.save( );
        } catch ( NullPartitionNotEmptyException e ) {
            e.printStackTrace( );
        } catch ( ReferencedTransientElementsException e ) {
            e.printStackTrace( );
        } catch ( PartitionsNotSavedException e ) {
            e.printStackTrace( );
        }


        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionsLoad( connection4, pris );
            testPerfMeter.stop( );
        }

        /** ************** Partitions Assignment1 *********************** */
        TestClass0 testClass0 = null;
        partition.deleteElements( );
        for ( int i = 0; i < 100; i++ ) {
            testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
        }
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionAssignment1( partition, testClass0 );
            testPerfMeter.stop( );
        }

        /** ************** Partitions Assignment2 *********************** */
        partition.deleteElements( );
        testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
        for ( int i = 0; i < 100; i++ ) {
            // TODO set down to 10 iterations due to upper multiplicity of attribute
            for ( int j = 0; j < 10; j++ ) {
                testClass0.getAttrStringMultiValued0( ).add( new String( "String" + j ) );
            }
        }
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionAssignment2( partition, testClass0 );
            testPerfMeter.stop( );
        }

        /** ************** Partitions Reassign1 *********************** */
        ;
        ModelPartition partition1 = getTestHelper( ).getDefaultTestClient( false ).getOrCreatePartition( "partition_1" );
        for ( int i = 0; i < 100; i++ ) {
            testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
            partition1.assignElement( testClass0 );
        }

        ModelPartition partition2 = getTestHelper( ).getDefaultTestClient( false ).getOrCreatePartition( "partition_2" );
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionReassign1( partition1, partition2 );
            testPerfMeter.stop( );
        }

        /** ************** Partitions Reassign2 *********************** */
        partition1.deleteElements( );
        for ( int i = 0; i < 100; i++ ) {
            testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
            for ( int j = 0; j < 10; j++ ) {
                testClass0.getAttrStringMultiValued0( ).add( new String( "String" + j ) );
            }
            partition1.assignElement( testClass0 );
        }

        partition2.deleteElements( );
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINPartitionReassign2( partition1, partition2 );
            testPerfMeter.stop( );
        }

        endPerformanceMeasurement( testPerfMeter, true );
        testPerfMeter.dispose( );
    }

    private void testMOINPartitionsCreate( TestClient testClient ) {

        for ( int i = 0; i < 10; i++ ) {
            ModelPartition partition = testClient.createPartition( "partition_mofextensions_" + i );
            partition.delete( );
        }

    }

    private void testMOINPartitionsDelete1( ModelPartition partition ) {

        for ( int i = 0; i < 10; i++ ) {
            partition.delete( );
        }

    }

    private void testMOINPartitionsDelete2( ModelPartition partition ) {

        for ( int i = 0; i < 100; i++ ) {
            partition.delete( );
        }

    }

    private void testMOINPartitionsDelete3( ModelPartition partition ) {

        for ( int i = 0; i < 100; i++ ) {
            partition.delete( );
        }
    }

    private void testMOINPartitionsLoad( Connection connection, Collection pris ) {

        Iterator iter = pris.iterator( );

        while ( iter.hasNext( ) ) {
            PRI pri = (PRI) iter.next( );
            ModelPartition partition = connection.getPartition( pri );
        }

    }

    private void testMOINPartitionAssignment1( ModelPartition partition, TestClass0 testClass0 ) {

        for ( int i = 0; i < 100; i++ ) {
            partition.assignElement( testClass0 );
        }

    }

    private void testMOINPartitionAssignment2( ModelPartition partition, TestClass0 testClass0 ) {

        for ( int i = 0; i < 100; i++ ) {
            partition.assignElementIncludingChildren( testClass0 );
        }

    }

    private void testMOINPartitionReassign1( ModelPartition partition1, ModelPartition partition2 ) {

        Collection elements = partition1.getElements( );
        Iterator iter = elements.iterator( );
        while ( iter.hasNext( ) ) {
            Partitionable partitionable = (Partitionable) iter.next( );
            partitionable.assign___Partition( partition2 );
        }

    }

    private void testMOINPartitionReassign2( ModelPartition partition1, ModelPartition partition2 ) {

        Collection elements = partition1.getElements( );
        Iterator iter = elements.iterator( );

        while ( iter.hasNext( ) ) {
            Partitionable partitionable = (Partitionable) iter.next( );
            partitionable.assign___Partition( partition2 );
        }

    }

    @Test
    @Ignore
    public void testMOINQueryMQL( ) throws Exception {

        String descriptiveId = "Query MQL";
        String comment = "MQL based queries reusing testsuite TestPerfQuery";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        try {

            Class clazz = Class.forName( "com.sap.tc.moin.repository.test.performance.TestPerfQuery" );
            testPerfMeter.start( );
            Result result = org.junit.runner.JUnitCore.runClasses( new Class<?>[] { clazz } );
            testPerfMeter.stop( );
            List<Failure> failures = result.getFailures( );
            Iterator iter = failures.iterator( );
            while ( iter.hasNext( ) ) {
                Failure failure = (Failure) iter.next( );
                System.out.println( failure.toString( ) );
            }
            if ( !result.wasSuccessful( ) ) {
                fail( );
            }

            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    @Ignore
    public void testMOINQueryHC( ) {

        String id = MOIN_TEST_ID_PREFIX + "_testMOINQueryHC";
        String summary = "TestMOINQueryHC";
        String comment = "The average performance over MOIN hard-coded queries";
        PerformanceMeter testPerfMeter = createPerformanceMeter( id, summary, false, comment );

        /** ************** QueryHC getPackage *********************** */
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINQuery_getPackage( );
            testPerfMeter.stop( );
        }

        /** ************** QueryHC isPartitionStored *********************** */
//      in query is only defined isPartitionExistent()
        ModelPartition partition = getTestHelper( ).getDefaultTestClient( false ).getOrCreatePartition( "partition" );
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINQuery_isPartitionStored( partition );
            testPerfMeter.stop( );
        }

        gmp = (GeneratedmetamodelPackage) ( (RefPackage) getTestHelper( ).getDefaultTestClient( false ).getConnection( ).getPackage( null, new String[] { "generatedmetamodel" } ) );
        if ( gmp == null ) {
            throw new RuntimeException( "GeneratedMetamodel package is null" );
        }
        RefClass testClass0Proxy = gmp.getTestClass0( );
        TestClass0 testClass0 = (TestClass0) testClass0Proxy.refCreateInstance( );
        SpiFacility fac = (SpiFacility) getTestHelper( ).getDefaultFacility( );
        MRI mri = ( (Partitionable) testClass0 ).get___Mri( );
        SpiCoreQueryService query = fac.getCoreQueryService( );
        ClientSpec clientSpec = getTestHelper( ).getDefaultTestClient( false ).getClientSpec( );

        /** ************ QueryHC getElementsForEndAndMetaobject* ************** */
        Assoc0x1 assoc = gmp.getAssoc0x1( );
        RefClass testClass1Proxy = gmp.getTestClass1( );
        TestClass1 testClass1 = (TestClass1) testClass1Proxy.refCreateInstance( );
        MRI mriAssoc = ( (Partitionable) assoc ).get___Mri( );
        assoc.add( testClass0, testClass1 );
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINQuery_getElementsForEndAndMetaobject( query, clientSpec, mriAssoc, mri );
            testPerfMeter.stop( );
        }

        /** ************** QueryHC getReferrers *********************** */
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINQuery_getReferrers( query, clientSpec, mri );
            testPerfMeter.stop( );
        }

        /** ************** QueryHC queryPartitions *********************** */
        for ( int i = 0; i < 100; i++ ) {
            testPerfMeter.start( );
            testMOINQuery_queryPartitions( query, clientSpec );
            testPerfMeter.stop( );
        }

        endPerformanceMeasurement( testPerfMeter, true );
        testPerfMeter.dispose( );

    }

    private void testMOINQuery_getPackage( ) {

        for ( int i = 0; i < 10; i++ ) {
            GeneratedmetamodelPackage gmp = (GeneratedmetamodelPackage) getTestHelper( ).getDefaultTestClient( false ).getConnection( ).getPackage( null, new String[] { "generatedmetamodel" } );
        }

    }

    private void testMOINQuery_isPartitionStored( ModelPartition partition ) {

        for ( int i = 0; i < 100; i++ ) {
            boolean dirty = partition.isDirty( );
        }

    }

    private void testMOINQuery_getElementsForEndAndMetaobject( SpiCoreQueryService query, ClientSpec clientSpec, MRI mriAssoc, MRI mri ) {

        // TODO was genau soll das machen?
        Collection instances = query.getReferringElementsForEndAndMetaobject( new ClientSpec[] { clientSpec }, mriAssoc, mri, 0 );

    }

    private void testMOINQuery_getReferrers( SpiCoreQueryService query, ClientSpec clientSpec, MRI mri ) {

        for ( int i = 0; i < 100; i++ ) {
            Collection instances = query.getReferringPartitions( new ClientSpec[] { clientSpec }, mri );
        }


    }

    private void testMOINQuery_queryPartitions( SpiCoreQueryService query, ClientSpec clientSpec ) {

        CRI cri = this.getTestHelper( ).getMoin( ).createCri( PrimaryFacility.FACILITY_ID, "defaultDataArea", "test.sap.com\\tc\\moin\\repository\\test\\_comp" );

        //TODO empty list
        for ( int i = 0; i < 100; i++ ) {
            Collection instances = query.getPartitionsInContainer( clientSpec, cri );
        }

    }

    @Test
    @Ignore
    public void testMOINEvents( ) {

        String id = MOIN_TEST_ID_PREFIX + "_testMOINEvents";
        String summary = "TestMOINEvents";
        String comment = "The average performance over MOIN events handling";
        PerformanceMeter testPerfMeter = createPerformanceMeter( id, summary, false, comment );

        try {

            try {
                // TODO richtiger Test?
                Class clazz = Class.forName( "com.sap.tc.moin.repository.test.performance.TestEventFrameworkPerformance" );
                testPerfMeter.start( );
                Result result = org.junit.runner.JUnitCore.runClasses( new Class<?>[] { clazz } );
                testPerfMeter.stop( );
                List<Failure> failures = result.getFailures( );
                Iterator iter = failures.iterator( );
                while ( iter.hasNext( ) ) {
                    Failure failure = (Failure) iter.next( );
                    System.out.println( failure.toString( ) );
                }
                if ( !result.wasSuccessful( ) ) {
                    fail( );
                }
            } catch ( ClassNotFoundException e ) {
                e.printStackTrace( );
                fail( "Test class not found" );
            }

            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    public void testMOINCommands( ) throws Exception {

        String descriptiveId = "Commands Basic";
        String comment = "Covers basic command flow (executeSubCommand, canExecute, getAffectedPartitions, doExecute)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );


        try {

            // setup
            TestClient testClient = getTestHelper( ).getDefaultTestClient( true );
            testClient.setAsCurrentClient( );
            PerformanceTestCommandBasicFlow basicFlowCommand = new PerformanceTestCommandBasicFlow( testClient.getConnection( ) );

            // warmup
            for ( int j = 0; j < 10000; j++ ) {
                basicFlowCommand.execute( );
            }

            // measure
            testPerfMeter.start( );
            for ( int j = 0; j < 10000; j++ ) {
                basicFlowCommand.execute( );
            }
            testPerfMeter.stop( );

            // cleanup
            testClient.clear( );

            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    class PerformanceTestCommandBasicFlow extends Command {


        protected PerformanceTestCommandBasicFlow( Connection connection ) {

            super( connection );
        }

        @Override
        public boolean canExecute( ) {

            return true;
        }

        @Override
        public void doExecute( ) {

            this.executeSubCommand( new PerformanceTestCommandNoOp( this.getConnection( ) ) );

        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            ArrayList<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>( 1 );
            return affectedPartitions;
        }

        class PerformanceTestCommandNoOp extends PerformanceTestCommandBasicFlow {

            protected PerformanceTestCommandNoOp( Connection connection ) {

                super( connection );
            }

            @Override
            public void doExecute( ) {

            }
        }
    }

    private Moin getNewMoin( ) {

        return setMoin( "getMoinInstance" );
    }

    private Moin setMoin( String methodName ) {

        TestConfigurationImpl conf = new TestConfigurationImpl( "eclipseRuntimeTestConfiguration.properties" );
        String moinFactoryImpl = conf.getProperty( "moin.factory.class" );

        Class moinFactoryClass = null;
        try {
            moinFactoryClass = Class.forName( moinFactoryImpl );
        } catch ( ClassNotFoundException e ) {
            throw new RuntimeException( e );
        }
        Moin mn = null;
        try {
            Method moinInstanceMethod = moinFactoryClass.getMethod( methodName, new Class[0] );
            mn = (Moin) moinInstanceMethod.invoke( moinFactoryClass.getClass( ), new Object[0] );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
        return mn;
    }

    private Connection getNewConn( ) {

        Connection conn = createConn( );
        conn.setLabel( new Date( System.currentTimeMillis( ) ).toString( ) );
        return conn;
    }

    private Connection createConn( ) {

        try {
            Moin moin = MoinTestCase.getTestHelper( ).getMoin( );
            SpiCompoundDataAreaManager cdam = (SpiCompoundDataAreaManager) moin.getCompoundDataAreaManager( );

            CompoundClientSpec compoundClientSpec = cdam.getDefaultCompoundClientSpec( getTestHelper( ).getDefaultTestClient( false ).getClientSpec( ) );

            return moin.createSession( compoundClientSpec ).createConnection( );
        } catch ( Exception e ) {
            // wrap with RuntimeException (test cases shouldn't bother with exceptions)
            throw new IllegalStateException( "Failed to create a connection for test client " + this, e );
        }
    }

}
