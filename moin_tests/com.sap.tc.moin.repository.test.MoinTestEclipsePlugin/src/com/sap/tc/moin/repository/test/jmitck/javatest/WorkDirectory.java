// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: WorkDirectory.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestResultTable, TestSuite

@SuppressWarnings( "nls" )
public class WorkDirectory {

    public static class TestSuiteFault extends Fault {

        private static final long serialVersionUID = 1L;

        TestSuiteFault( I18NResourceBundle i18nresourcebundle, String s, File file, Object obj ) {

            super( i18nresourcebundle, s, new Object[] { file.getPath( ), obj } );
        }
    }

    public static class MismatchFault extends Fault {

        private static final long serialVersionUID = 1L;

        MismatchFault( I18NResourceBundle i18nresourcebundle, String s, File file ) {

            super( i18nresourcebundle, s, file.getPath( ) );
        }
    }

    public static class WorkDirectoryExistsFault extends Fault {

        private static final long serialVersionUID = 1L;

        WorkDirectoryExistsFault( I18NResourceBundle i18nresourcebundle, String s, File file ) {

            super( i18nresourcebundle, s, file.getPath( ) );
        }
    }

    public static class NotWorkDirectoryFault extends Fault {

        private static final long serialVersionUID = 1L;

        NotWorkDirectoryFault( I18NResourceBundle i18nresourcebundle, String s, File file ) {

            super( i18nresourcebundle, s, file.getPath( ) );
        }
    }

    public static class BadDirectoryFault extends Fault {

        private static final long serialVersionUID = 1L;

        BadDirectoryFault( I18NResourceBundle i18nresourcebundle, String s, File file ) {

            super( i18nresourcebundle, s, file.getPath( ) );
        }

