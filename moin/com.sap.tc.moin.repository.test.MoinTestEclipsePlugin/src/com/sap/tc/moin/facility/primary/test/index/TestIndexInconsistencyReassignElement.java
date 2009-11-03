package com.sap.tc.moin.facility.primary.test.index;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.junit.Staged;
import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexLinkRecord;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexModelElement;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;

public class TestIndexInconsistencyReassignElement extends IndexTestCase {

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        testcasesPackage = (TestcasesPackage) getConnectionOne( ).getPackage( null, new String[] { "testcases" } );
        moinPackage = (MoinPackage) getConnectionOne( ).getPackage( null, new String[] { "MOIN" } );

        case002Package = testcasesPackage.getCase002( );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "InconsistencyTestSetup" );

        for ( Partitionable element : this.getConnectionOne( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    /**
     * <pre>
     * Starting Scenario:
     *     Two partitions with an element C, an element B
     *     one intra-partition link, no cross link.
     * 
     *     ------  ------
     *     | C1 |  |    |
     *     |  o |  |    |
     *     |  | |  |    |
     *     | B1 |  |    |
     *     ------  ------
     * 
     * Test Action: 
     *    reassign(B1, p2)
     *    
     * Test Verification: 
     *    Index should contain the cross link Link(C1->B) but not Link(E2->B)
     * </pre>
     */
    @Test
    @IndexOnly
    public void testReassignElement_2P_NoInconsistency( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.ra2pni.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTest.ra2pni.Partition2" );

        mp1.deleteElements( );
        mp2.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        MRI mriB1 = ( (Partitionable) b1 ).get___Mri( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );
        c1.setB( b1 );

        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains  links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", bs != null );
        assertTrue( "SV: LIndexModelElement expected for duplicate elements", bs instanceof IndexModelElement );

        Object cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", cs != null );
        assertTrue( "SV: LIndexModelElement expected for duplicated element", cs instanceof IndexModelElement );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        mp2.assignElement( b1 );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        bs = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", bs != null );
        assertTrue( "TV: LIndexModelElement expected for duplicate elements", bs instanceof IndexModelElement );

        cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", cs != null );
        assertTrue( "TV: LIndexModelElement expected for duplicated element", cs instanceof IndexModelElement );

        // check if there are links stored at C1
        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp1 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        IndexLinkRecord lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB1.getDataAreaDescriptor( ).getDataAreaName( ) );

        // ###### End Test Verification ######
        // ###################################

        // ###########################
        // ###### Start Cleanup ######

        mp1.delete( );
        mp2.delete( );

        saveConnectionOne( );

        // ###### End Cleanup ######
        // #########################

    }

    /**
     * <pre>
     * Starting Scenario:
     *     Two partitions with an element C, an element B
     *     no intra-partition link, one cross link.
     * 
     *     ------  ------
     *     | C1 |  |    |
     *     |  o |  |    |
     *     |   \|  |    |
     *     |    \--+-B2 |
     *     ------  ------
     * 
     * Test Action: 
     *    reassign(B2, p1)
     *    
     * Test Verification: 
     *    Index should contain no link
     * </pre>
     */
    @Test
    @IndexOnly
    public void testReassignElement_2P_NoInconsistency2( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.ra2pni2.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTest.ra2pni2.Partition2" );

        mp1.deleteElements( );
        mp2.deleteElements( );

        saveConnectionOne( );

        B2 b2 = createB2( );
        mp2.assignElement( b2 );
        MRI mriB1 = ( (Partitionable) b2 ).get___Mri( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );
        c1.setB( b2 );

        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains  links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", bs != null );
        assertTrue( "SV: LIndexModelElement expected for duplicate elements", bs instanceof IndexModelElement );

        Object cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", cs != null );
        assertTrue( "SV: LIndexModelElement expected for duplicated element", cs instanceof IndexModelElement );

        // check if there are links stored at C1
        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp1 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        IndexLinkRecord lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB1.getDataAreaDescriptor( ).getDataAreaName( ) );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        mp1.assignElement( b2 );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        bs = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", bs != null );
        assertTrue( "TV: LIndexModelElement expected for duplicate elements", bs instanceof IndexModelElement );

        cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", cs != null );
        assertTrue( "TV: LIndexModelElement expected for duplicated element", cs instanceof IndexModelElement );

        // ###### End Test Verification ######
        // ###################################

        // ###########################
        // ###### Start Cleanup ######

        mp1.delete( );
        mp2.delete( );

        saveConnectionOne( );

        // ###### End Cleanup ######
        // #########################

    }

    /**
     * <pre>
     * Starting Scenario:
     *     Three partitions with 1 element C and 3 element B,
     *     one intra-partition link, no cross link.
     * 
     *     ------  ------  ------
     *     |    |  | C2 |  |    |
     *     |    |  |  o |  |    |
     *     |    |  |  | |  |    |
     *     | B1 |  | B2 |  | B3 |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    reassign(B1, p3)
     *    
     * Test Verification: 
     *    Index should still contain no links
     * </pre>
     */
    @Test
    @IndexOnly
    public void testReassignElement_3P_SingleStorageTrippleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.ra3pssto.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        LRI lriB1 = ( (Partitionable) b1 ).get___Mri( ).getLri( );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );
        TestClient client = this._testClient1;
        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.ra3pssto.Partition2", mp1Xmi, client );
        ModelPartition mp3 = this.createDuplicatePartition( "IconsistencyTest.ra3pssto.Partition3", mp1Xmi, client );

        C2 c2 = createC2( );
        mp2.assignElement( c2 );
        MRI mriC2 = ( (Partitionable) c2 ).get___Mri( );
        c2.setB( b1 );

        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( lriB1.getMofId( ) );
        assertTrue( "SV: Missing tripple element in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) bs ).length == 3 );

        Object cs = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof IndexModelElement );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        mp3.assignElement( c2 );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );
        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        bs = this.getMofIdToElements( lriB1.getMofId( ) );
        assertTrue( "TV: Missing double element in index", bs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "TV: Tripple element number not correct", ( (Object[]) bs ).length == 3 );

        cs = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", cs != null );
        assertTrue( "TV: ArrayList expected for duplicated element", cs instanceof IndexModelElement );

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
     *     Three partitions with 1 element C and 3 element B,
     *     one intra-partition link, no cross link.
     * 
     *     ------  ------  ------
     *     |    |  |    |  | C3 |
     *     |    |  |    |  |  o |
     *     |    |  |    |  |  | |
     *     | B1 |  |    |  | B3 |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    reassign(C3, p2)
     *    
     * Test Verification: 
     *    Index should contain a link Link(C3->B)
     * </pre>
     */
    @Test
    @IndexOnly
    public void testReassignElement_3P_SingleStorageDoubleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp3 = this._testClient1.getOrCreatePartition( "IconsistencyTest.ra3pssdo.Partition3" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTest.ra3pssdo.Partition2" );
        mp3.deleteElements( );
        mp2.deleteElements( );

        saveConnectionOne( );

        B2 b3 = createB2( );
        mp3.assignElement( b3 );
        LRI lriB3 = ( (Partitionable) b3 ).get___Mri( ).getLri( );

        saveConnectionOne( );

        byte[] mp3Xmi = this.getPartitionByteArray( mp3 );
        TestClient client = this._testClient1;
        ModelPartition mp1 = this.createDuplicatePartition( "IconsistencyTest.ra3pssdo.Partition1", mp3Xmi, client );

        C2 c3 = createC2( );
        mp3.assignElement( c3 );
        MRI mriC3 = ( (Partitionable) c3 ).get___Mri( );
        c3.setB( b3 );

        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains elements", index.getPriToElements( ).get( index.getPriToIndexPri( ).get( mp2.getPri( ).toString( ) ) ) == null );

        Object bs = this.getMofIdToElements( lriB3.getMofId( ) );
        assertTrue( "SV: Missing double element in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Double element number not correct", ( (Object[]) bs ).length == 2 );

        Object cs = this.getMofIdToElements( mriC3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof IndexModelElement );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        mp2.assignElement( c3 );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains no elements", index.getPriToElements( ).get( this.index.getPriToIndexPri( ).get( mp2.getPri( ).toString( ) ) ) != null );
        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains no link", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) != null );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        bs = this.getMofIdToElements( lriB3.getMofId( ) );
        assertTrue( "TV: Missing double element in index", bs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "TV: Tripple element number not correct", ( (Object[]) bs ).length == 2 );

        cs = this.getMofIdToElements( mriC3.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing tripple element in index", cs != null );
        assertTrue( "TV: ArrayList expected for duplicated element", cs instanceof IndexModelElement );

        // check if there are links stored at C2
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp2 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp2.size( ) + " instead of 1", linksMp2.size( ) == 1 );
        IndexLinkRecord lr = linksMp2.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp2.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( lriB3.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC3.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == lriB3.getDataAreaDescriptor( ).getDataAreaName( ) );

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
     *     Three partitions with 3 elements C and 1 element B,
     *     one intra-partition link, two cross links.
     * 
     *     ------  ------  ------
     *     | C1 |  | C2 |  | C3 |
     *     |  o |  |  o |  | o  |
     *     |   \|  |  | |  |/   |
     *     |    \--+-B2-+--/    |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    reassign(B2, p3)
     *    
     * Test Verification: 
     *    Index should contain Link(C1->B), Link(C2->B) but not
     *    Link(C3->B)
     * </pre>
     */
    @Test
    @IndexOnly
    public void testReassignElement_3P_TrippleStorageSingleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.ra3ptsso.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        MRI mriB1 = ( (Partitionable) b1 ).get___Mri( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );
        c1.setB( b1 );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );
        TestClient client = this._testClient1;
        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.ra3ptsso.Partition2", mp1Xmi, client );
        ModelPartition mp3 = this.createDuplicatePartition( "IconsistencyTest.ra3ptsso.Partition3", mp1Xmi, client );

        // delete B1 and B3
        b1.refDelete( );
        ( (B2) this.getConnectionOne( ).getElement( mp3.getPri( ).createMri( mriB1.getMofId( ) ) ) ).refDelete( );

        B2 b2 = ( (B2) this.getConnectionOne( ).getElement( mp2.getPri( ).createMri( mriB1.getMofId( ) ) ) );
        MRI mriB2 = ( (Partitionable) b2 ).get___Mri( );

        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) != null );

        Object bs = this.getMofIdToElements( mriB2.getMofId( ) );
        assertTrue( "SV: Missing single element in index", bs != null );
        assertTrue( "SV: LIndexModelElement expected for single elements", bs instanceof IndexModelElement );

        Object cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing triplle element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof Object[] );
        assertTrue( "SV: Tripple element number not correct", ( (Object[]) cs ).length == 3 );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        mp3.assignElement( b2 );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );
        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) != null );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        bs = this.getMofIdToElements( mriB1.getMofId( ) );
        assertTrue( "TV: Missing single element in index", bs != null );
        assertTrue( "TV: LIndexModelElement expected for single elements", bs instanceof IndexModelElement );

        cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing tripple element in index", cs != null );
        assertTrue( "TV: ArrayList expected for tripple element", cs instanceof Object[] );
        assertTrue( "TV: Tripple element number not correct", ( (Object[]) cs ).length == 3 );

        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp1 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        IndexLinkRecord lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB2.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB2.getDataAreaDescriptor( ).getDataAreaName( ) );

        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp2 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp2.size( ) + " instead of 1", linksMp2.size( ) == 1 );
        lr = linksMp2.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp2.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB2.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB2.getDataAreaDescriptor( ).getDataAreaName( ) );
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

    @IndexOnly
    @Staged
    public void testTemplate( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        // TODO prepare start scenario

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        // TODO verify Scenario

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        // TODO do test action

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        // TODO do test verification

        // ###### End Test Verification ######
        // ###################################

        // ###########################
        // ###### Start Cleanup ######

        // TODO cleanup

        // ###### End Cleanup ######
        // #########################

    }
}
