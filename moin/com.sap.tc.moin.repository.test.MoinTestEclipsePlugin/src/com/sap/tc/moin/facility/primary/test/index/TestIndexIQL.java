package com.sap.tc.moin.facility.primary.test.index;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.spi.facility.SpiFacilitySlimIndexQueryService;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;
import com.sap.tc.moin.testcases.case002.D2;

public class TestIndexIQL extends IndexTestCase {

    protected SpiFacilitySlimIndexQueryService iql;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.iql = (SpiFacilitySlimIndexQueryService) super.index;

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

    @Test
    @IndexOnly
    public void testGetLinkedPartitions( ) {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "BasicQueryTest.glp.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "BasicQueryTest.glp.Partition2" );
        ModelPartition mp3 = this._testClient1.getOrCreatePartition( "BasicQueryTest.glp.Partition3" );
        ModelPartition mp4 = this._testClient1.getOrCreatePartition( "BasicQueryTest.glp.Partition4" );
        mp1.deleteElements( );
        mp2.deleteElements( );
        mp3.deleteElements( );
        mp4.deleteElements( );

        MRI assoc = ( (Partitionable) this.testcasesPackage.getCase002( ).getAreferencesB( ).refMetaObject( ) ).get___Mri( );
        MRI wrongAssoc = ( (Partitionable) this.testcasesPackage.getCase001( ).getAreferencesB( ).refMetaObject( ) ).get___Mri( );
        MRI unknownAssoc = wrongAssoc.getPri( ).createMri( fakeMofId );

        C2 c2_1 = this.createC2( );
        B2 b2_2 = this.createB2( );
        C2 c2_2 = this.createC2( );
        B2 b2_3 = this.createB2( );
        C2 c2_3 = this.createC2( );
        B2 b2_1 = this.createB2( );
        mp1.assignElement( c2_1 );
        mp1.assignElement( b2_1 );
        mp2.assignElement( c2_2 );
        mp2.assignElement( b2_2 );
        mp3.assignElement( c2_3 );
        mp3.assignElement( b2_3 );
        c2_1.setB( b2_2 );
        c2_2.setB( b2_3 );
        c2_3.setB( b2_1 );

        this.saveConnectionOne( );

        Collection<PRI> coll1 = this.iql.getLinkedPartitions( this.localQueryClientScope, mp1.getPri( ), assoc );
        Collection<PRI> coll2 = this.iql.getLinkedPartitions( this.localQueryClientScope, mp2.getPri( ), assoc );
        Collection<PRI> coll3 = this.iql.getLinkedPartitions( this.localQueryClientScope, mp3.getPri( ), assoc );

        Collection<PRI> coll4 = this.iql.getLinkedPartitions( this.localQueryClientScope, mp1.getPri( ), wrongAssoc );
        Collection<PRI> coll5 = this.iql.getLinkedPartitions( this.localQueryClientScope, mp2.getPri( ), wrongAssoc );
        Collection<PRI> coll6 = this.iql.getLinkedPartitions( this.localQueryClientScope, mp3.getPri( ), wrongAssoc );

        Collection<PRI> coll7 = this.iql.getLinkedPartitions( this.localQueryClientScope, mp4.getPri( ), assoc );
        Collection<PRI> coll8 = this.iql.getLinkedPartitions( this.localQueryClientScope, mp4.getPri( ), unknownAssoc );

        assertTrue( "Index returns wrong amount of PRIs (" + coll1.size( ) + ")", coll1.size( ) == 1 );
        assertTrue( "Index returns wrong amount of PRIs (" + coll2.size( ) + ")", coll2.size( ) == 1 );
        assertTrue( "Index returns wrong amount of PRIs (" + coll3.size( ) + ")", coll3.size( ) == 1 );

        assertTrue( "Index returns PRIs (expected none)", coll4.size( ) == 0 );
        assertTrue( "Index returns PRIs (expected none)", coll5.size( ) == 0 );
        assertTrue( "Index returns PRIs (expected none)", coll6.size( ) == 0 );

        assertTrue( "Index returns PRIs (expected none)", coll7.size( ) == 0 );
        assertTrue( "Index returns PRIs (expected none)", coll8.size( ) == 0 );

        assertSame( "PRIs are not the same", coll1.iterator( ).next( ), mp2.getPri( ) );
        assertSame( "PRIs are not the same", coll2.iterator( ).next( ), mp3.getPri( ) );
        assertSame( "PRIs are not the same", coll3.iterator( ).next( ), mp1.getPri( ) );

        mp1.delete( );
        mp2.delete( );
        mp3.delete( );
        this.saveConnectionOne( );
    }

