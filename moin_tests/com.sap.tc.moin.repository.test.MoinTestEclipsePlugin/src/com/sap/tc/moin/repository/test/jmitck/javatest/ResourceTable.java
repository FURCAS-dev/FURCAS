// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: ResourceTable.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings( "nls" )
public class ResourceTable {

    public ResourceTable( ) {

        table = new HashMap<String, Thread>( );
    }

    public ResourceTable( int i ) {

        table = new HashMap<String, Thread>( i );
    }

    public synchronized boolean acquire( String as[], int i ) throws InterruptedException {

        if ( i <= 0 ) {
            throw new IllegalArgumentException( "timeout required" );
        }
        if ( as.length > 1 ) {
            String as1[] = new String[as.length];
            System.arraycopy( as, 0, as1, 0, as1.length );
            Arrays.sort( as1 );
            as = as1;
        }
        long l = System.currentTimeMillis( );
        long l1 = l;
        try {
            for ( int j = 0; j < as.length; j++ ) {
                String s = as[j];
                for ( Object obj = null; ( obj = table.get( s ) ) != null; ) {
                    long l2 = ( l + i ) - l1;
                    if ( l2 < 0L ) {
                        release( as );
                        return false;
                    }
                    wait( l2 );
                    l1 = System.currentTimeMillis( );
                }

                table.put( s, Thread.currentThread( ) );
            }

            return true;
        } catch ( InterruptedException interruptedexception ) {
            release( as );
            throw interruptedexception;
        }
    }

    public synchronized void release( String as[] ) {

        for ( int i = 0; i < as.length; i++ ) {
            Object obj = table.get( as[i] );
            if ( obj == Thread.currentThread( ) ) {
                table.remove( as[i] );
            }
        }

        notifyAll( );
    }

    private HashMap<String, Thread> table;
}
