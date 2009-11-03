package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.XmiReader;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.JmiScript;
import com.sap.tc.moin.repository.test.jmitck.MetamodelLoader;
import com.sap.tc.moin.repository.test.jmitck.RepositoryLoader;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

/**
 * Script to execute JMI Semantic Tests. Provides an implementation of the
 * runScript method. This method identifies the test to execute, based on the
 * testType (a parameter of the TestDescription), creates an instance to run the
 * test, and executes it. It may be necessary for to load in a new metamodel
 * generate corresponding interfaces & implementation. It may be necessary to
 * request a new RefPackage extent. It may be necessary to compile test code
 * specific to generated interfaces.
 */
@SuppressWarnings( "nls" )
public class JmiModelSemanticsScript extends JmiScript {

    /*
     * NOTE: Some of this code was lifted from the provided JCK example,
     * JCKScript.java
     */

    private static final Object[] EMPTY_OBJ_ARRAY = new Object[] {};

    private static final Class<?>[] EMPTY_CLS_ARRAY = new Class[] {};

    private static final I18NResourceBundle i18n = I18NResourceBundle.getBundleForClass( JmiModelSemanticsScript.class );

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, JmiModelSemanticsScript.class );

    private static Properties testMap;

    private static Map<String, Method> methodMap = new HashMap<String, Method>( );

    private String prefix;

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
        List<RefPackage> refPackageList = setupIfNecessary( );
        Status result = runRuntimeTest( refPackageList, prefix );
        return result;
    }

    // identifies the test to execute, based on the testType, and
    // creates an instance to run the test, and executes it
    private Status runRuntimeTest( List<RefPackage> refPackageList, String prefix ) {

        PrintWriter trOut = getTestResult( ).getTestCommentWriter( );

        Class<?> tstClass = getTestClass( testType );
        SemModelTests runner = getTestInstance( tstClass, trOut, refPackageList, prefix, MetamodelLoader.getInstance( ).getVendorGenerator( ).createXmiReader( ) );
        Method tstMethod = getTestMethod( testType, tstClass );
        if ( tstMethod == null ) {
            throw new TestErrorException( i18n, "modelsem.noMethodForTest", testType );
        }
        try {
            return (Status) tstMethod.invoke( runner, EMPTY_OBJ_ARRAY );
        } catch ( IllegalAccessException iae ) {
            log.trace( iae, MoinSeverity.ERROR, "" );
            throw new TestErrorException( i18n, "modelsem.testMethodAccessError", tstMethod.getName( ) );
        } catch ( InvocationTargetException ite ) {
            Throwable th = ite.getTargetException( );
            log.trace( th, MoinSeverity.INFO, "" );
            if ( th instanceof TestErrorException ) {
                throw (TestErrorException) th;
            } else {
                throw new TestErrorException( i18n, "modelsem.testMethodException", new Object[] { tstMethod.getName( ), th.getClass( ).getName( ), th.getMessage( ) } );
            }
        }
    }

    // may cause a new metamodel to be loaded, and corresponding
    // interfaces & implementation generated.
    private List<RefPackage> setupIfNecessary( ) {

        List<RefPackage> refPkgList = new ArrayList<RefPackage>( );
        for ( Iterator<String> i = metamodelList.iterator( ); i.hasNext( ); ) {
            String metamodel = i.next( );
            prefix = Util.qualificationOf( metamodel );
            setClassLoader( MetamodelLoader.getInstance( ).loadIfNecessary( metamodel ) );
            String repId = td.getParameter( "repId" );
            if ( ( repId != null ) && !repId.equals( "" ) ) {
                refPkgList.add( RepositoryLoader.getInstance( ).getRep( repId, metamodel, prefix ) );
            }

        }
        return refPkgList;
    }

    private static void staticInit( ) {

        testMap = new java.util.Properties( );
        Class<?> cls = JmiModelSemanticsScript.class;
        InputStream in = null;
        try {
            in = cls.getResourceAsStream( "tests.properties" );
            if ( in == null ) {
                throw new TestErrorException( i18n, "modelsem.noTestProps", cls.getResource( "tests.properties" ) );
            }
            testMap.load( in );
        } catch ( IOException ioe ) {
            log.trace( ioe, MoinSeverity.ERROR, "" );
            throw new TestErrorException( i18n, "modelsem.testPropsNoRead" + cls.getResource( "tests.properties" ) );
        } finally {
            if ( in != null ) {
                try {
                    in.close( );
                } catch ( IOException e ) {
                    throw new TestErrorException( i18n, "modelsem.testPropsNoRead" + cls.getResource( "tests.properties" ) );
                }
            }
        }
    }

    private Class<?> getTestClass( String testType ) {

        String testMethod = testMap.getProperty( testType );
        if ( testMethod == null ) {
            log.trace( MoinSeverity.WARNING, "The testType property \"" + testType + "\" is not a key in the tests.properties resource; " + "test case cannot be executed" );
            throw new TestErrorException( i18n, "modelsem.unknownTestType", testType );
        }

        String trClass = Util.qualificationOf( testMethod );
        if ( trClass == null ) {
            throw new TestErrorException( i18n, "modelsem.badTestFormat", testMethod );
        }
        try {
            return Class.forName( trClass, true, getClassLoader( ) );
        } catch ( ClassNotFoundException cnfe ) {
            log.trace( cnfe, MoinSeverity.ERROR, "The JmiModelSemanticScript's classloader could not load " + "the specified test class, " + trClass );
            throw new TestErrorException( i18n, "modelsem.testPropNotClass", new Object[] { trClass, testType } );
        }
    }

    private SemModelTests getTestInstance( Class<?> trClass, PrintWriter trOut, List<RefPackage> refPackageList, String prefix, XmiReader reader ) {

        try {
            SemModelTests tr = (SemModelTests) trClass.newInstance( );
            tr.init( getClassLoader( ), td, trOut, refPackageList, prefix, reader );
            return tr;
        } catch ( InstantiationException ie ) {
            log.trace( ie, MoinSeverity.ERROR, "" );
            throw new TestErrorException( i18n, "modelsem.testInstantiateError", trClass.getName( ) );
        } catch ( IllegalAccessException iae ) {
            log.trace( iae, MoinSeverity.ERROR, "" );
            throw new TestErrorException( i18n, "maping.testClassAccessError", trClass.getName( ) );
        } catch ( ClassCastException cce ) {
            log.trace( cce, MoinSeverity.ERROR, "" );
            throw new TestErrorException( i18n, "modelsem.classNotModelTests", trClass.getName( ) );
        }
    }

    private static Method getTestMethod( String testType, Class<?> tstClass ) {

        Method answer = methodMap.get( testType );
        if ( answer == null ) {
            String fullMethodName = testMap.getProperty( testType );
            String methodName = Util.simpleNameOf( fullMethodName );
            try {
                answer = tstClass.getMethod( methodName, EMPTY_CLS_ARRAY );
            } catch ( NoSuchMethodException nsme ) {
                log.trace( nsme, MoinSeverity.ERROR, "Can't find method " + methodName + " in " + tstClass.getName( ) + " for " + testType + " registered as " + fullMethodName );
                throw new TestErrorException( i18n, "modelsem.unknownTestMethod", new Object[] { testType, methodName, tstClass.getName( ) } );
            }
            methodMap.put( testType, answer );
        }
        return answer;
    }

}
