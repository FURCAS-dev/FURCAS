package com.sap.tc.moin.repository.test.ocl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.ocl.ia.TestSuiteOclImpactAnalysisTests;
import com.sap.tc.moin.repository.test.ocl.integration.TestSuiteAllOclIntegrationTests;

/**
 * Suite for all OCL Tests
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestSuiteOCLParserTests.class, TestSuiteOclImpactAnalysisTests.class, TestSuiteAllOclIntegrationTests.class, TestSuiteOCLAttributeInitializer.class } )
public class TestSuiteAllOclTests {

}