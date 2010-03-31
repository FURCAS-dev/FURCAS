// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: Status.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

@SuppressWarnings( "nls" )
public class Status {

    public static Status passed( String s ) {

        return new Status( 0, s );
    }

    public static Status failed( String s ) {

        return new Status( 1, s );
    }

    public static Status error( String s ) {

        return new Status( 2, s );
    }

    /**
     * @deprecated Method notApplicable is deprecated
     */

    @Deprecated
    public static Status notApplicable( String s ) {

        return new Status( 1, "Not Applicable: " + s );
    }

    static Status notRun( String s ) {

        return new Status( 3, s );
    }

    public boolean isPassed( ) {

        return type == 0;
    }

    public boolean isFailed( ) {

        return type == 1;
    }

    public boolean isError( ) {

        return type == 2;
    }

    public int getType( ) {

        return type;
    }

    public String getReason( ) {

        return reason;
    }

    public Status augment( String s ) {

        if ( s == null || s.length( ) == 0 ) {
            return this;
        } else {
            return new Status( type, reason + " [" + s + "]" );
        }
    }

    public Status augment( Status status ) {

        return status != null ? augment( status.reason ) : this;
    }

    public static Status parse( String s ) {

        try {
            return new Status( s );
        } catch ( IllegalArgumentException illegalargumentexception ) {
            return null;
        }
    }

    private Status( String s ) {

        for ( int i = 0; i < texts.length; i++ ) {
            if ( s.startsWith( texts[i] ) ) {
                int j = texts[i].length( );
                String s1;
                if ( j < s.length( ) ) {
                    if ( s.charAt( j ) == ' ' ) {
                        s1 = s.substring( j + 1 );
                    } else {
                        s1 = s.substring( j );
                    }
                } else {
                    s1 = "";
                }
                type = i;
                reason = s1;
                return;
            }
        }

        throw new IllegalArgumentException( );
    }

    @Override
    public String toString( ) {

        if ( reason == null || reason.length( ) == 0 ) {
            return texts[type];
        } else {
            return texts[type] + " " + reason;
        }
    }

    public static String typeToString( int i ) {

        if ( i < 4 ) {
            return texts[i];
        } else {
            return null;
        }
    }

    public void exit( ) {

        if ( System.err != null ) {
            System.err.print( "STATUS:" );
            System.err.print( texts[type] );
            System.err.println( reason );
            System.err.flush( );
        }
        System.exit( exitCodes[type] );
    }

    public Status( int i, String s ) {

        for ( int j = 0; j < s.length( ); j++ ) {
            if ( isPrintable( s.charAt( j ) ) ) {
                continue;
            }
            StringBuffer stringbuffer = new StringBuffer( s.length( ) );
            for ( int k = 0; k < s.length( ); k++ ) {
                char c = s.charAt( k );
                stringbuffer.append( isPrintable( c ) ? c : ' ' );
            }

            s = stringbuffer.toString( );
            break;
        }

        type = i;
        reason = s.trim( );
    }

    private static final boolean isPrintable( char c ) {

        return ' ' <= c && c < '\177';
    }

    public static final int PASSED = 0;

    public static final int FAILED = 1;

    public static final int ERROR = 2;

    public static final int NOT_RUN = 3;

    public static final int NUM_STATES = 4;

    private int type;

    private String reason;

    public static final String EXIT_PREFIX = "STATUS:";

    private static String texts[] = { "Passed.", "Failed.", "Error.", "Not run." };

    public static final int exitCodes[] = { 95, 97, 98, 99 };

}
