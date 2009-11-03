// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: Script.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.OS_ARCH;
import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.OS_NAME;
import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.OS_VERSION;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Date;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.BackupPolicy;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.StringArray;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.Timer;

// Referenced classes of package com.sun.javatest:
// TestResult, Command, ResourceTable, TestDescription,
// WorkDirectory, ProductInfo, TestEnvironment, Status

@SuppressWarnings( "nls" )
public abstract class Script {

    private class Alarm implements com.sap.tc.moin.repository.test.jmitck.javatest.util.Timer.Timeable {

        synchronized void cancel( ) {

            if ( Script.debugAlarm ) {
                System.err.println( "alarm " + this + " cancelled" );
            }
            Script.alarmTimer.cancel( entry );
        }

        public synchronized void timeout( ) {

            if ( count == 0 ) {
                trOut.println( "Timeout signalled after " + delay / 1000D + " seconds" );
            } else if ( count % 100 == 0 ) {
                trOut.println( "Test not responding after " + count + " interrupts" );
                if ( count % 1000 == 0 ) {
                    System.err.println( "Test " + td.getRootRelativeURL( ) + " has timed out and is not responding after " + count + " interrupts" );
                }
            }
            if ( Script.debugAlarm ) {
                System.err.println( "alarm " + this + " interrupting " + caller );
            }
            caller.interrupt( );
            count++;
            entry = Script.alarmTimer.requestDelayedCallback( this, 100L );
        }

        private int delay;

        private Thread caller;

        private int count;

        private com.sap.tc.moin.repository.test.jmitck.javatest.util.Timer.Entry entry;

        Alarm( int i ) {

            delay = i;
            caller = Thread.currentThread( );
            entry = Script.alarmTimer.requestDelayedCallback( this, i );
            if ( Script.debugAlarm ) {
                System.err.println( "alarm " + this + " started" );
            }
        }
    }

    public Script( ) {

        backupPolicy = BackupPolicy.noBackups( );
        jtrIfPassed = System.getProperty( "javatest.script.jtrIfPassed", "true" ).equals( "true" );
    }

    public void initArgs( String as[] ) {

        scriptArgs = as;
    }

    public void initTestDescription( TestDescription testdescription ) {

        td = testdescription;
        testResult = new TestResult( testdescription );
        trOut = testResult.getTestCommentWriter( );
    }

    public void initExcludedTestCases( String as[] ) {

        excludedTestCases = as;
    }

    public void initTestEnvironment( TestEnvironment testenvironment ) {

        env = testenvironment;
    }

    public void initWorkDir( WorkDirectory workdirectory ) {

        workDir = workdirectory;
    }

    public void initBackupPolicy( BackupPolicy backuppolicy ) {

        backupPolicy = backuppolicy;
    }

    public void initClassLoader( ClassLoader classloader ) {

        loader = classloader;
    }

    protected void initDelegate( Script script, String as[] ) {

        script.scriptArgs = as;
        script.td = td;
        script.env = env;
        script.workDir = workDir;
        script.backupPolicy = backupPolicy;
        script.loader = loader;
        script.testResult = testResult;
        script.trOut = trOut;
        script.jtrIfPassed = jtrIfPassed;
    }

    protected void initTestResult( TestResult testresult ) {

        if ( testResult != null ) {
            throw new IllegalStateException( );
        } else {
            testResult = testresult;
            return;
        }
    }

