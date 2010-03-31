/*
 * Created on 03.08.2005
 */
package com.sap.tc.moin.repository.test.core;


import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Test;

import com.sap.tc.moin.repository.shared.util.Notifyee;
import com.sap.tc.moin.repository.shared.util.NotifyingWeakHashMap;
import com.sap.tc.moin.repository.shared.util.WeakHashMapWithReferenceQueue;

public class TestNotifyingWeakHashMap extends CoreMoinTest {

    private Entry e1;

    private Entry e2;

    private Entry e3;

    List trace;

    private class CallbackProvider implements Notifyee {

        public void notifyOnObjectRemoved( boolean garbageCollected, Object context ) {

            NoIn ni = new NoIn( (String) context, garbageCollected );
            synchronized ( trace ) {
                trace.add( ni );
            }
        }
    }

    private static class NoIn implements Comparable {

        public NoIn( String context, boolean garbageCollected ) {

            this.context = context != null ? new String( context ) : null;
            this.garbageCollected = garbageCollected;
        }

        private String context;

        private boolean garbageCollected;

        @Override
        public int hashCode( ) {

            int result = 17;
            result = 37 * result + ( context != null ? context.hashCode( ) : 0 );
            result = 37 * result + ( garbageCollected ? 0 : 1 );
            return result;
        }

        @Override
        public boolean equals( Object obj ) {

            boolean result = false;
            if ( obj instanceof NoIn ) {
                NoIn right = (NoIn) obj;
                result = ( context != null && context.equals( right.context ) || context == null && right.context == null ) && ( garbageCollected == right.garbageCollected );
            }
            return result;
        }

        public int compareTo( Object o ) {

            NoIn noIn = (NoIn) o;
            int result;
            result = this.context.compareTo( noIn == null ? null : noIn.context );
            if ( result == 0 ) {
                result = ( this.garbageCollected ? 0 : 1 ) - ( noIn.garbageCollected ? 0 : 1 );
            }
            return result;
        }

        @Override
        public String toString( ) {

            return "Context=" + context.toString( ) + " reason=" + ( garbageCollected ? "garbageCollected" : "removed" );
        }

        public static List toList( NoIn[] array ) {

            List result = new ArrayList( );
            for ( int i = 0; i < array.length; i++ ) {
                result.add( array[i] );
            }
            return result;
        }
    }

    private static class Entry {

        public String getKey( ) {

            return this.key;
        }

        public void setKey( String key ) {

            this.key = key;
        }

        public String getValue( ) {

            return this.value;
        }

        public void setValue( String value ) {

            this.value = value;
        }

        public String getContext( ) {

            return this.context;
        }

        public void setContext( String context ) {

            this.context = context;
        }

        private String key;

        private String value;

        private String context;

        public Entry( String key, String value, String context ) {

            setKey( new String( key ) );
            setValue( new String( value ) );
            setContext( new String( context ) );
        }

        public Entry( String key, String value, String prefix, String suffix, int no ) {

            setKey( new String( key ) );
            setValue( new String( value ) );
            setContext( createContext( new String( prefix ), new String( suffix ), no ) );
        }

        public static final String createContext( String prefix, String suffix, int no ) {

            String result = prefix + "::" + suffix + "::" + no;
            return result;
        }

        public Entry cloneEntry( ) {

            Entry result = new Entry( key != null ? new String( key ) : null, value != null ? new String( value ) : null, context != null ? new String( context ) : null );
            return result;
        }

        public static HashMap toMap( String[][] array ) {

            HashMap result = new HashMap( );
            for ( int i = 0; i < array.length; i++ ) {
                result.put( array[i][0], array[i][1] );
            }
            return result;
        }
    }

