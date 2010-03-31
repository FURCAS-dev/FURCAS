package com.sap.tc.moin.facility.primary.test.index;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.query.index.memory.IndexLinkRecord;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexModelElement;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;


public class TestIndexInconsistencyMisc extends IndexTestCase {

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

    /**
     * <pre>
     * Starting Scenario:
     *     Three partitions with an element B and an inconsistent element C,
     *     one link from C2 to B.
     * 
     *     ------  ------  ------
     *     | C1 |  |    |  | C3 |
     *     |  o |  |    |  |    |
     *     |   \|  |    |  |    |
     *     |    |--+-B2 |  |    |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    getReferringElementForEndAndMetaobject(B1)
     *    
     * Test Verification: 
     *    Result must only contain C2, not C1
     * </pre>
     */
    @Test
    public void testGetReferringElementFEAMOTwoSourceElementsOneLink( ) throws Exception {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTestMisc.grefeamotwseol.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );

        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTestMisc.grefeamotwseol.Partition2" );
        mp2.deleteElements( );

        B2 b2 = createB2( );
        mp2.assignElement( b2 );
        MRI mriB2 = b2.get___Mri( );

        c1.setB( b2 );

        saveConnectionOne( );

        TestClient client = this._testClient1;
        ModelPartition mp3 = this.createDuplicatePartition( "IconsistencyTestMisc.grefeamotwseol.Partition3", mp1Xmi, client );

        saveConnectionOne( );

        C2 c3 = (C2) this.getConnectionOne( ).getElement( mp3.getPri( ).createMri( mriC1.getMofId( ) ) );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: Could not retrieve c3", c3 != null );

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( mriB2.getMofId( ) );
        assertTrue( "SV: Missing B2 element in index", bs != null );
        assertTrue( "SV: No duplicate elements expected", !( bs instanceof Object[] ) );

        Object cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing tripple element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) cs ).length == 2 );

        // check if there are links stored at C1
        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "SV: A link should exist here", linksMp1 != null );
        assertTrue( "SV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        IndexLinkRecord lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB2.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB2.getDataAreaDescriptor( ).getDataAreaName( ) );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        Collection<MRI> collection = this.index.getReferringElementsForEndAndMetaobject( this.localClientSpecs, this.testcasesPackage.getCase002( ).getAreferencesB( ).refMetaObject( ).get___Mri( ), mriB2, 0 );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertNotNull( "TV: ", collection );
        assertEquals( "TV: Unexpected size", 1, collection.size( ) );
        assertTrue( "TV: Did not contain expected MRI " + mriC1.toString( ) + " in " + collection.toString( ), collection.contains( mriC1 ) );

        // ###### End Test Verification ######
        // ###################################

        // ###########################
        // ###### Start Cleanup ######

        mp1.delete( );
        mp2.delete( );
        mp3.delete( );

        saveConnectionOne( );

        // ###### End Cleanup ######
        // #########################

    }

    /**
     * <pre>
     * Starting Scenario:
     *     Two partitions with an element C and an inconsistent element B,
     *     one intra-partition link, one cross link.
     * 
     *     ------  ------  ------
     *     | C1 |  |    |  | C3 |
     *     |  o |  |    |  | o  |
     *     |   \|  |    |  |/   |
     *     |    |--+-B2-+--|    |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    getReferringElementsForEndAndMetaobject(B2)
     *    
     * Test Verification: 
     *    Result must contain C1 and C2
     * </pre>
     */
    @Test
    public void testGetReferringElementFEAMOTwoSourceElementsTwoLink( ) throws Exception {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTestMisc.grefeamotwsetl.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTestMisc.grefeamotwsetl.Partition2" );
        mp1.deleteElements( );
        mp2.deleteElements( );

        saveConnectionOne( );

        B2 b2 = createB2( );
        mp2.assignElement( b2 );
        MRI mriB2 = ( (Partitionable) b2 ).get___Mri( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );
        c1.setB( b2 );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );

        TestClient client = this._testClient1;

        ModelPartition mp3 = this.createDuplicatePartition( "IconsistencyTestMisc.grefeamotwsetl.Partition3", mp1Xmi, client );

        C2 c3 = (C2) this.getConnectionOne( ).getElement( mp3.getPri( ).createMri( mriC1.getMofId( ) ) );
        MRI mriC3 = c3.get___Mri( );

        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( mriB2.getMofId( ) );
        assertTrue( "SV: Missing single element in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof IndexModelElement );

        Object cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) cs ).length == 2 );

        // check if there are links stored at C2
        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "SV: A link should exist here", linksMp1 != null );
        assertTrue( "SV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        IndexLinkRecord lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB2.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB2.getDataAreaDescriptor( ).getDataAreaName( ) );
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "SV: A link should NOT exist here", linksMp2 == null );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        Collection<MRI> collection = this.index.getReferringElementsForEndAndMetaobject( this.localClientSpecs, this.testcasesPackage.getCase002( ).getAreferencesB( ).refMetaObject( ).get___Mri( ), mriB2, 0 );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertNotNull( "TV: ", collection );
        assertEquals( "TV: Unexpected size", 2, collection.size( ) );
        assertTrue( "TV: Did not contain expected MRIs " + Arrays.asList( mriC1, mriC3 ).toString( ) + " in " + collection.toString( ), collection.containsAll( Arrays.asList( mriC1, mriC3 ) ) );

        // ###### End Test Verification ######
        // ###################################

        // ###########################
        // ###### Start Cleanup ######

        mp1.delete( );
        mp2.delete( );
        mp3.delete( );

        saveConnectionOne( );

        // ###### End Cleanup ######
        // #########################

    }
}
