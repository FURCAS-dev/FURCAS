/*
 * Created on 24.08.2005
 */
package com.sap.tc.moin.repository.test.eclipse.plugin;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.primary.facility.test.ide.TestFsExceptions;
import com.sap.tc.moin.primary.facility.test.ide.TestUpdatePersistenceEvents;
import com.sap.tc.moin.repository.runtimehost.test.ide.TestMMDeployment;
import com.sap.tc.moin.repository.runtimehost.test.ide.TestMMLoadJmiClassFederation;
import com.sap.tc.moin.repository.test.TestSuiteFacilityIndependentSmokeTests;

/**
 * Test Suite for executing all MOIN smoke tests in Eclipse. setUp() delegates
 * to parent class.
 * 
 * @author d047064
 */

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestFsExceptions.class, TestUpdatePersistenceEvents.class, TestSuiteFacilityIndependentSmokeTests.class, TestMMLoadJmiClassFederation.class, TestMMDeployment.class } )
public class TestSuitePluginSmokeTest extends TestSuitePlugin {

    @BeforeClass
    static public void beforeClass( ) {

        TestSuitePlugin.beforeClass( );
    }
}
