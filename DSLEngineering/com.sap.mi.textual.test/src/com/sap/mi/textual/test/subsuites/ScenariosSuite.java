/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.mi.textual.test.scenarios.ATLTest;
import com.sap.mi.textual.test.scenarios.BibTextForcedLowerTest;
import com.sap.mi.textual.test.scenarios.BibTextGenerationTest;
import com.sap.mi.textual.test.scenarios.BibTextLowerUpperBoundsTest;
import com.sap.mi.textual.test.scenarios.BibTextModesTest;
import com.sap.mi.textual.test.scenarios.BibTextReferSubTypeTest;
import com.sap.mi.textual.test.scenarios.BibTextWithFunctionTest;
import com.sap.mi.textual.test.scenarios.ConditionalExpressionTest;
import com.sap.mi.textual.test.scenarios.DisambiguateTest;
import com.sap.mi.textual.test.scenarios.EnumTest;
import com.sap.mi.textual.test.scenarios.ExpressionAbstractTest;
import com.sap.mi.textual.test.scenarios.ExpressionBugTest;
import com.sap.mi.textual.test.scenarios.ExpressionNoLexerTest;
import com.sap.mi.textual.test.scenarios.ExpressionTest;
import com.sap.mi.textual.test.scenarios.FPathGenerationTest;
import com.sap.mi.textual.test.scenarios.GrammarTest;
import com.sap.mi.textual.test.scenarios.KM3Test;
import com.sap.mi.textual.test.scenarios.KmeliaTest;
import com.sap.mi.textual.test.scenarios.LexerMemberTest;
import com.sap.mi.textual.test.scenarios.MultiPackageTest;
import com.sap.mi.textual.test.scenarios.PeopleTest;
import com.sap.mi.textual.test.scenarios.ProblemTest;
import com.sap.mi.textual.test.scenarios.SPLTest;
import com.sap.mi.textual.test.scenarios.SQLDDLTest;
import com.sap.mi.textual.test.scenarios.TCSMQLTest;
import com.sap.mi.textual.test.scenarios.TCSObsoleteTest;
import com.sap.mi.textual.test.scenarios.XPathGenerationTest;
import com.sap.mi.textual.test.scenarios.XPathRedGenerationTest;

@RunWith (Suite.class)
@SuiteClasses ( { 
    ATLTest.class,
    BibTextGenerationTest.class,
    BibTextForcedLowerTest.class,
    BibTextLowerUpperBoundsTest.class,
    BibTextModesTest.class,
    BibTextReferSubTypeTest.class,
    BibTextWithFunctionTest.class,
    ConditionalExpressionTest.class,
    EnumTest.class,
    ExpressionBugTest.class,
    ExpressionNoLexerTest.class,
    ExpressionTest.class,
    ExpressionAbstractTest.class,
    FPathGenerationTest.class,
    GrammarTest.class,
    KM3Test.class,
    KmeliaTest.class,
    LexerMemberTest.class,
    DisambiguateTest.class,
    MultiPackageTest.class,
    ProblemTest.class,
    PeopleTest.class,
    SPLTest.class,
    SQLDDLTest.class,
    TCSObsoleteTest.class,
    TCSMQLTest.class,
    XPathGenerationTest.class,
    XPathRedGenerationTest.class
    } )

public class ScenariosSuite {

// empty class, no properties, no methods, nothing!!

}