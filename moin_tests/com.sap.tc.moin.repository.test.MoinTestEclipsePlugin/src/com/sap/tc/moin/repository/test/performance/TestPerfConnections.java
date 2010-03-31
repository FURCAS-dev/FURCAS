package com.sap.tc.moin.repository.test.performance;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestClientFactory;
import com.sap.tc.moin.testcases.case001.A1;

public class TestPerfConnections extends TestPerfBase {

    private static final int NUM_RUNS = 5;

    private static final int NUM_SESSIONS = 100;

    private static final int NUM_ELEMENTS = 100;

    private static final int NUM_OF_PARTITIONS = 100;

    public TestPerfConnections( ) {

        super( );
    }

    @Test
    public void testManyPartitionsInMultipleSessions( ) throws Exception {

        String descriptiveId = "Loading partitions";
        String comment = "The test generates many partitions, saves it and lets ten different sessions load it. Afterwards the partitions are made dirty so that they are cloned for each sessions.";
        PerformanceMeter testPerfMeterLoad = createPerformanceMeter( descriptiveId, false, comment );

        String shortId = "Creating connections";
        String comment2 = "The test creates a larger number of connections.";
        PerformanceMeter testPerfMeterConnectionCreate = createPerformanceMeter( shortId, false, comment2 );

        TestClientFactory clientFactory = getTestHelper( ).getTestClientFactory( "PF" );
        TestClient testClient0 = clientFactory.getTestClient( 0, 0, true );
        Connection conn = testClient0.getConnection( ); // initializes the test client
        Connection[] connections = new Connection[NUM_SESSIONS];

        // creating connections can be run only once
        try {
            testPerfMeterConnectionCreate.start( );
            for ( int i = 0; i < NUM_SESSIONS; i++ ) {
                TestClient testClient = clientFactory.getTestClient( i + 1, i + 1, true );
                connections[i] = testClient.getConnection( ); // initializes the test client
            }
            testPerfMeterConnectionCreate.stop( );
            endPerformanceMeasurement( testPerfMeterConnectionCreate, true );
        } finally {
            testPerfMeterConnectionCreate.dispose( );
        }

        PRI[] partitions = new PRI[NUM_OF_PARTITIONS];

        for ( int j = 0; j < NUM_OF_PARTITIONS; j++ ) {

            ModelPartition partition = testClient0.getOrCreatePartition( "SamePartitionMultipleSessions_" + j );

            partitions[j] = partition.getPri( );
            for ( int i = 0; i < NUM_ELEMENTS; i++ ) {
                partition.createElement( MofClass.class );
            }
            testClient0.getConnection( ).save( );
        }

        // load
        try {
            for ( int i = 0; i < NUM_RUNS; i++ ) {
                testPerfMeterLoad.start( );
                for ( int j = 0; j < NUM_SESSIONS; j++ ) {
                    // Load the partition into every session.
                    for ( int k = 0; k < NUM_OF_PARTITIONS; k++ ) {
                        connections[j].getPartition( partitions[k] );
                    }
                }

                testPerfMeterLoad.stop( );
            }
            endPerformanceMeasurement( testPerfMeterLoad, true );
        } finally {
            testPerfMeterLoad.dispose( );
        }

        // delete
        for ( int j = 0; j < NUM_OF_PARTITIONS; j++ ) {

            ModelPartition partition = conn.getPartition( partitions[j] );
            partition.delete( );
        }

        conn.save( );
    }

    @Test
    public void testManyPartitionsDirty( ) throws Exception {


        String comment = "The test generates many partitions, saves it and lets ten different sessions load it. Afterwards the partitions are made dirty so that they are cloned for each sessions.";
        String descriptiveId = "Cloning partitions";
        PerformanceMeter testPerfMeterClone = createPerformanceMeter( descriptiveId, false, comment );

        TestClientFactory clientFactory = getTestHelper( ).getTestClientFactory( "PF" );
        TestClient testClient0 = clientFactory.getTestClient( 0, 0, true );
        Connection conn = testClient0.getConnection( ); // initializes the test client        

        PRI[] partitions = new PRI[NUM_OF_PARTITIONS];

        for ( int j = 0; j < NUM_OF_PARTITIONS; j++ ) {

            ModelPartition partition = testClient0.getOrCreatePartition( "SamePartitionMultipleSessions_" + j );

            partitions[j] = partition.getPri( );
            for ( int i = 0; i < NUM_ELEMENTS; i++ ) {
                partition.createElement( MofClass.class );
            }
            testClient0.getConnection( ).save( );
        }

        // load
        for ( int i = 0; i < NUM_RUNS; i++ ) {

            // Load the partition into every session.
            for ( int k = 0; k < NUM_OF_PARTITIONS; k++ ) {
                conn.getPartition( partitions[k] );
            }


        }

        // modify
        try {
            for ( int i = 0; i < NUM_RUNS; i++ ) {
                testPerfMeterClone.start( );

                // add element to trigger clone 
                for ( int k = 0; k < NUM_OF_PARTITIONS; k++ ) {
                    ModelPartition partition = conn.getPartition( partitions[k] );
                    partition.createElement( A1.class );
                }

                testPerfMeterClone.stop( );
            }
            endPerformanceMeasurement( testPerfMeterClone, true );
        } finally {
            testPerfMeterClone.dispose( );
        }

        // delete
        for ( int j = 0; j < NUM_OF_PARTITIONS; j++ ) {

            ModelPartition partition = conn.getPartition( partitions[j] );
            partition.delete( );
        }
        conn.save( );
    }
}