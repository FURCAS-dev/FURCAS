package com.sap.tc.moin.facility.primary.test.index;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexConstants;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;

public class TestIndexGrowthAndShrink extends IndexTestCase {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "InconsistencyTestSetup" );

        for ( Partitionable element : this.getConnectionOne( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }

        this.saveConnectionOne( );
        this.deleteAllNonMetamodelsFromIndex( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    /**
     * Tests the growth of entries of typeToInstances and priToElements.
     */
    @Test
    @IndexOnly
    public void testPartitionGrowth( ) {

        final int count = IndexConstants.INITIAL_TOTAL_LRI;

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "Index.partitionGrowth.Partition" );

        C2 c2 = null;
        for ( int i = 0; i < count; i++ ) {
            c2 = this.createC2( );
            mp1.assignElement( c2 );
            this.saveConnectionOne( );
        }
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        mp1.delete( );
        this.saveConnectionOne( );
    }

    /**
     * Tests the shrink of mofIdToElements table, and typeToInstances and
     * priToElement entries.
     */
    @Test
    @IndexOnly
    public void testPartitionShrink( ) {

        final int count = IndexConstants.INITIAL_TOTAL_LRI;
        C2[] c2s = new C2[count];

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "Index.partitionShrink.Partition" );

        C2 c2 = null;
        for ( int i = 0; i < count; i++ ) {
            c2 = this.createC2( );
            mp1.assignElement( c2 );
            c2s[i] = c2;
        }
        this.saveConnectionOne( );
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        // delete each element
        for ( int i = 0; i < count; i++ ) {
            c2s[i].refDelete( );
            this.saveConnectionOne( );
        }
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        mp1.delete( );
        this.saveConnectionOne( );
    }

    /**
     * Tests the resize of table for priToElements, priToLinkRecords,
     * priToIndexPri, daToDcsToIndexPris.
     */
    @Test
    @IndexOnly
    public void testPartitionNumberGrowthAndShrink( ) {

        final int count = IndexConstants.INITIAL_PRI;

        ModelPartition[] partitions = new ModelPartition[count * 2];

        ModelPartition mp1 = null;
        ModelPartition mp2 = null;
        C2 c2 = null;
        B2 b2 = null;
        for ( int i = 0; i < count * 2; i++ ) {
            mp1 = this._testClient1.getOrCreatePartition( "Index.partitionNumGrowthAndShrink.partition1" );
            mp2 = this._testClient1.getOrCreatePartition( "Index.partitionNumGrowthAndShrink.partition2" );
            c2 = this.createC2( );
            b2 = this.createB2( );
            c2.setB( b2 );
            mp1.assignElement( c2 );
            mp2.assignElement( b2 );
            partitions[i++] = mp1;
            partitions[i] = mp2;
        }
        this.saveConnectionOne( );
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );

        for ( int i = 0; i < count * 2; i++ ) {
            partitions[i].delete( );
            this.saveConnectionOne( );
        }
        this.index.doSanityCheck( IndexConstants.SANITY_FORCE_CHECK_ALL );
    }
}
