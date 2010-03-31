package com.sap.tc.moin.repository.test.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.Case002Package;

public class TestResourceIdentifierRecreationFromString extends CoreMoinTest {

    private TestcasesPackage testcasesPackage = null;

    private Case002Package case002Package = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.testcasesPackage = (TestcasesPackage) this.getMOINConnection( ).getPackage( null, new String[] { "testcases" } );

        this.case002Package = this.testcasesPackage.getCase002( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testRecreateNullPartitionMri( ) {

        B2 b2 = getMOINConnection( ).createElementInPartition( B2.class, null );
        MRI b2Mri = ( (Partitionable) b2 ).get___Mri( );
        String b2MriString = b2Mri.toString( );
        MRI b2MriRecreated = MoinTestCase.getInstance( ).createMri( b2MriString );
        assertEquals( "MRIs are not the same:\nfst: " + b2Mri.toString( ) + "\nsnd: " + b2MriRecreated.toString( ), b2Mri, b2MriRecreated );
        B2 b2Recreated = (B2) getMOINConnection( ).getElement( b2MriRecreated );
        assertEquals( "Retrieved elements are not the same", b2, b2Recreated );
    }

    @Test
    public void testRecreateTransientMri( ) {

        ModelPartition mp = getMOINConnection( ).getOrCreateTransientPartition( "TransientTestMri" );
        B2 b2 = getMOINConnection( ).createElementInPartition( B2.class, null );
        mp.assignElement( b2 );
        MRI b2Mri = ( (Partitionable) b2 ).get___Mri( );
        String b2MriString = b2Mri.toString( );
        MRI b2MriRecreated = MoinTestCase.getInstance( ).createMri( b2MriString );
        assertEquals( "MRIs are not the same:\nfst: " + b2Mri.toString( ) + "\nsnd: " + b2MriRecreated.toString( ), b2Mri, b2MriRecreated );
        B2 b2Recreated = (B2) getMOINConnection( ).getElement( b2MriRecreated );
        assertEquals( "Retrieved elements are not the same", b2, b2Recreated );
    }

    @Test
    public void testRecreatePersistedMri( ) {

        ModelPartition mp = _testClient1.getOrCreatePartition( "PersistedTestMri" );
        B2 b2 = getMOINConnection( ).createElementInPartition( B2.class, null );
        mp.assignElement( b2 );
        MRI b2Mri = ( (Partitionable) b2 ).get___Mri( );
        String b2MriString = b2Mri.toString( );
        MRI b2MriRecreated = MoinTestCase.getInstance( ).createMri( b2MriString );
        assertEquals( "MRIs are not the same:\nfst: " + b2Mri.toString( ) + "\nsnd: " + b2MriRecreated.toString( ), b2Mri, b2MriRecreated );
        B2 b2Recreated = (B2) getMOINConnection( ).getElement( b2MriRecreated );
        assertEquals( "Retrieved elements are not the same", b2, b2Recreated );
    }

    @Test
    public void testRecreateNullPartitionLri( ) {

        B2 b2 = getMOINConnection( ).createElementInPartition( B2.class, null );
        LRI b2Lri = ( (Partitionable) b2 ).get___Mri( ).getLri( );
        String b2LriString = b2Lri.toString( );
        LRI b2LriRecreated = MoinTestCase.getInstance( ).createLri( b2LriString );
        assertEquals( "LRIs are not the same:\nfst: " + b2Lri.toString( ) + "\nsnd: " + b2LriRecreated.toString( ), b2Lri, b2LriRecreated );
        B2 b2Recreated = (B2) getMOINConnection( ).getElement( b2LriRecreated );
        assertEquals( "Retrieved elements are not the same", b2, b2Recreated );
    }

    @Test
    public void testRecreateTransientLri( ) {

        ModelPartition mp = getMOINConnection( ).getOrCreateTransientPartition( "TransientTestLri" );
        B2 b2 = getMOINConnection( ).createElementInPartition( B2.class, null );
        mp.assignElement( b2 );
        LRI b2Lri = ( (Partitionable) b2 ).get___Mri( ).getLri( );
        String b2LriString = b2Lri.toString( );
        LRI b2LriRecreated = MoinTestCase.getInstance( ).createLri( b2LriString );
        assertEquals( "LRIs are not the same:\nfst: " + b2Lri.toString( ) + "\nsnd: " + b2LriRecreated.toString( ), b2Lri, b2LriRecreated );
        B2 b2Recreated = (B2) getMOINConnection( ).getElement( b2LriRecreated );
        assertEquals( "Retrieved elements are not the same", b2, b2Recreated );
    }

    @Test
    public void testRecreatePersistedLri( ) {

        ModelPartition mp = _testClient1.getOrCreatePartition( "PersistedTestLri" );
        B2 b2 = getMOINConnection( ).createElementInPartition( B2.class, null );
        mp.assignElement( b2 );
        LRI b2Lri = ( (Partitionable) b2 ).get___Mri( ).getLri( );
        String b2LriString = b2Lri.toString( );
        LRI b2LriRecreated = MoinTestCase.getInstance( ).createLri( b2LriString );
        assertEquals( "LRIs are not the same:\nfst: " + b2Lri.toString( ) + "\nsnd: " + b2LriRecreated.toString( ), b2Lri, b2LriRecreated );
        B2 b2Recreated = (B2) getMOINConnection( ).getElement( b2LriRecreated );
        assertEquals( "Retrieved elements are not the same", b2, b2Recreated );
    }

    @Test
    public void testRecreateNullPartitionPri( ) {

        ModelPartition mp = getMOINConnection( ).getNullPartition( );
        PRI mpPri = mp.getPri( );
        String mpPriString = mpPri.toString( );
        PRI mpPriRecreated = MoinTestCase.getInstance( ).createPri( mpPriString );
        assertSame( "PRIs are not the same", mpPri, mpPriRecreated );
        ModelPartition mpRecreated = this.getMOINConnection( ).getPartition( mpPriRecreated );
        assertSame( "Partitions are not the same", mp, mpRecreated );
    }

    @Test
    public void testRecreateTransientPri( ) {

        ModelPartition mp = getMOINConnection( ).getOrCreateTransientPartition( "TransientTestPri" );
        PRI mpPri = mp.getPri( );
        String mpPriString = mpPri.toString( );
        PRI mpPriRecreated = MoinTestCase.getInstance( ).createPri( mpPriString );
        assertSame( "PRIs are not the same", mpPri, mpPriRecreated );
        ModelPartition mpRecreated = this.getMOINConnection( ).getPartition( mpPriRecreated );
        assertSame( "Partitions are not the same", mp, mpRecreated );
    }

    @Test
    public void testRecreatePersistedPri( ) {

        ModelPartition mp = _testClient1.getOrCreatePartition( "PersistedTestPri" );
        PRI mpPri = mp.getPri( );
        String mpPriString = mpPri.toString( );
        PRI mpPriRecreated = MoinTestCase.getInstance( ).createPri( mpPriString );
        assertSame( "PRIs are not the same", mpPri, mpPriRecreated );
        ModelPartition mpRecreated = this.getMOINConnection( ).getPartition( mpPriRecreated );
        assertSame( "Partitions are not the same", mp, mpRecreated );
    }

}
