package com.sap.tc.moin.repository.test.jmitck;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestJmiTckMapping.class, TestJmiTckModelsem.class } )
public class TestSuiteAllJmiTckTests {
}
