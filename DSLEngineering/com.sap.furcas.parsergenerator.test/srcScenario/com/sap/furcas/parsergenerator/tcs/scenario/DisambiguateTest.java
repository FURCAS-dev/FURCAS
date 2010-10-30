package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.EcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;

/**
 * Simple Test for the custom Disambiguate language
 */
@Ignore("Already broken in the moin codebase")
public class DisambiguateTest extends ExtendedGeneratedParserBasedTest {

    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
    private static final String LANGUAGE = "Disambiguate";

    @BeforeClass
    public static void setupParser() throws Exception {
        setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
        setLookup(new EcoreMetaModelLookUp("Disambiguate.ecore"));
        generateParserForLanguage(LANGUAGE);
    }

    @Test
    public void testSample1() throws Exception {

        StubModelAdapter stubModelHandler = parseFile("DisambiguateSample.sam", LANGUAGE, DSLSAMPLEDIR, 0);

    }

}
