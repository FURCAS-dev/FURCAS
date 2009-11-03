/*
 * Created on 24.08.2005
 */
package com.sap.tc.moin.repository.test.eclipse.plugin;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;

/**
 * Test Suite for executing all MOIN tests in Eclipse
 * 
 * @author d028486
 */
@RunWith( MoinSuite.class )
//@Suite.SuiteClasses( { PrimaryFacilityTestSuite.class, TestSuiteAllFacilityIndependentTests.class, TestMMLoadJmiClassFederation.class, TestMMDeployment.class } )
@Suite.SuiteClasses( { TestSuitePlugin.class } )
public class TestSuitePluginWithTrace {

    @BeforeClass
    static public void beforeClass( ) {

        MoinLoggerFactory.setAllLocationsToDebug( );

    }
}
