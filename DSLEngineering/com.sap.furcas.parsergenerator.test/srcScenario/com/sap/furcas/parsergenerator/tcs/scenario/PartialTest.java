package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.runtime.common.exceptions.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.test.scenario.FixtureData;

@Ignore("Already ignored in the moin codebase. Furthermore, not even included in the test suite.")
public class PartialTest extends ExtendedGeneratedParserBasedTest {

    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
    private static final String LANGUAGE = "XPath";

    @Before
    public void testXPathGenerationOnly() throws GrammarGenerationException, FileNotFoundException, ModelAdapterException,
            IOException {
        setLookup(new FileBasedEcoreMetaModelLookUp(FixtureData.XPATH1_METAMODEL));
        setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
        generateParserForLanguage(LANGUAGE);
    }

    @Test
    public void testSample1() throws Exception {
        StubModelAdapter stubModelHandler = parseFile("XPathSample01.sam", LANGUAGE, DSLSAMPLEDIR);
        stubModelHandler = parseFile("XPathSample02.sam", LANGUAGE, DSLSAMPLEDIR, 0);
    }

}
