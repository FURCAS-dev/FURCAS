// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestSuite.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.BackupPolicy;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.StringArray;

// Referenced classes of package com.sun.javatest:
// TestFinder, Script, TestEnvironment, Harness,
// TestFilter, TestDescription, WorkDirectory, InterviewParameters

@SuppressWarnings( "nls" )
public class TestSuite {

    public static class NotTestSuiteFault extends Fault {

        private static final long serialVersionUID = 1L;

        public NotTestSuiteFault( I18NResourceBundle i18nresourcebundle, String s, File file ) {

            super( i18nresourcebundle, s, file.getPath( ) );
        }
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

    public static boolean isTestSuite( File file ) {

        File file1;
        if ( file.isDirectory( ) ) {
            file1 = file;
        } else if ( file.getName( ).equalsIgnoreCase( "testsuite.html" ) ) {
            file1 = file.getParentFile( );
        } else {
            return false;
        }
        File file2 = new File( file1, "testsuite.jtt" );
        File file3 = new File( file1, "testsuite.html" );
        return file2.exists( ) && file2.isFile( ) && file2.canRead( ) || file3.exists( ) && file3.isFile( ) && file3.canRead( );
    }

    public static TestSuite open( File file ) throws FileNotFoundException, Fault, NotTestSuiteFault {

        if ( !file.exists( ) ) {
            throw new FileNotFoundException( file.getPath( ) );
        }
        File file1;
        try {
            file1 = file.getCanonicalFile( );
        } catch ( IOException ioexception ) {
            throw new Fault( i18n, "ts.cantCanonicalize", new Object[] { file.getPath( ), ioexception.toString( ) } );
        }
        File file2;
        if ( file1.isDirectory( ) ) {
            file2 = file1;
        } else if ( file1.getName( ).equalsIgnoreCase( "testsuite.html" ) ) {
            file2 = file1.getParentFile( );
        } else {
            throw new NotTestSuiteFault( i18n, "ts.notTestSuiteFile", file1 );
        }
        File file3 = new File( file2, "testsuite.jtt" );
        if ( file3.exists( ) && file3.isFile( ) && file3.canRead( ) ) {
            try {
                Properties properties = new Properties( );
                BufferedInputStream bufferedinputstream = new BufferedInputStream( new FileInputStream( file3 ) );
                properties.load( bufferedinputstream );
                bufferedinputstream.close( );
                Map<String, String> map = new HashMap<String, String>( properties.size( ) );
                for ( Entry<Object, Object> entry : properties.entrySet( ) ) {
                    map.put( (String) entry.getKey( ), (String) entry.getValue( ) );
                }
                return open( file1, map );
            } catch ( IOException ioexception1 ) {
                throw new Fault( i18n, "ts.cantReadTestSuiteFile", ioexception1.toString( ) );
            }
        }
        File file4 = new File( file2, "testsuite.html" );
        if ( file4.exists( ) && file4.isFile( ) && file4.canRead( ) ) {
            return open( file1, new HashMap<String, String>( ) );
        } else {
            throw new NotTestSuiteFault( i18n, "ts.notTestSuiteFile", file1 );
        }
    }

    private static TestSuite open( File file, Map<String, String> map ) throws Fault {

        TestSuite testsuite3;
        synchronized ( dirMap ) {
            WeakReference<TestSuite> weakreference = dirMap.get( file );
            if ( weakreference != null ) {
                TestSuite testsuite = weakreference.get( );
                if ( testsuite != null ) {
                    TestSuite testsuite2 = testsuite;
                    return testsuite2;
                }
            }
            TestSuite testsuite1 = open0( file, map );
            dirMap.put( file, new WeakReference<TestSuite>( testsuite1 ) );
            testsuite3 = testsuite1;
        }
        return testsuite3;
    }

    private static TestSuite open0( File file, Map<String, String> map ) throws Fault {

        String as[] = StringArray.split( map.get( "classpath" ) );
        URLClassLoader urlclassloader;
        if ( as.length == 0 ) {
            urlclassloader = null;
        } else {
            try {
                File file1 = file.isDirectory( ) ? file : file.getParentFile( );
                URL url = file1.toURI( ).toURL( );
                URL aurl[] = new URL[as.length];
                for ( int i = 0; i < as.length; i++ ) {
                    aurl[i] = new URL( url, as[i] );
                }

                urlclassloader = new URLClassLoader( aurl );
            } catch ( MalformedURLException malformedurlexception ) {
                throw new Fault( i18n, "ts.badClassPath", new Object[] { file, malformedurlexception.getMessage( ) } );
            }
        }
        String as1[] = StringArray.split( map.get( "testsuite" ) );
        TestSuite testsuite;
        if ( as1.length == 0 ) {
            testsuite = new TestSuite( file, map, urlclassloader );
        } else {
            String s = as1[0];
            try {
                Class<?> class1 = loadClass( s, urlclassloader );
                Class<?> aclass[] = { java.io.File.class, java.util.Map.class, java.lang.ClassLoader.class };
                Object aobj[] = { file, map, urlclassloader };
                testsuite = (TestSuite) newInstance( class1, aclass, aobj );
            } catch ( ClassCastException classcastexception ) {
                throw new Fault( i18n, "ts.notASubtype", new Object[] { s, "testsuite", ( com.sap.tc.moin.repository.test.jmitck.javatest.TestSuite.class ).getName( ) } );
            }
            String as2[] = new String[as1.length - 1];
            System.arraycopy( as1, 1, as2, 0, as2.length );
            testsuite.init( as2 );
        }
        testsuite.setTestFinder( testsuite.createTestFinder( ) );
        return testsuite;
    }

