package com.sap.tc.moin.facility.primary.test.index;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexLinkRecord;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexModelElement;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;

public class TestIndexInconsistencyAddLink extends IndexTestCase {

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
     *     Two partitions with an element C and an inconsistent element B,
     *     no links.
     * 
     *     ------  ------
     *     |    |  | C2 |
     *     |    |  |    |
     *     | B1 |  | B2 |
     *     ------  ------
     * 
     * Test Action: 
     *    addLink(C2 -> B1)
     *    
     * Test Verification: 
     *    Index should neither contain the cross link Link(C2->B) nor the 
     *    intra-partition link Link(C2->B)
     * </pre>
     */
    @Test
    @IndexOnly
    public void testAddLink_2P_SingleStorageDoubleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.al2pssdo.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        MRI mriB1 = ( (Partitionable) b1 ).get___Mri( );
        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );

        TestClient client = this._testClient1;

        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.al2pssdo.Partition2", mp1Xmi, client );

        C2 c2 = createC2( );
        mp2.assignElement( c2 );
        MRI mriC2 = ( (Partitionable) c2 ).get___Mri( );
        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        Object b1s = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated element in index", b1s != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", b1s instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) b1s ).length == 2 );

        Object c2s = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", c2s != null );
        assertTrue( "SV: IndexModelElement expected for single element", c2s instanceof IndexModelElement );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        // add link C2->B1
        c2.setB( (B2) this.getConnectionOne( ).getElement( mriB1 ) );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        b1s = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing duplicated element in index", b1s != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", b1s instanceof Object[] );
        assertTrue( "TV: Duplicate element number not correct", ( (Object[]) b1s ).length == 2 );

        c2s = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", c2s != null );
        assertTrue( "TV: IndexModelElement expected for single element", c2s instanceof IndexModelElement );

        // check if there are links stored at C2
        List<?> links = this.getPriToLinkRecords( mriC2.getPri( ).toString( ) );
        assertTrue( "TV: Link(s) should not exist here", links == null );

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
     *     Two partitions with an element B and an inconsistent element C,
     *     no links.
     * 
     *     ------  ------
     *     | C1 |  | C2 |
     *     |    |  |    |
     *     | B1 |  |    |
     *     ------  ------
     * 
     * Test Action: 
     *    addLink(C1 -> B1)
     *    
     * Test Verification: 
     *    Index should not contain the cross link Link(C2->B) and not the 
     *    intra-partition link Link(C1->B)
     * </pre>
     */
    @Test
    @IndexOnly
    public void testAddLink_2P_DoubleStorageSingleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException, InterruptedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        // clear PartitionA
        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "IconsistencyTest.al2pdsso.Partition1" );
        mp1.deleteElements( );

        saveConnectionOne( );

        C2 c1 = createC2( );
        mp1.assignElement( c1 );
        MRI mriC1 = ( (Partitionable) c1 ).get___Mri( );
        saveConnectionOne( );

        byte[] mp1Xmi = this.getPartitionByteArray( mp1 );

        TestClient client = this._testClient1;

        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.al2pdsso.Partition2", mp1Xmi, client );

        B2 b1 = createB2( );
        mp1.assignElement( b1 );
        MRI mriB1 = ( (Partitionable) b1 ).get___Mri( );
        saveConnectionOne( );

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );

        Object cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated element in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct", ( (Object[]) cs ).length == 2 );

        Object bs = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", bs != null );
        assertTrue( "SV: IndexModelElement expected for single element", bs instanceof IndexModelElement );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        // add link C1->B1
        c1.setB( (B2) this.getConnectionOne( ).getElement( mriB1 ) );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        cs = this.getMofIdToElements( mriC1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing duplicated element in index", cs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", cs instanceof Object[] );
        assertTrue( "TV: Duplicate element number not correct", ( (Object[]) cs ).length == 2 );

        bs = this.getMofIdToElements( mriB1.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", bs != null );
        assertTrue( "TV: IndexModelElement expected for single element", bs instanceof IndexModelElement );

        // check if there are links stored at C2
        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: Link(s) should not exist here", linksMp1 == null );
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "TV: Link(s) should not exist here", linksMp2 == null );

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
     *     Three partitions with three inconsistent elements B and two elements C,
     *     no links.
     * 
     *     ------  ------  ------
     *     |    |  | C2 |  | C3 |
     *     |    |  |    |  |    |
     *     | B1 |  | B2 |  | B3 |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    addLink(C2 -> B3)
     *    
     * Test Verification: 
     *    Index should not contain any cross link Link(Cx->Bx) and no 
     *    intra-partition link Link(Cx->Bx)
     * </pre>
     */
    @Test
    @IndexOnly
    public void testAddLink_3P_DoubleStorageTrippleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        TestClient client = this._testClient1;

        // clear PartitionA
        ModelPartition mp3 = this._testClient1.getOrCreatePartition( "IconsistencyTest.al3pdsto.Partition3" );
        mp3.deleteElements( );

        saveConnectionOne( );

        B2 b3 = createB2( );
        mp3.assignElement( b3 );
        MRI mriB3 = ( (Partitionable) b3 ).get___Mri( );
        saveConnectionOne( );

        byte[] mp3Xmi = this.getPartitionByteArray( mp3 );
        ModelPartition mp1 = this.createDuplicatePartition( "IconsistencyTest.al3pdsto.Partition1", mp3Xmi, client );

        C2 c3 = createC2( );
        mp3.assignElement( c3 );
        MRI mriC3 = ( (Partitionable) c3 ).get___Mri( );
        saveConnectionOne( );

        mp3Xmi = this.getPartitionByteArray( mp3 );
        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.al3pdsto.Partition2", mp3Xmi, client );

        C2 c2 = null;
        for ( Iterator<Partitionable> itP = mp2.getElements( ).iterator( ); itP.hasNext( ); ) {
            Partitionable elem = itP.next( );
            if ( elem instanceof C2 ) {
                c2 = (C2) elem;
            }
        }

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: Failed to get element from copied partition (C2)", c2 != null );

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( mriB3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) bs ).length + " instead of 3", ( (Object[]) bs ).length == 3 );

        Object cs = this.getMofIdToElements( mriC3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) cs ).length + " instead of 2", ( (Object[]) cs ).length == 2 );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        // add link C2->B3
        c2.setB( (B2) this.getConnectionOne( ).getElement( mriB3 ) );
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

        bs = this.getMofIdToElements( mriB3.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing duplicated elements in index", bs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "TV: Duplicate element number not correct. " + ( (Object[]) bs ).length + " instead of 3", ( (Object[]) bs ).length == 3 );

        cs = this.getMofIdToElements( mriC3.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing duplicated elements in index", cs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", cs instanceof Object[] );
        assertTrue( "TV: Duplicate element number not correct. " + ( (Object[]) cs ).length + " instead of 2", ( (Object[]) cs ).length == 2 );

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
     *     Three partitions with three inconsistent elements C and two elements B,
     *     no links.
     * 
     *     ------  ------  ------
     *     | C1 |  | C2 |  | C3 |
     *     |    |  |    |  |    |
     *     |    |  | B2 |  | B3 |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    addLink(C2 -> B3)
     *    
     * Test Verification: 
     *    Index should contain no link
     * </pre>
     */
    @Test
    @IndexOnly
    public void testAddLink_3P_TrippleStorageDoubleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        TestClient client = this._testClient1;

        ModelPartition mp3 = this._testClient1.getOrCreatePartition( "IconsistencyTest.al3ptsdo.Partition3" );
        mp3.deleteElements( );

        saveConnectionOne( );

        C2 c3 = createC2( );
        mp3.assignElement( c3 );
        MRI mriC3 = ( (Partitionable) c3 ).get___Mri( );
        saveConnectionOne( );

        byte[] mp3Xmi = this.getPartitionByteArray( mp3 );
        ModelPartition mp1 = this.createDuplicatePartition( "IconsistencyTest.al3ptsdo.Partition1", mp3Xmi, client );

        B2 b3 = createB2( );
        mp3.assignElement( b3 );
        MRI mriB3 = ( (Partitionable) b3 ).get___Mri( );
        saveConnectionOne( );

        mp3Xmi = this.getPartitionByteArray( mp3 );
        ModelPartition mp2 = this.createDuplicatePartition( "IconsistencyTest.al2pdsso.Partition2", mp3Xmi, client );

        C2 c2 = null;
        for ( Iterator<Partitionable> itP = mp2.getElements( ).iterator( ); itP.hasNext( ); ) {
            Partitionable elem = itP.next( );
            if ( elem instanceof C2 ) {
                c2 = (C2) elem;
            }
        }

        // ###### End Prepare Starting Scenario ######
        // ###########################################

        // ###################################
        // ###### Start Verify Scenario ######

        assertTrue( "SV: Failed to get element from copied partition (C2)", c2 != null );

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

        Object bs = this.getMofIdToElements( mriB3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) bs ).length + " instead of 2", ( (Object[]) bs ).length == 2 );

        Object cs = this.getMofIdToElements( mriC3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) cs ).length + " instead of 3", ( (Object[]) cs ).length == 3 );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        // add link C2->B3
        c2.setB( (B2) this.getConnectionOne( ).getElement( mriB3 ) );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );

        bs = this.getMofIdToElements( mriB3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) bs ).length + " instead of 2", ( (Object[]) bs ).length == 2 );

        cs = this.getMofIdToElements( mriC3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) cs ).length + " instead of 3", ( (Object[]) cs ).length == 3 );

        // check if the only link exists in the first partition and that all
        // other partitions still do not have any links
        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: A link should not exist here", linksMp1 == null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

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
     *     Three partitions with two inconsistent elements B and one element C,
     *     no links.
     * 
     *     ------  ------  ------
     *     |    |  | C2 |  |    |
     *     |    |  |    |  |    |
     *     | B1 |  |    |  | B3 |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    addLink(C2 -> B3)
     *    
     * Test Verification: 
     *    Index should contain exactly one link Link(C2->B)
     * </pre>
     */
    @Test
    @IndexOnly
    public void testAddLink_3P_SingleStorageDoubleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        TestClient client = this._testClient1;

        ModelPartition mp3 = this._testClient1.getOrCreatePartition( "IconsistencyTest.al3pssdo.Partition3" );
        mp3.deleteElements( );

        saveConnectionOne( );

        B2 b3 = createB2( );
        mp3.assignElement( b3 );
        MRI mriB3 = ( (Partitionable) b3 ).get___Mri( );
        saveConnectionOne( );

        byte[] mp3Xmi = this.getPartitionByteArray( mp3 );
        ModelPartition mp1 = this.createDuplicatePartition( "IconsistencyTest.al3pssdo.Partition1", mp3Xmi, client );

        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTest.al3pssdo.Partition2" );
        mp2.deleteElements( );

        saveConnectionOne( );

        C2 c2 = createC2( );
        mp2.assignElement( c2 );
        MRI mriC2 = ( (Partitionable) c2 ).get___Mri( );
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

        Object cs = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", cs != null );
        assertTrue( "SV: ArrayList expected for single element", cs instanceof IndexModelElement );

        Object bs = this.getMofIdToElements( mriB3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) bs ).length + " instead of 2", ( (Object[]) bs ).length == 2 );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        // add link C2->B3
        c2.setB( (B2) this.getConnectionOne( ).getElement( mriB3 ) );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "SV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );

        cs = this.getMofIdToElements( mriC2.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", cs != null );
        assertTrue( "SV: ArrayList expected for single element", cs instanceof IndexModelElement );

        bs = this.getMofIdToElements( mriB3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", bs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", bs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) bs ).length + " instead of 2", ( (Object[]) bs ).length == 2 );

        assertTrue( "SV: " + mp1.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp1.getPri( ).toString( ) ) == null );
        List<IndexLinkRecord> linksMp2 = this.getPriToLinkRecords( mp2.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp2 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp2.size( ) + " instead of 1", linksMp2.size( ) == 1 );
        IndexLinkRecord lr = linksMp2.get( 0 );
        assertTrue( "LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp2.getPri( ).toString( ) );
        assertTrue( "LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB3.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC2.getLri( ).getMofId( ) ) );
        assertTrue( "LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB3.getDataAreaDescriptor( ).getDataAreaName( ) );
        assertTrue( "SV: " + mp3.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp3.getPri( ).toString( ) ) == null );

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
     *     Three partitions with two inconsistent elements B and one element C,
     *     no links.
     * 
     *     ------  ------  ------
     *     | C1 |  |    |  | C3 |
     *     |    |  |    |  |    |
     *     |    |  | B2 |  |    |
     *     ------  ------  ------
     * 
     * Test Action: 
     *    addLink(C3 -> B2)
     *    
     * Test Verification: 
     *    Index should contain the link Link(C3->B)
     * </pre>
     */
    @Test
    @IndexOnly
    public void testAddLink_3P_DoubleStorageSingleOther( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // #############################################
        // ###### Start Prepare Starting Scenario ######

        TestClient client = this._testClient1;

        ModelPartition mp3 = this._testClient1.getOrCreatePartition( "IconsistencyTest.al3pdsso.Partition3" );
        mp3.deleteElements( );

        saveConnectionOne( );

        C2 c3 = createC2( );
        mp3.assignElement( c3 );
        MRI mriC3 = ( (Partitionable) c3 ).get___Mri( );
        saveConnectionOne( );

        byte[] mp3Xmi = this.getPartitionByteArray( mp3 );
        ModelPartition mp1 = this.createDuplicatePartition( "IconsistencyTest.al3pdsso.Partition1", mp3Xmi, client );

        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "IconsistencyTest.al3pdsso.Partition2" );
        mp2.deleteElements( );

        saveConnectionOne( );

        B2 b2 = createB2( );
        mp2.assignElement( b2 );
        MRI mriB2 = ( (Partitionable) b2 ).get___Mri( );
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

        Object bs = this.getMofIdToElements( mriB2.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing single element in index", bs != null );
        assertTrue( "SV: ArrayList expected for single element", bs instanceof IndexModelElement );

        Object cs = this.getMofIdToElements( mriC3.getLri( ).getMofId( ) );
        assertTrue( "SV: Missing duplicated elements in index", cs != null );
        assertTrue( "SV: ArrayList expected for duplicate elements", cs instanceof Object[] );
        assertTrue( "SV: Duplicate element number not correct. " + ( (Object[]) cs ).length + " instead of 2", ( (Object[]) cs ).length == 2 );

        // ###### End Verify Scenario ######
        // #################################

        // ###############################
        // ###### Start Test Action ######

        // add link C3->B2
        c3.setB( (B2) this.getConnectionOne( ).getElement( mriB2 ) );
        saveConnectionOne( );

        // ###### End Test Action ######
        // #############################

        // ####################################
        // ###### Start Test Verification ######

        assertTrue( "TV: " + mp1.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp1.getPri( ) ) );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp2.getPri( ) ) );
        assertTrue( "TV: " + mp3.getPri( ).toString( ) + " not indexed", this.isPartitionIndexed( mp3.getPri( ) ) );

        bs = this.getMofIdToElements( mriB2.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing single element in index", bs != null );
        assertTrue( "TV: ArrayList expected for single element", bs instanceof IndexModelElement );

        cs = this.getMofIdToElements( mriC3.getLri( ).getMofId( ) );
        assertTrue( "TV: Missing duplicated elements in index", cs != null );
        assertTrue( "TV: ArrayList expected for duplicate elements", cs instanceof Object[] );
        assertTrue( "TV: Duplicate element number not correct. " + ( (Object[]) cs ).length + " instead of 2", ( (Object[]) cs ).length == 2 );

        List<IndexLinkRecord> linksMp1 = this.getPriToLinkRecords( mp1.getPri( ).toString( ) );
        assertTrue( "TV: A link should not exist here", linksMp1 == null );
        assertTrue( "TV: " + mp2.getPri( ).toString( ) + " contains links", this.getPriToLinkRecords( mp2.getPri( ).toString( ) ) == null );
        List<IndexLinkRecord> linksMp3 = this.getPriToLinkRecords( mp3.getPri( ).toString( ) );
        assertTrue( "TV: A link should exist here", linksMp3 != null );
        assertTrue( "TV: Number of Links wrong. " + linksMp3.size( ) + " instead of 1", linksMp3.size( ) == 1 );
        IndexLinkRecord lr = linksMp3.get( 0 );
        assertTrue( "TV: LinkRecord wrong. (PRI)", lr.idxPri.getPriString( ) == mp3.getPri( ).toString( ) );
        assertTrue( "TV: LinkRecord wrong. (ExtMofId)", lr.mofIdOfExternalEnd.toString( ).equals( mriB2.getLri( ).getMofId( ) ) );
        assertTrue( "TV: LinkRecord wrong. (LocalMofId)", lr.mofIdOfLocalEnd.toString( ).equals( mriC3.getLri( ).getMofId( ) ) );
        assertTrue( "TV: LinkRecord wrong. (DataAreaName)", lr.dataAreaOfExternalEnd == mriB2.getDataAreaDescriptor( ).getDataAreaName( ) );

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