    public void run( ) {

        if ( workDir == null ) {
            throw new NullPointerException( "work directory not set" );
        }
        if ( td == null ) {
            throw new NullPointerException( "test description not set" );
        }
        if ( testResult == null ) {
            throw new NullPointerException( "test result not set" );
        }
        if ( env == null ) {
            throw new NullPointerException( "test environment not set" );
        }
        Status status = null;
        File file = workDir.getFile( td.getRootRelativeDir( ).getPath( ) );
        if ( !file.exists( ) ) {
            file.mkdirs( );
        }
        String s = td.getFile( ).getPath( ).replace( File.separatorChar, '/' );
        String s1 = s.startsWith( "/" ) ? "file://" : "file:///";
        String s2 = s1 + s;
        String s3 = td.getId( );
        if ( s3 != null ) {
            s2 = s2 + "#" + s3;
        }
        testResult.putProperty( "description", s2 );
        testResult.putProperty( "start", ( new Date( ) ).toString( ) );
        testResult.putProperty( "javatestVersion", ProductInfo.getVersion( ) );
        testResult.putProperty( "work", file.getAbsolutePath( ) );
        testResult.putProperty( "environment", env.getName( ) );
        if ( osInfo == null ) {
            String s4 = System.getProperty( OS_ARCH );
            String s6 = System.getProperty( OS_NAME );
            String s7 = System.getProperty( OS_VERSION );
            osInfo = s6 + " " + s7 + " (" + s4 + ")";
        }
        testResult.putProperty( "javatestOS", osInfo );
        if ( excludedTestCases != null ) {
            testResult.putProperty( "excludedTestCases", StringArray.join( excludedTestCases ) );
        }
        String s5 = td.getParameter( "classDir" );
        File file1 = s5 != null ? new File( file, s5 ) : workDir.getFile( "classes" );
        env.putUrlAndFile( "testClassDir", file1, true );
        env.putUrlAndFile( "testWorkDir", file, true );
        env.put( "test", td.getFile( ).getPath( ) );
        env.put( "testDir", td.getFile( ).getParent( ) );
        env.put( "testURL", s2 );
        env.put( "testPath", td.getRootRelativeURL( ) );
        int i = getTestTimeout( );
        try {
            testResult.putProperty( "test", td.getRootRelativeURL( ) );
            testResult.putProperty( "script", getClass( ).getName( ) + " " + StringArray.join( scriptArgs ) );
            if ( i > 0 ) {
                testResult.putProperty( "timeoutSeconds", Integer.toString( i ) );
                setAlarm( i * 1000 );
            }
            status = run( scriptArgs, td, env );
        } finally {
            if ( i > 0 ) {
                setAlarm( 0 );
            }
            try {
                System.setOut( System.out );
                System.setErr( System.err );
            } catch ( SecurityException securityexception ) {
            }
            if ( Thread.interrupted( ) ) {
                status = Status.error( "test was interrupted! (timeout?)" );
            }
            testResult.putProperty( "end", ( new Date( ) ).toString( ) );
            if ( status == null ) {
                status = Status.error( "Script did not return status" );
            } else {
                switch ( status.getType( ) ) {
                    default:
                        status = Status.error( "Illegal status returned from test: " + status );
                        break;

                    case 0: // '\0'
                    case 1: // '\001'
                    case 2: // '\002'
                        break;
                }
            }
        }
        testResult.setEnvironment( env );
        testResult.setStatus( status );
        try {
            if ( status.getType( ) != 0 || jtrIfPassed ) {
                testResult.writeResults( workDir, backupPolicy );
            }
        } catch ( IOException ioexception ) {
        }
    }

    public abstract Status run( String as[], TestDescription testdescription, TestEnvironment testenvironment );

    public TestDescription getTestDescription( ) {

        return td;
    }

    public TestResult getTestResult( ) {

        return testResult;
    }

    public boolean getJTRIfPassed( ) {

        return jtrIfPassed;
    }

    public void setJTRIfPassed( boolean flag ) {

        jtrIfPassed = flag;
    }

    protected void setAlarm( int i ) {

        if ( alarm != null ) {
            alarm.cancel( );
            alarm = null;
        }
        if ( i > 0 ) {
            alarm = new Alarm( i );
        }
    }

    protected int getTestTimeout( ) {

        int i = 1;
        try {
            String as[] = env.lookup( "javatestTimeoutFactor" );
            if ( as != null && as.length == 1 ) {
                i = Integer.parseInt( as[0] );
            }
        } catch ( TestEnvironment.Fault fault ) {
        }
        return 600 * i;
    }

    protected Status compileIndividually( String as[] ) {

        return compileIndividually( "compile", as );
    }

    protected Status compileIndividually( String s, String as[] ) {

        if ( as.length == 0 ) {
            return error_noSource;
        }
        for ( int i = 0; i < as.length; i++ ) {
            Status status = compileOne( s, as[i] );
            if ( !status.isPassed( ) ) {
                return status;
            }
        }

        return pass_compSuccExp;
    }

    protected Status compileIndividually( File afile[] ) {

        return compileIndividually( "compile", filesToStrings( afile ) );
    }

    protected Status compileIndividually( String s, File afile[] ) {

        return compileIndividually( s, filesToStrings( afile ) );
    }

    protected Status compileOne( String s ) {

        return compileOne( "compile", s );
    }

    protected Status compileOne( String s, String s1 ) {

        return compileTogether( s, new String[] { s1 } );
    }

    protected Status compileOne( File file ) {

        return compileOne( "compile", file.getPath( ) );
    }

    protected Status compileOne( String s, File file ) {

        return compileOne( s, file.getPath( ) );
    }

