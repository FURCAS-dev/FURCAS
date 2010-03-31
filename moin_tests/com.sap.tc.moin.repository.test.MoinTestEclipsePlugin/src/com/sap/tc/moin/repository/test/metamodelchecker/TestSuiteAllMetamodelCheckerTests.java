package com.sap.tc.moin.repository.test.metamodelchecker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestMetaModelNameAnalyzer.class, TestMetamodelConstraintChecker.class } )
public class TestSuiteAllMetamodelCheckerTests {
}
