package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the custom Expression language
 */
@Ignore("Already broken in the moin codebase. Was not even included in the test suite.")
public class OCLTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "OCL";
    private static final File TCS = FixtureData.OCL_TCS;
    private static final File[] METAMODELS = { FixtureData.OCL_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig);
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testAcceptSample1() throws Exception {

        parsingHelper.parseString("self.vertices->forAll(p1, p2 |\r\n" + "(p1.x = p2.x and p1.y = p2.y) implies p1 = p2)", 0);
    }

    @Test
    public void testAcceptSample2() throws Exception {

        parsingHelper.parseString("let a : Integer = 1 in a + 1", 0);

        // syntax error leave out bits
        parsingHelper.parseString("let a  Integer = 1 in a + 1", 1);
        parsingHelper.parseString("let a : Integer = 1 in a  1", 1);
    }

    @Test
    public void testAcceptSample3() throws Exception {

        parsingHelper.parseString("Student.allInstances->forAll( p1, p2 | p1 <> p2 implies p1.name <> p2.name )", 0);

        // error cases
        parsingHelper.parseString("Student.allInstances->forAll( p1, p2 | p1 <> p2 imies p1.name <> p2.name )", 1);
        parsingHelper.parseString("Student.allInstances>forAll( p1, p2 | p1 <> p2 implies p1.name <> p2.name )", 2);
        parsingHelper.parseString("Student.allInstances->forAll p1, p2 | p1 <> p2 implies p1.name <> p2.name )", 2);
    }

    @Test
    public void testAcceptSample4() throws Exception {

        parsingHelper.parseString("MOF!Class.allInstances()->collect(e|e.name)", 0);
    }

    @Test
    public void testAcceptSample5() throws Exception {

        parsingHelper
                .parseString(
                        "MOF!Class.allInstances()->collect(e | e.name + \' extends \' + e.supertypes->iterate(e; acc : String = \'\' | acc + if acc = \'\' then \'\' else \' and \' endif + e.name))",
                        0);
    }

}
