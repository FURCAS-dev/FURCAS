// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestEnvContext.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.Properties;

// Referenced classes of package com.sun.javatest:
// TestEnvironment
@SuppressWarnings( "nls" )
public class TestEnvContext {

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

    public static synchronized void addDefaultPropTable( String s, Map<String, String> map ) {

        defaultPropTableNames.add( s );
        defaultPropTables.add( map );
    }

    public static synchronized void clearDefaultPropTables( ) {

        defaultPropTableNames.clear( );
        defaultPropTables.clear( );
    }

    @SuppressWarnings( "unchecked" )
    public TestEnvContext( File afile[] ) throws Fault {

        Vector<String> vector = new Vector<String>( );
        Vector<Map<String, String>> vector1 = new Vector<Map<String, String>>( );
        addDefaults( vector1, vector );
        try {
            if ( afile != null ) {
                for ( int i = 0; i < afile.length; i++ ) {
                    File file = afile[i];
                    add( vector1, vector, load( file ), file.getPath( ) );
                }

            }
        } finally {
            propTables = new Map[vector1.size( )];
            vector1.copyInto( propTables );
            propTableNames = new String[vector.size( )];
            vector.copyInto( propTableNames );
            updateEnvTable( );
        }
    }

    @SuppressWarnings( "unchecked" )
    public TestEnvContext( Map<String, String> amap[], String as[] ) {

        Vector<String> vector = new Vector<String>( );
        Vector<Map<String, String>> vector1 = new Vector<Map<String, String>>( );
        addDefaults( vector1, vector );
        for ( int i = 0; i < amap.length; i++ ) {
            add( vector1, vector, amap[i], as[i] );
        }

        propTables = new Map[vector1.size( )];
        vector1.copyInto( propTables );
        propTableNames = new String[vector.size( )];
        vector.copyInto( propTableNames );
        updateEnvTable( );
    }

    @SuppressWarnings( "unchecked" )
    public TestEnvContext( Map<String, String> map, String s ) {

        Vector<String> vector = new Vector<String>( );
        Vector<Map<String, String>> vector1 = new Vector<Map<String, String>>( );
        addDefaults( vector1, vector );
        add( vector1, vector, map, s );
        propTables = new Map[vector1.size( )];
        vector1.copyInto( propTables );
        propTableNames = new String[vector.size( )];
        vector.copyInto( propTableNames );
        updateEnvTable( );
    }

    public TestEnvironment getEnv( String s ) throws TestEnvironment.Fault {

        if ( isValidEnv( s ) ) {
            return new TestEnvironment( s, propTables, propTableNames );
        } else {
            return null;
        }
    }

    public boolean isValidEnv( String s ) {

        if ( s.length( ) == 0 ) {
            return true;
        }
        for ( int i = 0; i < envNames.length; i++ ) {
            if ( envNames[i].equals( s ) ) {
                return true;
            }
        }

        return false;
    }

    public String[] getEnvNames( ) {

        return envNames;
    }

    public String[] getEnvMenuNames( ) {

        return envMenuNames;
    }

    private Properties load( File file ) throws Fault {

        if ( file == null ) {
            return null;
        }
        try {
            Properties properties = new Properties( );
            BufferedReader bufferedreader = new BufferedReader( new FileReader( file ) );
            properties.load( bufferedreader );
            bufferedreader.close( );
            return properties;
        } catch ( FileNotFoundException filenotfoundexception ) {
            throw new Fault( i18n, "tec.cantFindFile", file );
        } catch ( IOException ioexception ) {
            throw new Fault( i18n, "tec.ioError", new Object[] { file, ioexception } );
        }
    }

    private void addDefaults( Vector<Map<String, String>> vector, Vector<String> vector1 ) {

        for ( int i = 0; i < defaultPropTables.size( ); i++ ) {
            vector.addElement( defaultPropTables.elementAt( i ) );
            vector1.addElement( defaultPropTableNames.elementAt( i ) );
        }

    }

