package com.sap.tc.moin.repository.test.performance;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.Test;

import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.test.fw.TestClient;

public class TestPerfCustomParserSerializerAccess extends TestPerfBase {

    private static final String PERFORMANCE_TEST_CPS = "com.sap.tc.moin.repository.test.PerformanceTestCps";

    private static final String CPS_TEST_SUFFIX = "cpstest";

    @Test
    public void testCustomSerializationAccess( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "CPS_ACCESS", false, "Tests how long it takes retrieve the right custom parser/serializer." );

        TestClient client = getTestHelper( ).getDefaultTestClient( true );
        client.setAsCurrentClient( );

        ModelPartition partition = client.getOrCreatePartitionStable( "CpsPerformanceTestPartition" );

        // get PRI
        PRI pri = partition.getPri( );

        // create cps PRI
        String newPri = pri.toString( );
        newPri = newPri.replace( "moinmm", CPS_TEST_SUFFIX );
        Moin moin = client.getConnection( ).getSession( ).getMoin( );
        PRI testPri = moin.createPri( newPri );

        Facility facility = moin.getFacilityById( "PF" );

        PartitionSerializationManagerImpl partitionSerializationManager = (PartitionSerializationManagerImpl) ( (SpiFacility) facility ).getPartitionSerializationManager( );

        m.start( );
        // try to get the custom serialization factory often
        for ( int i = 0; i < 10000; i++ ) {
            // TODO fix
            //partitionSerializationManager.getCustomParser( testPri );
        }

        m.stop( );
        m.commit( );

        partition.delete( );
        client.getConnection( ).save( );
    }

    @Test
    public void testCustomSerializationRegistration( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "CPS_REGISTER_UNREGISTER", false, "Tests how long it takes to register and unregister some suffixes." );

        TestClient client = getTestHelper( ).getDefaultTestClient( true );
        client.setAsCurrentClient( );


        Moin moin = client.getConnection( ).getSession( ).getMoin( );


        Facility facility = moin.getFacilityById( "PF" );

        PartitionSerializationManagerImpl partitionSerializationManager = (PartitionSerializationManagerImpl) ( (SpiFacility) facility ).getPartitionSerializationManager( );

        String[] fileSuffixes = new String[10000];

        // fill registry
        for ( int i = 0; i < fileSuffixes.length; i++ ) {
            fileSuffixes[i] = CPS_TEST_SUFFIX + i;
        }

        m.start( );
        partitionSerializationManager.registerParserSerializer( PERFORMANCE_TEST_CPS, fileSuffixes, null );

        m.stop( );
        m.start( );
        //partitionSerializationManager.unregisterParserSerializer( PERFORMANCE_TEST_CPS );

        m.stop( );

        m.commit( );

    }

}
