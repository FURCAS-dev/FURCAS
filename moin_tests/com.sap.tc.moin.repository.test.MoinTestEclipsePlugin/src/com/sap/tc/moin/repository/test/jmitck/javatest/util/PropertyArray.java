// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: PropertyArray.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.LINE_SEPARATOR;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package com.sun.javatest.util:
// Properties

@SuppressWarnings( "nls" )
public class PropertyArray {

    public static class PropertyArrayError extends Error {

        private static final long serialVersionUID = 1L;

        public PropertyArrayError( ) {
        }

        public PropertyArrayError( String s ) {
            super( s );
        }
    }

    public PropertyArray( ) {

        locked = false;
    }

    public PropertyArray( Reader reader ) throws IOException {

        dataA = load( reader );
        locked = true;
    }

    public PropertyArray( Properties properties ) {

        dataA = getArray( properties );
        locked = true;
    }

    public PropertyArray( String as[] ) {

        locked = true;
        dataA = new String[as.length];
        for ( int i = 0; i < as.length; i++ ) {
            dataA[i] = as[i];
        }

    }

    public static String[] getArray( Properties properties ) {

        Enumeration<String> enumeration = properties.elements( );
        Enumeration<String> enumeration1 = properties.keys( );
        Vector<String> vector = new Vector<String>( properties.size( ), 2 );
        for ( ; enumeration1.hasMoreElements( ); insert( vector, enumeration1.nextElement( ), enumeration.nextElement( ) ) ) {
        }
        String as[] = new String[vector.size( )];
        vector.copyInto( as );
        return as;
    }

    public static String[] put( String as[], String s, String s1 ) {

        if ( s == null || s1 == null ) {
            throw new PropertyArrayError( "A key or value was null.  Null keys and values are illegal" );
        }
        if ( as == null ) {
            as = new String[0];
        }
        String as1[];
        Vector<String> vector = copyOutOf( as );
        as1 = new String[vector.size( )];
        vector.copyInto( as1 );
        return as1;
    }

    public static String get( String as[], String s ) {

        if ( as == null || as.length == 0 || s == null ) {
            return null;
        }
        int i = 0;
        int j = as.length - 2;
        if ( j < 0 ) {
            return null;
        }
        String s1 = as[j];
        int l = s.compareTo( s1 );
        if ( l > 0 ) {
            return null;
        }
        while ( i <= j ) {
            int k = i + ( ( j - i ) / 4 ) * 2;
            String s2 = as[k];
            int i1 = s.compareTo( s2 );
            if ( i1 < 0 ) {
                j = k - 2;
            } else if ( i1 > 0 ) {
                i = k + 2;
            } else {
                return as[k + 1];
            }
        }
        return null;
    }

    public static String[] remove( String as[], String s ) {

        Vector<String> vector = copyOutOf( as );
        int i = 0;
        int j = vector.size( ) - 2;
        if ( j < 0 ) {
            return as;
        }
        String s2 = vector.elementAt( j );
        int l = s.compareTo( s2 );
        if ( l > 0 ) {
            return as;
        }
        while ( i <= j ) {
            int k = i + ( ( j - i ) / 4 ) * 2;
            String s3 = vector.elementAt( k );
            int i1 = s.compareTo( s3 );
            if ( i1 < 0 ) {
                j = k - 2;
                continue;
            }
            if ( i1 > 0 ) {
                i = k + 2;
                continue;
            }
            vector.removeElementAt( k );
            vector.removeElementAt( k );
            break;
        }
        String as1[] = new String[vector.size( )];
        vector.copyInto( as1 );
        return as1;
    }

    public static Properties getProperties( String as[] ) {

        Properties properties = null;
        if ( as == null || as.length == 0 ) {
            properties = new Properties( );
        } else {
            properties = new Properties( );
            for ( int i = 0; i < as.length; i += 2 ) {
                properties.put( as[i], as[i + 1] );
            }

        }
        return properties;
    }

    public static void save( String as[], Writer writer ) throws IOException {

        if ( as == null || as.length == 0 ) {
            return;
        }
        for ( int i = 0; i < as.length; i += 2 ) {
            writer.write( as[i] );
            writer.write( 61 );
            String s = as[i + 1];
            int j = s.length( );
            boolean flag = false;
            for ( int k = 0; k < j; k++ ) {
                char c = s.charAt( k );
                switch ( c ) {
                    case 92: // '\\'
                        writer.write( 92 );
                        writer.write( 92 );
                        break;

                    case 9: // '\t'
                        writer.write( 92 );
                        writer.write( 116 );
                        break;

                    case 10: // '\n'
                        writer.write( 92 );
                        writer.write( 110 );
                        break;

                    case 13: // '\r'
                        writer.write( 92 );
                        writer.write( 114 );
                        break;

                    default:
                        if ( c < ' ' || c >= '\177' || flag && c == ' ' ) {
                            writer.write( 92 );
                            writer.write( 117 );
                            writer.write( toHex( c >> 12 & 0xf ) );
                            writer.write( toHex( c >> 8 & 0xf ) );
                            writer.write( toHex( c >> 4 & 0xf ) );
                            writer.write( toHex( c >> 0 & 0xf ) );
                        } else {
                            writer.write( c );
                        }
                        break;
                }
                flag = false;
            }

            writer.write( lineSeparator );
        }

    }