    private void add( Vector<Map<String, String>> vector, Vector<String> vector1, Map<String, String> map, String s ) {

        if ( map != null ) {
            vector.addElement( map );
            vector1.addElement( s );
        }
    }

    @SuppressWarnings( "unchecked" )
    private void updateEnvTable( ) {

        Vector<String> vector = new Vector<String>( );
        Vector<String> vector1 = new Vector<String>( );
        if ( debug ) {
            System.err.println( getClass( ).getName( ) + ": trace" );
        }
        for ( int i = 0; i < propTables.length; i++ ) {
            if ( debug ) {
                System.err.println( "Checking " + propTableNames[i] + " for environments..." );
            }
            Map<String, String> map = propTables[i];
            Iterator<String> iterator = map.keySet( ).iterator( );
            while ( iterator.hasNext( ) ) {
                String s = iterator.next( );
                String s1 = null;
                if ( debug ) {
                    System.err.println( "Checking property " + s );
                }
                if ( !s.startsWith( "jmi.env." ) ) {
                    continue;
                }
                if ( s.endsWith( ".inherits" ) ) {
                    s1 = s.substring( "env.".length( ), s.length( ) - ".inherits".length( ) );
                } else if ( s.endsWith( ".menu" ) ) {
                    s1 = s.substring( "env.".length( ), s.length( ) - ".menu".length( ) );
                    String s2 = map.get( s );
                    if ( "false".equals( s2 ) ) {
                        sortedInsert( vector1, s1 );
                    }
                } else if ( s.endsWith( ".description" ) ) {
                    s1 = s.substring( "env.".length( ), s.length( ) - ".description".length( ) );
                } else if ( s.endsWith( ".finder" ) ) {
                    s1 = s.substring( "env.".length( ), s.length( ) - ".finder".length( ) );
                } else if ( s.endsWith( ".script" ) ) {
                    s1 = s.substring( "env.".length( ), s.length( ) - ".script".length( ) );
                } else if ( s.endsWith( ".testsuite" ) ) {
                    s1 = s.substring( "env.".length( ), s.length( ) - ".testsuite".length( ) );
                } else {
                    int k = s.lastIndexOf( '.' );
                    int l = ( k - ".script.".length( ) ) + 1;
                    if ( l <= 0 || !s.regionMatches( l, ".script.", 0, ".script.".length( ) ) ) {
                        continue;
                    }
                    s1 = s.substring( "env.".length( ), l );
                }
                if ( debug ) {
                    System.err.println( "found environment name: " + s1 );
                }
                sortedInsert( vector, s1 );
            }
        }

        envNames = new String[vector.size( )];
        vector.copyInto( envNames );
        Vector vector2 = (Vector) vector.clone( );
        for ( int j = 0; j < vector1.size( ); j++ ) {
            vector2.removeElement( vector1.elementAt( j ) );
        }

        envMenuNames = new String[vector2.size( )];
        vector2.copyInto( envMenuNames );
    }

    private void sortedInsert( Vector<String> vector, String s ) {

        for ( int i = 0; i < vector.size( ); i++ ) {
            int j = s.compareTo( vector.elementAt( i ) );
            if ( j > 0 ) {
                vector.insertElementAt( s, i );
                return;
            }
            if ( j == 0 ) {
                return;
            }
        }

        vector.addElement( s );
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private static Vector<String> defaultPropTableNames = new Vector<String>( );

    private static Vector<Map<String, String>> defaultPropTables = new Vector<Map<String, String>>( );

    private Map<String, String> propTables[];

    private String propTableNames[];

    private String envNames[];

    private String envMenuNames[];

    private static I18NResourceBundle i18n;

    private static boolean debug;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvContext.class );
        debug = Boolean.getBoolean( "debug." + ( com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvContext.class ).getName( ) );
    }
}
