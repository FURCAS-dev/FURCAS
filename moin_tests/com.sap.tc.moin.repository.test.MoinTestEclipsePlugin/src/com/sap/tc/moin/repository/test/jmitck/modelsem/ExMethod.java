package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;

/**
 * Provides a definition of a method, and the methods to invoke it and examine
 * the results. The method is defined with java reflection. The definition
 * incudes an indication of the expected exception, if any
 */
@SuppressWarnings( "nls" )
public class ExMethod {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, ExMethod.class );

    private Method method;

    private Object target;

    private Object[] args;

    private String expectedException;

    private Status status;

    private PrintWriter messageStream;

    /**
     * Creates a new <code>ExMethod</code> instance.
     * 
     * @param m the <code>Method</code> to invoke
     * @param target the target object (never null, since a java class will
     * never be the target).
     * @param args the values for invocation (just like those required by
     * <code>java.lang.reflect.Method.invoke</code>
     * @param expectedException the expected exception resulting from
     * invocation, if any. Any subtype of the given exception will be a match.
     * For instance, java.lang.Throwable will match any exception thrown.
     * @param messageStream the Writer for writing script messages
     */
    public ExMethod( Method m, Object target, Object[] args, String expectedException, PrintWriter messageStream ) {

        this.method = m;
        this.target = target;
        this.args = ( args == null || args.length == 0 ) ? new Object[0] : args;
        this.expectedException = expectedException;
        this.messageStream = messageStream;
        if ( this.method == null ) {
            throw new TestErrorException( "Specified a null method" );
        }
        if ( this.target == null ) {
            throw new TestErrorException( "Specified a null target for method " + this.method.getName( ) );
        }

    }

    /**
     * Returns the status of executing the test. If the method has not been
     * invoked, <code>Status.NOT_RUN</code> is returned. The value
     * <code>Status.PASSED</code> or <code>Status.FAILED</code> is returned,
     * depending on whether the exception thrown (if any) matches the expected
     * exception. The value <code>Status.ERROR</code> is returned if something
     * else goes wrong in attempting to invoke the test.
     * 
     * @return the resulting status from the invocation.
     */
    public Status getStatus( ) {

        if ( status == null ) {
            return new Status( Status.NOT_RUN, "" );
        } else {
            return status;
        }
    }

    /**
     * Executes the method defined by this object.
     * 
     * @return the value returned by invoking the method. Null is returned if
     * the method has a void return type or if an exception is thrown.
     */
    public Object executeMethod( ) {

        Object result = null;
        messageStream.println( "Executing method " + method.getName( ) + " on an instance of " + target.getClass( ).getName( ) + " with " + args.length + " arguments" );
        for ( int i = 0; i < args.length; i++ ) {
            messageStream.println( "  arg[" + i + "] => " + Util.asString( args[i] ) );
        }
        if ( expectedException != null ) {
            messageStream.println( "Expecting the method to throw exception " + expectedException );
        }
        try {
            result = method.invoke( target, args );
            if ( expectedException == null ) {
                status = Status.passed( "execution completed" );
            } else {
                status = Status.failed( "Expected exception " + expectedException + " not thrown" );
            }
        } catch ( Throwable th ) {
            if ( th instanceof InvocationTargetException ) {
                th = ( (InvocationTargetException) th ).getTargetException( );
            }

            messageStream.println( "Method " + method.getName( ) + " threw a " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) );
            if ( isExpected( th ) ) {
                status = Status.passed( "Exception " + th.getClass( ).getName( ) + " caught, as expected" );
            } else {
                log.trace( th, MoinSeverity.INFO, "" );
                status = Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " caught" );
            }
        }
        return result;
    }

    private boolean isExpected( Throwable th ) {

        if ( expectedException == null ) {
            return false;
        }
        try {
            Class<?> expected = Class.forName( expectedException );
            if ( expected.isAssignableFrom( th.getClass( ) ) ) {
                return true;
            } else {
                return false;
            }
        } catch ( ClassNotFoundException cnfe ) {
            log.trace( cnfe, MoinSeverity.INFO, "" );
            throw new TestErrorException( "Specified exception " + expectedException + " is not recognized" );
        }
    }

}
