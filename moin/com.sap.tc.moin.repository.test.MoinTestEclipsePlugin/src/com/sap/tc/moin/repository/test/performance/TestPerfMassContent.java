package com.sap.tc.moin.repository.test.performance;

import java.util.LinkedList;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.sap.tc.moin.repository.test.query.BaseSyntheticQueryTests;
import com.sap.tc.moin.test.fw.ModelDataInstantiator;

public class TestPerfMassContent extends BaseSyntheticQueryTests {

    private static String TEST_NAME = "MOINPerformanceTests";

    private TestPerfBase performanceBase;

    private final static int numberOfRuns = 10;

    private int runNr;

    public TestPerfMassContent( int runNr ) {

        this.runNr = runNr;

        //initialize performance measurement and performance meter
        performanceBase = new TestPerfBase( );
    }

    @Parameters
    public static LinkedList<Object> queryTestData( ) {

        LinkedList<Object> params = new LinkedList<Object>( );

        for ( int r = 1; r <= numberOfRuns; r++ ) {
            params.add( new Integer[] { r } );
        }

        return params;
    }

    @BeforeClass
    static public void beforeQueryTests( ) throws Exception {

        mmSize = 20;
        attrSize = 10;
        instSize = 100;
        partSize = 100;

        partitionScope = null;
        partitionScopeInclusive = true;

        createDirtyData = false;
        createObjValAttrs = true;

        mdi = new ModelDataInstantiator( getTestHelper( ).getDefaultTestClient( true ), true, mmSize, attrSize, instSize, partSize, createObjValAttrs );
        mdi.removeData( );
    }

    @AfterClass
    public static void afterQueryTests( ) throws Exception {

        time_delete_partitions( );
        BaseSyntheticQueryTests.afterQueryTests( false );
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        partitionNameAppendix = "_run" + runNr;
        super.beforeTestMethod( );
    }

    @Test
    public void test_save_partitions( ) throws Exception {

        BaseSyntheticQueryTests.beforeQueryTests( false );

        String id = TEST_NAME + "_savePartitons" + this.runNr;
        String summary = "Test Save Partitions";
        String comment = "The average performance over partition saving";
        PerformanceMeter testPerfMeter = this.performanceBase.createPerformanceMeter( id, summary, false, comment );

        try {
            testPerfMeter.start( );
            mdi.saveData( );
            testPerfMeter.stop( );

            this.performanceBase.endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    public void test_load_partitions( ) throws Exception {

        String id = TEST_NAME + "_loadPartitons" + this.runNr;
        String summary = "Test Load Partitions";
        String comment = "The average performance over partition loading";
        PerformanceMeter testPerfMeter = this.performanceBase.createPerformanceMeter( id, summary, false, comment );

        try {
            testPerfMeter.start( );
            loadPartitions( );
            testPerfMeter.stop( );

            this.performanceBase.endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    public static void time_delete_partitions( ) throws Exception {

        TestPerfBase perfBase = new TestPerfBase( );

        String id = TEST_NAME + "_testDeletion";
        String summary = "Test Mass Content Deletion";
        String comment = "The performance over partition deletion";
        PerformanceMeter testPerfMeter = perfBase.createPerformanceMeter( id, summary, true, comment );

        try {
            testPerfMeter.start( );
            mdi.removeData( );
            testPerfMeter.stop( );

            perfBase.endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
            perfBase = null;
        }
    }
}
