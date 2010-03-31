package com.sap.tc.moin.primary.facility.test.ide;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.facility.primary.inconsistency.TestVisibilityRulesConsistency;
import com.sap.tc.moin.primary.facility.test.ide.lfs.LogicalFileSystemTestSuite;
import com.sap.tc.moin.repository.cps.test.TestCustomParserSimple;
import com.sap.tc.moin.repository.errorhandler.test.TestErrorhandlerMQL;
import com.sap.tc.moin.repository.test.s2x.TestSuiteAllS2XTest;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { // comment for smarter formatting 
TestErrorhandlerMQL.class, // comment for smarter formatting 
    TestVisibilityRulesConsistency.class,
    TestFsExceptions.class,
    TestUpdatePersistenceEvents.class,
    TestCoreFacilityLocks.class,
    TestResourceIdentifierFactory.class,
    TestResourceManagement.class,
    TestDirtyPartitionEviction.class, // comment for smarter formatting,
    TestCrossPartitionAttributeLinks.class,
    TestFsPersistence.class,
    TestFsPersistenceJmxAdapter.class,
    LogicalFileSystemTestSuite.class,
    TestMetamodelImport.class,
    TestLoadPartitionForMerge.class,
    TestSuiteAllS2XTest.class,
    TestCustomParserSimple.class  } )
public class IdePrimaryFacilityTestSuite {

}
