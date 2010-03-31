package com.sap.tc.moin.test.control;

import java.util.Arrays;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

import com.sap.junit.Junit4AdditionalListener;
import com.sap.junit.MoinRunner;
import com.sap.tc.moin.test.util.printer.MoinTestLogger;

/**
 * This class implements some basic functionality for logging, verifying, and
 * asserting. It is dependent from JUnit. The error-, verify-, and assert
 * methods differ from their corresponding methods in JUnit in two aspects: they
 * are also logging their results and the XXXAndContinue() methods do not stop
 * the execution of the calling method. Additionally they append the messages to
 * the other results of the calling method. The TearDown() of the method throws
 * a runtime exception at the end which will be catched by JUnit and the
 * collected results are presented by the TestRunner. Extend your test class
 * from MoinAssertVerifyLog only if you want to develop a test case independent
 * MOIN Otherwise you should extend your test class from MoinTestCase.
 * 
 * @author d037271
 * @version $Revision: #2 $ Copyright (c) SAP AG 2005
 */
/*
 * @TODO : 1. Replace/Remove the inheritance from junit.framework.TestCase once
 * there we have an alternative for TestCase.getName(). Right now, the point is
 * not clear. The community seem to still use this. 2. org.junit.Assert should
 * have to imported explicitly here since TestCase.assert methods would not be
 * available after 1.
 */
@RunWith( MoinRunner.class )
@SuppressWarnings( "nls" )
public class MoinAssertVerifyLog extends Assert {

    /**
     * Counter <code>errorCount</code> for number of errors occured in a method.
     */
    private static int errorCount;

    /**
     * Counter <code>testClassErrorCount</code> for number of errors occured in
     * a test class.
     */
    private static int testClassErrorCount;

    /**
     * Boolean <code>oneOrMoreVerfiesFailed</code> is set to true if
     * errorAndContinue(), assertAndContinue() or verifyAndLog() fails. Reset to
     * false in beforeTestMethod().
     */
    private boolean oneOrMoreVerfiesFailed = true;

    /**
     * Junit Errors
     */
    private Failure resultSet = null;

    /*
     * initializes the Location
     */
    public MoinAssertVerifyLog( ) {

    }

    // just a wrapper constructor
    public MoinAssertVerifyLog( String arg ) {

    }

    /**
     * Verifies that two boolean are equal. Appends message to the other
     * messages of the calling method if not. Name of calling method is included
     * in message automatically. Logs it anyway.
     * 
     * @param msg the message to log
     * @param isValue the given boolean value to compare and log
     * @param expectedValue the expected boolean value to compare and log
     */
    public void verifyAndLog( String msg, boolean isValue, boolean expectedValue ) {

        boolean verified = ( isValue == expectedValue );
        MoinTestLogger.printVerify( getTestName( ), verified, msg );
        if ( !verified ) {
            MoinAssertVerifyLog.incrErrorCount( );
            this.oneOrMoreVerfiesFailed = true;
        }
    }

    protected String getTestName( ) {

        return new MoinJunit4AdditionalListener( ).getName( );
    }

    /**
     * Verifies that two int are equal. Appends message to the other messages of
     * the calling method if not. Name of calling method is included in message
     * automatically. Logs it anyway.
     * 
     * @param msg the message to log
     * @param isValue the given int value to compare and log
     * @param expectedValue the expected int value to compare and log
     */
    public void verifyAndLog( String msg, int isValue, int expectedValue ) {

        boolean verified = ( isValue == expectedValue );
        MoinTestLogger.printVerify( getTestName( ), verified, msg + ":: is: " + isValue + "; expected: " + expectedValue );
        if ( !verified ) {
            MoinAssertVerifyLog.incrErrorCount( );
            this.oneOrMoreVerfiesFailed = true;
        }
    }

    /**
     * Verifies that two objects are equal. Appends message to the other
     * messages of the calling method if not. Name of calling method is included
     * in message automatically.
     * 
     * @param msg the message to log
     * @param isValue the given Object value to compare and log
     * @param expectedValue the expected Object value to compare and log
     */
    public void verifyAndLog( String msg, Object isValue, Object expectedValue ) {

        boolean verified = ( isValue == expectedValue ) || ( isValue != null && isValue.equals( expectedValue ) );
        MoinTestLogger.printVerify( getTestName( ), verified, msg + ":: is: " + isValue + "; expected: " + expectedValue );
        if ( !verified ) {
            MoinAssertVerifyLog.incrErrorCount( );
            this.oneOrMoreVerfiesFailed = true;
        }
    }

