package com.sap.tc.moin.repository.test.performance;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.After;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestClientFactory;
import com.sap.tc.moin.test.fw.NwdiTestClientImpl.VendorNamePair;
import com.sap.tc.moin.test.fw.ide.DcModificationUtil;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;

public class TestPerfPartitionHandling extends TestPerfBase {

    private static final int NUM_RUNS = 100;

    private static final int NUM_SESSIONS = 100;

    private static final int NUM_ELEMENTS = 10000;

    private static final int NUM_OF_PARTITIONS = 50;

    public static final VendorNamePair TEST_DC = new VendorNamePair( "test.sap.com", "tc/moin/repository/paritiontest" );
    
    IdeRuntimeTestHelper helper;

    public TestPerfPartitionHandling( ) {

        super( );
    }
    
    @After
    public void cleanupDc(){
        try {
            helper = (IdeRuntimeTestHelper) getTestHelper( );
            DcModificationUtil dcUtil = helper.getDcModificationUtil( );
            dcUtil.deleteLocalMoinDCProject( "test.sap.com", "tc/moin/repository/paritiontest" );
        } catch ( Exception e ) {
              System.out.println("Deletion of Test DC failed!");
              System.out.println(e.toString( ));
        }
        }
        
    @Test
    public void testPartitionDeletion( ) throws Exception {


        String comment = "The test deletes " + NUM_OF_PARTITIONS + " partitions.";
        String descriptiveId = "Partition Deletion";
        PerformanceMeter testPerfMeterClone = createPerformanceMeter( descriptiveId, false, comment );

        TestClientFactory clientFactory = getTestHelper( ).getTestClientFactory( "PF" );
        TestClient testClient0 = clientFactory.getTestClient( 0, 0, true );
        Connection conn = testClient0.getConnection( ); // initializes the test client
        helper = (IdeRuntimeTestHelper) getTestHelper( );

        helper.getOrCreateLocalMoinDCProject( "test.sap.com", "tc/moin/repository/paritiontest" );

        PRI[] partitions = new PRI[NUM_OF_PARTITIONS];
        ModelPartition[] modelPartitions = new ModelPartition[NUM_OF_PARTITIONS];

        String partitionNameFragment = "parition";

        ResourceIdentifierFactory mriFactory = getTestHelper( ).getFacility( "PF" ).getRIFactory( );
        String partitionPath = "src/moin_unit_test" + "/" + partitionNameFragment;

        PRI pri; // = mriFactory.createPri( testClient0.getClientSpec().getDataArea().getName( ), TEST_DC.toString( ), partitionPath );


        String uniquePartitionPath;
        int partitionIndex = 0;

        for ( int i = 0; i < NUM_RUNS; i++ ) {

            
            for ( int j = 0; j < NUM_OF_PARTITIONS; j++ ) {
                uniquePartitionPath = partitionPath + partitionIndex + MoinTestHelper.TEST_PARTITION_SUFFIX;
                
                partitions[j] = mriFactory.createPri( testClient0.getClientSpec( ).getDataArea( ).getName( ), TEST_DC.toString( ), uniquePartitionPath );
                modelPartitions[j] = conn.createPartition( partitions[j] );
                uniquePartitionPath = partitionPath;
                partitionIndex++;
            }
            conn.save( );
            testPerfMeterClone.start( );
            for ( int j = 0; j < NUM_OF_PARTITIONS; j++ ) {
                modelPartitions[j].delete( );
                //partitions[j] = null;
            }
            testPerfMeterClone.stop( );
            conn.save( );
        }
 
        conn.save( );
        
        
        endPerformanceMeasurement( testPerfMeterClone, true );
        testPerfMeterClone.dispose( );


    }
    
    
    @Test
    public void testPartitionCreation( ) throws Exception {


        String comment = "The test creates " + NUM_OF_PARTITIONS + " partitions.";
        String descriptiveId = "Partition Creation";
        PerformanceMeter testPerfMeterClone = createPerformanceMeter( descriptiveId, false, comment );

        TestClientFactory clientFactory = getTestHelper( ).getTestClientFactory( "PF" );
        TestClient testClient0 = clientFactory.getTestClient( 0, 0, true );
        Connection conn = testClient0.getConnection( ); // initializes the test client
        IdeRuntimeTestHelper helper = (IdeRuntimeTestHelper) getTestHelper( );

        helper.getOrCreateLocalMoinDCProject( "test.sap.com", "tc/moin/repository/paritiontest" );

        PRI[] partitions = new PRI[NUM_OF_PARTITIONS];
        ModelPartition[] modelPartitions = new ModelPartition[NUM_OF_PARTITIONS];

        String partitionNameFragment = "parition";

        ResourceIdentifierFactory mriFactory = getTestHelper( ).getFacility( "PF" ).getRIFactory( );
        String partitionPath = "src/moin_unit_test" + "/" + partitionNameFragment;

        PRI pri; // = mriFactory.createPri( testClient0.getClientSpec().getDataArea().getName( ), TEST_DC.toString( ), partitionPath );


        String uniquePartitionPath;
        int partitionIndex = 0;
        // Warm - UP
        uniquePartitionPath = partitionPath + partitionIndex + MoinTestHelper.TEST_PARTITION_SUFFIX;
        partitions[0] = mriFactory.createPri( testClient0.getClientSpec( ).getDataArea( ).getName( ), TEST_DC.toString( ), uniquePartitionPath );
        modelPartitions[0] = conn.createPartition( partitions[0] );
        uniquePartitionPath = partitionPath;
        partitionIndex++;

        for ( int i = 0; i < NUM_RUNS; i++ ) {

            testPerfMeterClone.start( );
            for ( int j = 0; j < NUM_OF_PARTITIONS; j++ ) {
                uniquePartitionPath = partitionPath + partitionIndex + MoinTestHelper.TEST_PARTITION_SUFFIX;
                
                partitions[j] = mriFactory.createPri( testClient0.getClientSpec( ).getDataArea( ).getName( ), TEST_DC.toString( ), uniquePartitionPath );
                modelPartitions[j] = conn.createPartition( partitions[j] );
                uniquePartitionPath = partitionPath;
                partitionIndex++;
            }
            testPerfMeterClone.stop( );
            for ( int j = 0; j < NUM_OF_PARTITIONS; j++ ) {
                modelPartitions[j].delete( );
                //partitions[j] = null;
            }
        }


        conn.save( );
        
        endPerformanceMeasurement( testPerfMeterClone, true );
        testPerfMeterClone.dispose( );


    }
}