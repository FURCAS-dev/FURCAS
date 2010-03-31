/**
 * 
 */
package com.sap.tc.moin.repository.test.jmitck;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.sap.junit.MoinParameterizedRunner;
import com.sap.junit.MoinParameterizedRunner.ParametersDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.Script;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestResult;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder.Fault;
import com.sap.tc.moin.repository.test.jmitck.mapping.JmiMappingTestScript;

/**
 * @author d045397 The JMI TCK tests provided by Sun shall ensure that the MOIN
 * implementation of JMI is compliant with the JMI specification This test
 * verifies that interfaces and classes generated conform to the the
 * metamodel-to-Java mapping specification For example it is tested - whether
 * certain classes or methods exist - whether a type is an interface or not - if
 * the inheritance hierarchy is conform - whether the right exceptions are
 * thrown and the correct types are returned There are 435 mapping tests in the
 * JMI TCK
 */

@RunWith( MoinParameterizedRunner.class )
public class TestJmiTckMapping {

    // name of property file containing the path to the testdescriptions
    static final String PROP_FILE_MAPPING = "mapping.properties"; //$NON-NLS-1$

    // creates am empty test environment for using a a parameter
    static TestEnvironment testEnv = new TestEnvironment( );

    // Variables for the test parameteriazation
    TestDescription td;

    boolean goodResult;

    /**
     * sets up the testcase; initializes MetamodelLoader and RepositoryLoader
     * 
     * @throws Exception
     */
    @Before
    public void setUp( ) throws Exception {

        // initializes metamodel loader
        MetamodelLoader.init( testEnv, new File( "" ) ); //$NON-NLS-1$
        RepositoryLoader.init( );
    }

    /**
     * resets MOIN after each test run
     * 
     * @throws Exception
     */
    @After
    public void tearDown( ) throws Exception {

    }

    /**
     * constructs a collection needed for the test parameterization
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Fault
     */
    @Parameters
    public static List<Object[]> returnTestDescriptions( ) throws FileNotFoundException, IOException, Fault {

        TestJmiTckUtil util = new TestJmiTckUtil( );
        try {
            Properties tdProps = util.loadProperties( PROP_FILE_MAPPING );
            return util.findTestDescriptions( tdProps );
        } catch ( com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder.Fault e ) {
            e.printStackTrace( );
        }
        return null;
    }

    @ParametersDescription
    public static List<String> returnTestParametersDescriptions( ) throws FileNotFoundException, IOException, Fault {
        List<String> testTitles = new ArrayList<String>( );
        List<Object[]> tdArrayList = null;
        try {
            TestJmiTckUtil util = new TestJmiTckUtil( );
            tdArrayList = util.findTestDescriptions( util.loadProperties( PROP_FILE_MAPPING ) );
        } catch ( Fault e ) {
            e.printStackTrace( );
            return null;
        }
        for ( Object[] tdArray : tdArrayList ) {
            TestDescription td = (TestDescription) tdArray[0];
            testTitles.add( td.getTitle( ) );
        }
        return testTitles;
    }

    /**
     * constructor demanded from JUnit4; called before each single test run; td
     * and goodResult are the parameters fetched from the collection of
     * testDescriptions
     * 
     * @param td
     * @param goodResult
     */
    public TestJmiTckMapping( TestDescription td, boolean goodResult ) {

        this.td = td;
        this.goodResult = goodResult;
    }

    /**
     * initializes the test script, invokes the tests, prepares the error output
     * and asserts that the test is passed
     * 
     * @throws Fault
     */
    @Test
    public void testMapping( ) throws Fault {

        // instantiates a script, initializes and runs it
        Script script = new JmiMappingTestScript( );

        script.initTestDescription( td );
        script.initTestEnvironment( testEnv );

        String[] array = null;
        Status result = script.run( array, td, testEnv );

        TestResult testResult = script.getTestResult( );
        testResult.setStatus( result );
        String resultString = testResult.getResults( );
        assertEquals( resultString, goodResult, result.isPassed( ) );
    }

}
