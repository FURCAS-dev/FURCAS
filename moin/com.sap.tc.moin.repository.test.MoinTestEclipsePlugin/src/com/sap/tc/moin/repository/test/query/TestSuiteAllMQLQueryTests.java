package com.sap.tc.moin.repository.test.query;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestSuiteSyntheticWithNoSchedulingQueryTests.class, // formatting
    TestSuiteSyntheticInMemoryForCst.class,
    TestSuiteSyntheticWithSchedulingQueryTests.class,
    TestSuiteCompanyQueryTests.class,
    TestSuiteNegativeQueryTests.class,
    TestHasCrossPartitionLinks.class,
    TestQueryRegression.class } )
public class TestSuiteAllMQLQueryTests {

}
