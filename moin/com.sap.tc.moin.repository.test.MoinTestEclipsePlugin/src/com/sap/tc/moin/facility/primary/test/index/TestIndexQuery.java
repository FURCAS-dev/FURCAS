package com.sap.tc.moin.facility.primary.test.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DuplicateElementException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;

public class TestIndexQuery extends IndexTestCase {

    protected SpiCoreQueryService query;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.query = (SpiCoreQueryService) super.index;

        ModelPartition mp = this._testClient1.getOrCreatePartition( "InconsistencyTestSetup" );

        for ( Partitionable element : this.getConnectionOne( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }

        this.saveConnectionOne( );
        super.deleteAllNonMetamodelsFromIndex( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    /**
     * <pre>
     * Tests the getPartitionsInDc() method of the Query interface
     * 
     * </pre>
     */
    @IndexOnly
    @Test
    public void testGetPartitionsInDc( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.getPartitionsInDc.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "QueryTest.getPartitionsInDc.Partition2" );

        this.saveConnectionOne( );

        String daName = mp1.getPri( ).getDataAreaDescriptor( ).getDataAreaName( );
        String dcName = mp1.getPri( ).getContainerName( );
        String wrongDaName = daName + "a";
        String wrongDcName = dcName + "b";

        Collection<PRI> pris = this.query.getPartitionsInContainer( this.localClientSpecs[0], mp1.getPri( ).getCri( ) );
        assertTrue( "PRIs not found for DA=" + daName + ", DC=" + dcName, !pris.isEmpty( ) );
        assertTrue( "Wrong number of PRIs in container (exp: 2, is: " + pris.size( ), pris.size( ) == 2 );

        CRI rightDaRightDc = mp1.getPri( ).getCri( );
        CRI wrongDaRightDc = getTestHelper( ).getFacility( PrimaryFacility.FACILITY_ID ).getRIFactory( ).createCri( wrongDaName, dcName );
        CRI rightDaWrongDc = getTestHelper( ).getFacility( PrimaryFacility.FACILITY_ID ).getRIFactory( ).createCri( daName, wrongDcName );
        CRI wrongDaWrongDc = getTestHelper( ).getFacility( PrimaryFacility.FACILITY_ID ).getRIFactory( ).createCri( wrongDaName, wrongDcName );

        pris = this.query.getPartitionsInContainer( this.localClientSpecs[0], wrongDaRightDc );
        assertTrue( "PRIs found for DA=" + wrongDaName + ", DC=" + dcName, pris.isEmpty( ) );

        pris = this.query.getPartitionsInContainer( this.localClientSpecs[0], rightDaWrongDc );
        assertTrue( "PRIs found for DA=" + daName + ", DC=" + wrongDaName, pris.isEmpty( ) );

        pris = this.query.getPartitionsInContainer( this.localClientSpecs[0], wrongDaWrongDc );
        assertTrue( "PRIs found for DA=" + wrongDaName + ", DC=" + wrongDcName, pris.isEmpty( ) );

        mp2.delete( );
        this.saveConnectionOne( );

        assertTrue( "Number of pris wrong", this.query.getPartitionsInContainer( this.localClientSpecs[0], rightDaRightDc ).size( ) == 1 );

        mp1.delete( );
        this.saveConnectionOne( );

        assertTrue( "Partition still in index", this.query.getPartitionsInContainer( this.localClientSpecs[0], rightDaRightDc ).isEmpty( ) );

    }

    /**
     * Tests the getReferrers() method of the Query interface
     */
    @Test
    @IndexOnly
    public void testGetReferringPartitions( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.getElementForEAM.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "QueryTest.getElementForEAM.Partition2" );

        mp1.deleteElements( );
        mp2.deleteElements( );

        C2 c2 = this.createC2( );
        C2 c2_2 = this.createC2( );
        B2 b2 = this.createB2( );
        B2 b2_2 = this.createB2( );
        mp1.assignElement( c2 );
        mp2.assignElement( b2 );
        mp1.assignElement( c2_2 );
        mp2.assignElement( b2_2 );
        c2.setB( b2 );
        c2_2.setB( b2_2 );

        MRI c2mri = ( (Partitionable) c2 ).get___Mri( );
        MRI b2mri = ( (Partitionable) b2 ).get___Mri( );

        this.saveConnectionOne( );

        Collection<PRI> coll1 = this.query.getReferringPartitions( this.localClientSpecs, c2mri );
        Collection<PRI> coll2 = this.query.getReferringPartitions( this.localClientSpecs, b2mri );

        assertTrue( "Index returns not the expected one value", coll1.size( ) == 0 );
        assertTrue( "Index returns not the expected one value", coll2.size( ) == 1 );

        PRI retPri2 = coll2.iterator( ).next( );
        assertSame( "MRIs are not the same", retPri2, c2mri.getPri( ) );

        mp1.delete( );
        mp2.delete( );
        this.saveConnectionOne( );
    }

