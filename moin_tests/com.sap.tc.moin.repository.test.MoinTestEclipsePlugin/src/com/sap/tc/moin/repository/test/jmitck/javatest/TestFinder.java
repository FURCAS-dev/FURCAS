// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestFinder.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.USER_DIR;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.StringArray;

// Referenced classes of package com.sun.javatest:
// TestDescription, TestEnvironment, TestFilter

@SuppressWarnings( "nls" )
public abstract class TestFinder {

    public static interface ErrorHandler {

        public abstract void error( String s );
    }

    public static class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        public Fault( I18NResourceBundle i18nresourcebundle, String s ) {

            super( i18nresourcebundle.getString( s ) );
        }

        public Fault( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

            super( i18nresourcebundle.getString( s, obj ) );
        }

        public Fault( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

            super( i18nresourcebundle.getString( s, aobj ) );
        }
    }

    public TestFinder( ) {

        keywordCache = new HashMap<String, String>( );
        testsInFile = new HashMap<String, Integer>( );
        errorMessages = new Vector<String>( );
    }

    public void init( String as[], File file, TestEnvironment testenvironment ) throws Fault {

        decodeAllArgs( as );
        setRoot( file );
        env = testenvironment;
    }

    protected void decodeAllArgs( String as[] ) throws Fault {

        int j;
        for ( int i = 0; i < as.length; i += j ) {
            j = decodeArg( as, i );
            if ( j == 0 ) {
                throw new Fault( i18n, "finder.badArg", as[i] );
            }
        }

    }

    protected int decodeArg( String as[], int i ) throws Fault {

        return 0;
    }

    protected void setRoot( File file ) throws IllegalStateException, Fault {

        if ( root != null ) {
            throw new IllegalStateException( "root already set" );
        } else {
            root = file.isAbsolute( ) ? file : new File( userDir, file.getPath( ) );
            rootDir = root.isDirectory( ) ? root : new File( root.getParent( ) );
            return;
        }
    }

    public File getRoot( ) {

        return root;
    }

    public File getRootDir( ) {

        return rootDir;
    }

    public void setErrorHandler( ErrorHandler errorhandler ) {

        errHandler = errorhandler;
    }

    protected void error( I18NResourceBundle i18nresourcebundle, String s ) {

        localizedError( i18nresourcebundle.getString( s ) );
    }

    protected void error( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

        localizedError( i18nresourcebundle.getString( s, obj ) );
    }

    protected void error( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

        localizedError( i18nresourcebundle.getString( s, aobj ) );
    }

    protected void localizedError( String s ) {

        errorMessages.add( s );
        if ( errHandler != null ) {
            errHandler.error( s );
        }
    }

    public synchronized int getErrorCount( ) {

        return errorMessages.size( );
    }

    public synchronized String[] getErrors( ) {

        String as[] = new String[errorMessages.size( )];
        errorMessages.copyInto( as );
        return as;
    }

    public synchronized void clearErrors( ) {

        errorMessages.setSize( 0 );
    }

    public synchronized void read( File file ) {

        if ( tests != null ) {
            tests.setSize( 0 );
        }
        if ( files != null ) {
            files.setSize( 0 );
        }
        testsInFile.clear( );
        scan( file.isAbsolute( ) ? file : new File( rootDir, file.getPath( ) ) );
    }

    public synchronized void read( InputStream is ) {

        if ( tests != null ) {
            tests.setSize( 0 );
        }
        if ( files != null ) {
            files.setSize( 0 );
        }
        testsInFile.clear( );
        scanResource( is );
    }

    protected abstract void scan( File file );

    protected abstract void scanResource( InputStream is );

    protected void processEntry( Map<String, String> map, String s, String s1 ) {

        s = s.intern( );
        if ( s.equalsIgnoreCase( "keywords" ) ) {
            String s2 = keywordCache.get( s1 );
            if ( s2 == null ) {
                String s3 = s1.toLowerCase( Locale.ENGLISH );
                String as[] = StringArray.split( s3 );
                Arrays.sort( as );
                s2 = StringArray.join( as ).intern( );
                keywordCache.put( s1, s2 );
            }
            s1 = s2;
        } else {
            s1 = s1.intern( );
        }
        map.put( s, s1 );
    }

    protected void foundTestDescription( Map<String, String> map, File file, int i ) {

        if ( debug ) {
            System.err.println( "Found TestDescription" );
            System.err.println( "--------values----------------------------" );
            Object obj;
            for ( Iterator<String> iterator = map.keySet( ).iterator( ); iterator.hasNext( ); System.err.println( ">> " + obj + ": " + map.get( obj ) ) ) {
                obj = iterator.next( );
            }

            System.err.println( "------------------------------------------" );
        }
        String s = map.get( "id" );
        if ( s == null ) {
            s = "";
        }
        Integer integer = testsInFile.get( s );
        if ( integer != null ) {
            String s1;
            for ( int j = 1; testsInFile.get( s1 = s + "__" + j ) != null; j++ ) {
            }
            error( i18n, "finder.nonUniqueId", new Object[] { file, s.equals( "" ) ? "(unset)" : s, new Integer( i ), integer, s1 } );
            s = s1;
            map.put( "id", s );
        }
        testsInFile.put( s, new Integer( i ) );
        TestDescription testdescription = new TestDescription( root, file, map );
        if ( errHandler != null ) {
            String s2 = testdescription.getRootRelativeURL( );
            if ( s2.indexOf( ' ' ) != -1 ) {
                error( i18n, "finder.spaceInId", testdescription.getRootRelativeURL( ) );
            }
        }
        foundTestDescription( testdescription );
    }

    protected void foundTestDescription( Map<String, String> map, int i ) {

        if ( debug ) {
            System.err.println( "Found TestDescription" );
            System.err.println( "--------values----------------------------" );
            String obj;
            for ( Iterator<String> iterator = map.keySet( ).iterator( ); iterator.hasNext( ); System.err.println( ">> " + obj + ": " + map.get( obj ) ) ) {
                obj = iterator.next( );
            }

            System.err.println( "------------------------------------------" );
        }
        String s = map.get( "id" );
        if ( s == null ) {
            s = "";
        }
        Integer integer = testsInFile.get( s );
        if ( integer != null ) {
            String s1;
            for ( int j = 1; testsInFile.get( s1 = s + "__" + j ) != null; j++ ) {
            }
            error( i18n, "finder.nonUniqueId", new Object[] { s.equals( "" ) ? "(unset)" : s, new Integer( i ), integer, s1 } );
            s = s1;
            map.put( "id", s );
        }
        testsInFile.put( s, new Integer( i ) );
        TestDescription testdescription = new TestDescription( map );
        if ( errHandler != null ) {
            String s2 = testdescription.getRootRelativeURL( );
            if ( s2.indexOf( ' ' ) != -1 ) {
                error( i18n, "finder.spaceInId", testdescription.getRootRelativeURL( ) );
            }
        }
        foundTestDescription( testdescription );
    }

    protected void foundTestDescription( TestDescription testdescription ) {

        if ( tests == null ) {
            tests = new Vector<TestDescription>( );
        }
        tests.addElement( testdescription );
    }

    public TestDescription[] getTests( ) {

        if ( tests == null ) {
            return noTests;
        } else {
            TestDescription atestdescription[] = new TestDescription[tests.size( )];
            tests.copyInto( atestdescription );
            return atestdescription;
        }
    }

    protected void foundFile( File file ) {

        if ( files == null ) {
            files = new Vector<File>( );
        }
        files.addElement( file );
    }

    public File[] getFiles( ) {

        if ( files == null ) {
            return new File[0];
        } else {
            File afile[] = new File[files.size( )];
            files.copyInto( afile );
            return afile;
        }
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private Map<String, String> keywordCache;

    private static final TestDescription noTests[] = new TestDescription[0];

    private File root;

    private File rootDir;

    /**
     * @deprecated Field env is deprecated
     */
    @Deprecated
    protected TestEnvironment env;

    private ErrorHandler errHandler;

    private Vector<File> files;

    private Vector<TestDescription> tests;

    private Map<String, Integer> testsInFile;

    private Vector<String> errorMessages;

    protected static boolean debug;

    private static final File userDir = new File( System.getProperty( USER_DIR ) );

    private static I18NResourceBundle i18n;

    static {
        debug = Boolean.getBoolean( "debug." + ( com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder.class ).getName( ) );
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder.class );
    }
}