    protected TestSuite( File file, Map<String, String> map, ClassLoader classloader ) throws Fault {

        root = file;
        tsInfo = map;
        loader = classloader;
        if ( map != null ) {
            String s = map.get( "helpSet" );
            if ( s != null ) {
                ClassLoader classloader1 = classloader != null ? loader : getClass( ).getClassLoader( );
                helpSetURL = classloader1.getResource( s );
            }
        }
    }

    protected TestSuite( File file ) {

        root = file;
    }

    protected void init( String as[] ) throws Fault {

        if ( as.length > 0 ) {
            throw new Fault( i18n, "ts.badArgs", as[0] );
        } else {
            return;
        }
    }

    public String getPath( ) {

        return root.getPath( );
    }

    public File getRoot( ) {

        return root;
    }

    public File getRootDir( ) {

        return root.isDirectory( ) ? root : new File( root.getParent( ) );
    }

    public File getTestsDir( ) {

        String s = tsInfo != null ? tsInfo.get( "tests" ) : null;
        if ( s == null || s.length( ) == 0 ) {
            File file = getRootDir( );
            File file2 = new File( file, "tests" );
            if ( file2.isDirectory( ) ) {
                File file3 = new File( file2, "testsuite.html" );
                if ( file3.canRead( ) ) {
                    return file2;
                }
            }
            return file;
        }
        File file1 = new File( s );
        if ( file1.isAbsolute( ) ) {
            return file1;
        } else {
            return new File( getRootDir( ), s.replace( '/', File.separatorChar ) );
        }
    }

    public TestFinder getTestFinder( ) {

        return finder;
    }

    protected void setTestFinder( TestFinder testfinder ) {

        if ( testfinder == null ) {
            throw new NullPointerException( );
        }
        if ( finder != null && finder != testfinder ) {
            throw new IllegalStateException( );
        } else {
            finder = testfinder;
            return;
        }
    }

    protected TestFinder createTestFinder( ) throws Fault {

        String as[] = StringArray.split( tsInfo.get( "finder" ) );
        if ( as == null || as.length == 0 ) {
            as = ( new String[] { ( com.sap.tc.moin.repository.test.jmitck.test.javatest.finder.HTMLTestFinder.class ).getName( ) } );
        }
        String s = as[0];
        String as1[] = new String[as.length - 1];
        System.arraycopy( as, 1, as1, 0, as1.length );
        File file = getTestsDir( );
        try {
            Class<?> class1 = loadClass( s );
            TestFinder testfinder = (TestFinder) newInstance( class1 );
            testfinder.init( as1, file, null );
            return testfinder;
        } catch ( ClassCastException classcastexception ) {
            throw new Fault( i18n, "ts.notASubtype", new Object[] { s, "finder", ( com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder.class ).getName( ) } );
        } catch ( TestFinder.Fault fault ) {
            throw new Fault( i18n, "ts.errorInitFinder", new Object[] { s, fault.getMessage( ) } );
        }
    }

    public Script createScript( TestDescription testdescription, String as[], TestEnvironment testenvironment, WorkDirectory workdirectory, BackupPolicy backuppolicy ) throws Fault {

        if ( scriptClass == null ) {
            String as1[] = envLookup( testenvironment, "script" );
            if ( as1.length == 0 ) {
                as1 = StringArray.split( tsInfo.get( "script" ) );
            }
            if ( as1.length > 0 ) {
                scriptClass = loadClass( as1[0] );
                if ( !( com.sap.tc.moin.repository.test.jmitck.javatest.Script.class ).isAssignableFrom( scriptClass ) ) {
                    throw new Fault( i18n, "ts.notASubtype", new Object[] { as1[0], "script", ( com.sap.tc.moin.repository.test.jmitck.javatest.Script.class ).getName( ) } );
                }
                scriptArgs = new String[as1.length - 1];
                System.arraycopy( as1, 1, scriptArgs, 0, scriptArgs.length );
            } else {
                boolean flag = false;
                String s;
                for ( Iterator<String> iterator = testenvironment.keys( ).iterator( ); iterator.hasNext( ) && !flag; flag = s.startsWith( "script." ) ) {
                    s = iterator.next( );
                }

                if ( flag ) {
                    scriptClass = com.sap.tc.moin.repository.test.jmitck.javatest.lib.KeywordScript.class;
                    scriptArgs = new String[0];
                } else {
                    throw new Fault( i18n, "ts.noScript" );
                }
            }
        }
        Script script = (Script) newInstance( scriptClass );
        script.initArgs( scriptArgs );
        script.initTestDescription( testdescription );
        script.initExcludedTestCases( as );
        script.initTestEnvironment( testenvironment );
        script.initWorkDir( workdirectory );
        script.initBackupPolicy( backuppolicy );
        script.initClassLoader( loader );
        return script;
    }

