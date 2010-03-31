package com.sap.tc.moin.repository.test.eclipse.plugin;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.jmigenerator.standalone.TestGenerateMoinMetamodelsStandalone;

/**
 * Test Suite for executing all MOIN tests in Eclipse
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestGenerateMoinMetamodelsStandalone.class } )
public class TestSuiteGenerateMoinMetamodelsStandalone {

    @BeforeClass
    static public void beforeClass( ) {

        // this can be overridden with the system property
        // moin.test.configuration = "myconf" in the launch
        // configuration.
        //MoinIdeTestHelper.setTestConfigurationFile( "eclipseRuntimeTestConfiguration" );
    }
}
