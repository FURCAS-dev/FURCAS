package com.sap.tc.moin.facility.primary.test.index;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.IndexOnly;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexArrayFastList;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexHashSetElement;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexHashSetFastLists;

public class TestIndexHashSets extends IndexTestCase {

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
     * Tests if the hash set reacts correctly if you put an element that causes
     * a wrap in the fast list.
     */
    @Test
    @IndexOnly
    public void testIndexHashSetFastLists_deleteAtWrap( ) {

        final Object key = new Object( );
        class Element implements IndexHashSetElement {

            public Object getKeyElement( int keyNr ) {

                return key;
            }
        }

        int elemCount = 65;

        IndexHashSetFastLists<Element> testHashSet = new IndexHashSetFastLists<Element>( 0 );

        Element e = null;
        for ( int i = 0; i < elemCount; i++ ) {
            e = new Element( );
            testHashSet.put( e );
        }

        IndexArrayFastList<Element> list = testHashSet.getUnderlyingForChange( key );
        int delPos = list.size( ) - 1;
        assertTrue( "expected " + elemCount + " elements in list. was " + list.size( ), list.size( ) == elemCount );
        list.remove( delPos );
        list.store( );
        assertTrue( "expected " + ( elemCount - 1 ) + " elements in list. was " + list.size( ), list.size( ) == elemCount - 1 );

        testHashSet.put( e );
        list = testHashSet.getUnderlyingForChange( key );
        assertTrue( "expected " + elemCount + " elements in list. was " + list.size( ), list.size( ) == elemCount );
    }
}
