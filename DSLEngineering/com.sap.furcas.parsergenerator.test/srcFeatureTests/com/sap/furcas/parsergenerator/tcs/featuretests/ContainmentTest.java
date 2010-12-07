package com.sap.furcas.parsergenerator.tcs.featuretests;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parser.tcs.TCSSyntaxDefinition;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.testutils.ScopeHelper;

public class ContainmentTest extends GeneratedParserBasedTest{
    
    private static final String LANGUAGE = "TCS";
    private static final File TCS = TCSSyntaxDefinition.TCS_TCS;
    private static final File[] METAMODELS = { }; 

    private static TCSSyntaxContainerBean syntaxBean;
    private static Resource resource;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS) {
            @Override
            public GrammarGenerationSourceConfiguration getSourceConfiguration() {
                return new GrammarGenerationSourceConfiguration(ScopeHelper.createResourceSet(), ScopeHelper.createFURCASReferenceScope());
            }
        };
        syntaxBean= parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
    }

    @Test
    public void testContainment() throws Exception {
        resource = syntaxBean.getSyntax().eResource();
      
    }

}
