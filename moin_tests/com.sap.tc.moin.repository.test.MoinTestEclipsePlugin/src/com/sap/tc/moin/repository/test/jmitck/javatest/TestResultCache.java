// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestResultCache.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.SortedSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.Debug;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestResult, Status, WorkDirectory, JavaTestError

@SuppressWarnings( "nls" )
public class TestResultCache {

    private class ShutdownHandler extends Thread {

        @Override
        public void run( ) {

            synchronized ( this ) {
                int i = 0;
                try {
                    while ( lockFile.exists( ) && i < TIMEOUT ) {
                        wait( DELAY );
                        i++;
                    }
                } catch ( InterruptedException interruptedexception ) {
                } finally {
                    if ( lockFile.exists( ) ) {
                        Debug.println( "TRC - lockfile not removed, destroying cache!" );
                        if ( cacheFile != null ) {
                            cacheFile.delete( );
                        }
                        if ( lockFile != null ) {
                            lockFile.delete( );
                        }
                    }
                }
            }
        }

        private int TIMEOUT;

        private int DELAY;

        private ShutdownHandler( ) {

            TIMEOUT = 5;
            DELAY = 1000;
        }

    }

    private static class ExtensionFilenameFilter implements FilenameFilter {

        public boolean accept( File file, String s ) {

            File file1 = new File( file, s );
            if ( file1.isDirectory( ) ) {
                return false;
            } else {
                s = s.toLowerCase( Locale.ENGLISH );
                return s.endsWith( extension );
            }
        }

        private String extension;

        public ExtensionFilenameFilter( String s ) {

            extension = s;
        }
    }

    private static class TestResultComparator implements Comparator<TestResult> {

        public int compare( TestResult obj, TestResult obj1 ) {
            int i = 0;
            i = obj.getWorkRelativePath( ).toLowerCase( Locale.ENGLISH ).compareTo( obj1.getWorkRelativePath( ).toLowerCase( Locale.ENGLISH ) );
            return i;
        }

        private TestResultComparator( ) {
        }
    }

    public static interface Observer {

        public abstract void newEntry( TestResult testresult );

        public abstract void resetCache( );
    }

    public static class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        Throwable getOriginalFault( ) {

            return orig;
        }

        protected Throwable orig;

        Fault( String s ) {

            super( s );
        }

