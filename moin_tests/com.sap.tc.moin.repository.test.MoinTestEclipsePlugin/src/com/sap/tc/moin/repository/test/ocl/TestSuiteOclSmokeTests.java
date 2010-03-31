/*
 * Created on 08.02.2006
 */
package com.sap.tc.moin.repository.test.ocl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

/**
 * @author d046074 Testsuite for all OCL Tests. First the respective
 * Test-Metamodel is imported then the test are executed
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestBagEvaluation.class, TestBooleanEvaluation.class, TestMOFConstraints.class } )
public class TestSuiteOclSmokeTests {
}