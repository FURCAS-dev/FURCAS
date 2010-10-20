/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.furcas.test.parsing.base.TestEcoreMetaModelLookup;
import com.sap.furcas.test.parsing.base.TestStubModelAdapter;
import com.sap.furcas.test.parsing.testutils.StringHelperTest;

@RunWith (Suite.class)
@SuiteClasses ( { 
    StringHelperTest.class,
    TestStubModelAdapter.class,
    TestEcoreMetaModelLookup.class} )

public class TestUtilsTestSuite {

// empty class, no properties, no methods, nothing!!

}