package com.sap.tc.moin.facility.primary.test.index;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { //TestIndexJustForMe.class, // 
TestIndexInactiveSync.class, //
    TestIndexSynchronize.class,
    TestIndexInconsistencySuite.class, // comment for smarter formatting
    TestIndexQuery.class,
    TestIndexIQL.class,
    TestIndexIQLPartitionScope.class,
    TestIndexDump.class,
    TestIndexManagement.class,
    TestIndexDataStructureSuite.class,
    TestIndexGrowthAndShrink.class
// end of list
} )
public class TestIndexSuite {

}