    /**
     * Asserts that a condition is true. Appends message to the other messages
     * of the calling method and logs it if not. Name of calling method is
     * included in message automatically.
     */
    public void assertTrueAndContinue( String message, boolean condition ) {

        if ( !condition ) {
            MoinAssertVerifyLog.incrErrorCount( );
            this.oneOrMoreVerfiesFailed = true;
            MoinTestLogger.printAssertAndContinue( getTestName( ), "[assertTrue]: " + message );
        }
    }

    /**
     * Asserts that a condition is false. Appends message to the other messages
     * of the calling method and logs it if not. Name of calling method is
     * included in message automatically.
     */
    public void assertFalseAndContinue( String message, boolean condition ) {

        if ( condition ) {
            MoinAssertVerifyLog.incrErrorCount( );
            this.oneOrMoreVerfiesFailed = true;
            MoinTestLogger.printAssertAndContinue( getTestName( ), "[assertFalse]: " + message );
        }
    }

    /**
     * Asserts that two strings are equal. Appends message to the other messages
     * of the calling method and logs it if not. Name of calling method is
     * included in message automatically.
     */
    public void assertEqualsAndContinue( String message, String expected, String actual ) {

        if ( !( ( expected == null && actual == null ) || ( expected != null && expected.equals( actual ) ) ) ) {
            failAndContinue( "[assertEquals]: " + message, actual, expected );
        }
    }

    /**
     * Asserts that two strings are not equal. Appends message to the other
     * messages of the calling method and logs it if not. Name of calling method
     * is included in message automatically.
     */
    public void assertNotEqualsAndContinue( String message, String expected, String actual ) {

        if ( ( expected == null && actual == null ) || ( expected != null && expected.equals( actual ) ) ) {
            failAndContinue( "[assertNotEquals]: " + message, actual, expected );
        }
    }

    /**
     * Asserts that two objects are equal. Appends message to the other messages
     * of the calling method and logs it if they are equal. Name of calling
     * method is included in message automatically.
     */
    public void assertEqualsAndContinue( String message, Object expected, Object actual ) {

        if ( !( ( expected == null && actual == null ) || ( expected != null && expected.equals( actual ) ) ) ) {
            failAndContinue( "[assertEquals]: " + message, actual, expected );
        }
    }

    /**
     * Asserts that two objects are not equal. Appends message to the other
     * messages of the calling method and logs it if they are equal. Name of
     * calling method is included in message automatically.
     */
    public void assertNotEqualsAndContinue( String message, Object expected, Object actual ) {

        if ( ( expected == null && actual == null ) || ( expected != null && expected.equals( actual ) ) ) {
            failAndContinue( "[assertNotEquals]: " + message, actual, expected );
        }
    }

    /**
     * Asserts that two object arrays are equal. Appends message to the other
     * messages of the calling method and logs it if they are equal. Name of
     * calling method is included in message automatically.
     */
    public void assertArraysEqualAndContinue( String message, Object[] expected, Object[] actual ) {

        if ( !Arrays.equals( expected, actual ) ) {
            failAndContinue( "[assertEquals]: " + message, toString( actual ), toString( expected ) );
        }
    }

    /**
     * Asserts that two objects are not equal. Appends message to the other
     * messages of the calling method and logs it if they are equal. Name of
     * calling method is included in message automatically.
     */
    public void assertArraysNotEqualAndContinue( String message, Object[] expected, Object[] actual ) {

        if ( Arrays.equals( expected, actual ) ) {
            failAndContinue( "[assertNotEquals]: " + message, toString( actual ), toString( expected ) );
        }
    }

    /**
     * Asserts that two chars are equal. Appends message to the other messages
     * of the calling method and logs it if they are equal. Name of calling
     * method is included in message automatically.
     */
    public void assertEqualsAndContinue( String message, char expected, char actual ) {

        assertEqualsAndContinue( message, new Character( expected ), new Character( actual ) );
    }

    /**
     * Asserts that two chars are not equal. Appends message to the other
     * messages of the calling method and logs it if they are equal. Name of
     * calling method is included in message automatically.
     */
    public void assertNotEqualsAndContinue( String message, char expected, char actual ) {

        assertNotEqualsAndContinue( message, new Character( expected ), new Character( actual ) );
    }

    /**
     * Asserts that two ints are equal. Appends message to the other messages of
     * the calling method and logs it if they are equal. Name of calling method
     * is included in message automatically.
     */
    public void assertEqualsAndContinue( String message, int expected, int actual ) {

        assertEqualsAndContinue( message, new Integer( expected ), new Integer( actual ) );
    }

