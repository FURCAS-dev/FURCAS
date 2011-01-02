package com.sap.furcas.parser.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * Simple Test for the custom Expression language
 */
public class TestOCL extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "OCL";
    private static final File TCS = ScenarioFixtureData.OCL_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.OCL_METAMODEL };

    private static StubParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new StubParsingHelper(facade);
    }
    
    @Test
    @Ignore("Already broken in the moin codebase. Was not even included in the test suite.")
    public void testAcceptSample1() throws Exception {

        parsingHelper.parseString("self.vertices->forAll(p1, p2 |\r\n" + "(p1.x = p2.x and p1.y = p2.y) implies p1 = p2)", 0);
    }

    @Test
    @Ignore("Already broken in the moin codebase. Was not even included in the test suite.")
    public void testAcceptSample2() throws Exception {

        parsingHelper.parseString("let a : Integer = 1 in a + 1", 0);

        // syntax error leave out bits
        parsingHelper.parseString("let a  Integer = 1 in a + 1", 1);
        parsingHelper.parseString("let a : Integer = 1 in a  1", 1);
    }

    @Test
    @Ignore("Already broken in the moin codebase. Was not even included in the test suite.")
    public void testAcceptSample3() throws Exception {

        parsingHelper.parseString("Student.allInstances->forAll( p1, p2 | p1 <> p2 implies p1.name <> p2.name )", 0);

        // error cases
        parsingHelper.parseString("Student.allInstances->forAll( p1, p2 | p1 <> p2 imies p1.name <> p2.name )", 1);
        parsingHelper.parseString("Student.allInstances>forAll( p1, p2 | p1 <> p2 implies p1.name <> p2.name )", 2);
        parsingHelper.parseString("Student.allInstances->forAll p1, p2 | p1 <> p2 implies p1.name <> p2.name )", 2);
    }

    @Test
    @Ignore("Already broken in the moin codebase. Was not even included in the test suite.")
    public void testAcceptSample4() throws Exception {
        parsingHelper.parseString("MOF!Class.allInstances()->collect(e|e.name)", 0);
    }

    @Test
    @Ignore("Already broken in the moin codebase. Was not even included in the test suite.")
    public void testAcceptSample5() throws Exception {
        parsingHelper
                .parseString(
                        "MOF!Class.allInstances()->collect(e | e.name + \' extends \' + e.supertypes->iterate(e; acc : String = \'\' | acc + if acc = \'\' then \'\' else \' and \' endif + e.name))",
                        0);
    }

}
