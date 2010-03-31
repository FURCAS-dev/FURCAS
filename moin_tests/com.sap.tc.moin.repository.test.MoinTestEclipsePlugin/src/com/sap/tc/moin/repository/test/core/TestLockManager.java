package com.sap.tc.moin.repository.test.core;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.LockedException;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.PartitionLockManager;

/**
 * @author d032153
 */
public class TestLockManager extends CoreMoinTest {

    private PartitionLockManager partitionLockManager = null;

    private LockManager applLockManager = null;

    private PRI pri1 = null, pri2 = null;

    private Connection conn1, conn2;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        conn1 = getMOINConnection( );
        conn1.setLabel( "Connection1" );
        this.pri1 = getPartitionOne( ).getPri( );
        this.pri2 = getPartitionTwo( ).getPri( );
        conn1.save( );
        conn2 = getSecondMOINConnection( );

        applLockManager = conn1.getSession( ).getLockManager( );
        partitionLockManager = getTestHelper( ).getCoreConnection( conn1 ).getPartitionLockManager( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( partitionLockManager != null ) {
            partitionLockManager.releaseAllLocks( conn1 );
            partitionLockManager.releaseAllLocks( conn2 );
            partitionLockManager = null;
        }
        applLockManager = null;
        pri1 = null;
        pri2 = null;
        conn1 = null;
        conn2 = null;
        super.afterTestMethod( );
    }

