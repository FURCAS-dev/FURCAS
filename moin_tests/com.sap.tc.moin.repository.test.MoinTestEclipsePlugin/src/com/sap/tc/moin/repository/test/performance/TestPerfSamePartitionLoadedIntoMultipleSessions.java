package com.sap.tc.moin.repository.test.performance;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.Test;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestClientFactory;

public class TestPerfSamePartitionLoadedIntoMultipleSessions extends TestPerfBase {

    private static final int NUM_RUNS = 5;

    private static final int NUM_SESSIONS = 10;

    private static final int NUM_ELEMENTS = 5000;

    public TestPerfSamePartitionLoadedIntoMultipleSessions( ) {

        super( );
    }

    @Test
    public void testSamePartitionLoadedIntoMultipleSessions( ) throws Exception {

        String descriptiveId = "Memory usage of loaded partitions";
        String comment = "The test generates a partition with 5000 elements, saves it and lets ten different sessions load it. Focus of this test is on the peak memory usage.";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        TestClientFactory clientFactory = getTestHelper( ).getTestClientFactory( "PF" );
        TestClient testClient0 = clientFactory.getTestClient( 0, 0, true );
        testClient0.getConnection( ); // initializes the test client
        TestClient[] testClients = new TestClient[NUM_SESSIONS];
        for ( int i = 0; i < NUM_SESSIONS; i++ ) {
            testClients[i] = clientFactory.getTestClient( i + 1, i + 1, true );
            testClients[i].getConnection( ); // initializes the test client
        }

        ModelPartition partition = testClient0.getOrCreatePartition( "SamePartitionMultipleSessions" );
        PRI pri = partition.getPri( );
        for ( int i = 0; i < NUM_ELEMENTS; i++ ) {
            partition.createElement( MofClass.class );
        }
        testClient0.getConnection( ).save( );

        try {
            for ( int i = 0; i < NUM_RUNS; i++ ) {
                testPerfMeter.start( );
                for ( int j = 0; j < NUM_SESSIONS; j++ ) {
                    // Load the partition into every session.
                    TestClient testClient = testClients[j];
                    testClient.getConnection( ).getPartition( pri );
                }
                partition.createElement( MofClass.class );
                testClient0.getConnection( ).save( );
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            partition.delete( );
            testClient0.getConnection( ).save( );
        }
    }
}