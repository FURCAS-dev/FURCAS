/*
 * Created on 08.02.2006
 */
package com.sap.tc.moin.repository.test.ocl.ia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

/**
 * @author d046074 Testsuite for all OCL Tests. First the respective
 * Test-Metamodel is imported then the test are executed
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestJmiCreator.class, TestClassScopeAnalysis.class, TestNavigationPaths.class, TestRevPathComputation.class, TestOperationCall.class } )
public class TestSuiteOclImpactAnalysisTests {

}