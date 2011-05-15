package com.sap.furcas.parser.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.util.QualifiedNamesHelper;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.StringListHelper;

/**
 * Tests generation of TCS Parsers. This is using an old obsolete implementation of TCS whithout direct links betweeen syntax
 * definition and Metamodel
 */
public class TestTCSObsolete extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "TCSObsolete";
    private static final File TCS = ScenarioFixtureData.TCS_OBSOLETE_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.TCS_METAMODEL };
    private static final String DSLSAMPLEDIR = "../com.sap.furcas.test/scenarioFixtures/";

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
        String sample = "syntax mySyntax {\n" + "  primitiveTemplate identifier for ->String default using NAME:\n"
                + "        value = \"%token%\";\n" + "  template ->ExpressionList main\n" + "    : ->elements{separator=\",\"}\n"
                + "    ;\n" + "    \n" + "}";

        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(2, stubModelHandler.getElementsOfType("TCS::Sequence").size());
    }

    @Test
    public void testSample2() throws Exception {
        // test for missing value after disambiguate results in one error after parsing.
        String sample = "syntax mySyntax {\n" + "  template ->errortemplate :" + " (disambiguate = )" + ";" + "}";

        parsingHelper.parseString(sample, 1);

    }

    @Test
    public void testBibTextTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parsingHelper.parseFile("Bibtext.tcs", DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(6, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(7, stubModelHandler.getElementsOfType("TCS::Sequence").size());
    }

    @Test
    public void testBibTextLowerTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parsingHelper.parseFile("BibtextForcedLower.tcs", DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(6, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(7, stubModelHandler.getElementsOfType("TCS::Sequence").size());
    }

    @Test
    public void testBibTextFunctionsTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parsingHelper.parseFile("BibtextWithFunction.tcs", DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(6, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(2, stubModelHandler.getElementsOfType("TCS::FunctionTemplate").size());
    }

    @Test
    public void testEnumTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parsingHelper.parseFile("EnumTest.tcs", DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(4, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(4, stubModelHandler.getElementsOfType("TCS::Sequence").size());
    }

    @Test
    public void testExpression() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parsingHelper.parseFile("Expression.tcs", DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(6, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(2, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(12, stubModelHandler.getElementsOfType("TCS::Sequence").size());
    }

    @Test
    public void testFPath() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parsingHelper.parseFile("FPath.tcs", DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(10, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(3, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(13, stubModelHandler.getElementsOfType("TCS::Sequence").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::EnumerationTemplate").size());
    }

    @Test
    public void testTCS() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parsingHelper.parseFile("TCSObsolete.tcs", DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(69, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(5, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(171, stubModelHandler.getElementsOfType("TCS::Sequence").size());
    }

    @Test
    public void testXPath() throws Exception {
        StubModelAdapter stubModelHandler = getModifiedAdapterStub();
        parsingHelper.parseFile("XPath.tcs", DSLSAMPLEDIR, 0, stubModelHandler);
        assertEquals(28, stubModelHandler.getElementsOfType("TCS::ClassTemplate").size());
        assertEquals(4, stubModelHandler.getElementsOfType("TCS::PrimitiveTemplate").size());
        assertEquals(1, stubModelHandler.getElementsOfType("TCS::ConcreteSyntax").size());
        assertEquals(36, stubModelHandler.getElementsOfType("TCS::Sequence").size());
    }

    private static StubModelAdapter getModifiedAdapterStub() {
        return new StubModelAdapter() {
            @Override
            public Object createElement(List<String> typeName) {
                if (StringListHelper.list("TCS", "Symbol").equals(typeName)) {
                    // Literal extends symbol, but StubModelHandler is unable to deal with Subtypes.
                    return model.create("TCS::Literal");
                } else {
                    return model.create(QualifiedNamesHelper.getQualifiedString(typeName));
                }
            }
        };
    }

}
