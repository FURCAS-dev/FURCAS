// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: PageGenerator.java

package com.sap.tc.moin.repository.test.jmitck.javatest.httpd;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.TimeZone;

@SuppressWarnings( "nls" )
public class PageGenerator {

    public PageGenerator( ) {
    }

    public static void generateOkHttp( PrintWriter printwriter ) {

        printwriter.println( "HTTP/1.1 200 OK" );
        genServerHdr( printwriter );
        printwriter.println( "Content-Type: text/html" );
        printwriter.println( );
    }

    public static void generateBadHttp( PrintWriter printwriter ) {

        printwriter.println( "HTTP/1.1 400 Bad Request" );
        genServerHdr( printwriter );
        printwriter.println( "Content-Type: text/html" );
    }

    public static void generateDocType( PrintWriter printwriter, int i ) {

        switch ( i ) {
            case 0: // '\0'
                printwriter.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2//EN\">" );
                break;

            case 1: // '\001'
                printwriter.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">" );
                break;
        }
    }

    public static void writeHeader( PrintWriter printwriter, String s ) {

        printwriter.println( "<Head>" );
        printwriter.print( "<Title>" );
        printwriter.print( s );
        printwriter.println( "</Title>" );
        printwriter.println( "</Head>" );
    }

    public static void writeBeginDoc( PrintWriter printwriter ) {

        printwriter.println( "<html>" );
    }

    public static void writeEndDoc( PrintWriter printwriter ) {

        printwriter.println( "</html>" );
    }

    public static void startBody( PrintWriter printwriter ) {

        printwriter.println( "<Body>" );
    }

    public static void endBody( PrintWriter printwriter ) {

        printwriter.println( "</Body>" );
    }

    public static void writeFooter( PrintWriter printwriter ) {

        printwriter.println( dateFormat.format( new Date( ) ) );
        printwriter.println( "<Address>" );
        printwriter.println( "Produced by " + swName + " " + swVersion );
        printwriter.println( "which was built on " + swBuildDate );
        printwriter.println( "</Address>" );
    }

    public static void writeDictionary( PrintWriter printwriter, Dictionary<Object, Object> dictionary, String s, String s1 ) {

        if ( s == null ) {
            s = "Key";
        }
        if ( s1 == null ) {
            s1 = "Value";
        }
        printwriter.println( "<Table Border>" );
        StringBuffer stringbuffer = new StringBuffer( 50 );
        stringbuffer.append( "<tr><th>" );
        stringbuffer.append( s );
        stringbuffer.append( "<th>" );
        stringbuffer.append( s1 );
        stringbuffer.append( "</tr>" );
        printwriter.println( stringbuffer.toString( ) );
        if ( dictionary == null || dictionary.size( ) == 0 ) {
            stringbuffer.setLength( 0 );
            stringbuffer.append( "<tr><td colspan=2>" );
            stringbuffer.append( "-EMPTY-" );
            stringbuffer.append( "</tr>" );
        } else {
            for ( Enumeration<Object> enumeration = dictionary.keys( ); enumeration.hasMoreElements( ); printwriter.println( "</tr>" ) ) {
                Object obj = enumeration.nextElement( );
                printwriter.println( "<tr>" );
                stringbuffer.setLength( 0 );
                stringbuffer.append( "<td>" );
                stringbuffer.append( obj.toString( ) );
                stringbuffer.append( "<td>" );
                stringbuffer.append( dictionary.get( obj ).toString( ) );
                printwriter.println( stringbuffer.toString( ) );
            }

        }
        printwriter.println( "</Table>" );
    }

    public static void startTable( PrintWriter printwriter, boolean flag ) {

        printwriter.print( "<Table" );
        if ( flag ) {
            printwriter.print( " Border" );
        }
        printwriter.println( ">" );
    }

    public static void endTable( PrintWriter printwriter ) {

        printwriter.println( "</Table>" );
    }

    public static String getSWBuildDate( ) {

        return swBuildDate;
    }

    public static String getSWName( ) {

        return swName;
    }

    public static String getSWVersion( ) {

        return swVersion;
    }

    public static void setSWBuildDate( String s ) {

        swBuildDate = s;
    }

    public static void setSWName( String s ) {

        swName = s;
    }

    public static void setSWVersion( String s ) {

        swVersion = s;
    }

    private static void genServerHdr( PrintWriter printwriter ) {

        if ( swName != null ) {
            printwriter.print( "Server: " );
            printwriter.print( swName );
            if ( swVersion != null ) {
                printwriter.print( "/" );
                printwriter.print( swVersion );
            }
            if ( swBuildDate != null ) {
                printwriter.print( "  built " );
                printwriter.print( swBuildDate );
            }
        }
        printwriter.println( );
        printwriter.print( "Date: " );
        printwriter.println( dateFormat.format( new Date( ) ) );
    }

    private static DateFormat dateFormat;

    private static String swBuildDate;

    private static String swName;

    private static String swVersion;

    public static final int HTML32 = 0;

    public static final int HTML40_TRANS = 1;

    static {
        dateFormat = DateFormat.getDateTimeInstance( 0, 1 );
        dateFormat.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
    }
}
