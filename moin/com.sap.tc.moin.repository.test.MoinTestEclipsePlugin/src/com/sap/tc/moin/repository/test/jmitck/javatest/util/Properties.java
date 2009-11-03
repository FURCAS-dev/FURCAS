// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: Properties.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

@SuppressWarnings( "nls" )
public class Properties extends Hashtable<String, String> {

    private static final long serialVersionUID = 1L;

    public Properties( ) {

        this( null );
    }

    public Properties( Properties properties ) {

        defaults = properties;
    }

    public synchronized void load( Reader reader ) throws IOException {

        int i = reader.read( );
        do {
            switch ( i ) {
                case -1:
                    return;

                case 33: // '!'
                case 35: // '#'
                    do {
                        i = reader.read( );
                    } while ( i >= 0 && i != 10 && i != 13 );
                    break;

                case 9: // '\t'
                case 10: // '\n'
                case 13: // '\r'
                case 32: // ' '
                    i = reader.read( );
                    break;

                default:
                    StringBuffer stringbuffer = new StringBuffer( );
                    for ( ; i >= 0 && i != 61 && i != 58 && i != 32 && i != 9 && i != 10 && i != 13; i = reader.read( ) ) {
                        stringbuffer.append( (char) i );
                    }

                    for ( ; i == 32 || i == 9; i = reader.read( ) ) {
                    }
                    if ( i == 61 || i == 58 ) {
                        i = reader.read( );
                    }
                    for ( ; i == 32 || i == 9; i = reader.read( ) ) {
                    }
                    StringBuffer stringbuffer1 = new StringBuffer( );
                    while ( i >= 0 && i != 10 && i != 13 ) {
                        int j = 0;
                        if ( i == 92 ) {
                            switch ( i = reader.read( ) ) {
                                case 13: // '\r'
                                    if ( ( i = reader.read( ) ) != 10 && i != 32 && i != 9 ) {
                                        continue;
                                        // fall through
                                    }
                                case 10: // '\n'
                                    while ( ( i = reader.read( ) ) == 32 || i == 9 ) {
                                    }
                                    continue;
                                case 116: // 't'
                                    i = 9;
                                    j = reader.read( );
                                    break;
                                case 110: // 'n'
                                    i = 10;
                                    j = reader.read( );
                                    break;
                                case 114: // 'r'
                                    i = 13;
                                    j = reader.read( );
                                    break;
                                case 117: // 'u'
                                    while ( ( i = reader.read( ) ) == 117 ) {
                                    }
                                    int k = 0;
                                    label0: for ( int l = 0; l < 4; l++ ) {
                                        j = reader.read( );
                                        switch ( i ) {
                                            case 58: // ':'
                                            case 59: // ';'
                                            case 60: // '<'
                                            case 61: // '='
                                            case 62: // '>'
                                            case 63: // '?'
                                            case 64: // '@'
                                            case 71: // 'G'
                                            case 72: // 'H'
                                            case 73: // 'I'
                                            case 74: // 'J'
                                            case 75: // 'K'
                                            case 76: // 'L'
                                            case 77: // 'M'
                                            case 78: // 'N'
                                            case 79: // 'O'
                                            case 80: // 'P'
                                            case 81: // 'Q'
                                            case 82: // 'R'
                                            case 83: // 'S'
                                            case 84: // 'T'
                                            case 85: // 'U'
                                            case 86: // 'V'
                                            case 87: // 'W'
                                            case 88: // 'X'
                                            case 89: // 'Y'
                                            case 90: // 'Z'
                                            case 91: // '['
                                            case 92: // '\\'
                                            case 93: // ']'
                                            case 94: // '^'
                                            case 95: // '_'
                                            case 96: // '`'
                                            default:
                                                break label0;

                                            case 48: // '0'
                                            case 49: // '1'
                                            case 50: // '2'
                                            case 51: // '3'
                                            case 52: // '4'
                                            case 53: // '5'
                                            case 54: // '6'
                                            case 55: // '7'
                                            case 56: // '8'
                                            case 57: // '9'
                                                k = ( ( k << 4 ) + i ) - 48;
                                                break;

                                            case 97: // 'a'
                                            case 98: // 'b'
                                            case 99: // 'c'
                                            case 100: // 'd'
                                            case 101: // 'e'
                                            case 102: // 'f'
                                                k = ( ( k << 4 ) + 10 + i ) - 97;
                                                break;

                                            case 65: // 'A'
                                            case 66: // 'B'
                                            case 67: // 'C'
                                            case 68: // 'D'
                                            case 69: // 'E'
                                            case 70: // 'F'
                                                k = ( ( k << 4 ) + 10 + i ) - 65;
                                                break;
                                        }
                                        i = j;
                                    }

                                    i = k;
                                    break;

                                default:
                                    j = reader.read( );
                                    break;
                            }
                        } else {
                            j = reader.read( );
                        }
                        stringbuffer1.append( (char) i );
                        i = j;
                    }
                    put( stringbuffer.toString( ), stringbuffer1.toString( ) );
                    break;
            }
        } while ( true );
    }