    @Test
    public void testLockTestCase_001( ) throws Exception {

        this.applLockManager.obtainApplicationLock( this.pri1, this.conn1 );

        this.applLockManager.obtainApplicationLock( this.pri2, this.conn2 );

        try {

            this.applLockManager.obtainApplicationLock( this.pri1, this.conn2 );

            flop( "Expected LockingException" );

        } catch ( LockedException e ) {
            assertEquals( this.conn1, e.getLockedBy( ) );
        }

        try {

            this.applLockManager.obtainApplicationLock( this.pri1, null );

            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {

            this.applLockManager.obtainApplicationLock( null, this.conn1 );

            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {

            this.applLockManager.obtainApplicationLock( null, null );

            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        this.applLockManager.checkApplicationLock( this.pri1, this.conn1 );

        this.applLockManager.checkApplicationLock( this.pri2, this.conn2 );

        try {

            this.applLockManager.checkApplicationLock( this.pri1, this.conn2 );

            flop( "LockingException was not thrown as expected!" );
        } catch ( LockedException e ) {
            assertEquals( this.conn1, e.getLockedBy( ) );
        }

        try {

            this.applLockManager.checkApplicationLock( this.pri1, null );

            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            this.applLockManager.checkApplicationLock( null, this.conn1 );

            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {

            this.applLockManager.checkApplicationLock( null, null );

            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        // after the following call, resInfo2 is no longer locked
        this.applLockManager.releaseApplicationLock( this.pri2, this.conn2 );

        try {
            this.applLockManager.releaseApplicationLock( this.pri1, this.conn2 );
            flop( "Exception expected" );
        } catch ( LockedException e ) {
            // expected as resInfo1 is locked by conn1
            assertEquals( this.conn1, e.getLockedBy( ) );
        }

        // following call must be a no-op because resInfo2 is not locked anymore
        this.applLockManager.releaseApplicationLock( this.pri2, this.conn1 );

        try {
            this.applLockManager.releaseApplicationLock( this.pri1, this.conn2 );
            flop( "Exception expected" );
        } catch ( LockedException e ) {
            // expected as resInfo1 is locked by conn1
            assertEquals( this.conn1, e.getLockedBy( ) );
        }

        try {

            this.applLockManager.releaseApplicationLock( null, this.conn1 );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {

            this.applLockManager.releaseApplicationLock( this.pri1, null );

            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {

            this.applLockManager.releaseApplicationLock( null, null );

            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        // after the following call, resInfo1 is no longer locked
        this.applLockManager.releaseApplicationLock( this.pri1, this.conn1 );

        // must be a no-op as resInfo is not locked anymore
        this.applLockManager.releaseApplicationLock( this.pri1, this.conn2 );

    }

    @Test
    public void testLockTestCase_002( ) throws Exception {

        this.applLockManager.obtainApplicationLock( this.pri1, this.conn1 );

        assertEquals( this.conn1, this.applLockManager.getLockOwner( pri1 ) );

        assertNull( this.applLockManager.getLockOwner( pri2 ) );

        try {
            this.applLockManager.getLockOwner( null );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected

        }

        this.applLockManager.releaseApplicationLock( this.pri1, this.conn1 );

        this.applLockManager.obtainApplicationLock( this.pri1, this.conn2 );

        assertEquals( this.conn2, this.applLockManager.getLockOwner( pri1 ) );

        try {
            this.applLockManager.releaseApplicationLock( this.pri1, conn1 );
            flop( "Expected LockingException" );
        } catch ( LockedException e ) {
            assertEquals( this.conn2, e.getLockedBy( ) );
        }

        this.applLockManager.releaseApplicationLock( this.pri1, this.conn2 );

    }

    @Test
    public void testLockTestCase_003( ) throws Exception {

        this.partitionLockManager.obtainLock( this.pri1, this.conn1 );
        this.partitionLockManager.obtainLock( this.pri2, this.conn2 );

        try {
            this.partitionLockManager.obtainLock( this.pri1, this.conn2 );
            flop( "LockingException was not thrown as expected!" );
        } catch ( LockedException e ) {
            assertEquals( this.conn1, e.getLockedBy( ) );
        }

        try {
            this.partitionLockManager.obtainLock( this.pri1, null );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected

        }
        try {
            this.partitionLockManager.obtainLock( null, this.conn1 );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            this.partitionLockManager.obtainLock( null, null );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        this.partitionLockManager.checkLock( this.pri1, this.conn1 );
        this.partitionLockManager.checkLock( this.pri2, this.conn2 );

        try {

            this.partitionLockManager.checkLock( this.pri1, this.conn2 );
            flop( "LockingException was not thrown as expected!" );
        } catch ( LockedException e ) {
            assertEquals( this.conn1, e.getLockedBy( ) );
        }

        try {

            this.partitionLockManager.checkLock( this.pri1, null );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            this.partitionLockManager.checkLock( null, this.conn1 );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {

            this.partitionLockManager.checkLock( null, null );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        this.partitionLockManager.releaseLock( this.pri2, this.conn2 );
        this.partitionLockManager.releaseLock( this.pri1, this.conn1 );

        this.partitionLockManager.releaseLock( this.pri2, this.conn1 );
        this.partitionLockManager.releaseLock( this.pri1, this.conn1 );

        try {

            this.partitionLockManager.releaseLock( null, this.conn1 );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {

            this.partitionLockManager.releaseLock( this.pri1, null );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {

            this.partitionLockManager.releaseLock( null, null );
            flop( "IllegalArgumentException was not thrown as expected!" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        this.partitionLockManager.releaseLock( this.pri1, this.conn1 );

    }

    @Test
    public void testLockTestCase_004( ) throws Exception {

        this.partitionLockManager.obtainLock( this.pri1, this.conn1 );

        // assertTrue(this.partitionLockManager.getLockOwner(resInfo1).equals(this.conn1));
        //
        // assertNull(this.partitionLockManager.getLockOwner(resInfo2));
        //        
        // try {
        //
        // this.partitionLockManager.getLockOwner(null);
        //
        // flop("IllegalArgumentException was not thrown as expected!");
        // } catch (IllegalArgumentException e) {
        // // expected
        // }

        this.partitionLockManager.releaseLock( this.pri1, this.conn1 );

        this.partitionLockManager.obtainLock( this.pri1, this.conn2 );

        // assertTrue(this.partitionLockManager.getLockOwner(resInfo1).equals(this.conn2));

        this.partitionLockManager.releaseLock( this.pri1, this.conn2 );

    }

    @Test
    public void testLockTestCase_005( ) throws Exception {

        this.partitionLockManager.obtainLock( this.pri1, this.conn1 );
        this.partitionLockManager.obtainLock( this.pri2, this.conn1 );

        this.partitionLockManager.checkLock( this.pri1, this.conn1 );
        this.partitionLockManager.checkLock( this.pri2, this.conn1 );

        this.partitionLockManager.obtainLock( this.pri1, this.conn1 );
        this.partitionLockManager.obtainLock( this.pri2, this.conn1 );

        this.partitionLockManager.checkLock( this.pri1, this.conn1 );
        this.partitionLockManager.checkLock( this.pri2, this.conn1 );

        try {
            this.partitionLockManager.obtainLock( this.pri1, this.conn2 );
            flop( "Exception expected" );
        } catch ( LockedException e ) {
            assertEquals( this.conn1, e.getLockedBy( ) );
        }

        try {
            this.partitionLockManager.checkLock( this.pri1, this.conn2 );
            flop( "Exception expected" );
        } catch ( LockedException e ) {
            assertEquals( this.conn1, e.getLockedBy( ) );
        }

        // no-op
        this.partitionLockManager.releaseAllLocks( this.conn2 );

        // release all locks of connection1
        this.partitionLockManager.releaseAllLocks( this.conn1 );

        try {

            this.partitionLockManager.checkLock( this.pri1, this.conn1 );
            flop( "LockingException was not thrown as expected!" );

        } catch ( LockingException e ) {
            // expected
            assertFalse( e instanceof LockedException );
        }

        try {

            this.partitionLockManager.checkLock( this.pri2, this.conn1 );
            flop( "ERROR LockingException was not thrown as expected!" );
        } catch ( LockingException e ) {
            assertFalse( e instanceof LockedException );
        }
    }

    @Test
    public void testLockTestCase_006( ) throws Exception {

        this.applLockManager.obtainApplicationLock( this.pri1, this.conn1 );

        this.applLockManager.checkApplicationLock( this.pri1, this.conn1 );

        // close conn1, that must release all locks currently held by conn1
        this.conn1.close( );

        try {
            this.applLockManager.checkApplicationLock( this.pri1, this.conn1 );
            flop( "Exception was not thrown as expected!" );
        } catch ( LockingException e ) {
            // expected as connection is no longer alive
            assertFalse( e instanceof LockedException );
        }
    }

    @Test
    public void testLockTestCase_007( ) throws Exception {

        this.applLockManager.obtainApplicationLock( this.pri1, this.conn1 );

        this.applLockManager.releaseApplicationLock( this.pri1, this.conn1 );

        this.applLockManager.obtainApplicationLock( this.pri1, this.conn1 );

        this.applLockManager.releaseApplicationLock( this.pri1, this.conn1 );

        try {
            applLockManager.checkApplicationLock( this.pri1, conn1 );
            flop( "Expected exception" );
        } catch ( LockingException e ) {
            // expected
            assertFalse( e instanceof LockedException );
        }

        assertNull( applLockManager.getLockOwner( this.pri1 ) );

        this.applLockManager.obtainApplicationLock( this.pri1, this.conn1 );
        this.applLockManager.obtainApplicationLock( this.pri1, this.conn1 );
        this.applLockManager.releaseApplicationLock( this.pri1, this.conn1 );
        applLockManager.checkApplicationLock( this.pri1, conn1 );
        assertEquals( conn1, applLockManager.getLockOwner( this.pri1 ) );
        this.applLockManager.releaseApplicationLock( this.pri1, this.conn1 );

        try {
            applLockManager.checkApplicationLock( this.pri1, conn1 );
            flop( "Expected exception" );
        } catch ( LockingException e ) {
            // expected
            assertFalse( e instanceof LockedException );
        }

        assertNull( applLockManager.getLockOwner( this.pri1 ) );

        this.partitionLockManager.obtainLock( this.pri1, this.conn1 );

        this.partitionLockManager.releaseLock( this.pri1, this.conn1 );

        this.partitionLockManager.obtainLock( this.pri1, this.conn1 );

        this.partitionLockManager.releaseLock( this.pri1, this.conn1 );
        try {
            this.partitionLockManager.checkLock( this.pri1, this.conn1 );
            flop( "Expected exception" );
        } catch ( LockingException e ) {
            assertFalse( e instanceof LockedException );
        }
        // must be no-op
        this.partitionLockManager.releaseLock( this.pri1, this.conn1 );

        this.partitionLockManager.obtainLock( this.pri1, this.conn1 );
        this.partitionLockManager.obtainLock( this.pri1, this.conn1 );
        this.partitionLockManager.releaseLock( this.pri1, this.conn1 );
        try {
            this.partitionLockManager.checkLock( this.pri1, this.conn1 );
            flop( "Expected exception" );
        } catch ( LockingException e ) {
            assertFalse( e instanceof LockedException );
        }

    }

    @Test
    public void testObtainTransientLockAndGetLockedPartitions( ) throws Exception {

        Connection owner = getMOINConnection( );
        PRI resourceOne = getPartitionOne( ).getPri( );
        PRI resourceTwo = getPartitionTwo( ).getPri( );

        LockManager applicationLockManager = getMOINConnection( ).getSession( ).getLockManager( );

        // make sure there are no partitions locked yet
        assertSame( 0, applicationLockManager.getLockedPartitions( owner ).size( ) );

        // get lock for resource 1
        applicationLockManager.obtainTransientLock( resourceOne, owner );

        // get lock for resource 2
        applicationLockManager.obtainTransientLock( resourceTwo, owner );

        // get the locked partitions
        Collection<PRI> lockedPartitions = applicationLockManager.getLockedPartitions( owner );

        assertSame( 2, lockedPartitions.size( ) );
        assertTrue( lockedPartitions.contains( resourceOne ) );
        assertTrue( lockedPartitions.contains( resourceTwo ) );

        // release lock for resource 1 and resource 2 by saving
        owner.save( );

        lockedPartitions = applicationLockManager.getLockedPartitions( owner );

        assertSame( 0, lockedPartitions.size( ) );

    }

    @Test
    public void testLockingWithTwoResources( ) throws Exception {

        Connection owner = getMOINConnection( );
        PRI resourceOne = getPartitionOne( ).getPri( );
        PRI resourceTwo = getPartitionTwo( ).getPri( );

        LockManager applicationLockManager = getMOINConnection( ).getSession( ).getLockManager( );

        // get lock for resource 1
        applicationLockManager.obtainApplicationLock( resourceOne, owner );

        // get lock for resource 2
        applicationLockManager.obtainApplicationLock( resourceTwo, owner );

        // release lock for resource 1
        applicationLockManager.releaseApplicationLock( resourceOne, owner );

        // release lock for resource 1 again -> this must be a no-op
        applicationLockManager.releaseApplicationLock( resourceOne, owner );

        // get lock for resource 2 again -> now locked 2-times
        applicationLockManager.obtainApplicationLock( resourceTwo, owner );

        // release lock for resource 2 -> now locked 1-time
        applicationLockManager.releaseApplicationLock( resourceTwo, owner );

        // final release of lock for resource 2 -> not locked anymore
        applicationLockManager.releaseApplicationLock( resourceTwo, owner );

        // release lock for resource 2 again -> this must be a no-op
        applicationLockManager.releaseApplicationLock( resourceTwo, owner );
    }

    @Test
    public void testLockReleaseOnConnectionClose( ) throws Exception {

        Connection owner = getMOINConnection( );
        LockManager lockManager = owner.getSession( ).getLockManager( );
        PRI resourceOne = getPartitionOne( ).getPri( );
        PRI resourceTwo = getPartitionTwo( ).getPri( );

        //make sure the resources are not locked
        assertNull( lockManager.getLockOwner( resourceOne ) );
        assertNull( lockManager.getLockOwner( resourceTwo ) );

        ModelPartition partitionOne = owner.getPartition( resourceOne );
        assertTrue( partitionOne != null );

        ModelPartition partitionTwo = owner.getPartition( resourceTwo );
        assertTrue( partitionTwo != null );

        //lock both resources
        owner.createElementInPartition( MofClass.class, partitionOne );
        owner.createElementInPartition( MofClass.class, partitionTwo );

        //check that the planned owner has the lock
        assertEquals( owner, lockManager.getLockOwner( resourceOne ) );
        assertEquals( owner, lockManager.getLockOwner( resourceTwo ) );


        Connection wannabeOwner = getSecondMOINConnection( );
        try {
            lockManager.obtainApplicationLock( resourceOne, wannabeOwner );
            fail( "Expected expcetion to be thrown" );
        } catch ( LockedException e ) {
            assertEquals( owner, e.getLockedBy( ) );
        }
        try {
            lockManager.obtainApplicationLock( resourceTwo, wannabeOwner );
            fail( "Expected expcetion to be thrown" );
        } catch ( LockedException e ) {
            assertEquals( owner, e.getLockedBy( ) );
        }

        owner.close( );

        //locks must be released 
        assertNull( lockManager.getLockOwner( resourceOne ) );
        assertNull( lockManager.getLockOwner( resourceTwo ) );

        //try to lock with other connection
        ModelPartition partitionOneOtherConnection = wannabeOwner.getPartition( resourceOne );
        assertTrue( partitionOneOtherConnection != null );

        ModelPartition partitionTwoOtherConnection = wannabeOwner.getPartition( resourceTwo );
        assertTrue( partitionTwoOtherConnection != null );

        wannabeOwner.createElementInPartition( MofClass.class, partitionOneOtherConnection );
        wannabeOwner.createElementInPartition( MofClass.class, partitionTwoOtherConnection );

        //check that the planned owner has the lock
        assertEquals( wannabeOwner, lockManager.getLockOwner( resourceOne ) );
        assertEquals( wannabeOwner, lockManager.getLockOwner( resourceTwo ) );

        //check that the locks are released on revert
        wannabeOwner.revert( );
        assertNull( lockManager.getLockOwner( resourceOne ) );
        assertNull( lockManager.getLockOwner( resourceTwo ) );
    }


}
