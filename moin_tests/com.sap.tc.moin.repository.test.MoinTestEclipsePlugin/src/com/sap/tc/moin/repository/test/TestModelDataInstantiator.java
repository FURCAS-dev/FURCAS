package com.sap.tc.moin.repository.test;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.ModelDataInstantiator;

public class TestModelDataInstantiator extends CoreMoinTest {

    ModelDataInstantiator mdi = null;

    int mmSize = 5;

    int attributeSize = 5;

    int instanceSize = 5;

    int partitionSize = 5;

    @Before
    public void beforeTest( ) throws Exception {

        this.mdi = new ModelDataInstantiator( _testClient1, true, mmSize, attributeSize, instanceSize, partitionSize, true );
    }

    @Test
    public void testIt( ) throws Exception {

        boolean succeed = mdi.createData( );
        assertTrue( "Failed to create data", succeed );

        Collection<PRI> partitions = mdi.loadData( );
        assertTrue( "Failed to load data", partitions != null && partitions.size( ) == partitionSize );

        int numPartitions = mdi.removeData( );
        assertTrue( "Failed to delete data", numPartitions == partitionSize );
    }

    @After
    public void afterTest( ) throws Exception {

        if ( this.mdi != null ) {
            this.mdi.shutdown( );
            this.mdi = null;
        }
    }
}