    public synchronized void save( Writer writer, String s ) {

        save( writer, s, false );
    }

    private void save( Writer writer, String s, boolean flag ) {

        PrintWriter printwriter = ( writer instanceof PrintWriter ) ? (PrintWriter) writer : new PrintWriter( writer, false );
        if ( s != null ) {
            printwriter.write( 35 );
            printwriter.println( s );
        }
        printwriter.write( 35 );
        printwriter.println( new Date( ) );
        for ( Enumeration<String> enumeration = keys( ); enumeration.hasMoreElements( ); printwriter.write( 10 ) ) {
            String s1 = enumeration.nextElement( );
            printwriter.print( s1 );
            printwriter.write( 61 );
            String s2 = get( s1 );
            int i = s2.length( );
            boolean flag1 = false;
            for ( int j = 0; j < i; j++ ) {
                char c = s2.charAt( j );
                switch ( c ) {
                    case 92: // '\\'
                        printwriter.write( 92 );
                        printwriter.write( 92 );
                        break;

                    case 9: // '\t'
                        printwriter.write( 92 );
                        printwriter.write( 116 );
                        break;

                    case 10: // '\n'
                        printwriter.write( 92 );
                        printwriter.write( 110 );
                        break;

                    case 13: // '\r'
                        printwriter.write( 92 );
                        printwriter.write( 114 );
                        break;

                    default:
                        if ( c < ' ' || c >= '\177' || flag1 && c == ' ' ) {
                            if ( c > '\377' && flag ) {
                                printwriter.write( c );
                            } else {
                                printwriter.write( 92 );
                                printwriter.write( 117 );
                                printwriter.write( toHex( c >> 12 & 0xf ) );
                                printwriter.write( toHex( c >> 8 & 0xf ) );
                                printwriter.write( toHex( c >> 4 & 0xf ) );
                                printwriter.write( toHex( c >> 0 & 0xf ) );
                            }
                        } else {
                            printwriter.write( c );
                        }
                        break;
                }
                flag1 = false;
            }

        }

    }

    public String getProperty( String s ) {

        Object obj = super.get( s );
        String s1 = ( obj instanceof String ) ? (String) obj : null;
        return s1 != null || defaults == null ? s1 : defaults.getProperty( s );
    }

    public String getProperty( String s, String s1 ) {

        String s2 = getProperty( s );
        return s2 != null ? s2 : s1;
    }

    public Enumeration<String> propertyNames( ) {

        Hashtable<String, String> hashtable = new Hashtable<String, String>( );
        enumerate( hashtable );
        return hashtable.keys( );
    }

    public void list( PrintWriter printwriter ) {

        printwriter.println( "-- listing properties --" );
        Hashtable<String, String> hashtable = new Hashtable<String, String>( );
        enumerate( hashtable );
        String s;
        String s1;
        for ( Enumeration<String> enumeration = hashtable.keys( ); enumeration.hasMoreElements( ); printwriter.println( s + "=" + s1 ) ) {
            s = enumeration.nextElement( );
            s1 = hashtable.get( s );
            if ( s1.length( ) > 40 ) {
                s1 = s1.substring( 0, 37 ) + "...";
            }
        }

    }

    private synchronized void enumerate( Hashtable<String, String> hashtable ) {

        if ( defaults != null ) {
            defaults.enumerate( hashtable );
        }
        String s;
        for ( Enumeration<String> enumeration = keys( ); enumeration.hasMoreElements( ); hashtable.put( s, get( s ) ) ) {
            s = enumeration.nextElement( );
        }

    }

    private static char toHex( int i ) {

        return hexDigit[i & 0xf];
    }

    protected Properties defaults;

    private static char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

}
