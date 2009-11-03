package com.sap.tc.moin.repository.test.performance;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.GeneratedmetamodelPackage;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass0;
import com.sap.tc.moin.test.fw.TestClient;

public class TestPerfMoinScenario extends TestPerfBase {

    public TestPerfMoinScenario( ) {

        super( );
    }


    @Test
    public void testBasicUsageScenario( ) throws Exception {

        String descriptiveId = "Basic Usage Scenario";
        String comment = "The test generates 10 partitions with 100 elements followed by a save(sample size is 10).";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        TestClient _testClient1 = getTestHelper( ).getDefaultTestClient( true );

        Connection conn = _testClient1.getConnection( );
        RefPackage refPackage = conn.getPackage( GeneratedmetamodelPackage.PACKAGE_DESCRIPTOR );
        if ( refPackage == null ) {
            throw new RuntimeException( "GeneratedMetamodel not found!" );
        }
        GeneratedmetamodelPackage gPackage = (GeneratedmetamodelPackage) refPackage;

        RefClass tClass0Class = gPackage.getTestClass0( );
        Collection<ModelPartition> partitionCollection = new ArrayList<ModelPartition>( );

        try {
            for ( int i = 0; i < 10; i++ ) {
                testPerfMeter.start( );
                for ( int s = 0; s < 10; s++ ) {
                    ModelPartition p = _testClient1.getOrCreatePartition( "BasicUsagePartition" + s );
                    partitionCollection.add( p );
                    for ( int t = 0; t < 100; t++ ) {
                        TestClass0 tClass0 = (TestClass0) tClass0Class.refCreateInstance( );
                        p.assignElement( tClass0 );
                    }
                }
                conn.save( );
                testPerfMeter.stop( );
                for ( ModelPartition modelPartition : partitionCollection ) {
                    modelPartition.delete( );
                }
                partitionCollection.clear( );
                conn.save( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            //check if not null
            if ( !partitionCollection.isEmpty( ) ) {
                for ( ModelPartition modelPartition : partitionCollection ) {
                    modelPartition.delete( );
                }
            }
            conn.save( );
        }

    }

}
