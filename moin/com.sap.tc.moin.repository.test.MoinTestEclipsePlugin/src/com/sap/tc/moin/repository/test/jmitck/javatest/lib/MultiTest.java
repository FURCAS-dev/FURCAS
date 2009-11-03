// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: MultiTest.java

package com.sap.tc.moin.repository.test.jmitck.javatest.lib;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.Test;

// Referenced classes of package com.sun.javatest.lib:
// TestCases

@SuppressWarnings( "nls" )
public class MultiTest implements Test {

    public static class SetupException extends Exception {

        private static final long serialVersionUID = 1L;

        public static SetupException notApplicable( String s ) {

            SetupException setupexception = new SetupException( "Test not applicable: " + s );
            setupexception.passed = true;
            return setupexception;
        }

        public boolean isPassed( ) {

            return passed;
        }

        private boolean passed;

        public SetupException( String s ) {

            super( s );
            passed = false;
        }
    }

    public MultiTest( ) {

    }

    public Status run( String as[], PrintWriter printwriter, PrintWriter printwriter1 ) {

        log = printwriter;
        ref = printwriter1;
        testCases = new TestCases( this, printwriter );
        Status status = init( as );
        if ( testNotApplicable || status != null && status.getType( ) != 0 ) {
            return status;
        } else {
            return testCases.invokeTestCases( );
        }
    }

    public final Status run( String as[], PrintStream printstream, PrintStream printstream1 ) {

        PrintWriter printwriter = new PrintWriter( new OutputStreamWriter( printstream ) );
        PrintWriter printwriter1 = new PrintWriter( new OutputStreamWriter( printstream1 ) );
        try {
            Status status = run( as, printwriter, printwriter1 );
            return status;
        } finally {
            printwriter.flush( );
            printwriter1.flush( );
        }
    }

    /**
     * @deprecated Method init is deprecated
     */

    @Deprecated
    protected Status init( String as[] ) {

        try {
            decodeAllArgs( as );
            init( );
            return null;
        } catch ( SetupException setupexception ) {
            testNotApplicable = true;
            return setupexception.isPassed( ) ? Status.passed( setupexception.getMessage( ) ) : Status.failed( setupexception.getMessage( ) );
        }
    }

    protected void init( ) throws SetupException {

    }

    protected final void decodeAllArgs( String as[] ) throws SetupException {

        int j;
        for ( int i = 0; i < as.length; i += j ) {
            j = decodeArg( as, i );
            if ( j == 0 ) {
                throw new SetupException( "Could not recognize argument: " + as[i] );
            }
        }

    }

    protected int decodeArg( String as[], int i ) throws SetupException {

        try {
            if ( as[i].equals( "-select" ) && i + 1 < as.length ) {
                testCases.select( as[i + 1] );
                return 2;
            }
            if ( as[i].equals( "-exclude" ) && i + 1 < as.length ) {
                testCases.exclude( as[i + 1] );
                return 2;
            }
            if ( as[i].equals( "-TestCaseID" ) ) {
                if ( i + 1 < as.length && as[i + 1].equals( "ALL" ) ) {
                    return 2;
                }
                int j;
                for ( j = i + 1; j < as.length && !as[j].startsWith( "-" ); j++ ) {
                    testCases.select( as[j] );
                }

                return j - i;
            } else {
                return 0;
            }
        } catch ( TestCases.Fault fault ) {
            throw new SetupException( fault.getMessage( ) );
        }
    }

    protected Status invokeTestCase( Method method ) throws IllegalAccessException, InvocationTargetException {

        Object aobj[] = new Object[0];
        return (Status) method.invoke( this, aobj );
    }

    private TestCases testCases;

    private boolean testNotApplicable;

    protected PrintWriter ref;

    protected PrintWriter log;
}
