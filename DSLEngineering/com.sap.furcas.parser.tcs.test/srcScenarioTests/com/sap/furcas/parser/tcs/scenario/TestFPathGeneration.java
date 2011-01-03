package com.sap.furcas.parser.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelElement;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * Currently fails because Enums are not implemented yet
 */
public class TestFPathGeneration extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "FPath";
    private static final File TCS = ScenarioFixtureData.FPATH_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.FPATH1_METAMODEL, ScenarioFixtureData.FPATH_METAMODEL };

    private static StubParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new StubParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {
        String sample = "myFunction(-$root,$a+$b)*.";

        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);

        // some asserts to make sure something reasonable has been parsed
        Collection<StubModelElement> functions = stubModelHandler.getElementsOfType("FPath::FunctionCallExp");
        assertEquals(1, functions.size());
        StubModelElement function = functions.iterator().next();
        assertEquals("myFunction", function.get("name"));
        Collection<StubModelElement> vars = stubModelHandler.getElementsOfType("FPath::VariableExp");
        assertEquals(3, vars.size());

    }

    @Test
    public void testSample2() throws Exception {
        String sample = "size($c/interface::*[required(.) and not(bound(.))]) > 0";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);

        // some asserts to make sure something reasonable has been parsed
        Collection<StubModelElement> functions = stubModelHandler.getElementsOfType("FPath::FunctionCallExp");
        assertEquals(3, functions.size()); // functions: size, required, bound

        Collection<StubModelElement> vars = stubModelHandler.getElementsOfType("FPath::VariableExp");
        assertEquals(1, vars.size());

        Collection<StubModelElement> binOps = stubModelHandler.getElementsOfType("FPath::BinaryOperatorExp");
        assertEquals(2, binOps.size()); // and, >

    }

    @Test
    public void testSample3() throws Exception {
        String sample = "$itf/sibling::*/interface::*[provided(.)][subtype(., $itf)]";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);

        Collection<StubModelElement> functions = stubModelHandler.getElementsOfType("FPath::Step");
        assertEquals(2, functions.size()); // functions: size, required, bound

    }

}
