package com.sap.furcas.parsergenerator.tcs.bootstrap;

import java.io.File;
import java.io.FileInputStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.parser.tcs.TCSSyntaxDefinition;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.testutils.ScopeHelper;

/**
 * This class runs a full bootstrap cycle, if started with the useBootstrappedTCSParser = true system property.
 * 
 * The bootstrapped parser is used to create a new TCSParser based on the same TCS.tcs that was used
 * to create the bootstrapped parser himself. The new TCSParser is then used to parse the TCS.tcs again.
 * 
 * If this test passes, then it is known that bootstrapped parser is capable of performing a full bootstrap
 * cycle. The old stable TCSParser can be replaced by the boostrapped one with confidence.
 * 
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public class TCSBootstrappingTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "TCS";
    private static final File TCS = TCSSyntaxDefinition.TCS_TCS;
    private static final File[] METAMODELS = { }; // keep empty. The FURCAS metamodel is added by the testConfig

    private static ParsingHelper parsingHelper;
    private static IModelAdapter modelAdapter;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS) {
            @Override
            public GrammarGenerationSourceConfiguration getSourceConfiguration() {
                return new GrammarGenerationSourceConfiguration(ScopeHelper.createResourceSet(), ScopeHelper.createFURCASReferenceScope());
            }
        };
        TCSSyntaxContainerBean syntaxBeanyntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBeanyntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
        modelAdapter = new DefaultTextAwareModelAdapter(new EMFModelAdapter(FURCASPackage.eINSTANCE, testConfig
                .getSourceConfiguration().getResourceSet(), testConfig.getSourceConfiguration().getReferenceScope()));
    }

    @Test
    public void testParseTCSTCSWithoutErrors() throws Exception {
        parsingHelper.parseStream(/* expected errors */ 0, new FileInputStream(TCS), modelAdapter);
    }

}
