/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.mi.textual.moinlookup.AbstractMoinLookupTest;
import com.sap.tc.moin.textual.moinadapter.adapter.AdapterJMIHelperTest;
import com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockTest;

@RunWith (Suite.class)
@SuiteClasses ( { 
    AdapterJMIHelperTest.class,
    AbstractMoinLookupTest.class,
    StructureTypeMockTest.class} )

public class MoinUnitTestSuite {

// empty class, no properties, no methods, nothing!!

}