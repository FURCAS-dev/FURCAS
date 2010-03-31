package com.sap.tc.moin.repository.test.performance;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.GeneratedmetamodelPackage;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass0;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestSubClass0;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * This JUnit testcase measures the performance of MOF standard operations. The
 * performance is measured using the Eclipse Performance API. Depending on the
 * configuration of the Eclipse Performance API, the results are typically
 * written into a database for further evaluation.
 */
public class TestPerfMofStandard extends TestPerfBase {

    Connection connection;

    public TestPerfMofStandard( ) {

        super( );
    }

    @Before
    public void prepareTest( ) throws Exception {

        connection = createConnection( );
        RefPackage refPackage = connection.getPackage( null, new String[] { TestMetaModels.GENERATEDMETAMODEL_TPE } );
        GeneratedmetamodelPackage generatedMM = null;
        if ( refPackage == null ) {
            throw new RuntimeException( "Required Package Extent not found for metamodel: " + TestMetaModels.GENERATEDMETAMODEL );
        }
        generatedMM = (GeneratedmetamodelPackage) refPackage;
    }

    @After
    public void cleanupTest( ) throws Exception {

        if ( connection != null ) {
            connection.close( );
        }
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

    /*
     * See comment below for details
     */
    @Test
    public void testElementCreationTypedAPI( ) throws Exception {

        int elementCount = 1000;

        String descriptiveId = "ElementCreation Typed API";
        String comment = "Creation of " + elementCount + " instances of TestClass0 via typed API (Class Proxy)";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        // Warmup
        createTestClass0Instances( elementCount );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                createTestClass0Instances( elementCount );
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    private void createTestClass0Instances( int instances ) {

        for ( int j = 0; j < instances; j++ ) {
            connection.createElementInPartition( TestClass0.class, null );
        }
    }

    @Test
    @Ignore
    public void testElementCreationReflectiveAPI( ) {

        String descriptiveId = "ElementCreation Reflective API";
        String comment = "XXX";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                // FIXME: implement me!
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    @Ignore
    public void testElementCreationCalculatedMofId( ) {

        String descriptiveId = "ElementCreation CalculatedMofId";
        String comment = "XXX";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                // FIXME: implement me!
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    /*
     * See comment below for details
     */
    @Test
    public void testElementDeletion( ) {

        int elementCount = 1000;
        String descriptiveId = "ElementDeletion";
        String comment = "Deletion of " + elementCount + " instances of TestClass0 via refDelete()";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        // Warmup
        createTestClass0Instances( elementCount );
        for ( Partitionable element : connection.getNullPartition( ).getElements( ) ) {
            ( (RefObject) element ).refDelete( );
        }

        try {
            for ( int i = 0; i < 100; i++ ) {
                createTestClass0Instances( elementCount );
                Collection<Partitionable> elements = connection.getNullPartition( ).getElements( );
                testPerfMeter.start( );
                for ( Partitionable element : elements ) {
                    ( (RefObject) element ).refDelete( );
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
    public void testLinkCreation( ) {

        String descriptiveId = "LinkCreation";
        String comment = "XXX";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                // FIXME: implement me!
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    @Ignore
    public void testNavigateLinkAtStorageWithMultiplicity( ) {

        String descriptiveId = "NavigateLink toN /w Storage";
        String comment = "XXX";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                // FIXME: implement me!
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    @Ignore
    public void testNavigateLinkAtStorage( ) {

        String descriptiveId = "NavigateLink to1 /w Storage";
        String comment = "XXX";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                // FIXME: implement me!
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    @Ignore
    public void testNavigateLinkAtNonStorage( ) {


        String descriptiveId = "NavigateLink /wo Storage";
        String comment = "XXX";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );
                // FIXME: implement me!
                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }

    @Test
    public void testRefIsInstanceOfOneGeneralizationHierarchy( ) throws Exception {

        String descriptiveId = "Call 100k refIsInstanceOf";
        String comment = "XXX";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, false, comment );

        Connection conn = createConnection( );

        TestSubClass0 instance = conn.createElementInPartition( TestSubClass0.class, null );
        MofClass clazz = conn.getClass( TestClass0.CLASS_DESCRIPTOR ).refMetaObject( );

        try {
            for ( int i = 0; i < 100; i++ ) {
                testPerfMeter.start( );

                for ( int j = 0; j < 1000000; j++ ) {
                    instance.refIsInstanceOf( (RefObject) clazz, true );
                }

                testPerfMeter.stop( );
            }
            endPerformanceMeasurement( testPerfMeter, true );
        } finally {
            testPerfMeter.dispose( );
        }
    }
}
