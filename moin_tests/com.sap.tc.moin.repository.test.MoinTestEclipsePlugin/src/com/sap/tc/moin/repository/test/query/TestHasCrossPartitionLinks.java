package com.sap.tc.moin.repository.test.query;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;

/**
 * Test class for hasCrossPartitionLinks() in API.
 * <p>
 * We use Case002 from Testcases metamodel which contains two classes C2 and B2
 * with a reference to B2 at C2. Storage is at reference.
 * 
 * @author D048997
 */
public class TestHasCrossPartitionLinks extends MoinTestCase {

    private static final boolean HAS_LINKS = true;

    private static final boolean HAS_NO_LINKS = false;

    private TestcasesPackage testcasesPackage;

    private TestClient testClient;

    private ModelPartition mp1;

    private ModelPartition mp2;

    private ModelPartition mp3;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.testClient = getTestHelper( ).getDefaultTestClient( true );
        this.testcasesPackage = (TestcasesPackage) this.testClient.getConnection( ).getPackage( null, new String[] { "testcases" } );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( mp1 != null ) {
            try {
                if ( mp1.isAlive( ) ) {
                    mp1.delete( );
                }
            } catch ( Exception e ) {
            }
        }
        if ( mp2 != null ) {
            try {
                if ( mp2.isAlive( ) ) {
                    mp2.delete( );
                }
            } catch ( Exception e ) {
            }
        }
        if ( mp3 != null ) {
            try {
                if ( mp3.isAlive( ) ) {
                    mp3.delete( );
                }
            } catch ( Exception e ) {
            }
        }
        this.testClient.getConnection( ).save( );
        super.afterTestMethod( );
    }

    @Test
    public void testAllPersistedEmpty( ) throws Exception {

        // save empty partitions to disc
        this.createEmptyPartitions( );
        this.saveConnection( );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testAllPersistedWithoutLink( ) throws Exception {

        // save empty partitions to disc
        this.createEmptyPartitions( );
        this.mp1.assignElement( this.createC2( ) );
        this.mp2.assignElement( this.createB2( ) );
        this.saveConnection( );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testAllPersistedStorageP1( ) throws Exception {

        this.createEmptyPartitions( );
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        c2.setB( b2 );
        this.mp1.assignElement( c2 );
        this.mp2.assignElement( b2 );
        this.saveConnection( );

        this.check( HAS_LINKS );
    }

    @Test
    public void testAllPersistedStorageP2( ) throws Exception {

        this.createEmptyPartitions( );
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        c2.setB( b2 );
        this.mp2.assignElement( c2 );
        this.mp1.assignElement( b2 );
        this.saveConnection( );

        this.check( HAS_LINKS );
    }

    @Test
    public void testIntrapartitionLinkAllPersisted( ) throws Exception {

        this.createEmptyPartitions( );
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        c2.setB( b2 );
        this.mp1.assignElement( c2 );
        this.mp1.assignElement( b2 );
        saveConnection( );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testIntrapartitionLinkAllDirtyNew( ) throws Exception {

        this.createEmptyPartitions( );
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        c2.setB( b2 );
        this.mp1.assignElement( c2 );
        this.mp1.assignElement( b2 );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testP2PersistedP1NewEmpty( ) throws Exception {

        this.createSecondPartition( );
        this.saveConnection( );
        this.createFirstPartition( );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testP2PersistedP1NewWithoutLink( ) throws Exception {

        this.createSecondPartition( );
        this.mp2.assignElement( this.createC2( ) );
        this.saveConnection( );
        this.createFirstPartition( );
        this.mp1.assignElement( this.createB2( ) );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testP2PersistedP1NewStorageInP1( ) throws Exception {

        B2 b2 = this.createB2( );
        this.createSecondPartition( );
        this.mp2.assignElement( b2 );
        this.saveConnection( );
        C2 c2 = this.createC2( );
        c2.setB( b2 );
        this.createFirstPartition( );
        this.mp1.assignElement( c2 );

        this.check( HAS_LINKS );
    }

    @Test
    public void testP2PersistedP1NewStorageInP2( ) throws Exception {

        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        c2.setB( b2 );
        this.createSecondPartition( );
        this.createThirdPartition( );
        this.mp2.assignElement( c2 );
        this.mp3.assignElement( b2 );
        this.saveConnection( );
        this.createFirstPartition( );
        this.mp1.assignElement( b2 );

        this.check( HAS_LINKS );
    }

    @Test
    public void testP1DirtyPersistedP2PersistedWithoutLink( ) throws Exception {

        this.createEmptyPartitions( );
        this.mp2.assignElement( this.createB2( ) );
        this.saveConnection( );
        this.mp1.assignElement( this.createC2( ) );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testP1DirtyPersistedP2PersistedStorageInP1( ) throws Exception {

        this.createEmptyPartitions( );
        B2 b2 = this.createB2( );
        this.mp2.assignElement( b2 );
        this.saveConnection( );
        C2 c2 = this.createC2( );
        c2.setB( b2 );
        this.mp1.assignElement( c2 );

        this.check( HAS_LINKS );
    }

    @Test
    public void testP1DirtyPersistedP2PersistedStorageInP2( ) throws Exception {

        this.createEmptyPartitions( );
        B2 b2 = this.createB2( );
        C2 c2 = this.createC2( );
        c2.setB( b2 );
        this.mp3.assignElement( b2 );
        this.mp2.assignElement( c2 );
        this.saveConnection( );
        mp1.assignElement( b2 );

        this.check( HAS_LINKS );
    }

    @Test
    public void testP1DirtyPersistedP2PersistedStorageInPersistedP1( ) throws Exception {

        this.createEmptyPartitions( );
        B2 b2 = this.createB2( );
        C2 c2 = this.createC2( );
        c2.setB( b2 );
        this.mp2.assignElement( b2 );
        this.mp1.assignElement( c2 );
        this.saveConnection( );
        c2.refDelete( );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testP1DirtyDeletedPersistedP2PersistedStorageInPersistedP1( ) throws Exception {

        this.createEmptyPartitions( );
        B2 b2 = this.createB2( );
        C2 c2 = this.createC2( );
        c2.setB( b2 );
        this.mp2.assignElement( b2 );
        this.mp1.assignElement( c2 );
        this.saveConnection( );
        mp1.delete( );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testP1DirtyPersistedP2DirtyPersistedWithoutLink( ) throws Exception {

        this.createEmptyPartitions( );
        this.saveConnection( );
        this.mp1.assignElement( this.createB2( ) );
        this.mp2.assignElement( this.createC2( ) );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testP1DirtyPersistedP2DirtyPersistedStorageInP1( ) throws Exception {

        this.createEmptyPartitions( );
        this.saveConnection( );
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        c2.setB( b2 );
        this.mp1.assignElement( c2 );
        this.mp2.assignElement( b2 );

        this.check( HAS_LINKS );
    }

    @Test
    public void testP1DirtyPersistedP2DirtyPersistedStorageInPersistedP1( ) throws Exception {

        this.createEmptyPartitions( );
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        c2.setB( b2 );
        this.mp1.assignElement( c2 );
        this.mp2.assignElement( b2 );
        this.saveConnection( );
        this.mp2.assignElement( this.createB2( ) );
        this.mp3.assignElement( c2 );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testP1DirtyDeletedPersistedP2DirtyPersistedStorageInPersistedP1( ) throws Exception {

        this.createEmptyPartitions( );
        C2 c2 = this.createC2( );
        B2 b2 = this.createB2( );
        c2.setB( b2 );
        this.mp1.assignElement( c2 );
        this.mp2.assignElement( b2 );
        this.saveConnection( );
        this.mp2.assignElement( this.createB2( ) );
        this.mp1.delete( );

        this.check( HAS_NO_LINKS );
    }

    @Test
    public void testNullArgInHasCrossPartitionLinks( ) throws Exception {

        this.createEmptyPartitions( );

        assertFalse( testClient.getConnection( ).getSession( ).hasCrossPartitionLinks( null, null ) );

        assertFalse( testClient.getConnection( ).getSession( ).hasCrossPartitionLinks( null ) );

        assertFalse( testClient.getConnection( ).getSession( ).hasCrossPartitionLinks( mp1.getPri( ) ) );

        assertFalse( testClient.getConnection( ).getSession( ).hasCrossPartitionLinks( mp1.getPri( ), (PRI[]) null ) );

        assertFalse( testClient.getConnection( ).getSession( ).hasCrossPartitionLinks( mp1.getPri( ), (PRI) null ) );

        // test if "null" arg does not trigger an Exception
        testClient.getConnection( ).getSession( ).hasCrossPartitionLinks( mp1.getPri( ), mp2.getPri( ), null );

    }


    // ############### PRIVATE METHODS ###############

    private void check( boolean result ) {

        Collection<PRI> evictedPartitions = this.evictPersistedUndirtyPartitions( );

        if ( mp1 == null || mp2 == null ) {
            throw new IllegalStateException( "mp1 and mp2 must not be null" );
        }
        PRI pri1 = mp1.getPri( );
        PRI pri2 = mp2.getPri( );

        assertFalse( this.hasCrossPartitionLinks( pri1, pri1 ) );
        assertFalse( this.hasCrossPartitionLinks( pri2, pri2 ) );
        assertTrue( this.hasCrossPartitionLinks( pri1, pri2 ) == result );
        assertTrue( this.hasCrossPartitionLinks( pri1, pri2 ) == this.hasCrossPartitionLinks( pri2, pri1 ) );

        for ( PRI pri : evictedPartitions ) {
            assertFalse( this.getClientSpecificWorkspace( this.testClient.getConnection( ) ).getPartitionManager( ).isPartitionLoaded( pri ) );
        }
    }

    private boolean hasCrossPartitionLinks( PRI first, PRI second ) {

        return this.testClient.getConnection( ).getSession( ).hasCrossPartitionLinks( first, second );
    }

    private void createEmptyPartitions( ) {

        this.createFirstPartition( );
        this.createSecondPartition( );
        this.createThirdPartition( );
    }

    private void createFirstPartition( ) {

        mp1 = this.testClient.createPartition( "one" );
    }

    private void createSecondPartition( ) {

        mp2 = this.testClient.createPartition( "two" );
    }

    /**
     * A helper partition!
     */
    private void createThirdPartition( ) {

        mp3 = this.testClient.createPartition( "three" );
    }

    private void saveConnection( ) throws Exception {

        this.testClient.getConnection( ).save( );
    }

    private C2 createC2( ) {

        return this.testClient.getConnection( ).createElementInPartition( C2.class, null );
    }

    private B2 createB2( ) {

        return this.testClient.getConnection( ).createElementInPartition( B2.class, null );
    }

    private Workspace getClientSpecificWorkspace( Connection connection ) {

        return getTestHelper( ).getCoreConnection( connection ).getSession( ).getWorkspace( );
    }

    private Collection<PRI> evictPersistedUndirtyPartitions( ) {

        Collection<PRI> evictedPris = new ArrayList<PRI>( );
        if ( this.mp1 != null && mp1.isAlive( ) && !mp1.isDirty( ) && isPersisted( mp1 ) ) {
            this.evictPartition( mp1 );
            evictedPris.add( mp1.getPri( ) );
        }
        if ( this.mp2 != null && mp2.isAlive( ) && !mp2.isDirty( ) && isPersisted( mp2 ) ) {
            this.evictPartition( mp2 );
            evictedPris.add( mp2.getPri( ) );
        }
        if ( this.mp3 != null && mp3.isAlive( ) && !mp3.isDirty( ) && isPersisted( mp3 ) ) {
            this.evictPartition( mp3 );
            evictedPris.add( mp3.getPri( ) );
        }

        return evictedPris;
    }

    private boolean isPersisted( ModelPartition mp ) {

        return getTestHelper( ).getCoreModelPartition( mp ).isPersisted( );
    }

    private void evictPartition( ModelPartition mp ) {

        System.out.println( "Evict Partition " + mp.getPri( ).toString( ) );
        this.getClientSpecificWorkspace( this.testClient.getConnection( ) ).getPartitionManager( ).evictPartitionForced( getTestHelper( ).getCoreModelPartition( mp ) );
    }
}
