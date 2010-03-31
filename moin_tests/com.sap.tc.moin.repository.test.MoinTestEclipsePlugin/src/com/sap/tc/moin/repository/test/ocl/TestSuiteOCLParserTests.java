/*
 * Created on 08.02.2006
 */
package com.sap.tc.moin.repository.test.ocl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

/**
 * OCL Parser tests
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( {
    TestAssociationEndCallEvaluation.class,
    TestAttributeCallEvaluation.class,
    TestBagEvaluation.class,
    TestBooleanEvaluation.class,
    TestCollectionLiteralEvaluation.class,
    TestFloatEvaluation.class,
    TestEnumerationLiteralEvaluation.class,
    NullAndInvalidEvaluationTest.class,
    TestIfThenElseEvaluation.class,
    TestIntegerEvaluation.class,
    TestLongEvaluation.class,
    TestIteratorEvaluation.class,
    TestLetEvaluation.class,
    TestOclVoidEvaluation.class,
    TestOperationCallEvaluation.class,
    TestOrderedSetEvaluation.class,
    TestDoubleEvaluation.class,
    TestSequenceEvaluation.class,
    TestSetEvaluation.class,
    TestSpecialOpsEvaluation.class,
    TestStringEvaluation.class,
    TestTupleLiteralEvaluation.class,
    TestReparseExpression.class,
    TestEnvironment.class,
    TestMOFConstraints.class } )
public class TestSuiteOCLParserTests {
    /**
     * The MOF Constraint and Environment tests.
     * 
     * @return the test suite
     */
    /*
     * public static Test suite() { TestSuite tmpSuite = new
     * TestSuite(TestSuiteOCLParserTests.class.getName());
     * tmpSuite.addTestSuite(TestAssociationEndCallEvaluation.class);
     * tmpSuite.addTestSuite(TestAttributeCallEvaluation.class);
     * tmpSuite.addTestSuite(TestBagEvaluation.class);
     * tmpSuite.addTestSuite(TestBooleanEvaluation.class);
     * tmpSuite.addTestSuite(TestCollectionLiteralEvaluation.class);
     * tmpSuite.addTestSuite(TestEnumerationLiteralEvaluation.class);
     * tmpSuite.addTestSuite(TestIfThenElseEvaluation.class);
     * tmpSuite.addTestSuite(TestIntegerEvaluation.class);
     * tmpSuite.addTestSuite(TestIteratorEvaluation.class);
     * tmpSuite.addTestSuite(TestLetEvaluation.class);
     * tmpSuite.addTestSuite(TestOclVoidEvaluation.class);
     * tmpSuite.addTestSuite(TestOperationCallEvaluation.class);
     * tmpSuite.addTestSuite(TestOrderedSetEvaluation.class);
     * tmpSuite.addTestSuite(TestRealEvaluation.class);
     * tmpSuite.addTestSuite(TestSequenceEvaluation.class);
     * tmpSuite.addTestSuite(TestSetEvaluation.class);
     * tmpSuite.addTestSuite(TestSpecialOpsEvaluation.class);
     * tmpSuite.addTestSuite(TestStringEvaluation.class);
     * tmpSuite.addTestSuite(TestTupleLiteralEvaluation.class);
     * tmpSuite.addTestSuite(TestReparseExpression.class);
     * tmpSuite.addTestSuite(TestEnvironment.class);
     * tmpSuite.addTestSuite(TestMOFConstraints.class); return tmpSuite; }
     */
}