package com.sap.tc.moin.facility.primary.test.index;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestIndexInconsistencyAddLink.class, TestIndexInconsistencyRemoveElement.class, TestIndexInconsistencyReassignElement.class, TestIndexInconsistencyMisc.class } )
public class TestIndexInconsistencySuite {

}
