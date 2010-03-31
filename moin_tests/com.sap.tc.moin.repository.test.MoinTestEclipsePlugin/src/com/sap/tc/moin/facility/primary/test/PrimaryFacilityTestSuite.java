package com.sap.tc.moin.facility.primary.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.facility.primary.test.component.TestFacilityComponentsSuite;
import com.sap.tc.moin.facility.primary.test.index.TestIndexJmxSuite;
import com.sap.tc.moin.facility.primary.test.index.TestIndexSuite;
import com.sap.tc.moin.facility.primary.test.index.fs.TestIndexFsSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestIndexSuite.class, TestIndexJmxSuite.class, TestIndexFsSuite.class, TestFacilityComponentsSuite.class } )
public class PrimaryFacilityTestSuite {

}
