package com.sap.furcas.parsergenerator.tcs.featuretests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parser.tcs.TCSSyntaxDefinition;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.testutils.ResourceTestHelper;

/**
 * This class tests if the containment settings are set correctly in the TCS metamodel.
 * If set correctly, the transient parsing resource should only contain one element, namely the ConreteSyntax.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */
public class ContainmentTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "TCS";
    private static final File TCS = TCSSyntaxDefinition.TCS_TCS;
    private static final File[] METAMODELS = {};

    private static TCSSyntaxContainerBean syntaxBean;
    private static Resource resource;     // The transient parsing resource that contains all model elements.



    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS) {
            @Override
            public GrammarGenerationSourceConfiguration getSourceConfiguration() {
                return new GrammarGenerationSourceConfiguration(ResourceTestHelper.createResourceSet(),
                        ResourceTestHelper.createFURCASReferenceScope());
            }
        };
        syntaxBean = parseSyntax(testConfig);
    }

    @Ignore
    @Test
    public void testContainment() throws Exception {
        resource = syntaxBean.getSyntax().eResource();
        EList<EObject> list = resource.getContents();
        assertEquals("Resource contains more than the ConcreteSyntax", list.size(), 1);

    }
}
