package com.sap.furcas.parser.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.StringListHelper;

/**
 * Simple Test for the SPL language, especially the word patterns
 */
@Ignore("Already ignored in the moin codebase")
public class TestSPL extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "SPL";
    private static final File TCS = ScenarioFixtureData.SPL_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.SPL_METAMODEL };
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    /**
     * test syntax errors cause parsing errors
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testSample02Direct() throws Exception {

        StubModelAdapter stubModelHandler = getSPLStubAdapter();

        parsingHelper.parseFile("SPLSample02.sam", DSLSAMPLEDIR, 0, stubModelHandler);

    }

    /**
     * test syntax errors cause parsing errors
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testSample01Direct() throws Exception {

        StubModelAdapter stubModelHandler = getSPLStubAdapter();

        parsingHelper.parseFile("SPLSample01.sam", DSLSAMPLEDIR, 0, stubModelHandler);

    }

    /**
     * @return
     */
    private StubModelAdapter getSPLStubAdapter() {
        StubModelAdapter stubModelHandler = new StubModelAdapter();
        // help stub along with supertypes
        stubModelHandler.supertypes.put("SPL::Argument", StringListHelper.list("SPL::VariableDeclaration", "SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::WhenHeader", StringListHelper.list("SPL::VariableDeclaration", "SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::Iterator", StringListHelper.list("SPL::VariableDeclaration", "SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::VariableDeclaration", StringListHelper.list("SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::StructureDeclaration", StringListHelper.list("SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::FunctionDeclaration", StringListHelper.list("SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::LocalFunctionDeclaration",
                StringListHelper.list("SPL::FunctionDeclaration", "SPL::Declaration"));
        stubModelHandler.supertypes.put("SPL::RemoteFunctionDeclaration",
                StringListHelper.list("SPL::FunctionDeclaration", "SPL::Declaration"));
        return stubModelHandler;
    }
}
