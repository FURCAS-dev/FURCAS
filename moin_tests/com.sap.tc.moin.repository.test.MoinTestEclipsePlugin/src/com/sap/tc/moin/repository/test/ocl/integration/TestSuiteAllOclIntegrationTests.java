package com.sap.tc.moin.repository.test.ocl.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.ocl.ia.TestRegression;

/**
 * @author d022737
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( {

MofConstraintRegistryTest.class, MetamodelConstraintRegistryTest.class, OclConstraintRegistryTest.class, FreestyleRegistryTestCompany.class, TestClassScopeAnalysisIntegration.class, ViolationMessageEvaluation.class, TestRegression.class } )
public class TestSuiteAllOclIntegrationTests {
    /**
     * @return the suite
     */
    /*
     * public static Test suite() { TestSuite tmpSuite = new
     * TestSuite(TestSuiteAllOclIntegrationTests.class.getName());
     * tmpSuite.addTestSuite(MofConstraintRegistryTest.class);
     * tmpSuite.addTestSuite(MetamodelConstraintRegistryTest.class);
     * tmpSuite.addTestSuite(OclConstraintRegistryTest.class);
     * tmpSuite.addTestSuite(TestClassScopeAnalysisIntegration.class); return
     * tmpSuite; }
     */
}
