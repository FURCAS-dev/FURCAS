/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.mi.textual.test.util.StringHelperTest;
import com.sap.mi.textual.test.util.StubModelTest;
import com.sap.mi.textual.test.util.TestEcoreLookup;

@RunWith (Suite.class)
@SuiteClasses ( { 
    StringHelperTest.class,
    StubModelTest.class,
    TestEcoreLookup.class} )

public class TestUtilsTestSuite {

// empty class, no properties, no methods, nothing!!

}