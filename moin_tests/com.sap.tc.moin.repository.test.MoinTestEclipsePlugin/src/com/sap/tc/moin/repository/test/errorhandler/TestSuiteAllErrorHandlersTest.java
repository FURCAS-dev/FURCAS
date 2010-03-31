package com.sap.tc.moin.repository.test.errorhandler;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestLoadAndSave.class, TestTextErrorHandlerTV.class, TestTextErrorHandlerGLX.class, TestTextErrorHandlerMC.class } )
public class TestSuiteAllErrorHandlersTest {
}