    @Test
    @IndexOnly
    public void testGetReferringPartitions_MetamodelEdited( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        this.deleteAllNonMetamodelsFromIndex( );
        MRI extSecondMri = this.getExtSecond( );
        MRI firstMri = this.getFirst( );
        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );

        // test retrieval from extMofIdToLR table
        Collection<PRI> pris = this.query.getReferringPartitions( this.metamodelClientSpecs, firstMri );
        assertTrue( "Number of elements wrong (expected 1, was " + pris.size( ), pris.size( ) == 0 );

        // test retrieval from localMofIdToLR table
        pris = this.query.getReferringPartitions( this.metamodelClientSpecs, extSecondMri );
        assertTrue( "Number of elements wrong (expected 1, was " + pris.size( ), pris.size( ) == 1 );
        assertTrue( "Retrieved element wrong", pris.contains( firstMri.getPri( ) ) );

        pris = this.query.getReferringPartitions( this.localClientSpecs, firstMri );
        assertTrue( "Number of elements wrong (expected 1, was " + pris.size( ), pris.size( ) == 0 );

        pris = this.query.getReferringPartitions( this.localClientSpecs, extSecondMri );
        assertTrue( "Number of elements wrong (expected 1, was " + pris.size( ), pris.size( ) == 1 );
        assertTrue( "Retrieved element wrong", !pris.contains( firstMri.getPri( ) ) );
    }

    /**
     * Tests the getTopLevelPackages() method of the Query interface.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    // @Test
    @IndexOnly
    public void testGetTopLevelPackages( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        //
        // Collection<IndexPri> prisToRemove = this.index.getPriToIndexPri().values();
        // for (IndexPri pri : prisToRemove) {
        // this.index.removePartition(pri.getCachedPri());
        // }
        //
        // assertTrue("There are still (meta-)models in the index",
        // index.getPriToIndexPri().isEmpty());
        // assertTrue("Top level packages found",
        // index.getTopLevelPackages(null).isEmpty());
        //
        // ArrayList<PRI> mmPris = this.getMetamodelPris();
        //
        // long[] timestamps = new long[mmPris.size()];
        //
        // index.synchronize(IndexManagement.SyncKind.METAMODEL_CONTENT,
        // mmPris.toArray(new PRI[mmPris.size()]),
        // timestamps, this.getStreamProvider());
        //
        // assertTrue("There are no (meta-)models in the index",
        // !index.getPriToIndexPri().isEmpty());
        // int countMM = index.getTopLevelPackages(null).size();
        // assertTrue("No top level packages found", countMM != 0);
        //
        // assertTrue("Number for UML metamodel wrong",
        // index.getTopLevelPackages("UML").size() == 1);
    }

    /**
     * Tests the getElementForEndAndMetaobject() method of the Query interface.<br>
     * <br>
     * Needs to be extended to test retrieval for different data areas.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    @IndexOnly
    public void testGetReferringElementsForEndAndMetaobject( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.getElementForEAM.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "QueryTest.getElementForEAM.Partition2" );

        mp1.deleteElements( );
        mp2.deleteElements( );

        C2 c2 = this.createC2( );
        C2 c2_2 = this.createC2( );
        B2 b2 = this.createB2( );
        B2 b2_2 = this.createB2( );
        mp1.assignElement( c2 );
        mp2.assignElement( b2 );
        mp1.assignElement( c2_2 );
        mp2.assignElement( b2_2 );
        c2.setB( b2 );
        c2_2.setB( b2_2 );

        MRI c2mri = ( (Partitionable) c2 ).get___Mri( );
        MRI b2mri = ( (Partitionable) b2 ).get___Mri( );
        MRI assoc = ( (Partitionable) this.case002Package.getAreferencesB( ).refMetaObject( ) ).get___Mri( );
        MRI wrongAssoc = ( (Partitionable) this.testcasesPackage.getCase001( ).getAreferencesB( ).refMetaObject( ) ).get___Mri( );

        this.saveConnectionOne( );

        Collection<MRI> coll1 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, assoc, c2mri, 0 );
        Collection<MRI> coll2 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, assoc, c2mri, 1 );
        Collection<MRI> coll3 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, assoc, b2mri, 0 );
        Collection<MRI> coll4 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, assoc, b2mri, 1 );

        Collection<MRI> coll5 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, wrongAssoc, c2mri, 0 );
        Collection<MRI> coll6 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, wrongAssoc, c2mri, 1 );
        Collection<MRI> coll7 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, wrongAssoc, b2mri, 0 );
        Collection<MRI> coll8 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, wrongAssoc, b2mri, 1 );

        MRI unknownAssoc = wrongAssoc.getPri( ).createMri( fakeMofId );
        Collection<MRI> coll9 = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, unknownAssoc, b2mri, 0 );

        assertTrue( "Index returns unexpected values", coll1.size( ) == 0 );
        assertTrue( "Index returns not the expected one value", coll2.size( ) == 0 );
        assertTrue( "Index returns not the expected one value", coll3.size( ) == 1 );
        assertTrue( "Index returns unexpected values", coll4.size( ) == 0 );

        assertTrue( "Index returns unexpected values", coll5.size( ) == 0 );
        assertTrue( "Index returns unexpected values", coll6.size( ) == 0 );
        assertTrue( "Index returns unexpected values", coll7.size( ) == 0 );
        assertTrue( "Index returns unexpected values", coll8.size( ) == 0 );

        assertTrue( "Index returns unexpected values", coll9.size( ) == 0 );

        MRI retMri2 = coll3.iterator( ).next( );
        assertSame( "MRIs are not the same", retMri2, c2mri );

        mp1.delete( );
        mp2.delete( );
        this.saveConnectionOne( );
    }

    /**
     * Test the client spec filter of the getElementForEndAndMetaobject() method
     * of the Query interface. Therefore we use a metamodel that is deployed and
     * in editing mode.
     */
    @Test
    @IndexOnly
    public void testGetReferringElementsForEndAndMetaobject_MetamodelEdited( ) throws PartitionsNotSavedException {

        this.deleteAllNonMetamodelsFromIndex( );

        MRI firstMri = this.getFirst( );
        MRI extsecondMri = this.getExtSecond( );
        MRI assoctypeMri = this.getAssocType( );

        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );

        Collection<MRI> res = this.query.getReferringElementsForEndAndMetaobject( this.metamodelClientSpecs, assoctypeMri, firstMri, 0 );
        assertTrue( "Number of results wrong (expected 1, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.metamodelClientSpecs, assoctypeMri, extsecondMri, 1 );
        assertTrue( "Number of results wrong (expected 1, was " + res.size( ) + ")", res.size( ) == 1 );
        assertTrue( "expected element not in result set", res.contains( firstMri ) );

        res = this.query.getReferringElementsForEndAndMetaobject( this.metamodelClientSpecs, assoctypeMri, firstMri, 1 );
        assertTrue( "Number of results wrong (expected 0, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.metamodelClientSpecs, assoctypeMri, extsecondMri, 0 );
        assertTrue( "Number of results wrong (expected 0, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, assoctypeMri, firstMri, 0 );
        assertTrue( "Number of results wrong (expected 0, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, assoctypeMri, firstMri, 1 );
        assertTrue( "Number of results wrong (expected 0, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, assoctypeMri, extsecondMri, 1 );
        assertTrue( "Number of results wrong (expected 0, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.localClientSpecs, assoctypeMri, extsecondMri, 0 );
        assertTrue( "Number of results wrong (expected 0, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.allClientSpecs, assoctypeMri, extsecondMri, 1 );
        assertTrue( "Number of results wrong (expected 1, was " + res.size( ) + ")", res.size( ) == 1 );
        assertTrue( "expected element not in result set", res.contains( firstMri ) );

        res = this.query.getReferringElementsForEndAndMetaobject( this.allClientSpecs, assoctypeMri, firstMri, 0 );
        assertTrue( "Number of results wrong (expected 1, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.allClientSpecs, assoctypeMri, firstMri, 1 );
        assertTrue( "Number of results wrong (expected 0, was " + res.size( ) + ")", res.size( ) == 0 );

        res = this.query.getReferringElementsForEndAndMetaobject( this.allClientSpecs, assoctypeMri, extsecondMri, 0 );
        assertTrue( "Number of results wrong (expected 0, was " + res.size( ) + ")", res.size( ) == 0 );
    }

//    /**
//     * Tests the getInstances() method of the Query interface.<br>
//     * <br>
//     * Needs to be extended to test retrieval for different data areas.
//     * 
//     * @throws NullPartitionNotEmptyException
//     * @throws ReferencedTransientElementsException
//     * @throws PartitionsNotSavedException
//     */
//    @Test
//    @IndexOnly
//    public void testGetInstances( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {
//
//        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.getInstances.Partition1" );
//        mp1.deleteElements( );
//        this.saveConnectionOne( );
//
//        C2 c1 = this.createC2( );
//        C2 c2 = this.createC2( );
//        C2 c3 = this.createC2( );
//        mp1.assignElement( c1 );
//        mp1.assignElement( c2 );
//        mp1.assignElement( c3 );
//
//        B2 b1 = this.createB2( );
//        mp1.assignElement( b1 );
//
//        this.saveConnectionOne( );
//
//        MRI c2MMri = ( (Partitionable) this.case002Package.getC2( ).refMetaObject( ) ).get___Mri( );
//        MRI b2MMri = ( (Partitionable) this.case002Package.getB2( ).refMetaObject( ) ).get___Mri( );
//
//        Collection<MRI> c2instances = this.query.getInstances( this.localClientSpecs, new MRI[] { c2MMri } );
//        Collection<MRI> b2instances = this.query.getInstances( this.localClientSpecs, new MRI[] { b2MMri } );
//
//        assertTrue( "No C2 instances found", !c2instances.isEmpty( ) );
//        assertTrue( "Number of C2 instances wrong", c2instances.size( ) == 3 );
//        assertTrue( "No B2 instances found", !b2instances.isEmpty( ) );
//        assertTrue( "Number of B2 instances wrong", b2instances.size( ) == 1 );
//
//        c1.refDelete( );
//        b1.refDelete( );
//
//        this.saveConnectionOne( );
//
//        c2instances = this.query.getInstances( this.localClientSpecs, new MRI[] { c2MMri } );
//        b2instances = this.query.getInstances( this.localClientSpecs, new MRI[] { b2MMri } );
//
//        assertTrue( "No C2 instances found", !c2instances.isEmpty( ) );
//        assertTrue( "Number of C2 instances wrong", c2instances.size( ) == 2 );
//        assertTrue( "B2 instances found", b2instances.isEmpty( ) );
//    }
//
//    @Test
//    @IndexOnly
//    public void testGetInstances_MetamodelEdited( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {
//
//        this.deleteAllNonMetamodelsFromIndex( );
//        MRI firstMri = this.getFirst( );
//        MRI firsttypeMri = this.getFirstType( );
//
//        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );
//
//        MRI[] typeMris = new MRI[] { firsttypeMri };
//
//        Collection<MRI> instances = this.query.getInstances( this.metamodelClientSpecs, typeMris );
//        assertTrue( "Result does not contain expected MRI: " + firstMri.toString( ), instances.contains( firstMri ) );
//
//        instances = this.query.getInstances( this.localClientSpecs, typeMris );
//        assertFalse( "Result does contain unexpected MRI: " + firstMri.toString( ), instances.contains( firstMri ) );
//    }

    /**
     * Tests the getPriForLri() method of the Query interface.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    @IndexOnly
    public void testGetPriForLri( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.getPriForLri.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "QueryTest.getPriForLri.Partition2" );
        mp1.deleteElements( );
        mp2.deleteElements( );
        this.saveConnectionOne( );

        C2 c1 = this.createC2( );
        C2 c2 = this.createC2( );
        C2 c3 = this.createC2( );
        mp1.assignElement( c1 );
        mp1.assignElement( c2 );
        mp2.assignElement( c3 );

        B2 b1 = this.createB2( );
        mp2.assignElement( b1 );

        LRI c1Lri = ( (Partitionable) c1 ).get___Mri( ).getLri( );
        LRI b1Lri = ( (Partitionable) b1 ).get___Mri( ).getLri( );

        this.saveConnectionOne( );

        Collection<ClientSpec> clientSpecsAsCollection = getConnectionOne( ).getSession( ).getCompoundClientSpec( ).getClientSpecs( );
        ClientSpec[] clientSpecs = clientSpecsAsCollection.toArray( new ClientSpec[clientSpecsAsCollection.size( )] );
        PRI mp1Pri = this.query.getPriForLri( clientSpecs, c1Lri );
        PRI mp2Pri = this.query.getPriForLri( clientSpecs, b1Lri );

        assertTrue( "No PRI for element", mp1Pri != null );
        assertTrue( "No PRI for element", mp2Pri != null );
        assertTrue( "PRI does not match", mp1Pri.toString( ) == mp1.getPri( ).toString( ) );
        assertTrue( "PRI does not match", mp2Pri.toString( ) == mp2.getPri( ).toString( ) );

        c1.refDelete( );
        this.saveConnectionOne( );

        mp1Pri = this.query.getPriForLri( clientSpecs, c1Lri );
        assertTrue( "PRI found for element", mp1Pri == null );

        ModelPartition mp2Copy = this.createDuplicatePartition( "getPriForLriCopy", this.getPartitionByteArray( mp2 ), this._testClient1 );

        try {
            this.query.getPriForLri( clientSpecs, b1Lri );
            fail( "Expected DuplicateElementException" );
        } catch ( DuplicateElementException e ) {
            List<PRI> pris = new ArrayList<PRI>( 2 );
            pris.add( mp2Copy.getPri( ) );
            pris.add( mp2.getPri( ) );
            assertTrue( "Wrong number of MRIs in exception (expected 2, was " + e.getMris( ).size( ) + ")", e.getMris( ).size( ) == 2 );
            for ( MRI mri : e.getMris( ) ) {
                assertTrue( "Unexpected MRI: " + mri.toString( ), pris.contains( mri.getPri( ) ) );
            }
        }

        mp1.delete( );
        mp2.delete( );
        mp2Copy.delete( );
        this.saveConnectionOne( );
    }

    @Test
    @IndexOnly
    public void testGetPriForLri_MetamodelEdited( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        this.deleteAllNonMetamodelsFromIndex( );
        MRI firstMri = this.getFirst( );
        LRI firstLri = firstMri.getLri( );
        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );

        try {
            PRI pri = this.query.getPriForLri( this.metamodelClientSpecs, firstLri );
            assertTrue( "PRI wrong (expected " + firstMri.getPri( ).toString( ) + ", was " + pri.toString( ) + ")", pri == firstMri.getPri( ) );
        } catch ( DuplicateElementException e ) {
            fail( "Unexpected duplicate element: " + e.getMris( ).toString( ) );
        }

        // clientspec should be uninteresting
        try {
            PRI pri = this.query.getPriForLri( this.localClientSpecs, firstLri );
            assertTrue( "PRI wrong (expected " + firstMri.getPri( ).toString( ) + ", was " + pri.toString( ) + ")", pri == firstMri.getPri( ) );
        } catch ( DuplicateElementException e ) {
            fail( "Unexpected duplicate element: " + e.getMris( ).toString( ) );
        }
    }

    @Test
    @IndexOnly
    public void testIsPartitionExistent( ) {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "QueryTest.ipe.Partition" );
        mp.deleteElements( );
        this.saveConnectionOne( );

        PRI pri = mp.getPri( );

        ClientSpec clientSpec = getConnectionOne( ).getSession( ).getCompoundClientSpec( ).getClientSpec( mp.getPri( ).getDataAreaDescriptor( ) );
        assertTrue( "Expected true", this.query.isPartitionExistent( clientSpec, pri ) );

        mp.delete( );
        this.saveConnectionOne( );

        assertFalse( "Expected false", this.query.isPartitionExistent( clientSpec, pri ) );
    }

    @Test
    public void testHasCrossPartitionLinks( ) throws Exception {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "hasCrossPartitionLinks1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "hasCrossPartitionLinks2" );
        PRI pri1 = mp1.getPri( );
        PRI pri2 = mp2.getPri( );
        mp1.deleteElements( );
        mp2.deleteElements( );
        saveConnectionOne( );

        this.checkCrossLinks( pri1, pri2, false );

        // single element in one partition
        C2 c2 = this.createC2( );
        mp1.assignElement( c2 );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri2, false );

        // two disconnected elements in one partition
        B2 b2 = this.createB2( );
        mp1.assignElement( b2 );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri2, false );

        // two linked partitions in one partition
        c2.setB( b2 );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri2, false );

        // duplicate partitions
        ModelPartition mp1inc = this.createDuplicatePartition( "p1inc", this.getPartitionByteArray( mp1 ), _testClient1 );
        PRI pri1inc = mp1inc.getPri( );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri1inc, false );
        mp1inc.delete( );
        saveConnectionOne( );

        // two unlinked elements in two partitions
        c2.refDelete( );
        C2 newC2 = this.createC2( );
        mp2.assignElement( newC2 );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri2, false );

        // two linked elements in two partitions
        newC2.setB( b2 );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri2, true );

        // duplicate partitions
        ModelPartition mp1clone = this.createDuplicatePartition( "p1clone", this.getPartitionByteArray( mp1 ), _testClient1 );
        ModelPartition mp2clone = this.createDuplicatePartition( "p2clone", this.getPartitionByteArray( mp2 ), _testClient1 );
        PRI pri1clone = mp1clone.getPri( );
        PRI pri2clone = mp2clone.getPri( );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri1clone, false );
        this.checkCrossLinks( pri1clone, pri2clone, true );
        this.checkCrossLinks( pri1, pri2clone, true );

        // test inconsistent partitions
        mp1.deleteElements( );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri2, false );

        // delete one partition
        mp1.delete( );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri2, false );
        this.checkCrossLinks( pri1clone, pri2clone, true );

        // delete the second partition
        mp2.delete( );
        saveConnectionOne( );
        this.checkCrossLinks( pri1, pri2, false );
        this.checkCrossLinks( pri1clone, pri2clone, true );

        mp1clone.delete( );
        mp2clone.delete( );
        saveConnectionOne( );
    }

    private void checkCrossLinks( PRI pri1, PRI pri2, boolean result ) {

        assertFalse( "", this.query.hasCrossPartitionLinks( this.localClientSpecs[0], pri1, this.localClientSpecs[0], pri1 ) );
        assertFalse( "", this.query.hasCrossPartitionLinks( this.localClientSpecs[0], pri2, this.localClientSpecs[0], pri2 ) );
        assertTrue( "Query result is not " + result, this.query.hasCrossPartitionLinks( this.localClientSpecs[0], pri1, this.localClientSpecs[0], pri2 ) == result );
        assertTrue( "Query result differs for swapped pris", this.query.hasCrossPartitionLinks( this.localClientSpecs[0], pri1, this.localClientSpecs[0], pri2 ) == this.query.hasCrossPartitionLinks( this.localClientSpecs[0], pri2, this.localClientSpecs[0], pri1 ) );
    }
}
