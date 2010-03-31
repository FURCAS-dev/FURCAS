package com.sap.tc.moin.repository.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.core.TestSuiteAllCoreTests;
import com.sap.tc.moin.repository.test.cps.TestSuiteCpsBase;
import com.sap.tc.moin.repository.test.graphicsfw.TestSuiteAllGfwTests;
import com.sap.tc.moin.repository.test.jmitck.TestSuiteAllJmiTckTests;
import com.sap.tc.moin.repository.test.logger.TestMoinLogger;
import com.sap.tc.moin.repository.test.ocl.TestSuiteAllOclTests;
import com.sap.tc.moin.repository.test.query.TestSuiteAllMQLQueryTests;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestSuiteAllCoreTests.class, TestSuiteAllGfwTests.class, TestSuiteAllOclTests.class, TestSuiteAllJmiTckTests.class, TestMoinLogger.class, TestSuiteAllMQLQueryTests.class, TestSuiteCpsBase.class } )
public class TestSuiteAllFacilityIndependentTests {
}