    protected Status compileTogether( String as[] ) {

        return compileTogether( "compile", as );
    }

    protected Status compileTogether( String s, String as[] ) {

        if ( as.length == 0 ) {
            return error_noSource;
        }
        try {
            String as1[] = env.lookup( "testClassDir" );
            if ( as1 == null || as1.length != 1 ) {
                return error_badTestClassDir;
            }
            File file = new File( as1[0] );
            if ( !file.exists( ) ) {
                file.mkdirs( );
            }
        } catch ( TestEnvironment.Fault fault ) {
            return error_badTestClassDir;
        }
        String s1 = as[0];
        int i = s1.lastIndexOf( '.' );
        if ( i == -1 ) {
            return error_noExtnInSource;
        }
        String s2 = s1.substring( i );
        env.put( "testSource", as );
        try {
            Status status1;
            try {
                boolean flag = sourceTable.acquire( as, 0x927c0 );
                if ( !flag ) {
                    Status status = Status.error( "timeout waiting to acquire internal lock on source files" );
                    return status;
                }
                Status status2 = invokeCommand( s + s2 );
                return status2;
            } catch ( InterruptedException interruptedexception ) {
                status1 = Status.error( "interrupted while waiting to acquire internal lock on source files" );
            }
            return status1;
        } finally {
            sourceTable.release( as );
        }
    }

    protected Status compileTogether( File afile[] ) {

        return compileTogether( "compile", filesToStrings( afile ) );
    }

    protected Status compileTogether( String s, File afile[] ) {

        return compileTogether( s, filesToStrings( afile ) );
    }

    protected Status compileIfNecessary( String as[], String s ) {

        return compileIfNecessary( "compile", as, s );
    }

    protected Status compileIfNecessary( String s, String as[], String s1 ) {

        if ( as.length == 0 ) {
            return error_noSource;
        }
        if ( s1 == null ) {
            s1 = "$testClassDir";
        }
        if ( s1.startsWith( "$" ) ) {
            try {
                String as1[] = env.resolve( s1 );
                if ( as1 == null || as1.length != 1 ) {
                    return error_badTestClassDir;
                }
                s1 = as1[0];
            } catch ( TestEnvironment.Fault fault ) {
                return error_badTestClassDir;
            }
        }
        File file = new File( s1 );
        if ( !file.exists( ) ) {
            file.mkdirs( );
        }
        Vector<String> vector = new Vector<String>( 0, as.length );
        for ( int i = 0; i < as.length; i++ ) {
            String s2;
            String s3;
            String s4;
            label0: {
                s2 = as[i];
                int j = s2.lastIndexOf( File.separatorChar );
                int k = s2.indexOf( '.', j + 1 );
                s3 = s2.substring( j + 1, k != -1 ? k : s2.length( ) );
                BufferedReader bufferedreader = null;
                try {
                    try {
                        bufferedreader = new BufferedReader( new FileReader( s2 ) );
                        StreamTokenizer streamtokenizer = new StreamTokenizer( bufferedreader );
                        streamtokenizer.ordinaryChar( 47 );
                        streamtokenizer.slashStarComments( true );
                        streamtokenizer.slashSlashComments( true );
                        streamtokenizer.wordChars( 46, 46 );
                        int l = streamtokenizer.nextToken( );
                        if ( l == -3 && streamtokenizer.sval.equals( "package" ) ) {
                            int i1 = streamtokenizer.nextToken( );
                            if ( i1 == -3 ) {
                                s4 = streamtokenizer.sval.replace( '.', File.separatorChar ) + File.separatorChar;
                            } else {
                                trOut.println( "malformed package statement for " + s2 + "; compiling anyway" );
                                vector.addElement( s2 );
                                continue;
                            }
                        } else {
                            s4 = "";
                        }
                    } catch ( IOException ioexception ) {
                        trOut.println( "cannot check date stamp for " + s2 + " compiling anyway; " + ioexception );
                        vector.addElement( s2 );
                        continue;
                    }
                    break label0;
                } finally {
                    if ( bufferedreader != null ) {
                        try {
                            bufferedreader.close( );
                        } catch ( IOException ioexception1 ) {
                        }
                    }
                }
            }
            File file1 = new File( s2 );
            File file2 = new File( s1, s4 + s3 + ".class" );
            if ( file2.exists( ) && file2.lastModified( ) > file1.lastModified( ) ) {
                trOut.println( "file does not need compiling: " + s2 );
            } else {
                vector.addElement( s2 );
            }
        }

        if ( vector.size( ) > 0 ) {
            String as2[] = new String[vector.size( )];
            vector.copyInto( as2 );
            return compileTogether( s, as2 );
        } else {
            return Status.passed( "no files needed compiling" );
        }
    }