        Fault( String s, Throwable throwable ) {

            super( s );
            orig = throwable;
        }
    }

    public TestResultCache( WorkDirectory workdirectory ) throws Fault {

        workDir = workdirectory;
        boolean flag = false;
        newResults = new Vector<TestResult>( );
        lockFile = workdirectory.getSystemFile( "ResultCache.jtw.lck" );
        cacheFile = workdirectory.getSystemFile( "ResultCache.jtw" );
        Runtime.getRuntime( ).addShutdownHook( new ShutdownHandler( ) );
        try {
            getLock( );
            if ( cacheFile.exists( ) ) {
                flag = true;
            }
            try {
                raf = new RandomAccessFile( cacheFile, "rw" );
            } catch ( FileNotFoundException filenotfoundexception ) {
                Object aobj[] = { cacheFile.getPath( ), filenotfoundexception.getMessage( ) };
                throw new Fault( i18n.getString( "trc.cantopen", aobj ), filenotfoundexception );
            }
            if ( flag ) {
                serial = raf.readInt( );
            } else {
                initCache( );
            }
            releaseLock( );
            timer = new Timer( true );
            flushTask = new TimerTask( ) {

                @Override
                public void run( ) {

                    if ( System.currentTimeMillis( ) - timeLastFlush <= 30000L ) {
                        return;
                    }
                    try {
                        flush( );
                    } catch ( Fault fault1 ) {
                        if ( TestResultCache.debug ) {
                            System.err.println( "Error flushing WorkDir" );
                            fault1.printStackTrace( );
                        }
                        throw new JavaTestError( TestResultCache.i18n, "trc.flushError", fault1 );
                    }
                }

            };
            timeLastFlush = System.currentTimeMillis( );
            timer.schedule( flushTask, new Date( System.currentTimeMillis( ) + 30000L ), 30000L );
        } catch ( IOException ioexception ) {
            if ( lockFile != null && lockFile.exists( ) ) {
                lockFile.delete( );
            }
            if ( cacheFile != null && cacheFile.exists( ) ) {
                cacheFile.delete( );
            }
            throw new Fault( ioexception.getMessage( ), ioexception );
        } catch ( TestResult.Fault fault ) {
            throw new Fault( fault.getMessage( ), fault );
        }
    }

    public synchronized void setObserver( Observer observer1 ) throws IllegalStateException {

        if ( observer == null ) {
            observer = observer1;
            observer1.resetCache( );
        } else {
            throw new IllegalStateException( "Error: Observer already specified" );
        }
    }

    public void removeObserver( ) {

        if ( observer != null ) {
            observer = null;
        }
    }

    public void add( TestResult testresult ) throws Fault {

        newResults.add( testresult );
        long l = System.currentTimeMillis( );
        synchronized ( this ) {
            if ( newResults.size( ) >= 5 || l - timeLastFlush > 0x989680L ) {
                flush( );
            }
        }
    }

    public synchronized void flush( ) throws Fault {

        timeLastFlush = System.currentTimeMillis( );
        try {
            Hashtable<String, String> hashtable = new Hashtable<String, String>( );
            boolean flag = false;
            getLock( );
            raf.seek( 0L );
            int i = raf.readInt( );
            if ( i != serial ) {
                raf.seek( raf.length( ) );
                serial = i;
                flag = true;
            } else {
                moveToFileEnd( hashtable );
            }
            for ( int j = 0; j < newResults.size( ); j++ ) {
                TestResult testresult = newResults.elementAt( j );
                if ( ( flag || hashtable.containsKey( testresult.getTestName( ) ) ) && testresult.isReloadable( ) ) {
                    File file = workDir.getFile( testresult.getWorkRelativePath( ) );
                    try {
                        testresult = new TestResult( file );
                    } catch ( TestResult.ResultFileNotFoundFault resultfilenotfoundfault ) {
                        if ( debug ) {
                            Debug.println( "Can't find file " + file.getPath( ) + " deleting it!" );
                            resultfilenotfoundfault.printStackTrace( Debug.getWriter( ) );
                        }
                        workDir.log( i18n, "trc.lostjtr", file.getPath( ) );
                        continue;
                    } catch ( TestResult.ReloadFault reloadfault ) {
                        if ( debug ) {
                            Debug.println( "Can't reload " + file.getPath( ) + " deleting it!" );
                            reloadfault.printStackTrace( Debug.getWriter( ) );
                        }
                        workDir.log( i18n, "trc.badjtr", file.getPath( ) );
                        file.delete( );
                        continue;
                    }
                }
                if ( testresult.isReloadable( ) || testresult.getStatus( ).getType( ) == 3 ) {
                    addResult( testresult, !flag );
                } else if ( debug ) {
                    System.out.println( "TRC - TR not reloadable, not adding to cache:" );
                    System.out.println( "   -> name: " + testresult.getTestName( ) );
                    System.out.println( "   -> status:  " + testresult.getStatus( ) );
                }
            }

            newResults.clear( );
            fileEnd = raf.length( );
            releaseLock( );
            if ( flag && observer != null ) {
                observer.resetCache( );
            }
        } catch ( TestResult.Fault fault ) {
            if ( debug ) {
                fault.printStackTrace( );
            }
            if ( !attemptingRecovery ) {
                attemptingRecovery = true;
                abortAndRecover( fault );
                flush( );
                attemptingRecovery = false;
            } else {
                attemptingRecovery = false;
                throw new Fault( fault.getMessage( ), fault );
            }
        } catch ( IOException ioexception ) {
            if ( debug ) {
                ioexception.printStackTrace( );
            }
            if ( !attemptingRecovery ) {
                attemptingRecovery = true;
                abortAndRecover( ioexception );
                flush( );
                attemptingRecovery = false;
            } else {
                attemptingRecovery = false;
                throw new Fault( ioexception.getMessage( ), ioexception );
            }
        }
    }

    private void moveToFileEnd( Hashtable<String, String> hashtable ) throws IOException {

        raf.seek( raf.length( ) );
        while ( raf.length( ) != raf.getFilePointer( ) ) {
            String s = raf.readUTF( );
            int i = raf.readInt( );
            String s1 = raf.readUTF( );
            hashtable.put( s, s );
            if ( observer != null ) {
                observer.newEntry( new TestResult( s, workDir, new Status( i, s1 ) ) );
            }
        }
    }

    public synchronized SortedSet<TestResult> getEntries( ) throws Fault {

        try {
            getLock( );
            SortedSet<TestResult> sortedset = getEntriesInternal( );
            releaseLock( );
            attemptingRecovery = false;
            return sortedset;
        } catch ( IOException ioexception ) {
            if ( debug ) {
                ioexception.printStackTrace( );
            }
            if ( !attemptingRecovery ) {
                attemptingRecovery = true;
                abortAndRecover( ioexception );
                return getEntries( );
            } else {
                attemptingRecovery = false;
                throw new Fault( ioexception.getMessage( ), ioexception );
            }
        }
    }

    private synchronized SortedSet<TestResult> getEntriesInternal( ) throws IOException {

        Hashtable<String, TestResult> hashtable = new Hashtable<String, TestResult>( );
        TreeSet<TestResult> treeset = new TreeSet<TestResult>( new TestResultComparator( ) );
        fileEnd = raf.length( );
        raf.seek( 4L );
        while ( raf.getFilePointer( ) != fileEnd ) {
            String s = raf.readUTF( );
            int i = raf.readInt( );
            String s2 = raf.readUTF( );
            TestResult testresult1 = new TestResult( s, workDir, new Status( i, s2 ) );
            if ( i == 3 && !testresult1.isReloadable( ) ) {
                hashtable.remove( s );
            } else {
                hashtable.put( s, testresult1 );
            }
        }
        TestResult testresult;
        for ( Enumeration<String> enumeration = hashtable.keys( ); enumeration.hasMoreElements( ); treeset.add( testresult ) ) {
            String s1 = enumeration.nextElement( );
            testresult = hashtable.get( s1 );
        }

        return treeset;
    }

    private synchronized void initCache( ) throws TestResult.Fault, IOException {

        raf.setLength( 0L );
        raf.seek( 0L );
        raf.writeInt( serial );
        addJTRFiles( workDir.getRoot( ) );
        fileEnd = raf.length( );
    }

    private synchronized void addJTRFiles( File file ) throws TestResult.Fault, IOException {

        File afile[] = file.listFiles( new ExtensionFilenameFilter( ".jtr" ) );
        if ( afile != null ) {
            for ( int i = 0; i < afile.length; i++ ) {
                try {
                    TestResult testresult = new TestResult( afile[i] );
                    addResult( testresult, false );
                } catch ( TestResult.ResultFileNotFoundFault resultfilenotfoundfault ) {
                    workDir.log( i18n, "trc.lostjtr", afile[i].getPath( ) );
                } catch ( TestResult.ReloadFault reloadfault ) {
                    workDir.log( i18n, "trc.badjtr", afile[i].getPath( ) );
                    afile[i].delete( );
                }
            }

        }
        Vector<String> vector = getDirs( file );
        for ( int j = 0; j < vector.size( ); j++ ) {
            String s = vector.elementAt( j );
            File file1 = new File( file, s );
            addJTRFiles( file1 );
        }

    }

    private void addResult( TestResult testresult, boolean flag ) throws IOException, TestResult.Fault {

        String s = testresult.getTestName( );
        Status status = testresult.getStatus( );
        raf.writeUTF( s );
        raf.writeInt( status.getType( ) );
        raf.writeUTF( status.getReason( ) );
        if ( flag && observer != null ) {
            observer.newEntry( testresult );
        }
    }

    public synchronized void compress( ) throws IOException, Fault {

        try {
            getLock( );
            fileEnd = raf.length( );
            SortedSet<TestResult> sortedset = getEntriesInternal( );
            raf.seek( 0L );
            int i = raf.readInt( ) + 1;
            raf.setLength( 0L );
            raf.writeInt( i );
            for ( Iterator<TestResult> iterator = sortedset.iterator( ); iterator.hasNext( ); ) {
                TestResult testresult = iterator.next( );
                if ( testresult.getStatus( ).getType( ) != 3 || testresult.isReloadable( ) ) {
                    raf.writeUTF( testresult.getTestName( ) );
                    raf.writeInt( testresult.getStatus( ).getType( ) );
                    raf.writeUTF( testresult.getStatus( ).getReason( ) );
                }
            }

            fileEnd = raf.length( );
            releaseLock( );
        } catch ( IOException ioexception ) {
            if ( debug ) {
                ioexception.printStackTrace( Debug.getWriter( ) );
            }
            abortAndRecover( ioexception );
        }
        flush( );
    }

    private static Vector<String> getDirs( File file ) {

        Vector<String> vector = new Vector<String>( );
        String as[] = file.list( );
        if ( as != null ) {
            for ( int i = 0; i < as.length; i++ ) {
                if ( ( new File( file, as[i] ) ).isDirectory( ) ) {
                    vector.addElement( as[i] );
                }
            }

        }
        return vector;
    }

    private synchronized void getLock( ) throws IOException {

        if ( debug ) {
            System.out.print( "TRC - trying to acquire lock " + lockFile + " ..." );
        }
        long l = System.currentTimeMillis( );
        long l1 = l;
        while ( !lockFile.createNewFile( ) ) {
            long l2 = System.currentTimeMillis( );
            long l3 = l2 - l;
            if ( l3 >= 20000L ) {
                if ( l3 < 60000L ) {
                    if ( l1 - l <= 20000L ) {
                        System.err.println( i18n.getString( "trc.waiting", lockFile.getPath( ) ) );
                        l1 = System.currentTimeMillis( );
                    }
                } else {
                    long l4 = ( l1 - l ) / 60000L;
                    long l5 = ( l2 - l ) / 60000L;
                    if ( l5 > l4 ) {
                        System.err.println( i18n.getString( "trc.waiting", lockFile.getPath( ) ) );
                        l1 = System.currentTimeMillis( );
                    }
                }
            }
        }
        if ( debug ) {
            System.out.println( "success!" );
        }
    }

    private synchronized void releaseLock( ) {

        if ( debug ) {
            System.out.println( "TRC - Removing lock." );
        }
        lockFile.delete( );
    }

    private synchronized void abortAndRecover( Throwable throwable ) throws Fault {

        workDir.log( i18n, "trc.recovering", throwable );
        try {
            raf.close( );
        } catch ( IOException ioexception ) {
        }
        cacheFile.delete( );
        try {
            raf = new RandomAccessFile( cacheFile, "rw" );
        } catch ( FileNotFoundException filenotfoundexception ) {
            Object aobj[] = { cacheFile.getPath( ), filenotfoundexception.getMessage( ) };
            throw new Fault( i18n.getString( "trc.cantopen", aobj ), filenotfoundexception );
        }
        serial++;
        try {
            initCache( );
        } catch ( IOException ioexception1 ) {
            if ( debug ) {
                ioexception1.printStackTrace( Debug.getWriter( ) );
            }
            Object aobj1[] = { cacheFile.getPath( ), ioexception1.getMessage( ) };
            throw new Fault( i18n.getString( "trc.unrecover", aobj1 ), ioexception1 );
        } catch ( TestResult.Fault fault ) {
            if ( debug ) {
                fault.printStackTrace( Debug.getWriter( ) );
            }
            throw new Fault( i18n.getString( "trc.badtr", fault.getMessage( ) ), fault );
        }
        workDir.log( i18n, "trc.recovered" );
        releaseLock( );
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private int serial;

    private RandomAccessFile raf;

    private File lockFile;

    private File cacheFile;

    private long fileEnd;

    private Observer observer;

    private Vector<TestResult> newResults;

    private WorkDirectory workDir;

    private Timer timer;

    private TimerTask flushTask;

    private long timeLastFlush;

    private boolean attemptingRecovery;

    private static I18NResourceBundle i18n;

    private static boolean debug;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TestResultCache.class );
        debug = Debug.getBoolean( ( com.sap.tc.moin.repository.test.jmitck.javatest.TestResultCache.class ).getName( ) );
    }

}
