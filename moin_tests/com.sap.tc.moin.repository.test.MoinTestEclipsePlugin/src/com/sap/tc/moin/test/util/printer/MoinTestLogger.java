/*
 * Created on Feb 16, 2006 TODO To change the template for this generated file
 * go to Window - Preferences - Java - Code Style - Code Templates
 */
package com.sap.tc.moin.test.util.printer;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * @author D037271 TODO To change the template for this generated type comment
 * go to Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings( "nls" )
public class MoinTestLogger {

    private static StringBuffer verifyResults = new StringBuffer( );

    private static StringBuffer res = new StringBuffer( );

    private static String currMethod = "";

    private static MoinLogger logger;

    static {
        logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_TEST, MoinTestLogger.class );
        if ( logger != null ) {
            System.out.println( "MOIN Test Logger initialized" );
        }
    }

    public static void printVerify( String methodName, boolean verified, String message ) {

        if ( verified ) {
            System.out.println( "          >(verify) [" + methodName + "]: " + message );
            logger.trace( MoinSeverity.INFO, "          >(verify) " + message );
        } else {
            printRedLn( "Error in: >(verify) [" + methodName + "]: " + message );
            logger.trace( MoinSeverity.ERROR, "          >(verify) [" + methodName + "]: " + message );
            appendToAssertCause( methodName, message );
        }
    }

    public static void printAssertAndContinue( String methodName, String message ) {

        printRedLn( "Error in: >(assert) [" + methodName + "]: " + message );
        //location.errorT( "          >(assert) [" + methodName + "]: " + message );
        logger.trace( MoinSeverity.ERROR, "          >(assert) [" + methodName + "]: " + message );
        appendToAssertCause( methodName, message );
    }

    public static void printTestMethodStart( String testName ) {

        System.out.println( "--------> [" + testName + "]" );
        logger.trace( MoinSeverity.INFO, "--------> [" + testName + "]" );
    }

    public static void printTestMethodFinish( String testMethodName, int errors, boolean junitErrors ) {

        if ( ( errors == 0 ) && ( !junitErrors ) ) {
            System.out.println( "<-------- [" + testMethodName + "]: Passed.\n" );
            logger.trace( MoinSeverity.INFO, "<-------- [" + testMethodName + "]: Passed." );
        } else {
            logger.trace( MoinSeverity.ERROR, "<-------- [" + testMethodName + "]: Failed with " + errors + " error message (s)." );
            System.out.println( "<-------- [" + testMethodName + "]: Failed with " + errors + " error message (s).\n" );
        }
    }

    /**
     * Prints an indented sub test title. Should be used in test methods
     * containing sub tests only.
     * 
     * @param title the sub test tile to print
     */
    public static void printSubTestTitle( String title ) {

        System.out.println( "          >(title)  [---------- " + title + " ----------]" );
        logger.trace( MoinSeverity.INFO, "          >(title)  [---------- " + title + " ----------]" );
    }

    /**
     * Prints an indented warning message including name of the method.
     * 
     * @param testMethodName the name of the method.
     * @param message the message to print
     */
    public static void printWarning( String testMethodName, String message ) {

        logger.trace( MoinSeverity.WARNING, "Warn  in: " + ">(warn)   [" + testMethodName + "]: " + message );
        System.out.println( "Warn  in: " + ">(warn)   [" + testMethodName + "]: " + message );
    }

    /**
     * Prints an indented warning message including name of the method. Name of
     * the method is obtained.
     * 
     * @param message the message to be printed
     */
    public static void printWarning( String message ) {

        printWarning( getMethodName( ), message );
    }

    /**
     * Prints an indented warning message including name of the method and the
     * stacktrace of a throwable.
     * 
     * @param testMethodName the name of the method.
     * @param message the message to print
     * @param t the throwable with the stack trace
     */
    public static void printWarning( String testMethodName, String message, Throwable t ) {

        printWarning( testMethodName, message );
        printException( "Warn  in: " + ">(warn)  : " + getStackTrace( t ), false );
    }

    /**
     * Prints an indented warning message including name of the method and the
     * stacktrace of a throwable. Name of the method is obtained.
     * 
     * @param message the message to print
     * @param t the throwable with the stack trace
     */
    public static void printWarning( String message, Throwable t ) {

        printWarning( getMethodName( ), message, t );
    }

    public static void printInfo( ) {

        logger.trace( MoinSeverity.INFO, "          >(nl)" );
        //System.out.println( "          >(nl)" );
    }

    /**
     * Prints an indented info message including name of the method.
     * 
     * @param testMethodName the name of the method.
     * @param message the message to print
     */
    public static void printInfo( String testMethodName, String message ) {

        //System.out.println( "          >(info)   [" + testMethodName + "]: " + message );
        logger.trace( MoinSeverity.INFO, "          >(info)   [" + testMethodName + "]: " + message );
    }

    /**
     * Prints an indented info message including name of the method. Name of the
     * method is obtained.
     * 
     * @param message
     */
    public static void printInfo( String message ) {

        printInfo( getMethodName( ), message );
    }

    /**
     * Prints an indented info message including name of the method and the
     * stacktrace of a throwable.
     * 
     * @param testMethodName the name of the method.
     * @param message the message to print
     * @param t the throwable with the stack trace
     */
    public static void printInfo( String testMethodName, String message, Throwable t ) {

        printInfo( testMethodName, message );
        printException( "          >(info)  : " + getStackTrace( t ), false );
    }

    /**
     * Prints an indented info message including name of the method and the
     * stacktrace of a throwable. Name of the method is obtained.
     * 
     * @param message the message to print
     * @param t the throwable with the stack trace
     */
    public static void printInfo( String message, Throwable t ) {

        printInfo( getMethodName( ), message, t );
    }

    /**
     * Prints an indented error message including name of the method. To console
     * it is printed red.
     * 
     * @param testMethodName the name of the method.
     * @param message the message to print
     */
    public static void printError( String testMethodName, String message ) {

        logger.trace( MoinSeverity.ERROR, "Error in: " + ">(error)  [" + testMethodName + "]: " + message );
        printRedLn( "Error in: " + ">(error)  [" + testMethodName + "]: " + message );
        appendToAssertCause( testMethodName, message );
    }

    /**
     * Prints an indented error message including name of the method and the
     * stacktrace of a throwable. To console it is printed red.
     * 
     * @param testMethodName the name of the method.
     * @param message the message to print
     * @param t the throwable with the stack trace
     */
    public static void printError( String testMethodName, String message, Throwable t ) {

        printError( testMethodName, message );
        printException( "          >(error):  " + getStackTrace( t ), true );
        ;
    }

    /**
     * Prints an indented warning message including name of the method and the
     * stacktrace of a throwable. Name of the method is obtained in Printer. To
     * the console it is printed in red.
     * 
     * @param message the message to print
     * @param t the throwable with the stack trace
     */
    public static void printError( String message, Throwable t ) {

        printError( getMethodName( ), message );
        logger.trace( t, MoinSeverity.ERROR, "[" + getMethodName( ) + "]: " + message );
    }

    /**
     * Prints an indented warning message including name of the method. Name of
     * the method is obtained. To console it is printed red.
     * 
     * @param message the message to be printed
     */
    public static void printError( String message ) {

        printError( getMethodName( ), message, new RuntimeException( ).getCause( ) );
    }

    /**
     * Prints an indented error message including the name of the method. The
     * message is printed in red and is appended to the other reported messages
     * of the calling method.
     * 
     * @param methodName the name of the method
     * @param message the message to print
     */
    public static void printErrorAndContinue( String methodName, String message ) {

        printError( methodName, message );
    }

    /**
     * Returns the name of the current method.
     * 
     * @return the name of the current method.
     */
    public static String getMethodName( ) {

        try {
            java.io.StringWriter writer = new java.io.StringWriter( );
            java.io.PrintWriter w = new java.io.PrintWriter( writer );

            Exception e = new Exception( "StackTrace" );
            e.printStackTrace( w );

            String stack = writer.toString( );

            java.util.StringTokenizer toker = new java.util.StringTokenizer( stack );

            // java.lang.Exception: StackTrace
            String line = toker.nextToken( "\n" );
            // at java.lang.Throwable.<init>(Throwable.java:89)
            line = toker.nextToken( "\n" );
            // at java.lang.Exception.<init>(Exception.java:53)
            line = toker.nextToken( "\n" );
            // at Sample.getMethodName(Sample.java:20)
            line = toker.nextToken( "\n" );
            // this is the method that called us
            //          line = toker.nextToken("\n");

            // Line is now the name of the method that called this one.

            // Remove the "... at"
            int index = line.indexOf( " " );
            line = line.substring( index + " ".length( ) );

            // Remove the line info, JIT will mess it up anyway
            index = line.indexOf( "(" );
            line = line.substring( 0, index );

            // find out the method name
            index = line.lastIndexOf( "." );
            String method = line.substring( index + 1 );

            int index2 = line.lastIndexOf( '.', index - 1 );

            // Package name
            //String packageName = line.substring(0, index2);

            // Class name
            String clazz = line.substring( index2 + 1, index );

            // If we were really pathological, we could use the
            // java.lang.reflect API to determine the parameters of
            // the method. But then we would have to figure out which of
            // the many possible overridden versions of the method was
            // used and I am to lazy to do that.

            return clazz + "." + method;
        } catch ( Throwable e ) {
            return "";
        }
    }

    /**
     * @return Returns the verifyResults.
     */
    public static String getVerifies( ) {

        return MoinTestLogger.verifyResults.toString( );
    }

    /*
     * Appends message to the other reported messages of the method.
     * @param methodName
     * @param message
     */
    private static void appendToAssertCause( String methodName, String message ) {

        if ( MoinTestLogger.currMethod.equals( "" ) ) {
            MoinTestLogger.currMethod = methodName;
        }
        if ( MoinTestLogger.currMethod.equals( methodName ) ) {
            appendVerify( "[" + methodName + "]: " + message );
        } else {
            MoinTestLogger.currMethod = methodName;
            resetVerifies( );
            appendVerify( "[" + methodName + "]: " + message );
        }
    }

    /*
     * Appends message to verifyResults.
     * @param message
     */
    private static void appendVerify( String message ) {

        if ( message.equals( "" ) ) {
            MoinTestLogger.verifyResults.append( "<empty message>" );
        } else {
            MoinTestLogger.verifyResults.append( message );
        }
        MoinTestLogger.verifyResults.append( '\n' );
    }

    /**
     * 
     */
    private static void resetVerifies( ) {

        MoinTestLogger.verifyResults = new StringBuffer( );
    }

    /*
     * Prints a trace in red if true. @param trace @param isError
     */
    private static void printException( String trace, boolean isError ) {

        if ( isError ) {
            printRedLn( trace );
            logger.trace( MoinSeverity.ERROR, trace );
        } else {
            System.out.println( trace );
            logger.trace( MoinSeverity.WARNING, trace );
        }
    }

    /**
     * Extracts the stacktrace from the given <tt>throwable</tt> and returns it
     * as a string.
     */
    private static String getStackTrace( Throwable throwable ) {

        StringWriter stringWriter = new StringWriter( );
        PrintWriter writer = new PrintWriter( stringWriter );
        throwable.printStackTrace( writer );

        return stringWriter.getBuffer( ).toString( );
    }

    private static void printRedLn( String fullmsg ) {

        // Looks weird, but ensures that error messages are in sync with the log
        // messages in the eclipse console.
        // Obviously eclipse doesn't forward the flush safely to the console.
        System.out.flush( );
        System.err.flush( );
        try {
            Thread.sleep( 10L );
        } catch ( InterruptedException e ) {
        }
        System.err.println( fullmsg );
        try {
            Thread.sleep( 10L );
        } catch ( InterruptedException e ) {
        }
        System.err.flush( );
    }
}