    //    public InterviewParameters createInterview()
    //        throws com.sun.interview.Interview.Fault
    //    {
    //        return new LegacyParameters(this);
    //    }

    public String getID( ) {

        return tsInfo != null ? (String) tsInfo.get( "id" ) : null;
    }

    public String getName( ) {

        return tsInfo != null ? (String) tsInfo.get( "name" ) : null;
    }

    public int getEstimatedTestCount( ) {

        try {
            if ( tsInfo != null ) {
                String s = tsInfo.get( "testCount" );
                if ( s != null ) {
                    return Integer.parseInt( s );
                }
            }
        } catch ( NumberFormatException numberformatexception ) {
        }
        return -1;
    }

    public File getDefaultExcludeList( ) {

        String s = tsInfo != null ? (String) tsInfo.get( "default.jtx" ) : null;
        if ( s == null ) {
            return null;
        }
        File file = new File( s );
        if ( !file.isAbsolute( ) ) {
            file = new File( getRootDir( ), file.getPath( ) );
        }
        return file;
    }

    public URL getLatestExcludeList( ) {

        try {
            String s = tsInfo != null ? (String) tsInfo.get( "latest.jtx" ) : null;
            return s != null ? new URL( s ) : null;
        } catch ( MalformedURLException malformedurlexception ) {
            return null;
        }
    }

    public URL getHelpSetURL( ) {

        return helpSetURL;
    }

    public URL getLogo( ) {

        return null;
    }

    private static String[] envLookup( TestEnvironment testenvironment, String s ) throws Fault {

        try {
            return testenvironment.lookup( s );
        } catch ( TestEnvironment.Fault fault ) {
            throw new Fault( i18n, "ts.cantFindNameInEnv", new Object[] { s, fault.getMessage( ) } );
        }
    }

    protected static Object newInstance( Class<?> class1 ) throws Fault {

        try {
            return class1.newInstance( );
        } catch ( InstantiationException instantiationexception ) {
            throw new Fault( i18n, "ts.cantInstantiate", new Object[] { class1.getName( ), instantiationexception } );
        } catch ( IllegalAccessException illegalaccessexception ) {
            throw new Fault( i18n, "ts.illegalAccess", new Object[] { class1.getName( ), illegalaccessexception } );
        }
    }

    protected static Object newInstance( Class<?> class1, Class<?> aclass[], Object aobj[] ) throws Fault {

        try {
            return class1.getConstructor( aclass ).newInstance( aobj );
        } catch ( IllegalAccessException illegalaccessexception ) {
            throw new Fault( i18n, "ts.illegalAccess", new Object[] { class1.getName( ), illegalaccessexception } );
        } catch ( InstantiationException instantiationexception ) {
            throw new Fault( i18n, "ts.cantInstantiate", new Object[] { class1.getName( ), instantiationexception } );
        } catch ( InvocationTargetException invocationtargetexception ) {
            Throwable throwable = invocationtargetexception.getTargetException( );
            if ( throwable instanceof Fault ) {
                throw (Fault) throwable;
            } else {
                throw new Fault( i18n, "ts.cantInit", new Object[] { class1.getName( ), throwable } );
            }
        } catch ( NoSuchMethodException nosuchmethodexception ) {
            throw new Fault( i18n, "ts.cantFindConstructor", new Object[] { class1.getName( ), nosuchmethodexception } );
        }
    }

    public Class<?> loadClass( String s ) throws Fault {

        return loadClass( s, loader );
    }

    protected static Class<?> loadClass( String s, ClassLoader classloader ) throws Fault {

        try {
            if ( classloader == null ) {
                return Class.forName( s );
            } else {
                return classloader.loadClass( s );
            }
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new Fault( i18n, "ts.classNotFound", new Object[] { s, classnotfoundexception } );
        } catch ( IllegalArgumentException illegalargumentexception ) {
            throw new Fault( i18n, "ts.badClassName", new Object[] { s } );
        }
    }

    protected ClassLoader getClassLoader( ) {

        return loader;
    }

    protected Map<String, String> getTestSuiteInfo( ) {

        return tsInfo;
    }

    public String getTestSuiteInfo( String s ) {

        return tsInfo.get( s );
    }

    private File root;

    private Map<String, String> tsInfo;

    private ClassLoader loader;

    private TestFinder finder;

    private Class<?> scriptClass;

    private String scriptArgs[];

    private URL helpSetURL;

    private static HashMap<File, WeakReference<TestSuite>> dirMap = new HashMap<File, WeakReference<TestSuite>>( 2 );

    private static I18NResourceBundle i18n;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TestSuite.class );
    }
}
