package com.sap.tc.moin.js.query.service.client.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;


/**
 * Test Suite for executing MOIN Query Service client tests in Eclipse
 * 
 * @author d044522
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestQueryServiceClient.class, RemoteMqlProcessorFactoryApiTest.class, RepositoryHelperTest.class } )
public class QueryServiceClientTestSuite {

}
