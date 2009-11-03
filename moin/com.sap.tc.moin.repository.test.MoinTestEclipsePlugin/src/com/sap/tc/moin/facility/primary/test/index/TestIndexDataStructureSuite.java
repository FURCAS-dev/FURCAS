package com.sap.tc.moin.facility.primary.test.index;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestIndexBasicDataStructures.class, // comment for smarter formatting
    TestIndexHashSets.class } )
public class TestIndexDataStructureSuite {

}