    public static String[] load( Reader reader ) throws IOException {

        Vector<String> vector = new Vector<String>( );
        int i = 0;
        i = 10;
        label0: do {
            switch ( i ) {
                case -1:
                    break label0;

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
                    int j = 0;
                    do {
                        if ( i == 10 && ++j > 1 ) {
                            break label0;
                        }
                        i = reader.read( );
                    } while ( i == 10 || i == 13 || i == 9 || i == 32 );
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
                        int k = 0;
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
                                    k = reader.read( );
                                    break;
                                case 110: // 'n'
                                    i = 10;
                                    k = reader.read( );
                                    break;
                                case 114: // 'r'
                                    i = 13;
                                    k = reader.read( );
                                    break;
                                case 117: // 'u'
                                    while ( ( i = reader.read( ) ) == 117 ) {
                                    }
                                    int l = 0;
                                    label1: for ( int i1 = 0; i1 < 4; i1++ ) {
                                        k = reader.read( );
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
                                                break label1;

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
                                                l = ( ( l << 4 ) + i ) - 48;
                                                break;

                                            case 97: // 'a'
                                            case 98: // 'b'
                                            case 99: // 'c'
                                            case 100: // 'd'
                                            case 101: // 'e'
                                            case 102: // 'f'
                                                l = ( ( l << 4 ) + 10 + i ) - 97;
                                                break;

                                            case 65: // 'A'
                                            case 66: // 'B'
                                            case 67: // 'C'
                                            case 68: // 'D'
                                            case 69: // 'E'
                                            case 70: // 'F'
                                                l = ( ( l << 4 ) + 10 + i ) - 65;
                                                break;
                                        }
                                        i = k;
                                    }

                                    i = l;
                                    break;

                                default:
                                    k = reader.read( );
                                    break;
                            }
                        } else {
                            k = reader.read( );
                        }
                        stringbuffer1.append( (char) i );
                        i = k;
                    }
                    insert( vector, stringbuffer.toString( ), stringbuffer1.toString( ) );
                    break;
            }
        } while ( true );
        String as[] = new String[vector.size( )];
        vector.copyInto( as );
        return as;
    }

    public static Enumeration<String> enumerate( final String props[] ) {

        return new Enumeration<String>( ) {

            public boolean hasMoreElements( ) {

                return props != null && pos < props.length;
            }

            public String nextElement( ) {

                if ( props == null || pos >= props.length ) {
                    return null;
                } else {
                    String s = props[pos];
                    pos += 2;
                    return s;
                }
            }

            int pos;

            {
                pos = 0;
            }
        };
    }

    public Properties getProperties( ) {

        return getProperties( dataA );
    }

    public boolean isMutable( ) {

        return !locked;
    }

    public int size( ) {

        if ( dataA == null ) {
            return 0;
        } else {
            return dataA.length / 2;
        }
    }

    public String get( String s ) {

        return get( dataA, s );
    }

    public String[] getArray( ) {

        if ( dataA == null || dataA.length == 0 ) {
            return null;
        } else {
            return shallowCopy( dataA );
        }
    }

    public String put( String s, String s1 ) {

        if ( locked ) {
            throw new IllegalStateException( "PropertyArray is immutable." );
        }
        if ( s == null || s1 == null ) {
            throw new PropertyArrayError( "A key or value was null.  Null keys and values are illegal" );
        } else {
            Vector<String> vector = copyOutOf( dataA );
            String s2 = insert( vector, s, s1 );
            dataA = new String[vector.size( )];
            vector.copyInto( dataA );
            return s2;
        }
    }

    public void remove( String s ) {

        dataA = remove( dataA, s );
    }

    public void save( Writer writer ) throws IOException {

        save( dataA, writer );
    }

    private static String insert( Vector<String> vector, String s, String s1 ) {

        int i = 0;
        int j = vector.size( ) - 2;
        int k = 0;
        String s2 = null;
        if ( j < 0 ) {
            vector.addElement( s );
            vector.addElement( s1 );
            return s2;
        }
        String s3 = vector.elementAt( j );
        int l = s.compareTo( s3 );
        if ( l > 0 ) {
            vector.addElement( s );
            vector.addElement( s1 );
            return null;
        }
        while ( i <= j ) {
            k = i + ( ( j - i ) / 4 ) * 2;
            String s4 = vector.elementAt( k );
            l = s.compareTo( s4 );
            if ( l < 0 ) {
                j = k - 2;
                continue;
            }
            if ( l > 0 ) {
                i = k + 2;
                continue;
            }
            vector.removeElementAt( k );
            s2 = vector.elementAt( k );
            vector.removeElementAt( k );
            break;
        }
        if ( l > 0 ) {
            k += 2;
        }
        vector.insertElementAt( s, k );
        vector.insertElementAt( s1, k + 1 );
        return s2;
    }

    private static Vector<String> copyOutOf( String as[] ) {

        Vector<String> vector = null;
        if ( as == null ) {
            vector = new Vector<String>( 0, 2 );
        } else {
            vector = new Vector<String>( as.length, 2 );
            for ( int i = 0; i < as.length; i++ ) {
                vector.addElement( as[i] );
            }

        }
        return vector;
    }

    private static String[] shallowCopy( String as[] ) {

        if ( as == null ) {
            return null;
        }
        String as1[] = new String[as.length];
        for ( int i = 0; i < as.length; i++ ) {
            as1[i] = as[i];
        }

        return as1;
    }

    private static char toHex( int i ) {

        return hexDigit[i & 0xf];
    }

    private static char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    private static final String lineSeparator = System.getProperty( LINE_SEPARATOR );

    private String dataA[];

    private boolean locked;

}
