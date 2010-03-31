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
import com.sap.tc.moin.repository.runtimehost.test.build.TestInBuildEnvironment;
import com.sap.tc.moin.repository.runtimehost.test.ide.TestMMDeployment;
import com.sap.tc.moin.repository.runtimehost.test.ide.TestMMLoadJmiClassFederation;
import com.sap.tc.moin.repository.test.TestSuiteAllFacilityIndependentTests;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * TestSuite to be used for the LKG process. Must not exceed 5 minutes runtime.
 * Try to keep required MMs stable since additional MMs increase runtime
 * 
 * @author d047064
 */

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { PrimaryFacilityTestSuite.class, TestSuiteAllFacilityIndependentTests.class, TestMMLoadJmiClassFederation.class, TestMMDeployment.class, MoinFriendsTestSuite.class, TestInBuildEnvironment.class } )
public class TestSuiteIdeLKG {
    @BeforeClass
    static public void beforeClass( ) {

        System.setProperty( MoinTestHelper.TEST_SCENARIO_KEY, MoinTestHelper.TEST_SCENARIO_IDE );
//        ((IdeRuntimeTestHelper) MoinTestCase.getTestHelper( )).setAutoBuilding( false );
    }
}