    protected Status compileIfNecessary( File afile[], String s ) {

        return compileIfNecessary( "compile", filesToStrings( afile ), s );
    }

    protected Status compileIfNecessary( String s, File afile[], String s1 ) {

        return compileIfNecessary( s, filesToStrings( afile ), s1 );
    }

    protected Status execute( String s, String s1 ) {

        return execute( "execute", s, s1 );
    }

    protected Status execute( String s, String s1, String s2 ) {

        try {
            String as[] = s2 != null ? env.resolve( s2 ) : nullArgs;
            if ( excludedTestCases != null ) {
                as = exclude( as, excludedTestCases );
            }
            return execute( s, s1, as );
        } catch ( TestEnvironment.Fault fault ) {
            trOut.println( "Trying to evaluate executeArgs: " + s2 );
            trOut.println( fault.toString( ) );
            return error_badExecuteArgs;
        }
    }

    protected Status execute( String s, String as[] ) {

        return execute( "execute", s, as );
    }

    protected Status execute( String s, String s1, String as[] ) {

        if ( s1 == null || s1.length( ) == 0 ) {
            return error_noExecuteClass;
        } else {
            env.put( "testExecuteClass", s1 );
            env.put( "testExecuteArgs", as );
            return invokeCommand( s );
        }
    }

    protected Status rmiCompile( String as[] ) {

        return rmiCompile( "rmic", as );
    }

    protected Status rmiCompile( String s, String as[] ) {

        try {
            String as1[] = env.lookup( "testClassDir" );
            if ( as1 == null || as1.length != 1 ) {
                return error_badTestClassDir;
            }
            File file = new File( as1[0] );
            if ( !file.exists( ) ) {
                file.mkdirs( );
            }
        } catch ( TestEnvironment.Fault fault ) {
            return error_badTestClassDir;
        }
        if ( as == null || as.length == 0 ) {
            return error_noRMIClasses;
        } else {
            env.put( "testRmicClasses", as );
            env.put( "testRmicClass", as );
            return invokeCommand( s );
        }
    }

    protected Status invokeCommand( String s ) {

        try {
            String as[] = env.lookup( "command." + s );
            if ( as.length == 0 ) {
                return Status.error( "environment `" + env.getName( ) + "' does not define a command `" + s + "'" );
            }
            String s1 = as[0];
            String as1[] = new String[as.length - 1];
            System.arraycopy( as, 1, as1, 0, as1.length );
            TestResult.Section section = testResult.createSection( s );
            String s2 = "command: " + s1 + " " + StringArray.join( as1 );
            section.getMessageWriter( ).println( s2 );
            PrintWriter printwriter = null;
            PrintWriter printwriter1 = null;
            Status status;
            try {
                printwriter = section.createOutput( "ref" );
                printwriter1 = section.createOutput( "log" );
                status = invokeClass( s1, as1, printwriter1, printwriter );
                printwriter1.close( );
                printwriter.close( );
            } finally {
                if ( printwriter != null ) {
                    printwriter.close( );
                }
                if ( printwriter1 != null ) {
                    printwriter1.close( );
                }
            }
            section.setStatus( status );
            return status;
        } catch ( TestEnvironment.Fault fault ) {
            return Status.error( "problem getting info in environment `" + env.getName( ) + "' for `command." + s + "'" );
        }
    }