    /**
     * Asserts that two ints are not equal. Appends message to the other
     * messages of the calling method and logs it if they are equal. Name of
     * calling method is included in message automatically.
     */
    public void assertNotEqualsAndContinue( String message, int expected, int actual ) {

        assertNotEqualsAndContinue( message, new Integer( expected ), new Integer( actual ) );
    }

    /**
     * Asserts that longs objects are equal. Appends message to the other
     * messages of the calling method and logs it if they are equal. Name of
     * calling method is included in message automatically.
     */
    public void assertEqualsAndContinue( String message, long expected, long actual ) {

        assertEqualsAndContinue( message, new Long( expected ), new Long( actual ) );
    }

    /**
     * Asserts that longs objects are not equal. Appends message to the other
     * messages of the calling method and logs it if they are equal. Name of
     * calling method is included in message automatically.
     */
    public void assertNotEqualsAndContinue( String message, long expected, long actual ) {

        assertNotEqualsAndContinue( message, new Long( expected ), new Long( actual ) );
    }

    /**
     * Asserts that two boolean are equal. Appends message to the other messages
     * of the calling method and logs it if they are equal. Name of calling
     * method is included in message automatically.
     */
    public void assertEqualsAndContinue( String message, boolean expected, boolean actual ) {

        assertEqualsAndContinue( message, new Boolean( expected ), new Boolean( actual ) );
    }

    /**
     * Asserts that two boolean are not equal. Appends message to the other
     * messages of the calling method and logs it if they are equal. Name of
     * calling method is included in message automatically.
     */
    public void assertNotEqualsAndContinue( String message, boolean expected, boolean actual ) {

        assertNotEqualsAndContinue( message, new Boolean( expected ), new Boolean( actual ) );
    }

    /**
     * Asserts that two objects do refer to the same object. Appends message to
     * the other messages of the calling method and logs it if they are equal.
     * Name of calling method is included in message automatically.
     */
    public void assertSameAndContinue( String message, Object expected, Object actual ) {

        if ( expected != actual ) {
            failAndContinue( "[assertSame]: " + message, actual, expected );
        }
    }

    /**
     * Asserts that two objects do not refer to the same object. Appends message
     * to the other messages of the calling method and logs it if they are
     * equal. Name of calling method is included in message automatically.
     */
    public void assertNotSameAndContinue( String message, Object expected, Object actual ) {

        if ( expected == actual ) {
            failAndContinue( "[assertNotSame]: " + message, actual, expected );
        }
    }

    /*
     * Increments the error count for current method and logs to MoinTestLogger.
     * @param message the message to be logged @param actual the Object to be
     * logged @param expected the Object to be logged
     */
    private void failAndContinue( String message, Object actual, Object expected ) {

        MoinAssertVerifyLog.incrErrorCount( );
        this.oneOrMoreVerfiesFailed = true;
        MoinTestLogger.printAssertAndContinue( getTestName( ), message + ":: is: " + actual + "; expected: " + expected );
    }

    /*
     * Implements a one-time-setup for a test method. Resets the error count for
     * current method. Logs a method header including the method name to the
     * MoinTestLogger. (non-Javadoc)
     * @see in Junit 3.8 , junit.framework.TestCase#beforeTestMethod()
     */
    @Before
    protected void beforeTestMethod( ) throws Exception {

        MoinAssertVerifyLog.errorCount = 0;
        this.oneOrMoreVerfiesFailed = false;
        MoinTestLogger.printTestMethodStart( getTestName( ) );
    }

    /*
     * Implements a one-time-tear-down for a test method. Sums up the error
     * count for current test class. Logs a method footer including the method
     * name to the MoinTestLogger. (non-Javadoc)
     * @see in Junit 3.8 , junit.framework.TestCase#afterTestMethod()
     */
    @After
    protected void afterTestMethod( ) throws Exception {

        MoinAssertVerifyLog.setTestClassErrorCount( MoinAssertVerifyLog.getTestClassErrorCount( ) + MoinAssertVerifyLog.errorCount );
        MoinTestLogger.printTestMethodFinish( getTestName( ), MoinAssertVerifyLog.errorCount, isErrors( ) );
        // tell it JUnit
        if ( this.oneOrMoreVerfiesFailed ) {
            StringBuilder msg = new StringBuilder( );
            msg.append( "Failure Trace: " + ( resultSet != null ? resultSet.getTrace( ) : "<unavailable>" ) );
            msg.append( "\nVerifiers: " + MoinTestLogger.getVerifies( ) );
            throw new AssertionFailedError( msg.toString( ) );
        }
        resultSet = null;
    }

