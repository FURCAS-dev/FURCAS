package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the a custom language having a metamodel with several subpackages and classnames that are not unique (only
 * unique within package)
 */
public class MultiPackageTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "MultiPackage";
    private static final File TCS = FixtureData.MULTIPACKAGE_TCS;
    private static final File[] METAMODELS = { FixtureData.MULTIPACKAGE_METAMODEL };
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseFile("ExpressionSample01.sam", DSLSAMPLEDIR, 0);
        Set values = stubModelHandler.getElementsbyType("expression::rightPackage::ExpressionList");
        assertNotNull(values);
        assertEquals(1, values.size());

        values = stubModelHandler.getElementsbyType("expression::rightPackage::BinaryExpression");
        assertNotNull(values);
        assertEquals(6, values.size());

        values = stubModelHandler.getElementsbyType("expression::rightPackage::ValueExpression");
        assertNotNull(values);
        assertEquals(9, values.size());
    }

    @Test
    public void testSample2() throws Exception {

        parsingHelper.parseFile("ExpressionSample02.sam", DSLSAMPLEDIR, 1);

    }

    @Test
    public void testSampleDirect() throws Exception {

        parsingHelper.parseString("1+1+2", 0);

        parsingHelper.parseString("1+1+", 1);
        parsingHelper.parseString("1+1+a", 1);
        parsingHelper.parseString("1+1+b, 2+c", 2);

    }
}