    public final void testRemove1( ) {

        System.out.println( "\n" + "testRemove1" );
        trace = new ArrayList( );
        CallbackProvider callbackProvider = new CallbackProvider( );
        initEntries( "testRemove1" );

        NotifyingWeakHashMap nwhm = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm.put( e1.getKey( ), e1.getValue( ), e1.getContext( ), callbackProvider );
        assertEquals( Entry.toMap( new String[][] { { e1.getKey( ), e1.getValue( ) } } ), nwhm );
        nwhm.remove( e1.getKey( ) );
        assertEquals( Entry.toMap( new String[][] {} ), nwhm );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), false ) } ), trace );
    }

    public final void testRemove3( ) {

        System.out.println( "\n" + "testRemove3" );
        trace = new ArrayList( );
        CallbackProvider callbackProvider = new CallbackProvider( );
        initEntries( "testRemove3" );

        NotifyingWeakHashMap nwhm = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm.put( e1.getKey( ), e1.getValue( ), e1.getContext( ), callbackProvider );
        nwhm.put( e2.getKey( ), e2.getValue( ), e2.getContext( ), callbackProvider );
        nwhm.put( e3.getKey( ), e3.getValue( ), e3.getContext( ), callbackProvider );
        assertEquals( Entry.toMap( new String[][] { { e1.getKey( ), e1.getValue( ) }, { e2.getKey( ), e2.getValue( ) }, { e3.getKey( ), e3.getValue( ) } } ), nwhm );
        nwhm.remove( e1.getKey( ) );
        nwhm.remove( e2.getKey( ) );
        nwhm.remove( e3.getKey( ) );
        assertEquals( Entry.toMap( new String[][] {} ), nwhm );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), false ), new NoIn( e2.getContext( ), false ), new NoIn( e3.getContext( ), false ) } ), trace );
    }

    public final void testClear1( ) {

        System.out.println( "\n" + "testClear1" );
        trace = new ArrayList( );
        CallbackProvider callbackProvider = new CallbackProvider( );
        initEntries( "testClear1" );

        NotifyingWeakHashMap nwhm = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm.put( e1.getKey( ), e1.getValue( ), e1.getContext( ), callbackProvider );
        nwhm.clear( );
        assertEquals( Entry.toMap( new String[][] {} ), nwhm );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), false ) } ), trace );
    }

    public final void testClear3( ) {

        System.out.println( "\n" + "testClear3" );
        trace = new ArrayList( );
        CallbackProvider callbackProvider = new CallbackProvider( );
        initEntries( "testClear3" );

        NotifyingWeakHashMap nwhm = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm.put( e1.getKey( ), e1.getValue( ), e1.getContext( ), callbackProvider );
        nwhm.put( e2.getKey( ), e2.getValue( ), e2.getContext( ), callbackProvider );
        nwhm.put( e3.getKey( ), e3.getValue( ), e3.getContext( ), callbackProvider );
        assertEquals( Entry.toMap( new String[][] { { e1.getKey( ), e1.getValue( ) }, { e2.getKey( ), e2.getValue( ) }, { e3.getKey( ), e3.getValue( ) } } ), nwhm );
        nwhm.clear( );
        assertEquals( Entry.toMap( new String[][] {} ), nwhm );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), false ), new NoIn( e2.getContext( ), false ), new NoIn( e3.getContext( ), false ) } ), trace );
    }

    public final void testPutAndGC( ) {

        System.out.println( "\n" + "testPutAndGC" );
        trace = new ArrayList( );
        CallbackProvider callbackProvider = new CallbackProvider( );
        initEntries( "testPutAndGC" );

        NotifyingWeakHashMap nwhm = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm.put( e1.getKey( ), e1.getValue( ), e1.getContext( ), callbackProvider );
        nwhm.put( e2.getKey( ), e2.getValue( ), e2.getContext( ), callbackProvider );
        assertEquals( Entry.toMap( new String[][] { { e1.getKey( ), e1.getValue( ) }, { e2.getKey( ), e2.getValue( ) } } ), nwhm );
        e1.setKey( null );
        e2.setKey( null );
        gc( 2 );
        assertEquals( Entry.toMap( new String[][] {} ), nwhm );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), true ), new NoIn( e2.getContext( ), true ) } ), trace );
        nwhm.put( e3.getKey( ), e3.getValue( ), e3.getContext( ), callbackProvider );
        assertEquals( Entry.toMap( new String[][] { { e3.getKey( ), e3.getValue( ) } } ), nwhm );
        e3.setKey( null );
        gc( 3 );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), true ), new NoIn( e2.getContext( ), true ), new NoIn( e3.getContext( ), true ) } ), trace );
    }

    public final void testPutAndGCWith2Maps( ) {

        System.out.println( "\n" + "testPutAndGCWith2Maps" );
        trace = new ArrayList( );
        CallbackProvider callbackProvider = new CallbackProvider( );
        initEntries( "testPutAndGCWith2Maps" );

        NotifyingWeakHashMap nwhm1 = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm1.put( e1.getKey( ), e1.getValue( ), e1.getContext( ), callbackProvider );
        nwhm1.put( e2.getKey( ), e2.getValue( ), e2.getContext( ), callbackProvider );
        NotifyingWeakHashMap nwhm2 = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm2.put( e1.getKey( ), e1.getValue( ), e1.getContext( ) + "_", callbackProvider );
        nwhm2.put( e2.getKey( ), e2.getValue( ), e2.getContext( ) + "_", callbackProvider );
        e1.setKey( null );
        e2.setKey( null );
        gc( 4 );
        assertEquals( Entry.toMap( new String[][] {} ), nwhm1 );
        assertEquals( Entry.toMap( new String[][] {} ), nwhm2 );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), true ), new NoIn( e2.getContext( ), true ), new NoIn( e1.getContext( ) + "_", true ), new NoIn( e2.getContext( ) + "_", true ) } ), trace );
    }

    public final void testAdditionalRegistration( ) {

        System.out.println( "\n" + "testAdditionalRegistration" );
        trace = new ArrayList( );
        CallbackProvider callbackProvider1 = new CallbackProvider( );
        CallbackProvider callbackProvider2 = new CallbackProvider( );
        initEntries( "testAdditionalRegistration" );

        NotifyingWeakHashMap nwhm1 = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm1.put( e1.getKey( ), e1.getValue( ), e1.getContext( ), callbackProvider1 );
        nwhm1.register( e1.getKey( ), e1.getContext( ) + "_", callbackProvider2 );
        nwhm1.remove( e1.getKey( ) );
        gc( 2 );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), false ), new NoIn( e1.getContext( ) + "_", false ) } ), trace );
        trace = new ArrayList( );
        nwhm1.put( e1.getKey( ), e1.getValue( ), e1.getContext( ), callbackProvider1 );
        nwhm1.register( e1.getKey( ), e1.getContext( ) + "_", callbackProvider2 );
        nwhm1.deregister( e1.getKey( ), callbackProvider2 );
        nwhm1.remove( e1.getKey( ) );
        gc( 1 );
        assertEquals( NoIn.toList( new NoIn[] { new NoIn( e1.getContext( ), false ) } ), trace );
    }

    public final void testNoRegistration( ) {

        System.out.println( "\n" + "testNoRegistration" );
        trace = new ArrayList( );
        CallbackProvider callbackProvider1 = new CallbackProvider( );
        initEntries( "testNoRegistration" );

        NotifyingWeakHashMap nwhm = new NotifyingWeakHashMap( getTestHelper( ).getHousekeepingReferenceQueue( ) );
        nwhm.put( e1.getKey( ), e1.getValue( ) );
        e1.setKey( null );
        gc( 0 );
        assertEquals( Entry.toMap( new String[][] {} ), nwhm );
        assertEquals( NoIn.toList( new NoIn[] {} ), trace );
    }

    @Test
    public void testNotifyingWeakHashMap( ) {

        ReferenceQueue q = new ReferenceQueue( );
        WeakHashMapWithReferenceQueue map = new WeakHashMapWithReferenceQueue( q );
        Object s1 = new Object( );
        Object s2 = new Object( );
        Object s3 = new Object( );
        Integer i1 = new Integer( 1 );
        Integer i2 = new Integer( 2 );
        Integer i3 = new Integer( 3 );
        map.put( s1, i1 );
        map.put( s2, i2 );
        map.put( s3, i3 );
        s2 = null;
        s3 = null;
        System.gc( );
        int cleared = 0;
        java.lang.ref.Reference r;
        while ( ( r = q.poll( ) ) != null ) {
            WeakHashMapWithReferenceQueue.KeyWeakReference kwr = (WeakHashMapWithReferenceQueue.KeyWeakReference) r;
            assertTrue( "expected to find either i2 or i3 but found " + kwr.getValue( ), kwr.getValue( ) == i2 || kwr.getValue( ) == i3 );
            int oldSize = map.size( );
            map.remove( kwr );
            assertTrue( "expected remove to decrease size of map by one", map.size( ) == oldSize - 1 );
        }
    }

    private void assertEquals( List expected, List actual ) {

        Collections.sort( expected );
        Collections.sort( actual );
        assertTrue( "unexpected notifications", expected.equals( actual ) );
    }

    private void assertEquals( Map expected, Map actual ) {

        assertTrue( "unexpected content of Maps", expected.equals( actual ) );
    }

    private final void gc( int targetCount ) {

        System.gc( );
        for ( int i = 0; i < 10 && ( targetCount > 0 ? trace.size( ) != targetCount : i < 10 ); i++ ) {
            System.gc( );
            try {
                Thread.sleep( 60 );
            } catch ( InterruptedException e ) {
                // do nothing about it
            }
        }
    }

    private void initEntries( String name ) {

        e1 = new Entry( "key1", "value1", name, "context", 1 );
        e2 = new Entry( "key2", "value2", name, "context", 2 );
        e3 = new Entry( "key3", "value3", name, "context", 3 );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        e1 = null;
        e2 = null;
        e3 = null;
    }
}