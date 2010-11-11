package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.base.StubModelAdapter;
import com.sap.furcas.test.base.StubModelElement;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Currently fails because Enums are not implemented yet
 */
public class FPathGenerationTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "FPath";
    private static final File TCS = FixtureData.FPATH_TCS;
    private static final File[] METAMODELS = { FixtureData.FPATH1_METAMODEL, FixtureData.FPATH_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig, testConfig.getSyntaxDefinitionFile());
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {
        String sample = "myFunction(-$root,$a+$b)*.";

        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);

        // some asserts to make sure something reasonable has been parsed
        Set<StubModelElement> functions = stubModelHandler.getElementsbyType("FPath::FunctionCallExp");
        assertEquals(1, functions.size());
        StubModelElement function = functions.iterator().next();
        assertEquals("myFunction", function.get("name"));
        Set<StubModelElement> vars = stubModelHandler.getElementsbyType("FPath::VariableExp");
        assertEquals(3, vars.size());

    }

    @Test
    public void testSample2() throws Exception {
        String sample = "size($c/interface::*[required(.) and not(bound(.))]) > 0";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);

        // some asserts to make sure something reasonable has been parsed
        Set<StubModelElement> functions = stubModelHandler.getElementsbyType("FPath::FunctionCallExp");
        assertEquals(3, functions.size()); // functions: size, required, bound

        Set<StubModelElement> vars = stubModelHandler.getElementsbyType("FPath::VariableExp");
        assertEquals(1, vars.size());

        Set<StubModelElement> binOps = stubModelHandler.getElementsbyType("FPath::BinaryOperatorExp");
        assertEquals(2, binOps.size()); // and, >

    }

    @Test
    public void testSample3() throws Exception {
        String sample = "$itf/sibling::*/interface::*[provided(.)][subtype(., $itf)]";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);

        Set<StubModelElement> functions = stubModelHandler.getElementsbyType("FPath::Step");
        assertEquals(2, functions.size()); // functions: size, required, bound

    }

}
