package com.sap.tc.moin.facility.primary.test.index;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.sap.junit.IndexOnly;
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

public class TestIndexInconsistencyRemoveElement extends IndexTestCase {

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
     *     Two partitions with an element C and an inconsistent element B,
     *     one intra-partition link.
     * 
     *     ------  ------
     *     | C1 |  |    |
     *     |  o |  |    |
     *     |  | |  |    |
     *     | B1 |  | B2 |
     *     ------  ------
     * 
     * Test Action: 
     *    delElement(B1)
     *    
     * Test Verification: 
     *    Index should contain the cross link Link(C1->B)
     * </pre>
     */
    @Test
    public void testRemoveElement_2P_SingleStorageDoubleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.re2pssdo.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        MRI mriB1 = ( (Partitionable) b1 ).get___Mri( );
        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );

        TestClient client = this._testClient1;

        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.re2pssdo.Partition2", mp1Xmi, client );

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
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated element in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) bs ).length == 2 );

        Object cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", cs != null );
        assertTrue( "SV: LIndexModelElement expected for single element", cs instanceof IndexModelElement );

        // check if there are links stored at C2
        List<IndexLinkRecord> links = this.getPriToLinkRecords( mriC1.getPri( ).toString( ) );
        assertTrue( "SV: Link(s) should not exist here", links == null );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        // delete b1
        b1.refDelete( );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );

        bs = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing duplicated element in index", bs != null );
        assertTrue( "TV: LIndexModelElement expected for deleted element", bs instanceof IndexModelElement );

        cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", cs != null );
        assertTrue( "TV: LIndexModelElement expected for single element", cs instanceof IndexModelElement );

        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp1 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        IndexLinkRecord lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriC1.getDataAreaDescriptor( ).getDataAreaName( ) );
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "TV: A link should NOT exist here", linksMp2 == null );

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
     *     Two partitions with an element C and an inconsistent element B,
     *     one intra-partition link, one cross link.
     * 
     *     ------  ------
     *     | C1 |  | C2 |
     *     |  o |  |  o |
     *     |   \|  |  | |
     *     |    |--+-B2 |
     *     ------  ------
     * 
     * Test Action: 
     *    delElement(B2)
     *    
     * Test Verification: 
     *    Index should NOT contain the cross link Link(C1->B) anymore
     * </pre>
     */
    @Test
    public void testRemoveElement_2P_DoubleStorageSingleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.re2pdsso.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        LRI lriB1 = ( (Partitionable) b1 ).get___Mri( ).getLri( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );
        c1.setB( b1 );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );

        TestClient client = this._testClient1;

        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.re2pdsso.Partition2", mp1Xmi, client );

        b1.refDelete( );
        B2 b2 = (B2) this.getConnectionOne( ).getElement( lriB1 );
        MRI mriB2 = ( (Partitionable) b2 ).get___Mri( );

        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( mriB2.getLri( ).getMofId( ) );
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
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB2.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB2.getDataAreaDescriptor( ).getDataAreaName( ) );
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "SV: A link should NOT exist here", linksMp2 == null );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        b2.refDelete( );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        bs = this.getMofIdToElements( mriB2.getLri( ).getMofId( ) );
        assertTrue( "SV: Single element found in index (expected none)", bs == null );

        cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) cs ).length == 2 );

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
     *     Two partitions with an element C and an inconsistent element B,
     *     one intra-partition link, one cross link.
     * 
     *     ------  ------
     *     | C1 |  | C2 |
     *     |  o |  |  o |
     *     |   \|  |  | |
     *     |    |--+-B2 |
     *     ------  ------
     * 
     * Test Action: 
     *    delElement(C2)
     *    
     * Test Verification: 
     *    Index should still contain the cross link Link(C1->B)
     * </pre>
     */
    @Test
    public void testRemoveElement_2P_DoubleStorageSingleOther2( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.re2pdsso2.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        LRI lriB1 = ( (Partitionable) b1 ).get___Mri( ).getLri( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );
        c1.setB( b1 );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );

        TestClient client = this._testClient1;

        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.re2pdsso2.Partition2", mp1Xmi, client );

        b1.refDelete( );
        C2 c2 = (C2) this.getConnectionOne( ).getElement( mp2.getPri( ).createMri( mriC1.getMofId( ) ) );

        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( lriB1.getMofId( ) );
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
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( lriB1.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == lriB1.getDataAreaDescriptor( ).getDataAreaName( ) );
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "SV: A link should NOT exist here", linksMp2 == null );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        c2.refDelete( );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) != null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        bs = this.getMofIdToElements( lriB1.getMofId( ) );
        assertTrue( "TV: Missing single element in index", bs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", bs instanceof IndexModelElement );

        cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing duplicated element in index", cs != null );
        assertTrue( "TV: ArrayList expected for duplicated element", cs instanceof IndexModelElement );

        // check if there are links stored at C2
        linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp1 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( lriB1.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == lriB1.getDataAreaDescriptor( ).getDataAreaName( ) );
        linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "TV: A link should NOT exist here", linksMp2 == null );

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
     *     Three partitions with 3 elements C and 2 element B,
     *     two intra-partition links, one cross link.
     * 
     *     ------  ------  ------
     *     | C1 |  | C2 |  | C3 |
     *     |  o |  |  o |  |  o |
     *     |   \|  |  | |  |  | |
     *     |    |--+-B2 |  | B3 |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    delElement(B2)
     *    
     * Test Verification: 
     *    Index should contain the cross link Link(C1->B) and
     *    Link(C2->B)
     * </pre>
     */
    @Test
    public void testRemoveElement_3P_TrippleStorageDoubleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.re3ptsdo.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        LRI lriB1 = ( (Partitionable) b1 ).get___Mri( ).getLri( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );
        c1.setB( b1 );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );
        TestClient client = this._testClient1;
        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.re3ptsdo.Partition2", mp1Xmi, client );

        b1.refDelete( );
        B2 b2 = (B2) this.getConnectionOne( ).getElement( mp2.getPri( ).createMri( lriB1.getMofId( ) ) );

        saveConnectionOne( );

        byte[] mp2Xmi = this.getPartitionByteArray( mp2 );
        ModelPartition mp3 = this.createDuplicatePartition( "IconsistencyTest.re3ptsdo.Partition3", mp2Xmi, client );

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
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( lriB1.getMofId( ) );
        assertTrue( "SV: Missing double element in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) bs ).length == 2 );

        Object cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing tripple element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) cs ).length == 3 );

        // check if there are links stored at C1
        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "SV: A link should exist here", linksMp1 != null );
        assertTrue( "SV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        IndexLinkRecord lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( lriB1.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == lriB1.getDataAreaDescriptor( ).getDataAreaName( ) );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        b2.refDelete( );
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

        bs = this.getMofIdToElements( lriB1.getMofId( ) );
        assertTrue( "TV: Missing double element in index", bs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", bs instanceof IndexModelElement );

        cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing tripple element in index", cs != null );
        assertTrue( "TV: ArrayList expected for duplicated element", cs instanceof Object[] );
        assertTrue( "TV: Duplicate element number not correct", ( (Object[]) cs ).length == 3 );

        // check if there are links stored at C1
        linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp1 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp1.size( ) + " instead of 1", linksMp1.size( ) == 1 );
        lr = linksMp1.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( lriB1.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == lriB1.getDataAreaDescriptor( ).getDataAreaName( ) );
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp2 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp2.size( ) + " instead of 1", linksMp2.size( ) == 1 );
        lr = linksMp2.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp2.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( lriB1.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC1.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == lriB1.getDataAreaDescriptor( ).getDataAreaName( ) );

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
     *     Three partitions with 2 elements C and 3 element B,
     *     two intra-partition links, no cross link.
     * 
     *     ------  ------  ------
     *     |    |  | C2 |  | C3 |
     *     |    |  |  o |  |  o |
     *     |    |  |  | |  |  | |
     *     | B1 |  | B2 |  | B3 |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    delElement(B2)
     *    
     * Test Verification: 
     *    Index should contain the cross link Link(C2->B)
     * </pre>
     */
    @Test
    public void testRemoveElement_3P_DoubleStorageTrippleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.re3pdsto.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        LRI lriB1 = ( (Partitionable) b1 ).get___Mri( ).getLri( );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );
        TestClient client = this._testClient1;
        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.re3pdsto.Partition2", mp1Xmi, client );

        C2 c2 = createC2( );
        mp2.assignElement( c2 );
        MRI mriC2 = ( (Partitionable) c2 ).get___Mri( );
        c2.setB( b1 );

        B2 b2 = (B2) this.getConnectionOne( ).getElement( mp2.getPri( ).createMri( lriB1.getMofId( ) ) );

        saveConnectionOne( );

        byte[] mp2Xmi = this.getPartitionByteArray( mp2 );
        ModelPartition mp3 = this.createDuplicatePartition( "IconsistencyTest.re3pdsto.Partition3", mp2Xmi, client );

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
        assertTrue( "SV: Missing double element in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) bs ).length == 3 );

        Object cs = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing tripple element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) cs ).length == 2 );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        b2.refDelete( );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );
        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains no links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) != null );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        bs = this.getMofIdToElements( lriB1.getMofId( ) );
        assertTrue( "TV: Missing double element in index", bs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "TV: Tripple element number not correct", ( (Object[]) bs ).length == 2 );

        cs = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing tripple element in index", cs != null );
        assertTrue( "TV: ArrayList expected for duplicated element", cs instanceof Object[] );
        assertTrue( "TV: Duplicate element number not correct", ( (Object[]) cs ).length == 2 );

        // check if there are links stored at C1
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp2 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp2.size( ) + " instead of 1", linksMp2.size( ) == 1 );
        IndexLinkRecord lr = linksMp2.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp2.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( lriB1.getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC2.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == lriB1.getDataAreaDescriptor( ).getDataAreaName( ) );

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
     *     |    |  | C2 |  |    |
     *     |    |  |  o |  |    |
     *     |    |  |  | |  |    |
     *     | B1 |  | B2 |  | B3 |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    delElement(B1)
     *    
     * Test Verification: 
     *    Index should still contain no links
     * </pre>
     */
    @Test
    public void testRemoveElement_3P_SingleStorageTrippleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.re3pssto.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        LRI lriB1 = ( (Partitionable) b1 ).get___Mri( ).getLri( );

        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );
        TestClient client = this._testClient1;
        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.re3pssto.Partition2", mp1Xmi, client );
        ModelPartition mp3 = this.createDuplicatePartition( "IconsistencyTest.re3pssto.Partition3", mp1Xmi, client );

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
        assertTrue( "SV: Missing double element in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) bs ).length == 3 );

        Object cs = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing tripple element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicated element", cs instanceof IndexModelElement );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        b1.refDelete( );
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
        assertTrue( "TV: Tripple element number not correct", ( (Object[]) bs ).length == 2 );

        cs = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing tripple element in index", cs != null );
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

    @IndexOnly
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
