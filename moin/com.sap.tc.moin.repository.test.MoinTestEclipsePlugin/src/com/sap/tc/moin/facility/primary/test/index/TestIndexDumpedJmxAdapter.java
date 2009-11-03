package com.sap.tc.moin.facility.primary.test.index;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.jmx.IndexDumpedMBean;
import com.sap.tc.moin.test.fw.JmxRemoteConnection;
import com.sap.tc.moin.testcases.case002.B2;


public class TestIndexDumpedJmxAdapter extends IndexTestCase {

    private JmxRemoteConnection jmx = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        if ( this.jmx == null ) {
            this.jmx = getTestHelper( ).createJmxRemoteConnection( this.index.getObjectName( ) );
        } else {
            this.jmx.reset( );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( jmx != null ) {
            this.jmx.shutdown( );
        }
        super.afterTestMethod( );
    }

    @Test
    public void testJmxOperation_forceDump( ) throws Exception {

        // fist change index
        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( "forceDump" );
        mp.createElement( B2.class );
        saveConnectionOne( );

        IndexDumpedMBean index = this.jmx.newProxy( IndexDumpedMBean.class );
        assertTrue( index.forceDump( ) );

        mp.delete( );
        saveConnectionOne( );
    }
}
