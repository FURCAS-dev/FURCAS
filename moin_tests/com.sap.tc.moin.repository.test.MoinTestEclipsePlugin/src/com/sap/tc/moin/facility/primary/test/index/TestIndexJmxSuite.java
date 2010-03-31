package com.sap.tc.moin.facility.primary.test.index;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

/**
 * Test suite for JMX tests of the index (have to be put into separated suite,
 * because JMX doesn't work yet on the server)
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestIndexJmxAdapter.class, TestIndexDumpedJmxAdapter.class
// end of list
} )
public class TestIndexJmxSuite {

}
