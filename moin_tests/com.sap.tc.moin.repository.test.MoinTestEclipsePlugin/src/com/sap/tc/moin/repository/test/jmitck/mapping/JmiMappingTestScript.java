package com.sap.tc.moin.repository.test.jmitck.mapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.sap.tc.moin.repository.test.jmitck.JmiScript;
import com.sap.tc.moin.repository.test.jmitck.MetamodelLoader;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

/**
 * Script to execute JMI Mapping tests.
 */
@SuppressWarnings( "nls" )
public class JmiMappingTestScript extends JmiScript {

    /*
     * NOTE: Code was lifted from the provided JCK example, JCKScript.java
     */

    private static final Object[] EMPTY_OBJ_ARRAY = new Object[] {};

    private static final Class<?>[] EMPTY_CLS_ARRAY = new Class[] {};

    private static final I18NResourceBundle i18n = I18NResourceBundle.getBundleForClass( JmiMappingTestScript.class );

    private static Properties testMap;

    private static Map<String, Method> methodMap = new HashMap<String, Method>( );

    static {
        staticInit( );
    }

    /**
     * Run the script.
     * 
     * @param env The test environment giving the details of how to run the test
     * @return The result of running the script
     */
    @Override
    protected Status runScript( String[] args, TestDescription td, TestEnvironment env ) {

        // script setup already provided the arguments, and superclass has them
        // as member fields, so we can ignore the arguments here
        setupIfNecessary( );
        return runRuntimeTest( );
    }

    private Status runRuntimeTest( ) {

        PrintWriter trOut = getTestResult( ).getTestCommentWriter( );

        Class<?> tstClass = getTestClass( testType );
        MappingTests runner = getTestInstance( tstClass, trOut );
        Method tstMethod = getTestMethod( testType, tstClass );
        if ( tstMethod == null ) {
            throw new TestErrorException( i18n, "mapping.noMethodForTest", testType );
        }
        try {
            return (Status) tstMethod.invoke( runner, EMPTY_OBJ_ARRAY );
        } catch ( IllegalAccessException iae ) {
            throw new TestErrorException( i18n, "mapping.testMethodAccessError", tstMethod.getName( ) );
        } catch ( InvocationTargetException ite ) {
            Throwable th = ite.getTargetException( );
            th.printStackTrace( );
            if ( th instanceof TestErrorException ) {
                throw (TestErrorException) th;
            } else {
                throw new TestErrorException( i18n, "mapping.testMethodException", new Object[] { tstMethod.getName( ), th.getClass( ).getName( ), th.getMessage( ) } );
            }
        }
    }

    private Status setupIfNecessary( ) {

        StringBuffer sb = new StringBuffer( );
        for ( int i = 0; i < metamodelList.size( ); i++ ) {
            String metamodel = metamodelList.get( i );
            setClassLoader( MetamodelLoader.getInstance( ).loadIfNecessary( metamodel ) );
            if ( i > 0 ) {
                sb.append( ", " );
            }
            sb.append( metamodel );
        }

        return Status.passed( "Metamodel(s) " + sb + " code loaded" );
    }

    private static void staticInit( ) {

        testMap = new java.util.Properties( );
        Class<?> cls = JmiMappingTestScript.class;
        InputStream in = null;
        try {
            in = cls.getResourceAsStream( "tests.properties" );
            if ( in == null ) {
                throw new TestErrorException( i18n, "mapping.noTestProps", cls.getResource( "tests.properties" ) );
            }
            testMap.load( in );
        } catch ( IOException ioe ) {
            throw new TestErrorException( i18n, "mapping.testPropsNoRead" + cls.getResource( "tests.properties" ) );
        } finally {
            if ( in != null ) {
                try {
                    in.close( );
                } catch ( IOException e ) {
                    throw new TestErrorException( i18n, "mapping.testPropsNoRead" + cls.getResource( "tests.properties" ) );
                }
            }
        }
    }

    private Class<?> getTestClass( String testType ) {

        String testMethod = testMap.getProperty( testType );
        if ( testMethod == null ) {
            throw new TestErrorException( i18n, "mapping.unknownTestType", testType );
        }

        String trClass = Util.extractTypeName( testMethod );
        if ( trClass == null ) {
            throw new TestErrorException( i18n, "mapping.badTestFormat", testMethod );
        }
        try {
            return Class.forName( trClass, true, getClassLoader( ) );
        } catch ( ClassNotFoundException cnfe ) {
            throw new TestErrorException( i18n, "mapping.testPropNotClass", new Object[] { trClass, testType } );
        }
    }

    private MappingTests getTestInstance( Class<?> trClass, PrintWriter trOut ) {

        try {
            MappingTests tr = (MappingTests) trClass.newInstance( );
            tr.init( getClassLoader( ), td, trOut );
            return tr;
        } catch ( InstantiationException ie ) {
            ie.printStackTrace( );
            throw new TestErrorException( i18n, "mapping.testInstantiateError", trClass.getName( ) );
        } catch ( IllegalAccessException iae ) {
            iae.printStackTrace( );
            throw new TestErrorException( i18n, "maping.testClassAccessError", trClass.getName( ) );
        } catch ( ClassCastException cce ) {
            throw new TestErrorException( i18n, "mapping.classNotMappingTests", trClass.getName( ) );
        }
    }

    private static Method getTestMethod( String testType, Class<?> tstClass ) {

        Method answer = methodMap.get( testType );
        if ( answer == null ) {
            String fullMethodName = testMap.getProperty( testType );
            String methodName = Util.extractMemberName( fullMethodName );
            try {
                answer = tstClass.getDeclaredMethod( methodName, EMPTY_CLS_ARRAY );
            } catch ( NoSuchMethodException nsme ) {
                System.err.println( "Cant find method " + methodName + " in " + tstClass.getName( ) + " for " + testType + " registered as " + fullMethodName );
                throw new TestErrorException( i18n, "mapping.unknownTestMethod", new Object[] { testType, methodName, tstClass.getName( ) } );
            }
            methodMap.put( testType, answer );
        }
        return answer;
    }
}
