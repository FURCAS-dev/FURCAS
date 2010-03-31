/*
 * Created on 24.08.2005
 */
package com.sap.tc.moin.repository.test.eclipse.plugin;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.facility.primary.test.PrimaryFacilityTestSuite;
import com.sap.tc.moin.friends.test.MoinFriendsTestSuite;
import com.sap.tc.moin.primary.facility.test.ide.IdePrimaryFacilityTestSuite;
import com.sap.tc.moin.repository.runtimehost.test.build.TestInBuildEnvironment;
import com.sap.tc.moin.repository.runtimehost.test.ide.TestMMDeployment;
import com.sap.tc.moin.repository.runtimehost.test.ide.TestMMLoadJmiClassFederation;
import com.sap.tc.moin.repository.test.TestSuiteAllFacilityIndependentTests;
import com.sap.tc.moin.repository.test.ocl.integration.OclEditorHelperTest;
import com.sap.tc.moin.repository.test.ocl.integration.OclEditorIntegrationTest;
import com.sap.tc.moin.xm.test.XmTestSuite;

/**
 * Test Suite for executing all MOIN tests in Eclipse
 * 
 * @author d028486
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { PrimaryFacilityTestSuite.class, IdePrimaryFacilityTestSuite.class, TestSuiteAllFacilityIndependentTests.class, TestMMLoadJmiClassFederation.class, TestMMDeployment.class, OclEditorIntegrationTest.class, OclEditorHelperTest.class, MoinFriendsTestSuite.class, TestInBuildEnvironment.class, XmTestSuite.class } )
public class TestSuitePlugin {

    @BeforeClass
    static public void beforeClass( ) {

        //MoinIdeTestHelper.setTestConfigurationFile( "eclipseRuntimeTestConfiguration" );
//        MoinIdeTestHelper.getInstance( ).setAutoBuilding( false );
    }
}
