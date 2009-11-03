package com.sap.tc.moin.repository.test.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.test.query.BaseSyntheticQueryTests;
import com.sap.tc.moin.test.fw.ModelDataInstantiator;
import com.sap.tc.moin.test.testcase.MoinTestCase;

public class TestPerfQuery extends BaseSyntheticQueryTests {

    private String TEST_NAME = "MOINPerformanceTests";

    private TestPerfBase performanceBase;

    private final static int numberOfRuns = 3;

    private boolean withScope;

    public TestPerfQuery( boolean withScope ) {

        this.withScope = withScope;

        //initialize performance measurement and performance meter
        performanceBase = new TestPerfBase( );
        partitionScope = new PRI[0];

        try {
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    @Parameters
    public static LinkedList<Object> queryTestData( ) {

        LinkedList<Object> params = new LinkedList<Object>( );

        params.add( new Object[] { true } );
        params.add( new Object[] { false } );

        return params;
    }

    @BeforeClass
    static public void beforeQueryTests( ) throws Exception {

        mmSize = 10;
        attrSize = 10;
        instSize = 10;
        partSize = 10;

        createDirtyData = false;
        createObjValAttrs = false;

        mdi = new ModelDataInstantiator( getTestHelper( ).getDefaultTestClient( true ), true, mmSize, attrSize, instSize, partSize, createObjValAttrs );
        mdi.removeData( );
    }

    @AfterClass
    public static void afterQueryTests( ) throws Exception {

        BaseSyntheticQueryTests.afterQueryTests( true );
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    private PRI[] getPRIsForRun( ) throws Exception {

        List<PRI> partitionsList = new ArrayList<PRI>( );

        // Arrays.asList(partitionScope);
        for ( int i = 0; i < partitionScope.length / 2; i++ ) {
            partitionsList.add( partitionScope[i] );
        }

        PRI[] partitions = partitionsList.toArray( new PRI[partitionsList.size( )] );

        return partitions;
    }

    private void preambleOperation( ) throws Exception {

        // ONLY FOR FIRST TEST
        // reset scope for this particular test
        if ( withScope ) {
            // before each query, we add data to the data base
            partitionScopeInclusive = true;
            partitionScope = null;
            BaseSyntheticQueryTests.beforeQueryTests( true );
            partitionScope = getPRIsForRun( );

            myTestClient = MoinTestCase.getTestHelper( ).getDefaultTestClient( true );
            myTestClient.setAsCurrentClient( );
            myConn = myTestClient.getConnection( );
        } else {
            partitionScope = new PRI[0];
            partitionScopeInclusive = false;
        }
    }

    @Test
//    @Ignore
    public void test_assoc( ) throws Exception {

        String id = TEST_NAME + "_testAssoc" + ( ( this.withScope ) ? 0 : 1 );
        String summary = "Test Query Association";
        String comment = "The average performance over association query";
        PerformanceMeter testPerfMeter = this.performanceBase.createPerformanceMeter( id, summary, false, comment );

        try {
            for ( int j = 0; j < numberOfRuns; j++ ) {
                preambleOperation( );

                testPerfMeter.start( );
                for ( int i = 0; i < 10; i++ ) {
                    super.double_assoc_ast( );
                }
                testPerfMeter.stop( );
            }

            this.performanceBase.endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
//    @Ignore
    public void test_linear_associations( ) throws Exception {

        String id = TEST_NAME + "_testLinearAssoc" + ( ( this.withScope ) ? 0 : 1 );
        String summary = "Test Query Linear Association";
        String comment = "The average performance over linear association query";
        PerformanceMeter testPerfMeter = this.performanceBase.createPerformanceMeter( id, summary, false, comment );

        try {
            for ( int j = 0; j < numberOfRuns; j++ ) {
                preambleOperation( );

                testPerfMeter.start( );
                for ( int i = 0; i < 10; i++ ) {
                    super.complex_assoc_linear_ast( );
                }
                testPerfMeter.stop( );
            }
            this.performanceBase.endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
//    @Ignore
    public void test_grid_associations( ) throws Exception {

        String id = TEST_NAME + "_testGridAssoc" + ( ( this.withScope ) ? 0 : 1 );
        String summary = "Test Query Grid Association";
        String comment = "The average performance over grid association query";
        PerformanceMeter testPerfMeter = this.performanceBase.createPerformanceMeter( id, summary, false, comment );

        try {
            for ( int j = 0; j < numberOfRuns; j++ ) {
                preambleOperation( );

                testPerfMeter.start( );
                for ( int i = 0; i < 10; i++ ) {
                    super.complex_assoc_grid_ast( );
                }
                testPerfMeter.stop( );
            }
            this.performanceBase.endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }
}
