// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: Debug.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

@SuppressWarnings( "nls" )
public class Debug {

    private static class WildcardProperties extends Properties {

        private static final long serialVersionUID = 1L;

        public String search( String s ) {

            String s1 = s.toLowerCase( Locale.ENGLISH );
            String s2 = trimTarget( s1 );
            for ( Enumeration<?> enumeration = propertyNames( ); enumeration.hasMoreElements( ); ) {
                String s3 = (String) enumeration.nextElement( );
                String s4 = s3.toLowerCase( Locale.ENGLISH );
                if ( s4.startsWith( s2 ) ) {
                    String s5 = s4.substring( s2.length( ) );
                    String s6 = s4.substring( 0, s2.length( ) );
                    if ( s5.equals( ".*" ) || s6.equals( s1 ) ) {
                        return getProperty( s3 );
                    }
                }
            }

            return null;
        }

        String trimTarget( String s ) {

            int i = s.lastIndexOf( "." );
            if ( i != -1 ) {
                return s.substring( 0, i );
            } else {
                return s;
            }
        }

        static final String wildTail = ".*";

        private WildcardProperties( ) {

        }

    }

    private Debug( ) {

    }

    public static void print( String s ) {

        out.print( s );
        out.flush( );
    }

    public static void println( String s ) {

        out.println( s );
        out.flush( );
    }

    public static boolean isEnabled( ) {

        return masterSwitch;
    }

    public static String getSetting( String s ) {

        if ( !masterSwitch ) {
            return null;
        }
        String s1 = dProps.getProperty( s );
        if ( s1 != null ) {
            return s1;
        } else {
            String s2 = wildProps.search( s );
            return s2;
        }
    }

    public static boolean getBoolean( Class<?> class1 ) {

        init( false );
        if ( !masterSwitch ) {
            return false;
        } else {
            String s = getName( class1 );
            String s1 = getSetting( s );
            boolean flag = convertToBool( s1 );
            return flag;
        }
    }

    public static boolean getBoolean( Class<?> class1, String s ) {

        init( false );
        if ( !masterSwitch ) {
            return false;
        }
        StringBuffer stringbuffer = new StringBuffer( getName( class1 ) );
        if ( s != null && s.length( ) != 0 ) {
            stringbuffer.append( "." );
            stringbuffer.append( s );
        }
        String s1 = stringbuffer.toString( );
        String s2 = getSetting( s1 );
        boolean flag = convertToBool( s2 );
        return flag;
    }

    public static boolean getBoolean( String s ) {

        init( false );
        if ( !masterSwitch || s == null ) {
            return false;
        } else {
            String s1 = getSetting( s );
            boolean flag = convertToBool( s1 );
            return flag;
        }
    }

    public static int getInt( Class<?> class1 ) {

        init( false );
        if ( !masterSwitch || class1 == null ) {
            return 0;
        } else {
            String s = getName( class1 );
            String s1 = getSetting( s );
            int i = convertToInt( s1 );
            return i;
        }
    }

    public static int getInt( Class<?> class1, String s ) {

        init( false );
        if ( !masterSwitch || class1 == null ) {
            return 0;
        }
        StringBuffer stringbuffer = new StringBuffer( getName( class1 ) );
        if ( s != null && s.length( ) != 0 ) {
            stringbuffer.append( "." );
            stringbuffer.append( s );
        }
        String s1 = stringbuffer.toString( );
        String s2 = getSetting( s1 );
        int i = convertToInt( s2 );
        return i;
    }

    public static int getInt( String s ) {

        init( false );
        if ( !masterSwitch ) {
            return 0;
        } else {
            String s1 = getSetting( s );
            return convertToInt( s1 );
        }
    }

    public static PrintWriter getWriter( ) {

        return out;
    }

    public static void setProperties( Properties properties ) {

        givenProps = properties;
    }

    public static void init( boolean flag ) {

        if ( dProps != null && !flag ) {
            return;
        }
        Properties properties;
        try {
            properties = System.getProperties( );
        } catch ( SecurityException securityexception ) {
            properties = givenProps;
        }
        if ( properties == null ) {
            masterSwitch = false;
            return;
        }
        Enumeration<?> enumeration = properties.propertyNames( );
        dProps = new Properties( );
        wildProps = new WildcardProperties( );
        while ( enumeration.hasMoreElements( ) ) {
            String s = (String) enumeration.nextElement( );
            if ( s.startsWith( "debug." ) ) {
                if ( s.equalsIgnoreCase( "debug.disable" ) ) {
                    String s1 = properties.getProperty( s );
                    if ( s1.equalsIgnoreCase( "true" ) ) {
                        masterSwitch = false;
                    }
                } else if ( s.endsWith( "*" ) ) {
                    wildProps.put( s.substring( "debug.".length( ) ), properties.getProperty( s ) );
                } else {
                    dProps.put( s.substring( "debug.".length( ) ), properties.getProperty( s ) );
                }
            }
        }
    }

    private static String getName( Class<?> class1 ) {

        String s = class1.getName( );
        s = s.replace( '$', '.' );
        return s;
    }

    private static boolean convertToBool( String s ) {

        if ( s == null ) {
            return false;
        }
        if ( s.equalsIgnoreCase( "true" ) ) {
            return true;
        }
        try {
            int i = Integer.parseInt( s );
            return i > 0;
        } catch ( NumberFormatException numberformatexception ) {
            return false;
        }
    }

    private static int convertToInt( String s ) {

        if ( s == null ) {
            return 0;
        }
        if ( s.equalsIgnoreCase( "true" ) ) {
            return 1;
        }
        try {
            int i = Integer.parseInt( s );
            return i;
        } catch ( NumberFormatException numberformatexception ) {
            return 0;
        }
    }

    private static Properties givenProps;

    private static Properties dProps;

    private static WildcardProperties wildProps;

    private static PrintWriter out;

    private static boolean masterSwitch = true;

    static {
        out = new PrintWriter( System.err );
    }
}
