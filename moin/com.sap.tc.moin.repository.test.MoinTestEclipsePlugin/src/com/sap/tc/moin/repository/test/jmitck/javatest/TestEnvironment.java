// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestEnvironment.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.StringArray;

@SuppressWarnings( "nls" )
public class TestEnvironment {

    public class Element {

        public String getKey( ) {

            return key;
        }

        public String getValue( ) {

            return value;
        }

        public String getDefinedInEnv( ) {

            return definedInEnv;
        }

        public String getDefinedInFile( ) {

            return definedInFile;
        }

        String key;

        String value;

        String definedInEnv;

        String definedInFile;

        Element( String s, String s1, String s2, String s3 ) {

            key = s;
            value = s1;
            definedInEnv = s2;
            definedInFile = s3;
        }
    }

    public static class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        Fault( I18NResourceBundle i18nresourcebundle, String s ) {

            super( i18nresourcebundle.getString( s ) );
        }

        Fault( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

            super( i18nresourcebundle.getString( s, obj ) );
        }

        Fault( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

            super( i18nresourcebundle.getString( s, aobj ) );
        }
    }

    public TestEnvironment( ) {
    }

    public TestEnvironment( String s, Map<String, String>[] amap, String as[] ) throws Fault {

        table = new HashMap<String, Element>( );
        extras = new HashMap<String, String[]>( );
        cache = new HashMap<String, Element>( );
        name = s;
        Vector<String> vector = new Vector<String>( );
        String s1 = s;
        for ( String s2 = null; s1 != null && s1.length( ) > 0; s2 = null ) {
            if ( vector.contains( s1 ) ) {
                throw new Fault( i18n, "env.loop", s );
            }
            vector.addElement( s1 );
            for ( int j = amap.length - 1; j >= 0 && s2 == null; j-- ) {
                s2 = amap[j].get( "jmi." + s1 + ".inherits" );
            }

            s1 = s2;
        }

        inherits = new String[vector.size( )];
        vector.copyInto( inherits );
        for ( int i = 0; i < inherits.length; i++ ) {
            String s4 = "jmi." + inherits[i] + ".";
            for ( int l = amap.length - 1; l >= 0; l-- ) {
                Map<String, String> map1 = amap[l];
                for ( Iterator<String> iterator1 = map1.keySet( ).iterator( ); iterator1.hasNext( ); ) {
                    String s6 = iterator1.next( );
                    if ( s6.startsWith( s4 ) ) {
                        String s7 = s6.substring( s4.length( ) );
                        if ( !table.containsKey( s7 ) ) {
                            Element element1 = new Element( s7, map1.get( s6 ), inherits[i], as[l] );
                            table.put( s7, element1 );
                        }
                    }
                }

            }

        }

        for ( int k = amap.length - 1; k >= 0; k-- ) {
            Map<String, String> map = amap[k];
            for ( Iterator<String> iterator = map.keySet( ).iterator( ); iterator.hasNext( ); ) {
                String s5 = iterator.next( );
                if ( !s5.startsWith( "jmi.env." ) && !table.containsKey( s5 ) ) {
                    Element element = new Element( s5, map.get( s5 ), null, as[k] );
                    table.put( s5, element );
                }
            }

        }

    }

    public TestEnvironment copy( ) {

        return new TestEnvironment( this );
    }

    public String getName( ) {

        return name;
    }

    public String[] getInherits( ) {

        return inherits;
    }

    public void put( String s, String s1 ) {

        String[] as = { s1 };
        extras.put( s, as );
    }

    public void put( String s, String as[] ) {

        extras.put( s, as );
    }

    public void putUrlAndFile( String s, File file, boolean flag ) {

        String s1 = file.getPath( );
        if ( s1.endsWith( File.separator ) ) {
            s1 = s1.substring( 0, s1.length( ) - File.separator.length( ) );
        }
        String s2 = s1.replace( File.separatorChar, '/' );
        String s3 = s2.startsWith( "/" ) ? "file://" : "file:///";
        String s4 = s3 + s2 + ( flag ? "/" : "" );
        put( s, s1 );
        put( s + "URL", s4 );
    }

    public String[] lookup( String s ) throws Fault {

        return lookup( s, null );
    }

    private String[] lookup( String s, Vector<String> vector ) throws Fault {

        String as[] = extras.get( s );
        if ( as != null ) {
            return as;
        }
        Element element = table.get( s );
        if ( element != null ) {
            cache.put( s, element );
            if ( vector == null ) {
                vector = new Vector<String>( );
            } else if ( vector.contains( s ) ) {
                throw new Fault( i18n, "env.recursive", new Object[] { s, element.getDefinedInFile( ) } );
            }
            vector.addElement( s );
            try {
                String as1[] = resolve( element.getValue( ), vector );
                return as1;
            } catch ( Fault fault ) {
                throw new Fault( i18n, "env.badName", new Object[] { s, element.getDefinedInFile( ), fault.getMessage( ) } );
            } finally {
                vector.removeElement( s );
            }
        } else {
            return EMPTY_STRING_ARRAY;
        }
    }

    public String[] resolve( String s ) throws Fault {

        return resolve( s, null );
    }

    private String[] resolve( String s, Vector<String> vector ) throws Fault {

        Vector<String> vector1 = new Vector<String>( );
        StringBuffer stringbuffer = new StringBuffer( 64 );
        int i = 0;
        label0: for ( int j = 0; j < s.length( ); j++ ) {
            char c = s.charAt( j );
            label1: switch ( c ) {
                case 35: // '#'
                    if ( i != 0 && i != 32 ) {
                        stringbuffer.append( c );
                        break;
                    }
                    break label0;

                case 34: // '"'
                case 39: // '\''
                    if ( i == 0 || i == 32 ) {
                        i = c;
                        break;
                    }
                    if ( i == c ) {
                        i = 32;
                    } else {
                        stringbuffer.append( c );
                    }
                    break;

                case 36: // '$'
                    if ( i != 39 ) {
                        StringBuffer stringbuffer1 = new StringBuffer( );
                        String as1[] = null;
                        try {
                            c = s.charAt( ++j );
                            String s1;
                            switch ( c ) {
                                case 47: // '/'
                                    stringbuffer.append( File.separatorChar );
                                    break label1;

                                case 58: // ':'
                                    stringbuffer.append( File.pathSeparatorChar );
                                    break label1;

                                case 36: // '$'
                                    stringbuffer.append( '$' );
                                    break label1;

                                case 123: // '{'
                                    for ( c = s.charAt( ++j ); c != ':' && c != '}'; c = s.charAt( ++j ) ) {
                                        stringbuffer1.append( c );
                                    }

                                    s1 = convertToName( resolve( stringbuffer1.toString( ) ) );
                                    if ( c == ':' ) {
                                        stringbuffer1 = new StringBuffer( );
                                        for ( c = s.charAt( ++j ); c != '}'; c = s.charAt( ++j ) ) {
                                            stringbuffer1.append( c );
                                        }

                                        as1 = StringArray.split( stringbuffer1.toString( ) );
                                    }
                                    break;

                                default:
                                    if ( isNameChar( c ) ) {
                                        for ( ; j < s.length( ) && isNameChar( s.charAt( j ) ); stringbuffer1.append( s.charAt( j++ ) ) ) {
                                        }
                                        j--;
                                    } else {
                                        throw new Fault( i18n, "env.badExprChar", new Character( c ) );
                                    }
                                    s1 = stringbuffer1.toString( );
                                    break;
                            }
                            String as2[] = lookup( s1, vector );
                            if ( as1 != null ) {
                                for ( int k = 0; k < as1.length; k++ ) {
                                    String s2 = as1[k];
                                    if ( s2.startsWith( "FS=" ) && s2.length( ) == 4 ) {
                                        substituteChar( as2, File.separatorChar, s2.charAt( 3 ) );
                                    } else if ( s2.startsWith( "PS=" ) && s2.length( ) == 4 ) {
                                        substituteChar( as2, File.pathSeparatorChar, s2.charAt( 3 ) );
                                    } else if ( s2.startsWith( "MAP=" ) ) {
                                        substituteMap( as2, lookup( "map." + s2.substring( 4 ), vector ) );
                                    } else if ( s2.equals( "MAP" ) ) {
                                        substituteMap( as2, lookup( "map", vector ) );
                                    } else {
                                        throw new Fault( i18n, "env.badOption", s2 );
                                    }
                                }

                            }
                            if ( as2 == null || as2.length <= 0 ) {
                                break;
                            }
                            if ( i == 0 ) {
                                i = 32;
                            }
                            for ( int l = 0; l < as2.length; l++ ) {
                                if ( l == 0 ) {
                                    stringbuffer.append( as2[l] );
                                } else if ( i == 34 ) {
                                    stringbuffer.append( ' ' );
                                    stringbuffer.append( as2[l] );
                                } else {
                                    vector1.addElement( stringbuffer.toString( ) );
                                    stringbuffer.setLength( 0 );
                                    stringbuffer.append( as2[l] );
                                }
                            }

                        } catch ( IndexOutOfBoundsException indexoutofboundsexception ) {
                            throw new Fault( i18n, "env.badExpr" );
                        }
                    } else {
                        stringbuffer.append( c );
                    }
                    break;

                case 9: // '\t'
                case 32: // ' '
                    if ( i == 0 ) {
                        break;
                    }
                    if ( i == 32 ) {
                        vector1.addElement( stringbuffer.toString( ) );
                        stringbuffer.setLength( 0 );
                        i = 0;
                    } else {
                        stringbuffer.append( c );
                    }
                    break;

                default:
                    if ( i == 0 ) {
                        i = 32;
                    }
                    stringbuffer.append( c );
                    break;
            }
        }

        if ( i != 0 ) {
            vector1.addElement( stringbuffer.toString( ) );
        }
        String as[] = new String[vector1.size( )];
        vector1.copyInto( as );
        return as;
    }

    public boolean hasUndefinedValues( ) {

        for ( Iterator<Element> iterator = elements( ).iterator( ); iterator.hasNext( ); ) {
            Element element = iterator.next( );
            if ( element.value.indexOf( "VALUE_NOT_DEFINED" ) >= 0 ) {
                return true;
            }
        }

        return false;
    }

    private void substituteChar( String as[], char c, char c1 ) {

        for ( int i = 0; i < as.length; i++ ) {
            as[i] = as[i].replace( c, c1 );
        }

    }

    private void substituteMap( String as[], String as1[] ) {

        if ( as1 == null ) {
            return;
        }
        for ( int i = 0; i < as.length; i++ ) {
            String s = as[i];
            for ( int j = 0; j + 1 < as1.length; j += 2 ) {
                String s1 = as1[j];
                String s2 = as1[j + 1];
                for ( int k = s.indexOf( s1 ); k != -1; k = s.indexOf( s1, k + s2.length( ) ) ) {
                    s = s.substring( 0, k ) + s2 + s.substring( k + s1.length( ) );
                }

            }

            as[i] = s;
        }

    }

    private String convertToName( String as[] ) {

        String s = "";
        for ( int i = 0; i < as.length; i++ ) {
            if ( i > 0 ) {
                s = s + '_';
            }
            for ( int j = 0; j < as[i].length( ); j++ ) {
                char c = as[i].charAt( j );
                s = s + ( isNameChar( c ) ? c : 95 );
            }

        }

        return s;
    }

    private static boolean isNameChar( char c ) {

        return Character.isUpperCase( c ) || Character.isLowerCase( c ) || Character.isDigit( c ) || c == '_' || c == '.';
    }

    public Set<String> keys( ) {

        return table.keySet( );
    }

    public Collection<Element> elementsUsed( ) {

        return cache.values( );
    }

    public void resetElementsUsed( ) {

        cache.clear( );
    }

    public Collection<Element> elements( ) {

        return table.values( );
    }

    private TestEnvironment( TestEnvironment testenvironment ) {

        table = new HashMap<String, Element>( );
        extras = new HashMap<String, String[]>( );
        cache = new HashMap<String, Element>( );
        name = testenvironment.name;
        inherits = testenvironment.inherits;
        table = testenvironment.table;
        extras = new HashMap<String, String[]>( testenvironment.extras.size( ) );
        for ( Entry<String, String[]> entry : testenvironment.extras.entrySet( ) ) {
            extras.put( entry.getKey( ), entry.getValue( ) );
        }
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private String name;

    private String inherits[];

    private HashMap<String, Element> table;

    private HashMap<String, String[]> extras;

    private HashMap<String, Element> cache;

    private static final String EMPTY_STRING_ARRAY[] = new String[0];

    private static I18NResourceBundle i18n;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment.class );
    }
}
