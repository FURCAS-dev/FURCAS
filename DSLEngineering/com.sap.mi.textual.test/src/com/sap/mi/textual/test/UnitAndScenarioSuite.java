/**
 * 
 */
package com.sap.mi.textual.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.mi.textual.test.subsuites.GrammarUnitTestSuite;
import com.sap.mi.textual.test.subsuites.InjectingSuite;
import com.sap.mi.textual.test.subsuites.MoinUnitTestSuite;
import com.sap.mi.textual.test.subsuites.OtherUnitTestSuite;
import com.sap.mi.textual.test.subsuites.ParsingSuite;
import com.sap.mi.textual.test.subsuites.ScenariosSuite;
import com.sap.mi.textual.test.subsuites.TCSSyntaxParsingSuite;
import com.sap.mi.textual.test.subsuites.TestUtilsTestSuite;

@RunWith (Suite.class)
@SuiteClasses ( { 
    GrammarUnitTestSuite.class,
    InjectingSuite.class,
    MoinUnitTestSuite.class,
    OtherUnitTestSuite.class,
    ParsingSuite.class,
    ScenariosSuite.class,
    TestUtilsTestSuite.class,
    TCSSyntaxParsingSuite.class
    } )

    /**
     * runs all tests that can run independent of Moin and NWDI
     */
public class UnitAndScenarioSuite {

// empty class, no properties, no methods, nothing!!

}