    /**
     * tests if the filtering for client specs works in the getLinkedPartitions
     * method.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    @Test
    @IndexOnly
    public void testGetLinkedPartitions_MetamodelEdited( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        MRI firstMri = this.getFirst( );
        MRI extsecondMri = this.getExtSecond( );
        MRI assoctypeMri = this.getAssocType( );

        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );

        Object forRead = this.index.getMofIdToElements( ).getUnderlyingForRead( this.index.getMofIdFactory( ).getMofId( firstMri.getMofId( ) ) );
        assertTrue( "Expected to find two elements for mofid " + firstMri, forRead instanceof Object[] );

        Collection<PRI> pris = this.iql.getLinkedPartitions( this.metamodelQueryClientScope, firstMri.getPri( ), assoctypeMri );
        //Expected linked partitions: testcasesfoundation.moinmm, Reflect.moinmm, PrimitiveTypes.moinmm
        assertTrue( "Number of pris wrong (expected 3, was " + pris.size( ) + ")", pris.size( ) == 3 );
        assertTrue( "Expected pri not contained in result", pris.contains( extsecondMri.getPri( ) ) );
        for ( PRI pri : pris ) {
            assertTrue( "Wrong DataArea (expected " + extsecondMri.getDataAreaDescriptor( ).getDataAreaName( ) + ", was " + pri.getDataAreaDescriptor( ).getDataAreaName( ) + ")", pri.getDataAreaDescriptor( ).getDataAreaName( ) == extsecondMri.getDataAreaDescriptor( ).getDataAreaName( ) );
        }


        pris = this.iql.getLinkedPartitions( this.localQueryClientScope, firstMri.getPri( ), assoctypeMri );
        assertTrue( "expected empty result", pris.isEmpty( ) );

        //Expected linked partitions: testcasesfoundation.moinmm, Reflect.moinmm, PrimitiveTypes.moinmm
        pris = this.iql.getLinkedPartitions( this.allQueryClientScope, firstMri.getPri( ), assoctypeMri );
        assertTrue( "Number of pris wrong (expected 3, was " + pris.size( ) + ")", pris.size( ) == 3 );
        assertTrue( "Expected pri not contained in result", pris.contains( extsecondMri.getPri( ) ) );
        for ( PRI pri : pris ) {
            assertTrue( "Wrong DataArea (expected " + extsecondMri.getDataAreaDescriptor( ).getDataAreaName( ) + ", was " + pri.getDataAreaDescriptor( ).getDataAreaName( ) + ")", pri.getDataAreaDescriptor( ).getDataAreaName( ) == extsecondMri.getDataAreaDescriptor( ).getDataAreaName( ) );
        }
    }

    @Test
    @IndexOnly
    public void testGetPartitionsOfInstances( ) {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "BasicQueryTest.gpoi.Partition1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "BasicQueryTest.gpoi.Partition2" );
        ModelPartition mp3 = this._testClient1.getOrCreatePartition( "BasicQueryTest.gpoi.Partition3" );
        mp1.deleteElements( );
        mp2.deleteElements( );
        mp3.deleteElements( );

        C2 c2_1 = this.createC2( );
        C2 c2_2 = this.createC2( );
        B2 b2_2 = this.createB2( );
        B2 b2_3 = this.createB2( );
        D2 d2_1 = this._testClient1.getConnection( ).createElementInPartition( D2.class, null );

        mp1.assignElement( c2_1 );
        mp1.assignElement( d2_1 );
        mp2.assignElement( c2_2 );
        mp2.assignElement( b2_2 );
        mp3.assignElement( b2_3 );
        c2_1.setB( b2_2 );
        c2_2.setB( b2_3 );

        this.saveConnectionOne( );

        MRI c2type = ( (Partitionable) c2_1.refMetaObject( ) ).get___Mri( );
        MRI b2type = ( (Partitionable) b2_3.refMetaObject( ) ).get___Mri( );
        MRI d2type = ( (Partitionable) d2_1.refMetaObject( ) ).get___Mri( );
        MRI otherType = ( (Partitionable) this.case002Package.getE2( ).refMetaObject( ) ).get___Mri( );

        Collection<PRI> coll1 = this.iql.getPartitionsOfInstances( this.localQueryClientScope, new MRI[] { c2type } );
        Collection<PRI> coll2 = this.iql.getPartitionsOfInstances( this.localQueryClientScope, new MRI[] { b2type } );
        Collection<PRI> coll3 = this.iql.getPartitionsOfInstances( this.localQueryClientScope, new MRI[] { d2type } );
        Collection<PRI> coll4 = this.iql.getPartitionsOfInstances( this.localQueryClientScope, new MRI[] { otherType } );
        Collection<PRI> coll5 = this.iql.getPartitionsOfInstances( this.localQueryClientScope, new MRI[0] );

        assertTrue( "Index returns wrong amount of PRIs (" + coll1.size( ) + ")", coll1.size( ) == 2 );
        assertTrue( "Index returns wrong amount of PRIs (" + coll2.size( ) + ")", coll2.size( ) == 2 );
        assertTrue( "Index returns wrong amount of PRIs (" + coll3.size( ) + ")", coll3.size( ) == 1 );
        assertTrue( "Index returns wrong amount of PRIs (" + coll4.size( ) + ")", coll4.size( ) == 0 );
        assertTrue( "Index returns no PRIs (" + coll5.size( ) + ")", coll5.size( ) > 0 );

        PRI pri1 = null;
        PRI pri2 = null;
        Iterator<PRI> it = null;

        it = coll1.iterator( );
        pri1 = it.next( );
        pri2 = it.next( );
        assertTrue( "PRIs are not as expected", ( pri1 == mp1.getPri( ) && pri2 == mp2.getPri( ) ) || ( pri1 == mp2.getPri( ) && pri2 == mp1.getPri( ) ) );

        it = coll2.iterator( );
        pri1 = it.next( );
        pri2 = it.next( );
        assertTrue( "PRIs are not as expected", ( pri1 == mp3.getPri( ) && pri2 == mp2.getPri( ) ) || ( pri1 == mp2.getPri( ) && pri2 == mp3.getPri( ) ) );

        assertSame( "PRIs are not the same", coll3.iterator( ).next( ), mp1.getPri( ) );

        assertTrue( "Collection does not contain all PRIs", coll5.containsAll( Arrays.asList( mp1.getPri( ), mp2.getPri( ), mp3.getPri( ) ) ) );

        mp1.delete( );
        mp2.delete( );
        mp3.delete( );
        this.saveConnectionOne( );
    }

    /**
     * Tests the getInstances() method of the Query interface.<br>
     * <br>
     * Needs to be extended to test retrieval for different data areas.
     * 
     * @throws NullPartitionNotEmptyException
     * @throws ReferencedTransientElementsException
     * @throws PartitionsNotSavedException
     */
    @Test
    @IndexOnly
    public void testGetInstances( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "QueryTest.getInstances.Partition1" );
        mp1.deleteElements( );
        this.saveConnectionOne( );

