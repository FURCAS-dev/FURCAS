/*
 * Created on 20.02.2006
 */
package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.junit.Test;

import com.sap.tc.moin.friends.RefBaseObjectDummyForCollectionAccess;

/**
 * Tests different editing scenarios of partitions. Main focus is on locking.
 * 
 * @author d044711
 */
public class TestRefBaseObjectDummy extends CoreMoinTest {

    @Test
    public void testRetrieveAliveObjectFromCollection( ) throws Exception {

        MofClass mofClass = getMOINConnection( ).createElement( MofClass.class );
        List<MofClass> list = new ArrayList<MofClass>( );
        list.add( mofClass );

        RefBaseObject dummy = new RefBaseObjectDummyForCollectionAccess( mofClass.get___Mri( ).getLri( ) );

        assertTrue( list.contains( mofClass ) );
        assertTrue( list.contains( dummy ) );

    }

    @Test
    public void testRetrieveDeadObjectFromCollection( ) throws Exception {

        MofClass mofClass = getMOINConnection( ).createElement( MofClass.class );
        List<MofClass> list = new ArrayList<MofClass>( );
        list.add( mofClass );

        mofClass.refDelete( );

        RefBaseObject dummy = new RefBaseObjectDummyForCollectionAccess( mofClass.get___Mri( ).getLri( ) );

        assertTrue( list.contains( mofClass ) );
        assertTrue( list.contains( dummy ) );
    }

    @Test
    public void testRemoveDeadObjectFromSet( ) throws Exception {

        MofClass mofClass = getMOINConnection( ).createElement( MofClass.class );
        Set<MofClass> set = new HashSet<MofClass>( );
        set.add( mofClass );

        mofClass.refDelete( );

        RefBaseObject dummy = new RefBaseObjectDummyForCollectionAccess( mofClass.get___Mri( ).getLri( ) );

        assertTrue( set.contains( mofClass ) );
        assertTrue( set.contains( dummy ) );

        boolean removed = set.remove( dummy );
        assertTrue( removed );
        assertEquals( 0, set.size( ) );
    }
}