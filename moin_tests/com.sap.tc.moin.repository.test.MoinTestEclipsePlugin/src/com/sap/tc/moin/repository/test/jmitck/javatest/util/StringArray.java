// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: StringArray.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import java.util.Vector;

@SuppressWarnings( "nls" )
public class StringArray {

    public StringArray( ) {
    }

    public static String[] split( String s ) {

        if ( s == null ) {
            return empty;
        }
        Vector<String> vector = new Vector<String>( );
        int i = -1;
        for ( int j = 0; j < s.length( ); j++ ) {
            if ( white( s.charAt( j ) ) ) {
                if ( i != -1 ) {
                    vector.addElement( s.substring( i, j ) );
                }
                i = -1;
            } else if ( i == -1 ) {
                i = j;
            }
        }

        if ( i != -1 ) {
            vector.addElement( s.substring( i ) );
        }
        if ( vector.size( ) == 0 ) {
            return empty;
        } else {
            String as[] = new String[vector.size( )];
            vector.copyInto( as );
            return as;
        }
    }

    public static String join( String as[] ) {

        if ( as == null || as.length == 0 ) {
            return "";
        }
        int i = as.length - 1;
        for ( int j = 0; j < as.length; j++ ) {
            i += as[j].length( );
        }

        StringBuffer stringbuffer = new StringBuffer( i );
        stringbuffer.append( as[0] );
        for ( int k = 1; k < as.length; k++ ) {
            stringbuffer.append( ' ' );
            stringbuffer.append( as[k] );
        }

        return stringbuffer.toString( );
    }

    private static boolean white( char c ) {

        return c == ' ' || c == '\t' || c == '\n';
    }

    private static final String empty[] = new String[0];

}
