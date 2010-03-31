package com.sap.tc.moin.repository.performance.test.ide;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.test.performance.TestPerfBase;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.GeneratedmetamodelPackage;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass0;
import com.sap.tc.moin.test.fw.TestMetaModels;


public class TestPerfStartup extends TestPerfBase {


    @Test
    public void testMoinStartup( ) throws Exception {

        String descriptiveId = "Startup in IDE (Cold Start)";
        String comment = "Get MOIN instance and project-less connection in the IDE, cold start, one call";
        PerformanceMeter testPerfMeter = createPerformanceMeter( descriptiveId, true, comment );

        try {

            testPerfMeter.start( );
            Connection conn = createMoinAndProjectLessConnection( );
            testPerfMeter.stop( );
            testPerfMeter.commit( );
            if ( conn != null ) {
                conn.close( );
            }

        } finally {
            testPerfMeter.dispose( );
        }

    }

    private Connection createMoinAndProjectLessConnection( ) {

        Moin moin = MoinFactory.getMoinInstance( );
        CompoundDataAreaManager cdam = moin.getCompoundDataAreaManager( );
        CompoundClientSpec ccs = cdam.getCompoundClientSpecTransientOnly( );
        Session session = moin.createSession( ccs );
        Connection conn = session.createConnection( );

        ModelPartition mp = conn.getOrCreateTransientPartition( "transientPartitionForStartupTest" );
        GeneratedmetamodelPackage gmPackage = (GeneratedmetamodelPackage) getPackageExtent( conn, new String[] { TestMetaModels.GENERATEDMETAMODEL_TPE } );
        TestClass0 testClass0 = (TestClass0) gmPackage.getTestClass0( ).refCreateInstance( );
        mp.assignElementIncludingChildren( testClass0 );

        return conn;
    }

    private RefPackage getPackageExtent( Connection conn, String[] qualifiedName ) {

        RefPackage refPackage = conn.getPackage( null, qualifiedName );
        if ( refPackage == null ) {
            throw new RuntimeException( "No package extent found for" + qualifiedName );
        }
        return refPackage;
    }

}
