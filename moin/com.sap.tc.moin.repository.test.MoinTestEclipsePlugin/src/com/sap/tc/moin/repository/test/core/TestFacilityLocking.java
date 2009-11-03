/*
 * Created on 02.06.2006
 */
package com.sap.tc.moin.repository.test.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.LockedException;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.SpiInternalDistributedDirtyLocking;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;

public class TestFacilityLocking extends CoreMoinTest {

    private SpiInternalDistributedDirtyLocking facilityLocking;

    private PRI pri1;

    private PRI pri2;

    private String owner_1 = "owner_1";

    private String owner_2 = "owner_2";

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this.pri1 = getPartitionOne( ).getPri( );
        this.pri2 = getPartitionTwo( ).getPri( );
        this.facilityLocking = ( (SpiFacility) getFacility( ) ).getInternalDistributedDirtyLocking( this._testClient1.getClientSpec( ).getDataArea( ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( facilityLocking != null ) {
            facilityLocking.releaseAllLocks( owner_1 );
            facilityLocking.releaseAllLocks( owner_2 );
        }
        facilityLocking = null;
        pri1 = null;
        pri2 = null;
        super.afterTestMethod( );
    }

    @Test
    public void test_001( ) throws Exception {

        if ( facilityLocking == null ) {
            return;
        }

        // Situtation: nothing locked
        facilityLocking.obtainLock( pri1, owner_1 );

        // Situation: resource1 locked by owner_1
        try {
            facilityLocking.obtainLock( pri1, owner_2 );
            flop( "Expected exception" );
        } catch ( LockedException e ) {
            assertSame( e.getLockedBy( ), owner_1 );
        }

        // Situation: resource1 locked by owner_1
        // facilityLocking.obtainLock(resourceInfo1, owner_1);// must be idempotent TODO clarify idempotence

        // Situation: resource1 locked by owner_1
        facilityLocking.releaseLock( pri1, owner_1 ); // must be released despite obtainLock() was called
        // twice -> must not be cumulative
        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_2 ); // must work if it was released correctly

        // Situation: resource1 locked by owner_2
        facilityLocking.releaseLock( pri2, owner_1 ); // must be a no-operation

        // Situation: resource1 locked by owner_2
        facilityLocking.releaseLock( pri2, owner_2 ); // must be a no-operation

        // Situation: resource1 locked by owner_2
        facilityLocking.releaseAllLocks( owner_1 ); // must be a no-operation

        // Situation: resource1 locked by owner_2
        facilityLocking.releaseAllLocks( owner_2 ); // must release resource1

        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_1 );

        // Situation: resource1 locked by owner_1
        facilityLocking.releaseAllLocks( owner_2 ); // must be a no-operation

        // Situation: resource1 locked by owner_1
        facilityLocking.obtainLock( pri2, owner_1 );

        // Situation: resource1, resource2 locked by owner_1
        facilityLocking.releaseAllLocks( owner_1 );

        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_1 );

        // Situation: resource1 locked by owner_1
        facilityLocking.releaseAllLocks( owner_1 );

        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_2 );

        // Situation: resource1 locked by owner_2
        facilityLocking.obtainLock( pri2, owner_2 );

        // Situation: resource1, resource2 locked by owner_2
        try {
            facilityLocking.obtainLock( pri1, owner_1 );
            flop( "Expected exception" );
        } catch ( LockedException e ) {
            assertSame( e.getLockedBy( ), owner_2 );
        }

        // Situation: resource1, resource2 locked by owner_2
        try {
            facilityLocking.obtainLock( pri2, owner_1 );
            flop( "Expected exception" );
        } catch ( LockedException e ) {
            assertSame( e.getLockedBy( ), owner_2 );
        }
    }

    @Test
    public void test_002( ) throws Exception {

        if ( facilityLocking == null ) {
            return;
        }

        // Situtation: nothing locked
        try {
            facilityLocking.checkLock( pri1, owner_1 );
            flop( "Expected exception" );

        } catch ( LockingException e ) {
            assertFalse( e instanceof LockedException );
        }

        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_1 );

        // Situation: resource1 locked by owner_1
        facilityLocking.checkLock( pri1, owner_1 );

        // Situation: resource1 locked by owner_1
        try {
            facilityLocking.checkLock( pri1, owner_2 );
            flop( "Expected exception" );

        } catch ( LockedException e ) {
            assertSame( e.getLockedBy( ), owner_1 );
        }

        // Situation: resource1 locked by owner_1
        facilityLocking.checkLock( pri1, owner_1 ); // must still have the lock

    }

    @Test
    public void test_003( ) throws Exception {

        if ( facilityLocking == null ) {
            return;
        }

        // Situtation: nothing locked
        facilityLocking.releaseLock( pri1, owner_1 ); // must be a no-op

        // Situation: nothing locked
        facilityLocking.releaseAllLocks( owner_1 ); // must be a no-op

        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_1 );

        // Situation: resource1 locked by owner_1
        try {
            facilityLocking.releaseLock( pri1, owner_2 );
            flop( "Expected exception" );
        } catch ( LockedException e ) {
            assertSame( e.getLockedBy( ), owner_1 );
        }

        // Situation: resource1 locked by owner_1
        facilityLocking.checkLock( pri1, owner_1 ); // must still have the lock

    }

    @Test
    public void test_004( ) throws Exception {

        if ( facilityLocking == null ) {
            return;
        }

        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_1 );

        // Situation: resource1 locked by owner_1
        facilityLocking.obtainLock( pri2, owner_2 );// that is done to make sure that there is a
        // serverInternalLocking existing for owner_2

        // Situation: resource1 locked by owner_1, resource2 locked by owner_2
        try {
            facilityLocking.releaseLock( pri1, owner_2 );
            flop( "Expected exception" );
        } catch ( LockedException e ) {
            assertSame( e.getLockedBy( ), owner_1 );
        }

        // Situation: resource1 locked by owner_1
        facilityLocking.checkLock( pri1, owner_1 ); // must still have the lock

    }

    @Test
    public void test_005( ) throws Exception {

        if ( facilityLocking == null ) {
            return;
        }

        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_1 );// that is done to make sure that there is a
        // serverInternalLocking existing for owner_1
        try {
            // Situation: resource1 locked by owner_1
            facilityLocking.checkLock( pri2, owner_1 );
            flop( "Expected exception" );
        } catch ( LockingException e ) {
            assertFalse( e instanceof LockedException );
        }

    }

    @Test
    public void test_006( ) throws Exception {

        if ( facilityLocking == null ) {
            return;
        }

        // Situation: nothing locked
        facilityLocking.obtainLock( pri1, owner_1 );// that is done to make sure that there is a
        // serverInternalLocking existing for owner_1

        // Situation: resource1 locked by owner_1
        facilityLocking.obtainLock( pri2, owner_2 );// that is done to make sure that there is a

        try {
            facilityLocking.checkLock( pri2, owner_1 );
            flop( "Expected exception" );
        } catch ( LockedException e ) {
            assertSame( e.getLockedBy( ), owner_2 );
        }
    }

}
