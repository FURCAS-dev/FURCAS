package com.sap.tc.moin.repository.test.commands;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestCommandStack.class, TestCommandExecution.class, TestExceptionHandling.class, TestJMIWrapping.class, TestCommandIntegration.class, TestCommandIllegalOperations.class } )
public class TestSuiteAllCommandsTests {

}