    private Status invokeClass( String s, String as[], PrintWriter printwriter, PrintWriter printwriter1 ) {

        Command command;
        try {
            Class<?> class1 = loader != null ? loader.loadClass( s ) : Class.forName( s );
            command = (Command) class1.newInstance( );
        } catch ( ClassCastException classcastexception ) {
            return Status.error( "Can't run class `" + s + "': it does not implement interface " + ( com.sap.tc.moin.repository.test.jmitck.javatest.Command.class ).getName( ) );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            return Status.error( "Can't find class `" + s + "', used in `" + env.getName( ) + "'" );
        } catch ( IllegalAccessException illegalaccessexception ) {
            return Status.error( "Illegal access to class `" + s + "', used in `" + env.getName( ) + "'" );
        } catch ( IllegalArgumentException illegalargumentexception ) {
            return Status.error( "Bad class name `" + s + "', used in `" + env.getName( ) + "'" );
        } catch ( InstantiationException instantiationexception ) {
            return Status.error( "Can't instantiate class `" + s + "', used in `" + env.getName( ) + "'" );
        } catch ( ThreadDeath threaddeath1 ) {
            throw (ThreadDeath) threaddeath1.fillInStackTrace( );
        } catch ( Exception exception1 ) {
            exception1.printStackTrace( printwriter );
            return Status.error( "Unexpected exception trying to load command `" + s + "': " + exception1 );
        } catch ( Error error1 ) {
            error1.printStackTrace( printwriter );
            return Status.error( "Unexpected error trying to load command `" + s + "': " + error1 );
        } catch ( Throwable throwable1 ) {
            throwable1.printStackTrace( printwriter );
            return Status.error( "Unexpected throwable trying to load command `" + s + "': " + throwable1 );
        }
        try {
            command.setClassLoader( loader );
            return command.run( as, printwriter, printwriter1 );
        } catch ( ThreadDeath threaddeath ) {
            throw (ThreadDeath) threaddeath.fillInStackTrace( );
        } catch ( Exception exception ) {
            exception.printStackTrace( printwriter );
            return Status.failed( "Unexpected exception while executing command " + s + ": " + exception );
        } catch ( Error error ) {
            error.printStackTrace( printwriter );
            return Status.failed( "Unexpected error while executing command " + s + ": " + error );
        } catch ( Throwable throwable ) {
            throwable.printStackTrace( printwriter );
            return Status.error( "Unexpected throwable while executing command " + s + ": " + throwable );
        }
    }

    protected String[] exclude( String as[], String as1[] ) {

        if ( as1 == null ) {
            return as;
        }
        StringBuffer stringbuffer = new StringBuffer( );
        for ( int i = 0; i < as1.length; i++ ) {
            if ( i > 0 ) {
                stringbuffer.append( "," );
            }
            stringbuffer.append( as1[i] );
        }

        String as2[] = new String[as.length + 2];
        as2[0] = "-exclude";
        as2[1] = stringbuffer.toString( );
        System.arraycopy( as, 0, as2, 2, as.length );
        testResult.putProperty( "exclude", as2[1] );
        return as2;
    }

    protected static String[] filesToStrings( File afile[] ) {

        String as[] = new String[afile.length];
        for ( int i = 0; i < afile.length; i++ ) {
            as[i] = afile[i].getPath( );
        }

        return as;
    }

    private static ResourceTable sourceTable = new ResourceTable( );

    protected TestDescription td;

    protected String excludedTestCases[];

    protected TestEnvironment env;

    protected String scriptArgs[];

    protected WorkDirectory workDir;

    protected BackupPolicy backupPolicy;

    protected ClassLoader loader;

    protected PrintWriter trOut;

    protected static final Status error_badExecuteArgs = Status.error( "problem evaluating executeArgs for test" );

    protected static final Status error_badTestClassDir = Status.error( "bad value for testClassDir" );

    protected static final Status error_compFailUnexp = Status.error( "Compilation failed unexpectedly" );

    protected static final Status error_noActionSpecified = Status.error( "No action specified" );

    protected static final Status error_noExecuteClass = Status.error( "No executeClass specified" );

    protected static final Status error_noExtnInSource;

    protected static final Status error_noRMIClasses = Status.error( "no rmiclasses specified in test description" );

    protected static final Status error_noSource;

    protected static final Status fail_compFailUnexp = Status.failed( "Compilation failed unexpectedly" );

    protected static final Status fail_compSuccUnexp = Status.failed( "Compilation did not fail as expected" );

    protected static final Status fail_execSuccUnexp = Status.failed( "Execution did not fail as expected" );

    protected static final Status pass_compFailExp = Status.passed( "Compilation failed as expected" );

    protected static final Status pass_compSuccExp = Status.passed( "Compilation succeeded as expected" );

    protected static final Status pass_execFailExp = Status.passed( "Execution failed as expected" );

    protected static final Status noSource;

    protected static final Status noExtnInSource;

    private static final String nullArgs[] = new String[0];

    private static String osInfo;

    protected static Timer alarmTimer = new Timer( );

    private TestResult testResult;

    private Alarm alarm;

    private boolean jtrIfPassed;

    private static boolean debugAlarm = Boolean.getBoolean( "debug.com.sun.javatest.Script.Alarm" );

    static {
        error_noExtnInSource = Status.error( "No extension specified in source" );
        error_noSource = Status.error( "no sources specified in test description" );
        noSource = error_noSource;
        noExtnInSource = error_noExtnInSource;
    }

}
