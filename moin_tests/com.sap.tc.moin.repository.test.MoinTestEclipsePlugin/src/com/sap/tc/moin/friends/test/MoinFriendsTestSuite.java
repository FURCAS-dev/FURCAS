package com.sap.tc.moin.friends.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.friends.test.connectionutil.ConnectionUtilTest;
import com.sap.tc.moin.friends.test.metamodelchecker.TestMetaModelNameCheckerFriendsApi;
import com.sap.tc.moin.friends.test.metamodelchecker.TestModelElementNameGeneratorFriendsApi;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( {
//
    TestMetaModelNameCheckerFriendsApi.class,
    TestModelElementNameGeneratorFriendsApi.class,
    ConnectionUtilTest.class,//
    SingletonTest.class } )
public class MoinFriendsTestSuite {

}
