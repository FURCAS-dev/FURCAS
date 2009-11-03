package com.sap.tc.moin.repository.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.core.TestSuiteCoreSmokeTests;
import com.sap.tc.moin.repository.test.graphicsfw.TestSuiteAllGfwTests;
import com.sap.tc.moin.repository.test.ocl.TestSuiteOclSmokeTests;
import com.sap.tc.moin.repository.test.query.TestSuiteSmokeQueryTests;

@RunWith( MoinSuite.class )
@SuiteClasses( { TestSuiteCoreSmokeTests.class, TestSuiteAllGfwTests.class, TestSuiteOclSmokeTests.class, TestSuiteSmokeQueryTests.class } )
public class TestSuiteFacilityIndependentSmokeTests {
}