        BadDirectoryFault( I18NResourceBundle i18nresourcebundle, String s, File file, Throwable throwable ) {

            super( i18nresourcebundle, s, new Object[] { file.getPath( ), throwable.toString( ) } );
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

    public static boolean isWorkDirectory( File file ) {

        File file1 = new File( file, "jtData" );
        return file1.exists( ) && file1.isDirectory( );
    }

    public static boolean isEmptyDirectory( File file ) {

        if ( file.exists( ) && file.isDirectory( ) ) {
            String as[] = file.list( );
            return as == null || as.length == 0;
        } else {
            return false;
        }
    }

    public static WorkDirectory create( File file, TestSuite testsuite ) throws BadDirectoryFault, WorkDirectoryExistsFault {

        return createOrConvert( file, testsuite, true );
    }

    public static WorkDirectory convert( File file, TestSuite testsuite ) throws BadDirectoryFault, WorkDirectoryExistsFault, FileNotFoundException {

        if ( !file.exists( ) ) {
            throw new FileNotFoundException( file.getPath( ) );
        } else {
            return createOrConvert( file, testsuite, false );
        }
    }

    private static WorkDirectory createOrConvert( File file, TestSuite testsuite, boolean flag ) throws BadDirectoryFault, WorkDirectoryExistsFault {

        File file1;
        File file2;
        if ( file.exists( ) ) {
            file1 = canonicalize( file );
            file2 = new File( file1, "jtData" );
            if ( !file1.isDirectory( ) ) {
                throw new BadDirectoryFault( i18n, "wd.notDirectory", file1 );
            }
            if ( !file1.canRead( ) ) {
                throw new BadDirectoryFault( i18n, "wd.notReadable", file1 );
            }
            if ( file2.exists( ) && file2.isDirectory( ) ) {
                throw new WorkDirectoryExistsFault( i18n, "wd.alreadyExists", file1 );
            }
            if ( flag ) {
                String as[] = file1.list( );
                if ( as != null && as.length > 0 ) {
                    throw new BadDirectoryFault( i18n, "wd.notEmpty", file1 );
                }
            }
        } else {
            if ( !file.mkdirs( ) ) {
                throw new BadDirectoryFault( i18n, "wd.cantCreate", file );
            }
            file1 = canonicalize( file );
            file2 = new File( file1, "jtData" );
        }
        if ( !file2.mkdirs( ) ) {
            throw new BadDirectoryFault( i18n, "wd.cantCreate", file1 );
        }
        try {
            WorkDirectory workdirectory;
            synchronized ( dirMap ) {
                workdirectory = new WorkDirectory( file1, testsuite, null );
                dirMap.put( file1, new WeakReference<WorkDirectory>( workdirectory ) );
            }
            workdirectory.saveTestSuiteInfo( );
            return workdirectory;
        } catch ( IOException ioexception ) {
            throw new BadDirectoryFault( i18n, "wd.cantWriteTestSuiteInfo", file1, ioexception );
        }
    }

    public static WorkDirectory open( File file ) throws FileNotFoundException, BadDirectoryFault, NotWorkDirectoryFault, MismatchFault, TestSuiteFault {

        if ( !file.exists( ) ) {
            throw new FileNotFoundException( file.getPath( ) );
        }
        File file1 = canonicalize( file );
        if ( !file1.isDirectory( ) ) {
            throw new BadDirectoryFault( i18n, "wd.notDirectory", file1 );
        }
        if ( !file1.canRead( ) ) {
            throw new BadDirectoryFault( i18n, "wd.notReadable", file1 );
        }
        File file2 = new File( file1, "jtData" );
        if ( !file2.exists( ) ) {
            throw new NotWorkDirectoryFault( i18n, "wd.notWorkDir", file1 );
        }
        WorkDirectory workdirectory = null;
        synchronized ( dirMap ) {
            WeakReference<WorkDirectory> weakreference = dirMap.get( file1 );
            if ( weakreference != null ) {
                workdirectory = weakreference.get( );
            }
            if ( workdirectory != null ) {
                WorkDirectory workdirectory1 = workdirectory;
                return workdirectory1;
            }
            Properties properties;
            TestSuite testsuite;
            try {
                properties = loadTestSuiteInfo( file2 );
                String s = properties.getProperty( "root" );
                if ( s == null ) {
                    throw new BadDirectoryFault( i18n, "wd.noTestSuiteRoot", file1 );
                }
                File file3 = new File( s );
                if ( !file3.isAbsolute( ) ) {
                    file3 = new File( file1, s );
                }
                if ( !file3.exists( ) ) {
                    throw new TestSuiteFault( i18n, "wd.cantFindTestSuite", file1, file3.getPath( ) );
                }
                testsuite = TestSuite.open( file3 );
                String s1 = (String) properties.get( "id" );
                String s2 = testsuite.getID( );
                if ( !( s1 != null ? s1 : "" ).equals( s2 != null ? ( (Object) ( s2 ) ) : "" ) ) {
                    throw new MismatchFault( i18n, "wd.mismatchID", file1 );
                }
            } catch ( FileNotFoundException filenotfoundexception ) {
                throw new BadDirectoryFault( i18n, "wd.noTestSuiteFile", file1 );
            } catch ( IOException ioexception ) {
                throw new BadDirectoryFault( i18n, "wd.badTestSuiteFile", file1, ioexception );
            } catch ( TestSuite.Fault fault ) {
                throw new TestSuiteFault( i18n, "wd.cantOpenTestSuite", file1, fault.toString( ) );
            }
            workdirectory = new WorkDirectory( file1, testsuite, properties );
            dirMap.put( file1, new WeakReference<WorkDirectory>( workdirectory ) );
        }
        return workdirectory;
    }

    public static WorkDirectory open( File file, TestSuite testsuite ) throws FileNotFoundException, BadDirectoryFault, NotWorkDirectoryFault, MismatchFault {

        if ( !file.exists( ) ) {
            throw new FileNotFoundException( file.getPath( ) );
        }
        File file1 = canonicalize( file );
        if ( !file1.isDirectory( ) ) {
            throw new BadDirectoryFault( i18n, "wd.notDirectory", file1 );
        }
        if ( !file1.canRead( ) ) {
            throw new BadDirectoryFault( i18n, "wd.notReadable", file1 );
        }
        File file2 = new File( file1, "jtData" );
        if ( !file2.exists( ) ) {
            throw new NotWorkDirectoryFault( i18n, "wd.notWorkDir", file1 );
        }
        WorkDirectory workdirectory = null;
        synchronized ( dirMap ) {
            WeakReference<WorkDirectory> weakreference = dirMap.get( file1 );
            if ( weakreference != null ) {
                workdirectory = weakreference.get( );
            }
            if ( workdirectory == null ) {
                Properties properties;
                try {
                    properties = loadTestSuiteInfo( file2 );
                } catch ( IOException ioexception ) {
                    properties = null;
                }
                String s = properties != null ? (String) properties.get( "id" ) : null;
                String s1 = testsuite.getID( );
                if ( !( s != null ? s : "" ).equals( s1 != null ? ( (Object) ( s1 ) ) : "" ) ) {
                    throw new MismatchFault( i18n, "wd.mismatchID", file1 );
                }
                try {
                    workdirectory = new WorkDirectory( file1, testsuite, properties );
                    workdirectory.saveTestSuiteInfo( );
                    dirMap.put( file1, new WeakReference<WorkDirectory>( workdirectory ) );
                } catch ( IOException ioexception1 ) {
                    throw new BadDirectoryFault( i18n, "wd.cantWriteTestSuiteInfo", file1, ioexception1 );
                }
            }
        }
        return workdirectory;
    }

    private WorkDirectory( File file, TestSuite testsuite, Properties prop ) {
        testCount = -1;
        if ( file == null || testsuite == null ) {
            throw new NullPointerException( );
        }
        root = file;
        testSuite = testsuite;
        jtData = new File( file, "jtData" );
        testResultTable = new TestResultTable( this );
        if ( prop != null ) {
            String s = (String) prop.get( "testCount" );
            int i;
            if ( s == null ) {
                i = -1;
            } else {
                try {
                    i = Integer.parseInt( s );
                } catch ( NumberFormatException numberformatexception ) {
                    i = -1;
                }
            }
            testCount = i;
        } else {
            testCount = testsuite.getEstimatedTestCount( );
        }
        testSuiteID = testsuite.getID( );
        if ( testSuiteID == null ) {
            testSuiteID = "";
        }
    }

    public File getRoot( ) {

        return root;
    }

    public String getPath( ) {

        return root.getPath( );
    }

    public File getJTData( ) {

        return jtData;
    }

    public File getFile( String s ) {

        return new File( root, s );
    }

    public File getSystemFile( String s ) {

        return new File( jtData, s );
    }

    public TestSuite getTestSuite( ) {

        return testSuite;
    }

    public int getTestSuiteTestCount( ) {

        return testCount;
    }

    public void setTestSuiteTestCount( int i ) {

        if ( i != testCount ) {
            testCount = i;
            try {
                saveTestSuiteInfo( );
            } catch ( IOException ioexception ) {
            }
        }
    }

    public TestResultTable getTestResultTable( ) {

        return testResultTable;
    }

    public void log( I18NResourceBundle i18nresourcebundle, String s ) {

        log( i18nresourcebundle.getString( s ), ( (Throwable) ( null ) ) );
    }

    public void log( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

        if ( obj instanceof Throwable ) {
            log( i18nresourcebundle.getString( s, obj ), (Throwable) obj );
        } else {
            log( i18nresourcebundle.getString( s, obj ), ( (Throwable) ( null ) ) );
        }
    }

    public void log( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

        if ( aobj != null && aobj.length > 0 && ( aobj[0] instanceof Throwable ) ) {
            log( i18nresourcebundle.getString( s, aobj ), (Throwable) aobj[0] );
        } else {
            log( i18nresourcebundle.getString( s, aobj ), ( (Throwable) ( null ) ) );
        }
    }

    private synchronized void log( String s, Throwable throwable ) {

        SimpleDateFormat simpledateformat = new SimpleDateFormat( "[ddMMMyyyy kk:mmz]" );
        FileWriter filewriter = null;
        try {
            filewriter = new FileWriter( getSystemFile( "log.txt" ).getAbsolutePath( ), true );
            PrintWriter printwriter = new PrintWriter( filewriter );
            printwriter.print( simpledateformat.format( new Date( ) ) );
            printwriter.print( "  " );
            printwriter.println( s );
            if ( throwable != null ) {
                throwable.printStackTrace( printwriter );
            }
            printwriter.close( );
        } catch ( IOException ioexception ) {
        } finally {
            try {
                if ( filewriter != null ) {
                    filewriter.close( );
                }
            } catch ( IOException ioexception1 ) {
            }
        }
    }

    private static Properties loadTestSuiteInfo( File file ) throws FileNotFoundException, IOException {

        File file1 = new File( file, "testsuite" );
        BufferedInputStream bufferedinputstream = new BufferedInputStream( new FileInputStream( file1 ) );
        Properties properties = new Properties( );
        properties.load( bufferedinputstream );
        bufferedinputstream.close( );
        return properties;
    }

    @SuppressWarnings( "deprecation" )
    private void saveTestSuiteInfo( ) throws IOException {

        File file = File.createTempFile( "testsuite", ".new", jtData );
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream( new FileOutputStream( file ) );
        Properties properties = new Properties( );
        properties.put( "root", testSuite.getPath( ) );
        String s = testSuite.getName( );
        if ( s != null ) {
            properties.put( "name", s );
        }
        if ( testCount > 0 ) {
            properties.put( "testCount", Integer.toString( testCount ) );
        }
        if ( testSuiteID != null && testSuiteID.length( ) > 0 ) {
            properties.put( "id", testSuiteID );
        }
        properties.save( bufferedoutputstream, "JavaTest Work Directory: Test Suite Info" );
        bufferedoutputstream.close( );
        file.renameTo( new File( jtData, "testsuite" ) );
    }

    private static File canonicalize( File file ) throws BadDirectoryFault {

        try {
            return file.getCanonicalFile( );
        } catch ( IOException ioexception ) {
            throw new BadDirectoryFault( i18n, "wd.cantCanonicalize", file, ioexception );
        }
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private File root;

    private TestSuite testSuite;

    private String testSuiteID;

    private int testCount;

    private TestResultTable testResultTable;

    private File jtData;

    private static HashMap<File, WeakReference<WorkDirectory>> dirMap = new HashMap<File, WeakReference<WorkDirectory>>( 2 );

    private static I18NResourceBundle i18n;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.WorkDirectory.class );
    }
}