        C2 c1 = this.createC2( );
        C2 c2 = this.createC2( );
        C2 c3 = this.createC2( );
        mp1.assignElement( c1 );
        mp1.assignElement( c2 );
        mp1.assignElement( c3 );

        B2 b1 = this.createB2( );
        mp1.assignElement( b1 );

        this.saveConnectionOne( );

        MRI c2MMri = ( (Partitionable) this.case002Package.getC2( ).refMetaObject( ) ).get___Mri( );
        MRI b2MMri = ( (Partitionable) this.case002Package.getB2( ).refMetaObject( ) ).get___Mri( );

        Collection<MRI> c2instances = this.iql.getInstances( this.localQueryClientScope, new MRI[] { c2MMri } );
        Collection<MRI> b2instances = this.iql.getInstances( this.localQueryClientScope, new MRI[] { b2MMri } );

        assertTrue( "No C2 instances found", !c2instances.isEmpty( ) );
        assertTrue( "Number of C2 instances wrong", c2instances.size( ) == 3 );
        assertTrue( "No B2 instances found", !b2instances.isEmpty( ) );
        assertTrue( "Number of B2 instances wrong", b2instances.size( ) == 1 );

        c1.refDelete( );
        b1.refDelete( );

        this.saveConnectionOne( );

        c2instances = this.iql.getInstances( this.localQueryClientScope, new MRI[] { c2MMri } );
        b2instances = this.iql.getInstances( this.localQueryClientScope, new MRI[] { b2MMri } );

        assertTrue( "No C2 instances found", !c2instances.isEmpty( ) );
        assertTrue( "Number of C2 instances wrong", c2instances.size( ) == 2 );
        assertTrue( "B2 instances found", b2instances.isEmpty( ) );
    }

    @Test
    @IndexOnly
    public void testGetInstances_MetamodelEdited( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        this.deleteAllNonMetamodelsFromIndex( );
        MRI firstMri = this.getFirst( );
        MRI firsttypeMri = this.getFirstType( );

        super.loadMetamodelInLocalDataArea( this.getMetamodelContainer( "testcases" ), this.getMetamodelContainer( "testcasesfoundation" ), this.getMetamodelContainer( "textverticalization" ) );
        MRI[] typeMris = new MRI[] { firsttypeMri };

        Collection<MRI> instances = this.iql.getInstances( this.metamodelQueryClientScope, typeMris );
        assertTrue( "Result does not contain expected MRI: " + firstMri.toString( ), instances.contains( firstMri ) );

        instances = this.iql.getInstances( this.localQueryClientScope, typeMris );
        assertFalse( "Result does contain unexpected MRI: " + firstMri.toString( ), instances.contains( firstMri ) );
    }
}
