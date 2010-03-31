// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: Timer.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import java.util.Vector;

@SuppressWarnings( "nls" )
public class Timer {

    public class Entry {

        Timeable obj;

        long expiration;

        Entry( Timeable timeable, long l ) {

            obj = timeable;
            expiration = l;
        }
    }

    public static interface Timeable {

        public abstract void timeout( );
    }

    public Timer( ) {

        entries = new Vector<Entry>( );
        acceptingRequests = true;
        Thread thread = new Thread( ) {

            @Override
            public void run( ) {

                try {
                    Entry entry;
                    for ( ; ( entry = getNextEntry( ) ) != null; entry = null ) {
                        entry.obj.timeout( );
                    }

                } catch ( InterruptedException interruptedexception ) {
                }
            }

        };
        thread.setName( "Timer" + nextThreadNum( ) );
        thread.setDaemon( true );
        thread.start( );
    }

    private static synchronized int nextThreadNum( ) {

        return threadInitNumber++;
    }

    public synchronized Entry requestDelayedCallback( Timeable timeable, long l ) {

        try {
            long l1 = System.currentTimeMillis( ) + l;
            Entry entry = new Entry( timeable, l1 );
            for ( int i = 0; i < entries.size( ); i++ ) {
                Entry entry1 = entries.elementAt( i );
                if ( entry.expiration < entry1.expiration ) {
                    entries.insertElementAt( entry, i );
                    Entry entry3 = entry;
                    return entry3;
                }
            }

            entries.addElement( entry );
            Entry entry2 = entry;
            return entry2;
        } finally {
            notify( );
        }
    }

    public synchronized void cancel( Entry entry ) {

        entries.removeElement( entry );
        notify( );
    }

    public synchronized void finished( ) {

        acceptingRequests = false;
        notify( );
    }

    private synchronized Entry getNextEntry( ) throws InterruptedException {

        while ( acceptingRequests ) {
            if ( entries.size( ) == 0 ) {
                wait( );
            } else {
                long l = System.currentTimeMillis( );
                Entry entry = entries.elementAt( 0 );
                if ( entry.expiration <= l ) {
                    entries.removeElementAt( 0 );
                    return entry;
                }
                wait( entry.expiration - l );
                l = System.currentTimeMillis( );
            }
        }
        return null;
    }

    private static int threadInitNumber;

    private Vector<Entry> entries;

    private boolean acceptingRequests;

}
