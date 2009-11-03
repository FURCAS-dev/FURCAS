// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: JThttpProvider.java

package com.sap.tc.moin.repository.test.jmitck.javatest.httpd;

import java.io.PrintWriter;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.DynamicArray;

// Referenced classes of package com.sun.javatest.httpd:
// httpURL

@SuppressWarnings( "nls" )
public abstract class JThttpProvider {

    public JThttpProvider( ) {

        regURLs = new String[0];
    }

    public abstract void serviceRequest( httpURL httpurl, PrintWriter printwriter );

    public String getRootURL( ) {

        if ( regURLs != null && regURLs.length > 0 ) {
            return regURLs[0];
        } else {
            return null;
        }
    }

    public String[] getRegisteredURLs( ) {

        String as[] = new String[regURLs.length];
        System.arraycopy( regURLs, 0, as, 0, regURLs.length );
        return as;
    }

    protected static void print( PrintWriter printwriter, String s ) {

        if ( s == null ) {
            return;
        } else {
            printwriter.print( filterTags( s ) );
            return;
        }
    }

    protected static void println( PrintWriter printwriter, String s ) {

        if ( s == null ) {
            return;
        } else {
            printwriter.println( filterTags( s ) );
            return;
        }
    }

    protected static String filterTags( String s ) {

        int k = 0;
        if ( s == null ) {
            return null;
        }
        StringBuffer stringbuffer;
        for ( stringbuffer = new StringBuffer( s ); k < stringbuffer.length( ); k++ ) {
            char c = stringbuffer.charAt( k );
            if ( c == '<' ) {
                stringbuffer.setCharAt( k, '&' );
                stringbuffer.insert( k + 1, "lt;" );
                k += 3;
            } else if ( c == '>' ) {
                stringbuffer.setCharAt( k, '&' );
                stringbuffer.insert( k + 1, "gt;" );
                k += 3;
            }
        }

        return stringbuffer.toString( );
    }

    void addRegistredURL( String s ) {

        if ( s != null ) {
            regURLs = (String[]) DynamicArray.append( regURLs, s );
            if ( debug ) {
                System.out.println( "PROV-registred URL (" + s + ") in " + this );
            }
        }
    }

    void removeRegisteredURL( String s ) {

        for ( int i = 0; i < regURLs.length; i++ ) {
            if ( !regURLs[i].equals( s ) ) {
                continue;
            }
            regURLs = (String[]) DynamicArray.remove( regURLs, i );
            break;
        }

    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private String regURLs[];

    protected static boolean debug;

    static {
        debug = Boolean.getBoolean( "debug." + ( com.sap.tc.moin.repository.test.jmitck.javatest.httpd.JThttpProvider.class ).getName( ) );
    }
}
