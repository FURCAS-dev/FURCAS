// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: httpURL.java

package com.sap.tc.moin.repository.test.jmitck.javatest.httpd;

import java.util.Properties;

@SuppressWarnings( "nls" )
public class httpURL {

    public static class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        public Throwable getException( ) {

            return orig;
        }

        private Throwable orig;

        public Fault( String s ) {

            super( s );
        }
    }

    public httpURL( String s ) {

        lPort = -1;
        urlValues = new Properties( );
        firstQ = s.indexOf( '?' );
        file = s;
        fileLen = file.length( );
        resetIterator( );
        if ( firstQ != -1 ) {
            parseURLKeys( );
        }
    }

    public String getNextFile( ) {

        if ( pathPos == fileLen ) {
            return null;
        }
        String s;
        if ( pathPos == fileLen - 1 ) {
            if ( fileLen == 1 && file.charAt( 0 ) == '/' ) {
                s = "/";
                pathPos = fileLen;
            } else {
                s = file.substring( pathPos, fileLen );
                pathPos = fileLen;
            }
        } else {
            int i = file.indexOf( '/', pathPos + 1 );
            if ( i == -1 ) {
                String s1 = file.substring( pathPos, firstQ != -1 ? firstQ : fileLen );
                pathPos = fileLen;
                s = s1;
            } else {
                s = file.substring( pathPos, i );
                pathPos = i + 1;
            }
        }
        return s;
    }

    public void resetIterator( ) {

        if ( file.indexOf( '/' ) == 0 && fileLen > 1 ) {
            pathPos = 1;
        } else {
            pathPos = 0;
        }
    }

    public String getFullPath( ) {

        return file;
    }

    public String getLocalHost( ) throws Fault {

        if ( lHost == null ) {
            throw new Fault( "Local hostname for URL not available" );
        } else {
            return lHost;
        }
    }

    public int getLocalPort( ) throws Fault {

        if ( lPort == -1 ) {
            throw new Fault( "Local port for URL not available" );
        } else {
            return lPort;
        }
    }

    public String getRemoteHost( ) throws Fault {

        if ( rHost == null ) {
            throw new Fault( "Remote hostname for URL not available" );
        } else {
            return rHost;
        }
    }

    public String[] getKeys( ) {

        return null;
    }

    public String[] getValues( ) {

        return null;
    }

    public String getValue( String s ) {

        return urlValues.getProperty( s );
    }

    public static String reassemblePath( String as[], boolean flag, boolean flag1 ) {

        if ( as == null || as.length == 0 ) {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer( );
        if ( flag ) {
            stringbuffer.append( "/" );
        }
        for ( int i = 0; i < as.length; i++ ) {
            if ( as[i] != null ) {
                stringbuffer.append( as );
                stringbuffer.append( "/" );
            }
        }

        if ( !flag1 && stringbuffer.length( ) > 1 ) {
            stringbuffer.setLength( stringbuffer.length( ) - 1 );
        }
        return stringbuffer.toString( );
    }

    void setRemoteHost( String s ) {

        rHost = s;
    }

    void setLocalHost( String s ) {

        lHost = s;
    }

    void setLocalPort( int i ) {

        lPort = i;
    }

    private void parseURLKeys( ) {

        String s = file.substring( firstQ + 1, fileLen );
        if ( s.length( ) == 0 ) {
            return;
        }
        String s1 = null;
        int i = 0;
        int j = s.length( );
        while ( ( s1 = readSegment( s, i, j ) ) != null ) {
            i += s1.length( );
            if ( debug ) {
                System.out.println( "   Read key: " + s1 );
            }
            if ( i >= j || s.charAt( i ) == '&' ) {
                if ( debug ) {
                    System.out.println( "key: " + s1 + "  value: null" );
                }
                urlValues.put( s1, "true" );
                continue;
            }
            String s2 = readSegment( s, ++i, j );
            if ( debug ) {
                System.out.println( "key: " + s1 + "  value: " + s2 );
            }
            urlValues.put( s1, s2 );
            i = i + s2.length( ) + 1;
            if ( i > j ) {
                break;
            }
        }
    }

    private String readSegment( String s, int i, int j ) {

        StringBuffer stringbuffer = new StringBuffer( );
        for ( int k = i; k < j && s.charAt( k ) != '&' && s.charAt( k ) != '='; k++ ) {
            stringbuffer.append( s.charAt( k ) );
        }

        return stringbuffer.length( ) != 0 ? stringbuffer.toString( ) : null;
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private String lHost;

    private int lPort;

    private String rHost;

    private int pathPos;

    private int firstQ;

    protected static boolean debug;

    private String file;

    private int fileLen;

    private Properties urlValues;

    static {
        debug = Boolean.getBoolean( "debug." + ( com.sap.tc.moin.repository.test.jmitck.javatest.httpd.httpURL.class ).getName( ) );
    }
}