    /**
     * Prints a sub test title to the log. Use it if you have subtests to
     * structure in a test method.
     * 
     * @param title the sub test title to log
     */
    public void subTestTitle( String title ) {

        MoinTestLogger.printSubTestTitle( title );
    }

    /**
     * Prints a newline to the log. Use it in combination with subTestTitle(),
     * when you have subtests to structure in a test method.
     */
    public void newLn( ) {

        MoinTestLogger.printInfo( );
    }

    /**
     * Prints a message to the log. Name of calling method is included in
     * message automatically.
     * 
     * @param message the message to log
     */
    public void info( String message ) {

        MoinTestLogger.printInfo( getTestName( ), message );
    }

    /**
     * Prints a message and a throwable to the log. Name of calling method is
     * included in message automatically.
     * 
     * @param message the message to log
     * @param t the throwable to log, including its stack trace
     */
    public void info( String message, Throwable t ) {

        MoinTestLogger.printInfo( getTestName( ), message, t );
    }

    /**
     * Prints a warning and to the log. Name of calling method is included in
     * message automatically.
     * 
     * @param message the message to log
     */
    public void warn( String message ) {

        MoinTestLogger.printWarning( getTestName( ), message );
    }

    /**
     * Prints a warning and a throwable to the log. Name of calling method is
     * included in message automatically.
     * 
     * @param message the message to log
     * @param t the throwable to log, including its stack trace
     */
    public void warn( String message, Throwable t ) {

        MoinTestLogger.printWarning( getTestName( ), message, t );
    }

    /**
     * Prints an error to the log. Name of calling method is included in message
     * automatically. Throws a runtime exception including the message and JUnit
     * will stop execution.
     * 
     * @param message the message to log
     */
    public void errorAndStop( String message ) {

        MoinAssertVerifyLog.incrErrorCount( );
        MoinTestLogger.printError( getTestName( ), message );
        throw new RuntimeException( "Error reported from: " + getTestName( ) + " message: " + message );
    }

    /**
     * Prints an error and a throwable to the log. Name of calling method is
     * included in message automatically. Throws a runtime exception including
     * the message and JUnit will stop execution.
     * 
     * @param message the message to log
     * @param t the throwable to log, including its stack trace
     */
    public void errorAndStop( String message, Throwable t ) {

        MoinAssertVerifyLog.incrErrorCount( );
        MoinTestLogger.printError( getTestName( ), message, t );
        throw new RuntimeException( "Error reported from: " + getTestName( ) + " message: " + message + ", error: " + t, t );
    }

    /**
     * Prints an error to the log. Name of calling method is included in message
     * automatically. Appends message to the other messages of the calling
     * method.
     * 
     * @param message the message to log
     */
    public void errorAndContinue( String message ) {

        MoinAssertVerifyLog.incrErrorCount( );
        this.oneOrMoreVerfiesFailed = true;
        MoinTestLogger.printErrorAndContinue( getTestName( ), message );
    }

    /**
     * Returns current number of errors occurred in test class.
     * 
     * @return the testClassErrorCount.
     */
    public static int getTestClassErrorCount( ) {

        return testClassErrorCount;
    }

    /**
     * Sets the number of errors occured in test class.
     * 
     * @param allTestsErrorCount the testClassErrorCount to set.
     */
    public static void setTestClassErrorCount( int allTestsErrorCount ) {

        MoinAssertVerifyLog.testClassErrorCount = allTestsErrorCount;
    }

    /**
     * Increments the number of errors per method.
     */
    public static void incrErrorCount( ) {

        MoinAssertVerifyLog.errorCount++;
    }

    private static String toString( Object[] array ) {

        if ( array == null ) {
            return null;
        } else {
            StringBuffer sb = new StringBuffer( array.length * 20 );
            sb.append( array.length ).append( "[" );
            for ( int i = 0; i < array.length; i++ ) {
                sb.append( array[i] );
                if ( i < array.length - 1 ) {
                    sb.append( "," );
                }
            }
            sb.append( "]" );

            return sb.toString( );
        }
    }

    private void printVerify( ) {

    }

    public void printEnd( ) {
        System.out.println( "End Test Run" );
    }

    private boolean isErrors( ) {

        resultSet = this.createResult( );
        if ( resultSet != null ) {
            return true;
        }
        return false;
    }

    private Failure createResult( ) {

        // TODO Auto-generated method stub
        return new MoinJunit4AdditionalListener( ).getFailures( );
    }

    public class MoinJunit4AdditionalListener extends Junit4AdditionalListener {

        @Override
        public String getName( ) {

            return super.testName;
        }

        @Override
        public Failure getFailures( ) {

            return super.testFailures;
        }
    }

}