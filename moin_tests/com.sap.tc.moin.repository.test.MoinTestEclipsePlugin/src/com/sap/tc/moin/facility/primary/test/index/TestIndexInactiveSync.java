package com.sap.tc.moin.facility.primary.test.index;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexImpl;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;



public class TestIndexInactiveSync extends TestIndexInactiveSyncBase {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Override
    protected void initializeIndex( ) {

        IndexImpl i = new IndexImpl( IpiPrimaryFacility.FACILITY_ID, "myFakeMoin" + System.currentTimeMillis( ), null );
        i.bind( ( (SpiMoin) getTestHelper( ).getCoreMoin( ) ).getCore( ).getMetamodelService( ) );
        i.bind( ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( ) );
        i.initialize( );
        i.finalizeStartup( );
        this.inactiveIndex = i;
    }

    @Override
    protected void cleanupIndex( ) {

        if ( this.inactiveIndex != null ) {
            this.inactiveIndex.tearDown( );
            this.inactiveIndex = null;
        }
    }

    @Test
    public void testSyncInactiveDataArea( ) throws Exception {

        super.executeTestSyncInactiveDataArea( );
    }

    @Test
    public void testSyncInactiveDataAreaWithoutActivation( ) throws Exception {

        super.executeTestSyncInactiveWithoutActivation( );
    }

    @Test
    public void testSyncInactiveDataAreaActivatedAndDeactivated( ) throws Exception {

        super.executeTestSyncInactiveActivatedAndDeactivated( );
    }
}
